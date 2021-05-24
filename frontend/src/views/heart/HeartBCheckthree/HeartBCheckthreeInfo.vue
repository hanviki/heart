<template>
  <div>
    <a-form :form="form">

      <a-form-item label="PH">
        <a-input-number
          placeholder="请输入PH"
          v-decorator="['ph', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="乳酸">
        <a-input-number
          placeholder="请输入乳酸"
          v-decorator="['rs', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="BE">
        <a-input-number
          placeholder="请输入BE"
          v-decorator="['be', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="SO2">
        <a-input-number
          placeholder="请输入SO2"
          v-decorator="['so2', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="PO2">
        <a-input-number
          placeholder="请输入PO2"
          v-decorator="['po2', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="PCO2">
        <a-input-number
          placeholder="请输入PCO2"
          v-decorator="['pco2', {}]"
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
      let values = this.form.getFieldsValue(['ph', 'rs', 'be', 'so2', 'po2', 'pco2'])
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