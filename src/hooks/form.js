import { ref, reactive, computed, toRaw } from 'vue'
import { Form } from 'ant-design-vue'

export const useForm = () => {
  // 表单相关
  const formRef = ref('')
  const useForm = Form.useForm
  const videoArea = ref(['旅游', '体育', '生活', '娱乐'])
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
  const selectedChange = (value) => {
    formState.selected = value
  }
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

  return {
    formRef,
    videoArea,
    formState,
    rules,
    helpMsg,
    myValidate,
    submit,
    resetForm,
    selectedChange
  }
}
