<template>
  <div>
    <a-form :form="form">
         <muti-uploadFile :baseId="baseId"></muti-uploadFile>
      <a-form-item
        label="图片类型"
      >
         <a-radio-group v-decorator="['qtType', {}]">
          <a-radio value="心电图">
           心电图
          </a-radio>
          <a-radio value="胸片">
            胸片
          </a-radio>
           <a-radio value="MRI">
            MRI
          </a-radio>
           <a-radio value="造影/心导管">
            造影/心导管
          </a-radio>
           <a-radio value="肺功能">
            肺功能
          </a-radio>
        </a-radio-group>
      </a-form-item>
    </a-form>
  </div>
</template>

<script>
import MutiUploadFile from '../../common/MutiUploadFile'
export default {
  data () {
    return {
      loading: false,
      form: this.$form.createForm(this),
      csfcInfo: {

      },
      baseId: ''
    }
  },
  mounted () {
    // this.fetch()
  },
 components: {MutiUploadFile} ,
  methods: {
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
    fetch () {
      this.$get('comFile/getUid?time=' + new Date().getTime()).then(res => {
        this.baseId = res.data.data
      })
     // console.log('CsfcInfo Id 创建成功.')
    }
  }
}
</script>

<style>
</style>