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
        label="PH"
      >
        <a-input-number
          :precision="2"
          :max="99999999.99"
          style="width:100%;"
          v-decorator="[ 'ph',{}]"
        />
      </a-form-item>
      <a-form-item
        label="PO2"
      >
        <a-input-number
          :precision="2"
          :max="99999999.99"
          style="width:100%;"
          v-decorator="[ 'po2',{}]"
        />
      </a-form-item>
      <a-form-item
        label="PCO2"
      >
        <a-input-number
          :precision="2"
          :max="99999999.99"
          style="width:100%;"
          v-decorator="[ 'pco2',{}]"
        />
      </a-form-item>
      <a-form-item
        label="K+"
      >
        <a-input-number
          :precision="2"
          :max="99999999.99"
          style="width:100%;"
          v-decorator="[ 'k',{}]"
        />
      </a-form-item>
      <a-form-item
        label="Na+"
      >
        <a-input-number
          :precision="2"
          :max="99999999.99"
          style="width:100%;"
          v-decorator="[ 'na',{}]"
        />
      </a-form-item>
      <a-form-item
        label="Ca+"
      >
        <a-input-number
          :precision="2"
          :max="99999999.99"
          style="width:100%;"
          v-decorator="[ 'ca',{}]"
        />
      </a-form-item>
      <a-form-item
        label="GLU"
      >
        <a-input-number
          :precision="2"
          :max="99999999.99"
          style="width:100%;"
          v-decorator="[ 'glu',{}]"
        />
      </a-form-item>
      <a-form-item
        label="BE"
      >
        <a-input-number
          :precision="2"
          :max="99999999.99"
          style="width:100%;"
          v-decorator="[ 'be',{}]"
        />
      </a-form-item>
      <a-form-item
        label="Lac"
      >
        <a-input-number
          :precision="2"
          :max="99999999.99"
          style="width:100%;"
          v-decorator="[ 'lac',{}]"
        />
      </a-form-item>
      <a-form-item
        label="Hb"
      >
        <a-input-number
          :precision="2"
          :max="99999999.99"
          style="width:100%;"
          v-decorator="[ 'hb',{}]"
        />
      </a-form-item>
      <a-form-item
        label="FiaO2"
      >
        <a-input-number
          :precision="2"
          :max="99999999.99"
          style="width:100%;"
          v-decorator="[ 'fiao2',{}]"
        />
      </a-form-item>
      <a-form-item
        label="SO2"
      >
        <a-input-number
          :precision="2"
          :max="99999999.99"
          style="width:100%;"
          v-decorator="[ 'so2',{}]"
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
export default {
  data () {
    return {
      loading: false,
      form: this.$form.createForm(this),
      csfcInfo: {

      }
    }
  },
  mounted () {
    // this.fetch()
  },
  components: {},
  methods: {
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
    }
  }
}
</script>

<style>
</style>
