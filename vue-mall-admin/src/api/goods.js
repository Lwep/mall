import request from "../utils/request"


/**
 *获取所有商品信息 
 */

export function getListGoods(){
    return request({
        url:'/goods-service/goods/goods/list',
        method:'get'
    });
}