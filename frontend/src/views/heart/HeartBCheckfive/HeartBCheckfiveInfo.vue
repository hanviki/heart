<template>
  <div>
    <a-form :form="form">
      <a-form-item
        label="检测时间"
      >
        <a-date-picker
          showTime
          format='YYYY-MM-DD HH:mm'
          v-decorator="[ 'checkDate', {}]"
        />
      </a-form-item>
      <a-form-item label="D二聚体(mg/L)">
        <a-input-number
          placeholder="请输入D二聚体(mg/L)"
          v-decorator="['d2jt', {}]"
          :precision="2"
          :max="99999999.99"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="FDP(mg/L)">
        <a-input-number
          placeholder="请输入FDP(mg/L)"
          v-decorator="['fdp', {}]"
          :precision="2"
          :max="99999999.99"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="PT(s)">
        <a-input-number
          placeholder="请输入PT(s)"
          v-decorator="['pt', {}]"
          :precision="2"
          :max="99999999.99"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="APTT(s)">
        <a-input-number
          placeholder="请输入APTT(s)"
          v-decorator="['aptt', {}]"
          :precision="2"
          :max="99999999.99"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="INR">
        <a-input-number
          placeholder="请输入INR"
          v-decorator="['inr', {}]"
          :precision="2"
          :max="99999999.99"
          style="width:100%;"
        />
      </a-form-item>
       <a-form-item label="C反应蛋白">
        <a-input
          placeholder="请输入C反应蛋白"
          v-decorator="['cfydb', {rules:[{max:50,message:'最长不超过50'}]}]"
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

      }
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
    },
    setFields () {
      let values = this.form.getFieldsValue(['checkDate', 'd2jt', 'fdp', 'pt', 'aptt', 'inr', 'cfydb'])
      if (typeof values !== 'undefined') {
        Object.keys(values).forEach(_key => {
          if (values[_key] !== undefined) {
            this.csfcInfo[_key] = values[_key]
          }
        })
      }
      return this.csfcInfo
    }
  }
}
</script>

<style>
</style>
