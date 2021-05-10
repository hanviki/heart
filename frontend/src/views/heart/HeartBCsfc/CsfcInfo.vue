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
          v-decorator="['szdmzj', {}]"
          :precision="0"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item
        
        label="CT图片名称"
      >
        <a-input
          placeholder="请输入CT图片名称"
          v-decorator="['fileNamect', {}]"
        />
      </a-form-item>
      <a-form-item
        
        label="CT图片地址"
      >
        <a-input
          placeholder="请输入CT图片地址"
          v-decorator="['filePathct', {}]"
        />
      </a-form-item>
      <a-form-item
        
        label="主动脉窦直径"
      >
        <a-input
          placeholder="请输入主动脉窦直径"
          v-decorator="['ctZdmdzj', {}]"
        />
      </a-form-item>
      <a-form-item
        
        label="升主动脉直径"
      >
        <a-input
          placeholder="请输入升主动脉直径"
          v-decorator="['ctSzdmzj', {}]"
        />
      </a-form-item>
      <a-form-item
        
        label="主动脉弓直径"
      >
        <a-input
          placeholder="请输入主动脉弓直径"
          v-decorator="['ctZdmgzj', {}]"
        />
      </a-form-item>
      <a-form-item
        
        label="胸上主动脉直径"
      >
        <a-input
          placeholder="请输入胸上主动脉直径"
          v-decorator="['ctXszdmzj', {}]"
        />
      </a-form-item>
      <a-form-item
        
        label="胸中主动脉直径"
      >
        <a-input
          placeholder="请输入胸中主动脉直径"
          v-decorator="['ctXzzdmzj', {}]"
        />
      </a-form-item>
      <a-form-item
        
        label="胸下主动脉直径"
      >
        <a-input
          placeholder="请输入胸下主动脉直径"
          v-decorator="['ctXxzdmzj', {}]"
        />
      </a-form-item>
      <a-form-item
        
        label="腹主动脉上段直径"
      >
        <a-input
          placeholder="请输入腹主动脉上段直径"
          v-decorator="['ctFzdmsdzj', {}]"
        />
      </a-form-item>
      <a-form-item
        
        label="腹主动脉下段直径"
      >
        <a-input
          placeholder="请输入腹主动脉下段直径"
          v-decorator="['ctFzdmxdzj', {}]"
        />
      </a-form-item>
      <a-form-item
        
        label="升主动脉假腔直径"
      >
        <a-input
          placeholder="请输入升主动脉假腔直径"
          v-decorator="['ctSzdmjqzj', {}]"
        />
      </a-form-item>
      <a-form-item
        
        label="主动脉弓假腔直径"
      >
        <a-input
          placeholder="请输入主动脉弓假腔直径"
          v-decorator="['ctZdmgjqzj', {}]"
        />
      </a-form-item>
      <a-form-item
        
        label="胸上假腔直径"
      >
        <a-input
          placeholder="请输入胸上假腔直径"
          v-decorator="['ctXsjqzj', {}]"
        />
      </a-form-item>
      <a-form-item
        
        label="胸中假腔直径"
      >
        <a-input
          placeholder="请输入胸中假腔直径"
          v-decorator="['ctXzjqzj', {}]"
        />
      </a-form-item>
      <a-form-item
        
        label="胸下假腔直径"
      >
        <a-input
          placeholder="请输入胸下假腔直径"
          v-decorator="['ctXxjqzj', {}]"
        />
      </a-form-item>
      <a-form-item
        
        label="腹上假腔直径"
      >
        <a-input
          placeholder="请输入腹上假腔直径"
          v-decorator="['ctFsjqzj', {}]"
        />
      </a-form-item>
      <a-form-item
        
        label="腹下假腔直径"
      >
        <a-input
          placeholder="请输入腹下假腔直径"
          v-decorator="['ctFxjqzj', {}]"
        />
      </a-form-item>
      <a-form-item
        
        label="主动脉夹层阜外分型"
      >
        <a-input
          placeholder="请输入主动脉夹层阜外分型"
          v-decorator="['ctZdmjcfwfx', {}]"
        />
      </a-form-item>
      <a-form-item
        
        label="升主夹层病理"
      >
        <a-input
          placeholder="请输入升主夹层病理"
          v-decorator="['ctSzjcbl', {}]"
        />
      </a-form-item>
      <a-form-item
        
        label="主动脉弓假腔位置"
      >
        <a-input
          placeholder="请输入主动脉弓假腔位置"
          v-decorator="['ctZdmgjqwz', {}]"
        />
      </a-form-item>
      <a-form-item
        
        label="主动脉胸段病理"
      >
        <a-input
          placeholder="请输入主动脉胸段病理"
          v-decorator="['ctZdxdbl', {}]"
        />
      </a-form-item>
      <a-form-item
        
        label="主动脉胸段假腔位置"
      >
        <a-input
          placeholder="请输入主动脉胸段假腔位置"
          v-decorator="['ctZdxdjqwz', {}]"
        />
      </a-form-item>
      <a-form-item
        
        label="腹主动脉上段病理"
      >
        <a-input
          placeholder="请输入腹主动脉上段病理"
          v-decorator="['ctFzdmsdbl', {}]"
        />
      </a-form-item>
      <a-form-item
        
        label="腹主动脉假腔位置"
      >
        <a-input
          placeholder="请输入腹主动脉假腔位置"
          v-decorator="['ctFzdmjqwz', {}]"
        />
      </a-form-item>
      <a-form-item
        
        label="肾动脉下夹层病理"
      >
        <a-input
          placeholder="请输入肾动脉下夹层病理"
          v-decorator="['ctSdmxjcbl', {}]"
        />
      </a-form-item>
      <a-form-item
        
        label="肾下假腔位置"
      >
        <a-input
          placeholder="请输入肾下假腔位置"
          v-decorator="['ctSxjqwz', {}]"
        />
      </a-form-item>
      <a-form-item
        
        label="原发破口位置"
      >
        <a-input
          placeholder="请输入原发破口位置"
          v-decorator="['ctYfpkwz', {}]"
        />
      </a-form-item>
      <a-form-item
        
        label="原发破口大小"
      >
        <a-input
          placeholder="请输入原发破口大小"
          v-decorator="['ctYfpkdx', {}]"
        />
      </a-form-item>
      <a-form-item
        
        label="缺血或重度受压分支血管"
      >
        <a-input
          placeholder="请输入缺血或重度受压分支血管"
          v-decorator="['ctQxhzdsyfzxg', {}]"
        />
      </a-form-item>
      <a-form-item
        
        label="完全缺血器官"
      >
        <a-input
          placeholder="请输入完全缺血器官"
          v-decorator="['ctWqqxqg', {}]"
        />
      </a-form-item>
      <a-form-item
        
        label="夹层累及范围"
      >
        <a-input
          placeholder="请输入夹层累及范围"
          v-decorator="['ctJcljfw', {}]"
        />
      </a-form-item>
      <a-form-item
        
        label="主动脉夹层特殊征象"
      >
        <a-input
          placeholder="请输入主动脉夹层特殊征象"
          v-decorator="['ctZdmjctszx', {}]"
        />
      </a-form-item>
      <a-form-item
        
        label="假腔供血器官"
      >
        <a-input
          placeholder="请输入假腔供血器官"
          v-decorator="['ctJqgxqg', {}]"
        />
      </a-form-item>
      <a-form-item
        
        label="备注"
      >
        <a-input
          placeholder="请输入备注"
          v-decorator="['ctNote', {}]"
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
    this.fetch()
  },
   components: {MutiUploadFile} ,
  methods: {
    setFields () {
      let values = this.form.getFieldsValue([ 'avr', 'mvr', 'sbydycwz', 'xbjy', 'ef', 'zsszwnj', 'zdmbhzj', 'zdmdzj', 'szdmzj'])
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
    }
  }
}
</script>

<style>
</style>