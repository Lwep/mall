import request from "@/utils/request.js";
// 文件上传地址


export function fileUpload(fileobj){
    let param = new FormData();
    param.append('file',fileobj.file);
    return request({
        url:'/goods-service/goods/goods/upload',
        method: 'post',
        headers: {'Content-Type':'multipart/form-data'},
        data: param
      });
}