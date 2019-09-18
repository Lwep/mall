<template>
  <div>
    <div class="topBtn">
      <el-button>添加用户</el-button>
      <el-button @click="toggleSelection()">取消选择</el-button>
    </div>
    <el-table
      ref="multipleTable"
      :data="data"
      tooltip-effect="dark"
      style="width: 100%"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55"></el-table-column>
      <el-table-column prop="id" label="ID"></el-table-column>
      <el-table-column prop="username" label="登录名"></el-table-column>
      <el-table-column prop="phone" label="电话"></el-table-column>
      <el-table-column label="创建时间">
        <template slot-scope="scope">{{scope.row.createTime}}</template>
      </el-table-column>
      <el-table-column label="更新时间">
        <template slot-scope="scope">{{scope.row.uptateTime}}</template>
      </el-table-column>
    </el-table>

    <div class="block">
      <!-- <span class="demonstration">完整功能</span> -->
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="current"
        :page-sizes="[5, 10, 15, 20]"
        :page-size="size"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
      ></el-pagination>
    </div>
  </div>
</template>

<script>
import { getList } from "@/api/user.js";
export default {
  data() {
    return {
      data: [],
      total: 0,
      current: 1,
      size: 5,
      ids: []
    };
  },
  beforeMount() {
    this.getList();
  },
  methods: {
    getList() {
      let params = { current: this.current, size: this.size };
      getList(params).then(response => {
        this.data = response.data.data.records;
        this.total = response.data.data.total;
        this.current = response.data.data.current;
        this.size = response.data.data.size;
        // console.log(response);
      });
    },
    handleSelectionChange(val) {
      console.log(val);
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
    toggleSelection() {}
  }
};
</script>
<style lang='scss' scoped>
.topBtn {
  margin: 10px;
  text-align: left;
}
</style>