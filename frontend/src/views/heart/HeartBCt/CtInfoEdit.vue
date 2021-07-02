<template>
  <div>
    <a-form :form="form">
      
       <a-divider orientation="left" style="font-size:14px;">5. 术前CT</a-divider>
       <a-divider orientation="left" style="font-size:14px;">2.5.1、直径测量</a-divider>
       <muti-uploadFile :baseId="baseId" :isEdit="isEdit"></muti-uploadFile>
     
      <a-form-item
        
        label="主动脉窦直径(mm)"
      >
        <a-input-number
          placeholder="请输入主动脉窦直径(mm)"
          v-decorator="['ctZdmdzj', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item
        
        label="升主动脉直径(mm)"
      >
        <a-input-number
          placeholder="请输入升主动脉直径(mm)"
          v-decorator="['ctSzdmzj', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item
        
        label="主动脉弓直径(mm)"
      >
        <a-input-number
          placeholder="请输入主动脉弓直径(mm)"
          v-decorator="['ctZdmgzj', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item
        
        label="胸上主动脉直径(mm)"
      >
        <a-input-number
          placeholder="请输入胸上主动脉直径(mm)"
          v-decorator="['ctXszdmzj', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item
        
        label="胸中主动脉直径(mm)"
      >
        <a-input-number
          placeholder="请输入胸中主动脉直径(mm)"
          v-decorator="['ctXzzdmzj', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item
        
        label="胸下主动脉直径(mm)"
      >
        <a-input-number
          placeholder="请输入胸下主动脉直径(mm)"
          v-decorator="['ctXxzdmzj', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item
        
        label="腹主动脉上段直径(mm)"
      >
        <a-input-number
          placeholder="请输入腹主动脉上段直径(mm)"
          v-decorator="['ctFzdmsdzj', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item
        
        label="腹主动脉下段直径(mm)"
      >
        <a-input-number
          placeholder="请输入腹主动脉下段直径(mm)"
          v-decorator="['ctFzdmxdzj', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item
        
        label="升主动脉假腔直径(mm)"
      >
        <a-input-number
          placeholder="请输入升主动脉假腔直径(mm)"
          v-decorator="['ctSzdmjqzj', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item
        
        label="主动脉弓假腔直径(mm)"
      >
        <a-input-number
          placeholder="请输入主动脉弓假腔直径(mm)"
          v-decorator="['ctZdmgjqzj', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item
        
        label="胸上假腔直径(mm)"
      >
        <a-input-number
          placeholder="请输入胸上假腔直径(mm)"
          v-decorator="['ctXsjqzj', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item
        
        label="胸中假腔直径(mm)"
      >
        <a-input-number
          placeholder="请输入胸中假腔直径(mm)"
          v-decorator="['ctXzjqzj', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item
        
        label="胸下假腔直径(mm)"
      >
        <a-input-number
          placeholder="请输入胸下假腔直径(mm)"
          v-decorator="['ctXxjqzj', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item
        
        label="腹上假腔直径(mm)"
      >
        <a-input-number
          placeholder="请输入腹上假腔直径(mm)"
          v-decorator="['ctFsjqzj', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item
        
        label="腹下假腔直径(mm)"
      >
        <a-input-number
          placeholder="请输入腹下假腔直径(mm)"
          v-decorator="['ctFxjqzj', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
       <a-divider orientation="left" style="font-size:14px;">2.5.2、夹层描述</a-divider>
      <a-form-item
        
        label="主动脉夹层阜外分型"
      >
        <a-input
          placeholder="请输入主动脉夹层阜外分型"
          v-decorator="['ctZdmjcfwfx', {rules:[{max:50,message:'最长不超过50'}]}]"
        />
      </a-form-item>
      <a-form-item
        
        label="升主夹层病理"
      >
        <a-radio-group v-decorator="['ctSzjcbl', {}]">
          <a-radio value="新月形">
            新月形
          </a-radio>
          <a-radio value="套筒形">
            套筒形
          </a-radio>
          <a-radio value="融合型">
            融合型
          </a-radio>
        </a-radio-group>
      </a-form-item>
      <a-form-item
        
        label="主动脉弓假腔位置"
      >
        <a-radio-group v-decorator="['ctZdmgjqwz', {}]">
          <a-radio value="大弯侧">
            大弯侧
          </a-radio>
          <a-radio value="小弯侧">
            小弯侧
          </a-radio>
        </a-radio-group>
      </a-form-item>
      <a-form-item
        
        label="主动脉胸段病理"
      >
        <a-radio-group v-decorator="['ctZdxdbl', {}]">
          <a-radio value="新月形">
            新月形
          </a-radio>
          <a-radio value="套筒形">
            套筒形
          </a-radio>
          <a-radio value="融合型">
            融合型
          </a-radio>
        </a-radio-group>
      </a-form-item>
      <a-form-item
        
        label="主动脉胸段假腔位置"
      >
        <a-radio-group v-decorator="['ctZdxdjqwz', {}]">
          <a-radio value="脊柱侧">
            脊柱侧
          </a-radio>
          <a-radio value="非脊柱侧">
            非脊柱侧
          </a-radio>
        </a-radio-group>
      </a-form-item>
      <a-form-item
        
        label="腹主动脉上段病理"
      >
        <a-radio-group v-decorator="['ctFzdmsdbl', {}]">
          <a-radio value="新月形">
            新月形
          </a-radio>
          <a-radio value="套筒形">
            套筒形
          </a-radio>
          <a-radio value="融合型">
            融合型
          </a-radio>
        </a-radio-group>
      </a-form-item>
      <a-form-item
        
        label="腹主动脉假腔位置"
      >
        <a-radio-group v-decorator="['ctFzdmjqwz', {}]">
          <a-radio value="脊柱侧">
            脊柱侧
          </a-radio>
          <a-radio value="非脊柱侧">
            非脊柱侧
          </a-radio>
        </a-radio-group>
      </a-form-item>
      <a-form-item
        
        label="肾动脉下夹层病理"
      >
        <a-radio-group v-decorator="['ctSdmxjcbl', {}]">
          <a-radio value="新月形">
            新月形
          </a-radio>
          <a-radio value="套筒形">
            套筒形
          </a-radio>
          <a-radio value="融合型">
            融合型
          </a-radio>
        </a-radio-group>
      </a-form-item>
      <a-form-item
        
        label="肾下假腔位置"
      >
        <a-radio-group v-decorator="['ctSxjqwz', {}]">
          <a-radio value="脊柱侧">
            脊柱侧
          </a-radio>
          <a-radio value="非脊柱侧">
            非脊柱侧
          </a-radio>
        </a-radio-group>
      </a-form-item>
      <a-form-item
        
        label="原发破口位置"
      >
        <a-radio-group v-decorator="['ctYfpkwz', {}]">
          <a-radio value="窦部">
            窦部
          </a-radio>
          <a-radio value="升主">
            升主
          </a-radio>
          <a-radio value="弓">
            弓
          </a-radio>
          <a-radio value="降主">
            降主
          </a-radio>
        </a-radio-group>
      </a-form-item>
      <a-form-item
        
        label="原发破口大小(mm)"
      >
        <a-input-number
          placeholder="请输入原发破口大小(mm)"
          v-decorator="['ctYfpkdx', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item
        
        label="缺血或重度受压分支血管"
      >
        <a-input
          placeholder="请输入缺血或重度受压分支血管"
          v-decorator="['ctQxhzdsyfzxg', {rules:[{max:50,message:'最长不超过50'}]}]"
        />
      </a-form-item>
      <a-form-item
        
        label="完全缺血器官"
      >
        <a-input
          placeholder="请输入完全缺血器官"
          v-decorator="['ctWqqxqg', {rules:[{max:50,message:'最长不超过50'}]}]"
        />
      </a-form-item>
      <a-form-item
        
        label="夹层累及范围"
      >
        <a-checkbox-group
          v-decorator="['ctJcljfw', {}]"
          :options="jcOptions"
        />
      </a-form-item>
      <a-form-item
        
        label="主动脉夹层特殊征象"
      >
        <a-checkbox-group
          v-decorator="['ctZdmjctszx', {}]"
          :options="zdmOptions"
        />
      </a-form-item>
      <a-form-item
        
        label="假腔供血器官"
      >
        <a-input
          placeholder="请输入假腔供血器官"
          v-decorator="['ctJqgxqg',  {rules:[{max:50,message:'最长不超过50'}]}]"
        />
      </a-form-item>
      <a-form-item
        
        label="备注"
      >
        <a-input
          placeholder="请输入备注"
          v-decorator="['ctNote',  {rules:[{max:50,message:'最长不超过50'}]}]"
        />
      </a-form-item>
    </a-form>
  </div>
