<template>
  <a-drawer
    title="新增"
    :maskClosable="false"
    width="90%"
    placement="right"
    :closable="false"
    @close="onClose"
    :visible="addVisiable"
    style="height: calc(100% - 15px);overflow: auto;"
  >
    <a-tabs
      :activeKey = "activeKey"
      @change="callback"
    >
      <a-tab-pane
        key="1"
        tab="个人信息"
      >
        <patient-info 
          ref="patientInfo"
          @check="checkFileNo"
        ></patient-info>
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
        <check-info ref="checkInfo"></check-info>
        <checkTwo-info ref="checkTwoInfo"></checkTwo-info>
        <!-- <checkThree-info ref="checkThreeInfo"></checkThree-info> -->
        <checkFour-info ref="checkFourInfo"></checkFour-info>
        <checkFive-info ref="checkFiveInfo"></checkFive-info>
      </a-tab-pane>
      <a-tab-pane
        key="4"
        tab="超声"
        force-render
      >
        <cs-info ref="csInfo"></cs-info>
      </a-tab-pane>
      <a-tab-pane
        key="5"
        tab="术前CT"
        force-render
      >
        <ct-info ref="ctInfo"></ct-info>
      </a-tab-pane>
      <a-tab-pane
        key="6"
        tab="出院复查CT"
        force-render
      >
        <out-info ref="outInfo"></out-info>
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
        <fc-info ref="fcInfo"></fc-info>
        <fcct-info ref="fcctInfo"></fcct-info>
        <fchy-info ref="fchyInfo"></fchy-info>
      </a-tab-pane>
      <a-tab-pane
        key="9"
        tab="术前资料"
        force-render
      >
       <sqzl-info ref="sqzlInfo"></sqzl-info>
      </a-tab-pane>
       <a-tab-pane
        key="10"
        tab="术后资料"
        force-render
      >
       <shzl-info ref="shzlInfo"></shzl-info>
       <shzlxq-info ref="shzlxqsInfo"></shzlxq-info>
      </a-tab-pane>
       <a-tab-pane
        key="11"
        tab="其他"
        force-render
      >
       <other-info ref="otherInfo"></other-info>
      </a-tab-pane>
    </a-tabs>
    <div class="drawer-bootom-button">
      <a-popconfirm
        title="确定放弃编辑？"
        @confirm="onClose"
        okText="确定"
        cancelText="取消"
      >
        <a-button style="margin-right: .8rem">取消</a-button>
      </a-popconfirm>
      <a-button
        @click="handleSubmit"
        type="primary"
        :loading="loading"
      >提交</a-button>
    </div>
  </a-drawer>
</template>
<script>
import PatientInfo from './PatientInfo' // 个人信息
import HospitalInfo from '../HeartBHospitalinfo/HospitalInfo' // 住院病历资料
import CheckInfo from '../HeartBCheck/HeartBCheckListInfo' // 检验 1
import CheckTwoInfo from '../HeartBChecktwo/HeartBChecktwoListInfo' // 检验 2
import CheckThreeInfo from '../HeartBCheckthree/HeartBCheckthreeListInfo' // 检验 3
import CheckFourInfo from '../HeartBCheckfour/HeartBCheckfourListInfo' // 检验 4
import CheckFiveInfo from '../HeartBCheckfive/HeartBCheckfiveListInfo' // 检验 5
import CsInfo from '../HeartBCs/HeartBCsListInfo' // 超声
import CtInfo from '../HeartBCt/HeartBCtListInfo' // 术前CT
import OutInfo from '../HeartBCtout/OutInfo' // 出院复查CT
import SurgicalInfo from '../HeartBSurgical/SurgicalInfo' // 手术
import SurAfterInfo from '../HeartBSurgicalafter/SurAfterInfo' // 术后
import FcInfo from '../HeartBCsfc/FcInfo' // 超声复查
import FcctInfo from '../HeartBCtfc/FcctInfo' // CT复查
import FchyInfo from '../HeartBHyfc/FchyInfo' // 化验复查
import ShzlInfo from '../HeartBShzl/HeartBShzlInfo'
import SqzlInfo from '../HeartBSqzl/HeartBSqzlInfo'
import ShzlxqInfo from '../HeartBShzlxq/HeartBShzlxqListInfo'
import OtherInfo from '../HeartBOther/HeartBOtherListInfo'

