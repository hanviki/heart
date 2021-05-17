<template>
  <div>
    <a-form :form="form">
      <a-divider orientation="left" style="font-size:14px;">2. 住院病历资料</a-divider>
      <a-form-item label="主诉">
        <a-input
          placeholder="请输入主诉"
          v-decorator="['zhusu', {rules:[{max:100,message:'最长不超过100'}]}]"
        />
      </a-form-item>
      <a-divider orientation="left" style="font-size:14px;">2.2.1、病历首页信息</a-divider>
      <a-form-item label="入院日期">
        <a-date-picker
          :showTime="{ format: 'HH:mm' }"
          format='YYYY-MM-DD HH:mm'
          v-decorator="['inHospital', {}]"
        />
      </a-form-item>
      <a-form-item label="出院日期">
        <a-date-picker
          showTime
          format='YYYY-MM-DD'
          v-decorator="['outHospital', {}]"
        />
      </a-form-item>
      <a-form-item label="住院转归">
        <a-radio-group v-decorator="['inRedirect', {}]">
          <a-radio value="手术后死亡">
            手术后死亡
          </a-radio>
          <a-radio value="手术后存活">
            手术后存活
          </a-radio>
          <a-radio value="拟手术，术前死亡">
            拟手术，术前死亡
          </a-radio>
          <a-radio value="保守治疗，住院期间死亡">
            保守治疗，住院期间死亡
          </a-radio>
          <a-radio value="保守治疗，存活出院">
            保守治疗，存活出院
          </a-radio>
           <a-radio value="术后放弃,自动出院">
            术后放弃,自动出院
          </a-radio>
           <a-radio value="仍住院">
            仍住院
          </a-radio>
        </a-radio-group>
      </a-form-item>
      <a-form-item label="死亡原因">
        <a-input
          placeholder="请输入死亡原因"
          v-decorator="['deathInfo',  {rules:[{max:100,message:'最长不超过100'}]}]"
        />
      </a-form-item>
      <a-form-item label="死亡日期">
        <a-date-picker
          showTime
          format='YYYY-MM-DD'
          v-decorator="['swsj', {}]"
        />
      </a-form-item>
      <a-form-item label="住院转归备注">
        <a-input
          placeholder="请输入住院转归备注"
          v-decorator="['inRedirectnote',  {rules:[{max:100,message:'最长不超过100'}]}]"
        />
      </a-form-item>
      <a-divider orientation="left" style="font-size:14px;">2.2.2、诊断</a-divider>
      <a-form-item label="夹层诊断（阜外分型）">
         <a-radio-group v-decorator="['jczd', {}]">
          <a-radio value="A">
           A
          </a-radio>
          <a-radio value="B">
            B
          </a-radio>
          <a-radio value="C">
            C
          </a-radio>
          <a-radio value="D">
            D
          </a-radio>
        </a-radio-group>
      </a-form-item>
      <a-form-item label="高血压">
        <a-radio-group v-decorator="['gxy', {}]">
          <a-radio value="无">
           无
          </a-radio>
          <a-radio value="1级">
            1级
          </a-radio>
          <a-radio value="2级">
            2级
          </a-radio>
          <a-radio value="3级">
            3级
          </a-radio>
        </a-radio-group>
      </a-form-item>
      <a-form-item label="NYHA分级">
        
         <a-radio-group v-decorator="['nyha', {}]">
          <a-radio value="Ⅰ">
           Ⅰ
          </a-radio>
          <a-radio value="Ⅱ">
            Ⅱ
          </a-radio>
          <a-radio value="Ⅲ">
            Ⅲ
          </a-radio>
          <a-radio value="Ⅳ">
            Ⅳ
          </a-radio>
        </a-radio-group>
      </a-form-item>
      <a-form-item label="糖尿病">
        <a-input
          placeholder="请输入糖尿病"
          v-decorator="['tnb', {}]"
        />
        <a-radio-group v-decorator="['tnb', {}]">
          <a-radio value="是">
           是
          </a-radio>
          <a-radio value="否">
            否
          </a-radio>
        </a-radio-group>
      </a-form-item>
      <a-form-item label="马凡综合征">
        <a-radio-group v-decorator="['mfzhz', {}]">
          <a-radio value="是">
           是
          </a-radio>
          <a-radio value="否">
            否
          </a-radio>
        </a-radio-group>
      </a-form-item>
      <a-form-item label="其他">
        <a-input
          placeholder="请输入其他"
          v-decorator="['other',  {rules:[{max:50,message:'最长不超过50'}]}]"
        />
      </a-form-item>
      <a-divider orientation="left" style="font-size:14px;">2.2.3、既往史</a-divider>
      <a-form-item label="主动脉瓣手术">
         <a-radio-group v-decorator="['zdmbss', {}]">
          <a-radio value="是">
           是
          </a-radio>
          <a-radio value="否">
            否
          </a-radio>
        </a-radio-group>
      </a-form-item>
      <a-form-item label="全弓置换">
         <a-radio-group v-decorator="['qgzh', {}]">
          <a-radio value="是">
           是
          </a-radio>
          <a-radio value="否">
            否
          </a-radio>
        </a-radio-group>
      </a-form-item>
      <a-form-item label="其他主动干预">
        <a-input
          placeholder="请输入其他主动干预"
          v-decorator="['qtzdgy',  {rules:[{max:50,message:'最长不超过50'}]}]"
        />
      </a-form-item>
      <a-form-item label="上次主动干预时间">
        <a-date-picker
          showTime
          format='YYYY-MM-DD'
          v-decorator="['sczdgysj', {}]"
        />
      </a-form-item>
      <a-form-item label="主动脉疾病家族史">
        <a-input
          placeholder="请输入主动脉疾病家族史"
          v-decorator="['zdmjbjzs', {rules:[{max:50,message:'最长不超过50'}]}]"
        />
      </a-form-item>
      <a-form-item label="吸烟">
       <a-radio-group v-decorator="['xy', {}]">
          <a-radio value="是">
           是
          </a-radio>
          <a-radio value="否">
            否
          </a-radio>
        </a-radio-group>
      </a-form-item>
      <a-form-item label="喝酒">
       <a-radio-group v-decorator="['hj', {}]">
          <a-radio value="是">
           是
          </a-radio>
          <a-radio value="否">
            否
          </a-radio>
        </a-radio-group>
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
      hospitalInfo: {},
    }
  },
  methods: {
    reset () {
      this.loading = false
      this.hospitalInfo = {}
      this.form.resetFields()
    },
    setFields () {
      let values = this.form.getFieldsValue(['zhusu', 'inHospital', 'outHospital', 'inRedirect', 'deathInfo', 'swsj', 'inRedirectnote', 'jczd', 'gxy', 'nyha', 'tnb', 'mfzhz', 'other', 'zdmbss', 'qgzh', 'qtzdgy', 'sczdgysj', 'zdmjbjzs', 'xy', 'hj'])
      if (typeof values !== 'undefined') {
          Object.keys(values).forEach(_key => {
          if (values[_key] !== undefined) {
            this.hospitalInfo[_key] = values[_key]
          }

        })
      }
      return this.hospitalInfo
    },
    setFormValues ({ ...checkInfo }) {
      let fields = ['zhusu', 'inHospital', 'outHospital', 'inRedirect', 'deathInfo', 'swsj', 'inRedirectnote', 'jczd', 'gxy', 'nyha', 'tnb', 'mfzhz', 'other', 'zdmbss', 'qgzh', 'qtzdgy', 'sczdgysj', 'zdmjbjzs', 'xy', 'hj']
      let fieldDates = []
      Object.keys(checkInfo).forEach((key) => {
        if (fields.indexOf(key) !== -1) {
          this.form.getFieldDecorator(key)
          let obj = {}
          if (fieldDates.indexOf(key) !== -1) {
            if (checkInfo[key] !== '') {
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
      this.hospitalInfo = checkInfo
    }
  }
}
</script>

<style>
</style>