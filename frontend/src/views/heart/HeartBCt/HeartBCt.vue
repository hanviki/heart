<template>
    <a-card :bordered="false" class="card-area">
        <div :class="advanced ? 'search' : null">
            <a-form layout="horizontal">
                <div :class="advanced ? null: 'fold'">
                    <a-row >
                        <a-col :md="8" :sm="24" >
                            <a-form-item
                                    label="名称"
                                    :labelCol="{span: 5}"
                                    :wrapperCol="{span: 18, offset: 1}">
                                <a-input v-model="queryParams.name"/>
                            </a-form-item>
                        </a-col>
                        <a-col :md="8" :sm="24" >
                            <a-form-item
                                    label="编码"
                                    :labelCol="{span: 5}"
                                    :wrapperCol="{span: 18, offset: 1}">
                                <a-input v-model="queryParams.code"/>
                            </a-form-item>
                        </a-col>
                    </a-row>
                    <a-row v-if="advanced">
                        <a-col :md="8" :sm="24" >
                            <a-form-item
                                    label="备注"
                                    :labelCol="{span: 5}"
                                    :wrapperCol="{span: 18, offset: 1}">
                                <a-input v-model="queryParams.comments" />
                            </a-form-item>
                        </a-col>
                    </a-row>
                </div>
                <span style="float: right; margin-top: 3px;">
          <a-button type="primary" @click="search">查询</a-button>
          <a-button style="margin-left: 8px" @click="reset">重置</a-button>
          <a @click="toggleAdvanced" style="margin-left: 8px">
            {{advanced ? '收起' : '展开'}}
            <a-icon :type="advanced ? 'up' : 'down'" />
          </a>
        </span>
            </a-form>
        </div>
        <div>
            <div class="operator">
                <a-button v-hasPermission="['heartBCt:add']" type="primary" ghost @click="add">新增</a-button>
                <a-button v-hasPermission="['heartBCt:delete']" @click="batchDelete">删除</a-button>
                <a-dropdown v-hasPermission="['heartBCt:export']">
                    <a-menu slot="overlay">
                        <a-menu-item key="export-data" @click="exportExcel">导出Excel</a-menu-item>
                    </a-menu>
                    <a-button>
                        更多操作 <a-icon type="down" />
                    </a-button>
                </a-dropdown>
            </div>
            <!-- 表格区域 -->
            <a-table ref="TableInfo"
                     :columns="columns"
                     :rowKey="record => record.id"
                     :dataSource="dataSource"
                     :pagination="pagination"
                     :loading="loading"
                     :rowSelection="{selectedRowKeys: selectedRowKeys, onChange: onSelectChange}"
                     @change="handleTableChange"
                     :bordered="bordered"
                     :scroll="{ x: 900 }">
                <template slot="remark" slot-scope="text, record">
                    <a-popover placement="topLeft">
                        <template slot="content">
                            <div style="max-width: 200px">{{text}}</div>
                        </template>
                        <p style="width: 200px;margin-bottom: 0">{{text}}</p>
                    </a-popover>
                </template>
                <template slot="operation" slot-scope="text, record">
                    <a-icon v-hasPermission="['heartBCt:update']" type="setting" theme="twoTone" twoToneColor="#4a9ff5" @click="edit(record)" title="修改"></a-icon>
                    <a-badge v-hasNoPermission="['heartBCt:update']" status="warning" text="无权限"></a-badge>
                </template>
            </a-table>
        </div>
        <!-- 新增字典 -->
        <heartBCt-add
        @close="handleAddClose"
        @success="handleAddSuccess"
        :addVisiable="addVisiable">
    </heartBCt-add>
    <!-- 修改字典 -->
    <heartBCt-edit
    ref="heartBCtEdit"
    @close="handleEditClose"
    @success="handleEditSuccess"
    :editVisiable="editVisiable">
</heartBCt-edit>
</a-card>
</template>

