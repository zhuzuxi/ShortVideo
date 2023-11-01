<template>
  <div>
    <Content>
      <template #left class="left">
        <a-button type="primary" class="gh_button"> 热门</a-button>
        <a-button type="default" class="gh_button">推荐</a-button>
        <a-button type="default" class="gh_button">分类</a-button>
      </template>
      <template #right class="right">
        <gh-video></gh-video>
        <!-- <video class="video" controls>
            <source src="@/assets/1.mp4" />
          </video> -->
      </template>
    </Content>
  </div>
</template>
<script setup>
import Content from '@/components/layout/Content.vue'
import ghVideo from '@/components/GhVideo.vue'
</script>
<style scoped lang="less"></style>
