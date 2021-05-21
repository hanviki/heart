<template>
  <div>
    <a-form :form="form">
      <a-form-item
        v-bind="formItemLayout"
        label="D二聚体"
      >
        <a-input
          placeholder="请输入D二聚体"
          v-decorator="['d2jt', {rules:[{max:100,message:'最长不超过100'}]}]"
        />
      </a-form-item>
      <a-form-item
        v-bind="formItemLayout"
        label="FDP"
      >
        <a-input
          placeholder="请输入FDP"
          v-decorator="['fdp', {rules:[{max:100,message:'最长不超过100'}]}]"
        />
      </a-form-item>
      <a-form-item
        v-bind="formItemLayout"
        label="PT"
      >
        <a-input
          placeholder="请输入PT"
          v-decorator="['pt', {rules:[{max:100,message:'最长不超过100'}]}]"
        />
      </a-form-item>
      <a-form-item
        v-bind="formItemLayout"
        label="APTT"
      >
        <a-input
          placeholder="请输入APTT"
          v-decorator="['aptt', {rules:[{max:100,message:'最长不超过100'}]}]"
        />
      </a-form-item>
    </a-form>
  </div>
</template>

<script>
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
  components: {},
  methods: {
    reset () {
      this.loading = false
      this.csfcInfo = {}
      this.form.resetFields()
      this.baseId = ''
    },
    setFields () {
      let values = this.form.getFieldsValue(['d2jt', 'fdp', 'pt', 'aptt'])
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
      console.log('CsfcInfo Id 创建成功.')
    }
  }
}
</script>

<style>
</style>