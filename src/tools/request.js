import axios from './axios'
let { get } = axios
//获取各省份对应动物接口
/**
 *
 * @param {number} data
 * @returns
 */
export const getRecommend = (data) => get(`/video/recommend?pagenum=${data}`)
export const getVideoFlag = (data, falg) => get(`/video/videos/flags?pagenum=${data}&flag=${falg}`)

export const getToken = () => get(`/video/uploadtoken?bucket=xzqmsgh`)

export const getCategory = () => get(`/category/list`)

export const getUserWork = () => get(`/user/getMyWorks/2`)
// export const getCategory = () => get(`/category/list`)
