<template>
  <div>
  <!-- <el-upload
    class="avatar-uploader"
    action=""
    :show-file-list="false"
    :on-success="handleAvatarSucess"
    :before-upload="beforeAvatarupload"
    :auto-upload="true"
  > -->

   <el-upload
      action
      :http-request="fileUpload"
      list-type="picture-card"

      :before-upload="beforeAvatarupload"
      :auto-upload="true"
    >
      <!-- 十字图标 -->
      <i slot="default" class="el-icon-plus"></i>
      <!-- 文件 -->
      <div slot="file" slot-scope="{file}">
        <img class="el-upload-list__item-thumbnail" :src="file.url" alt />
        <span class="el-upload-list__item-actions">
          <span class="el-upload-list__item-preview" >
            <i class="el-icon-zoom-in"></i>
          </span>
          
        </span>
      </div>
    </el-upload>
    <!-- 显示图像
    <img v-if="imgeUrl" :src="imgeUrl" clss="avatar" />
    <i v-else class="el-icon-plus avatar-uploader-icon"></i>
  </el-upload> -->
  </div>
</template>
<script>
import {
  fileUpload
} from "@/api/upload.js";


export default {
  data() {
    return {
      imgeUrl:"",
      dialogImageUrl: "",
      dialogVisible: false,
      disabled: false
    };
  },
  methods: {

   handleAvatarSucess(res,file){
     this.imgeUrl = URL.createObjectURL(file.raw);
   },

   beforeAvatarupload(file){
     const isJPG = file.type ==="image/jpeg";
     const isLt20M = file.size/1024/1024 <20;
     if(!isJPG){
       this.$message.error("不是jpg");
     }
     if(!isLt20M){
       this.$message.error("文件超过20mb");
     }
     return isJPG && isLt20M;
   },

     fileUpload(file) {
      console.log(file);
      fileUpload(file).then(res => {
        console.log(res);
      });
    }
  }
};
</script>
<style lang='scss' scoped>
</style>    