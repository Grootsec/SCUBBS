<template>
<div class="layout">
  <Layout>
    <Header :style="{position: 'fixed', width: '100%'}">
      <Menu mode="horizontal" :theme="theme1" active-name="1">
        <div class="layout-logo"></div>
        <MenuItem name="1">
        <router-link to="/">
          <Icon type="ios-paper"></Icon>青春广场
        </router-link>
        </MenuItem>
        <MenuItem name="2">
        <Icon type="ios-people"></Icon>瞎BB
        </MenuItem>
        <MenuItem name="3">
        <Icon type="heart"></Icon>表白墙
        </MenuItem>
        <span style="float: right;">
        <MenuItem name="4">
            <!--<router-link to="/setting" style="color: rgba(255,255,255,.7);">-->
            <Badge dot>
                <Avatar :src="avatar" v-if="avatar"/>
                <Avatar icon="person" v-else="avatar"/>
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
        </span>
      </Menu>
    </Header>
  </Layout>
</div>
</template>

<script>
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
    }
  }
};
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
</style>
