/**
 *
 * @param video {HYML DOM} 表示视频组件,用 ref 获取到的 响应式值
 *
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
  let currentVolume = ref(volume.value)
  let isMute = ref(false)
  // 因为要获取 dom ，所以在 mounted 中初始化音量
  onMounted(() => {
    if (video.value.volume) {
      // 因为获取到的音量是 0-1 之间，所以初始化先放大一百倍，给 进度条匹配上
      volume.value = video.value.volume * 100
      currentVolume.value = volume.value
    }
  })
  const changeVolume = (res) => {
    // 音量是从 0-1 的，所以要 除以 100
    video.value.volume = res / 100
    currentVolume.value = res / 100
  }
  const mute = () => {
    // 如果没有静音，就设置为 静音
    if (!isMute.value) {
      currentVolume.value = volume.value //记录当前时间
      volume.value = 0 //同步更改 音量条
      video.value.volume = 0 //实际视频时间归零
      isMute.value = true
    } else {
      video.value.volume = currentVolume.value // 视频时间复原
      volume.value = currentVolume.value // 音量进度条也复原
      isMute.value = false
    }
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
  // 快进
  /**
   *
   * @param flag {boolean} true 表示快进，false 表示快退
   */
  const forward = (flag) => {
    // 快进或者快退
    // flag 为 true 表示 快进
    let time
    if (flag) {
      time = currentTime.value + duration.value / 20 //步进视频长度的二十分之一
    } else {
      time = currentTime.value - duration.value / 20 //步进视频长度的二十分之一
    }
    changeTime(time)
  }
  // 倍速
  const speedPlay = () => {
    // 设置一个定时器，在长按一段时间后触发操作
    isKeyPressed = true
    if (isKeyPressed) {
      timer = setTimeout(() => {
        console.log('长按事件触发！')
        isKeyPressed = false // 让长按只触发一次
      }, 1000) // 设置长按时间，单位为毫秒
    }
  }
  // 全屏
  const fullScn = () => {
    // 全屏打开的是默认的播放器，同时还会和我设置的暂停冲突，有一些小 bug
    video.value.requestFullscreen()
  }

  // 键盘事件
  let isKeyPressed = false //长按
  let timer // 定时器
  //按钮监听键盘
  const keyDown = () => {
    //监听键盘按钮
    document.onkeyup = function (event) {
      const e = event || window.event
      const keyCode = e.keyCode || e.which
      switch (keyCode) {
        case 32: //space
          play()
          break
        case 37: //<-
          forward(false)
          break
        case 38: //↑
          alert('↑')
          break
        case 39: //->
          forward(true)
          break
        case 40: //↓
          alert('↓')
          break
        case 13: //enter
          alert('enter')
          break
        case 77: //enter
          mute()
          break
        default:
          console.log(keyCode)
          break
      }
      if (e && e.preventDefault) {
        e.preventDefault()
      } else {
        window.event.returnValue = false
      }
    }
    // 监听键盘长按
    // document.onkeydown = function (event) {
    //   const e = event || window.event
    //   const keyCode = e.keyCode || e.which
    //   switch (keyCode) {
    //     case 37: //<-
    //       // forward(false)
    //       console.log(keyCode)
    //       break
    //     case 39: //->
    //       speedPlay()
    //       break
    //     default:
    //       console.log(keyCode)
    //       break
    //   }
    //   if (e && e.preventDefault) {
    //     e.preventDefault()
    //   } else {
    //     window.event.returnValue = false
    //   }
    // }
  }

  onMounted(() => {
    // 调用键盘事件监听
    keyDown()
  })

  // 倍速播放
  const selected = ref(1.0)
  const options = ref([
    {
      value: 0.5,
      label: 0.5
    },
    {
      value: 1.0,
      label: 1.0
    },
    {
      value: 2.0,
      label: 2.0
    }
  ])
  const speedChange = () => {
    video.value.playbackRate = selected.value
  }

  return {
    doing,
    volume,
    duration,
    currentTime,
    selected,
    options,
    play,
    changeVolume,
    mute,
    videoLoaded,
    changeTime,
    forward,
    getCurrentTime,
    fullScn,
    speedChange
  }
}
