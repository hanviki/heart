<template>
  <a-drawer
    title="查看资料"
    :maskClosable="false"
    width="90%"
    placement="right"
    :closable="true"
    @close="onClose"
    :visible="editVisiable"
    style="height: calc(100% - 15px);overflow: auto;"
  >
    <a-tabs
      @change="callback"
      :activeKey = "activeKey"
    >
      <a-tab-pane
        key="1"
        tab="个人信息"
      >
        <patient-info ref="patientInfo" @check="checkFileNo"></patient-info>
      </a-tab-pane>
      <a-tab-pane
        key="2"
        tab="住院病历资料"
        force-render
      >
        <hospital-info ref="hospitalInfo"></hospital-info>
      </a-tab-pane>
      <a-tab-pane
        key="3"
        tab="检验"
        force-render
      >
        <check-info ref="checkInfo" :isEdit="false"></check-info>
        <checkTwo-info ref="checkTwoInfo" :isEdit="false"></checkTwo-info>
        <checkThree-info ref="checkThreeInfo" :isEdit="false"></checkThree-info>
        <checkFour-info ref="checkFourInfo" :isEdit="false"></checkFour-info>
        <checkFive-info ref="checkFiveInfo" :isEdit="false"></checkFive-info>
        <checkSix-info ref="checkSixInfo" :isEdit="false"></checkSix-info>
      </a-tab-pane>
     <a-tab-pane
        key="4"
        tab="超声"
        force-render
      >
        <cs-info ref="csInfo" :isEdit="false"></cs-info>
      </a-tab-pane>
       <a-tab-pane
        key="5"
        tab="术前CT"
        force-render
      >
        <ct-info ref="ctInfo" :isEdit="false"></ct-info>
      </a-tab-pane>
       <a-tab-pane
        key="7"
        tab="手术"
        force-render
      >
        <surgical-info ref="surgicalInfo"></surgical-info>
      </a-tab-pane>
      <a-tab-pane
        key="8"
        tab="术后"
        force-render
      >
        <surAfter-info ref="surAfterInfo"></surAfter-info>
      </a-tab-pane>
      <a-tab-pane
        key="6"
        tab="门诊复查"
        force-render
      >
        <out-info ref="outInfo" :isEdit="false"></out-info>
      </a-tab-pane>
      <a-tab-pane
        key="9"
        tab="超声复查"
        force-render
      >
        <fc-info ref="fcInfo" :isEdit="false"></fc-info>
      </a-tab-pane> 
      <a-tab-pane
        key="10"
        tab="CT复查"
        force-render
      >
        <fcct-info ref="fcctInfo" :isEdit="false"></fcct-info>
      </a-tab-pane> 
       <a-tab-pane
        key="11"
        tab="化验复查"
        force-render
      >
        <fchy-info ref="fchyInfo" :isEdit="false"></fchy-info>
      </a-tab-pane> 
      <a-tab-pane
        key="12"
        tab="护理部术前"
        force-render
      >
        <sqzl-info ref="sqzlInfo" :isEdit="false"></sqzl-info>
      </a-tab-pane>
      <a-tab-pane
        key="13"
        tab="护理部术后"
        force-render
      >
        <shzl-info ref="shzlInfo" :isEdit="false"></shzl-info>
        <shzlxq-info ref="shzlxqsInfo" :isEdit="false"></shzlxq-info>
      </a-tab-pane>
       <a-tab-pane
        key="14"
        tab="其他"
        force-render
      >
       <other-info ref="otherInfo" :isEdit="false"></other-info>
      </a-tab-pane>
    </a-tabs>
  </a-drawer>
