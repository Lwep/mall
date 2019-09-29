>
<template>
  <div>
    
    <el-menu :default-openeds="['2']" :collapse="isCollapse">
      <!-- 目录 -->
      <el-submenu :index="item.key" v-for="item in menuData" :key="item.id">
        <template slot="title">
          <i :class="item.icon"></i>
          <span slot="title">{{item.title}}</span>
        </template>
        <el-menu-item-group>
          <!-- 子菜单 -->
          <el-menu-item
            v-for="childItem in item.children"
            :key="childItem.id"
            :index="item.key"
            @click="navRouter(childItem.path)"
          >{{childItem.title}}</el-menu-item>
        </el-menu-item-group>
      </el-submenu>
    </el-menu>
  </div>
</template>
<script>
import { getMenu } from "@/api/menu.js";
export default {
  data() {
    return {
      menuData: []
    };
  },
  props: {
    isCollapse: {
      type: Boolean
    }
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
</script>

<style lang="scss" >
.el-submenu__title {
  font-weight: 900;
  right: 20px;
}
</style>