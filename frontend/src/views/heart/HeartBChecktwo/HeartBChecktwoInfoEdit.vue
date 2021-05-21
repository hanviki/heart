<template>
  <div>
    <a-form :form="form">
      <a-form-item
        v-bind="formItemLayout"
        label="红细胞计数"
      >
        <a-input
          placeholder="请输入红细胞计数"
          v-decorator="['hxbjs', {rules:[{max:100,message:'最长不超过100'}]}]"
        />
      </a-form-item>
      <a-form-item
        v-bind="formItemLayout"
        label="血红蛋白"
      >
        <a-input
          placeholder="请输入血红蛋白"
          v-decorator="['xhdb', {rules:[{max:100,message:'最长不超过100'}]}]"
        />
      </a-form-item>
      <a-form-item
        v-bind="formItemLayout"
        label="白细胞计数"
      >
        <a-input
          placeholder="请输入白细胞计数"
          v-decorator="['bxbjs', {rules:[{max:100,message:'最长不超过100'}]}]"
        />
      </a-form-item>
      <a-form-item
        v-bind="formItemLayout"
        label="中性粒细胞百分比"
      >
        <a-input
          placeholder="请输入中性粒细胞百分比"
          v-decorator="['zxlxbbfb', {rules:[{max:100,message:'最长不超过100'}]}]"
        />
      </a-form-item>
      <a-form-item
        v-bind="formItemLayout"
        label="血小板计数"
      >
        <a-input
          placeholder="请输入血小板计数"
          v-decorator="['xxbjs', {rules:[{max:100,message:'最长不超过100'}]}]"
        />
      </a-form-item>
    </a-form>
  </div>
</template>

<script>
import moment from 'moment'
export default {
  props: {
    isEdit: {
      default: true
    },
    checkInfo: {
      default: {}
    }
  },
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
    this.setFormValues(this.checkInfo)
  },
  components: {},
  methods: {
    moment,
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
    setFormValues ({ ...checkInfo }) {
      let fields = ['id', 'username', 'fileNo', 'name', 'hxbjs', 'xhdb', 'bxbjs', 'zxlxbbfb', 'xxbjs', 'isDeletemark', 'createTime', 'modifyTime', 'createUserId', 'modifyUserId']
      let fieldDates = ['createTime', 'modifyTime']
      Object.keys(checkInfo).forEach((key) => {
        if (fields.indexOf(key) !== -1) {
          this.form.getFieldDecorator(key)
          let obj = {}
          if (fieldDates.indexOf(key) !== -1) {
            if (checkInfo[key] !== '' && checkInfo[key] !== null) {
              obj[key] = moment(checkInfo[key])
            }
            else {
              obj[key] = ''
            }
          } else {
            obj[key] = checkInfo[key]
          }
          this.form.setFieldsValue(obj)
        }
      })
      this.baseId = checkInfo.id
      this.csfcInfo = checkInfo
    },

  }
}
</script>

<style>
</style>