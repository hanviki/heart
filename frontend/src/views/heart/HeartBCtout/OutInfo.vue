<template>
  <div>
    <a-form :form="form">
      <a-divider
        orientation="left"
        style="font-size:14px;"
      >6.1 出院复查CT</a-divider>
       <muti-uploadFile :baseId="baseId" refTab="outctfc"></muti-uploadFile>
       <a-form-item
        label="检测时间"
      >
        <a-date-picker
          showTime
          format='YYYY-MM-DD HH:mm'
          v-decorator="[ 'checkDate', {}]"
        />
      </a-form-item>
      <a-form-item label="病人状态">
        <a-radio-group v-decorator="['brzt', {}]">
          <a-radio value="步行返院">
            步行返院
          </a-radio>
          <a-radio value="平车返院">
            平车返院
          </a-radio>
          <a-radio value="急诊返院">
            急诊返院
          </a-radio>
          <a-radio value="外院救治无法返院">
            外院救治无法返院
          </a-radio>
        </a-radio-group>
      </a-form-item>
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
      <a-divider
        orientation="left"
        style="font-size:14px;"
      >6.2 肝功能</a-divider>
      <a-form-item
        label="检测时间"
      >
        <a-date-picker
          showTime
          format='YYYY-MM-DD HH:mm'
          v-decorator="[ 'checkDate2', {}]"
        />
      </a-form-item>
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
      <a-form-item label="肌酐(umol/L)">
        <a-input-number
          placeholder="请输入肌酐(umol/L)"
          v-decorator="['jg', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
      <a-form-item label="尿素氮(umol/L)">
        <a-input-number
          placeholder="请输入尿素氮(umol/L)"
          v-decorator="['nsd', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
       <a-form-item label="尿酸(umol/L)">
        <a-input-number
          placeholder="请输入尿酸(umol/L)"
          v-decorator="['ns', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>

       <a-form-item label="白蛋白(G/L)">
        <a-input-number
          placeholder="请输入白蛋白(g/L)"
          v-decorator="['bdb', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
       <a-form-item label="胱仰素C(MG/L)">
        <a-input-number
          placeholder="请输入胱仰素C(Mg/L)"
          v-decorator="['gysc', {}]"
          :precision="2"
          style="width:100%;"
        />
      </a-form-item>
       <a-form-item label="肾小球滤过率(ml/min/1.703m)">
         <a-input
          placeholder="请输入肾小球滤过率"
          v-decorator="['sxqlgl', {rules:[{max:50,message:'最长不超过50'}]}]"
        />
      </a-form-item>
      <a-divider
        orientation="left"
        style="font-size:14px;"
      >6.3 超声</a-divider>
      <muti-uploadFile :baseId="baseId" refTab="outcsfc"></muti-uploadFile>
      <a-form-item
        label="检测时间"
      >
        <a-date-picker
          showTime
          format='YYYY-MM-DD HH:mm'
          v-decorator="[ 'checkDate3', {}]"
        />
      </a-form-item>
      <a-form-item
        label="AVR"
      >
        <a-radio-group v-decorator="['avr', {}]">
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
        label="MVR"
      >
        <a-radio-group v-decorator="['mvr', {}]">
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
      let values = this.form.getFieldsValue(['checkDate', 'brzt', 'fctFileName', 'fctFilePath', 'fctZjwdwz', 'fctDzj', 'fctSzmdzj', 'fctZdmgzj', 'fctXzdmsdzj', 'fctXzdmsdjqxzzj', 'fctXzdmzdzj', 'fctXzdmzdjqzj', 'fctXzdmxdzj', 'fctXzdmxdjqzj', 'fctFzdmsdzj', 'fctFzdmsdjqzj', 'fctFzdmxdzj', 'fctFzdmxdjqzj', 'fctJdwhkl', 'fctYdwhkl', 'fctSzzwxz', 'fctGbxz', 'fctJqzg', 'fctFqqzg', 'fctZsmdzg', 'fctYsmdzg', 'fctZkzzg', 'fctYkzzg', 'fctRgxgycsm', 'fctDmlykz', 'fctZjycsm', 'checkDate2', 'xjg', 'alt', 'ast', 'zdhs', 'zjdhs', 'dfm', 'jg', 'nsd', 'ns', 'bdb' ,'gysc', 'sxqlgl', 'checkDate3', 'avr', 'mvr', 'sbydycwz', 'xbjy', 'ef', 'zsszwnj', 'zdmbhzj', 'zdmdzj', 'szdmzj'])
      if (typeof values !== 'undefined') {
        Object.keys(values).forEach(_key => {
          if (values[_key] !== undefined) {
            this.ctfcInfo[_key] = values[_key]
          }
        })
      }
      this.ctfcInfo.id = this.baseId
      return this.ctfcInfo
    },
    fetch () {
      this.$get('comFile/getUid?time=' + new Date().getTime()).then(res => {
        this.baseId = res.data.data
      })
      console.log('门诊复查 Id 创建成功.')
    }
  }
}
</script>

<style>
</style>
