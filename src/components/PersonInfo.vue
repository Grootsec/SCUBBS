<template>
  <div class="layout">
    <Layout>
      <headers/>
      <Row style="height: 200px">
        <Col span="6"><div>{{username}}</div></Col>
        <Col span="6"><div >test</div></Col>
        <Col span="6"></Col>
        <Col span="6"></Col>
      </Row>

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
        avatar: this.$store.state.info.avatar,
        new_message: [],
        new_secret_message : []
      }
    },
    components: {
      headers
    },
    mounted() {
      this.getUserInfo()
    },
    methods: {
      getUserInfo() {
        this.new_message.push({"title":"测试", "content": "测试消息内容"})
        // this.$http.get('/api/v1/').then(function(){
        //
        // })
      }
    }
  }
</script>

<style scoped>
  .layout{
    border: 1px solid #d7dde4;
    background: #f5f7f9;
    position: relative;
    border-radius: 4px;
    overflow: hidden;
  }
  .layout-logo{
    width: 100px;
    height: 30px;
    background: #5b6270;
    border-radius: 3px;
    float: left;
    position: relative;
    top: 15px;
    left: 20px;
  }
  .layout-nav{
    width: 420px;
    margin: 0 auto;
    margin-right: 20px;
  }
  .layout-footer-center{
    text-align: center;
  }
</style>
