<template>
  <div>
    <div class="layout">
      <Layout>
        <headers/>


        <Content :style="{padding: '0 50px'}">
          <Card>
            <div>
              <Row type="flex" justify="center" class="code-row-bg">
                <Col span="4">
                <label> 组织名称&nbsp;&nbsp;&nbsp;</label></Col>
                <Col span="4">
                <Input v-model="OrganizationName" placeholder="Enter something..." clearable
                       style="width: 200px"></Input></Col>
              </Row>
            </div>
            <Row type="flex" justify="center" class="code-row-bg">
              <Col span="4">
              <label> 组织描述</label></Col>
              <Col span="4">
              <Input v-model="description" placeholder="Enter something..." clearable
                     style="width: 200px"></Input></Col>
            </Row>
              <Row type="flex" justify="center" class="code-row-bg">
                <Col span="4">
              <Button type="success" size="large" style="width: 80%" v-on:click="submit">申请</Button>
                </Col>
              </Row>
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
        description:''
      }
    },
    methods: {
      submit() {
        // todo: 加入后台接口
        this.$http.post('/api/v1/createTeam', {
          name: this.OrganizationName,
          description: this.description
        }).then(function (res) {
          res =res.body;
          if (res.code==0){
            this.$Message.success({
              content: '申请成功',
              duration: 0.5,
              closable: true
            });
            // this.$router.push("/");
          }
          else {
            this.$Message.error({
              content: '未知错误',
              duration: 0.5,
              closable: true
            });
          }
        });

      }
    },
    components: {
      headers
    }
  }
</script>


<style scoped>
  label {
    text-align: center;
    font-size: 20px;
  }
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
