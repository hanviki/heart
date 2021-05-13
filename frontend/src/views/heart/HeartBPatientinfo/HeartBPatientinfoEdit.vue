<template>
  <a-drawer
    title="修改"
    :maskClosable="false"
    width="80%"
    placement="right"
    :closable="false"
    @close="onClose"
    :visible="editVisiable"
    style="height: calc(100% - 15px);overflow: auto;"
  >
    <a-tabs
      default-active-key="1"
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
import moment from 'moment'
import PatientInfo from './PatientInfoEdit'
import HospitalInfo from '../HeartBHospitalinfo/HospitalInfoEdit'
import CheckInfo from '../HeartBCheck/CheckInfoEdit'
 import CsInfo from '../HeartBCs/CsInfoEdit'
import CtInfo from '../HeartBCt/CtInfoEdit'
 import OutInfo from '../HeartBCtout/OutInfoEdit'
 import SurgicalInfo from '../HeartBSurgical/SurgicalInfoEdit'
 import SurAfterInfo from '../HeartBSurgicalafter/SurAfterInfoEdit'
 import FcInfo from '../HeartBCsfc/FcInfoEdit'
 import FcctInfo from '../HeartBCtfc/FcctInfoEdit'
 import FchyInfo from '../HeartBHyfc/FchyInfoEdit'

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
      heartBPatientinfo: {}
    }
  },
   components: {
    PatientInfo, HospitalInfo, CheckInfo, CsInfo, CtInfo, OutInfo, SurgicalInfo, SurAfterInfo, FcInfo
    , FcctInfo, FchyInfo
  },
  methods: {
    reset () {
      this.loading = false
      this.form.resetFields()
    },
    onClose () {
      this.reset()
      this.$emit('close')
    },
    handleSubmit () {
      this.form.validateFields((err, values) => {
        if (!err) {
          let heartBPatientinfo = this.form.getFieldsValue()
          heartBPatientinfo.id = this.heartBPatientinfo.id
          this.$put('heartBPatientinfo', {
            ...heartBPatientinfo
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
