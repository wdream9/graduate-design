//创建封装后的实例
import { BASE_URL_USER, TIME_OUT_USER, BASE_URL_UPLOAD, TIME_OUT_UPLOAD, BASE_URL_DOWNLOAD, TIME_OUT_DOWNLOAD } from './config'
import xwlRequest from './axios/index'

// 用户服务
export const request = new xwlRequest({
  baseURL: BASE_URL_USER,
  timeout: TIME_OUT_USER
})

// 文件上传
export const uploadRequest = new xwlRequest({
  baseURL:BASE_URL_UPLOAD,
  timeout:TIME_OUT_UPLOAD
})

// 文件下载
export const downRequest = new xwlRequest({
  baseURL:BASE_URL_DOWNLOAD,
  timeout:TIME_OUT_DOWNLOAD
})
