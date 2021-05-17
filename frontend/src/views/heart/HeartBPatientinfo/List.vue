<template>
  <a-card title="数据列表">
    <a-list
      class="demo-loadmore-list"
      :loading="loading"
      item-layout="vertical"
      :data-source="data"
    >
      <div
        v-if="showLoadingMore"
        slot="loadMore"
        :style="{ textAlign: 'left', marginTop: '3px' }"
      >
        <a-spin v-if="loadingMore" />
        <a-button
          v-else
          @click="onLoadMore"
        >
          加载更多
        </a-button>
      </div>
      <a-list-item
        slot="renderItem"
        slot-scope="item, index"
      >
      <a slot="actions" @click="edit(item)">编辑</a>
        <a-list-item-meta>
          <span slot="title">{{ item.fileNo }} </span>
        </a-list-item-meta>

        <a-form-item
          v-bind="formItemLayout"
          label="病案号"
        >
          {{item.fileNo}}
        </a-form-item>

        <a-form-item
          v-bind="formItemLayout"
          label="姓名"
        >
          {{item.name}}
        </a-form-item>

        <a-form-item
          v-bind="formItemLayout"
          label="年龄"
        >
          {{item.age}}
        </a-form-item>
      </a-list-item>
    </a-list>
     <heartBPatientinfo-edit
      ref="heartBPatientinfoEdit"
      @close="handleEditClose"
      @success="handleEditSuccess"
      :editVisiable="editVisiable"
    >
    </heartBPatientinfo-edit>
  </a-card>
</template>

<script>
const formItemLayout = {
  labelCol: { span: 8 },
  wrapperCol: { span: 15 }
}
const pageSize = 10
import HeartBPatientinfoEdit from './HeartBPatientinfoEdit'
export default {
  data () {
    return {
      loading: true,
      loadingMore: false,
      formItemLayout,
      pageSize,
      showLoadingMore: true,
      data: [],
      page: 1,
       editVisiable: false,
    }
  },
  components: { HeartBPatientinfoEdit },
  mounted () {
    this.fetch({
      pageNum: this.page,
      pageSize: this.pageSize
    })
  },
  methods: {
    onLoadMore () {
      this.loadingMore = true;
      this.page += 1
      this.fetch({
        pageNum: this.page,
        pageSize: this.pageSize
      })
    },
     handleEditClose () {
      this.editVisiable = false
    },
    edit (record) {
      this.$refs.heartBPatientinfoEdit.fetch(record.fileNo)
      this.editVisiable = true
    },
    fetch (params = {}) {
      this.loading = true
      this.$get('heartBPatientinfo', {
        ...params
      }).then((r) => {
        let data = r.data
        let total = data.total
        if (this.page * this.pageSize < total) {
          this.showLoadingMore = true
        }
        else {
          this.showLoadingMore = false
        }
        this.loading = false
        this.data = this.data.concat(data.rows);

      })
    }
  }
}
</script>

<style>
</style>