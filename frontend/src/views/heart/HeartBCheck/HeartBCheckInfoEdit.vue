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
      <a-form-item label="肌红蛋白">
        <a-input-number
          placeholder="请输入肌红蛋白"
          v-decorator="['jhdb', {}]"
          :precision="2"
          :max="99999999.99"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="肌钙蛋白">
        <a-input-number
          placeholder="请输入肌钙蛋白"
          v-decorator="['jgdb', {}]"
          :precision="2"
          :max="99999999.99"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="CK-MB">
        <a-input-number
          placeholder="请输入CK-MB"
          v-decorator="['ckmb', {}]"
          :precision="2"
          :max="99999999.99"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="超敏肌钙蛋白（optional）">
        <a-input-number
          placeholder="请输入超敏肌钙蛋白（optional）"
          v-decorator="['cmjgdb', {}]"
          :precision="2"
          :max="99999999.99"
          style="width:100%;"
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
      let values = this.form.getFieldsValue(['checkDate', 'jhdb', 'jgdb', 'ckmb', 'cmjgdb'])
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
      let fields = ['id', 'username', 'fileNo', 'name', 'checkDate', 'jhdb', 'jgdb', 'ckmb', 'cmjgdb', 'isDeletemark', 'createTime', 'modifyTime', 'createUserId', 'modifyUserId']
      let fieldDates = ['checkDate', 'createTime', 'modifyTime']
      Object.keys(checkInfo).forEach((key) => {
        if (fields.indexOf(key) !== -1) {
          this.form.getFieldDecorator(key)
          let obj = {}
          if (fieldDates.indexOf(key) !== -1) {
            if (checkInfo[key] !== '' && checkInfo[key] !== null) {
              obj[key] = moment(checkInfo[key])
            } else {
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
    }
  }
}
</script>

<style>
</style>
