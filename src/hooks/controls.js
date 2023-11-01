/**
 *
 * @param
 * video: 表示视频组件,用 ref 获取到的 响应式值
 */

import { ref, onMounted } from 'vue'

export const controls = (video) => {
  // 视频播放暂停
  let doing = ref(false)
  const play = () => {
    if (!doing.value) {
      video.value.play()
      doing.value = true
    } else {
      video.value.pause()
      doing.value = false
    }
  }

  // 音量
  const volume = ref(0)
  // 因为要获取 dom ，所以在 mounted 中初始化音量
  onMounted(() => {
    if (video.value.volume) {
      volume.value = video.value.volume
    }
  })
  const changeVolume = (res) => {
    // 音量是从 0-1 的，所以要 除以 100
    video.value.volume = res / 100
  }

  // 进度条
  const duration = ref(0)
  const currentTime = ref(0)
  // 视频加载完毕后的回调函数,确保能拿到 视频的时长，这在 mounted 不能确保一定拿到
  const videoLoaded = () => {
    if (video.value) {
      currentTime.value = video.value.currentTime
      duration.value = video.value.duration
    }
  }
  const changeTime = (res) => {
    video.value.currentTime = res
  }
  const getCurrentTime = () => {
    // 这样随着视频的播放会不断地触发当前方法,更新当前的值,但总感觉有点延迟不知道有没有影响
    currentTime.value = video.value.currentTime
  }

  return {
    doing,
    volume,
    duration,
    currentTime,
    play,
    changeVolume,
    videoLoaded,
    changeTime,
    getCurrentTime
  }
}
