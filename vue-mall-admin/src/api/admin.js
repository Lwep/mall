import request from "../utils/request"

/**
 * 获取数据
 * @param {*} params 
 */
export function getList(params){
    return request({
        url:'/admin-service/admin',
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
        url:'/admin-service/admin/batch',
        method:'delete',
        data:ids
    });
}

/**
 * 添加管理员
 */
export function addAdmin(admin){
    return request({
        url:'/admin-service/admin/',
        method:'post',
        data:admin
    });
}