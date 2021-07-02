<template>
  <div>
    <a-form :form="form">
 <a-divider orientation="left" style="font-size:14px;">7. 手术</a-divider>
      <a-form-item label="备注">
        <a-input
          placeholder="请输入备注"
          v-decorator="['ssNote',{rules:[{max:50,message:'最长不超过50'}]}]"
        />
      </a-form-item>
      <a-form-item label="手术日期和时间">
        <a-date-picker
          :showTime="{ format: 'HH:mm' }"
          format='YYYY-MM-DD HH:mm'
          v-decorator="['ssDate', {}]"
        />
      </a-form-item>
      <a-form-item label="手术结束日期和时间">
        <a-date-picker
          :showTime="{ format: 'HH:mm' }"
          format='YYYY-MM-DD HH:mm'
          v-decorator="[ 'ssDateend', {}]"
        />
      </a-form-item>
      <a-form-item label="手术医生姓名">
        <a-input
          placeholder="请输入手术医生姓名"
          v-decorator="['ssDoctor',{rules:[{max:50,message:'最长不超过50'}]}]"
        />
      </a-form-item>
      <a-form-item label="医助1姓名">
        <a-input
          placeholder="请输入医助1姓名"
          v-decorator="['ssAssitant1',{rules:[{max:50,message:'最长不超过50'}]}]"
        />
      </a-form-item>
      <a-form-item label="医助2姓名">
        <a-input
          placeholder="请输入医助2姓名"
          v-decorator="['ssAssitant2',{rules:[{max:50,message:'最长不超过50'}]}]"
        />
      </a-form-item>
      <a-form-item label="医助3姓名">
        <a-input
          placeholder="请输入医助3姓名"
          v-decorator="['ssAssitant3',{rules:[{max:50,message:'最长不超过50'}]}]"
        />
      </a-form-item>
      <a-form-item label="医助4姓名">
        <a-input
          placeholder="请输入医助4姓名"
          v-decorator="['ssAssitant4',{rules:[{max:50,message:'最长不超过50'}]}]"
        />
      </a-form-item>
      <a-form-item label="医助5姓名">
        <a-input
          placeholder="请输入医助5姓名"
          v-decorator="['ssAssitant5',{rules:[{max:50,message:'最长不超过50'}]}]"
        />
      </a-form-item>
      <a-form-item label="主动脉手术方式">
        <a-input
          placeholder="请输入主动脉手术方式"
          v-decorator="['ssZdmssfs',{rules:[{max:50,message:'最长不超过50'}]}]"
        />
      </a-form-item>
      <a-form-item label="合并手术">
        <a-input
          placeholder="请输入合并手术"
          v-decorator="['ssHbss',{rules:[{max:50,message:'最长不超过50'}]}]"
        />
      </a-form-item>
      <a-form-item label="主动脉窦成形">
        <a-input
          placeholder="请输入主动脉窦成形"
          v-decorator="['ssZdmdcx',{rules:[{max:50,message:'最长不超过50'}]}]"
        />
      </a-form-item>
      <a-form-item label="主动脉瓣成形">
        <a-input
          placeholder="请输入主动脉瓣成形"
          v-decorator="['ssZdmbcx',{rules:[{max:50,message:'最长不超过50'}]}]"
        />
      </a-form-item>
      <a-form-item label="术中失血量(ml)">
        <a-input-number
          placeholder="请输入术中失血量(ml)"
          v-decorator="['ssSzsxl', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="红细胞输入量(U)">
        <a-input-number
          placeholder="请输入红细胞输入量(U)"
          v-decorator="['ssHxbsrl', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="血浆输入量(ml)">
        <a-input-number
          placeholder="请输入血浆输入量(ml)"
          v-decorator="['ssXjsrl', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="血小板输入量(治疗量)">
        <a-input-number
          placeholder="请输入血小板输入量(治疗量)"
          v-decorator="['ssXxbsrl', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="CBP时间(分钟)">
        <a-input-number
          placeholder="请输入CBP时间(分钟)"
          v-decorator="['ssCbptime', {}]"
          :precision="0"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="主动脉阻断时间(分钟)">
        <a-input-number
          placeholder="请输入主动脉阻断时间(分钟)"
          v-decorator="['ssZdmzdsj', {}]"
          :precision="0"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="停跳液类型">
        <a-input
          placeholder="请输入停跳液类型"
          v-decorator="['ttylx',{rules:[{max:50,message:'最长不超过50'}]}]"
        />
      </a-form-item>
      <a-form-item label="停跳液使用量">
        <a-input-number
          placeholder="请输入停跳液使用量"
          v-decorator="['ttysyl', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="最低鼻咽温度">
        <a-input-number
          placeholder="请输入最低鼻咽温度"
          v-decorator="['ssZdbywd', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="深低温停循环时间(分钟)">
        <a-input-number
          placeholder="请输入深低温停循环时间(分钟)"
          v-decorator="['ssSdwtxhsj', {}]"
          :precision="0"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="最低直肠温(分钟)">
        <a-input
          placeholder="请输入最低直肠温(分钟)"
          v-decorator="['ssZdzcw', {}]"
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
      surgicalInfo: {},
    }
  },
  methods: {
    reset () {
      this.loading = false
      this.surgicalInfo = {}
      this.form.resetFields()
    },
    setFields () {
      let values = this.form.getFieldsValue(['ssNote', 'ssDate', 'ssDateend', 'ssDoctor', 'ssZdmssfs', 'ssHbss', 'ssZdmdcx', 'ssZdmbcx', 'ssSzsxl', 'ssHxbsrl', 'ssXjsrl', 'ssXxbsrl', 'ssCbptime', 'ssZdmzdsj', 'ssZdbywd', 'ssSdwtxhsj', 'ssZdzcw', 'ssAssitant1', 'ssAssitant2', 'ssAssitant3', 'ssAssitant4', 'ssAssitant5', 'ttylx', 'ttysyl'])
      if (typeof values !== 'undefined') {
          Object.keys(values).forEach(_key => {
          if (values[_key] !== undefined) {
            this.surgicalInfo[_key] = values[_key]
          }

        })
      }
      return this.surgicalInfo
    },
  }
}
</script>

<style>
</style>