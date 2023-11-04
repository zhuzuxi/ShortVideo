import { ref } from 'vue'
import { defineStore } from 'pinia'

export const useBusinessStore = defineStore('business', () => {
  // 弹窗开启与关闭
  const dialogFlag = ref(false)
  const changeDialog = (data) => {
    /**
     * @param data {true||false} 用于控制是否弹出弹窗
     */
    dialogFlag.value = data
  }
  // 关注与粉丝按钮的切换
  const isPannalActive = ref(true)
  const changePannal = (data) => {
    if (data === 0) {
      isPannalActive.value = true
    } else {
      isPannalActive.value = false
    }
    console.log(isPannalActive)
  }

  return { dialogFlag, changeDialog, isPannalActive, changePannal }
})
