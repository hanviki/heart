<template>
  <div>
    <a-form :form="form">

      <a-form-item label="红细胞计数">
        <a-input-number
          placeholder="请输入红细胞计数"
          v-decorator="['hxbjs', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="血红蛋白">
        <a-input-number
          placeholder="请输入血红蛋白"
          v-decorator="['xhdb', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="白细胞计数">
        <a-input-number
          placeholder="请输入白细胞计数"
          v-decorator="['bxbjs', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="中性粒细胞百分比">
        <a-input-number
          placeholder="请输入中性粒细胞百分比"
          v-decorator="['zxlxbbfb', {}]"
          :precision="0"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="血小板计数">
        <a-input-number
          placeholder="请输入血小板计数"
          v-decorator="['xxbjs', {}]"
          :precision="0"
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
      let values = this.form.getFieldsValue(['hxbjs', 'xhdb', 'bxbjs', 'zxlxbbfb', 'xxbjs'])
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