import Vue from 'vue'
import Router from 'vue-router'


Vue.use(Router)


const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'login',
      component: () => import('@/views/Login.vue')
    },
    {
      path: '/layout',
      name: 'layout',
      component: () => import('@/views/layout/Layout.vue'),
      children: [
        { path: 'order', name: 'order', component: () => import('@/views/order/Order.vue'), },
        { path: 'catagory', name: 'catagory', component: () => import('@/views/catagory/Catagory.vue'), },
        { path: 'admin', name: 'admin', component: () => import('@/views/admin/Admin.vue'), },
        { path: 'user', name: 'user', component: () => import('@/views/user/User.vue'), },
        { path: 'upload', name: 'upload', component: () => import('@/views/upload/Upload.vue'), },

      ]
    },

  ]
})
// 解决重复路由，重写push方法
const originalPush = Router.prototype.push;
Router.prototype.push = function push(location) {
    return originalPush.call(this, location).catch(err => err);
};


router.beforeEach((to, from, next) => {
  if (window.token) {
    next();
  } else {
   console.log("认证是否成功")
    if (to.path != '/') {
      next('/')
    } else {
      next();
    }
  }
});

export default router;