<template>
<div>
  <Icon type="at"></Icon>
  <Input v-model="postcontent" type="textarea" :rows="4" placeholder="Enter something..."></Input>
</div>
</template>

<script>
export default {
  data(){
    return {
      postcontent: "",
    }
  }
}
</script>

<style scoped>

</style>


