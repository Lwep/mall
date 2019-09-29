import request from "@/utils/request.js";
// 文件上传地址


export function fileUpload(fileobj){
    let param = new FormData();
    // 上传文件对象 名称file与后台控制器参数要一致
    param.append('file',fileobj.file);
    return request({
        
        // 上传地址
        url: '/goods-service/goods/goods/upload',
        method: 'post',
        // 定义上传头
        headers: {'Content-Type':'multipart/form-data'},
        data: param
      });
}