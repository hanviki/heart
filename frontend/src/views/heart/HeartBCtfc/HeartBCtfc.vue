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
                <a-button v-hasPermission="['heartBCtfc:add']" type="primary" ghost @click="add">新增</a-button>
                <a-button v-hasPermission="['heartBCtfc:delete']" @click="batchDelete">删除</a-button>
                <a-dropdown v-hasPermission="['heartBCtfc:export']">
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
                    <a-icon v-hasPermission="['heartBCtfc:update']" type="setting" theme="twoTone" twoToneColor="#4a9ff5" @click="edit(record)" title="修改"></a-icon>
                    <a-badge v-hasNoPermission="['heartBCtfc:update']" status="warning" text="无权限"></a-badge>
                </template>
            </a-table>
        </div>
        <!-- 新增字典 -->
        <heartBCtfc-add
        @close="handleAddClose"
        @success="handleAddSuccess"
        :addVisiable="addVisiable">
    </heartBCtfc-add>
    <!-- 修改字典 -->
    <heartBCtfc-edit
    ref="heartBCtfcEdit"
    @close="handleEditClose"
    @success="handleEditSuccess"
    :editVisiable="editVisiable">
</heartBCtfc-edit>
</a-card>
</template>

<script>
    import HeartBCtfcAdd from './HeartBCtfcAdd'
    import HeartBCtfcEdit from './HeartBCtfcEdit'

    export default {
        name: 'HeartBCtfc',
        components: {HeartBCtfcAdd, HeartBCtfcEdit},
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
                            title: '图片名',
                        dataIndex: 'fileName'
                    },                    {
                            title: '图片地址',
                        dataIndex: 'fileUrl'
                    },                    {
                            title: 'CT复查时间',
                        dataIndex: 'ctDate'
                    },                    {
                            title: '支架末端位置(胸椎序号)',
                        dataIndex: 'zjwdwzCode'
                    },                    {
                            title: '窦直径',
                        dataIndex: 'dzj'
                    },                    {
                            title: '升主脉动直径',
                        dataIndex: 'szmdzj'
                    },                    {
                            title: '主动脉弓直径',
                        dataIndex: 'zdmgzj'
                    },                    {
                            title: '胸主动脉上段直径',
                        dataIndex: 'xzdmsdzj'
                    },                    {
                            title: '胸主动脉上段假腔/血肿直径',
                        dataIndex: 'xzdmsdjqxzzj'
                    },                    {
                            title: '胸主动脉中段直径',
                        dataIndex: 'xzdmzdzj'
                    },                    {
                            title: '胸主动脉中段假腔/血肿直径',
                        dataIndex: 'xzdmzdjqzj'
                    },                    {
                            title: '胸主动脉下段直径',
                        dataIndex: 'xzdmxdzj'
                    },                    {
                            title: '胸主动脉下段假腔/血肿直径',
                        dataIndex: 'xzdmxdjqzj'
                    },                    {
                            title: '腹主动脉上段直径',
                        dataIndex: 'fzdmsdzj'
                    },                    {
                            title: '腹主动脉上段假腔/血肿直径',
                        dataIndex: 'fzdmsdjqzj'
                    },                    {
                            title: '腹主动脉下段直径',
                        dataIndex: 'fzdmxdzj'
                    },                    {
                            title: '腹主动脉下段假腔/血肿直径',
                        dataIndex: 'fzdmxdjqzj'
                    },                    {
                            title: '近端吻合口漏',
                        dataIndex: 'jdwhkl'
                    },                    {
                            title: '远端吻合口漏',
                        dataIndex: 'ydwhkl'
                    },                    {
                            title: '升主周围血肿',
                        dataIndex: 'szzwxz'
                    },                    {
                            title: '弓部血肿',
                        dataIndex: 'gbxz'
                    },                    {
                            title: '假腔转归',
                        dataIndex: 'jqzg'
                    },                    {
                            title: '腹腔干转归',
                        dataIndex: 'fqqzg'
                    },                    {
                            title: '左肾脉动转归',
                        dataIndex: 'zsmdzg'
                    },                    {
                            title: '右肾脉动转归',
                        dataIndex: 'ysmdzg'
                    },                    {
                            title: '左髂总转归',
                        dataIndex: 'zkzzg'
                    },                    {
                            title: '右髂总转归',
                        dataIndex: 'ykzzg'
                    },                    {
                            title: '人工血管异常说明',
                        dataIndex: 'rgxgycsm'
                    },                    {
                            title: '动脉瘤样扩张',
                        dataIndex: 'dmlykz'
                    },                    {
                            title: '支架异常说明',
                        dataIndex: 'zjycsm'
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
                this.$refs.heartBCtfcEdit.setFormValues(record)
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
                        let heartBCtfcIds = that.selectedRowKeys.join(',')
                        that.$delete('heartBCtfc/' + heartBCtfcIds).then(() => {
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
                this.$export('heartBCtfc/excel', {
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
                this.$get('heartBCtfc', {
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
