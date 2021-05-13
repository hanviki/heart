<template>
  <a-drawer
    title="修改"
    :maskClosable="false"
    width="40%"
    placement="right"
    :closable="false"
    @close="onClose"
    :visible="editVisiable"
    style="height: calc(100% - 55px);overflow: auto;padding-bottom: 53px;"
  >
    <a-affix :offset-top="top">

      <a-card
        size="small"
        title="分类信息"
      >
        <a-icon
          slot="extra"
          :type="!isShow?'down':'up'"
          @click="isShow=!isShow"
        />
        <a-anchor
          :target-offset="targetOffset"
          @click="handleClick"
          v-if="isShow"
        >
          <a-anchor-link
            href="#patientInfo"
            title="个人信息"
          />
          <a-anchor-link
            href="#hospitalInfo"
            title="住院病历资料"
          />
          <a-anchor-link
            href="#checkInfo"
            title="检验"
          />
          <a-anchor-link
            href="#csInfo"
            title="超声"
          />
          <a-anchor-link
            href="#ctInfo"
            title="术前CT"
          />
          <a-anchor-link
            href="#outInfo"
            title="出院复查CT"
          />
          <a-anchor-link
            href="#surgicalInfo"
            title="手术"
          />
          <a-anchor-link
            href="#surAfterInfo"
            title="术后"
          />
        </a-anchor>
      </a-card>
    </a-affix>
    <div id="patientInfo">
      <patient-info ref="patientInfo"></patient-info>
    </div>
    <div id="hospitalInfo">
      <hospital-info ref="hospitalInfo"></hospital-info>
    </div>
    <div id="checkInfo">
      <check-info ref="checkInfo"></check-info>
    </div>
    <!-- <div id="csInfo">
      <cs-info ref="csInfo"></cs-info>
    </div>
    <div id="ctInfo">
      <ct-info ref="ctInfo"></ct-info>
    </div>
    <div id="outInfo">
      <out-info ref="outInfo"></out-info>
    </div>
    <div id="surgicalInfo">
      <surgical-info ref="surgicalInfo"></surgical-info>
    </div>
    <div id="surAfterInfo">
      <surAfter-info ref="surAfterInfo"></surAfter-info>
      <fc-info ref="fcInfo"></fc-info>
      <fcct-info ref="fcctInfo"></fcct-info>
      <fchy-info ref="fchyInfo"></fchy-info>
    </div> -->

    <div style="position:fixed;bottom:10px;">
      <a-button
        @click="sumbitForm"
        type="primary"
        :loading="loading"
      >提交</a-button>
    </div>
  </a-drawer>
</template>

<script>

import PatientInfo from './PatientInfoEdit'
import HospitalInfo from '../HeartBHospitalinfo/HospitalInfoEdit'
import CheckInfo from '../HeartBCheck/CheckInfoEdit'
// import CsInfo from '../HeartBCs/CsInfoEdit'
// import CtInfo from '../HeartBCt/CtInfoEdit'
// import OutInfo from '../HeartBCtout/OutInfoEdit'
// import SurgicalInfo from '../HeartBSurgical/SurgicalInfoEdit'
// import SurAfterInfo from '../HeartBSurgicalafter/SurAfterInfoEdit'
// import FcInfo from '../HeartBCsfc/FcInfoEdit'
// import FcctInfo from '../HeartBCtfc/FcctInfoEdit'
// import FchyInfo from '../HeartBHyfc/FchyInfoEdit'


export default {
  data () {
    return {
      loading: false,
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

      },
      isShow: true,
      top: 80,
      targetOffset: undefined,
      activeKey: 1,
      baseId: ''
    }
  },
  props: {
    editVisiable: {
      default: false
    }
  },
  onClose () {
    this.$emit('close')
  },
  components: {
    PatientInfo, HospitalInfo, CheckInfo//, CsInfo, CtInfo, OutInfo, SurgicalInfo, SurAfterInfo, FcInfo
   // , FcctInfo, FchyInfo
  },
  mounted () {
    this.targetOffset = (window.innerHeight / 2) + 10
    this.fetch()
  },
  methods: {
    onChange (link) {
      console.log('Anchor:OnChange', link);
    },
    handleClick () {
      this.activeKey = 2
    },
    sumbitForm () {
      this.$refs.patientInfo.form.validateFields((err, values) => {
        if (!err) {
          this.heartBPatientinfo.checkInfo = this.$refs.checkInfo.setFields()
          this.heartBPatientinfo.patientInfo = this.$refs.patientInfo.setFields()
          // this.heartBPatientinfo.csInfo = this.$refs.csInfo.setFields()
          // this.heartBPatientinfo.ctInfo = this.$refs.ctInfo.setFields()
          // this.heartBPatientinfo.hospitalInfo = this.$refs.hospitalInfo.setFields()
          // this.heartBPatientinfo.outInfo = this.$refs.outInfo.setFields()
          // this.heartBPatientinfo.surgicalInfo = this.$refs.surgicalInfo.setFields()
          // this.heartBPatientinfo.checkInfo = this.$refs.surAfterInfo.setFields()
          // this.heartBPatientinfo.fcInfo = this.$refs.fcInfo.setFields()
          // this.heartBPatientinfo.fcctInfo = this.$refs.fcctInfo.setFields()
          // this.heartBPatientinfo.fchyInfo = this.$refs.fchyInfo.setFields()

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
    },
    fetch (fileNo) {
      this.$get('heartBPatientinfo/all', { fileNo: fileNo }).then(res => {
        this.heartBPatientinfo = res.data.data
        this.$refs.checkInfo.setFormValues(this.heartBPatientinfo.checkInfo)

        this.$refs.patientInfo.setFormValues(this.heartBPatientinfo.patientInfo)
        // this.$refs.csInfo.setFormValues(this.heartBPatientinfo.csInfo)
        // this.$refs.ctInfo.setFormValues(this.heartBPatientinfo.ctInfo)
        // this.$refs.hospitalInfo.setFormValues(this.heartBPatientinfo.hospitalInfo)
        // this.$refs.outInfo.setFormValues(this.heartBPatientinfo.outInfo)
        // this.$refs.surgicalInfo.setFormValues(this.heartBPatientinfo.surgicalInfo)
        // this.$refs.surAfterInfo.setFormValues(this.heartBPatientinfo.checkInfo)
        // this.$refs.fcInfo.setFormValues(this.heartBPatientinfo.fcInfo)
        // this.$refs.fcctInfo.setFormValues(this.heartBPatientinfo.fcctInfo)
        // this.$refs.fchyInfo.setFormValues(this.heartBPatientinfo.fchyInfo)
      })
    }
  }
}
</script>

<style>
</style>