</template>
<script>
import moment from 'moment'
import PatientInfo from './PatientInfoEdit' // 个人信息
import HospitalInfo from '../HeartBHospitalinfo/HospitalInfoEdit' // 住院病历资料
import CheckInfo from '../HeartBCheck/HeartBCheckListInfoEdit' // 检验 1
import CheckTwoInfo from '../HeartBChecktwo/HeartBChecktwoListInfoEdit' // 检验 2
import CheckThreeInfo from '../HeartBCheckthree/HeartBCheckthreeListInfoEdit' // 检验 3
import CheckFourInfo from '../HeartBCheckfour/HeartBCheckfourListInfoEdit' // 检验 4
import CheckFiveInfo from '../HeartBCheckfive/HeartBCheckfiveListInfoEdit' // 检验 5
import CheckSixInfo from '../HeartBChecksix/HeartBChecksixListInfoEdit' // 检验 6
import CsInfo from '../HeartBCs/HeartBCsListInfoEdit' // 超声
import CtInfo from '../HeartBCt/HeartBCtListInfoEdit' // 术前CT
import OutInfo from '../HeartBCtout/OutListInfoEdit' // 出院复查CT
import SurgicalInfo from '../HeartBSurgical/SurgicalInfoEdit' // 手术
import SurAfterInfo from '../HeartBSurgicalafter/SurAfterInfoEdit' // 术后
import FcInfo from '../HeartBCsfc/FcInfoEdit' // 超声复查
import FcctInfo from '../HeartBCtfc/FcctInfoEdit' // CT复查
import FchyInfo from '../HeartBHyfc/FchyInfoEdit' // 化验复查
import ShzlInfo from '../HeartBShzl/HeartBShzlInfoEdit'
import SqzlInfo from '../HeartBSqzl/HeartBSqzlInfoEdit'
import ShzlxqInfo from '../HeartBShzlxq/HeartBShzlxqListInfoEdit'
import OtherInfo from '../HeartBOther/HeartBOtherListInfoEdit'

