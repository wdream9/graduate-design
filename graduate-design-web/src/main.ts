import { createApp } from 'vue'
import App from './App.vue'
import { store, key } from './store'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import router from './router'
import myconfirm from '@/hooks/myConfirm'
const app = createApp(App)
app.use(router)
app.use(store, key)
app.use(ElementPlus)
app.mount('#app')

//挂载全局确定弹框
app.config.globalProperties.$myconfirm = myconfirm;
// mock
// if (process.env.NODE_ENV === 'development') {
//   require ('./mock/index.ts')
// }
// require ('./mock/index.ts')

// 引入图标库所有图标
import * as Icons from '@element-plus/icons-vue'
Object.keys(Icons).forEach(key => {
  app.component(key, Icons[key as keyof typeof Icons])
})


import { getTokenCookie } from "@/utils/auth/auth"
const whiteList = ['/login','/register'];
router.beforeEach((to, from, next) => {
  let token = getTokenCookie("netdisk");
  if (token) { //token存在
    next()
  } else { //token不存在 , 跳转的时候，需要注意 BredCum.vue里面判断first
    //判断是否存在白名单中
    if (whiteList.indexOf(to.path) !== -1) { //存在白名单中
      next();
    } else { //不存在白名单中,去登录
      next({ path: '/login' })
    }
  }
})
