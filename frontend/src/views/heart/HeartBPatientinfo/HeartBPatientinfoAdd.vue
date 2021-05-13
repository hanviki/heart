<template>
  <a-drawer
    title="新增"
    :maskClosable="false"
    width="80%"
    placement="right"
    :closable="false"
    @close="onClose"
    :visible="addVisiable"
    style="height: calc(100% - 15px);overflow: auto;"
  >
    <a-tabs
      default-active-key="1"
      @change="callback"
    >
      <a-tab-pane
        key="1"
        tab="个人信息"
      >
        <patient-info ref="patientInfo"></patient-info>
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
        <fc-info ref="fcInfo"></fc-info>
        <fcct-info ref="fcctInfo"></fcct-info>
        <fchy-info ref="fchyInfo"></fchy-info>
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
import PatientInfo from './PatientInfo'
import HospitalInfo from '../HeartBHospitalinfo/HospitalInfo'
import CheckInfo from '../HeartBCheck/CheckInfo'
import CsInfo from '../HeartBCs/CsInfo'
import CtInfo from '../HeartBCt/CtInfo'
import OutInfo from '../HeartBCtout/OutInfo'
import SurgicalInfo from '../HeartBSurgical/SurgicalInfo'
import SurAfterInfo from '../HeartBSurgicalafter/SurAfterInfo'
import FcInfo from '../HeartBCsfc/FcInfo'
import FcctInfo from '../HeartBCtfc/FcctInfo'
import FchyInfo from '../HeartBHyfc/FchyInfo'
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
      form: this.$form.createForm(this),
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
    callback (key) {
      console.log(key);
    },
    reset () {
      this.loading = false
      this.heartBPatientinfo = {}
      this.form.resetFields()
    },
    onClose () {
      this.reset()
      this.$emit('close')
    },
        handleSubmit () {
      this.$refs.patientInfo.form.validateFields((err, values) => {
        if (!err) {
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
