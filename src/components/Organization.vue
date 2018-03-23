<template>
  <div class="layout">
    <Header>
      <headers/>
    </Header>
    <BackTop></BackTop>
    <Layout>
      <Avatar :src="avatar"></Avatar>
      <Content :style="{padding: '0 50px'}">
        <Row style="height: 200px">
          <Col span="6">
          <div>组织名称: {{username}}</div>
          </Col>
          <Col span="6">
          <div>组织人数: {{count}}</div>
          </Col>
        </Row>
        <div class="border"></div>
        <Row>
          <div>
            组织介绍
            {{introduction}}
          </div>
        </Row>
        <div class="border"></div>
        <Button type="primary" @click="apply">申请加入</Button>
      </Content>
      <Footer class="layout-footer-center">2018 &copy; <a href="http://grootsec.org">grootsec.org</a></Footer>
    </Layout>
  </div>
</template>

<script>
  import headers from "./header/headers"

  export default {
    name: "organization",
    data() {
      return {
        username: "",
        avatar: "",
        count: "",
        introduction: "",
        new_secret_message: [],
        new_dynamic: [{"date": "2分钟前", "content": "逼王真是强"}, {"date": "2分钟前", "content": "逼王真是强"}, {
          "date": "1996/1/2",
          "content": "逼王诞生于云南"
        }, {"date": "2分钟前", "content": "逼王真是强"}]
      }
    },
    components: {
      headers
    },
    mounted() {
      this.getUserInfo();
    },
    methods: {
      getUserInfo() {
        console.log(this.$route);
        let id = this.$route.params.id;
        this.$http.get('/api/v1/getTeamInfoByNumber' + "?id=" + id).then(function (res) {
          res = res.body;
          if (res.code == 0) {
            res = res.info;
            this.username = res.name;
            this.avatar = res.icon;
            this.introduction = res.description;

          }

        })
      },
      apply(){
        let id = this.$route.params.id;
        this.$http.post('/api/v1/applyTeam',{
          teamid: id
        }).then(function(res) {
          if (res.code == 0) {
            this.$Message.success({
              content: "申请成功",
              duration: 0.3,
              closable: true
            });
          }else{
            this.$Message.success({
              content: "您已经是该组织的成员了",
              duration: 0.8,
              closable: true
            });
          }
        })

      }
    }
  }
</script>

<style scoped>
  .layout {
    border: 1px solid #d7dde4;
    background: #f5f7f9;
    position: relative;
    border-radius: 4px;
    overflow: hidden;
  }

  .layout-logo {
    width: 100px;
    height: 30px;
    background: #5b6270;
    border-radius: 3px;
    float: left;
    position: relative;
    top: 15px;
    left: 20px;
  }

  .layout-nav {
    width: 420px;
    margin: 0 auto;
    margin-right: 20px;
  }

  .layout-footer-center {
    text-align: center;
  }

  .border {
    border: 1px solid #e9eaec;
    height: 1px;
    transform: scaleY(.5);
  }
</style>
