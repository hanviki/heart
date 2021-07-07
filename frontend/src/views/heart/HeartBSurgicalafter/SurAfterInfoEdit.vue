<template>
  <div>
    <a-form :form="form">
      <a-divider
        orientation="left"
        style="font-size:14px;"
      >8. 术后</a-divider>
      <a-form-item label="累计辅助通气时间(h)">
        <a-input-number
          placeholder="请输入累计辅助通气时间(h)"
          v-decorator="['shLjfztqsj', {}]"
          :precision="0"
          :max="99999999"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="再次气管插管">
        <a-radio-group v-decorator="['shZcqgcg', {}]">
          <a-radio value="是">
            是
          </a-radio>
          <a-radio value="否">
            否
          </a-radio>
        </a-radio-group>
      </a-form-item>
      <a-form-item label="术后ICU停留时间(天)">
        <a-input-number
          placeholder="请输入术后ICU停留时间(天)"
          v-decorator="['shShicutime', {}]"
          :precision="0"
          :max="99999999"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="再次进入ICU">
        <a-radio-group v-decorator="['shZcicu', {}]">
          <a-radio value="是">
            是
          </a-radio>
          <a-radio value="否">
            否
          </a-radio>
        </a-radio-group>
      </a-form-item>
      <a-form-item label="再次ICU停留时间（天）">
        <a-input-number
          placeholder="请输入再次ICU停留时间（天）"
          v-decorator="['shZcicutime', {}]"
          :precision="0"
          :max="99999999"
          style="width:100%;"
        />

      </a-form-item>
      <a-form-item label="术后开胸止血">
        <a-radio-group v-decorator="['shShkxzx', {}]">
          <a-radio value="是">
            是
          </a-radio>
          <a-radio value="否">
            否
          </a-radio>
        </a-radio-group>
      </a-form-item>
      <a-form-item label="其他再次手术原因">
        <a-input
          placeholder="请输入其他再次手术原因"
          v-decorator="['shQtzcssyy', {rules:[{max:50,message:'最长不超过50'}]}]"
        />
      </a-form-item>
      <a-form-item label="术后并发症">
        <a-checkbox-group
          v-decorator="['shShbfz', {}]"
          :options="pfOptions"
        />
      </a-form-item>
      <a-form-item label="备注">
        <a-input
          placeholder="请输入备注"
          v-decorator="['shNote',{rules:[{max:50,message:'最长不超过50'}]}]"
        />
      </a-form-item>
      <a-divider
        orientation="left"
        style="font-size:14px;"
      >术后随访</a-divider>
      <a-form-item label="主诉">
        <a-input
          placeholder="请输入主诉"
          v-decorator="['shsfZs', {rules:[{max:50,message:'最长不超过50'}]}]"
        />
      </a-form-item>
      <a-divider
        orientation="left"
        style="font-size:14px;"
      >1.生存状态</a-divider>
      <a-form-item label="随访日期">
        <a-date-picker v-decorator="[ 'shsfDate', {}]" />
      </a-form-item>
      <a-form-item label="生存状态">
        <a-radio-group v-decorator="['shsfSczt', {}]">
          <a-radio value="存活">
            存活
          </a-radio>
          <a-radio value="死亡">
            死亡
          </a-radio>
        </a-radio-group>
      </a-form-item>
      <a-form-item label="死亡原因">
        <a-input
          placeholder="请输入死亡原因"
          v-decorator="['shsfDeath', {rules:[{max:50,message:'最长不超过50'}]}]"
        />
      </a-form-item>
      <a-form-item label="死亡日期">
        <a-date-picker v-decorator="[ 'shsfDeathDate', {}]" />
      </a-form-item>
      <a-form-item label="心血管再次干预">
        <a-input
          placeholder="请输入心血管再次干预"
          v-decorator="['shsfXxgzcgy', {rules:[{max:50,message:'最长不超过50'}]}]"
        />
      </a-form-item>
      <a-form-item label="再次干预时间">
        <a-date-picker v-decorator="[ 'shsfZcgysj', {}]" />
      </a-form-item>
      <a-form-item label="新发疾病">
        <a-input
          placeholder="请输入新发疾病"
          v-decorator="['shsfXfjb', {rules:[{max:50,message:'最长不超过50'}]}]"
        />
      </a-form-item>
      <a-form-item label="新发疾病时间">
        <a-date-picker v-decorator="[ 'shsfXfjbsj', {}]" />
      </a-form-item>
      <a-form-item label="其他并发症">
        <a-input
          placeholder="请输入其他并发症"
          v-decorator="['shsfQtbfz', {rules:[{max:50,message:'最长不超过50'}]}]"
        />
      </a-form-item>
       <a-form-item label="C反应蛋白">
        <a-input
          placeholder="请输入C反应蛋白"
          v-decorator="['cfydb', {rules:[{max:50,message:'最长不超过50'}]}]"
        />
      </a-form-item>
    </a-form>
  </div>
