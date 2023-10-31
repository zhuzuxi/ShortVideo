<template>
  <div>
    <Content>
      <template #left class="left">
        <a-button type="primary" danger class="gh_button back" @click="back"> 返回 </a-button>
        <a-button type="primary" class="gh_button"> 作品</a-button>
        <a-button type="default" class="gh_button">点赞</a-button>
        <a-button type="default" class="gh_button">收藏</a-button>
        <a-button type="default" class="gh_button">历史</a-button>
      </template>
      <template #right class="right">
        <div class="person_box">
          <div class="info">
            <div class="img">头像</div>
            <div class="detail">
              <div class="username">用户名</div>
              <div class="btn_list">
                <a-button type="default" class="btn">关注</a-button>
                <a-button type="default" class="btn">粉丝</a-button>
                <a-button type="dashed" class="btn good">获赞：{{ good }}</a-button>
              </div>
            </div>
          </div>
          <div class="video_box">
            <!-- 之后渲染的时候可能需要算法转化一下，就算不够三个视频也可以占位符 -->
            <div class="video_list">
              <div class="item">11</div>
              <div class="item">11</div>
              <div class="item">11</div>
            </div>
            <div class="video_list">
              <div class="item">11</div>
              <div class="item">11</div>
              <div class="item">11</div>
            </div>
            <div class="video_list">
              <div class="item">11</div>
              <div class="item">11</div>
              <div class="item"></div>
            </div>
          </div>
        </div>
      </template>
    </Content>
  </div>
</template>
<script setup>
import Content from '@/components/layout/Content.vue'
import { ref } from 'vue'
import { useRouter } from 'vue-router'

const router = useRouter()

const good = ref('88')

const back = () => {
  router.back()
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
      height: 100%;
      padding: 2vh 1vw;

      border-radius: 0.5vw;
      overflow-y: scroll;
      background-color: #e4c30497;

      .video_list {
        display: flex;
        margin-bottom: 2vh;
        text-align: center;

        .item {
          flex: 1;
          height: 22vh;
          border-radius: 0.5vw;
          background-color: #efefef;
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
</style>
