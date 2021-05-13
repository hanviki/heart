<template>
  <div>
      <a-divider orientation="left" style="font-size:14px;">3. CT复查</a-divider>
    <a-button
      icon="plus"
      @click="AddCtfc"
    >
    </a-button>
    <a-collapse accordion>
      <a-collapse-panel
        :header="index"
        v-for="(item,index) in listCsfc"
        :key="index+1"
      >
        <ctfc-info :ref="'fc'+index" :checkInfo="item"></ctfc-info>
      </a-collapse-panel>
    </a-collapse>
  </div>
</template>
      
      <script>
import CtfcInfo from './CtfcInfoEdit'
export default {
  data () {
    return {
      loading: false,
      form: this.$form.createForm(this),
      listFc: ['1'],
      baseId: '',
      listCsfc: []
    }
  },
  components: {
    CtfcInfo
  },
  methods: {
    AddCtfc () {
      let that =this
      that.$get('comFile/getUid?time='+ new Date().getTime()).then(res => {
           var  baseId =res.data.data
           that.listCsfc.push({id: baseId})
       })
    },
    setFields () {
      for (let i = 0; i < this.listFc.length; i++) {
          let name= 'fc'+ i
          console.info(name)
         // console.info(this.$refs[name][0])
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