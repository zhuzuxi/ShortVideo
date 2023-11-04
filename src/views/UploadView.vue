<template>
  <div>
    <Content>
      <template #left class="left">
        <a-button type="primary" danger class="gh_button back" @click="back"> 返回 </a-button>
      </template>
      <template #right class="right">
        <div class="upload">
          <div class="select">
            <div class="video_upload">
              <a-upload-dragger
                v-model:fileList="fileList"
                name="file"
                action=""
                @change="handleChange"
              >
                <p class="ant-upload-drag-icon">搞个图标 -- 视频</p>
                <p><DeleteColumnOutlined /></p>
                <p class="ant-upload-text">单击或拖动 视频 到此区域进行上传</p>
                <p class="ant-upload-hint">仅支持上传单个文件，格式为 mp4</p>
              </a-upload-dragger>
            </div>
            <div class="post_upload">
              <a-upload-dragger
                v-model:fileList="fileList"
                name="file"
                action=""
                @change="handleChange"
              >
                <p class="ant-upload-drag-icon">搞个图标 -- 图片</p>
                <p><DeleteColumnOutlined /></p>
                <p class="ant-upload-text">单击或拖动 图片 到此区域进行上传</p>
                <p class="ant-upload-hint">仅支持上传单个文件，格式为 JPEG、PNG</p>
              </a-upload-dragger>
            </div>
          </div>
          <div class="info">
            <div class="simple_imput">
              <a-input placeholder="请输入标题" />
            </div>
            <div class="text_area">
              <a-textarea v-model:value="value1" placeholder="给它添加一个简介吧~" auto-size />
            </div>

            <div class="simple_imput">
              <a-input placeholder="请设置标签，格式如：#标签" />
            </div>

            <div class="address">
              <div class="control">
                <span>是否显示ip：</span><a-switch v-model:checked="checked" />
              </div>
              <div class="select">
                <a-select
                  v-model:selected="selected"
                  @change="handleChange"
                  placeholder="请选择视频分区"
                >
                  <a-select-option v-for="item in videoArea" :value="item">{{
                    item
                  }}</a-select-option>
                </a-select>
              </div>
            </div>

            <!-- 上传按钮 -->
            <a-button class="submit" type="primary">上传</a-button>
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

const checked = ref(false)
const router = useRouter()
const selected = ref('')
const videoArea = ref(['旅游', '体育', '生活', '娱乐'])

const handleChange = (value) => {
  selected.value = value // 这样才能修改成功
}
const back = () => {
  router.back()
}
</script>
<style scoped lang="less">
.back {
  border-radius: 1vw;
  margin: 1vh 0 5vh;
}
.right > .upload {
  width: 100%;
  height: 100%;
  display: flex;

  .select {
    flex: 6;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    padding: 2vh 0;
    margin-right: 1vw;

    .video_upload {
      flex: 1;
      width: 100%;
      border-radius: 0.5vw;
      background-color: #b2b1b1;
    }
    .post_upload {
      flex: 1;
      width: 100%;
      margin-top: 2vh;
      border-radius: 0.5vw;
      background-color: #c1c1c1;
    }
  }
  .info {
    flex: 4;
    padding: 1vh 0;
    display: flex;
    align-items: center;
    flex-direction: column;

    > div {
      width: 88%;
      padding: 0.4vw 0.35vw;
      margin-top: 4vh;
      background-color: orange;
      border-radius: 0.5vw;
    }
    .simple_imput {
    }
    .address {
      display: flex;
      align-items: center;
      // justify-content: space-between;
      background-color: #eee;

      .control {
        width: 10vw;
        color: #fff;
        text-align: center;
        padding: 0.4vw 0.35vw;
        border-radius: 0.5vw;
        font-weight: 600;
        margin-right: 6vw;
        background-color: orange;
      }
      .select {
        padding: 0.4vw 0.35vw;
        border-radius: 0.5vw;
        text-align: center;
        background-color: orange;
      }
    }
    .submit {
      bottom: 8vh;
      min-width: 10vw;
      position: absolute;
      background-color: orange;
    }
  }
}
</style>
