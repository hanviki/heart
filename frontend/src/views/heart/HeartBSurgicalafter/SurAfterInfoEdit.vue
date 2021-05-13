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
          v-decorator="['shNote',{rules:[{max:20,message:'最长不超过20'}]}]"
        />
      </a-form-item>
      <a-form-item label="主诉">
        <a-input
          placeholder="请输入主诉"
          v-decorator="['shsfZs', {rules:[{max:50,message:'最长不超过50'}]}]"
        />
      </a-form-item>
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
    </a-form>
  </div>
</template>

<script>
import moment from 'moment'
const pfOptions = [
  '胸部切口感染',
  '肺部感染',
  '呼吸功能不全',
  '气管切开',
  '急性肾功能不全',
  '肾脏血滤治疗',
  '多系统衰竭',
  '脑梗塞',
  '脑出血',
  '精神症状(如谵妄)',
  '截瘫',
  '偏瘫',
  '软瘫',
  '轻瘫',
  '术后肝功能不全',
  '胃肠道出血',
  '肠梗阻',
  '急性胰腺炎',
  '心功能不全',
  '凝血功能不全',
]

export default {
  data () {
    return {
      loading: false,
      form: this.$form.createForm(this),
      surgicalInfo: {},
      pfOptions
    }
  },
  methods: {
    setFields () {
      let values = this.form.getFieldsValue(['shLjfztqsj', 'shZcqgcg', 'shShicutime', 'shZcicu', 'shZcicutime', 'shShkxzx', 'shQtzcssyy', 'shShbfz', 'shNote', 'shsfZs', 'shsfSczt', 'shsfDeath', 'shsfDeathDate', 'shsfXxgzcgy', 'shsfZcgysj', 'shsfXfjb', 'shsfXfjbsj', 'shsfQtbfz'])
      if (typeof values !== 'undefined') {
        Object.keys(values).forEach(_key => {
          if (values[_key] !== undefined) {
            this.surgicalInfo[_key] = values[_key]
          }

        })
      }
      return this.surgicalInfo
    },
    setFormValues ({ ...checkInfo }) {
      let fields = ['shLjfztqsj', 'shZcqgcg', 'shShicutime', 'shZcicu', 'shZcicutime', 'shShkxzx', 'shQtzcssyy', 'shShbfz', 'shNote', 'shsfZs', 'shsfSczt', 'shsfDeath', 'shsfDeathDate', 'shsfXxgzcgy', 'shsfZcgysj', 'shsfXfjb', 'shsfXfjbsj', 'shsfQtbfz']
      let fieldDates = ['shsfDeathDate', 'shsfZcgysj', 'shsfXfjbsj']
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
      this.surgicalInfo = checkInfo
    }
  }
}
</script>

<style>
</style>