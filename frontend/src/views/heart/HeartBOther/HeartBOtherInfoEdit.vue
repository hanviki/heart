<template>
  <div>
    <a-form :form="form">
        <muti-uploadFile :baseId="baseId" :isEdit="isEdit"></muti-uploadFile>
      <a-form-item
        label="图片类型"
      >
        <a-radio-group v-decorator="['qtType', {}]" :options="tpOptions">
        </a-radio-group>
      </a-form-item>
    </a-form>
  </div>
</template>

<script>
import MutiUploadFile from '../../common/MutiUploadFile'
import moment from 'moment'
const tpOptions = [
  { label: '心电图', value: '心电图' },
  { label: '胸片', value: '胸片' },
  { label: 'MRI', value: 'MRI' },
  { label: '造影/心导管', value: '造影/心导管' },
  { label: '肺功能', value: '肺功能' }]
export default {
  props: {
    isEdit: {
      default: true
    },
    checkInfo: {
      default: {}
    }
  },
  data () {
    return {
      loading: false,
      form: this.$form.createForm(this),
      csfcInfo: {
      },
      baseId: '',
      tpOptions
    }
  },
  mounted () {
    this.setFormValues(this.checkInfo)
  },
  components: {MutiUploadFile},
  methods: {
    moment,
    reset () {
      this.loading = false
      this.csfcInfo = {}
      this.form.resetFields()
      this.baseId = ''
    },
    setFields () {
      let values = this.form.getFieldsValue(['qtType'])
      if (typeof values !== 'undefined') {
        Object.keys(values).forEach(_key => {
          if (values[_key] !== undefined) {
            this.csfcInfo[_key] = values[_key]
          }
        })
      }
      this.csfcInfo.id = this.baseId
      return this.csfcInfo
    },
    setFormValues ({ ...checkInfo }) {
      let fields = ['qtType']
      let fieldDates = []
      Object.keys(checkInfo).forEach((key) => {
        if (fields.indexOf(key) !== -1) {
          this.form.getFieldDecorator(key)
          let obj = {}
          if (fieldDates.indexOf(key) !== -1) {
            if (checkInfo[key] !== '' && checkInfo[key] !== null) {
              obj[key] = moment(checkInfo[key])
            } else {
              obj[key] = ''
            }
          } else {
            obj[key] = checkInfo[key]
          }
          this.form.setFieldsValue(obj)
        }
      })
      this.baseId = checkInfo.id
      this.csfcInfo = checkInfo
    }
  }
}
</script>

<style>
</style>
