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
              <a-upload-dragger name="video" class="video" :customRequest="customRequestHandler">
                <p class="ant-upload-text">视频上传</p>
                <p class="ant-upload-hint">仅支持上传单个文件，格式为 mp4</p>
              </a-upload-dragger>
            </a-form-item>
            <a-form-item class="post_upload">
              <a-upload-dragger name="file" :customRequest="uploadPost">
                <p><DeleteColumnOutlined /></p>
                <p class="ant-upload-text">图片上传</p>
                <p class="ant-upload-hint">仅支持上传单个文件，格式为 JPEG、PNG</p>
              </a-upload-dragger>
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
                  @change="handleChange"
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

import { ref, reactive, computed, toRaw } from 'vue'
import { useRouter } from 'vue-router'
import { Form, message } from 'ant-design-vue'
import * as qiniu from 'qiniu-js'

const router = useRouter()
// const checked = ref(false)
// const selected = ref('')
const title = ref('')
const profile = ref('')
const subTitle = ref('')
const videoArea = ref(['旅游', '体育', '生活', '娱乐'])

// 表单相关
const formRef = ref('')
const useForm = Form.useForm
const formState = reactive({
  title: '',
  subTitle: '',
  profile: '',
  checked: false,
  selected: false
})
const rules = {
  title: [
    {
      required: true,
      message: 'Please input title',
      trigger: 'change'
    }
  ],
  subTitle: [
    {
      required: true,
      message: 'Please input subTitle',
      trigger: 'change'
    }
  ],
  profile: [
    {
      required: true,
      message: 'Please input profile',
      trigger: 'change'
    }
  ]
}

// let validatePass =

const { resetFields, validate } = useForm(formState, rules)
const helpMsg = ref({})

const myValidate = (e) => {
  // console.log(e)
  validate()
    .then(() => {
      helpMsg.value = []
      console.log(helpMsg.value)
      console.log(toRaw(formState))
    })
    .catch((err) => {
      helpMsg.value = []
      const errs = err.errorFields
      for (let item in errs) {
        helpMsg.value[errs[item].name] = errs[item].errors[0]
      }
      console.log(helpMsg.value)
    })
}

const submit = () => {
  myValidate()
}
const resetForm = () => {
  formRef.value.resetFields()
}

const handleChange = (value) => {
  formState.selected = value
}
const back = () => {
  router.push('/')
}

// 文件上传
const token =
  'w3VdBuR5aZoHP-v3NIjNJiOh0DwEq5Fh9EtQj1rM:CQVqAh1ZCVRZhr5ahdgUkGiIpw4=:eyJzY29wZSI6Inh6cW1zZ2giLCJkZWFkbGluZSI6MTY5OTIwODY3Mn0='s

const customRequestHandler = (info) => {
  // 文件上传 自定义
  // console.log(info.file.name)
  // info.file.status = 'uploading'
  // 初始化七牛云的上传器
  const config = {
    useCdnDomain: true,
    region: qiniu.region.z2,
    disableStatisticsReport: false,
    retryCount: 6
  }
  const putExtra = {
    fname: '',
    params: {},
    mimeType: null
  }
  const observer = {
    next(res) {
      // 上传进度中的信息
      console.log('上传中：', res.total)
    },
    error(err) {
      info.file.status = 'done'
      console.log('上传失败：', err)
    },
    complete(res) {
      info.file.status = 'done'
      console.log('上传成功：', res)
    }
  }
  // const observable = qiniu.upload(info.file, info.file.name, token, putExtra, config)
  // // 上传开始
  // const subscription = observable.subscribe(observer)
}

const uploadPost = (info) => {
  // 图片上传 自定义
}
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
      width: 100%;
      border-radius: 0.5vw;
      background-color: #b2b1b1;

      /deep/.ant-upload-btn {
        padding: 6vh 0;
      }
    }
    /deep/.ant-upload-btn {
      padding: 5vh 0;
    }
    .post_upload {
      width: 100%;
      margin-top: 1vh;
      border-radius: 0.5vw;
      background-color: #c1c1c1;
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
