<template>
    <div>
     <el-menu :default-openeds="['1']" >
      <el-submenu index="1">
        <template slot="title" ><i class="el-icon-s-data"></i>统 计</template>
        <el-menu-item-group>
          <el-menu-item index="1-1">用户统计</el-menu-item>
          <el-menu-item index="1-2">订单统计</el-menu-item>
        </el-menu-item-group>
      </el-submenu>

      <el-submenu index="2">
        <template slot="title" ><i class="el-icon-s-custom"></i>管 理</template>
        <el-menu-item-group>
          <el-menu-item index="2-1" @click="navUser">用户管理</el-menu-item>
          <el-menu-item index="2-2" @click="navGoods">商品管理</el-menu-item>
          <el-menu-item index="2-3" @click="navOrder">订单管理</el-menu-item>
          <el-menu-item index="2-4" @click="navAdmin">管理员管理</el-menu-item>
        </el-menu-item-group>
      </el-submenu>

      <el-submenu index="3">
        <template slot="title"><i class="el-icon-s-tools"></i>设 置</template>
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
  
  },
  methods: {
    navUser(){
     this.$router.push("/layout/user");
    },
    navAdmin(){
     this.$router.push("/layout/admin");
    },
    navOrder(){
     this.$router.push("/layout/order");
    },
    navGoods(){
     this.$router.push("/layout/goods");
    },
  }
};
</script>
<style lang="scss" >

.el-submenu__title {
font-weight: 900;
right: 20px;
}

</style>