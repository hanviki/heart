<template>
  <a-card title="数据列表">
      <a-button
          type="primary"
          ghost
          @click="add"
        >新增</a-button>
        <div>
          <a-form-item
                label="姓名"
                :labelCol="{span: 8}"
                :wrapperCol="{span: 15, offset: 1}"
              >
                <a-input v-model="queryParams.name" />
              </a-form-item>
              <a-form-item
                label="档案号"
                :labelCol="{span: 8}"
                :wrapperCol="{span: 15, offset: 1}"
              >
                <a-input v-model="queryParams.fileNo" />
              </a-form-item>
               <a-button
            type="primary"
            @click="search"
          >查询</a-button>
        </div>
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
        <a-card :title="`病案号${item.fileNo}`">
          <a slot="extra" href="#" @click="edit(item)">编辑</a>
          <a-form-item v-bind="formItemLayout"
                    label="姓名">
                       {{item.name}}
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="年龄">
                       {{item.age}}
                </a-form-item>
        </a-card>
      </a-list-item>
    </a-list>
    <!-- 新增字典 -->
    <heartBPatientinfo-add
      ref="heartBPatientinfoAdd"
      @close="handleAddClose"
      @success="handleAddSuccess"
      :addVisiable="addVisiable"
    >
    </heartBPatientinfo-add>
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
import HeartBPatientinfoAdd from './HeartBPatientinfoAdd'
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
      queryParams: {
        fileNo: '',
        name: ''
      },
      page: 1,
       editVisiable: false,
       addVisiable: false,
    }
  },
  components: { HeartBPatientinfoEdit, HeartBPatientinfoAdd },
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
    search (){
      this.data= []
      this.page = 1
      this.fetch({
        pageNum: this.page,
        pageSize: this.pageSize,
        ...this.queryParams
      })
    },
    handleAddSuccess () {
      this.addVisiable = false
      this.$message.success('新增成功')
      this.search()
    },
    handleAddClose () {
      this.addVisiable = false
    },
    add () {
      this.addVisiable = true
      this.$refs.heartBPatientinfoAdd.getId()
    },
     handleEditSuccess () {
      this.editVisiable = false
      this.$message.success('修改成功')
      this.search()
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