</template>

<script>
import moment from 'moment'
const pfOptions = [
  { label: '胸部切口感染', value: '胸部切口感染' },
  { label: '肺部感染', value: '肺部感染' },
  { label: '呼吸功能不全', value: '呼吸功能不全' },
  { label: '气管切开', value: '气管切开' },
  { label: '急性肾功能不全', value: '急性肾功能不全' },
  { label: '肾脏血滤治疗', value: '肾脏血滤治疗' },
  { label: '多系统衰竭', value: '多系统衰竭' },
  { label: '脑梗塞', value: '脑梗塞' },
  { label: '脑出血', value: '脑出血' },
  { label: '精神症状(如谵妄)', value: '精神症状(如谵妄)' },
  { label: '截瘫', value: '截瘫' },
  { label: '偏瘫', value: '偏瘫' },
  { label: '软瘫', value: '软瘫' },
  { label: '轻瘫', value: '轻瘫' },
  { label: '术后肝功能不全', value: '术后肝功能不全' },
  { label: '胃肠道出血', value: '胃肠道出血' },
  { label: '肠梗阻', value: '肠梗阻' },
  { label: '急性胰腺炎', value: '急性胰腺炎' },
  { label: '心功能不全', value: '心功能不全' },
  { label: '凝血功能不全', value: '凝血功能不全' }
]

export default {
  data () {
    return {
      loading: false,
      form: this.$form.createForm(this),
      afterSurgicalInfo: {},
      pfOptions
    }
  },
  methods: {
    reset () {
      this.loading = false
      this.afterSurgicalInfo = {}
      this.form.resetFields()
    },
    setFields () {
      let values = this.form.getFieldsValue(['shLjfztqsj', 'shZcqgcg', 'shShicutime', 'shZcicu', 'shZcicutime', 'shShkxzx', 'shQtzcssyy', 'shShbfz', 'shNote', 'shsfZs', 'shsfDate', 'shsfSczt', 'shsfDeath', 'shsfDeathDate', 'shsfXxgzcgy', 'shsfZcgysj', 'shsfXfjb', 'shsfXfjbsj', 'shsfQtbfz', 'cfydb'])
      if (typeof values !== 'undefined') {
        Object.keys(values).forEach(_key => {
          if (values[_key] !== undefined) {
            this.afterSurgicalInfo[_key] = values[_key]
          }
        })
      }
      return this.afterSurgicalInfo
    },
    setFormValues ({ ...setAfterSurgicalInfo }) {
      let fields = ['shLjfztqsj', 'shZcqgcg', 'shShicutime', 'shZcicu', 'shZcicutime', 'shShkxzx', 'shQtzcssyy', 'shShbfz', 'shNote', 'shsfZs', 'shsfDate', 'shsfSczt', 'shsfDeath', 'shsfDeathDate', 'shsfXxgzcgy', 'shsfZcgysj', 'shsfXfjb', 'shsfXfjbsj', 'shsfQtbfz', 'cfydb']
      let fieldDates = ['shsfDeathDate', 'shsfZcgysj', 'shsfXfjbsj', 'shsfDate']
      Object.keys(setAfterSurgicalInfo).forEach((key) => {
        if (fields.indexOf(key) !== -1) {
          this.form.getFieldDecorator(key)
          let obj = {}
          if (fieldDates.indexOf(key) !== -1) {
            if (setAfterSurgicalInfo[key] !== '' && setAfterSurgicalInfo[key] !== null) {
              obj[key] = moment(setAfterSurgicalInfo[key])
            } else {
              obj[key] = ''
            }
          } else {
            if (key === 'shShbfz') {
              obj[key] = setAfterSurgicalInfo[key] === '' ? null : JSON.parse(setAfterSurgicalInfo[key])
            } else {
              obj[key] = setAfterSurgicalInfo[key]
            }
          }
          this.form.setFieldsValue(obj)
        }
      })
      this.afterSurgicalInfo = setAfterSurgicalInfo
    }
  }
}
</script>

<style>
</style>
