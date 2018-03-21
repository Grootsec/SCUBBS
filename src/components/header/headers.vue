<template>
  <div>
    <Menu mode="horizontal" :theme="theme1" active-name="1">
      <MenuItem name="1">
        <router-link to="/">
          <Icon type="ios-paper"></Icon>
          青春广场
        </router-link>
      </MenuItem>
      <MenuItem name="2">
        <Icon type="ios-people"></Icon>
        瞎BB
      </MenuItem>
      <MenuItem name="3">
        <Icon type="heart"></Icon>
        表白墙
      </MenuItem>
      <span style="float: right;">
        <MenuItem name="4">
            <router-link to="/setting" style="color: rgba(255,255,255,.7);">
            <Badge dot>
              <Avatar :src="avatar" v-if="avatar"/>
                <Avatar icon="person" v-else="avatar"/>
            </Badge>
              <span v-if="nickname">{{$store.state.info.nickname}}</span>
              <span v-else="nickname">{{$store.state.info.name}}</span>
            </router-link>
        </MenuItem>
        </span>
    </Menu>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        theme1: 'dark',
        name: this.$store.state.info.name,
        nickname: this.$store.state.info.nickname,
      }
    },
    computed: {
      avatar: function () {
        return this.$store.state.info.avatar
      }
    }
  }
</script>
