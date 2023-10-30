<script setup>
import { RouterLink, RouterView } from 'vue-router'
import Header from '@/components/layout/Header.vue'
</script>

<template>
  <div id="app">
    <Header id="head"></Header>
    <RouterView id="content" />
  </div>
</template>

<style scoped lang="less">
#app {
  padding: 1vw;
  height: 98vh;
  display: flex;
  flex-direction: column;
  box-sizing: border-box;
  background-color: #fff;

  // 分好上下两块区域
  #head {
    height: 10vh;
    margin-bottom: 1.5vh;
    background-color: #fff;
  }

  #content {
    flex: 1;
  }
}
</style>
