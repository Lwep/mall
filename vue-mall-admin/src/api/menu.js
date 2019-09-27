import request from "@/utils/request.js";

/**
 * 获取菜单数据
 */
export function getMenu(){
    return request({
        url:"/admin-service/menu/admin002",
        method:"get"
    });
}
/**
 * 获取路由数据
 */
export function getRouter(){
    return request({
        url:"/admin-service/menu/router/admin002",
        method:"get"
    });
}