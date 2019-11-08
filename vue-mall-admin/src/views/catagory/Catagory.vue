<template>
  <div>
    <!-- 级联分类 -->
    <div class="block">
      <span class="demonstration"></span>
      <el-cascader :options="options" v-model="selectedOptions" @change="handleChange"></el-cascader>
    </div>

    <div class="topBtn">
      <el-button @click="dialogFormVisible = true">添加商品</el-button>
      <el-button @click="bathDelete()">删除选中</el-button>
    </div>

    <el-dialog title="添加商品" :visible.sync="dialogFormVisible">
      <el-form :model="form">
        <el-form-item label="商品名" :label-width="formLabelWidth">
          <el-input v-model="form.goodsName" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="商品价格" :label-width="formLabelWidth">
          <el-input v-model="form.goodsPrice" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="商品库存" :label-width="formLabelWidth">
          <el-input v-model="form.goodsStock" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="商品状态" :label-width="formLabelWidth">
          <el-input v-model="form.goodsStatus" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="addGoods">确 定</el-button>
      </div>
    </el-dialog>



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
      
      </el-table>


      
    </div>
  </div>
</template>
<script>
import { getListCatagory } from "@/api/catagory.js";
import { getList , bathDelete,addGoods} from "@/api/goods.js";
export default {
  data() {
    return {
      data: [],
      total: 0,
      current: 1,
      size: 5,
      ids: [],
      options: [],
      selectedOptions: [],


       dialogFormVisible: false,

       form: {
        username: "",
        password: "",
        repassword: "",
        realname: "",
        phone: "",
        delivery: false
      },
       formLabelWidth: "120px"
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
        getList(params).then(response => {
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

      bathDelete() {
      bathDelete(this.ids).then(response => {
        if (response.data.code == "0000") {
          this.getList();
        }
        alert(response.data.message);
      });
    },

    addGoods() {
       addGoods(this.form).then(response => {
        if (response.data.code == "0000") {
          this.getList();
        }
        alert(response.data.message);
        this.dialogFormVisible=false;
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