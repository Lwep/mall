import request from "../utils/request"
/**
 * 登录方法
 * @param {} data 
 */
export function login(data){
    return request({
        url:"/admin-service/auth/login",
        method:"post",
        data:data
    });
}

