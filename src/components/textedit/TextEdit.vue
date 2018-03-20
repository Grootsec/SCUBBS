<template>
  <div>
    <Input v-model="postcontent" type="textarea" :autosize="{minRows: 4}" placeholder="Enter something..."></Input>
    <Button type="primary" shape="circle" icon="at" @click="handleRender"></Button>
    <Button type="primary" shape="circle" icon="heart" @click="test"></Button>
  </div>
</template>

<script>
  import AddressSelect from "../AddressSelect/AddressSelect"

  export default {
    data() {
      return {
        postcontent: "",
        value: '',
        addresslist: [
          {
            value: 'new york',
            label: 'New York'
          },
          {
            value: 'Sydney',
            label: 'Sydney'
          },
          {
            value: 'Ottawa',
            label: 'Ottawa'
          },
          {
            value: 'Paris',
            label: 'Paris'
          },
          {
            value: 'Canberra',
            label: 'Canberra'
          }],
        address: ""
      }
    },
    methods: {
      handleRender() {
        this.$Modal.confirm({
          render: (h) => {
            return h('AddressSelect', {
              props: {
                address: this.value,
                addresslist: this.addresslist,
              },
              on: {
                ontest: (val) => {
                  this.value = val;
                  
                }
              }
            })
          }
        })
      },
      test() {
        console.log(this.value)
      }
    },
    components: {
      AddressSelect
    },
  }
</script>

<style scoped>
  button {
    position: relative;
    top: -18px;
    left: 10px;
  }
</style>


