<template>
  <div class="layout">
    <Layout>
      <headers/>
      <Content :style="{padding: '0 50px'}">
      <Row style="height: 200px">
        <Col span="6">
        <div>姓名: {{username}}</div>
        </Col>
        <Col span="6">
        <div>学院: {{college}}</div>
        </Col>
      </Row>
      <div class="border"></div>
      <Row>
        <div>
          个人简介:
          {{introduction}}
        </div>
      </Row>
      <div class="border"></div>
      <Row>
        <h3>动态</h3>
      </Row>
      </Content>
      <Footer class="layout-footer-center">2018 &copy; <a href="http://grootsec.org">grootsec.org</a></Footer>
    </Layout>
  </div>
</template>

<script>
  import headers from "./header/headers"

  export default {
    name: "person-info",
    data() {
      return {
        username: this.$store.state.info.name,
        nickname: this.$store.state.info.nickname,
        college: this.$store.state.info.college,
        avatar: this.$store.state.info.avatar,
        introduction: this.$store.state.info.introduction,
        new_message: [],
        new_secret_message: []
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
