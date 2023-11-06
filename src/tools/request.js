import axios from './axios'
let { get } = axios
//获取各省份对应动物接口
/**
 *
 * @param {number} data
 * @returns
 */
export const getRecommend = (data) => get(`/video/recommend?pagenum=${data}`)
export const getToken = () => get(`/video/uploadtoken`)