const formItemLayout = {
  labelCol: { span: 3 },
  wrapperCol: { span: 18 }
}
export default {
  name: 'HeartBPatientinfoAdd',
  props: {
    addVisiable: {
      default: false
    }
  },
  data () {
    return {
      loading: false,
      formItemLayout,
      activeKey: '1',
      form: this.$form.createForm(this),
      validateStatus: '',
      heartBPatientinfo: {
        patientInfo: {},
        checkInfo: {},
        checkTwoInfo: {},
        checkThreeInfo: {},
        checkFourInfo: {},
        checkFiveInfo: {},
        csInfo: {},
        hospitalInfo: {},
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
    PatientInfo, HospitalInfo, CheckInfo,CheckTwoInfo,CheckThreeInfo,CheckFourInfo,CheckFiveInfo, CsInfo, CtInfo, OutInfo, SurgicalInfo, SurAfterInfo, FcInfo
    , FcctInfo, FchyInfo, ShzlInfo, SqzlInfo, ShzlxqInfo, OtherInfo
  },
  methods: {
    callback (key) {
      this.activeKey = key
      console.log(key);
    },
    reset () {
      this.loading = false
      this.activeKey = '1'
      this.heartBPatientinfo = {}
      this.form.resetFields()
      //子页面清空form表单等.
      this.$refs.checkInfo.reset()
      this.$refs.checkTwoInfo.reset()
      // this.$refs.checkThreeInfo.reset()
      this.$refs.checkFourInfo.reset()
      this.$refs.checkFiveInfo.reset()
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
    getId () { //有附件的需要加
      setTimeout(() => {
        this.$refs.csInfo.getId()
        this.$refs.ctInfo.getId()
        this.$refs.outInfo.fetch()
        this.$refs.fcInfo.getId()
        this.$refs.fcctInfo.getId()
        this.$refs.otherInfo.getId()
      }, 200);
    },
    onClose () {
      this.reset()
      this.$emit('close')
    },
    checkFileNo (validateStatus) {
      this.validateStatus = validateStatus
    },
        handleSubmit () {
          this.$refs.patientInfo.handlefileNoBlur()
        this.$refs.patientInfo.form.validateFields((err, values) => {
        if (!err && this.validateStatus === 'success') {
          this.heartBPatientinfo = {}
          this.heartBPatientinfo.patientInfo = this.$refs.patientInfo.setFields() // 个人信息
          this.heartBPatientinfo.hospitalInfo = this.$refs.hospitalInfo.setFields() // 住院病历资料
          this.heartBPatientinfo.checkInfo = this.$refs.checkInfo.setFields() // 住院病历资料
          this.heartBPatientinfo.checkTwoInfo = this.$refs.checkTwoInfo.setFields()
          // this.heartBPatientinfo.checkThreeInfo = this.$refs.checkThreeInfo.setFields()
          this.heartBPatientinfo.checkFourInfo = this.$refs.checkFourInfo.setFields()
          this.heartBPatientinfo.checkFiveInfo = this.$refs.checkFiveInfo.setFields()
          this.heartBPatientinfo.csInfo = this.$refs.csInfo.setFields() // 超声1
          this.heartBPatientinfo.ctInfo = this.$refs.ctInfo.setFields() // 术前CT1
          this.heartBPatientinfo.outInfo = this.$refs.outInfo.setFields() // 出院复查CT1
          this.heartBPatientinfo.surgicalInfo = this.$refs.surgicalInfo.setFields() // 手术
          this.heartBPatientinfo.surAfterInfo = this.$refs.surAfterInfo.setFields() // 术后
          this.heartBPatientinfo.fcInfo = this.$refs.fcInfo.setFields() // 超声复查1
          this.heartBPatientinfo.fcctInfo = this.$refs.fcctInfo.setFields() // CT复查1
          this.heartBPatientinfo.fchyInfo = this.$refs.fchyInfo.setFields() // 化验复查
          this.heartBPatientinfo.shzlxqsInfo = this.$refs.shzlxqsInfo.setFields() // 超声复查1
          this.heartBPatientinfo.shzlInfo = this.$refs.shzlInfo.setFields() // CT复查1
          this.heartBPatientinfo.sqzlInfo = this.$refs.sqzlInfo.setFields() // 化验复查        
          this.heartBPatientinfo.otherInfo = this.$refs.otherInfo.setFields() // 其他     
          this.$post('heartBPatientinfo', {
            data: JSON.stringify(this.heartBPatientinfo)
          }).then(() => {
            this.reset()
            this.$emit('success')
          }).catch(() => {
            this.loading = false
          })
        }
      })
    }
  }
}
</script>
