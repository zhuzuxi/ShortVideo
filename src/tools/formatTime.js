export const formatTime = (s) => {
  s = parseInt(s)
  let t
  if (s > -1) {
    let hour = Math.floor(s / 3600)
    let min = Math.floor(s / 60) % 60
    let sec = s % 60
    // 时
    if (hour < 0 || hour == 0) {
      t = ''
    } else if (0 < hour < 10) {
      t = '0' + hour + ':'
    } else {
      t = hour + ':'
    }
    // 分
    if (min < 10) {
      t += '0'
    }
    t += min + ':'
    // 秒
    if (sec < 10) {
      t += '0'
    }
    // 有可能遇到不是整秒的视频,这种情况我让它忽略不计那几毫秒  不知道会有什么 bug 存在,视频播放不完还是快进位置不对呢?  可以不使用 floor ,而是保证传入的时间戳是整数,那就需要 parseInt 处理
    // t += Math.floor(sec)
    t += sec
  }
  return t
}
