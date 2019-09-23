<template>
  <div>
  <!-- 上传图片 -->
  <!-- <el-upload action="http://localhost:8004/goods/goods/upload" list-type="picture-card" :auto-upload="false">
      <i slot="default" class="el-icon-plus"></i>
      <div slot="file" slot-scope="{file}">
        <img class="el-upload-list__item-thumbnail" :src="file.url" alt />
        <span class="el-upload-list__item-actions">
          <span class="el-upload-list__item-preview" @click="handlePictureCardPreview(file)">
            <i class="el-icon-zoom-in"></i>
          </span>
          <span v-if="!disabled" class="el-upload-list__item-delete" @click="handleDownload(file)">
            <i class="el-icon-download"></i>
          </span>
          <span v-if="!disabled" class="el-upload-list__item-delete" @click="handleRemove(file)">
            <i class="el-icon-delete"></i>
          </span>
        </span>
      </div>
  </el-upload>-->
  <el-upload
    class="avatar-uploader"
    action="http://localhost:8004/goods/goods/upload"
    :show-file-list="false"
    :on-success="handleAvatarSucess"
    :before-upload="beforeAvatarupload"
    name="file"
  >
    <!-- 显示图像 -->
    <img v-if="imgeUrl" :src="imgeUrl" clss="avatar" />
    <i v-else class="el-icon-plus avatar-uploader-icon"></i>
  </el-upload>
  </div>
</template>
<script>
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
    // handleRemove(file) {
    //   console.log(file);
    // },
    // //点击预览
    // handlePictureCardPreview(file) {
    //   this.dialogImageUrl = file.url;
    //   this.dialogVisible = true;
    // },
    // handleDownload(file) {
    //   console.log(file);
    // }
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
       this.$message.error("太大");
     }
     return isJPG && isLt20M;
   }

  }
};
</script>
<style lang='scss' scoped>
</style>    