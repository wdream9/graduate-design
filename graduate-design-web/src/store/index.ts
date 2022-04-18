import { LoginParams } from '@/views/user/UserModel';
import { InjectionKey } from 'vue'
import { loginApi } from '@/api/user/index'
import { setToken, setUserId, setExpireTime } from '@/utils/auth/auth'


import { createStore, useStore as baseUseStore, Store, ActionContext } from 'vuex'
import { format } from 'path';

/**
 * 抽象sate
 * const questionList: Array<BaseType> = reactive([]);
 */
export interface State {
  token: string,
  userId: number,
  userNick: string
}

export const key: InjectionKey<Store<State>> = Symbol()

// 规定，如果type = 5 ，则表示组合题型
export const store = createStore<State>({
  state: {
    token: '',
    userId: -1,
    userNick: ''
  },
  mutations: {
    setToken(state: State, token: string) {
      state.token = token;
    },
    setUserId(state: State, userId: number) {
      state.userId = userId;
    },
    setUserNick(state: State, nick: string){
      state.userNick = nick;
    }
  },
  actions: {
    // 登录
    login({ commit }: ActionContext<State, State>, loginParm: LoginParams) {
      return new Promise((resolve, reject) => {
        loginApi(loginParm).then((res: any) => {
          if (res.data.code == 200) {
            console.log("2. login success ====>", res.data)
            const cookie = res.data
            var d = new Date();
            d.setTime(d.getTime() + cookie.expireTime);
            document.cookie = `netdisk=${cookie.token}; expires=${d.toUTCString()}; path=/`;
            //设置到vuex中
            commit('setToken', res.data.token)
            commit('setUserId', res.data.id)
            commit('setUserNick', res.data.nick)
            //存储到sessionStorage
            setToken(res.data.token)
            setUserId(res.data.id)
            setExpireTime(res.data.expireTime)
          } 
          resolve(res)
        }).catch(error => {
          reject(error)
        })
      })
    },
  },
  getters: {
    getToken(state: State) {
      return state.token
    },
    getNick(state: State){
      return state.userNick
    }
  }
})

// 定义自己的 `useStore` 组合式函数
export function useStore() {
  return baseUseStore(key)
}