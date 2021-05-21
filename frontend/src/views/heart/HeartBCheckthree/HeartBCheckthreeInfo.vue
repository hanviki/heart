<template>
  <div>
    <a-form :form="form">
      <a-form-item
        v-bind="formItemLayout"
        label="PH"
      >
        <a-input
          placeholder="请输入PH"
          v-decorator="['ph', {rules:[{max:100,message:'最长不超过100'}]}]"
        />
      </a-form-item>
      <a-form-item
        v-bind="formItemLayout"
        label="乳酸"
      >
        <a-input
          placeholder="请输入乳酸"
          v-decorator="['rs', {rules:[{max:100,message:'最长不超过100'}]}]"
        />
      </a-form-item>
      <a-form-item
        v-bind="formItemLayout"
        label="BE"
      >
        <a-input
          placeholder="请输入BE"
          v-decorator="['be', {rules:[{max:100,message:'最长不超过100'}]}]"
        />
      </a-form-item>
      <a-form-item
        v-bind="formItemLayout"
        label="SO2"
      >
        <a-input
          placeholder="请输入SO2"
          v-decorator="['so2', {rules:[{max:100,message:'最长不超过100'}]}]"
        />
      </a-form-item>
      <a-form-item
        v-bind="formItemLayout"
        label="PO2"
      >
        <a-input
          placeholder="请输入PO2"
          v-decorator="['po2', {rules:[{max:100,message:'最长不超过100'}]}]"
        />
      </a-form-item>
      <a-form-item
        v-bind="formItemLayout"
        label="PCO2"
      >
        <a-input
          placeholder="请输入PCO2"
          v-decorator="['pco2', {rules:[{max:100,message:'最长不超过100'}]}]"
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
      let values = this.form.getFieldsValue(['ph', 'rs', 'be', 'so2', 'po2', 'pco2'])
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