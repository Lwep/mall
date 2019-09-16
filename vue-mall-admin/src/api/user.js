import request from "../utils/request"

/**
 * 获取数据
 * @param {*} params 
 */
export function getList(params){
    return request({
        url:'/user-service/user',
        methods:'get',
        params
    });
}
