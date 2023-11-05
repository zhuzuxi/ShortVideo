<template>
  <div class="dialog">
    <div class="box">
      <div class="top">
        <span
          :class="{ pannel: true, isActive: store.isPannalActive }"
          @click="store.changePannal(0)"
          >关注</span
        >
        <span
          :class="{ pannel: true, isActive: !store.isPannalActive }"
          @click="store.changePannal(1)"
          >粉丝</span
        >
        <span class="close" @click="closeDialog">X</span>
      </div>
      <div class="mid">
        <div class="search">
          <a-input class="input_search" placeholder=" 🔍  input your search text" />
        </div>
        <div class="sort">
          <a-select ref="select" placeholder="排序规则" @change="handleChange(index)">
            <a-select-option value="1">时间正序</a-select-option>
            <a-select-option value="2">时间倒序</a-select-option>
          </a-select>
        </div>
      </div>
      <div class="content">
        <div class="item" v-for="(item, index) in itemList">
          <div class="img">头像</div>
          <div class="detail">
            <div class="username">{{ item.username }}</div>
            <div class="btn_list">{{ item.motto }}</div>
          </div>
          <div class="follow">
            <a-button type="primary" v-show="!item.isFollow" @click="changeFollow(item)"
              >关注</a-button
            >
            <a-button
              ref="followed"
              type="primary"
              v-show="item.isFollow"
              :class="{ followed, cancel: item.isCancel }"
              @click="changeFollow(item)"
              @mouseenter="cancelEnter(item)"
              @mouseleave="cancelLeave(item)"
              >{{ item.text }}</a-button
            >
            <!-- 鼠标滑上去展现以下组件 用 v-show  -->
            <!-- <a-button type="primary" danger>取消关注</a-button> -->
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script setup>
import { ref } from 'vue'
import { useBusinessStore } from '@/stores/business.js'

// 从 pinia 中引入 state 和 方法
const store = useBusinessStore()

const isFollow = ref(false) // followed flag
const followed = ref(null) // dom
const follow = ref('已关注') // text
const isCancel = ref(false) //cancel flag

const itemList = ref([
  {
    img: '头像',
    username: '用户名',
    motto: '格言',
    text: '关注',
    isFollow: false,
    isCancel: false
  },
  {
    img: '头像',
    username: '张三',
    motto: '纸上得来终觉浅',
    text: '已关注', // text 于 isFollow 是关联在一起的
    isFollow: true,
    isCancel: false
  },
  {
    img: '头像',
    username: '李四',
    motto: '绝知此事要躬行',
    text: '已关注',
    isFollow: true,
    isCancel: false
  }
])

const changeFollow = (item) => {
  item.isFollow = !item.isFollow
  if (item.isFollow) {
    item.text = '已关注'
  } else {
    item.text = '关注'
  }
}
const cancelEnter = (item) => {
  item.text = '取消关注'
  item.isCancel = true
}
const cancelLeave = (item) => {
  item.text = '已关注'
  item.isCancel = false
}
const closeDialog = () => {
  // 调用 pinia 中的函数控制弹窗的关闭
  store.changeDialog(false)
}
</script>
<style scoped lang="less">
.cancel {
  background-color: rgb(218, 12, 12) !important;
}
.isActive {
  background-color: orange !important;
}
.dialog {
  .box {
    position: absolute;
    left: 50%;
    top: 50%;
    width: 50vw;
    height: 88vh;
    z-index: 2;
    border-radius: 0.8vw;
    background-color: #fff;
    padding: 1vw;
    transform: translateX(-50%) translateY(-50%);
  }

  .top {
    padding: 1vh 0;
    margin-bottom: 1vh;

    > span {
      margin-right: 1.5vw;
      padding: 0.5vw 1vw;
      color: #fff;
      border-radius: 0.5vw;
      cursor: pointer;
      transition: all 0.25s;
      background-color: #ccc;
    }
    .pannel:hover {
      background-color: rgb(191, 175, 144);
    }

    .close {
      float: right;
    }
    .close:hover {
      background-color: rgb(224, 67, 10);
    }
  }
  .mid {
    display: flex;
    align-items: center;
    padding: 1vh 0;

    .search {
      flex: 5;
      margin-right: 2vw;

      .input_search {
        width: 100%;
        height: 6vh;
        text-align: center;
        background-color: rgb(251, 243, 229);
      }
    }
    .sort {
      // flex: 1;
      height: 6vh;
      min-width: 6vw;
      line-height: 6vh;
      padding: 0 0.5vw;
      text-align: center;
      border-radius: 0.8vw;
      background-color: rgb(251, 243, 229);
    }
  }
  .content {
    margin-top: 2vh;
    .item {
      padding: 1vh 2vw;
      display: flex;
      align-items: center;
      border-radius: 0.5vw;
      margin-bottom: 2vh;
      background-color: #ccc;

      .img {
        width: 4vw;
        height: 4vw;
        border-radius: 50%;
        text-align: center; //文字居中，未来头像居中再说
        line-height: 4vw;
        margin-right: 1vw;
        background-color: #fff;
      }
      .detail {
        display: flex;
        flex-direction: column;

        .username {
          padding: 0.5vh 1vw;
          font-size: 1.2vw;
          text-shadow: 0.05vw 0.05vw 0.1vw rgba(0, 0, 0, 0.5);
          border-radius: 0.4vw;
        }
        .btn_list {
          margin-top: 0.5vh;
          padding: 0 1vw;
          border-radius: 0.4vw;
          background-color: #f5eeae;
        }
      }
      .follow {
        flex: 6;
        text-align: right;

        .followed {
          background-color: #aaa;
        }
      }
    }
  }
}
</style>