<script>
    import HeartBCtAdd from './HeartBCtAdd'
    import HeartBCtEdit from './HeartBCtEdit'

    export default {
        name: 'HeartBCt',
        components: {HeartBCtAdd, HeartBCtEdit},
        data () {
            return {
                advanced: false,
                dataSource: [],
                selectedRowKeys: [],
                sortedInfo: null,
                paginationInfo: null,
                pagination: {
                    pageSizeOptions: ['10', '20', '30', '40', '100'],
                    defaultCurrent: 1,
                    defaultPageSize: 10,
                    showQuickJumper: true,
                    showSizeChanger: true,
                    showTotal: (total, range) => `显示 ${range[0]} ~ ${range[1]} 条记录，共 ${total} 条记录`
            },
                    queryParams: {},
            addVisiable: false,
                    editVisiable: false,
                    loading: false,
                    bordered: true
        }
        },
        computed: {
            columns () {
                let { sortedInfo } = this
                sortedInfo = sortedInfo || {}
                return [                    {
                            title: '主键自增',
                        dataIndex: 'id'
                    },                    {
                            title: '用户帐号',
                        dataIndex: 'username'
                    },                    {
                            title: '病案号',
                        dataIndex: 'fileNo'
                    },                    {
                            title: '姓名',
                        dataIndex: 'name'
                    },                    {
                            title: 'CT图片名称',
                        dataIndex: 'fileNamect'
                    },                    {
                            title: 'CT图片地址',
                        dataIndex: 'filePathct'
                    },                    {
                            title: '主动脉窦直径',
                        dataIndex: 'ctZdmdzj'
                    },                    {
                            title: '升主动脉直径',
                        dataIndex: 'ctSzdmzj'
                    },                    {
                            title: '主动脉弓直径',
                        dataIndex: 'ctZdmgzj'
                    },                    {
                            title: '胸上主动脉直径',
                        dataIndex: 'ctXszdmzj'
                    },                    {
                            title: '胸中主动脉直径',
                        dataIndex: 'ctXzzdmzj'
                    },                    {
                            title: '胸下主动脉直径',
                        dataIndex: 'ctXxzdmzj'
                    },                    {
                            title: '腹主动脉上段直径',
                        dataIndex: 'ctFzdmsdzj'
                    },                    {
                            title: '腹主动脉下段直径',
                        dataIndex: 'ctFzdmxdzj'
                    },                    {
                            title: '升主动脉假腔直径',
                        dataIndex: 'ctSzdmjqzj'
                    },                    {
                            title: '主动脉弓假腔直径',
                        dataIndex: 'ctZdmgjqzj'
                    },                    {
                            title: '胸上假腔直径',
                        dataIndex: 'ctXsjqzj'
                    },                    {
                            title: '胸中假腔直径',
                        dataIndex: 'ctXzjqzj'
                    },                    {
                            title: '胸下假腔直径',
                        dataIndex: 'ctXxjqzj'
                    },                    {
                            title: '腹上假腔直径',
                        dataIndex: 'ctFsjqzj'
                    },                    {
                            title: '腹下假腔直径',
                        dataIndex: 'ctFxjqzj'
                    },                    {
                            title: '主动脉夹层阜外分型',
                        dataIndex: 'ctZdmjcfwfx'
                    },                    {
                            title: '升主夹层病理',
                        dataIndex: 'ctSzjcbl'
                    },                    {
                            title: '主动脉弓假腔位置',
                        dataIndex: 'ctZdmgjqwz'
                    },                    {
                            title: '主动脉胸段病理',
                        dataIndex: 'ctZdxdbl'
                    },                    {
                            title: '主动脉胸段假腔位置',
                        dataIndex: 'ctZdxdjqwz'
                    },                    {
                            title: '腹主动脉上段病理',
                        dataIndex: 'ctFzdmsdbl'
                    },                    {
                            title: '腹主动脉假腔位置',
                        dataIndex: 'ctFzdmjqwz'
                    },                    {
                            title: '肾动脉下夹层病理',
                        dataIndex: 'ctSdmxjcbl'
                    },                    {
                            title: '肾下假腔位置',
                        dataIndex: 'ctSxjqwz'
                    },                    {
                            title: '原发破口位置',
                        dataIndex: 'ctYfpkwz'
                    },                    {
                            title: '原发破口大小',
                        dataIndex: 'ctYfpkdx'
                    },                    {
                            title: '缺血或重度受压分支血管',
                        dataIndex: 'ctQxhzdsyfzxg'
                    },                    {
                            title: '完全缺血器官',
                        dataIndex: 'ctWqqxqg'
                    },                    {
                            title: '夹层累及范围',
                        dataIndex: 'ctJcljfw'
                    },                    {
                            title: '主动脉夹层特殊征象',
                        dataIndex: 'ctZdmjctszx'
                    },                    {
                            title: '假腔供血器官',
                        dataIndex: 'ctJqgxqg'
                    },                    {
                            title: '备注',
                        dataIndex: 'ctNote'
                    },                    {
                            title: '是否删除',
                        dataIndex: 'isDeletemark'
                    },                    {
                            title: '创建时间',
                        dataIndex: 'createTime'
                    },                    {
                            title: '修改时间',
                        dataIndex: 'modifyTime'
                    },                    {
                            title: '创建人',
                        dataIndex: 'createUserId'
                    },                    {
                            title: '修改人',
                        dataIndex: 'modifyUserId'
                    },                    {
                        title: '操作',
                        dataIndex: 'operation',
                        scopedSlots: { customRender: 'operation' },
                        fixed: 'right',
                        width: 100
                    }]
            }
        },
        mounted () {
            this.fetch()
        },
        methods: {
            onSelectChange (selectedRowKeys) {
                this.selectedRowKeys = selectedRowKeys
            },
            toggleAdvanced () {
                this.advanced = !this.advanced
                if (!this.advanced) {
                    this.queryParams.comments = ''
                }
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
                this.$refs.heartBCtEdit.setFormValues(record)
                this.editVisiable = true
            },
            batchDelete () {
                if (!this.selectedRowKeys.length) {
                    this.$message.warning('请选择需要删除的记录')
                            return
                }
                let that = this
                this.$confirm({
                    title: '确定删除所选中的记录?',
                    content: '当您点击确定按钮后，这些记录将会被彻底删除',
                    centered: true,
                    onOk () {
                        let heartBCtIds = that.selectedRowKeys.join(',')
                        that.$delete('heartBCt/' + heartBCtIds).then(() => {
                            that.$message.success('删除成功')
                                    that.selectedRowKeys = []
                            that.search()
                        })
                    },
                    onCancel () {
                        that.selectedRowKeys = []
                    }
                })
            },
            exportExcel () {
                let { sortedInfo } = this
                let sortField, sortOrder
                // 获取当前列的排序和列的过滤规则
                if (sortedInfo) {
                    sortField = sortedInfo.field
                    sortOrder = sortedInfo.order
                }
                this.$export('heartBCt/excel', {
                    sortField: sortField,
                    sortOrder: sortOrder,
                    ...this.queryParams
                })
            },
            search () {
                let { sortedInfo } = this
                let sortField, sortOrder
                // 获取当前列的排序和列的过滤规则
                if (sortedInfo) {
                    sortField = sortedInfo.field
                    sortOrder = sortedInfo.order
                }
                this.fetch({
                    sortField: sortField,
                    sortOrder: sortOrder,
                    ...this.queryParams
                })
            },
            reset () {
                // 取消选中
                this.selectedRowKeys = []
                // 重置分页
                this.$refs.TableInfo.pagination.current = this.pagination.defaultCurrent
                if (this.paginationInfo) {
                    this.paginationInfo.current = this.pagination.defaultCurrent
                    this.paginationInfo.pageSize = this.pagination.defaultPageSize
                }
                // 重置列排序规则
                this.sortedInfo = null
                this.paginationInfo = null
                // 重置查询参数
                this.queryParams = {}
                this.fetch()
            },
            handleTableChange (pagination, filters, sorter) {
                this.sortedInfo = sorter
                this.paginationInfo = pagination
                this.fetch({
                    sortField: sorter.field,
                    sortOrder: sorter.order,
                    ...this.queryParams
                })
            },
            fetch (params = {}) {
                this.loading = true
                if (this.paginationInfo) {
                    // 如果分页信息不为空，则设置表格当前第几页，每页条数，并设置查询分页参数
                    this.$refs.TableInfo.pagination.current = this.paginationInfo.current
                    this.$refs.TableInfo.pagination.pageSize = this.paginationInfo.pageSize
                    params.pageSize = this.paginationInfo.pageSize
                    params.pageNum = this.paginationInfo.current
                } else {
                    // 如果分页信息为空，则设置为默认值
                    params.pageSize = this.pagination.defaultPageSize
                    params.pageNum = this.pagination.defaultCurrent
                }
                this.$get('heartBCt', {
                    ...params
                }).then((r) => {
                    let data = r.data
                    const pagination = { ...this.pagination }
                    pagination.total = data.total
                    this.loading = false
                    this.dataSource = data.rows
                    this.pagination = pagination
                })
            }
        }
    }
</script>

<style lang="less" scoped>
    @import "../../../../static/less/Common";
</style>
