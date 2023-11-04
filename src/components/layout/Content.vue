<template>
  <div class="content">
    <div class="left">
      <slot name="left"></slot>
    </div>
    <div class="right">
      <slot name="right"></slot>
    </div>
  </div>
</template>
<script setup></script>
<style scoped lang="less">
.content {
  display: flex;
  height: 100%;

  .left {
    flex: 1;
    display: flex;
    align-items: center;
    flex-direction: column;
    padding: 1.5vw 0 0.2vw;
    border-radius: 0.4vw;
    background-color: #eee;
    overflow-y: scroll;
    height: 80vh;
  }
  // 滚动条样式
  ::-webkit-scrollbar {
    width: 0.3vw;
  }
  ::-webkit-scrollbar-track {
    -webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.1);
    border-radius: 0.5vw;
    background-color: #f5f5f5;
  }
  ::-webkit-scrollbar-thumb {
    border-radius: 0.5vw;
    -webkit-box-shadow: inset 0 0 6px rgb(159, 158, 156);
    background-color: #555;
  }

  .right {
    flex: 8;
    display: flex;
    justify-content: center;
    align-items: center;
    padding: 0.4vh 0.8vw;
    margin-left: 1vw;
    box-sizing: border-box;
    border-radius: 1vw;
    box-shadow: 0 0 0.8vw #969292;
    background-color: #eee;
  }
}
</style>
