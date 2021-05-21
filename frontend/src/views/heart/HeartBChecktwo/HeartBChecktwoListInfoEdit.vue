<template>
  <div>
          <a-divider
        orientation="left"
        style="font-size:14px;"
      >2.3.2 血常规</a-divider>
    <a-button
      icon="plus"
      @click="AddCsfc"
      v-show="isEdit"
    >
    </a-button>
    <a-collapse
      v-model="activeKey"
      accordion
    >
      <a-collapse-panel
        :header="index"
        v-for="(item,index) in listCsfc"
        :key="item.id"
        :forceRender="true"
      >
        <heartBChecktwo-infoEdit
          :ref="'fc'+index"
          :checkInfo="item"
          :isEdit="isEdit"
        ></heartBChecktwo-infoEdit>
        <a-icon
          slot="extra"
          type="close"
          v-show="isEdit"
          @click="e => handleClick(e,item)"
        />
      </a-collapse-panel>
    </a-collapse>
  </div>
</template>

<script>
import HeartBChecktwoInfoEdit from './HeartBChecktwoInfoEdit.vue'
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
      listFc: [],
      activeKey: '1',
      baseId: '',
      listCsfc: []
    }
  },
  components: {
    HeartBChecktwoInfoEdit
  },
  methods: {
    AddCsfc () {
      let that = this
      that.$get('comFile/getUid?time=' + new Date().getTime()).then(res => {
        var baseId = res.data.data
        that.listCsfc.push({ id: baseId })
        this.activeKey = that.listCsfc.length
      })
    },
    reset () {
      this.loading = false
      this.baseId = ''
      this.activeKey = '1'
      this.listFc = []
      this.listCsfc = []
    },
    handleClick (event, item) {
      event.stopPropagation();
      let that = this
      that.$delete('heartBCsfc/' + item.id).then(() => {
        that.$message.success('删除成功')
        const index = that.listCsfc.indexOf(item)
        const newList = that.listCsfc.slice()
        newList.splice(index, 1)
        that.listCsfc = newList
      })

    },
    setFields () {
      let list = []
      for (let i = 0; i < this.listCsfc.length; i++) {
        let name = 'fc' + i


        list.push((this.$refs[name])[0].setFields())
      }
      return list
    },
    setFormValues (listCsfc) {
      let that = this
      that.listCsfc = listCsfc
    },
  }
}
</script>

<style>
</style>