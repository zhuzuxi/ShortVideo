<template>
  <div>
    <Content>
      <template #left class="left">
        <a-button type="primary" danger class="gh_button back" @click="back"> 返回首页 </a-button>
        <a-button
          :type="item.type"
          class="gh_button"
          v-for="(item, index) in options"
          @click="changeItem(index)"
        >
          {{ item.name }}</a-button
        >
      </template>
      <template #right class="right">
        <div class="person_box">
          <div class="info">
            <div class="imgBox">
              <img class="img" src="@/assets/headImg.jpg" alt="" />
            </div>
            <div class="detail">
              <div class="username">{{ username }}</div>
              <div class="btn_list">
                <a-button type="default" class="btn" @click="follow">关注</a-button>
                <a-button type="default" class="btn" @click="fans">粉丝</a-button>
                <a-button type="dashed" class="btn good">获赞：{{ good }}</a-button>
              </div>
            </div>
          </div>
          <div class="video_box">
            <div class="inser_box">
              <!-- 之后渲染的时候可能需要算法转化一下，就算不够三个视频也可以占位符 -->
              <div class="video_list" v-if="videoList" v-for="item1 in videoList">
                <div class="item" v-for="item2 in item1">
                  <video class="videoBox">
                    <source :src="`${domain}${item2.videoUrl}${eToken}`" />
                  </video>
                </div>
              </div>
            </div>
          </div>
        </div>
      </template>
    </Content>
    <gh-dialog class="dialog" v-if="store.dialogFlag"></gh-dialog>
  </div>
</template>
<script setup>
import Content from '@/components/layout/Content.vue'
import GhDialog from '../components/GhDialog.vue'
import { onMounted, ref } from 'vue'
import { useRouter } from 'vue-router'
import { useBusinessStore } from '@/stores/business.js'
import { getUserWork, getToken } from '@/tools/request.js'

const router = useRouter()
const store = useBusinessStore()

// 左侧
const currentId = ref(1)
const options = ref([
  {
    id: 1,
    name: '作品',
    type: 'primary'
  },
  {
    id: 2,
    name: '点赞',
    type: 'default'
  },
  {
    id: 3,
    name: '收藏',
    type: 'default'
  }
])
// 点击切换
const changeItem = (index1) => {
  currentId.value = index1 + 1 //保存当前选择的分类，用于后续获取视频
  options.value = options.value.map((item, index2) => {
    if (index1 === index2) {
      item.type = 'primary'
    } else {
      item.type = 'default'
    }
    return item //记得要 return
  })
}

// 右侧
const username = ref('桂花')
const good = ref('88')
const videoList = ref([])
// 设置一个算法格式化后端返回的数据
const formatVideo = (data) => {
  // data = [{},{}]
  let list = []

  for (let i = 0; i < data.length; ) {
    let item = []
    item.push(data[i])
    // 补上后续两个，如果为空就返回空对象
    if (i + 1 < data.length) {
      item.push(data[i + 1])
    } else {
      item.push({})
    }
    if (i + 2 < data.length) {
      item.push(data[i + 2])
    } else {
      item.push({})
    }
    list.push(item)
    i = i + 3
  }
  // 返回格式化后的结果
  return list
}
const token = ref('')
const eToken = ref('')
const domain = 'http://s3c51zvtx.hn-bkt.clouddn.com/'

// 获取列表
onMounted(() => {
  getUserWork().then((res) => {
    // let data = res.data [{videoUrl},{}]
    let data = res.data
    // 格式化
    data = formatVideo(data)
    videoList.value = data
  })
  getToken().then((res) => {
    token.value = res.data
    eToken.value = `?e=300&token=${token.value}`
    // console.log(res.data)
  })
})

const follow = () => {
  // 打开面板，并且进入到 关注 页面
  store.changeDialog(true)
  store.changePannal(0)
  console.log('关注')
}
const fans = () => {
  // 打开面板，并且进入到 粉丝 页面
  store.changeDialog(true)
  store.changePannal(1)
  console.log('粉丝')
}
const back = () => {
  router.push('/')
}
</script>
<style scoped lang="less">
.back {
  border-radius: 1vw;
  margin: 1vh 0 5vh;
}
.right {
  .person_box {
    width: 100%;
    height: 100%;
    display: flex;
    flex-direction: column;
    padding: 1vh 0vw;
    box-sizing: border-box;

    .info {
      flex: 1;
      padding: 0 2vw;
      display: flex;
      align-items: center;

      .imgBox {
        width: 4vw;
        height: 4vw;
        border-radius: 50%;
        text-align: center; //文字居中，未来头像居中再说
        line-height: 4vw;
        margin-right: 1vw;
        background-color: #fff;

        .img {
          width: 100%;
          height: 100%;
          border-radius: 50%;
        }
      }
      .detail {
        .username {
          padding: 0.5vh 0;
        }
        .btn_list {
          padding: 0 0 0.5vh;

          .btn {
            padding: 0.5vh;
            margin-right: 0.5vw;
          }
          .good {
            color: #000;
            cursor: default;
            background-color: #fff;
          }
        }
      }
    }
    .video_box {
      flex: 3;
      padding: 2vh 0.8vw;
      border-radius: 0.5vw;
      background-color: #e4c30497;

      .inser_box {
        height: 60vh;
        overflow-y: scroll;
        border-radius: 0.5vw;
        box-sizing: border-box;
      }

      .video_list {
        display: flex;
        margin-bottom: 2vh;
        text-align: center;

        .item {
          flex: 1;
          height: 22vh;
          border-radius: 0.5vw;
          background-color: #e8d463;

          .videoBox {
            width: 100%;
            height: 100%;
            object-fit: cover;
            border-radius: 0.5vw;
          }
        }
        .item:nth-child(1) {
          margin-right: 1vw; //右边距 1vw，因为 flex =1 所以会压缩自己 1vw
        }
        .item:nth-child(2) {
          margin-left: 0.5vw;
          margin-right: 0.5vw; // 为了保持也压缩自己 1vw，所以左右各 0.5vw
        }
        .item:nth-child(3) {
          margin-left: 1vw; // 为了保持也压缩自己 1vw，所以左边距设置为 1vw
        }
      }
    }
  }
}

.dialog {
  position: absolute;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  z-index: 1;
  background-color: #ccccccb4;
}
</style>
