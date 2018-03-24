<template>
<div class="layout">
  <headers></headers>
  <BackTop></BackTop>
  <Layout>
    <Content :style="{margin: '88px 70px 0', minHeight: '500px'}">
      <Row :gutter="16">
        <Col span="6">
        <div>col-6</div>
        </Col>
        <Col span="6">
        <div>col-6</div>
        </Col>
        <Col span="6">
        <div>col-6</div>
        </Col>
        <Col span="6">
        <div>col-6</div>
        </Col>
      </Row>
      <Row>
        <h2>动态</h2>
        <timeline-bur>
          <timeline-item-bur :date="item.time" v-for="item of new_dynamic" :key="item.value" type="primary">
            <p>{{filterContent(item.content)}}</p>
          </timeline-item-bur>
        </timeline-bur>
      </Row>
    </Content>
  </Layout>
  <ifooter></ifooter>
</div>
</template>

<script>
import headers from "./header/headers"
import ifooter from './footer/ifooter'

export default {
  name: "person-info",
  data() {
    return {
      username: "",
      nickname: "",
      college: "",
      avatar: "",
      introduction: "",
      profession: "",
      grade: "",
      sex: "",
      new_message: [],
      new_secret_message: [],
      new_dynamic: [{
        "date": "2分钟前",
        "content": "@2015141463198 @2015141463077 测试数据丨a42bdcc1178e62b4694c830f028db5c0 bc7521e033abdd1e92222d733590f104 "
      }, {
        "date": "2分钟前",
        "content": "逼王真是强"
      }, {
        "date": "1996/1/2",
        "content": "逼王诞生于云南"
      }, {
        "date": "2分钟前",
        "content": "逼王真是强"
      }]
    }
  },
  components: {
    headers,
    ifooter
  },
  mounted() {
    this.getUserInfo();
  },
  methods: {
    getUserInfo() {
      let user_id = this.$route.params.id;
      this.$http.get('/api/v1/getuserinfo' + "?id=" + user_id)
        .then(function(res) {
          res = res.body;
          this.username = res.nickname;
          this.avatar = res.avatar;
          this.introduction = res.introduction;
          this.college = res.academy;
          this.sex = res.sex;
          this.grade = res.grade;
          this.profession = res.profession;
        });
      this.$http.get('/api/v1/getTeamInfo' + '?studentnumber=' + user_id)
        .then();
    },
    filterContent(info) {
      info = info.replace(/@(.*?) /g, ' ');
      info = info.replace(/丨.*/g, ' ');
      return info
    }
  }
}
</script>

<style scoped>
.border {
  border: 1px solid #e9eaec;
  height: 1px;
  transform: scaleY(.5);
}

.card {
  margin: auto;
  width: 40vw;
}

.ivu-card-head p,
.ivu-card-head-inner {
  height: auto;
}

.ivu-avatar {
  margin-right: 0.5rem;
}
</style>
