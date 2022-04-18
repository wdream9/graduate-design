import { request } from "@/utils/http";
import { LoginParams } from '@/views/user/UserModel';

enum UserApi {
    login = '/user/login',
}

// 登录
export async function loginApi(params: LoginParams) {
    return await request.post({
        url: UserApi.login,
        data: JSON.stringify(params),
        headers:{'content-type': 'application/json'},
    })
}