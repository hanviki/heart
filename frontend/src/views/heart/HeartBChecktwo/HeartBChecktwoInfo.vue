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
      <a-form-item label="红细胞计数(T/L)">
        <a-input-number
          placeholder="请输入红细胞计数"
          v-decorator="['hxbjs', {}]"
          :precision="2"
          :max="99999999.99"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="血红蛋白(G/L)">
        <a-input-number
          placeholder="请输入血红蛋白"
          v-decorator="['xhdb', {}]"
          :precision="2"
          :max="99999999.99"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="白细胞计数(G/L)">
        <a-input-number
          placeholder="请输入白细胞计数"
          v-decorator="['bxbjs', {}]"
          :precision="2"
          :max="99999999.99"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="中性粒细胞百分比(%)">
        <a-input-number
          placeholder="请输入中性粒细胞百分比"
          v-decorator="['zxlxbbfb', {}]"
          :precision="0"
          :max="99999999"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="血小板计数(G/L)">
        <a-input-number
          placeholder="请输入血小板计数"
          v-decorator="['xxbjs', {}]"
          :precision="0"
          :max="99999999"
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
      let values = this.form.getFieldsValue(['checkDate', 'hxbjs', 'xhdb', 'bxbjs', 'zxlxbbfb', 'xxbjs'])
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
