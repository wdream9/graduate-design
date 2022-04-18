// 登录组件逻辑

import { ref, reactive } from "vue";
import { onMounted } from 'vue'
import {request} from '@/utils/http/index';

// 获取验证码
export function codeLogin() {
    const imageSrc = ref('')
    const send = () => {
        request.get({
            url: '/user/code',
            responseType: 'arraybuffer'
        }).then((res: any) => {
            return 'data:image/png;base64,' + btoa(
                new Uint8Array(res.data as any).reduce((data, byte) => data + String.fromCharCode(byte), '')
            )
        }).then((data: any) => {
            imageSrc.value = data;
        })
    }
    onMounted(() => {
        send()
    })
    return { imageSrc, send };
}



