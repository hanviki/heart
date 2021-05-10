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
        v-for="(item,index) in listFc"
        :key="index+1"
      >
        <ctfc-info :ref="'fc'+index"></ctfc-info>
      </a-collapse-panel>
    </a-collapse>
  </div>
</template>
      
      <script>
import CtfcInfo from './CtfcInfo'
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
      this.listFc.push('1')
    },
    setFields () {
      for (let i = 0; i < this.listFc.length; i++) {
          let name= 'fc'+ i
          console.info(name)
         // console.info(this.$refs[name][0])
        this.listCsfc.push((this.$refs[name])[0].setFields())
      }
      return this.listCsfc
    }
  }
}
      </script>
      
      <style>
</style>