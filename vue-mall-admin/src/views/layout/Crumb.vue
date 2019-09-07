<template>
  <div class="crumb">
    <el-row>
      <el-col :span="20">
        <h1>MALL后台管理</h1>
      </el-col>
      <el-col :span="4">
        <el-link type="primary" class="logout">退出登录</el-link>
      </el-col>
    </el-row>
  </div>
</template>
<script>
export default {};
</script>
<style lang='scss' scoped>
.logout{
    margin-top: 10px;
}
</style>