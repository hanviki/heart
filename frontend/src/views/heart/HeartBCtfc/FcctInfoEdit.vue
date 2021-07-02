<template>
  <div>
      <a-divider orientation="left" style="font-size:14px;">3. CT复查</a-divider>
    <a-button
      icon="plus"
      @click="AddCtfc"
      v-show="isEdit"
    >
    </a-button>
    <a-collapse v-model="activeKey" accordion>
      <a-collapse-panel
        :header="(index + 1)"
        v-for="(item,index) in listCsfc"
        :key="item.id"
        :forceRender="true"
      >
        <ctfc-info :ref="'fc'+index" :checkInfo="item" :isEdit="isEdit"></ctfc-info>
         <a-popconfirm
            placement="topLeft" 
            slot="extra"
            v-show="isEdit"
            title="确定要删除吗?"
            @confirm="e => handleClick(e,item)"
            okText="确定"
            cancelText="取消"
          >
            <a-icon @click.stop type="close"></a-icon>
          </a-popconfirm>
      </a-collapse-panel>
    </a-collapse>
  </div>
</template>
      
      <script>
import CtfcInfo from './CtfcInfoEdit'
export default {
  props: {
    isEdit: {
        default: true
    }
  },
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
    CtfcInfo
  },
  methods: {
    reset () {
      this.listCsfc = []
      this.listFc = ['1']
      this.activeKey = '1'
      this.baseId = ''
    },
    AddCtfc () {
      let that =this
      that.$get('comFile/getUid?time='+ new Date().getTime()).then(res => {
           var  baseId =res.data.data
           that.listCsfc.push({id: baseId})
           this.activeKey = baseId
       })
    },
    handleClick (event, item) {
      event.stopPropagation();
      let that = this
      that.$delete('heartBCtfc/' + item.id).then(() => {
        that.$message.success('删除成功')
        const index = that.listCsfc.indexOf(item)
        const newList = that.listCsfc.slice()
        newList.splice(index, 1)
        that.listCsfc = newList
      })

    },
    setFields () {
     let list =[]
      for (let i = 0; i < this.listCsfc.length; i++) {
          let name= 'fc'+ i
          console.info(name)
         // console.info(this.$refs[name][0])
        list.push((this.$refs[name])[0].setFields())
      }
      return list
    },
     setFormValues (listCsfc) {
      let that =this
      that.listCsfc =listCsfc
      if (listCsfc.length > 0) {
        this.activeKey = listCsfc[0].id
      }
    },
  }
}
      </script>
      
      <style>
</style>