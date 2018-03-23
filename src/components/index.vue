<template>
<div>
  <headers></headers>
  <div class="layout">
    <Layout>
      <Content :style="{margin: '88px 70px 0', minHeight: '500px'}">
        <shortMessage></shortMessage>
      </Content>
    </Layout>
  </div>
  <ifooter></ifooter>
</div>
</template>
<script>
import headers from './header/headers'
import ifooter from './footer/ifooter'
import shortMessage from './shortMessageContainer/shortMessage'
export default {
  data() {
    return {

    }
  },
  components: {
    headers,
    ifooter,
    shortMessage
  }
}
</script>

<style scoped>

</style>
