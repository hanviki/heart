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
      <a-form-item label="血肌肝umol/L">
        <a-input-number
          placeholder="请输入血肌肝umol/L"
          v-decorator="['xjg', {}]"
          :precision="2"
          :max="99999999.99"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="ALT(U/L)">
        <a-input-number
          placeholder="请输入ALT(U/L)"
          v-decorator="['alt', {}]"
          :precision="2"
          :max="99999999.99"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="AST(U/L)">
        <a-input-number
          placeholder="请输入AST(U/L)"
          v-decorator="['ast', {}]"
          :precision="2"
          :max="99999999.99"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="总胆红素(umol/L)">
        <a-input-number
          placeholder="请输入总胆红素(umol/L)"
          v-decorator="['zdhs', {}]"
          :precision="2"
          :max="99999999.99"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="直接胆红素(umol/L)">
        <a-input-number
          placeholder="请输入直接胆红素"
          v-decorator="['zjdhs', {}]"
          :precision="2"
          :max="99999999.99"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="淀粉酶(U)">
        <a-input-number
          placeholder="请输入淀粉酶(U)"
          v-decorator="['dfm', {}]"
          :precision="2"
          :max="99999999.99"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="肌酐(umol/L)">
        <a-input-number
          placeholder="请输入肌酐(umol/L)"
          v-decorator="['jg', {}]"
          :precision="2"
          :max="99999999.99"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="尿素氮(umol/L)">
        <a-input-number
          placeholder="请输入尿素氮(umol/L)"
          v-decorator="['nsd', {}]"
          :precision="2"
          :max="99999999.99"
          style="width:100%;"
        />
      </a-form-item>
       <a-form-item label="尿酸(umol/L)">
        <a-input-number
          placeholder="请输入尿酸(umol/L)"
          v-decorator="['ns', {}]"
          :precision="2"
          :max="99999999.99"
          style="width:100%;"
        />
      </a-form-item>

       <a-form-item label="白蛋白(G/L)">
        <a-input-number
          placeholder="请输入白蛋白(g/L)"
          v-decorator="['bdb', {}]"
          :precision="2"
          :max="99999999.99"
          style="width:100%;"
        />
      </a-form-item>
       <a-form-item label="胱仰素C(MG/L)">
        <a-input-number
          placeholder="请输入胱仰素C(Mg/L)"
          v-decorator="['gysc', {}]"
          :precision="2"
          :max="99999999.99"
          style="width:100%;"
        />
      </a-form-item>
       <a-form-item label="肾小球滤过率(ml/min/1.703m)">
         <a-input
          placeholder="请输入肾小球滤过率"
          v-decorator="['sxqlgl', {rules:[{max:50,message:'最长不超过50'}]}]"
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
      let values = this.form.getFieldsValue(['checkDate', 'xjg', 'alt', 'ast', 'zdhs', 'zjdhs', 'dfm', 'jg', 'nsd', 'ns', 'bdb' ,'gysc', 'sxqlgl'])
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
