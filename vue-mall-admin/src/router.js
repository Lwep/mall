import Vue from 'vue'
import Router from 'vue-router'
import { getToken } from '@/utils/store.js'
import { getRouter } from "@/api/menu.js";
import dynamicRouter from "@/router/dynamicRouter.js";

Vue.use(Router)

// 解决重复路由，重写push方法
const originalPush = Router.prototype.push;
Router.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => err);
};

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'login',
      component: () => import('@/views/Login.vue')
    },

  ]
});




let newRoutes = null;
router.beforeEach((to, from, next) => {
  // 判断是否是登录界面
  if (to.path != '/') {
    // 从获取store中Token
    if (getToken()) {
      // 刷新动态路由丢失
      if (!newRoutes) {
        // 调用API获取动态路由
        getRouter().then(res => {
          res.data.data.forEach(element => {
            // 重要：赋值给变量
            let value = element.component;
            element.component = function component(resolve) {
              require(["@/views" + value], resolve);
            };
          });
          dynamicRouter.routes[0].children = res.data.data;
          newRoutes = dynamicRouter.routes;
          // 添加路由数据
          router.addRoutes(newRoutes);
          next({ ...to, replace: true });
        });
      } else {
        next()
      }
    } else {
      next("/");
    }
  } else {
    // 如果是登录界面放行
    next();
  }
});

export default router;