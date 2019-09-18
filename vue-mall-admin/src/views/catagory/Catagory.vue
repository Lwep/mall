<template>
  <div class="block">
    <span class="demonstration"></span>
    <el-cascader :options="options" v-model="selectedOptions"   @change="handleChange"></el-cascader>
  </div>
</template>
<script>
import { getListCatagory } from "@/api/catagory.js";

export default {
  data() {
    return {
      options:[],
      selectedOptions: []
    };
  },
  beforeMount() {
    this.getList();
  },

  methods: {
    handleChange(value) {
      console.log(value);
    },
    getList() {
      console.log("--");
      getListCatagory().then(response =>  {
        this.options = response.data.data;
      });
    }
  }
};
</script>
<style lang='scss' scoped>
</style>