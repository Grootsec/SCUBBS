<template>
<div>
  <headers></headers>
  <shortMessage></shortMessage>
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
