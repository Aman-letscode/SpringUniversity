import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: () => import('../components/Home.vue')
    },
    {
      path: '/login',
      name: 'login',
      component: () => import('../components/Login.vue')
    },
    {
      path: '/signup',
      name: 'signup',

      component: () => import('../components/Signup.vue')
    },
    {
      path: '/forget-password',
      name: 'forget-password',

      component: () => import('../components/ForgetPassword.vue')
    },
    {
      path: '/courses',
      name: 'courses',

      component: () => import('../components/CourseList.vue')
    }
  ]
})

export default router
