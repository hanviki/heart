<template>
  <div>
    <a-form :form="form">
      <a-divider
        orientation="left"
        style="font-size:14px;"
      >2.3.4、肝肾功</a-divider>
      <a-form-item label="血肌肝umol/L">
        <a-input-number
          placeholder="请输入血肌肝umol/L"
          v-decorator="['xjg', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="ALT(U/L)">
        <a-input-number
          placeholder="请输入ALT(U/L)"
          v-decorator="['alt', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="AST(U/L)">
        <a-input-number
          placeholder="请输入AST(U/L)"
          v-decorator="['ast', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="总胆红素(umol/L)">
        <a-input-number
          placeholder="请输入总胆红素(umol/L)"
          v-decorator="['zdhs', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="直接胆红素(umol/L)">
        <a-input-number
          placeholder="请输入直接胆红素"
          v-decorator="['zjdhs', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="淀粉酶(U)">
        <a-input-number
          placeholder="请输入淀粉酶(U)"
          v-decorator="['dfm', {}]"
          :precision="2"
          style="width:100%;"
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
      let values = this.form.getFieldsValue(['xjg', 'alt', 'ast', 'zdhs', 'zjdhs', 'dfm'])
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