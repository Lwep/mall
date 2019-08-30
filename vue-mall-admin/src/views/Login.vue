<template>
  <div class="container">
    <div>
      <el-row>
            <el-col :span="8">
                <div class="grid-content bg-purple-dark">&nbsp;</div>
            </el-col>
            <el-col :span="8">
                <div class="grid-content bg-purple-dark">
                    <h3>欢迎登录</h3>
                    <el-form ref="form" :model="form" label-width="80px">
                </div>
            </el-col>
            <el-col :span="8">
                <div class="grid-content bg-purple-dark">&nbsp;</div>
            </el-col>
           
      </el-row>
    </div>
  </div>
</template>
<script>
export default {};
</script>
<style lang="scss" scoped>
.grid-content {
  background-color: pi;
}

.container {
  margin: 0;
  padding: 0;
  height: 100%;
  width: 100%;
  position: fixed;
  background-image: url("../assets/background_img.jpg");
}
</style>