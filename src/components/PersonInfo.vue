<template>

    <div class="layout">
      <Header>
      <headers/>
      </Header>
      <BackTop></BackTop>
      <Layout>
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
            <h2>动态</h2>
            <timeline-bur>
              <timeline-item-bur :date="item.date" v-for="item of new_dynamic" :key="item.value" type="primary">
                <p>{{item.content}}</p>
              </timeline-item-bur>
            </timeline-bur>
          </Row>
          <div class="border"></div>
            <h2>ta的组织 :测试</h2>
          <Row>
            <Col span="4">
            <route-link to="">
            <Card>
              <p slot="title">The standard card</p>
              <p>Content of card</p>
              <p>Content of card</p>
              <p>Content of card</p>
            </Card>
            </route-link>
            </Col>
            <Col span="4" offset="2">
            <Card>
              <p slot="title">The standard card</p>
              <p>Content of card</p>
              <p>Content of card</p>
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
    name: "person-info",
    data() {
      return {
        username: "",
        nickname: "",
        college: "",
        avatar: "",
        introduction: "",
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

    },
    methods: {
      getUserInfo(){
        let user_id = this.$route.params.id;
        // todo fetch info
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
