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
        { path: 'order', name: 'roorderle', component: () => import('@/views/order/Order.vue'), },
        { path: 'goods', name: 'goods', component: () => import('@/views/goods/Goods.vue'), },
        { path: 'admin', name: 'admin', component: () => import('@/views/admin/Admin.vue'), },
        { path: 'user', name: 'user', component: () => import('@/views/user/User.vue'), },
      ]
    },

  ]
})
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