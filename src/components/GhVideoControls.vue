<template>
  <div class="mutual">
    <div class="img">
      <img src="@/assets/headImg.jpg" alt="" />
    </div>
    <div class="item">
      <!-- <LikeOutlined /> -->
      <LikeFilled :class="{ like_active: liked }" @click="changeLike" />
    </div>
    <div class="item">
      <StarFilled :class="{ select_active: selected }" @click="changeSelect" />
    </div>
    <div class="item">
      <SendOutlined />
    </div>
  </div>
</template>
<script setup>
import { LikeOutlined, LikeFilled, StarFilled, SendOutlined } from '@ant-design/icons-vue'
import { ref } from 'vue'

const liked = ref(false)
const selected = ref(false)

const changeLike = () => {
  liked.value = !liked.value
}
const changeSelect = () => {
  selected.value = !selected.value
}
</script>
<style scoped lang="less">
.like_active {
  color: red;
}
.select_active {
  color: orange;
}
.mutual {
  width: 5vw;
  min-height: 35vh;
  font-size: 2vw;
  padding: 0.5vw;
  box-sizing: border-box;
  display: flex;
  flex-direction: column;
  align-items: center;
  border-radius: 0.5vw;
  background-color: rgba(201, 201, 201, 0.6);

  > div {
    margin-top: 1.5vh;
  }
  .img {
    width: 100%;
    height: 100%;
    margin-bottom: 1vh;
    display: flex;
    justify-content: center;
    align-items: center;
    // border-radius: 50%;

    > img {
      width: 100%;
      border-radius: 50%;
      object-fit: contain;
    }
  }
  .item {
    padding: 0.2vw;
    transition-property: all;
    transition-duration: 0.3s;
  }
  .item:hover {
    color: #4096ff;
  }
}
</style>
