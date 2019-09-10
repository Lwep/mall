<template>
  <el-table ref="multipleTable" :data="tableData" tooltip-effect="dark" style="width: 100%">
    <el-table-column type="selection" width="55"></el-table-column>
    <el-table-column prop="ID" label="ID" ></el-table-column>
    <el-table-column prop="username" label="登录名" ></el-table-column>
    <el-table-column prop="rolename" label="真实姓名" ></el-table-column>
    <el-table-column prop="create_time" label="创建时间" ></el-table-column>
    <el-table-column prop="uptate_time" label="更新时间" ></el-table-column>
  </el-table>
</template>
<script>
export default {
  data() {
    return {
      tableData: [
        {
          ID: "1111111111111111",
          username: "王小虎",
          rolename: "上海市普陀区金沙江路 1518 弄",
          create_time: "上海市普陀区金沙江路 1518 弄",
          uptate_time: "上海市普陀区金沙江路 1518 弄"
        },
         {
          ID: "1111111111111111",
          username: "王小虎",
          rolename: "上海市普陀区金沙江路 1518 弄",
          create_time: "上海市普陀区金沙江路 1518 弄",
          uptate_time: "上海市普陀区金沙江路 1518 弄"
        },
      ]
    };
  }
};
</script>
<style lang='scss' scoped>
</style>