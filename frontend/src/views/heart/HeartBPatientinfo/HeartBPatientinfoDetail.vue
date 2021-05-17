<template>
  <a-drawer
    title="查看资料"
    :maskClosable="false"
    width="80%"
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
        <check-info ref="checkInfo"></check-info>
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
       
       <!-- <fchy-info ref="fchyInfo"></fchy-info>-->
      </a-tab-pane> 
      <a-tab-pane
        key="9"
        tab="超声复查"
        force-render
      >
        <fc-info ref="fcInfo"></fc-info>
      </a-tab-pane> 
      <a-tab-pane
        key="10"
        tab="CT复查"
        force-render
      >
        <fcct-info ref="fcctInfo"></fcct-info>
      </a-tab-pane> 
       <a-tab-pane
        key="11"
        tab="化验复查"
        force-render
      >
        <fchy-info ref="fchyInfo"></fchy-info>
      </a-tab-pane> 
    </a-tabs>
  </a-drawer>
</template>
<script>
import moment from 'moment'
import PatientInfo from './PatientInfoEdit' // 个人信息
import HospitalInfo from '../HeartBHospitalinfo/HospitalInfoEdit' // 住院病历资料
import CheckInfo from '../HeartBCheck/CheckInfoEdit' // 检验
import CsInfo from '../HeartBCs/CsInfoEdit' // 超声
import CtInfo from '../HeartBCt/CtInfoEdit' // 术前CT
import OutInfo from '../HeartBCtout/OutInfoEdit' // 出院复查CT
import SurgicalInfo from '../HeartBSurgical/SurgicalInfoEdit' // 手术
import SurAfterInfo from '../HeartBSurgicalafter/SurAfterInfoEdit' // 术后
import FcInfo from '../HeartBCsfc/FcInfoEdit' // 超声复查
import FcctInfo from '../HeartBCtfc/FcctInfoEdit' // CT复查
import FchyInfo from '../HeartBHyfc/FchyInfoEdit' // 化验复查

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
        checkInfo: {},
        csInfo: {},
        hospitalInfo: {},
        ctInfo: {},
        outInfo: {},
        surgicalInfo: {},
        surAfterInfo: {},
        fcInfo: [],
        fcctInfo: [],
        fchyInfo: [],
      }
    }
  },
   components: {
    PatientInfo, HospitalInfo, CheckInfo, CsInfo, CtInfo, OutInfo, SurgicalInfo, SurAfterInfo, FcInfo
    , FcctInfo, FchyInfo
  },
  methods: {
    reset () {
      this.loading = false
      this.activeKey = '1'
      this.form.resetFields()
      //子页面清空form表单等.
      this.$refs.checkInfo.reset()
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
      })
    }
  }
}
</script>