</template>

<script>
import MutiUploadFile from '../../common/MutiUploadFile'
import moment from 'moment'
const jcOptions = ['右无交界', '左无交界', '左右交界', '无窦', '右窦', '左窦', '右冠', '左冠',
  '无名', '右颈总', '右锁下', '左颈总', '左锁骨下',
  '腹腔干', '肠系膜上', '左肾脉动', '右肾脉动', '左髂脉动', '右髂脉动']
const zdmOptions = [
  '云雾征',
  '纵膈血肿',
  '心包积液/血',
  '胸腔积液/血',
  '肺渗出',
  '胃肠胀气',
  '升主动脉离断'
]
export default {
  props: {
    isEdit: {
        default: true
    }
  },
  data () {
    return {
      loading: false,
      form: this.$form.createForm(this),
      ctInfo: {},
      jcOptions,
      zdmOptions,
      baseId: ''
    }
  },
  components: {MutiUploadFile} ,
  mounted () {
   // this.fetch()
  },
  methods: {
    moment,
    reset () {
      this.loading = false
      this.ctInfo = {}
      this.form.resetFields()
      this.baseId = ''
    },
    setFields () {
      let values = this.form.getFieldsValue(['ctZdmdzj', 'ctSzdmzj', 'ctZdmgzj', 'ctXszdmzj', 'ctXzzdmzj', 'ctXxzdmzj', 'ctFzdmsdzj', 'ctFzdmxdzj', 'ctSzdmjqzj', 'ctZdmgjqzj', 'ctXsjqzj', 'ctXzjqzj', 'ctXxjqzj', 'ctFsjqzj', 'ctFxjqzj', 'ctZdmjcfwfx', 'ctSzjcbl', 'ctZdmgjqwz', 'ctZdxdbl', 'ctZdxdjqwz', 'ctFzdmsdbl', 'ctFzdmjqwz', 'ctSdmxjcbl', 'ctSxjqwz', 'ctYfpkwz', 'ctYfpkdx', 'ctQxhzdsyfzxg', 'ctWqqxqg', 'ctJcljfw', 'ctZdmjctszx', 'ctJqgxqg', 'ctNote'])
      if (typeof values !== 'undefined') {
          Object.keys(values).forEach(_key => {
          if (values[_key] !== undefined) {
            this.ctInfo[_key] = values[_key]
          }

        })
      }
     this.ctInfo.id =this.baseId
      return this.ctInfo
    },
    setFormValues ({ ...checkInfo }) {
      let fields = ['ctZdmdzj', 'ctSzdmzj', 'ctZdmgzj', 'ctXszdmzj', 'ctXzzdmzj', 'ctXxzdmzj', 'ctFzdmsdzj', 'ctFzdmxdzj', 'ctSzdmjqzj', 'ctZdmgjqzj', 'ctXsjqzj', 'ctXzjqzj', 'ctXxjqzj', 'ctFsjqzj', 'ctFxjqzj', 'ctZdmjcfwfx', 'ctSzjcbl', 'ctZdmgjqwz', 'ctZdxdbl', 'ctZdxdjqwz', 'ctFzdmsdbl', 'ctFzdmjqwz', 'ctSdmxjcbl', 'ctSxjqwz', 'ctYfpkwz', 'ctYfpkdx', 'ctQxhzdsyfzxg', 'ctWqqxqg', 'ctJcljfw', 'ctZdmjctszx', 'ctJqgxqg', 'ctNote']
      let fieldDates = []
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
            if (key =='ctJcljfw' || key =='ctZdmjctszx'){
              obj[key] = checkInfo[key] == '' ? null : JSON.parse(checkInfo[key])
            } else {
              obj[key] = checkInfo[key]
            }
          }
          this.form.setFieldsValue(obj)
        }
      })
      this.baseId = checkInfo.id
      this.ctInfo = checkInfo
    }
  }
}
</script>

<style>
</style>