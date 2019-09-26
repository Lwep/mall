<template>
  <div>
    <el-menu :default-openeds="['1']">
      <el-submenu :index="item.id" v-for="item in menuDate" :key="item.id">
        <template slot="title">
          <i :class="item.icon"></i>
          <span slot="title">{{item.title}}</span>
        </template>
        <el-menu-item-group v-for="childItem in item.children" :key="childItem.id">
          <el-menu-item :index="childItem.id">{{childItem.title}}</el-menu-item>
        </el-menu-item-group>
      </el-submenu>
    </el-menu>
  </div>
</template>>
<script>
export default {
  data() {
    return {
      menuDate: [
        {
          id: "1",
          title: "统 计",
          icon: "el-icon-s-data",
          children: [
            { id: "5", title: "用户统计" },
            { id: "6", title: "订单统计" }
          ]
        },

        { id: "2", title: "管 理", icon: "el-icon-s-custom" },
        { id: "3", title: "设 置", icon: "el-icon-s-tools" }
      ]
    };
  },

  props: {},
  methods: {
    navUser() {
      this.$router.push("/layout/user");
    },
    navAdmin() {
      this.$router.push("/layout/admin");
    },
    navOrder() {
      this.$router.push("/layout/order");
    },
    navGoods() {
      this.$router.push("/layout/catagory");
    },
    navUpload() {
      this.$router.push("/layout/upload");
    }
  }
};
</script>
<style lang="scss" >
.el-submenu__title {
  font-weight: 900;
  right: 20px;
}
</style>