<template>
  <el-container>
    <el-header style="background-color:#B2EBF2 ">
      <el-container>
        <el-aside width="200px" >
          <h3>首页</h3>
          </el-aside>
        <el-main>
          <h3>MALL管理系统</h3>
        </el-main>
      </el-container>
    </el-header>
    <el-container>
      <el-aside width="200px" style="background-color:#A5D6A7">
        <Aside />
      </el-aside>
      <el-main style="background-color:#C5E1A5">
        <router-view/>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
// 导入组件
import Aside from "../layout/Aside";

export default {
  name: "layout",
  components: {
    Aside
  }
};
</script>

<style lang="scss" scoped>
.el-header{
  padding: 0;
}
.el-main{
  padding: 0;
}
</style>