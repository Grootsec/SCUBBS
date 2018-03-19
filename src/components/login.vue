<template>
  <div class="dialog">
    <div class="loginPage">
      <h1>SCUBBS登录</h1>
      <el-form>
        <el-form-item label="学号">
          <el-input type="text" id="user" v-model="formName.user"></el-input>
        </el-form-item>
        <el-form-item label="密码">
          <el-input type="password" id="password" v-model="formName.password"></el-input>
        </el-form-item>
        <el-button type="primary" @click="submitForm()">提交</el-button>
        <el-button @click="resetForm">重置</el-button>
      </el-form>
    </div>
  </div>
</template>
<script>
  export default {
    name: '',
    data() {
      return {
        formName: {//表单中的参数
          user: '',
          userError: '',
          password: '',
          passwordError: '',
          beDisabled: true
        },
      }
    },
    methods: {
      submitForm(){
        this.$http.post('',{zjh: this.formName.user, mm: this.formName.password}).then(function(responce){
        // todo: $store 存储内容
        this.$store.commit("login", responce);
        })
      },
      checkForm(){

      },
      resetForm(){
        this.formName.user = '';
        this.formName.password=''
      }
    }
  }
</script>

<style scoped>
  html,body{
    margin: 0;
    padding: 0;
    position: relative;
  }
  .dialog{
    width: 100%;
    height: 100%;
    background: rgba(0,0,0,.8);
    text-align: center;
  }
  .loginPage{
    position: absolute;
    top: 50%;
    left: 50%;
    margin-top: -150px;
    margin-left: -175px;
    width: 350px;
    min-height: 300px;
    padding: 30px 20px 20px;
    border-radius: 8px;
    box-sizing: border-box;
    background-color: #fff;
  }
  .loginPage p{
    color: red;
    text-align: left;
  }
</style>