const formItemLayout = {
  labelCol: { span: 3 },
  wrapperCol: { span: 18 }
}
export default {
  name: 'HeartBPatientinfoEdit',
  props: {
    editVisiable: {
      default: false
    }
  },
  data () {
    return {
      loading: false,
      formItemLayout,
      form: this.$form.createForm(this),
      activeKey: '1',
      validateStatus: '',
      heartBPatientinfo: {
         patientInfo: {},
        hospitalInfo: {},
        checkInfo: {},
        checkTwoInfo: {},
        checkThreeInfo: {},
        checkFourInfo: {},
        checkFiveInfo: {},
        checkSixInfo: {},
        csInfo: {},
        ctInfo: {},
        outInfo: {},
        surgicalInfo: {},
        surAfterInfo: {},
        fcInfo: [],
        fcctInfo: [],
        fchyInfo: [],
        shzlxqsInfo: [],
        shzlInfo: {},
        sqzlInfo: {},
        otherInfo: {}
      }
    }
  },
   components: {
    PatientInfo, HospitalInfo, CheckInfo,CheckTwoInfo,CheckThreeInfo,CheckFourInfo,CheckFiveInfo, CheckSixInfo, CsInfo, CtInfo, OutInfo, SurgicalInfo, SurAfterInfo, FcInfo
    , FcctInfo, FchyInfo, ShzlInfo, SqzlInfo, ShzlxqInfo, OtherInfo
  },
  methods: {
    reset () {
      this.loading = false
      this.activeKey = '1'
      this.form.resetFields()
      //子页面清空form表单等.
      this.$refs.checkInfo.reset()
      this.$refs.checkTwoInfo.reset()
      this.$refs.checkThreeInfo.reset()
      this.$refs.checkFourInfo.reset()
      this.$refs.checkFiveInfo.reset()
      this.$refs.checkSixInfo.reset()
      this.$refs.patientInfo.reset()
      this.$refs.csInfo.reset()
      this.$refs.ctInfo.reset()
      this.$refs.hospitalInfo.reset()
      this.$refs.outInfo.reset()
      this.$refs.surgicalInfo.reset()
      this.$refs.surAfterInfo.reset()
      this.$refs.fcInfo.reset()
      this.$refs.fcctInfo.reset()
      this.$refs.fchyInfo.reset()
      this.$refs.shzlxqsInfo.reset()
      this.$refs.shzlInfo.reset()
      this.$refs.sqzlInfo.reset()
      this.$refs.otherInfo.reset()
    },
    callback (key) {
      this.activeKey = key
      console.log(key);
    },
    checkFileNo (validateStatus) {
      this.validateStatus = validateStatus
    },
    onClose () {
      this.reset()
      this.$emit('close')
    },
    handleSubmit () {
       this.$refs.patientInfo.handlefileNoBlur()
       this.$refs.patientInfo.form.validateFields((err, values) => {
        if (!err && this.validateStatus === 'success') {
          this.loading = true
          this.heartBPatientinfo.checkInfo = this.$refs.checkInfo.setFields()
          this.heartBPatientinfo.checkTwoInfo = this.$refs.checkTwoInfo.setFields()
          this.heartBPatientinfo.checkThreeInfo = this.$refs.checkThreeInfo.setFields()
          this.heartBPatientinfo.checkFourInfo = this.$refs.checkFourInfo.setFields()
          this.heartBPatientinfo.checkFiveInfo = this.$refs.checkFiveInfo.setFields()
          this.heartBPatientinfo.checkSixInfo = this.$refs.checkSixInfo.setFields()
          this.heartBPatientinfo.patientInfo = this.$refs.patientInfo.setFields()
          this.heartBPatientinfo.csInfo = this.$refs.csInfo.setFields()
          this.heartBPatientinfo.ctInfo = this.$refs.ctInfo.setFields()
          this.heartBPatientinfo.hospitalInfo = this.$refs.hospitalInfo.setFields()
          this.heartBPatientinfo.outInfo = this.$refs.outInfo.setFields()
          this.heartBPatientinfo.surgicalInfo = this.$refs.surgicalInfo.setFields()
          this.heartBPatientinfo.checkInfo = this.$refs.surAfterInfo.setFields()
          this.heartBPatientinfo.fcInfo = this.$refs.fcInfo.setFields()
          this.heartBPatientinfo.fcctInfo = this.$refs.fcctInfo.setFields()
          this.heartBPatientinfo.fchyInfo = this.$refs.fchyInfo.setFields()
          this.heartBPatientinfo.shzlxqsInfo = this.$refs.shzlxqsInfo.setFields()
          this.heartBPatientinfo.shzlInfo = this.$refs.shzlInfo.setFields()
          this.heartBPatientinfo.sqzlInfo = this.$refs.sqzlInfo.setFields()
          this.heartBPatientinfo.otherInfo = this.$refs.otherInfo.setFields()
       
          this.$put('heartBPatientinfo', {
            data: JSON.stringify(this.heartBPatientinfo)
          }).then(() => {
            this.reset()
            this.$emit('success')
          }).catch(() => {
            this.loading = false
          })
        }
      })
    },
    fetch (fileNo) {
      this.$get('heartBPatientinfo/all', { fileNo: fileNo }).then(res => {
        this.heartBPatientinfo = res.data.data
        this.$refs.checkInfo.setFormValues(this.heartBPatientinfo.checkInfo)
        this.$refs.checkTwoInfo.setFormValues(this.heartBPatientinfo.checkTwoInfo)
        this.$refs.checkThreeInfo.setFormValues(this.heartBPatientinfo.checkThreeInfo)
        this.$refs.checkFourInfo.setFormValues(this.heartBPatientinfo.checkFourInfo)
        this.$refs.checkFiveInfo.setFormValues(this.heartBPatientinfo.checkFiveInfo)
        this.$refs.checkSixInfo.setFormValues(this.heartBPatientinfo.checkSixInfo)
        this.$refs.patientInfo.setFormValues(this.heartBPatientinfo.patientInfo)
        this.$refs.csInfo.setFormValues(this.heartBPatientinfo.csInfo)
        this.$refs.ctInfo.setFormValues(this.heartBPatientinfo.ctInfo)
        this.$refs.hospitalInfo.setFormValues(this.heartBPatientinfo.hospitalInfo)
        this.$refs.outInfo.setFormValues(this.heartBPatientinfo.outInfo)
        this.$refs.surgicalInfo.setFormValues(this.heartBPatientinfo.surgicalInfo)
        this.$refs.surAfterInfo.setFormValues(this.heartBPatientinfo.surAfterInfo)
        this.$refs.fcInfo.setFormValues(this.heartBPatientinfo.fcInfo)
        this.$refs.fcctInfo.setFormValues(this.heartBPatientinfo.fcctInfo)
        this.$refs.fchyInfo.setFormValues(this.heartBPatientinfo.fchyInfo)
        this.$refs.shzlxqsInfo.setFormValues(this.heartBPatientinfo.shzlxqsInfo)
        this.$refs.shzlInfo.setFormValues(this.heartBPatientinfo.shzlInfo)
        this.$refs.sqzlInfo.setFormValues(this.heartBPatientinfo.sqzlInfo)
        this.$refs.otherInfo.setFormValues(this.heartBPatientinfo.otherInfo)
      })
    }
  }
}
</script>
