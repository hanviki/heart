<template>
  <div>
            <a-divider
        orientation="left"
        style="font-size:14px;"
      >2.3.3、血气分析</a-divider>
    <a-button
      icon="plus"
      @click="AddCsfc"
    >
    </a-button>
    <a-collapse
      v-model="activeKey"
      accordion
    >
      <a-collapse-panel
        :header="index"
        v-for="(item,index) in listFc"
        :key="item.toString()"
      >
        <heartBCheckthree-info :ref="'fc'+item"></heartBCheckthree-info>
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
import HeartBCheckthreeInfo from './HeartBCheckthreeInfo'
export default {
  data () {
    return {
      loading: false,
      form: this.$form.createForm(this),
      listFc: [1],
      activeKey: '1',
      refName: 'fc',
      baseId: '',
      listCsfc: []
    }
  },
  components: {
    HeartBCheckthreeInfo
  },
  methods: {
    reset () {
      this.loading = false
      this.baseId = ''
      this.listCsfc = []
      this.listFc = [1]
      setTimeout(() => {
        (this.$refs[this.refName + '1'])[0].reset()
      }, 200)
      this.activeKey = '1'
    },
    AddCsfc () {
      let len = this.listFc.length
      if (len === 0) {
        len = 1
      } else {
        len = this.listFc[len - 1] + 1
      }
      this.listFc.push(len)
      let val = this.listFc[this.listFc.length - 1]
      let name = this.refName + val
      this.activeKey = val
      this.execId(name)
    },
    execId (name) {
      setTimeout(() => {
        (this.$refs[name])[0].fetch()
      }, 200)
    },
    getId () {
      for (let i = 0; i < this.listFc.length; i++) {
        let name = this.refName + this.listFc[i]
        console.info(name)

        this.execId(name)
      }
    },
    handleClick (event, item) {
      event.stopPropagation();
      const index = this.listFc.indexOf(item)
      const newList = this.listFc.slice()
      newList.splice(index, 1)
      this.listFc = newList
    },
    setFields () {
      this.listCsfc = []
      for (let i = 0; i < this.listFc.length; i++) {
        let name = this.refName + this.listFc[i]

        this.listCsfc.push((this.$refs[name])[0].setFields())
      }
      return this.listCsfc
    }
  }
}
</script>

<style>
</style>