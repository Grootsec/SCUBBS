<template>
  <div>
    <Input v-model="postcontent" type="textarea" :autosize="{minRows: 4}" placeholder="输入内容，点击下方的@按钮可@。"></Input>
    <Button type="primary" shape="circle" icon="at" class="button" @click="handleRender"></Button>
    <Button type="success" long @click="submit">SUBMIT</Button>
  </div>
</template>

<script>
  import AddressSelect from "../AddressSelect/AddressSelect"

  export default {
    data() {
      return {
        postcontent: "",
        hiddencontent: "",
        value: '',
        addresslist: [
          {
            value: 'newyork',
            label: 'NewYork'
          },
          {
            value: 'sydney',
            label: 'Sydney'
          },
          {
            value: 'ottawa',
            label: 'Ottawa'
          },
          {
            value: 'paris',
            label: 'Paris'
          },
          {
            value: 'canberra',
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
                  let name = "";
                  this.addresslist.forEach(function (item) {
                    if (item.value === val) {
                      name = item.label;
                    }
                  });
                  this.postcontent += "@" + name + " ";
                  this.hiddencontent += "@" + val + " ";
                }
              }
            })
          }
        })
      },
      submit(){
        console.log(this.submitcontent);
        // todo: 消息推上去

      }
    },
    components: {
      AddressSelect
    },
    computed: {
      submitcontent() {
        let content = this.postcontent;
        content = content.replace(/@(.*?) /g, "");
        return this.hiddencontent + content;
      }
    },
  }
</script>

<style scoped>
  .button {
    position: relative;
    top: -18px;
    left: 10px;
  }
</style>


