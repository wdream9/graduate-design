import { ref, reactive, getCurrentInstance } from "vue";
import { ElForm } from 'element-plus';
import { RegisterParams } from "./registerModel";

export default function baseRegister() {
    // 注册表单 ref
    const registerFormRef = ref<InstanceType<typeof ElForm>>();

    // 表单绑定参数
    const registerModel = reactive<RegisterParams>({
        username: '',
        password: '',
        email: '',
        telephone: '',
        code: ''
    })
    const { proxy } = getCurrentInstance() as any;
    // 密码验证
    var checkPassword = (rule: any, value: any, callback: any) => {
        const pwdReg = /^(?=.*\d)(?=.*[a-zA-Z]).{8,}$/;
        if (!pwdReg.test(value)) {
            callback("请输入包含数字字母的不低于8位数的密码");
        } else {
            callback();
        }
    };
    // 验证手机号
    const checkTelephone = (rule: any, value: any, callback: any) => {
        if (!/^1[34578]\d{9}$/.test(value)) {
            callback('手机号格式错误')
        } else {
            callback()
        }
    }
    // 邮箱验证
    var checkEmail = (rule: any, value: any, callback: any) => {
        const mailReg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
        if (!mailReg.test(value)) {
            callback("请输入正确的邮箱格式");
        } else {
            callback()
        }
    };

    // 表单验证规则 , { validator: checkPassword, trigger: 'blur' }
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
        email: [{
            required: true,
            message: '请填写邮箱',
            trigger: 'change',
        }, { validator: checkEmail, trigger: 'blur' }],
        code: [{
            required: true,
            message: '请填写验证码',
            trigger: 'change',
        }],
        telephone: [{
            required: true,
            message: '请填写手机号',
            trigger: 'blur',
        }, { validator: checkTelephone, trigger: 'blur' }],
    })

    return {
        registerFormRef,
        registerModel,
        rules
    }

}