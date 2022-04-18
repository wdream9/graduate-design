import { getCurrentInstance,ComponentInternalInstance } from "vue";

export default function useInstance(){
    const {appContext,proxy} = getCurrentInstance() as ComponentInternalInstance；
    const global = appContext.config.globalProperties;
    return {
        proxy, // 获取每一个页面的ref属性
        global
    }
}