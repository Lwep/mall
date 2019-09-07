import axios from 'axios'

// 创建axios实例
const service = axios.create({
     baseURL: 'http://localhost:8002', // api的base_url
    // baseURL: 'http://localhost', // api的base_url
    timeout: 5000 // 请求超时时间
  });

  // request拦截器
service.interceptors.request.use(config => {
    console.log("请求拦截");
    return config
  }, error => {
    return Promise.reject(error);
  })
  
  // respone拦截器
  service.interceptors.response.use(
    response => {
      console.log("响应拦截");
      return response;
    }, error => {
      return Promise.reject(error.response.data)
    })
  
 // 导出对象
  export default service
  