import axios from 'axios'
axios.defaults.baseURL = 'http://47.113.144.50:8080' //baseURL
//post请求头
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8'
//设置超时
axios.defaults.timeout = 15000
axios.interceptors.request.use(
  (config) => {
    return config
  },
  (error) => {
    return Promise.reject(error)
  }
)

axios.interceptors.response.use(
  (response) => {
    if (response.status == 200) {
      return Promise.resolve(response)
    } else {
      return Promise.reject(response)
    }
  },
  (error) => {
    alert(JSON.stringify(error), '请求异常', {
      confirmButtonText: '确定',
      callback: (action) => {
        console.log(action)
      }
    })
  }
)
export default {
  /**
   * @param {String} url
   * @param {Object} data
   * @returns Promise
   */
  post(url, data) {
    return new Promise((resolve, reject) => {
      axios({
        method: 'post',
        url,
        data: qs.stringify(data)
      })
        .then((res) => {
          resolve(res.data)
        })
        .catch((err) => {
          reject(err)
        })
    })
  },

  get(url) {
    return new Promise((resolve, reject) => {
      axios({
        method: 'get',
        url
      })
        .then((res) => {
          resolve(res.data)
        })
        .catch((err) => {
          reject(err)
        })
    })
  }
}
