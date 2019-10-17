import axios from 'axios'
import { getToken } from '@/utils/store.js'

// 创建axios实例
const service = axios.create({

  baseURL: 'http://192.168.0.186', // api的base_url
  timeout: 5000 // 请求超时时间
});

// request拦截器
service.interceptors.request.use(config => {
  if (config.url.indexOf('/login') == -1) {
    //console.log(getToken())
    config.headers["admin_token"] = getToken();
  }
  return config
}, error => {
  return Promise.reject(error);
})

// respone拦截器
service.interceptors.response.use(
  response => {
    //console.log("响应拦截");
    return response;
  }, error => {
    return Promise.reject(error)
  })

// 导出对象
export default service