<template>
  <div class="header">
    <div class="logo">小🐖骑🐎赏桂❀</div>
    <!-- <div class="logo">
      <img src="@/assets/logo.jpg" alt="" />
    </div> -->
    <div class="search">
      <a-input
        v-model:value="value"
        class="input_search"
        placeholder=" 🔍  input your search text"
      />
    </div>
    <div class="right">
      <div class="upload" @click="toUpload">+</div>
      <!-- 登录或者个人中心 可以放个组件 -->
      <!-- <div class="person gh_button">登录</div> -->
      <a-button class="person" @click="toPerson">登录</a-button>
    </div>
  </div>
</template>
<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'
const router = useRouter()
const value = ref('')

const toUpload = () => {
  router.push('/upload')
}
const toPerson = () => {
  router.push('/person')
}

const onSearch = (searchValue) => {
  console.log('use value', searchValue)
  console.log('or use this.value', value.value)
}
</script>
<style scoped lang="less">
.header {
  display: flex;
  padding: 0.5vw 0;
  box-sizing: border-box;
  justify-content: space-between;

  .logo {
    display: flex;
    align-items: center;
    border-radius: 0.6vw;
    padding: 0 0.8vw;
    // width: 11vw;
    background-color: gold;
  }
  .logo > img {
    height: 100%;
    object-fit: contain;
  }
  .search {
    display: flex;
    align-items: center;

    .input_search {
      width: 26vw;
      height: 6vh;
      background-color: rgb(251, 243, 229);
    }
  }
  .right {
    display: flex;
    align-items: center;

    .upload {
      margin-right: 1.2vw;
      border-radius: 50%;
      width: 2vw;
      height: 2vw;
      text-align: center;
      line-height: 1.7vw;
      font-size: 2vw;
      background-color: gold;
    }
    .upload:hover {
      cursor: pointer;
    }
    .person {
      padding: 0 1.2vw;
      background-color: gold;
    }
  }
}
</style>
