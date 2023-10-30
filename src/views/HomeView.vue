<template>
  <div>
    <Content>
      <template #left class="left">
        <a-button type="primary" class="gh_button"> 热门</a-button>
        <a-button type="default" class="gh_button">推荐</a-button>
        <a-button type="default" class="gh_button">分类</a-button>
      </template>
      <template #right class="right">
        <div class="video_box">
          <video class="video" controls>
            <source src="@/assets/1.mp4" />
          </video>
        </div>
      </template>
    </Content>
  </div>
</template>
<script setup>
import Content from '@/components/layout/Content.vue'
</script>
<style scoped lang="less">
.left > .gh_button {
  min-width: 6vw;
  margin-bottom: 1.5vw;
}
.gh_button {
  border-radius: 0.4vw;
}

.right > .video_box {
  width: 100%;
  height: 100%;
  border-radius: 1vw;
  padding: 0.5vw;
  box-sizing: border-box;
  position: relative;
  // backdrop-filter: blur(6px);
  background-color: #eee;
  box-shadow: 0 0 0.8vw #969292;

  .video {
    width: 100%;
    height: 100%;
    position: absolute;
    top: 0;
    left: 0;
    object-fit: contain; // 随高度自适应，两边适当留白
  }
}
</style>
