<template>
  <div>
    <div class="layout">
      <Layout>
        <headers/>


        <Content :style="{padding: '0 50px'}">
          <Card>
            <div>
              <label> 组织名称&nbsp;&nbsp;&nbsp;</label>
              <Input v-model="OrganizationName" placeholder="Enter something..." clearable style="width: 200px"></Input>
            </div>
            <div>
              <label> 负责人名字</label>
              <Input v-model="OrganizationHeadName" placeholder="Enter something..." clearable style="width: 200px"></Input>
            </div>
            <div>
              <label> 组织所属学院</label>
              <Input v-model="College" placeholder="Enter something..." clearable style="width: 200px"></Input>
            </div>
            <Button type="success"  v-on:click="submit">SUBMIT</Button>
          </Card>
        </Content>
        <Footer class="layout-footer-center">2018 &copy; <a href="http://grootsec.org">grootsec.org</a></Footer>
      </Layout>
    </div>
  </div>
</template>
<script>
  import headers from './header/headers'

  export default {
    data() {
      return {
        OrganizationName: '',
        OrganizationHeadName: '',
        College: '',
      }
    },
    methods: {
      submit() {
        // todo: 加入后台接口
        this.$http.post('/api/v1/xxxxx', {}).then(function () {

        })
      }
    },
    components: {
      headers
    }
  }
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
