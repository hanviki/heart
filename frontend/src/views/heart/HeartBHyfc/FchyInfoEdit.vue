<template>
  <div>
      <a-divider orientation="left" style="font-size:14px;">4. 化验复查</a-divider>
    <a-button
      icon="plus"
      @click="AddHyfc"
    >
    </a-button>
    <a-collapse v-model="activeKey" accordion>
      <a-collapse-panel
        :header="index"
        v-for="(item,index) in listCsfc"
        :key="item.id"
        :forceRender="true"
      >
        <hyfc-info :ref="'fc'+index"  :checkInfo="item"></hyfc-info>
         <a-icon
          slot="extra"
          type="close"
          @click="e => handleClick(e,item)"
        />
      </a-collapse-panel>
    </a-collapse>
  </div>
</template>
      
      <script>
import HyfcInfo from './HyfcInfoEdit'
export default {
  data () {
    return {
      loading: false,
      form: this.$form.createForm(this),
      listFc: ['1'],
      activeKey: '1',
      baseId: '',
      listCsfc: []
    }
  },
  components: {
    HyfcInfo
  },
  
  methods: {
    reset () {
      this.loading = false
      this.listCsfc = []
      this.listFc = [1]
      this.activeKey = '1'
      this.baseId =''
    },
    AddHyfc () {
      let that =this
      that.$get('comFile/getUid?time='+ new Date().getTime()).then(res => {
           var  baseId =res.data.data
           that.listCsfc.push({id: baseId})
           this.activeKey = that.listCsfc.length
       })
    },
     handleClick (event, item) {
      event.stopPropagation();
      let that = this
      that.$delete('heartBHyfc/' + item.id).then(() => {
        that.$message.success('删除成功')
        const index = that.listCsfc.indexOf(item)
        console.info(index)
        const newList = that.listCsfc.slice()
        newList.splice(index, 1)
        that.listCsfc = newList
      })

    },
    setFields () {
      let list =[]
      for (let i = 0; i < this.listCsfc.length; i++) {
          let name= 'fc'+ i
        list.push((this.$refs[name])[0].setFields())
      }
      return list
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