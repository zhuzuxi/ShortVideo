<template>
  <div>
    <Content>
      <template #left class="left">
        <a-button
          :type="item.type"
          class="gh_button item"
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

let currentId = ref(1)
const options = ref([
  {
    id: 1,
    name: '推荐',
    type: 'primary'
  },
  {
    id: 2,
    name: '热门',
    type: 'default'
  },
  {
    id: 3,
    name: '体育',
    type: 'default'
  },
  {
    id: 4,
    name: '旅行',
    type: 'default'
  },
  {
    id: 5,
    name: '游戏',
    type: 'default'
  },
  {
    id: 3,
    name: '体育',
    type: 'default'
  },
  {
    id: 4,
    name: '旅行',
    type: 'default'
  },
  {
    id: 5,
    name: '游戏',
    type: 'default'
  },
  {
    id: 3,
    name: '体育',
    type: 'default'
  },
  {
    id: 4,
    name: '旅行',
    type: 'default'
  },
  {
    id: 5,
    name: '游戏',
    type: 'default'
  },
  {
    id: 6,
    name: '户外',
    type: 'default'
  },
  {
    id: 2,
    name: '热门',
    type: 'default'
  },
  {
    id: 3,
    name: '体育',
    type: 'default'
  },
  {
    id: 4,
    name: '旅行',
    type: 'default'
  },
  {
    id: 5,
    name: '游戏',
    type: 'default'
  },
  {
    id: 6,
    name: '户外',
    type: 'default'
  }
])
// 点击切换
const changeItem = (index1) => {
  currentId = index1 + 1 //保存当前选择的分类，用于后续获取视频
  options.value = options.value.map((item, index2) => {
    if (index1 === index2) {
      item.type = 'primary'
    } else {
      item.type = 'default'
    }
    return item //记得要 return
  })
  console.log(currentId)
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
