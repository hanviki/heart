<template>
  <a-card title="页面导航">
    <a-card-grid style="width:80%;text-align:center">
      <a-button
        type="primary"
        @click="navigationToPerson"
      >
        个人数据
      </a-button>
    </a-card-grid>
    <a-card-grid style="width:80%;text-align:center">
      <a-button
        type="primary"
        @click="navigationToAll"
      >
        全部数据
      </a-button>
    </a-card-grid>
  </a-card>
</template>

<script>
export default {
    data() {

    },
    methods :{
navigationToPerson () {
    this.$router.push('/heart/info')

}
    }
}
</script>

<style>
</style>