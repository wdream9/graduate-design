import { RegisterParams } from "./registerModel"
import { getCurrentInstance } from "vue";
import { useStore } from "@/store/index";
import { useRouter } from 'vue-router';
import {request} from "@/utils/http";
import { ElNotification } from 'element-plus'

export default function registerApi(registerModel: RegisterParams) {

    const { proxy } = getCurrentInstance() as any;

    const store = useStore();
    const router = useRouter();
    const login = () => {
        router.push({ path: '/login' })
    }
    // 注册
    const register = () => {
        proxy.$refs.registerFormRef.validate(async (valid: boolean) => {
            if (valid) {
                // 提交注册信息
                request.post({
                    url: '/user/register',
                    data: JSON.stringify(registerModel),
                    headers: { 'content-type': 'application/json' },
                }).then((res: any) => {
                    if (res.data == "00000") {
                        //弹窗成功
                        ElNotification({
                            title: 'Prompt',
                            message: '注册成功,3秒后跳转到登录界面......',
                            duration: 2000,
                        })
                        // 跳转到登录界面
                        setTimeout(() => {
                            router.push({ path: '/login' })
                        }, 3000)
                    } else if (res.data == "10006") {
                        alterInfo("验证码有误")
                    } else if (res.data == "10005") {
                        alterInfo("用户昵称已存在")
                    }
                })
            }
        })
    }
    const alterInfo = (msg: string) => {
        // 验证码错误
        ElNotification({
            title: 'Prompt',
            message: msg,
            duration: 5000,
        })
        location.reload();
    }
    return {
        register, 
        login
    }
}