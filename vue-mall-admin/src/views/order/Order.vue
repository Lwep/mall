<template>
  <div>
    <!-- <el-tabs v-model="activeName" @tab-click="handleClick">
      <el-tab-pane label="待付款" name="first"></el-tab-pane>
      <el-tab-pane label="待发货" name="second"></el-tab-pane>
      <el-tab-pane label="待签收" name="third"></el-tab-pane>
      <el-tab-pane label="已完成" name="fourth"></el-tab-pane>
    </el-tabs> -->

    <div>
      <el-table ref="multipleTable" :data="data" tooltip-effect="dark" style="width: 100%">
        <el-table-column type="selection" width="55"></el-table-column>
        <el-table-column prop="id" label="订单编号"></el-table-column>
        <el-table-column label="提交时间">
          <template slot-scope="scope">{{scope.row.createTime}}</template>
        </el-table-column>
        <el-table-column prop="realname" label="用户账号"></el-table-column>
        <el-table-column prop="phone" label="交易金额"></el-table-column>
        <el-table-column prop="phone" label="支付方式"></el-table-column>
        <el-table-column prop="phone" label="订单状态"></el-table-column>
      </el-table>
    </div>
  </div>
</template>
<script>
export default {
}
</script>   
<style lang='scss'>
.el-tabs__nav-scroll {
  position: relative;
  left: 5%;
}
</style>            