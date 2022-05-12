import { getCurrentInstance } from "vue";
import { useStore } from "@/store/index";
import { LoginParams } from "@/views/user/UserModel";
import { useRouter } from 'vue-router';
import { ElNotification } from 'element-plus'
// 点击登录
export default function userLogin(loginModel: LoginParams) {

    const { proxy } = getCurrentInstance() as any;

    const store = useStore();
    const router = useRouter();
    // 登录
    const login = () => {
        console.log("login start ===>",Date.now())
        proxy.$refs.loginFormRef.validate(async (valid: boolean) => {
            if (valid) {
                store.dispatch('login', loginModel).then(res => {
                    if (res.data.code == 200) {
                        console.log("login end ===>",Date.now())
                        router.push({ path: '/home' })
                    } else {
                        ElNotification({
                            title: 'Prompt',
                            message: "验证码或者密码错误！",
                            duration: 7000,
                        })
                        location.reload();
                    }
                })
            }
        })
    }
    // 注册
    const register = () => {
        router.push({ path: "/register" })
    }
    return { login, register }
}