<template>
  <div>
      <a-divider orientation="left" style="font-size:14px;">2. 超声复查</a-divider>
    <a-button
      icon="plus"
      @click="AddCsfc"
    >
    </a-button>
    <a-collapse accordion>
      <a-collapse-panel
        :header="index"
        v-for="(item,index) in listCsfc"
        :key="index+1"
        :forceRender="true"
      >
        <csfc-info :ref="'fc'+index" :checkInfo="item"></csfc-info>
      </a-collapse-panel>
    </a-collapse>
  </div>
</template>
      
      <script>
import CsfcInfo from './CsfcInfoEdit.vue'
export default {
  data () {
    return {
      loading: false,
      form: this.$form.createForm(this),
      listFc: [],
      baseId: '',
      listCsfc: []
    }
  },
  components: {
    CsfcInfo
  },
  methods: {
    AddCsfc () {
      let that =this
      that.$get('comFile/getUid?time='+ new Date().getTime()).then(res => {
           var  baseId =res.data.data
           that.listCsfc.push({id: baseId})
       })
    },
    reset () {
      this.baseId =''
      this.listFc = []
      this.listCsfc = []
    },
    setFields () {
      for (let i = 0; i < this.listFc.length; i++) {
          let name= 'fc'+ i
          console.info(name)
         // console.info((this.$refs[name])[0])
        this.listCsfc.push((this.$refs[name])[0].setFields())
      }
      return this.listCsfc
    },
    setFormValues (listCsfc) {
      let that =this
      that.listCsfc =listCsfc
    },
  }
}
      </script>
      
      <style>
</style>