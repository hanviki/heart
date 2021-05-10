<template>
  <div style="width:100%">
    <a-collapse v-model="activeKey" style="width:100%">
      <a-collapse-panel
        key="1"
        header="列表"
      >
        <a-anchor
          :target-offset="targetOffset"
          @click="handleClick"
          
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
        </a-collapse-panel>
        <a-collapse-panel
          key="2"
          header="信息填写"
        >
          <div id="patientInfo">
            <patient-info ref="patientInfo"></patient-info>
          </div>
          <div id="hospitalInfo">
            <hospital-info ref="hospitalInfo"></hospital-info>
          </div>
          <div id="checkInfo">
            <check-info ref="checkInfo"></check-info>
          </div>
           <div id="csInfo">
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
          </div>
           
          
          <div style="position:fixed;bottom:10px;"> <a-button @click="sumbitForm"  type="primary" :loading="loading">提交</a-button></div>
        </a-collapse-panel>
      
    </a-collapse>

    
  </div>
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
import FcInfo  from '../HeartBCsfc/FcInfo'
import FcctInfo from '../HeartBCtfc/FcctInfo'
import FchyInfo from '../HeartBHyfc/FchyInfo'


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
            fchyInfo: []
      },
      targetOffset: undefined,
      activeKey: 1,
      baseId: ''
    }
  },
  components: {
    PatientInfo, HospitalInfo, CheckInfo, CsInfo, CtInfo, OutInfo, SurgicalInfo, SurAfterInfo, FcInfo
    , FcctInfo, FchyInfo
  },
  mounted () {
    this.targetOffset = (window.innerHeight / 2) +10
    this.fetch()
  },
  methods: {
    onChange (link) {
      console.log('Anchor:OnChange', link);
    },
    handleClick () {
      this.activeKey = 2
    },
    sumbitForm(){
      this.heartBPatientinfo.checkInfo =this.$refs.checkInfo.setFields()
      this.heartBPatientinfo.patientInfo= this.$refs.patientInfo.setFields()
      this.heartBPatientinfo.csInfo =this.$refs.csInfo.setFields()
      this.heartBPatientinfo.ctInfo= this.$refs.ctInfo.setFields()
      this.heartBPatientinfo.hospitalInfo=this.$refs.hospitalInfo.setFields()
      this.heartBPatientinfo.outInfo =this.$refs.outInfo.setFields()
      this.heartBPatientinfo.surgicalInfo =this.$refs.surgicalInfo.setFields()
      this.heartBPatientinfo.checkInfo =this.$refs.surAfterInfo.setFields()
     this.heartBPatientinfo.fcInfo =this.$refs.fcInfo.setFields()
     this.heartBPatientinfo.fcctInfo =this.$refs.fcctInfo.setFields()
     this.heartBPatientinfo.fchyInfo =this.$refs.fchyInfo.setFields()

       this.$post('heartBPatientinfo', {
                      data: JSON.stringify(this.heartBPatientinfo)
                    }).then(() => {
                        this.reset()
                        this.$emit('success')
                    }).catch(() => {
                        this.loading = false
                    })
     
      
    },
    fetch () {
       this.$get('comFile/getUid').then(res=>{
          this.baseId =res.data.data
       })
    }
  }
}
</script>

<style>
</style>