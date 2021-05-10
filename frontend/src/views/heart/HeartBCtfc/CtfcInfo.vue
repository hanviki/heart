<template>
  <div>
    <a-form :form="form">
        <muti-uploadFile :baseId="baseId"></muti-uploadFile>
      <a-form-item
        
        label="CT复查时间"
      >
        <a-date-picker v-decorator="[ 'ctDate', {}]" />
      </a-form-item>
      <a-form-item
        
        label="支架末端位置(胸椎序号)"
      >
        <a-input
          placeholder="请输入支架末端位置(胸椎序号)"
          v-decorator="['zjwdwzCode', {rules:[{max:10,message:'最长不超过10'}]}]"
        />
      </a-form-item>
      <a-form-item
        
        label="窦直径(mm)"
      >
        <a-input-number
          placeholder="请输入窦直径(mm)"
          v-decorator="['dzj', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item
        
        label="升主脉动直径(mm)"
      >
        <a-input-number
          placeholder="请输入升主脉动直径(mm)"
          v-decorator="['szmdzj', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item
        
        label="主动脉弓直径(mm)"
      >
        <a-input-number
          placeholder="请输入主动脉弓直径(mm)"
          v-decorator="['zdmgzj', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item
        
        label="胸主动脉上段直径(mm)"
      >
        <a-input-number
          placeholder="请输入胸主动脉上段直径(mm)"
          v-decorator="['xzdmsdzj', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item
        
        label="胸主动脉上段假腔/血肿直径(mm)"
      >
        <a-input-number
          placeholder="请输入胸主动脉上段假腔/血肿直径(mm)"
          v-decorator="['xzdmsdjqxzzj', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item
        
        label="胸主动脉中段直径(mm)"
      >
        <a-input-number
          placeholder="请输入胸主动脉中段直径(mm)"
          v-decorator="['xzdmzdzj', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item
        
        label="胸主动脉中段假腔/血肿直径(mm)"
      >
        <a-input-number
          placeholder="请输入胸主动脉中段假腔/血肿直径(mm)"
          v-decorator="['xzdmzdjqzj', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item
        
        label="胸主动脉下段直径(mm)"
      >
        <a-input-number
          placeholder="请输入胸主动脉下段直径(mm)"
          v-decorator="['xzdmxdzj', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item
        
        label="胸主动脉下段假腔/血肿直径(mm)"
      >
        <a-input-number
          placeholder="请输入胸主动脉下段假腔/血肿直径(mm)"
          v-decorator="['xzdmxdjqzj', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item
        
        label="腹主动脉上段直径(mm)"
      >
        <a-input-number
          placeholder="请输入腹主动脉上段直径(mm)"
          v-decorator="['fzdmsdzj', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item
        
        label="腹主动脉上段假腔/血肿直径(mm)"
      >
        <a-input-number
          placeholder="请输入腹主动脉上段假腔/血肿直径(mm)"
          v-decorator="['fzdmsdjqzj', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item
        
        label="腹主动脉下段直径(mm)"
      >
        <a-input-number
          placeholder="请输入腹主动脉下段直径(mm)"
          v-decorator="['fzdmxdzj', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item
        
        label="腹主动脉下段假腔/血肿直径(mm)"
      >
        <a-input-number
          placeholder="请输入腹主动脉下段假腔/血肿直径(mm)"
          v-decorator="['fzdmxdjqzj', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item
        
        label="近端吻合口漏"
      >
        <a-radio-group v-decorator="['jdwhkl', {}]">
          <a-radio value="是">
            是
          </a-radio>
          <a-radio value="否">
            否
          </a-radio>
        </a-radio-group>
      </a-form-item>
      <a-form-item
        
        label="远端吻合口漏"
      >
        <a-radio-group v-decorator="['ydwhkl', {}]">
          <a-radio value="是">
            是
          </a-radio>
          <a-radio value="否">
            否
          </a-radio>
        </a-radio-group>
      </a-form-item>
      <a-form-item
        
        label="升主周围血肿"
      >
        <a-radio-group v-decorator="['szzwxz', {}]">
          <a-radio value="是">
            是
          </a-radio>
          <a-radio value="否">
            否
          </a-radio>
        </a-radio-group>

      </a-form-item>
      <a-form-item
        
        label="弓部血肿"
      >
        <a-radio-group v-decorator="['gbxz', {}]">
          <a-radio value="是">
            是
          </a-radio>
          <a-radio value="否">
            否
          </a-radio>
        </a-radio-group>
      </a-form-item>
      <a-form-item
        
        label="假腔转归"
      >
        <a-radio-group v-decorator="['jqzg', {}]">
          <a-radio value="完全闭合">
            完全闭合
          </a-radio>
          <a-radio value="部分血栓">
            部分血栓
          </a-radio>
          <a-radio value="继续通畅">
            继续通畅
          </a-radio>
        </a-radio-group>
      </a-form-item>
      <a-form-item
        
        label="腹腔干转归"
      >
        <a-radio-group v-decorator="['fqqzg', {}]">
          <a-radio value="完全闭合">
            完全闭合
          </a-radio>
          <a-radio value="部分血栓">
            部分血栓
          </a-radio>
          <a-radio value="继续通畅">
            继续通畅
          </a-radio>
        </a-radio-group>
      </a-form-item>
      <a-form-item
        
        label="左肾脉动转归"
      >
        <a-radio-group v-decorator="['zsmdzg', {}]">
          <a-radio value="完全闭合">
            完全闭合
          </a-radio>
          <a-radio value="部分血栓">
            部分血栓
          </a-radio>
          <a-radio value="继续通畅">
            继续通畅
          </a-radio>
        </a-radio-group>
      </a-form-item>
      <a-form-item
        
        label="右肾脉动转归"
      >
        <a-radio-group v-decorator="['ysmdzg', {}]">
          <a-radio value="完全闭合">
            完全闭合
          </a-radio>
          <a-radio value="部分血栓">
            部分血栓
          </a-radio>
          <a-radio value="继续通畅">
            继续通畅
          </a-radio>
        </a-radio-group>
      </a-form-item>
      <a-form-item
        
        label="左髂总转归"
      >
        <a-radio-group v-decorator="['zkzzg', {}]">
          <a-radio value="完全闭合">
            完全闭合
          </a-radio>
          <a-radio value="部分血栓">
            部分血栓
          </a-radio>
          <a-radio value="继续通畅">
            继续通畅
          </a-radio>
        </a-radio-group>
      </a-form-item>
      <a-form-item
        
        label="右髂总转归"
      >
        <a-radio-group v-decorator="['ykzzg', {}]">
          <a-radio value="完全闭合">
            完全闭合
          </a-radio>
          <a-radio value="部分血栓">
            部分血栓
          </a-radio>
          <a-radio value="继续通畅">
            继续通畅
          </a-radio>
        </a-radio-group>
      </a-form-item>
      <a-form-item
        
        label="人工血管异常说明"
      >
        <a-input
          placeholder="请输入人工血管异常说明"
          v-decorator="['rgxgycsm', {rules:[{max:50,message:'最长不超过50'}]}]"
        />
      </a-form-item>
      <a-form-item
        
        label="动脉瘤样扩张"
      >
        <a-radio-group v-decorator="['dmlykz', {}]">
          <a-radio value="是">
            是
          </a-radio>
          <a-radio value="否">
            否
          </a-radio>
        </a-radio-group>
      </a-form-item>
      <a-form-item
        
        label="支架异常说明"
      >
        <a-input
          placeholder="请输入支架异常说明"
          v-decorator="['zjycsm',{rules:[{max:50,message:'最长不超过50'}]}]"
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
      ctfcInfo: {},
      baseId: ''
    }
  },
  mounted () {
    this.fetch()
  },
   components: {MutiUploadFile} ,
  methods: {
    setFields () {
      let values = this.form.getFieldsValue([ 'ctDate', 'zjwdwzCode', 'dzj', 'szmdzj', 'zdmgzj', 'xzdmsdzj', 'xzdmsdjqxzzj', 'xzdmzdzj', 'xzdmzdjqzj', 'xzdmxdzj', 'xzdmxdjqzj', 'fzdmsdzj', 'fzdmsdjqzj', 'fzdmxdzj', 'fzdmxdjqzj', 'jdwhkl', 'ydwhkl', 'szzwxz', 'gbxz', 'jqzg', 'fqqzg', 'zsmdzg', 'ysmdzg', 'zkzzg', 'ykzzg', 'rgxgycsm', 'dmlykz', 'zjycsm'])
     if (typeof values !== 'undefined') {
          Object.keys(values).forEach(_key => {
          if (values[_key] !== undefined) {
            this.ctfcInfo[_key] = values[_key]
          }

        })
      }
      this.ctfcInfo.id= this.baseId
      return this.ctfcInfo
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