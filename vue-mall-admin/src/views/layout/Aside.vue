<template>
    <div>
     <el-menu :default-openeds="['1']">
      <el-submenu index="1">
        <template slot="title">分析</template>
        <el-menu-item-group>
          <el-menu-item index="1-1">用户分析</el-menu-item>
          <el-menu-item index="1-2">订单分析</el-menu-item>
        </el-menu-item-group>
      </el-submenu>

      <el-submenu index="2">
        <template slot="title">管理</template>
        <el-menu-item-group>
          <el-menu-item index="2-1">用户管理</el-menu-item>
          <el-menu-item index="2-2">商品管理</el-menu-item>
          <el-menu-item index="2-3">订单管理</el-menu-item>
          <el-menu-item index="2-4">管理员管理</el-menu-item>
        </el-menu-item-group>
      </el-submenu>

      <el-submenu index="3">
        <template slot="title">设置</template>
        <el-menu-item-group>
          <el-menu-item index="3-1">活动设置</el-menu-item>
          <el-menu-item index="3-2">卡券设置</el-menu-item>
        </el-menu-item-group>
      </el-submenu>
    </el-menu>
    </div>
</template>
<script>
export default {
  props: {
    isCollapse: {
      type: Boolean
    }
  },
  methods: {
    navRole() {
      this.$router.push("/layout/role");
    },
    navUser() {
      this.$router.push("/layout/user");
    },
    navCategory() {
      this.$router.push("/layout/category");
    }
  }
};
</script>
<style lang="scss" scoped>
// .el-menu-vertical-demo:not(.el-menu--collapse) {
//   width: 200px;
//   min-height: 400px;
// }
</style>