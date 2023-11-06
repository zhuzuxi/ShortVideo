<template>
  <div>
    <Content>
      <template #left class="left">
        <a-button type="primary" danger class="gh_button back" @click="back"> 返回首页 </a-button>
      </template>
      <template #right class="right">
        <a-form
          class="upload"
          name="upload"
          ref="formRef"
          :model="formState"
          :rules="rules"
          @submit="handleSubmit"
        >
          <div class="select">
            <a-form-item class="video_upload" has-feedback>
              <div class="upload_button" @click="uploadVideo">
                <a-button type="primary">上传视频</a-button>
              </div>
              <input type="file" ref="videoInput" class="video" @change="videoChange" />
              <video controls class="video_box" v-if="videoUrl !== ''">
                <source :src="videoUrl" />
              </video>
              <a-button
                type="primary"
                class="delete"
                danger
                v-if="videoUrl !== ''"
                @click="deleteUrl(true)"
                >删除</a-button
              >
            </a-form-item>
            <a-form-item class="post_upload">
              <div class="upload_button" @click="uploadPost">
                <a-button type="primary">上传封面</a-button>
              </div>
              <input type="file" ref="postInput" class="post" @change="postChange" />
              <img class="post_img" :src="imgUrl" alt="" />
              <a-button
                type="primary"
                class="delete"
                danger
                v-if="imgUrl !== ''"
                @click="deleteUrl(false)"
                >删除</a-button
              >
            </a-form-item>
          </div>
          <div class="info">
            <a-form-item
              ref="title"
              :name="formState.title"
              :help="helpMsg.title"
              @input="myValidate"
            >
              <a-input v-model:value="formState.title" placeholder="请输入标题" />
            </a-form-item>
            <a-form-item name="subTitle" :help="helpMsg.subTitle" @input="myValidate">
              <a-input v-model:value="formState.subTitle" placeholder="请设置标签，格式如：#标签" />
              <!-- <a-alert message="请注意格式" type="error" closable @close="onClose" /> -->
            </a-form-item>
            <a-form-item name="profile" :help="helpMsg.profile" @input="myValidate">
              <a-textarea
                v-model:value="formState.profile"
                placeholder="给它添加一个简介吧~"
                auto-size
              />
            </a-form-item>
            <div class="address">
              <a-form-item class="control">
                <span>是否显示ip：</span><a-switch v-model:checked="formState.checked" />
              </a-form-item>
              <a-form-item class="select">
                <a-select
                  v-model:selected="formState.selected"
                  @change="selectedChange"
                  placeholder="请选择视频分区"
                >
                  <a-select-option v-for="item in videoArea" :value="item">{{
                    item
                  }}</a-select-option>
                </a-select>
              </a-form-item>
            </div>

            <!-- 上传按钮 -->
            <div class="btn">
              <a-button class="submit" type="primary" @click="submit">上传</a-button>
              <a-button class="reset" type="primary" @click="resetForm">重置</a-button>
            </div>
          </div>
        </a-form>
      </template>
    </Content>
  </div>
</template>
<script setup>
import Content from '@/components/layout/Content.vue'
import { useForm } from '@/hooks/form.js'
import { useUpload } from '@/hooks/upload.js'
import { ref, reactive, computed, toRaw } from 'vue'
import { useRouter } from 'vue-router'
import * as qiniu from 'qiniu-js'

const router = useRouter()

const back = () => {
  router.push('/')
}

const {
  formRef,
  videoArea,
  formState,
  rules,
  helpMsg,
  myValidate,
  submit,
  resetForm,
  selectedChange
} = useForm()

const {
  videoUrl,
  imgUrl,
  postInput,
  videoInput,
  customRequestHandler,
  uploadPost,
  postChange,
  uploadVideo,
  videoChange,
  deleteUrl
} = useUpload()
</script>

<style scoped lang="less">
.back {
  border-radius: 1vw;
  margin: 1vh 0 5vh;
}
/deep/.ant-form-item-explain {
  padding: 0 2vh;
  margin-top: 1vh;
  border-radius: 0.3vw;
  color: red !important;
  background-color: #e4d9d9;
}
.right > .upload {
  width: 100%;
  height: 100%;
  display: flex;

  .select {
    flex: 6;
    display: flex;
    flex-direction: column;
    // justify-content: space-between;
    padding: 2vh 0 0;
    margin-right: 1vw;

    .video_upload {
      flex: 1;
      width: 100%;
      margin-top: 1vh;
      padding-top: 2vh;
      border-radius: 0.5vw;
      box-sizing: border-box;
      text-align: center;
      background-color: #b2b1b1;

      .video {
        display: none;
      }
      .upload_button {
        text-align: center;
      }
      .video_box {
        height: 30vh;
        margin-top: 1vh;
        object-fit: contain;
      }
      .delete {
        position: absolute;
        right: 4vh;
        bottom: 4vh;
        padding: 0 4vh;
      }
    }
    .post_upload {
      flex: 1;
      width: 100%;
      padding-top: 2vh;
      border-radius: 0.5vw;
      box-sizing: border-box;
      text-align: center;
      background-color: #c1c1c1;

      .upload_button {
        text-align: center;
      }
      .post {
        margin: 2vw;
        display: none;
        box-sizing: border-box;
      }

      .post_img {
        margin: 1vh 0;
        height: 30vh;
        object-fit: contain;
        background-color: pink;
      }
      .delete {
        position: absolute;
        right: 4vh;
        bottom: 4vh;
        padding: 0 4vh;
      }
    }
  }
  .info {
    flex: 4;
    padding: 1vh 0;
    margin-top: 4vh;
    display: flex;
    align-items: center;
    position: relative;
    flex-direction: column;

    > div {
      width: 88%;
      margin-top: 1vh;
      padding: 0.4vw 0.35vw;

      background-color: orange;
      border-radius: 0.5vw;
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
    .btn {
      position: absolute;
      bottom: 8vh;
      display: flex;
      justify-content: center;
      background-color: #eee;

      .submit {
        min-width: 10vw;
        transition: all 0.5s;
        background-color: orange;
      }
      .reset {
        margin-left: 2vw;
        min-width: 5vw;
        background-color: rgb(233, 16, 16);
      }
      .submit:hover {
        border: 0.3vh solid skyblue;
        box-sizing: border-box;
      }
    }
  }
}
</style>
