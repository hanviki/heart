<template>
  <div>
    <a-form :form="form">
      <a-divider orientation="left" style="font-size:14px;">1.个人信息</a-divider>
      <a-form-item label="录入人">
        <a-input
          placeholder="请输入录入人"
          v-decorator="['createname', {
              rules: [{ required: true, message: '录入人不能为空!' },{
                max:50,message:'最长不超过50'
            }]
          }]"
        />
      </a-form-item>
      <a-form-item label="病案号" :validateStatus="validateStatus"
        :help="help">
        <a-input
        @blur="handlefileNoBlur"
          placeholder="请输入病案号"
          v-decorator="['fileNo', {
            rules: [{ required: true, message: '病案号不能为空!' },{
                max:20,message:'最长不超过20'
            }]
          }]"
        />
      </a-form-item>
      <a-form-item label="姓名">
        <a-input
          placeholder="请输入姓名"
          v-decorator="['name', {
              rules: [{ required: true, message: '姓名不能为空!' },{
                max:50,message:'最长不超过50'
            }]
          }]"
        />
      </a-form-item>
      <a-form-item label="年龄">
        <a-input-number
          placeholder="请输入年龄"
          v-decorator="['age', {}]"
          :precision="0"
          :max="120"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="性别">
       <a-radio-group   v-decorator="['gender',{initialValue: '0'}]">
    <a-radio value="0">
      男
    </a-radio>
    <a-radio value="1">
      女
    </a-radio>
  </a-radio-group>
      </a-form-item>
      <a-form-item label="身高(cm)">
        <a-input-number
          placeholder="请输入身高"
          v-decorator="['height', {}]"
          :precision="0"
          :max="230"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="体重(kg)">
       <a-input-number
          placeholder="请输入体重"
          v-decorator="['weight', {}]"
          :precision="0"
          :max="600"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="地址">
       <a-cascader :options="options"  v-decorator="['province', {}]" />
       <a-input
          placeholder="请输入详细地址"
          v-decorator="['address', {rules:[{max:100,message:'最长不超过100'} ]}]"
        />
      </a-form-item>
      <!-- <a-form-item label="详细地址">
        <a-input
          placeholder="请输入详细地址"
          v-decorator="['address', {}]"
        />
      </a-form-item> -->
      <a-form-item label="联系方式">
        <a-input
          placeholder="请输入联系方式"
          v-decorator="['telphone', {rules:[{max:100,message:'最长不超过100'} ]}]"
        />
      </a-form-item>
      <a-form-item label="入诊日期和时间">
        <a-date-picker
          :showTime="{ format: 'HH:mm' }"
          format='YYYY-MM-DD HH:mm'
          v-decorator="[ 'inCheck', {}]"
        />
      </a-form-item>
      <a-form-item label="主诉">
        <a-input
          placeholder="请输入主诉"
          v-decorator="['zhusu', {rules:[{max:100,message:'最长不超过100'}]}]"
        />
      </a-form-item>
      <a-form-item label="发病-就诊时间">
        年
        <a-input-number
          placeholder="年"
          v-decorator="['toYear', {}]"
          :precision="0"
          :max="9999"
          style="width:18%;"
        />
        &nbsp;&nbsp;月
        <a-input-number
          placeholder="月"
          v-decorator="['toMonth', {}]"
          :precision="0"
          :max="12"
          style="width:15%;"
        />
        &nbsp;&nbsp;日
        <a-input-number
          placeholder="日"
          v-decorator="['toDay', {}]"
          :precision="0"
          :max="31"
          style="width:15%;"
        />
        &nbsp;&nbsp;时
        <a-input-number
          placeholder="时"
          v-decorator="['toHour', {}]"
          :precision="0"
          :max="24"
          style="width:15%;"
        />
      </a-form-item>
      <a-form-item label="疼痛部位">
        <a-checkbox-group  v-decorator="['painPos', {}]" :options="plainOptions" />
      </a-form-item>
      <a-form-item label="症状和体征">
          <a-checkbox-group  v-decorator="['symptoms', {}]" :options="symptomsOptions" />
      </a-form-item>
      <a-form-item label="其他症状">
        <a-input
          placeholder="请输入其他症状"
          v-decorator="['otherSymptoms', {rules:[{max:100,message:'最长不超过100'} ]}]"
        />
      </a-form-item>
      <a-form-item label="急诊转归">
        <a-radio-group   v-decorator="['emergency', {}]" :options="emergencyOptions">
      </a-radio-group>
      </a-form-item>
      <a-form-item label="死亡原因">
        <a-input
          placeholder="请输入死亡原因"
          v-decorator="['deathCause', {rules:[{max:100,message:'最长不超过100'} ]}]"
        />
      </a-form-item>
      <a-form-item label="死亡时间">
        <a-date-picker v-decorator="[ 'deathDate', {}]" />
      </a-form-item>
      <a-form-item label="急诊转归备注">
        <a-input
          placeholder="请输入急诊转归备注"
          v-decorator="['emergencyNote', {rules:[{max:100,message:'最长不超过100'} ]}]"
        />
      </a-form-item>
    </a-form>
    </div>
