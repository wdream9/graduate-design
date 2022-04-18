import { getTokenCookie } from '@/utils/auth/auth'
import axios from 'axios'
import { AxiosInstance, AxiosRequestConfig } from 'axios'

axios.defaults.headers.common['Access-Control-Allow-Origin'] = '*'
//将axios封装到类中
class xwlRequest {
    //axios的实例将被保存到这里
    instance: AxiosInstance
    //构造器里的config包括baseURL，timeout等
    constructor(config: AxiosRequestConfig) {
        //创建axios实例
        this.instance = axios.create(config)
        //实例中的请求拦截器
        this.instance.interceptors.request.use(
            (config: AxiosRequestConfig) => {
                //请求成功的拦截
                console.log("interceptors.request", config)
                let token = getTokenCookie("netdisk") || '';
                if (token) {
                    //把token添加到请求头部
                    config.headers = {
                        'netdisk': token,
                        'content-type': 'application/json',
                    };
                }
                return config
            },
            (error) => {
                //请求失败的拦截
                return Promise.reject(error)
            }
        )
        this.instance.interceptors.response.use(//实例中的响应拦截器
            (response) => {
                //响应成功的拦截
                console.log("interceptors.response", response)
                return response
            },
            (error) => {
                //响应失败的拦截
                return Promise.reject(error)
            }
        )
    }
    //再次封装request方法
    request<T>(config: AxiosRequestConfig): Promise<T> {
        return new Promise((resolve, reject) => {
            this.instance
                .request<any, T>(config)
                .then((res) => {
                    //将结果返回出去
                    resolve(res)
                })
                .catch((err) => {
                    reject(err)
                    return err
                })
        })
    }
    get<T>(config: AxiosRequestConfig): Promise<T> {
        return this.request<T>({ ...config, method: 'GET' })
    }
    post<T>(config: AxiosRequestConfig): Promise<T> {
        return this.request<T>({ ...config, method: 'POST' })
    }
    delete<T>(config: AxiosRequestConfig): Promise<T> {
        return this.request<T>({ ...config, method: 'DELETE' })
    }
    patch<T>(config: AxiosRequestConfig): Promise<T> {
        return this.request<T>({ ...config, method: 'PATCH' })
    }
}
export default xwlRequest 