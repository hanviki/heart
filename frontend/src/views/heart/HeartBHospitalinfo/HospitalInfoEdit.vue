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
          format='YYYY-MM-DD'
          v-decorator="['outHospital', {}]"
        />
      </a-form-item>
      <a-form-item label="住院转归">
        <a-radio-group v-decorator="['inRedirect', {}]" :options="inRedirectOptions">
        </a-radio-group>
      </a-form-item>
      <!-- <a-form-item label="死亡原因">
        <a-input
          placeholder="请输入死亡原因"
          v-decorator="['deathInfo',  {rules:[{max:100,message:'最长不超过100'}]}]"
        />
      </a-form-item>
      <a-form-item label="死亡日期">
        <a-date-picker
          format='YYYY-MM-DD'
          v-decorator="['swsj', {}]"
        />
      </a-form-item>
      <a-form-item label="住院转归备注">
        <a-input
          placeholder="请输入住院转归备注"
          v-decorator="['inRedirectnote',  {rules:[{max:100,message:'最长不超过100'}]}]"
        />
      </a-form-item> -->
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
        <a-tooltip placement="top">
          <template slot="title" trigger="hover">
            A 型： 仅局限于升主动脉的夹层， 夹层中止于无名动脉近端； <br>
            B 型：夹层局限于胸降主动脉， 或延伸到腹主动脉； <br>
            C 型： 夹层累及主动脉弓， 无论升主动脉和胸降主动脉是否受到累及。 Cp型： 夹层仅累及到主动脉弓近心侧的无名动脉和（或） 左颈总动脉； Cd 型： 夹层仅累及到主动脉弓远心侧的左锁骨下动脉和（或） 左颈总动脉； <br>
            D 型： 夹层局限于膈肌水平以下的腹主动脉和（或） 髂动脉。
          </template>
          <a-icon type="question-circle" theme="twoTone" />
        </a-tooltip>
      </a-form-item>
       <a-form-item label="夹层诊断（Stanford分层）">
         <a-radio-group v-decorator="['inRedirectnote', {}]">
          <a-radio value="A">
           A
          </a-radio>
          <a-radio value="B">
            B
          </a-radio>
        </a-radio-group>
      </a-form-item>
      <a-form-item label="其他">
        <a-input
          placeholder="请输入其他诊断"
          v-decorator="['deathInfo',  {rules:[{max:100,message:'最长不超过100'}]}]"
        />
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
         <a-radio-group v-decorator="['zdmbss', {}]" @change="onZdmbssChange">
          <a-radio value="是">
           是
          </a-radio>
          <a-radio value="否">
            否
          </a-radio>
        </a-radio-group>
        <a-date-picker
          format='YYYY-MM-DD'
          v-if="isZdmbss"
          v-decorator="['zdmbssDate', {}]"
        />
      </a-form-item>
      <a-form-item label="全弓置换">
         <a-radio-group v-decorator="['qgzh', {}]" @change="onQgzhChange">
          <a-radio value="是">
           是
          </a-radio>
          <a-radio value="否">
            否
          </a-radio>
        </a-radio-group>
        <a-date-picker
          format='YYYY-MM-DD'
          v-if="isQgzh"
          v-decorator="['qgzhDate', {}]"
        />
      </a-form-item>
      <a-form-item label="夹层腔内修复术">
         <a-radio-group v-decorator="['jcqnxfs', {}]" @change="onJcqnxfsChange">
          <a-radio value="是">
           是
          </a-radio>
          <a-radio value="否">
            否
          </a-radio>
        </a-radio-group>
        <a-date-picker
          format='YYYY-MM-DD'
          v-if="isJcqnxfs"
          v-decorator="['jcqnxfsDate', {}]"
        />
      </a-form-item>
      <a-form-item label="其他主动干预 (如 无 请填写 “-”)">
        <a-input
          placeholder="请输入其他主动干预"
          v-decorator="['qtzdgy',  {rules:[{max:50,message:'最长不超过50'}]}]"
        />
      </a-form-item>
      <a-form-item label="上次主动干预时间">
        <a-date-picker
          format='YYYY-MM-DD'
          v-decorator="['sczdgysj', {}]"
        />
      </a-form-item>
      <a-form-item label="主动脉疾病家族史 (如 无 请填写 “-”)">
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
import moment from 'moment'
const inRedirectOptions = [
  {label: '手术后死亡', value: '手术后死亡'},
  {label: '手术后存活', value: '手术后存活'},
  {label: '拟手术，术前死亡', value: '拟手术，术前死亡'},
  {label: '保守治疗，住院期间死亡', value: '保守治疗，住院期间死亡'},
  {label: '保守治疗，存活出院', value: '保守治疗，存活出院'},
  {label: '术后放弃,自动出院', value: '术后放弃,自动出院'},
  {label: '仍住院', value: '仍住院'}]
