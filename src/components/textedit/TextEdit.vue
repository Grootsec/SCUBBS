<template>
  <div>


    <Input v-model="postcontent" type="textarea" :autosize="{minRows: 4}" placeholder="Enter something..."></Input>
    <Button type="primary" style="    position: relative;
    top: -18px;
    left: 10px;" shape="circle" icon="at" v-on:click=""></Button>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        postcontent: "",
      }
    }
  }
</script>

<style scoped>

</style>


