import './assets/main.css'

import { createApp } from 'vue'
import { createPinia } from 'pinia'
// 完整引入
import Antd from 'ant-design-vue'
// import { Button, InputSearch, Textarea } from 'ant-design-vue'

import App from './App.vue'
import router from './router'

const app = createApp(App)

app.use(createPinia())
app.use(router)
app.use(Antd)

app.mount('#app')
