import { onMounted, ref } from 'vue'

import { getToken } from '@/tools/request.js'

const token = ref('')
const eToken = ref('')
const domain = 'http://s3c51zvtx.hn-bkt.clouddn.com/'

getToken().then((res) => {
  token.value = res.data
  eToken.value = `?e=300&token=${token.value}`
  console.log(res.data)
})

import * as qiniu from 'qiniu-js'
export const useUpload = () => {
  // 文件上传
  const videoUrl = ref('')
  const imgUrl = ref('')
  /**
   * @param file {file} 上传后获取到的文件对象
   * @param flag {boolean} true 表示视频上传，false 表示图片上传,默认视频上传
   */
  const customRequestHandler = (file, flag = true) => {
    // 文件上传
    // 初始化七牛云的上传器
    const config = {
      useCdnDomain: true,
      region: qiniu.region.z2,
      disableStatisticsReport: false,
      retryCount: 6
    }
    const putExtra = {
      fname: '',
      params: {},
      mimeType: null
    }
    const observer = {
      next(res) {
        // 上传进度中的信息
        console.log('上传中：', res.total)
      },
      error(err) {
        console.log('上传失败：', err)
      },
      complete(res) {
        if (flag) {
          videoUrl.value = `${domain}${res.key}${eToken.value}`
          // 视频的地址在七牛云中似乎是直接下载的，需要额外获取下载权限 现在视频又可以了，似乎需要通过审核才能访问
          // 其他图片上传的也会这样，不知道为什么：401 (Unauthorized)
        } else {
          imgUrl.value = `${domain}${res.key}${eToken.value}`
        }
        // console.log('上传成功：', res)
      }
    }
    const observable = qiniu.upload(file, file.name, token.value, putExtra, config)
    // // 上传开始
    const subscription = observable.subscribe(observer)
  }

  const postInput = ref('')
  const uploadPost = () => {
    // 图片上传 自定义
    postInput.value.click() //点击文件上传呼出文件选择
  }
  const postChange = () => {
    console.log(postInput.value.files[0]) //上传后的文件
    customRequestHandler(postInput.value.files[0], false)
  }

  // 视频上传
  const videoInput = ref('')
  const uploadVideo = () => {
    videoInput.value.click()
  }
  const videoChange = () => {
    console.log(videoInput.value.files[0]) //上传后的文件
    customRequestHandler(videoInput.value.files[0], true)
  }
  const deleteUrl = (flag) => {
    console.log('shanchu')
    if (flag) {
      videoUrl.value = ''
    } else {
      imgUrl.value = ''
    }
  }
  return {
    videoUrl,
    imgUrl,
    postInput,
    videoInput,
    customRequestHandler,
    uploadPost,
    postChange,
    uploadVideo,
    videoChange,
    deleteUrl
  }
}
