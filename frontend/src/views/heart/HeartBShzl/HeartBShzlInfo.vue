<template>
  <div>
    <a-form :form="form">
      <a-form-item label="手术时间">
        <a-date-picker
          :showTime="{ format: 'HH:mm' }"
          format='YYYY-MM-DD HH:mm'
          v-decorator="[ 'ssDate', { }]" />
      </a-form-item>
      <a-form-item label="术后入住ICU总天数">
        <a-input-number
          :precision="2"
          style="width:100%;"
          v-decorator="[ 'icuDay',{ }]"
        />
      </a-form-item>
      <a-form-item label="再次入住ICU">
        <a-radio-group v-decorator="['icuAgain', {}]">
          <a-radio value="是">
           是
          </a-radio>
          <a-radio value="否">
            否
          </a-radio>
        </a-radio-group>
      </a-form-item>
      <a-form-item label="意识状态">
          <a-radio-group
          v-decorator="['shishui', {}]"
          :options="ysztOptions"
        />
         <a-input
          placeholder="请输入嗜睡备注" 
          v-decorator="['shishuiNote', { }]"
        />
      </a-form-item>
      <!-- <a-form-item label="模糊">
        <a-radio-group v-decorator="['mohu', {}]">
          <a-radio value="是">
           是
          </a-radio>
          <a-radio value="否">
            否
          </a-radio>
        </a-radio-group>
        <a-input
          placeholder="请输入模糊备注"
          v-decorator="['mohuNote', { }]"
        />
      </a-form-item>
      <a-form-item label="昏睡">
        <a-radio-group v-decorator="['hunshui', {}]">
          <a-radio value="是">
           是
          </a-radio>
          <a-radio value="否">
            否
          </a-radio>
        </a-radio-group>
        <a-input
          placeholder="请输入昏睡备注"
          v-decorator="['hunshuiNote', { }]"
        />
      </a-form-item>
      <a-form-item label="昏迷">
        <a-radio-group v-decorator="['hunmi', {}]">
          <a-radio value="是">
           是
          </a-radio>
          <a-radio value="否">
            否
          </a-radio>
        </a-radio-group>
        <a-input
          placeholder="请输入昏迷备注"
          v-decorator="['hunmiNote', { }]"
        />
      </a-form-item>
      <a-form-item label="谵妄">
        <a-radio-group v-decorator="['zhanwang', {}]">
          <a-radio value="是">
           是
          </a-radio>
          <a-radio value="否">
            否
          </a-radio>
        </a-radio-group>
        <a-input
          placeholder="请输入谵妄备注"
          v-decorator="['zhanwangNote', { }]"
        />
      </a-form-item> -->
      <a-form-item label="有创机械通气时长">
        <a-input-number
          :precision="2"
          style="width:100%;"
          v-decorator="[ 'ycjxsc',{ }]"
        />
      </a-form-item>
      <a-form-item label="无创辅助时间（天）">
        <a-input-number
          :precision="2"
          style="width:100%;"
          v-decorator="[ 'wcfzsjDay',{ }]"
        />
      </a-form-item>
      <a-form-item label="无创辅助时间（小时）">
        <a-input-number
          :precision="2"
          style="width:100%;"
          v-decorator="[ 'wcfzsjHour',{ }]"
        />
      </a-form-item>
      <a-form-item label="无创辅助时间备注">
        <a-input
          v-decorator="[ 'wcfzsjNote',{ }]"
        />
      </a-form-item>
      <a-form-item label="疼痛评分CPOT/NRS">
        <a-input-number
          :precision="2"
          style="width:100%;"
          v-decorator="[ 'painScore',{ }]"
        />
      </a-form-item>
      <a-form-item label="RASS评分">
        <a-input-number
          :precision="2"
          style="width:100%;"
          v-decorator="[ 'rass',{ }]"
        />
      </a-form-item>
      <a-form-item label="GCS评分">
        <a-input-number
          :precision="2"
          style="width:100%;"
          v-decorator="[ 'gcs',{ }]"
        />
      </a-form-item>
      <a-form-item label="Braden评分">
        <a-input-number
          :precision="2"
          style="width:100%;"
          v-decorator="[ 'braden',{ }]"
        />
      </a-form-item>
      <a-form-item label="人工有创气道置管时间（小时）">
        <a-input-number
          :precision="2"
          style="width:100%;"
          v-decorator="[ 'rgcqdzHour',{ }]"
        />
      </a-form-item>
      <a-form-item label="插管部位">
        <a-radio-group v-decorator="['cgbw', {}]">
          <a-radio value="口腔型">
           口腔型
          </a-radio>
          <a-radio value="气切">
            气切
          </a-radio>
          <a-radio value="鼻腔型">
            鼻腔型
          </a-radio>
        </a-radio-group>
      </a-form-item>
      <a-form-item label="CVC留置时间（天）">
        <a-input-number
          :precision="2"
          style="width:100%;"
          v-decorator="[ 'cvc',{ }]"
        />
      </a-form-item>
      <a-form-item label="留置部位">
        <a-radio-group v-decorator="['lzbw', {}]">
          <a-radio value="颈内">
           颈内
          </a-radio>
          <a-radio value="股V">
            股V
          </a-radio>
          <a-radio value="锁骨下">
            锁骨下
          </a-radio>
        </a-radio-group>
      </a-form-item>
      <a-form-item label="血透">
        <a-radio-group v-decorator="['xuetou', {}]">
          <a-radio value="有">
           有
          </a-radio>
          <a-radio value="无">
            无
          </a-radio>
        </a-radio-group>
      </a-form-item>
      <a-form-item label="IABP置管时间">
        <a-radio-group v-decorator="['iabp', {}]">
          <a-radio value="有">
           有
          </a-radio>
          <a-radio value="无">
            无
          </a-radio>
        </a-radio-group>
      </a-form-item>
      <a-form-item label="营养评估（NRS2002）（分）">
        <a-input-number
          :precision="2"
          style="width:100%;"
          v-decorator="[ 'nrs',{ }]"
        />
      </a-form-item>
      <a-form-item label="肠内营养">
        <a-radio-group v-decorator="['cnyy', {}]">
          <a-radio value="有">
           有
          </a-radio>
          <a-radio value="无">
            无
          </a-radio>
        </a-radio-group>
      </a-form-item>
      <a-form-item label="肠外营养">
         <a-radio-group v-decorator="['cwyy', {}]">
          <a-radio value="有">
           有
          </a-radio>
          <a-radio value="无">
            无
          </a-radio>
        </a-radio-group>
      </a-form-item>
    </a-form>
  </div>
