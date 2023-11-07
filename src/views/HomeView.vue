<template>
  <div>
    <Content>
      <template #left class="left">
        <a-button
          :type="item.type"
          class="gh_button item"
          v-if="options"
          v-for="(item, index) in options"
          @click="changeItem(index)"
        >
          {{ item.name }}</a-button
        >
      </template>
      <template #right class="right">
        <gh-video></gh-video>
      </template>
    </Content>
  </div>
</template>
<script setup>
import Content from '@/components/layout/Content.vue'
import ghVideo from '@/components/GhVideo.vue'
import { ref } from 'vue'
import { getCategory } from '@/tools/request.js'
import { useBusinessStore } from '@/stores/business.js'

let currentId = ref(0)
const options = ref([])
getCategory().then((res) => {
  // 拿到数据后格式化一下
  let data = res.data
  data = data.map((item) => {
    item.type = 'default'
    return item
  })
  data[0].type = 'primary'
  options.value = data
})
// 点击切换
const changeItem = (index1) => {
  currentId.value = index1 //保存当前选择的分类，用于后续获取视频
  options.value = options.value.map((item, index2) => {
    if (index1 === index2) {
      item.type = 'primary'
    } else {
      item.type = 'default'
    }
    return item //记得要 return
  })
  // 调用接口获取视频
  const store = useBusinessStore()
  store.changeFlag(options.value[index1 + 1].name)
}

// 分类
</script>
<style scoped lang="less">
.item:nth-child(2) {
  margin-bottom: 3vh;
}
.item:nth-child(-n + 2) {
  background-color: rgb(243, 179, 191);
}
/deep/.ant-btn-primary {
  background-color: #1677ff !important;
}
</style>
