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
      <a-form-item
        label="血气结果"
      >
         <a-radio-group v-decorator="['xqtype', {}]">
          <a-radio value="手术回即刻">
           手术回即刻
          </a-radio>
          <a-radio value="拔管时血气">
            拔管时血气
          </a-radio>
           <a-radio value="拔管后2小时">
            拔管后2小时
          </a-radio>
           <a-radio value="拔管后6小时">
            拔管后6小时
          </a-radio>
           <a-radio value="拔管后12小时">
            拔管后12小时
          </a-radio>
           <a-radio value="拔管后48小时">
            拔管后48小时
          </a-radio>
           <a-radio value="拔管后72小时">
            拔管后72小时
          </a-radio>
        </a-radio-group>
      </a-form-item>
      <a-form-item
        label="PH"
      >
        <a-input-number
          :precision="2"
          :max="99999999.99"
          style="width:100%;"
          v-decorator="[ 'ph',{ }]"
        />
      </a-form-item>
      <a-form-item
        label="PO2"
      >
        <a-input-number
          :precision="2"
          :max="99999999.99"
          style="width:100%;"
          v-decorator="[ 'po2',{ }]"
        />
      </a-form-item>
      <a-form-item
        label="PCO2"
      >
        <a-input-number
          :precision="2"
          :max="99999999.99"
          style="width:100%;"
          v-decorator="[ 'pco2',{ }]"
        />
      </a-form-item>
      <a-form-item
        label="K+"
      >
        <a-input-number
          :precision="2"
          :max="99999999.99"
          style="width:100%;"
          v-decorator="[ 'k',{ }]"
        />
      </a-form-item>
      <a-form-item
        label="Na+"
      >
        <a-input-number
          :precision="2"
          :max="99999999.99"
          style="width:100%;"
          v-decorator="[ 'na',{ }]"
        />
      </a-form-item>
      <a-form-item
        label="Ca+"
      >
        <a-input-number
          :precision="2"
          :max="99999999.99"
          style="width:100%;"
          v-decorator="[ 'ca',{ }]"
        />
      </a-form-item>
      <a-form-item
        label="GLU"
      >
        <a-input-number
          :precision="2"
          :max="99999999.99"
          style="width:100%;"
          v-decorator="[ 'glu',{ }]"
        />
      </a-form-item>
      <a-form-item
        label="BE"
      >
        <a-input-number
          :precision="2"
          :max="99999999.99"
          style="width:100%;"
          v-decorator="[ 'be',{ }]"
        />
      </a-form-item>
      <a-form-item
        label="Lac"
      >
        <a-input-number
          :precision="2"
          :max="99999999.99"
          style="width:100%;"
          v-decorator="[ 'lac',{ }]"
        />
      </a-form-item>
      <a-form-item
        label="Hb"
      >
        <a-input-number
          :precision="2"
          :max="99999999.99"
          style="width:100%;"
          v-decorator="[ 'hb',{ }]"
        />
      </a-form-item>
      <a-form-item
        label="FiaO2"
      >
        <a-input-number
          :precision="2"
          :max="99999999.99"
          style="width:100%;"
          v-decorator="[ 'fiao2',{ }]"
        />
      </a-form-item>
      <a-form-item
        label="SO2"
      >
        <a-input-number
          :precision="2"
          :max="99999999.99"
          style="width:100%;"
          v-decorator="[ 'so2',{ }]"
        />
      </a-form-item>
      <a-form-item
        label="备注"
      >
        <a-input
          placeholder="请输入备注"
          v-decorator="['note', {rules:[{max:50,message:'最长不超过50'} ]}]"
        />
      </a-form-item>
    </a-form>
  </div>
</template>

<script>
import moment from 'moment'
export default {
  props: {
    checkInfo: {
      default: {}
    }
  },
  data () {
    return {
      loading: false,
      form: this.$form.createForm(this),
      csfcInfo: {
      }
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
    },
    setFields () {
      let values = this.form.getFieldsValue(['checkDate', 'xqtype', 'ph', 'po2', 'pco2', 'k', 'na', 'ca', 'glu', 'be', 'lac', 'hb', 'fiao2', 'so2', 'note'])
      if (typeof values !== 'undefined') {
        Object.keys(values).forEach(_key => {
          if (values[_key] !== undefined) {
            this.csfcInfo[_key] = values[_key]
          }
        })
      }
      return this.csfcInfo
    },
    setFormValues ({ ...checkInfo }) {
      let fields = ['id', 'username', 'fileNo', 'name', 'checkDate', 'xqtype', 'ph', 'po2', 'pco2', 'k', 'na', 'ca', 'glu', 'be', 'lac', 'hb', 'fiao2', 'so2', 'note']
      let fieldDates = ['checkDate']
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
      this.csfcInfo = checkInfo
    }
  }
}
</script>

<style>
</style>
