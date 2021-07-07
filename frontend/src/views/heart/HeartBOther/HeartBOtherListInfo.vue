<template>
  <div>
    <a-divider
      orientation="left"
      style="font-size:14px;"
    >其他</a-divider>
    <a-button
      icon="plus"
      @click="AddPanel"
    >
    </a-button>
    <a-collapse
      v-model="activeKey"
      accordion
    >
      <a-collapse-panel
        :header="index"
        v-for="(item,index) in listFc"
        :key="item.id"
      >
        <heartBOther-info :ref="'fc'+index" :baseId="item.id"></heartBOther-info>
        <a-popconfirm
            placement="topLeft"
            slot="extra"
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
import HeartBOtherInfo from './HeartBOtherInfo'
export default {
  data () {
    return {
      loading: false,
      form: this.$form.createForm(this),
      listFc: [],
      activeKey: '',
      refName: 'fc',
      listCsfc: []
    }
  },
  components: {
    HeartBOtherInfo
  },
  methods: {
    reset () {
      this.loading = false
      this.listCsfc = []
      this.listFc = []
      this.activeKey = ''
    },
    AddPanel () {
      this.$get('comFile/getUid?time=' + new Date().getTime()).then(res => {
        var baseId = res.data.data
        this.listFc.push({ id: baseId })
        this.activeKey = baseId
        console.log('其他 Id 创建成功.')
      })
    },
    handleClick (event, item) {
      event.stopPropagation()
      const index = this.listFc.indexOf(item)
      const newList = this.listFc.slice()
      newList.splice(index, 1)
      this.listFc = newList
    },
    setFields () {
      this.listCsfc = []
      for (let i = 0; i < this.listFc.length; i++) {
        let name = this.refName + i

        this.listCsfc.push((this.$refs[name])[0].setFields())
      }
      return this.listCsfc
    }
  }
}
</script>

<style>
</style>
