<template>
  <div>
      <a-divider orientation="left" style="font-size:14px;">4. 化验复查</a-divider>
    <a-button
      icon="plus"
      @click="AddHyfc"
    >
    </a-button>
    <a-collapse accordion>
      <a-collapse-panel
        :header="index"
        v-for="(item,index) in listFc"
        :key="index+1"
      >
        <hyfc-info :ref="'fc'+index"></hyfc-info>
      </a-collapse-panel>
    </a-collapse>
  </div>
</template>
      
      <script>
import HyfcInfo from './HyfcInfo'
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
    HyfcInfo
  },
  methods: {
    AddHyfc () {
      this.listFc.push('1')
    },
    setFields () {
      for (let i = 0; i < this.listFc.length; i++) {
          let name= 'fc'+ i
        this.listCsfc.push((this.$refs[name])[0].setFields())
      }
      return this.listCsfc
    }
  }
}
      </script>
      
      <style>
</style>