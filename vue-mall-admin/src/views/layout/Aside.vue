<template>
  <div>
    <el-menu :default-openeds="['1']">
      <!-- 目录 -->
      <el-submenu :index="item.id" v-for="item in menuDate" :key="item.id">
        <template slot="title">
          <i :class="item.icon"></i>
          <span slot="title">{{item.title}}</span>
        </template>
        <!-- 子菜单 -->
        <el-menu-item-group v-for="childItem in item.children" :key="childItem.id">
          <el-menu-item :index="childItem.id" @click="navRouter(childItem.path)">{{childItem.title}}</el-menu-item>
        </el-menu-item-group>
      </el-submenu>
    </el-menu>
  </div>
</template>>
<script>
import { getMenu } from "@/api/menu.js";

export default {
 data() {
    return {
      menuData: []
    };
  },

  created() {
    this.initMenu();
  },
  methods: {
    navRouter(url) {
      this.$router.push("/layout/" + url);
    },
    initMenu() {
      getMenu().then(res => {
        this.menuData = res.data.data;
      });
    }
  } 
};

// data() {
//   return {
//     menuDate: [
//       {
//         id: "1",
//         title: "统 计",
//         icon: "el-icon-s-data",
//         children: [
//           { id: "5", title: "用户统计", path: "" },
//           { id: "6", title: "订单统计", path: "" }
//         ]
//       },

//       {
//         id: "2",
//         title: "管 理",
//         icon: "el-icon-s-custom",
//         children: [
//           { id: "7", title: "用户管理", path: "user" },
//           { id: "8", title: "商品管理", path: "catagory" },
//           { id: "9", title: "订单管理", path: "order" },
//           { id: "10", title: "管理员管理", path: "admin" }
//         ]
//       },
//       {
//         id: "3",
//         title: "设 置",
//         icon: "el-icon-s-tools",
//         children: [
//           { id: "11", title: "用户统计", path: "" },
//           { id: "12", title: "订单统计", path: "" }
//         ]
//       }
//     ]
//   };
// },

// props: {},
// methods: {
//   navRouter(url) {
//     this.$router.push("/layout/" + url);
//   }

// navUser() {
//   this.$router.push("/layout/user");
// },
// navAdmin() {
//   this.$router.push("/layout/admin");
// },
// navOrder() {
//   this.$router.push("/layout/order");
// },
// navGoods() {
//   this.$router.push("/layout/catagory");
// },
// navUpload() {
//   this.$router.push("/layout/upload");
// }
</script>
<style lang="scss" >
.el-submenu__title {
  font-weight: 900;
  right: 20px;
}
</style>