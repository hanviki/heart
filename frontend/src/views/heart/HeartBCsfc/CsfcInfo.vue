<template>
  <div>
    <a-form :form="form">
       <muti-uploadFile :baseId="baseId"></muti-uploadFile>
      <a-form-item
        label="AVR"
      >
        <a-input-number
          placeholder="请输入AVR"
          v-decorator="['avr', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item
        label="MVR"
      >
        <a-input-number
          placeholder="请输入MVR"
          v-decorator="['mvr', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item
        
        label="室壁运动异常位置"
      >
        <a-input
          placeholder="请输入室壁运动异常位置"
          v-decorator="['sbydycwz', {rules:[{max:20,message:'最长不超过20'}]}]"
        />
      </a-form-item>
      <a-form-item
        
        label="心包积液"
      >
        <a-radio-group v-decorator="['xbjy', {}]">
          <a-radio value="无">
            无
          </a-radio>
          <a-radio value="微量">
            微量
          </a-radio>
          <a-radio value="少量">
            少量
          </a-radio>
          <a-radio value="少中量">
            少中量
          </a-radio>
          <a-radio value="中大量">
            中大量
          </a-radio>
          <a-radio value="大量">
            大量
          </a-radio>
        </a-radio-group>
      </a-form-item>
      <a-form-item
        
        label="EF(%)"
      >
        <a-input-number
          placeholder="请输入EF(%)"
          v-decorator="['ef', {}]"
          :precision="0"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item
        
        label="左室舒张末内径(mm)"
      >
        <a-input-number
          placeholder="请输入左室舒张末内径(mm)"
          v-decorator="['zsszwnj', {}]"
          :precision="0"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item
        
        label="主动脉闭环直径(mm)"
      >
        <a-input-number
          placeholder="请输入主动脉闭环直径(mm)"
          v-decorator="['zdmbhzj', {}]"
          :precision="0"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item
        
        label="主动脉窦直径(mm)"
      >
        <a-input-number
          placeholder="请输入主动脉窦直径(mm)"
          v-decorator="['zdmdzj', {}]"
          :precision="0"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item
        
        label="升主动脉直径(mm)"
      >
        <a-input-number
          placeholder="请输入升主动脉直径(mm)"
          v-decorator="['szdmdzj', {}]"
          :precision="0"
          style="width:100%;"
        />
      </a-form-item>
    </a-form>
  </div>
</template>

<script>
import MutiUploadFile from '../../common/MutiUploadFile'
export default {
  data () {
    return {
      loading: false,
      form: this.$form.createForm(this),
      csfcInfo:{
              
        },
      baseId: ''
    }
  },
  mounted () {
    // this.fetch()
  },
   components: {MutiUploadFile} ,
  methods: {
    reset () {
      this.loading = false
      this.csfcInfo = {}
      this.form.resetFields()
      this.baseId = ''
    },
    setFields () {
      let values = this.form.getFieldsValue([ 'avr', 'mvr', 'sbydycwz', 'xbjy', 'ef', 'zsszwnj', 'zdmbhzj', 'zdmdzj', 'szdmdzj'])
      if (typeof values !== 'undefined') {
         Object.keys(values).forEach(_key => {
          if (values[_key] !== undefined) {
            this.csfcInfo[_key] = values[_key]
          }

        })
      }
      this.csfcInfo.id= this.baseId
      return this.csfcInfo
    },
    fetch () {
       this.$get('comFile/getUid?time='+ new Date().getTime()).then(res => {
          this.baseId =res.data.data
       })
       console.log('CsfcInfo Id 创建成功.')
    }
  }
}
</script>

<style>
</style>