export default {
  data () {
    return {
      loading: false,
      form: this.$form.createForm(this),
      hospitalInfo: {},
      isZdmbss: false,
      isQgzh: false,
      isJcqnxfs: false,
      inRedirectOptions
    }
  },
  methods: {
    moment,
    reset () {
      this.loading = false
      this.hospitalInfo = {}
      this.form.resetFields()
      this.isZdmbss = false
      this.isQgzh = false
      this.isJcqnxfs = false
    },
    onZdmbssChange (e) {
      if (e.target.value === '是') {
        this.isZdmbss = true
      } else {
        this.isZdmbss = false
        this.form.setFieldsValue({ zdmbssDate: null })
      }
    },
    onQgzhChange (e) {
      if (e.target.value === '是') {
        this.isQgzh = true
      } else {
        this.isQgzh = false
        this.form.setFieldsValue({ qgzhDate: null })
      }
    },
    onJcqnxfsChange (e) {
      if (e.target.value === '是') {
        this.isJcqnxfs = true
      } else {
        this.isJcqnxfs = false
        this.form.setFieldsValue({ jcqnxfsDate: null })
      }
    },
    setFields () {
      let values = this.form.getFieldsValue(['zhusu', 'inHospital', 'outHospital', 'inRedirect', 'deathInfo', 'inRedirectnote', 'jczd', 'gxy', 'nyha', 'tnb', 'mfzhz', 'other', 'zdmbss', 'zdmbssDate', 'qgzh', 'qgzhDate', 'jcqnxfs', 'jcqnxfsDate', 'qtzdgy', 'sczdgysj', 'zdmjbjzs', 'xy', 'hj'])
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
      let fields = ['zhusu', 'inHospital', 'outHospital', 'inRedirect', 'deathInfo', 'inRedirectnote', 'jczd', 'gxy', 'nyha', 'tnb', 'mfzhz', 'other', 'zdmbss', 'zdmbssDate', 'qgzh', 'qgzhDate', 'jcqnxfs', 'jcqnxfsDate', 'qtzdgy', 'sczdgysj', 'zdmjbjzs', 'xy', 'hj']
      let fieldDates = ['inHospital', 'outHospital', 'sczdgysj', 'zdmbssDate', 'qgzhDate', 'jcqnxfsDate']
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
            if (key === 'zdmbss' || key === 'qgzh' || key === 'jcqnxfs') {
              if (key == 'zdmbss') {
                if (checkInfo[key] !== '' && checkInfo[key] !== null && checkInfo[key] === '是') {
                  this.isZdmbss = true
                } else {
                  this.isZdmbss = false
                }
              } else if (key === 'qgzh') {
                if (checkInfo[key] !== '' && checkInfo[key] !== null && checkInfo[key] === '是') {
                  this.isQgzh = true
                } else {
                  this.isQgzh = false
                }
              } else {
                if (checkInfo[key] !== '' && checkInfo[key] !== null && checkInfo[key] === '是') {
                  this.isJcqnxfs = true
                } else {
                  this.isJcqnxfs = false
                }
              }
            }
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
