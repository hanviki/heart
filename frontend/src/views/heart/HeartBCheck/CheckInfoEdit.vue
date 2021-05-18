<template>
  <div>
    <a-form :form="form">
      <a-divider
        orientation="left"
        style="font-size:14px;"
      >3. 检验</a-divider>
      <a-divider
        orientation="left"
        style="font-size:14px;"
      >2.3.1、 心梗三项</a-divider>
      <a-form-item label="肌红蛋白">
        <a-input-number
          placeholder="请输入肌红蛋白"
          v-decorator="['jhdb', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="肌钙蛋白">
        <a-input-number
          placeholder="请输入肌钙蛋白"
          v-decorator="['jgdb', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="CK-MB">
        <a-input-number
          placeholder="请输入CK-MB"
          v-decorator="['ckmb', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="超敏肌钙蛋白（optional）">
        <a-input-number
          placeholder="请输入超敏肌钙蛋白（optional）"
          v-decorator="['cmjgdb', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-divider
        orientation="left"
        style="font-size:14px;"
      >2.3.2 血常规</a-divider>
      <a-form-item label="红细胞计数">
        <a-input-number
          placeholder="请输入红细胞计数"
          v-decorator="['hxbjs', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="血红蛋白">
        <a-input-number
          placeholder="请输入血红蛋白"
          v-decorator="['xhdb', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="白细胞计数">
        <a-input-number
          placeholder="请输入白细胞计数"
          v-decorator="['bxbjs', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="中性粒细胞百分比">
        <a-input-number
          placeholder="请输入中性粒细胞百分比"
          v-decorator="['zxlxbbfb', {}]"
          :precision="0"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="血小板计数">
        <a-input-number
          placeholder="请输入血小板计数"
          v-decorator="['xxbjs', {}]"
          :precision="0"
          style="width:100%;"
        />
      </a-form-item>
      <a-divider
        orientation="left"
        style="font-size:14px;"
      >2.3.3、血气分析</a-divider>
      <a-form-item label="PH">
        <a-input-number
          placeholder="请输入PH"
          v-decorator="['ph', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="乳酸">
        <a-input-number
          placeholder="请输入乳酸"
          v-decorator="['rs', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="BE">
        <a-input-number
          placeholder="请输入BE"
          v-decorator="['be', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="SO2">
        <a-input-number
          placeholder="请输入SO2"
          v-decorator="['so2', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="PO2">
        <a-input-number
          placeholder="请输入PO2"
          v-decorator="['po2', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="PCO2">
        <a-input-number
          placeholder="请输入PCO2"
          v-decorator="['pco2', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-divider
        orientation="left"
        style="font-size:14px;"
      >2.3.4、肝肾功</a-divider>
      <a-form-item label="血肌肝umol/L">
        <a-input-number
          placeholder="请输入血肌肝umol/L"
          v-decorator="['xjg', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="ALT(U/L)">
        <a-input-number
          placeholder="请输入ALT(U/L)"
          v-decorator="['alt', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="AST(U/L)">
        <a-input-number
          placeholder="请输入AST(U/L)"
          v-decorator="['ast', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="总胆红素(umol/L)">
        <a-input-number
          placeholder="请输入总胆红素(umol/L)"
          v-decorator="['zdhs', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="直接胆红素(umol/L)">
        <a-input-number
          placeholder="请输入直接胆红素"
          v-decorator="['zjdhs', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="淀粉酶(U)">
        <a-input-number
          placeholder="请输入淀粉酶(U)"
          v-decorator="['dfm', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-divider
        orientation="left"
        style="font-size:14px;"
      >2.3.5、凝血功能</a-divider>
      <a-form-item label="D二聚体(mg/L)">
        <a-input-number
          placeholder="请输入D二聚体(mg/L)"
          v-decorator="['d2jt', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="FDP(mg/L)">
        <a-input-number
          placeholder="请输入FDP(mg/L)"
          v-decorator="['fdp', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="PT(s)">
        <a-input-number
          placeholder="请输入PT(s)"
          v-decorator="['pt', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="APTT(s)">
        <a-input-number
          placeholder="请输入APTT(s)"
          v-decorator="['aptt', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
    </a-form>
  </div>
</template>

<script>
import moment from 'moment'
export default {
  data () {
    return {
      loading: false,
      form: this.$form.createForm(this),
      checkInfo: {},
      baseId: ''
    }
  },
  mounted () {

  },

  methods: {
    reset () {
      this.loading = false
      this.checkInfo = {}
      this.form.resetFields()
      this.baseId = ''
    },
    setFields () {
      let values = this.form.getFieldsValue(['jhdb', 'jgdb', 'ckmb', 'cmjgdb', 'hxbjs', 'xhdb', 'bxbjs', 'zxlxbbfb', 'xxbjs', 'ph', 'rs', 'be', 'so2', 'po2', 'pco2', 'xjg', 'alt', 'ast', 'zdhs', 'zjdhs', 'dfm', 'd2jt', 'fdp', 'pt', 'aptt'])
      if (typeof values !== 'undefined') {

        Object.keys(values).forEach(_key => {
          if (values[_key] !== undefined) {
            this.checkInfo[_key] = values[_key]
          }

        })
      }
      // this.checkInfo.id= this.baseId
      return this.checkInfo
    },
    setFormValues ({ ...checkInfo }) {
      let fields = ['jhdb', 'jgdb', 'ckmb', 'cmjgdb', 'hxbjs', 'xhdb', 'bxbjs', 'zxlxbbfb', 'xxbjs', 'ph', 'rs', 'be', 'so2', 'po2', 'pco2', 'xjg', 'alt', 'ast', 'zdhs', 'zjdhs', 'dfm', 'd2jt', 'fdp', 'pt', 'aptt']
      let fieldDates = []
      Object.keys(checkInfo).forEach((key) => {
        if (fields.indexOf(key) !== -1) {
          this.form.getFieldDecorator(key)
          let obj = {}
          if (fieldDates.indexOf(key) !== -1) {
            if (checkInfo[key] !== ''&&checkInfo[key] !== null) {
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
      this.checkInfo = checkInfo
    }
  }
}
</script>

<style>
</style>