<template>
  <div>
    <a-divider orientation="left" style="font-size:14px;" >2 检查</a-divider>
    <a-divider orientation="left" style="font-size:14px;" >2.3.1、 心梗三项</a-divider>
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
        :header="(index + 1)"
        v-for="(item,index) in listCsfc"
        :key="item.id"
        :forceRender="true"
      >
        <heartBCheck-info
          :ref="'fc'+index"
          :checkInfo="item"
          :isEdit="isEdit"
        ></heartBCheck-info>
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
import HeartBCheckInfo from './HeartBCheckInfoEdit'
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
    HeartBCheckInfo
  },
  methods: {
    AddCsfc () {
      let that = this
      that.$get('comFile/getUid?time=' + new Date().getTime()).then(res => {
        var baseId = res.data.data
        that.listCsfc.push({ id: baseId })
        this.activeKey = baseId
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
      event.stopPropagation()
      let that = this
      that.$delete('heartBCheck/' + item.id).then(() => {
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
      if (listCsfc.length > 0) {
        this.activeKey = listCsfc[0].id
      }
    }
  }
}
</script>

<style>
</style>
