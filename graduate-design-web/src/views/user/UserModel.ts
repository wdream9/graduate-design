/**
 * 登录请求参数类型
 */
export interface LoginParams{
    username:string,
    password:string,
    code:string
}
/**
 * 登录响应参数类型
 */
export interface LoginResult{
    id:number,
    token:string,
    code:number,
    expireTime:number
}
export interface UserInfo{
    avatar:string;
    id:string;
    introduction:string;
    name:string;
    roles:Array<string>
}