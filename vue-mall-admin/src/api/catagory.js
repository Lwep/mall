import request from "../utils/request"

/**
 * 级联菜单
 */

 export function getListCatagory(){
     return request({
         url:'/goods-service/goods/catagory',
         method:'get'
     });
 }