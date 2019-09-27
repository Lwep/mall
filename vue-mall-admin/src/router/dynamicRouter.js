/**
 * 动态路由定义
 */
let dynamicRouter = {
    routes: [
        {
            path: "/layout",
            name: "layout",
            component: () => import("@/views/layout/Layout.vue"),
            children: []
        }
    ]
}

export default dynamicRouter;