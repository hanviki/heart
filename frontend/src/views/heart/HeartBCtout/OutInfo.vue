<template>
  <div>
    <a-form :form="form">
      <a-divider
        orientation="left"
        style="font-size:14px;"
      >6. 出院复查CT</a-divider>
       <muti-uploadFile :baseId="baseId"></muti-uploadFile>
      <a-form-item label="支架末端位置(胸椎序号)">
        <a-input
          placeholder="请输入支架末端位置(胸椎序号)"
          v-decorator="['fctZjwdwz', {rules:[{max:50,message:'最长不超过50'}]}]"
        />
      </a-form-item>
      <a-form-item label="窦直径(mm)">
        <a-input-number
          placeholder="请输入窦直径(mm)"
          v-decorator="['fctDzj', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="升主脉动直径(mm)">
        <a-input-number
          placeholder="请输入升主脉动直径(mm)"
          v-decorator="['fctSzmdzj', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="主动脉弓直径(mm)">
        <a-input-number
          placeholder="请输入主动脉弓直径(mm)"
          v-decorator="['fctZdmgzj', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="胸主动脉上段直径(mm)">
        <a-input-number
          placeholder="请输入胸主动脉上段直径(mm)"
          v-decorator="['fctXzdmsdzj', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="胸主动脉上段假腔/血肿直径(mm)">
        <a-input-number
          placeholder="请输入胸主动脉上段假腔/血肿直径(mm)"
          v-decorator="['fctXzdmsdjqxzzj', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="胸主动脉中段直径(mm)">
        <a-input-number
          placeholder="请输入胸主动脉中段直径(mm)"
          v-decorator="['fctXzdmzdzj', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="胸主动脉中段假腔/血肿直径(mm)">
        <a-input-number
          placeholder="请输入胸主动脉中段假腔/血肿直径(mm)"
          v-decorator="['fctXzdmzdjqzj', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="胸主动脉下段直径(mm)">
        <a-input-number
          placeholder="请输入胸主动脉下段直径(mm)"
          v-decorator="['fctXzdmxdzj', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="胸主动脉下段假腔/血肿直径(mm)">
        <a-input-number
          placeholder="请输入胸主动脉下段假腔/血肿直径(mm)"
          v-decorator="['fctXzdmxdjqzj', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="腹主动脉上段直径(mm)">
        <a-input-number
          placeholder="请输入腹主动脉上段直径(mm)"
          v-decorator="['fctFzdmsdzj', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="腹主动脉上段假腔/血肿直径(mm)">
        <a-input-number
          placeholder="请输入腹主动脉上段假腔/血肿直径(mm)"
          v-decorator="['fctFzdmsdjqzj', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="腹主动脉下段直径(mm)">
        <a-input-number
          placeholder="请输入腹主动脉下段直径(mm)"
          v-decorator="['fctFzdmxdzj', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="腹主动脉下段假腔/血肿直径(mm)">
        <a-input-number
          placeholder="请输入腹主动脉下段假腔/血肿直径(mm)"
          v-decorator="['fctFzdmxdjqzj', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="近端吻合口漏">
        <a-radio-group v-decorator="['fctJdwhkl', {}]">
          <a-radio value="是">
            是
          </a-radio>
          <a-radio value="否">
            否
          </a-radio>
        </a-radio-group>
      </a-form-item>
      <a-form-item label="远端吻合口漏">
        <a-radio-group v-decorator="['fctYdwhkl', {}]">
          <a-radio value="是">
            是
          </a-radio>
          <a-radio value="否">
            否
          </a-radio>
        </a-radio-group>
      </a-form-item>
      <a-form-item label="升主周围血肿">
        <a-radio-group v-decorator="['fctSzzwxz', {}]">
          <a-radio value="是">
            是
          </a-radio>
          <a-radio value="否">
            否
          </a-radio>
        </a-radio-group>

      </a-form-item>
      <a-form-item label="弓部血肿">
        <a-radio-group v-decorator="['fctGbxz', {}]">
          <a-radio value="是">
            是
          </a-radio>
          <a-radio value="否">
            否
          </a-radio>
        </a-radio-group>
      </a-form-item>
      <a-form-item label="假腔转归">
        <a-radio-group v-decorator="['fctJqzg', {}]">
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
      <a-form-item label="腹腔干转归">
        <a-radio-group v-decorator="['fctFqqzg', {}]">
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
      <a-form-item label="左肾脉动转归">
        <a-radio-group v-decorator="['fctZsmdzg', {}]">
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
      <a-form-item label="右肾脉动转归">
        <a-radio-group v-decorator="['fctYsmdzg', {}]">
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
      <a-form-item label="左髂总转归">
        <a-radio-group v-decorator="['fctZkzzg', {}]">
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
      <a-form-item label="右髂总转归">
        <a-radio-group v-decorator="['fctYkzzg', {}]">
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
      <a-form-item label="人工血管异常说明">
        <a-input
          placeholder="请输入人工血管异常说明"
          v-decorator="['fctRgxgycsm', {rules:[{max:50,message:'最长不超过50'}]}]"
        />
      </a-form-item>
      <a-form-item label="动脉瘤样扩张">
        <a-radio-group v-decorator="['fctDmlykz', {}]">
          <a-radio value="是">
            是
          </a-radio>
          <a-radio value="否">
            否
          </a-radio>
        </a-radio-group>
      </a-form-item>
      <a-form-item label="支架异常说明">
        <a-input
          placeholder="请输入支架异常说明"
          v-decorator="['fctZjycsm',{rules:[{max:50,message:'最长不超过50'}]}]"
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
   components: {MutiUploadFile} ,
  mounted () {
    // this.fetch()
  },
  methods: {
    reset () {
        this.loading = false
        this.ctfcInfo = {}
        this.form.resetFields()
        this.baseId = ''
    },
    setFields () {
      let values = this.form.getFieldsValue(['fctFileName', 'fctFilePath', 'fctZjwdwz', 'fctDzj', 'fctSzmdzj', 'fctZdmgzj', 'fctXzdmsdzj', 'fctXzdmsdjqxzzj', 'fctXzdmzdzj', 'fctXzdmzdjqzj', 'fctXzdmxdzj', 'fctXzdmxdjqzj', 'fctFzdmsdzj', 'fctFzdmsdjqzj', 'fctFzdmxdzj', 'fctFzdmxdjqzj', 'fctJdwhkl', 'fctYdwhkl', 'fctSzzwxz', 'fctGbxz', 'fctJqzg', 'fctFqqzg', 'fctZsmdzg', 'fctYsmdzg', 'fctZkzzg', 'fctYkzzg', 'fctRgxgycsm', 'fctDmlykz', 'fctZjycsm'])
      if (typeof values !== 'undefined') {
          Object.keys(values).forEach(_key => {
          if (values[_key] !== undefined) {
            this.ctfcInfo[_key] = values[_key]
          }

        })
      }
      this.ctfcInfo.id =this.baseId
      return this.ctfcInfo
    },
     fetch () {
       this.$get('comFile/getUid?time='+ new Date().getTime()).then(res => {
          this.baseId =res.data.data
       })
       console.log('出院复查CT Id 创建成功.')
    }
  }
}
</script>

<style>
</style>