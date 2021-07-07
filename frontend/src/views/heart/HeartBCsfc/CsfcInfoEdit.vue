<template>
  <div>
    <a-form :form="form">
       <muti-uploadFile :baseId="baseId" :isEdit="isEdit"></muti-uploadFile>
      <a-form-item
        label="检测时间"
      >
        <a-date-picker
          showTime
          format='YYYY-MM-DD HH:mm'
          v-decorator="[ 'checkDate', {}]"
        />
      </a-form-item>
      <a-form-item
        label="AVR"
      >
        <a-radio-group v-decorator="['avr', {}]" :options="jlOptions">
        </a-radio-group>
      </a-form-item>
      <a-form-item
        label="MVR"
      >
        <a-radio-group v-decorator="['mvr', {}]" :options="jlOptions">
        </a-radio-group>
      </a-form-item>
      <a-form-item
        label="室壁运动异常位置"
      >
        <a-input
          placeholder="请输入室壁运动异常位置"
          v-decorator="['sbydycwz', {rules:[{max:20,message:'最长不超过20'}]}]"
        />
      </a-form-item>
      <a-form-item
        label="心包积液"
      >
        <a-radio-group v-decorator="['xbjy', {}]" :options="jlOptions">
        </a-radio-group>
      </a-form-item>
      <a-form-item
        label="EF(%)"
      >
        <a-input-number
          placeholder="请输入EF(%)"
          v-decorator="['ef', {}]"
          :precision="0"
          :max="99999999"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item
        label="左室舒张末内径(mm)"
      >
        <a-input-number
          placeholder="请输入左室舒张末内径(mm)"
          v-decorator="['zsszwnj', {}]"
          :precision="0"
          :max="99999999"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item
        label="主动脉闭环直径(mm)"
      >
        <a-input-number
          placeholder="请输入主动脉闭环直径(mm)"
          v-decorator="['zdmbhzj', {}]"
          :precision="0"
          :max="99999999"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item
        label="主动脉窦直径(mm)"
      >
        <a-input-number
          placeholder="请输入主动脉窦直径(mm)"
          v-decorator="['zdmdzj', {}]"
          :precision="0"
          :max="99999999"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item
        label="升主动脉直径(mm)"
      >
        <a-input-number
          placeholder="请输入升主动脉直径(mm)"
          v-decorator="['szdmdzj', {}]"
          :precision="0"
          :max="99999999"
          style="width:100%;"
        />
      </a-form-item>
    </a-form>
  </div>
</template>

<script>
import MutiUploadFile from '../../common/MutiUploadFile'
import moment from 'moment'
const jlOptions = [
  { label: '无', value: '无' },
  { label: '微量', value: '微量' },
  { label: '少量', value: '少量' },
  { label: '少中量', value: '少中量' },
  { label: '中大量', value: '中大量' },
  { label: '大量', value: '大量' }]
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
      baseId: '',
      jlOptions
    }
  },
  mounted () {
    this.setFormValues(this.checkInfo)
  },
  components: {MutiUploadFile},
  methods: {
    moment,
    reset () {
      this.loading = false
      this.csfcInfo = {}
      this.form.resetFields()
      this.baseId = ''
    },
    setFields () {
      let values = this.form.getFieldsValue(['checkDate', 'avr', 'mvr', 'sbydycwz', 'xbjy', 'ef', 'zsszwnj', 'zdmbhzj', 'zdmdzj', 'szdmdzj', 'csjcsj'])
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
      let fields = ['checkDate', 'avr', 'mvr', 'sbydycwz', 'xbjy', 'ef', 'zsszwnj', 'zdmbhzj', 'zdmdzj', 'szdmdzj', 'csjcsj']
      let fieldDates = ['checkDate', 'csjcsj']
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
