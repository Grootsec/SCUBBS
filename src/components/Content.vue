<template>
  <div>
        <Content :style="{padding: '0 50px'}">
            <div>消息......</div>
        </Content>
  </div>
</template>

<script>
  import headers from './header/headers'
  export default {
    name: "content",
    component:{
      headers
    }
  }
</script>

<style scoped>

</style>
