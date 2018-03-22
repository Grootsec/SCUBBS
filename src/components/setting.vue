<template>
  <div class="layout">
    <Header>
      <headers/>
    </Header>
    <BackTop></BackTop>
    <Layout>
      <Content :style="{padding: '0 50px'}">
        <Row style="height: 100px">
          <Col span="4">
          <Upload
            multiple
            type="drag"
            action="//jsonplaceholder.typicode.com/posts/">
            <div>
              <Avatar :src="avatar" size="large" v-if="avatar"></Avatar>
              <Avatar icon="person" size="large" v-else="avatar"></Avatar>
            </div>
          </Upload>
          </Col>
          <Col span="4" offset="2" style="vertical-align: middle;">
          <div style="vertical-align: middle">姓名: {{username}}</div>
          </Col>
          <Col span="4">
          <div>学院: {{college}}</div>
          </Col>
          <Col span="4">
          <div>专业: {{profession}}</div>
          </Col>
          <Col span="4">
          <div>性别: {{sex}}</div>
          </Col>
        </Row>
        <div class="border"></div>
        <Row>
            <label>设置nickname:</label>
            <input v-model="nickname">
            <lable>我的简介:</lable>
            <Input v-model="introduction" type="textarea" :autosize="{minRows: 2}" placeholder="Enter something..."/>
          <Button type="primary" @click="handleSubmit">保存修改</Button>
        </Row>
        <div class="border"></div>
        <Row>
          <h2>动态</h2>
          <timeline-bur>
            <timeline-item-bur :date="item.date" v-for="item of new_dynamic" :key="item.value" type="primary">
              <p>{{item.content}}</p>
            </timeline-item-bur>
          </timeline-bur>
        </Row>
        <div class="border"></div>
        <h2>我的组织 :测试</h2>
        <Row>
          <Col span="4">
          <route-link to="/">
            <Card>
              <p slot="title">The standard card</p>
              <p>Content of card</p>
            </Card>
          </route-link>
          </Col>
          <Col span="4" offset="2">
          <Card>
            <p slot="title">The standard card</p>
            <p>Content of card</p>
          </Card>
          </Col>
        </Row>
      </Content>
      <Footer class="layout-footer-center">2018 &copy; <a href="http://grootsec.org">grootsec.org</a></Footer>
    </Layout>
  </div>
</template>

<script>
  import headers from "./header/headers"

  export default {
    name: "setting",
    data() {
      return {
        username: this.$store.state.info.name,
        nickname: this.$store.state.info.nickname,
        college: this.$store.state.info.college,
        introduction: this.$store.state.info.introduction,
        profession: this.$store.state.info.profession,
        sex: this.$store.state.info.sex,
        new_message: [],
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
      // let responce = {"name":"孔旻昊", "nickname":"", "avatar":"https://i.loli.net/2017/08/21/599a521472424.jpg"};
      // this.$store.commit("login", responce);
    },
    methods: {
      getUserInfo() {
        this.new_message.push({"title": "测试", "content": "测试消息内容"})
        // this.$http.get('/api/v1/').then(function(){
        //
        // })
      },
      handleSubmit(){
        this.$http.post("/api/v1/updateObject",
          {
            // icon: this.avatar,
            id : this.$store.state.info.no,
            name: this.nickname,
            description: this.introduction,

          }).then(function(res){

        })
      }
    },
    computed:{
      avatar(){
        return this.$store.state.info.avatar;
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
