<template>
  <div>
    <a-form :form="form">
         <muti-uploadFile :baseId="baseId"></muti-uploadFile>
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
const tpOptions = [
  { label: '心电图', value: '心电图' },
  { label: '胸片', value: '胸片' },
  { label: 'MRI', value: 'MRI' },
  { label: '造影/心导管', value: '造影/心导管' },
  { label: '肺功能', value: '肺功能' }]
export default {
  props: {
    baseId: {
      default: {}
    }
  },
  data () {
    return {
      loading: false,
      form: this.$form.createForm(this),
      csfcInfo: {

      },
      tpOptions
    }
  },
  mounted () {
    // this.fetch()
  },
  components: {MutiUploadFile},
  methods: {
    reset () {
      this.loading = false
      this.csfcInfo = {}
      this.form.resetFields()
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
    }
  }
}
</script>

<style>
</style>