</template>

<script>
import moment from 'moment'
 import area from '../../../utils/chinaarea'
const plainOptions = [
    { label: '无/No', value: '无/No' },
    { label: '胸前/Front chest', value: '胸前/Front chest' },
    { label: '胸背/Behind chest', value: '胸背/Behind chest' },
    { label: '腰背/Behind low back', value: '腰背/Behind low back' },
    { label: '腹部/Abdomen', value: '腹部/Abdomen' }];
const symptomsOptions = [
  { label: '下肢活动异常', value: '下肢活动异常' },
  { label: '下肢感觉异常', value: '下肢感觉异常' },
  { label: '晕厥', value: '晕厥' },
  { label: '精神状态异常', value: '精神状态异常' },
  { label: '心包填塞症', value: '心包填塞症' },
  { label: '心律失常', value: '心律失常' },
  { label: '心肌缺血', value: '心肌缺血' },
  { label: '肢体缺血', value: '肢体缺血' },
  { label: '脑卒中', value: '脑卒中' },
  { label: '脊髓缺血', value: '脊髓缺血' },
  { label: '内脏缺血', value: '内脏缺血' },
  { label: '无', value: '无' }];
const emergencyOptions = [
    { label: '住院治疗', value: '住院治疗' },
    { label: '急诊治疗期间死亡', value: '急诊治疗期间死亡' },
    { label: '急诊保守治疗出院', value: '急诊保守治疗出院' },
    { label: '放弃', value: '放弃' },
    { label: '自动出院', value: '自动出院' }];
export default {
  data () {
    return {
      loading: false,
      form: this.$form.createForm(this),
      heartBPatientinfo: {},
      options: area,
      plainOptions,
      validateStatus: '',
      help: '',
      symptomsOptions,
      emergencyOptions
    }
  },
  methods: {
    reset () {
      this.loading = false
      this.heartBPatientinfo = {}
      this.form.resetFields()
    },
    setFields () {
      let values = this.form.getFieldsValue(['createname', 'fileNo', 'name', 'age', 'gender', 'height', 'weight', 'province', 'city', 'area', 'address', 'telphone', 'inCheck', 'toYear', 'toMonth', 'toDay', 'toHour', 'painPos', 'symptoms', 'otherSymptoms', 'emergency', 'deathCause', 'deathDate', 'emergencyNote', 'zhusu'])
      if (typeof values !== 'undefined') {
        Object.keys(values).forEach(_key => { 
            if(values[_key]!==undefined){
            this.heartBPatientinfo[_key] = values[_key]
          }
       })
      }
      return this.heartBPatientinfo
    },
     handlefileNoBlur () {
      let fileno = this.form.getFieldValue("fileNo")
      fileno = typeof fileno === "undefined" ? "" : fileno.trim()
      if (fileno.length) {
          this.validateStatus = "validating"
          this.$get(`heartBPatientinfo/check/${fileno}`,{id: this.heartBPatientinfo.id}).then(r => {
            if (r.data) {
              this.validateStatus = "success"
              this.help = ""
              this.$emit('check',this.validateStatus)
            } else {
              this.validateStatus = "error"
              this.help = "抱歉，该病案号已存在"
        this.$emit('check',this.validateStatus)
            }
          })
      } else {
        this.validateStatus = "error"
        this.$emit('check',this.validateStatus)
        this.help = "病案号不能为空"
      }
    },
  setFormValues ({ ...checkInfo }) {
      let fields = ['createname', 'fileNo', 'name', 'age', 'gender', 'height', 'weight', 'province', 'address', 'telphone', 'inCheck', 'toYear', 'toMonth', 'toDay', 'toHour', 'painPos', 'symptoms', 'otherSymptoms', 'emergency', 'deathCause', 'deathDate', 'emergencyNote', 'zhusu']
      let fieldDates = ['inCheck', 'deathDate']
      Object.keys(checkInfo).forEach((key) => {
        if (fields.indexOf(key) !== -1) {
          this.form.getFieldDecorator(key)
          let obj = {}
          if (fieldDates.indexOf(key) !== -1) {
            if (checkInfo[key] !== '' && checkInfo[key] != null) {
              obj[key] = moment(checkInfo[key])
            } else {
              obj[key] = ''
            }
          } else {
            if(key=='province' || key =='painPos' || key =='symptoms'){
              obj[key] = checkInfo[key] == '' ? null : JSON.parse(checkInfo[key])
            }
            else if(key =='gender'){
               obj[key] = checkInfo[key]?'1':'0'
            }
            else{
              obj[key] = checkInfo[key]
            }
          }
          this.form.setFieldsValue(obj)
        }
      })
     // this.baseId = checkInfo.id
      this.heartBPatientinfo = checkInfo
    }
  }
}
</script>

<style>
</style>