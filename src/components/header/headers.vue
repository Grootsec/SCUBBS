<template>
<div class="layout">
  <Layout>
    <Header :style="{position: 'fixed', width: '100%', zIndex: '9999'}">
      <Menu mode="horizontal" :theme="theme1" active-name="1">
        <div class="layout-nav">
          <MenuItem name="0">
          <router-link to="/SCUBBS" tag="span">
            <h1>SCUBBS</h1>
          </router-link>
          </MenuItem>
          <MenuItem name="1">
          <router-link to="/" tag="span">
            <Icon type="ios-paper"></Icon>青春广场
          </router-link>
          </MenuItem>
          <MenuItem name="2">
          <router-link to="/xbb" tag="span">
            <Icon type="ios-people"></Icon>瞎BB
          </router-link>
          </MenuItem>
          <MenuItem name="3">
          <router-link to="/bbq" tag="span">
            <Icon type="heart"></Icon>表白墙
          </router-link>
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
            <span>
            <span v-if="nickname">{{$store.state.info.nickname}}</span>
            <span v-else="nickname">{{$store.state.info.name}}</span>
            <Icon type="arrow-down-b"></Icon>
            </span>
            <DropdownMenu slot="list">
              <router-link v-if="!show_login" to="/setting" tag="span">
                <DropdownItem>设置</DropdownItem>
              </router-link>
              <router-link v-if="show_login" to="/login" tag="span">
                <DropdownItem>login</DropdownItem>
              </router-link>
              <router-link v-else="show_login" to="/logout" tag="span">
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
    avatar: function() {
      return this.$store.state.info.avatar
    }
  },
  mounted() {
    if (document.cookie.indexOf("myStrCookie=") === -1) {
      this.show_login = true;
    } else {
      if (this.name === "登录") {
        this.$http.get("/api/v1/fetchInfo")
          .then(function(res) {
            res = res.body;
            if (res.code == 0) {
              this.$store.commit("fetch", res);
            } else {
              this.show_login = true;
            }
          })
      }
    }
    if (this.$store.state.addressInfo.address.length === 0) {
      this.$http.get("/api/v1/getAllNameAndNumber")
        .then(function(res) {
          res = res.body;
          this.$store.commit("fetchAddressInfo", res);
        })
    }
  }
};
</script>

<style media="screen">
.float-left {
  float: right;
}
</style>
