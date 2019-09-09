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
      component: () => import('@/views/layout/Layout.vue')
    }
  ]
})
router.beforeEach((to,from,next) => {
  if(window.token) {
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