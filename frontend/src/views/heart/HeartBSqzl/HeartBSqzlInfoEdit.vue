<template>
  <div>
   <a-form :form="form">
      <a-form-item label="意识状态">
        <a-radio-group
          v-decorator="['yszt', {}]"
          :options="ysztOptions"
        />
      </a-form-item>
      <a-form-item label="皮肤黏膜">
        <a-radio-group v-decorator="['pfnm', {}]">
          <a-radio value="正常">
            正常
          </a-radio>
          <a-radio value="压疮">
            压疮
          </a-radio>
          <a-radio value="烫伤">
            烫伤
          </a-radio>
          <a-radio value="外伤">
            外伤
          </a-radio>
          <a-radio value="其他">
            其他
          </a-radio>
        </a-radio-group>
      </a-form-item>
      <a-form-item label="饮食">
        <a-radio-group v-decorator="['yinshi', {}]">
          <a-radio value="普食">
            普食
          </a-radio>
          <a-radio value="半流质">
            半流质
          </a-radio>
          <a-radio value="留质">
            留质
          </a-radio>
          <a-radio value="禁食">
            禁食
          </a-radio>
          <a-radio value="鼻饲">
            鼻饲
          </a-radio>
          <a-radio value="治疗饮食">
            治疗饮食
          </a-radio>
        </a-radio-group>
      </a-form-item>
      <a-form-item label="排便">
        <a-radio-group v-decorator="['paibian', {}]">
          <a-radio value="正常">
            正常
          </a-radio>
          <a-radio value="便秘">
            便秘
          </a-radio>
          <a-radio value="腹泻">
            腹泻
          </a-radio>
          <a-radio value="失禁">
            失禁
          </a-radio>
          <a-radio value="造瘘">
            造瘘
          </a-radio>
          <a-radio value="其他">
            其他
          </a-radio>

        </a-radio-group>
        <a-input
          placeholder="请输入排便备注"
          v-decorator="['paibianNote', { }]"
        />
      </a-form-item>
      <a-form-item label="辅助排便">
        <a-radio-group v-decorator="['paibianHelp', {}]">
          <a-radio value="有">
            有
          </a-radio>
          <a-radio value="无">
            无
          </a-radio>

        </a-radio-group>
      </a-form-item>
      <a-form-item label="排尿">
        <a-radio-group v-decorator="['painiao', {}]">
          <a-radio value="正常">
            正常
          </a-radio>
          <a-radio value="尿失禁">
            尿失禁
          </a-radio>
          <a-radio value="尿潴留">
            尿潴留
          </a-radio>
          <a-radio value="排尿困难">
            排尿困难
          </a-radio>
          <a-radio value="留置尿管">
            留置尿管
          </a-radio>
          <a-radio value="其他">
            其他
          </a-radio>

        </a-radio-group>
      </a-form-item>
      <a-form-item label="过敏史（药物）">

        <a-radio-group v-decorator="['guominshi', {}]">
          <a-radio value="有">
            有
          </a-radio>
          <a-radio value="无">
            无
          </a-radio>

        </a-radio-group>
        <a-input
          placeholder="请输入过敏史备注"
          v-decorator="['guominshiNote', { }]"
        />
      </a-form-item>
      <a-form-item label="过敏史（食物）">

        <a-radio-group v-decorator="['gmsSw', {}]">
          <a-radio value="有">
            有
          </a-radio>
          <a-radio value="无">
            无
          </a-radio>

        </a-radio-group>
        <a-input
          placeholder="请输入过敏史备注"
          v-decorator="['gmsSwNote', { }]"
        />
      </a-form-item>

      <a-form-item label="吸烟史">
        <a-radio-group v-decorator="['xiyanshi', {}]">
          <a-radio value="有">
            有
          </a-radio>
          <a-radio value="无">
            无
          </a-radio>

        </a-radio-group>
        <a-input
          placeholder="请输入吸烟史时间（几年）"
          v-decorator="['xiyanshiNote', { }]"
        />
      </a-form-item>
      <a-form-item label="饮酒史">
        <a-radio-group v-decorator="['yinjiushi', {}]">
          <a-radio value="无">
            无
          </a-radio>
          <a-radio value="偶尔">
            偶尔
          </a-radio>
          <a-radio value="经常">
            经常
          </a-radio>
          <a-radio value="每天">
            每天
          </a-radio>
        </a-radio-group>
      </a-form-item>
      <a-form-item label="慢性病">
        <a-checkbox-group v-decorator="['manxingbing', {}]">
          <a-checkbox value="无">
            无
          </a-checkbox>
          <a-checkbox value="心脏病">
            心脏病
          </a-checkbox>
          <a-checkbox value="高血压">
            高血压
          </a-checkbox>
          <a-checkbox value="糖尿病">
            糖尿病
          </a-checkbox>
          <a-checkbox value="脑卒中">
            脑卒中
          </a-checkbox>
          <a-checkbox value="其他">
            其他
          </a-checkbox>
        </a-checkbox-group>
        <a-input
          placeholder="请输入其他慢性病"
          v-decorator="['manxingbingNote', { }]"
        />
      </a-form-item>
      <a-divider
        orientation="left"
        style="font-size:14px;"
      >2. 生活自理能力</a-divider>
      <a-form-item label="Barthel指数">
        <a-input
          placeholder="请输入Barthel指数"
          v-decorator="['barthel', { }]"
        />
        <span>a重度依赖（≤40分）b中度依赖（41-60分）c轻度依赖（61-99分） d无需依赖（100分）</span>
      </a-form-item>
      <a-divider
        orientation="left"
        style="font-size:14px;"
      >3. 压疮风险评估</a-divider>
      <a-form-item label="Braden评分">
        <a-input
          placeholder="请输入Braden评分"
          v-decorator="['braden', { }]"
        />
        <span>a低风险（15-18）b中风险（13-14）c高风险（10-12）d极高风险（≤9）</span>
      </a-form-item>
      <a-form-item label="压疮">

        <a-radio-group v-decorator="['yachuang', {}]">
          <a-radio value="有">
            有
          </a-radio>
          <a-radio value="无">
            无
          </a-radio>
        </a-radio-group>
      </a-form-item>
      <a-divider
        orientation="left"
        style="font-size:14px;"
      >4. 深静脉血栓评估</a-divider>
      <a-form-item label="Caprini评分">
        <a-input
          placeholder="请输入Caprini评分"
          v-decorator="['caprini', { }]"
        />
        <span>a极低风险（0分）b低度风险（1-2分）c中度风险（3-4）d高度风险（≥5分）</span>
      </a-form-item>
      <a-divider
        orientation="left"
        style="font-size:14px;"
      >5. 疼痛评估</a-divider>
      <a-form-item label="首次出现疼痛到现在的时长（小时）">
        <a-input
          placeholder="请输入疼痛时长"
          v-decorator="['painTime', { }]"
        />
      </a-form-item>
      <a-form-item label="疼痛评分">
        <a-input
          placeholder="请输入疼痛评分"
          v-decorator="['painScore', { }]"
        />
        <span>（如果为0分，没有处理；如果疼痛，疼痛处理后再次复评）</span>
        <span>a无痛（0分）b轻微痛（1-3分）c比较痛（4-6分）d非常痛（7-9分）e剧痛（10分）</span>
      </a-form-item>
      <a-form-item label="疼痛处理">
        <a-radio-group v-decorator="['painHadle', {}]">
          <a-radio value="药物止痛">
            药物止痛
          </a-radio>
          <a-radio value="心理护理">
            心理护理
          </a-radio>
          <a-radio value="物理止痛">
            物理止痛
          </a-radio>
          <a-radio value="其他">
            其他
          </a-radio>
        </a-radio-group>
      </a-form-item>
      <a-form-item label="疼痛处理备注">
        <a-input
          placeholder="请输入疼痛处理，具体药物+方式"
          v-decorator="['painHadlenote', { }]"
        />
      </a-form-item>
      <a-form-item label="疼痛处理后再次评分">
        <a-input
          placeholder="请输入疼痛处理后再次评分"
          v-decorator="['painScoreAgain', { }]"
        />
      </a-form-item>
      <a-divider
        orientation="left"
        style="font-size:14px;"
      >6. 营养评估</a-divider>
      <a-form-item label="营养风险筛查评估（NRS2002）">
        <a-input
          placeholder="请输入营养风险筛查评估（NRS2002）"
          v-decorator="['yingyangfxsc', { }]"
        />
      </a-form-item>
      <span>a无风险 b低度风险 c中度风险 d高度风险</span>
      <a-form-item label="营养风险筛查评估备注">
        <a-input
          placeholder="请输入营养风险筛查评估备注"
          v-decorator="['yingyangfxscNote', { }]"
        />
      </a-form-item>
    </a-form>
  </div>
