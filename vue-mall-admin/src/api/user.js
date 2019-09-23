import request from "../utils/request"

/**
 * 获取数据
 * @param {*} params 
 */
export function getList(params){
    return request({
        url:'/user-service/user',
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
        url:'/user-service/user/batch',
        method:'delete',
        data:ids
    });
}