<template>
  <div>
    <a-form :form="form">
 
      <a-form-item label="肌红蛋白">
        <a-input-number
          placeholder="请输入肌红蛋白"
          v-decorator="['jhdb', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="肌钙蛋白">
        <a-input-number
          placeholder="请输入肌钙蛋白"
          v-decorator="['jgdb', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="CK-MB">
        <a-input-number
          placeholder="请输入CK-MB"
          v-decorator="['ckmb', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="超敏肌钙蛋白（optional）">
        <a-input-number
          placeholder="请输入超敏肌钙蛋白（optional）"
          v-decorator="['cmjgdb', {}]"
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
      let values = this.form.getFieldsValue(['jhdb', 'jgdb', 'ckmb', 'cmjgdb'])
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