</template>

<script>
const ysztOptions = ['清楚', '嗜睡', '模糊', '昏睡', '昏迷', '镇静状态', '谵妄']
import moment from 'moment'
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
      csfcInfo: {
      },
      ysztOptions,
    }
  },
  mounted () {
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
      let values = this.form.getFieldsValue(['yszt', 'pfnm', 'yinshi', 'paibian', 'paibianNote', 'paibianHelp', 'painiao', 'guominshi', 'guominshiNote', 'gmsSw', 'gmsSwNote', 'manxingbingNote', 'xiyanshi', 'xiyanshiNote', 'yinjiushi', 'manxingbing', 'barthel', 'braden', 'yachuang', 'caprini', 'painTime', 'painScore', 'painHadle', 'painHadlenote', 'painScoreAgain', 'yingyangfxsc', 'yingyangfxscNote'])
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
      let fields = ['yszt', 'pfnm', 'yinshi', 'paibian', 'paibianNote', 'paibianHelp', 'painiao', 'guominshi', 'guominshiNote', 'gmsSw', 'gmsSwNote', 'manxingbingNote', 'xiyanshi', 'xiyanshiNote', 'yinjiushi', 'manxingbing', 'barthel', 'braden', 'yachuang', 'caprini', 'painTime', 'painScore', 'painHadle', 'painHadlenote', 'painScoreAgain', 'yingyangfxsc', 'yingyangfxscNote']
      let fieldDates = []
      Object.keys(checkInfo).forEach((key) => {
        if (fields.indexOf(key) !== -1) {
          this.form.getFieldDecorator(key)
          let obj = {}
          if (fieldDates.indexOf(key) !== -1) {
            if (checkInfo[key] !== '' && checkInfo[key] !== null) {
              obj[key] = moment(checkInfo[key])
            }
            else {
              obj[key] = ''
            }
          } else {
            if(key=='manxingbing'){
              if (checkInfo[key] !== '' && checkInfo[key] !== null) {
                 obj[key] =JSON.parse(checkInfo[key])
              }
              else{
                  obj[key] = ''
              }
            } else {
              obj[key] = checkInfo[key]
            }
          }
          this.form.setFieldsValue(obj)
        }
      })
      this.csfcInfo = checkInfo
    },

  }
}
</script>

<style>
</style>