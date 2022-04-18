import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import Login from '@/views/login/index.vue'
import Mock from '@/views/mock/index.vue'
import Upload from '@/views/upload/index.vue'
import Register from '@/views/register/index.vue'
import Container from '@/views/container/index.vue'
import File from '@/views/container/menu/file.vue'
import Favorites from '@/views/container/menu/favorites.vue'
import Encrypt from '@/views/container/menu/encrypt.vue'
import Subscribe from '@/views/container/menu/subscribe.vue'
import Recovery from '@/views/container/menu/recovery.vue'
import Log from '@/views/container/menu/log.vue'
const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    redirect: '/login'
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/mock',
    name: 'Mock',
    component: Mock
  },
  {
    path: '/register',
    name: 'Register',
    component: Register
  },
  {
    path: '/home',
    name: 'Home',
    component: Container,
    children: [
      {
        path: '/file',
        component: File,
        meta: {
          title: "文件",
        },
      },
      {
        path: '/favorites',
        component: Favorites,
        meta: {
          title: "收藏夹",
        },
      },
      {
        path: '/encrypt',
        component: Encrypt,
        meta: {
          title: "加密箱",
        },
      },
      {
        path: '/subscribe',
        component: Subscribe,
        meta: {
          title: "订阅栏",
        },
      },
      {
        path: '/recovery',
        component: Recovery,
        meta: {
          title: "回收站",
        },
      },
      {
        path: '/log',
        component: Log,
        meta: {
          title: "登录日志",
        },
      },
    ]
  },
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
