<template>
  <div class="container">
    <el-header style="height:35%">&nbsp;</el-header>
    <el-form ref="loginForm" :rules="loginRules" :model="form">
      <el-row :gutter="20" style>
        <el-col :span="8" :offset="8" style>
          <el-form-item class="text" prop="username">
            <el-input placeholder="请输入账号" v-model="form.username" style="width:80%"></el-input>
          </el-form-item>

          <el-form-item class="text">
            <el-input
              placeholder="请输入密码"
              v-model="form.password"
              show-password
              style="width:80%"
            ></el-input>
          </el-form-item>

          <el-form-item class="text">
            <el-input
              placeholder="验证码"
              v-model="form.authcode"
              show-password
              style="width:80%"
            ></el-input>
          </el-form-item>

          <el-button type="primary" style="width:80%" @click="login('loginForm')">登录</el-button>
        </el-col>
      </el-row>
    </el-form>
  </div>
</template> 
<script>
// 导入 axios
// import axios from 'axios'

import { login } from "../api/login";

export default {
  data() {
    return {
      form: { username: "", password: "" },
       // 表单验证
      loginRules: {
        username: [
          { required: true, message: "请输入用户名称", trigger: "blur" }
        ]
      }
    };
   
  },
  created() {
    this.getList();
  },
  methods: {
    login() {
      login(this.form).then(response => {
        if (response.data.code == "0000") {
          //令牌储存
          window.token = response.data.data;
          this.$router.push("/layout");
        } else {
          alert(response.data.message);
        }
      });
    },
    getList() {}
  }
};
</script>


<style lang="scss" >
.container {
  position: fixed;
  width: 100%;
  height: 100%;
  top: 0px; // 这里是设置与顶部的距离
  left: 0px; // 这里是设置与左边的距离
  background-image: url("https://lwep-1300175355.cos.ap-beijing.myqcloud.com/Sat%20Sep%2007%2008%3A45%3A06%20CST%202019.jpg");
}
.el-form-item__label {
  //border: 1px black solid;
  line-height: 40px;
  font-size: 20px;
  font-weight: 20px;
  text-align: center;
  color: black;
}
.el-button--primary {
  background-color: #4fc3f7;
  border-color: #4fc3f7;
}
</style>