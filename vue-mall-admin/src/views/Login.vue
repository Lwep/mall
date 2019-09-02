<template>
  <div class="container">
    <el-header style="height:35%">&nbsp;</el-header>
    <el-main>
      <el-row :gutter="20" style="">
        
        <el-col :span="8" :offset="8" style="">
          <el-form ref="form" :model="loginForm" class="text">
            <el-form-item label="账户" >
              <el-input v-model="loginForm.account" style="width:80%"></el-input>
            </el-form-item>
          </el-form>
          <el-form ref="form" :model="loginForm" class="text">
            <el-form-item label="密码" >
              <el-input v-model="loginForm.password" show-password style="width:80%"></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" style="width:90%">登录</el-button>
            </el-form-item>
          </el-form>
        </el-col>
        
      </el-row>
    </el-main>
  </div>
</template>
<script>
export default {
   data() {
      return {
        loginForm:{
          account:"",
          password:"",
        },
      }
    },

 methods: {
    submitForm(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          alert("submit!");
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    }
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
  background-image: url("../assets/background_img.jpg");
};
.el-form-item__label{
  //border: 1px black solid;
  line-height: 40px;
  font-size:20px;
  font-weight: 20px;
  text-align: center;
  color: black;
};
.el-button--primary{
background-color:#4FC3F7;
border-color: #4FC3F7;
}
</style>