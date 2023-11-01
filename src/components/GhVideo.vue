<template>
  <div class="video_box">
    <!-- 视频 -->
    <video
      class="video"
      ref="video"
      @click="play"
      @loadedmetadata="videoLoaded"
      @timeupdate="getCurrentTime"
      loop
    >
      <source src="@/assets/2.mp4" />
    </video>

    <!-- 控件  -->
    <div class="controls">
      <!-- 视频进度条 -->
      <a-slider
        v-model:value="currentTime"
        class="process"
        :tip-formatter="null"
        :max="duration"
        @change="changeTime"
      />
      <!-- 暂停、播放、音量选择、快进、快退 -->
      <div class="other">
        <div class="basic">
          <FastBackwardOutlined class="item" />
          <template v-if="doing">
            <PauseCircleOutlined class="item" @click="play" />
          </template>
          <template v-else>
            <PlayCircleOutlined class="item" @click="play" />
          </template>
          <FastForwardOutlined class="item" />
        </div>
        <div class="volume">
          <div class="time_data item">
            <span>{{ formatTime(currentTime) }}</span>
            <span>-</span>
            <span>{{ formatTime(duration) }}</span>
          </div>

          <!-- 如果音量为0就换成透明的图标 -->
          <SoundOutlined v-if="!volume" class="item" />
          <SoundFilled v-else class="item" />
          <a-slider class="vol_line" id="test" v-model:value="volume" @change="changeVolume" />
        </div>
      </div>
    </div>
    <!-- 暂停时显示在屏幕中间的 -->
    <div class="show_pause" v-if="!doing">
      <CaretRightOutlined @click="play" />
    </div>
  </div>
</template>
<script setup>
import {
  PauseCircleOutlined,
  PlayCircleOutlined,
  FastForwardOutlined,
  FastBackwardOutlined,
  CaretRightOutlined,
  SoundOutlined,
  SoundFilled
} from '@ant-design/icons-vue'
import { formatTime } from '@/tools/formatTime.js'
import { ref, onMounted } from 'vue'
// 播放、暂停、进度条、音量变化等 逻辑处理都在controls 中
import { controls } from '@/hooks/controls.js'

const video = ref('')
const {
  doing,
  volume,
  duration,
  currentTime,
  play,
  changeVolume,
  videoLoaded,
  changeTime,
  getCurrentTime
} = controls(video)
// console.log(controls(video))
</script>
<style scoped lang="less">
.video_box {
  width: 100%;
  height: 100%;
  position: relative;

  .video {
    width: 100%;
    height: 92%;
    // 视频边框，因为底色与背景一致就不需要了
    // border-radius: 2vw;
    // background-color: #fff;

    position: absolute;
    top: 0;
    right: 0;
    object-fit: contain; // 随高度自适应，两边适当留白
  }
  .controls {
    position: absolute;
    left: 0;
    bottom: 0;
    width: 100%;
    z-index: 1;
    margin-top: 2vh;
    // background-color: pink;

    // 进度条
    .process {
    }

    .other {
      margin-top: -1vh; // 与进度条拉近一些
      // 用定位，让 音量 控件与播放暂停在同一行
      position: relative;

      .item {
        margin-right: 0.5vw;
      }

      .basic {
        width: 100%;
        text-align: center;
        font-size: 1.5vw;
        box-sizing: border-box;
      }
      .volume {
        position: absolute;
        top: 0;
        right: 0;
        display: flex;
        align-items: center;
        justify-content: end;

        .time_data {
          > span {
            margin-right: 0.2vw;
          }
        }

        .vol_line {
          width: 10vw;
        }
      }
    }
  }
  .show_pause {
    position: absolute;
    left: 50%;
    top: 50%;
    color: orange;
    font-size: 10vw;
    opacity: 0.75;
    transform: translateX(-50%) translateY(-50%);
  }
}
</style>
