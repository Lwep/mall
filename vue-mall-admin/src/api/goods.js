import request from "../utils/request"


/**
 *获取所有商品信息 
 */

export function getList(params){
    return request({
        url:'/goods-service/goods/goods',
        method:'get',
        params
    });
}


/**
 * 批量删除
 * 
 */
export function bathDelete(ids){
    return request({
        url:'/goods-service/goods/goods/batch',
        method:'delete',
        data:ids
    });
}



/**
 * 添加商品
 */
export function addGoods(goods){
    return request({
        url:'/goods-service/goods/goods/addGoods',
        method:'post',
        data:goods
    });
}