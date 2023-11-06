/**
 *
 * @param video {HYML DOM} 表示视频组件,用 ref 获取到的 响应式值
 *
 */
import { getRecommend } from '@/tools/request.js'
import { ref, onMounted, onUnmounted } from 'vue'
import { message } from 'ant-design-vue'

export const controls = (video) => {
  // 视频播放暂停
  const doing = ref(false)
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

  // const route = useRoute()
  // 节流函数
  const throttle = (func, delay, falg = true) => {
    let lastCallTime = 0 // 上次调用的时间戳
    return function (...args) {
      const now = Date.now()
      if (now - lastCallTime >= delay) {
        func.apply(this, args)
        lastCallTime = now
      } else {
        // 如果 flag 为true 就展示这个提示，如果为false就不弹，用于滚轮
        if (falg) {
          message.success('视频跟不上您的手速啦~', 0.8)
        }
      }
    }
  }
  // 视频切换
  const videoList = ref([
    {
      video: {
        videoUrl: 'https://m.huanqiu.com/article/4FFAcORXyWG'
      }
    },
    {
      video: {
        videoUrl: 'https://m.huanqiu.com/article/4FF7qXziTHO'
      }
    }
  ])
  const videoShow = ref(true)
  const index = ref(1)
  const cur = ref(0)
  const changeVideoDown = () => {
    // 先做键盘切换视频
    if (doing.value === false) {
      doing.value = true
    }
    if (cur.value + 1 < videoList.value.length) {
      cur.value += 1
      video.value.src = videoList.value[cur.value].video.videoUrl
      video.value.load()
      video.value.play()
    } else {
      // 如果长度相等了就请求下一页的视频，添加到视频列表中
      // 请求下一页
      // 重新调用 changeVideo 一次
      // console.log(video.value)
      // console.log('请求下一页') 服务器挂了，先还原
      // index.value += 1
      // getRecommendList(index)
      // cur.value += 1
      cur.value = 0
      video.value.src = videoList.value[cur.value].video.videoUrl
      video.value.load()
      video.value.play()
    }
  }
  const changeVideoUp = () => {
    // 先做键盘切换视频
    if (doing.value === false) {
      doing.value = true
    }
    if (cur.value - 1 >= 0) {
      cur.value -= 1
      video.value.src = videoList.value[cur.value].video.videoUrl
      video.value.load()
      video.value.play()
    } else {
      // 请求下一页
      // index.value += 1
      // getRecommendList(index,false)
      // cur.value = 29
      cur.value = videoList.value.length - 1
      video.value.src = videoList.value[cur.value].video.videoUrl
      video.value.load()
      video.value.play()
    }
  }
  // 键盘切换
  const videoDown = throttle(changeVideoDown, 500)
  const videoUp = throttle(changeVideoUp, 500)
  // 键盘事件
  let isKeyPressed = false //长按
  // let timer // 定时器
  //按钮监听键盘
  const keyDown = (event) => {
    //监听键盘按钮
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
        videoUp()
        break
      case 39: //->
        forward(true)
        break
      case 40: //↓
        videoDown()
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
  // 滚轮切换
  const switchVideo = (direction) => {
    // 根据滚动方向切换视频
    if (direction === 'up') {
      console.log('滚轮向上')
      // changeVideoUp()
    } else if (direction === 'down') {
      console.log('滚轮向下')
      // changeVideoDown()
    }
  }
  const mySwitchVideo = throttle(switchVideo, 600, false)
  const scollEvent = (event) => {
    if (event.deltaY < 0) {
      mySwitchVideo('up') // 向上滚动
    } else if (event.deltaY > 0) {
      mySwitchVideo('down') // 向下滚动
    }
  }

  onMounted(() => {
    // 调用键盘事件监听
    document.addEventListener('keyup', keyDown)
    document.addEventListener('wheel', scollEvent)
  })
  onUnmounted(() => {
    document.removeEventListener('keyup', keyDown)
    document.removeEventListener('wheel', scollEvent)
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

  const getRecommendList = (id, flag = true) => {
    getRecommend(id).then((res) => {
      // console.log(res)
      if (flag) {
        videoList.value.push(...res.data)
      } else {
        // 如果 flag 为 false 表示按了 上 键，这时就要从头插入视频
        videoList.value.unshift(...res.data)
      }
    })
  }

  // 对接接口
  onMounted(() => {
    // getRecommendList(index.value)
  })

  return {
    video,
    doing,
    volume,
    duration,
    currentTime,
    selected,
    options,
    videoList,
    cur,
    videoShow,
    play,
    changeVolume,
    mute,
    videoLoaded,
    changeTime,
    forward,
    getCurrentTime,
    fullScn,
    speedChange,
    changeVideoDown,
    changeVideoUp
  }
}
