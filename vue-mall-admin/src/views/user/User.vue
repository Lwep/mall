<template>
  <div>
    <div class="topBtn">
      <el-button @click="dialogFormVisible = true">添加用户</el-button>
      <el-button @click="bathDelete()">删除选中</el-button>
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
      <el-table-column label="操作">
        <el-button type="primary" size="mini" @click="update">修改</el-button>
      </el-table-column>
    </el-table>

    <el-dialog title="添加用户" :visible.sync="dialogFormVisible">
      <el-form :model="form">
        <el-form-item label="登录名" :label-width="formLabelWidth">
          <el-input v-model="form.username" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="密码" :label-width="formLabelWidth">
          <el-input v-model="form.password" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="确认密码" :label-width="formLabelWidth">
          <el-input v-model="form.password" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="联系方式" :label-width="formLabelWidth">
          <el-input v-model="form.name" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="addUser">确 定</el-button>
      </div>
    </el-dialog>

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
import { getList, bathDelete, addUser } from "@/api/user.js";
export default {
  data() {
    return {
      dialogFormVisible: false,
      form: {
        username: "",
        password: "",
        repassword: "",
        phone: "",
        delivery: false
      },
      formLabelWidth: "120px",

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
    update() {
    
      
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
    bathDelete() {
      bathDelete(this.ids).then(response => {
        if (response.data.code == "0000") {
          this.getList();
        }
        alert(response.data.message);
      });
    },

    addUser() {
      addUser(this.form).then(response => {
        if (response.data.code == "0000") {
          this.getList();
        }
        alert(response.data.message);
        this.dialogFormVisible = false;
      });
    }
  }
};
</script>
<style lang='scss' scoped>
.topBtn {
  margin: 10px;
  text-align: left;
}

.el-form-item__label {
  font-size: 14px;
}
</style>