<template>
  <el-container>
    <el-header style="background-color:#80CBC4">Header</el-header>
    <el-container>
      <el-aside width="200px" style="background-color:#A5D6A7">
        <Aside />
      </el-aside>
      <el-main style="background-color:#C5E1A5">Main</el-main>
    </el-container>
  </el-container>
</template>

<script>
// 导入组件
import Aside from "../layout/Aside.vue";
export default {
  name: "Aside",
  components: {
    Aside
  }
};
</script>

<style lang="scss" scoped>
</style>