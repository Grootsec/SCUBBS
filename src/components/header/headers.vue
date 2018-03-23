<template>
<div class="layout">
  <Layout>
    <Header :style="{position: 'fixed', width: '100%', zIndex: '9999'}">
      <Menu mode="horizontal" :theme="theme1" active-name="1">
        <div class="layout-nav">
          <MenuItem name="0">
          <v-link href="/SCUBBS">
            <h1>SCUBBS</h1>
          </v-link>
          </MenuItem>
          <MenuItem name="1">
          <v-link href="/">
            <Icon type="ios-paper"></Icon>青春广场
          </v-link>
          </MenuItem>
          <MenuItem name="2">
          <v-link href="/xbb">
            <Icon type="ios-people"></Icon>瞎BB
          </v-link>
          </MenuItem>
          <MenuItem name="3">
          <Icon type="heart"></Icon>表白墙
          </MenuItem>
          </span>
        </div>
        <div class="float-left">
          <MenuItem name="4">
          <!--<router-link to="/setting" style="color: rgba(255,255,255,.7);">-->
          <Badge dot>
            <Avatar :src="avatar" v-if="avatar" />
            <Avatar icon="person" v-else="avatar" />
          </Badge>
          <Dropdown>
            <a href="javascript:void(0)">
              <span v-if="nickname">{{$store.state.info.nickname}}</span>
            <span v-else="nickname">{{$store.state.info.name}}</span>
            <Icon type="arrow-down-b"></Icon>
            </a>
            <DropdownMenu slot="list">
              <router-link v-if="!show_login" to="/setting">
                <DropdownItem>设置</DropdownItem>
              </router-link>
              <router-link v-if="show_login" to="/login">
                <DropdownItem>login</DropdownItem>
              </router-link>
              <router-link v-else="show_login" to="/logout">
                <DropdownItem>logout</DropdownItem>
              </router-link>
            </DropdownMenu>
          </Dropdown>
          <!--</router-link>-->
          </MenuItem>
        </div>
      </Menu>
    </Header>
  </Layout>
</div>
</template>

<script>
<<<<<<< HEAD
import VLink from '../VLink.vue'

export default {
  data() {
    return {
      theme1: "dark",
      name: this.$store.state.info.name,
      nickname: this.$store.state.info.nickname,
      show_login: false
    };
  },
  computed: {
    avatar: function() {
      return this.$store.state.info.avatar;
    }
  },
  mounted() {
    if (document.cookie.indexOf("myStrCookie=") === -1) {
      this.show_login = true;
    } else {
      this.$http.get("/api/v1/fetchInfo")
        .then(function(res) {
          res = res.body;
          if (res.code == 0) {
            this.$store.commit("fetch", res);
          } else {
            this.show_login = true;
          }
        });
=======
  export default {
    data() {
      return {
        theme1: 'dark',
        name: this.$store.state.info.name,
        nickname: this.$store.state.info.nickname,
        show_login: false
      }
    },
    computed: {
      avatar: function () {
        return this.$store.state.info.avatar
      }
    },
    mounted() {
      if (document.cookie.indexOf("myStrCookie=") === -1) {
        this.show_login = true;
      } else {
        if (this.name === "登录"){
          this.$http.get("/api/v1/fetchInfo").then(function (res) {
            res = res.body;
            if (res.code == 0) {
              this.$store.commit("fetch", res);
            } else {
              this.show_login = true;
            }
          })
        }
      }
      if(this.$store.state.addressInfo.address.length === 0){
        this.$http.get("/api/v1/getAllNameAndNumber").then(function(res){
          res = res.body;
          this.$store.commit("fetchAddressInfo", res);
        })
      }
>>>>>>> 293413483290991cffc7eb3272f7f227b00d35f2
    }
  },
  components: {
    VLink
  }
};
</script>

<style media="screen">
.float-left {
  float: right;
}
</style>
