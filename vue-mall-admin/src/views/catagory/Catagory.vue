<template>
  <div>
    <!-- 级联分类 -->
    <div class="block">
      <span class="demonstration"></span>
      <el-cascader :options="options" v-model="selectedOptions" @change="handleChange"></el-cascader>
    </div>

    <!-- 商品显示 -->
    <div>
      <el-table
        ref="multipleTable"
        :data="data"
        tooltip-effect="dark"
        @selection-change="handleSelectionChange"
        style="width: 100%"
      >
        <el-table-column type="selection" width="55"></el-table-column>
        <el-table-column prop="id" label="商品ID"></el-table-column>
        <el-table-column prop="goodsName" label="商品名"></el-table-column>
        <el-table-column prop="goodsPrice" label="价格"></el-table-column>
        <el-table-column prop="goodsStock" label="库存"></el-table-column>
        <el-table-column label="创建时间">
          <template slot-scope="scope">{{scope.row.createTime}}</template>
        </el-table-column>
        <el-table-column label="更新时间">
          <template slot-scope="scope">{{scope.row.uptateTime}}</template>
        </el-table-column>
      </el-table>


      
    </div>
  </div>
</template>
<script>
import { getListCatagory } from "@/api/catagory.js";
import { getListGoods } from "@/api/goods.js";
export default {
  data() {
    return {
      data: [],
      total: 0,
      current: 1,
      size: 5,
      ids: [],
      options: [],
      selectedOptions: []
    };
  },
  beforeMount() {
    this.getList();
  },

  methods: {
    handleChange(value) {
      console.log("111+" + value);
    },
    getList() {
      let params = { current: this.current, size: this.size };
      getListCatagory().then(
        response => {
          this.options = response.data.data;
        },
        getListGoods(params).then(response => {
          this.data = response.data.data.records;
          this.total = response.data.data.total;
          this.current = response.data.data.current;
          this.size = response.data.data.size;
          console.log(response);
        })
      );
    },
    handleSelectionChange(val) {
      this.ids = [];
      val.forEach(element => {
        this.ids.push(element.id);
      });
      console.log("1-----" + this.ids);
      this.multipleSelection = val;
    },
    handleSizeChange(val) {
      this.size = val;
      console.log(`每页 ${val} 条`);
      this.getList();
    },
    handleCurrentChange(val) {
      this.current = val;
      console.log(`当前页: ${val}`);
      this.getList();
    },
  }
};
</script>
<style lang='scss' scoped>
</style>