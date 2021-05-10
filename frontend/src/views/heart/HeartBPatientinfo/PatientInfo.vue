<template>
  <div>
    <a-form :form="form">
      <a-divider orientation="left" style="font-size:14px;">1.个人信息</a-divider>
      <a-form-item label="病案号">
        <a-input
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
       <a-radio-group   v-decorator="['gender',{initialValue: '0'}, {}]">
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
          v-decorator="['address', {rules:[{max:200,message:'最长不超过200'} ]}]"
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
      <a-form-item label="发病-就诊时间">
        <a-input
          placeholder="请输入发病-就诊时间"
          v-decorator="['toCheck', {}]"
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
          v-decorator="['otherSymptoms', {}]"
        />
      </a-form-item>
      <a-form-item label="急诊转归">
        <a-radio-group   v-decorator="['emergency', {}]">
    <a-radio value="住院治疗">
      住院治疗
    </a-radio>
    <a-radio value="急诊治疗期间死亡">
      急诊治疗期间死亡
    </a-radio>
     <a-radio value="急诊保守治疗出院">
      急诊保守治疗出院
    </a-radio>
     <a-radio value="放弃">
      放弃
    </a-radio>
    <a-radio value="自动出院">
      自动出院
    </a-radio>
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
 import area from '../../../utils/chinaarea'
const plainOptions = ['无/No', '胸前/Front chest', '胸背/Behind chest','腰背/Behind low back','腹部/Abdomen'];
const symptomsOptions = ['下肢活动异常','下肢感觉异常','晕厥','精神状态异常','心包填塞症','心律失常','心肌缺血','肢体缺血','脑卒中','脊髓缺血','内脏缺血','无']
export default {
  data () {
    return {
      loading: false,
      form: this.$form.createForm(this),
      heartBPatientinfo: {},
      options: area,
      plainOptions,
      symptomsOptions
    }
  },
  methods: {
    setFields () {
      let values = this.form.getFieldsValue(['fileNo', 'name', 'age', 'gender', 'height', 'weight', 'province', 'city', 'area', 'address', 'telphone', 'inCheck', 'toCheck', 'painPos', 'symptoms', 'otherSymptoms', 'emergency', 'deathCause', 'deathDate', 'emergencyNote'])
      if (typeof values !== 'undefined') {
        Object.keys(values).forEach(_key => { 
            if(values[_key]!==undefined){
            this.heartBPatientinfo[_key] = values[_key]
          }
       })
      }
      return this.heartBPatientinfo
    },
   
  }
}
</script>

<style>
</style>