</template>

<script>
const ysztOptions = ['清楚', '嗜睡', '模糊', '昏睡', '昏迷', '镇静状态', '谵妄']
export default {
  data () {
    return {
      loading: false,
      form: this.$form.createForm(this),
      csfcInfo: {

      },
      ysztOptions,
      baseId: ''
    }
  },
  mounted () {
    // this.fetch()
    this.form.setFieldsValue({shishuiNote: '开始出现时间：术后    小时；持续时长：   （小时）'})
    //this.form.setFieldsValue({mohuNote: '开始出现时间：术后    小时；持续时长：   （小时）'})
   // this.form.setFieldsValue({hunshuiNote: '开始出现时间：术后    小时；持续时长：   （小时）'})
   // this.form.setFieldsValue({hunmiNote: '开始出现时间：术后    小时；持续时长：   （小时）'})
   // this.form.setFieldsValue({zhanwangNote: '开始出现时间：术后    小时；持续时长：   （小时）'})
  },
  components: {},
  methods: {
    reset () {
      this.loading = false
      this.csfcInfo = {}
      this.form.resetFields()
      this.baseId = ''
    },
    setFields () {
      let values = this.form.getFieldsValue(['ssDate', 'icuDay', 'icuAgain', 'shishui', 'shishuiNote', 'mohu', 'mohuNote', 'hunshui', 'hunshuiNote', 'hunmi', 'hunmiNote', 'zhanwang', 'zhanwangNote', 'ysztNote', 'ycjxsc', 'wcfzsjDay', 'wcfzsjHour', 'wcfzsjNote', 'painScore', 'rass', 'gcs', 'braden', 'rgcqdzHour', 'cgbw', 'cvc', 'lzbw', 'xuetou', 'iabp', 'nrs', 'cnyy', 'cwyy'])
      if (typeof values !== 'undefined') {
        Object.keys(values).forEach(_key => {
          if (values[_key] !== undefined) {
            this.csfcInfo[_key] = values[_key]
          }

        })
      }
      this.csfcInfo.id = this.baseId
      return this.csfcInfo
    },
    fetch () {
      this.$get('comFile/getUid?time=' + new Date().getTime()).then(res => {
        this.baseId = res.data.data
      })
      console.log('CsfcInfo Id 创建成功.')
    }
  }
}
</script>

<style>
</style>