import { LoginParams } from "@/views/user/UserModel";
import { ref, reactive } from "vue";
import { ElForm } from 'element-plus';
export default function useBaseLogin() {
    //登录表单ref
    const loginFormRef = ref<InstanceType<typeof ElForm>>();
    // 表单绑定数据
    const loginModel = reactive<LoginParams>({
        username: '',
        password: '',
        code: ''
    })

    // 表单验证规则
    const rules = reactive({
        username: [{
            required: true,
            message: '请填写登录账户',
            trigger: 'change',
        }],
        password: [{
            required: true,
            message: '请填写密码',
            trigger: 'change',
        }],
        code: [{
            required: true,
            message: '请填写验证码',
            trigger: 'change',
        }]
    })

    // 忘记密码
    const forget = () => {
        console.log("wangjimima")
    }
    return {
        loginModel,
        loginFormRef,
        rules,
        forget
    }
}