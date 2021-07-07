<template>
  <div>
    <a-form :form="form">
      <a-divider orientation="left" style="font-size:14px;">2.5.1、 直径测量</a-divider>
       <muti-uploadFile :baseId="baseId"></muti-uploadFile>
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
        label="主动脉窦直径(mm)"
      >
        <a-input-number
          placeholder="请输入主动脉窦直径(mm)"
          v-decorator="['ctZdmdzj', {}]"
          :precision="2"
          :max="99999999.99"
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
          :max="99999999.99"
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
          :max="99999999.99"
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
          :max="99999999.99"
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
          :max="99999999.99"
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
          :max="99999999.99"
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
          :max="99999999.99"
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
          :max="99999999.99"
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
          :max="99999999.99"
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
          :max="99999999.99"
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
          :max="99999999.99"
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
          :max="99999999.99"
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
          :max="99999999.99"
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
          :max="99999999.99"
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
          :max="99999999.99"
          style="width:100%;"
        />
      </a-form-item>
       <a-divider orientation="left" style="font-size:14px;">2.5.2、夹层描述</a-divider>
      <a-form-item label="夹层诊断（阜外分型）">
         <a-radio-group v-decorator="['ctJcms', {}]">
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
         <a-radio-group v-decorator="['ctStanford', {}]">
          <a-radio value="A">
           A
          </a-radio>
          <a-radio value="B">
            B
          </a-radio>
        </a-radio-group>
      </a-form-item>
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
          :max="99999999.99"
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
const jcOptions = [
  { label: '右无交界', value: '右无交界' },
  { label: '左无交界', value: '左无交界' },
  { label: '左右交界', value: '左右交界' },
  { label: '无窦', value: '无窦' },
  { label: '右窦', value: '右窦' },
  { label: '左窦', value: '左窦' },
  { label: '右冠', value: '右冠' },
  { label: '左冠', value: '左冠' },
  { label: '无名', value: '无名' },
  { label: '右颈总', value: '右颈总' },
  { label: '右锁下', value: '右锁下' },
  { label: '左颈总', value: '左颈总' },
  { label: '左锁骨下', value: '左锁骨下' },
  { label: '腹腔干', value: '腹腔干' },
  { label: '肠系膜上', value: '肠系膜上' },
  { label: '左肾脉动', value: '左肾脉动' },
  { label: '右肾脉动', value: '右肾脉动' },
  { label: '左髂脉动', value: '左髂脉动' },
  { label: '右髂脉动', value: '右髂脉动' }]
const zdmOptions = [
  { label: '云雾征', value: '云雾征' },
  { label: '纵膈血肿', value: '纵膈血肿' },
  { label: '心包积液/血', value: '心包积液/血' },
  { label: '胸腔积液/血', value: '胸腔积液/血' },
  { label: '肺渗出', value: '肺渗出' },
  { label: '胃肠胀气', value: '胃肠胀气' },
  { label: '升主动脉离断', value: '升主动脉离断' }]

export default {
  props: {
    baseId: {
      default: {}
    }
  },
  data () {
    return {
      loading: false,
      form: this.$form.createForm(this),
      ctInfo: {},
      jcOptions,
      zdmOptions
    }
  },
  components: {MutiUploadFile},
  mounted () {
    // this.fetch()
  },
  methods: {
    reset () {
      this.loading = false
      this.ctInfo = {}
      this.form.resetFields()
    },
    setFields () {
      let values = this.form.getFieldsValue(['checkDate', 'ctJcms', 'ctStanford', 'ctZdmdzj', 'ctSzdmzj', 'ctZdmgzj', 'ctXszdmzj', 'ctXzzdmzj', 'ctXxzdmzj', 'ctFzdmsdzj', 'ctFzdmxdzj', 'ctSzdmjqzj', 'ctZdmgjqzj', 'ctXsjqzj', 'ctXzjqzj', 'ctXxjqzj', 'ctFsjqzj', 'ctFxjqzj', 'ctZdmjcfwfx', 'ctSzjcbl', 'ctZdmgjqwz', 'ctZdxdbl', 'ctZdxdjqwz', 'ctFzdmsdbl', 'ctFzdmjqwz', 'ctSdmxjcbl', 'ctSxjqwz', 'ctYfpkwz', 'ctYfpkdx', 'ctQxhzdsyfzxg', 'ctWqqxqg', 'ctJcljfw', 'ctZdmjctszx', 'ctJqgxqg', 'ctNote'])
      if (typeof values !== 'undefined') {
        Object.keys(values).forEach(_key => {
          if (values[_key] !== undefined) {
            this.ctInfo[_key] = values[_key]
          }
        })
      }
      this.ctInfo.id = this.baseId
      return this.ctInfo
    }
  }
}
</script>

<style>
</style>
