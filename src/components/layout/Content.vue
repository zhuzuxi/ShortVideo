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
    padding: 1vw 0;
    border-radius: 0.4vw;
    background-color: #eee;
  }
  .right {
    flex: 9;
    display: flex;
    justify-content: center;
    align-items: center;
    padding: 0.4vh 0.8vw;
  }
}
</style>
