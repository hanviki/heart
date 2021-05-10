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
                <a-button v-hasPermission="['heartBCheck:add']" type="primary" ghost @click="add">新增</a-button>
                <a-button v-hasPermission="['heartBCheck:delete']" @click="batchDelete">删除</a-button>
                <a-dropdown v-hasPermission="['heartBCheck:export']">
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
                    <a-icon v-hasPermission="['heartBCheck:update']" type="setting" theme="twoTone" twoToneColor="#4a9ff5" @click="edit(record)" title="修改"></a-icon>
                    <a-badge v-hasNoPermission="['heartBCheck:update']" status="warning" text="无权限"></a-badge>
                </template>
            </a-table>
        </div>
        <!-- 新增字典 -->
        <heartBCheck-add
        @close="handleAddClose"
        @success="handleAddSuccess"
        :addVisiable="addVisiable">
    </heartBCheck-add>
    <!-- 修改字典 -->
    <heartBCheck-edit
    ref="heartBCheckEdit"
    @close="handleEditClose"
    @success="handleEditSuccess"
    :editVisiable="editVisiable">
</heartBCheck-edit>
</a-card>
</template>

<script>
    import HeartBCheckAdd from './HeartBCheckAdd'
    import HeartBCheckEdit from './HeartBCheckEdit'

    export default {
        name: 'HeartBCheck',
        components: {HeartBCheckAdd, HeartBCheckEdit},
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
                            title: '肌红蛋白',
                        dataIndex: 'jhdb'
                    },                    {
                            title: '肌钙蛋白',
                        dataIndex: 'jgdb'
                    },                    {
                            title: 'CK-MB',
                        dataIndex: 'ckmb'
                    },                    {
                            title: '超敏肌钙蛋白（optional）',
                        dataIndex: 'cmjgdb'
                    },                    {
                            title: '红细胞计数',
                        dataIndex: 'hxbjs'
                    },                    {
                            title: '血红蛋白',
                        dataIndex: 'xhdb'
                    },                    {
                            title: '白细胞计数',
                        dataIndex: 'bxbjs'
                    },                    {
                            title: '中性粒细胞百分比',
                        dataIndex: 'zxlxbbfb'
                    },                    {
                            title: '血小板计数',
                        dataIndex: 'xxbjs'
                    },                    {
                            title: 'PH',
                        dataIndex: 'ph'
                    },                    {
                            title: '乳酸',
                        dataIndex: 'rs'
                    },                    {
                            title: 'BE',
                        dataIndex: 'be'
                    },                    {
                            title: 'SO2',
                        dataIndex: 'so2'
                    },                    {
                            title: 'PO2',
                        dataIndex: 'po2'
                    },                    {
                            title: 'PCO2',
                        dataIndex: 'pco2'
                    },                    {
                            title: '血肌肝',
                        dataIndex: 'xjg'
                    },                    {
                            title: 'ALT',
                        dataIndex: 'alt'
                    },                    {
                            title: 'AST',
                        dataIndex: 'ast'
                    },                    {
                            title: '总胆红素',
                        dataIndex: 'zdhs'
                    },                    {
                            title: '直接胆红素',
                        dataIndex: 'zjdhs'
                    },                    {
                            title: '淀粉酶',
                        dataIndex: 'dfm'
                    },                    {
                            title: 'D二聚体',
                        dataIndex: 'd2jt'
                    },                    {
                            title: 'FDP',
                        dataIndex: 'fdp'
                    },                    {
                            title: 'PT',
                        dataIndex: 'pt'
                    },                    {
                            title: 'APTT',
                        dataIndex: 'aptt'
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
                this.$refs.heartBCheckEdit.setFormValues(record)
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
                        let heartBCheckIds = that.selectedRowKeys.join(',')
                        that.$delete('heartBCheck/' + heartBCheckIds).then(() => {
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
                this.$export('heartBCheck/excel', {
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
                this.$get('heartBCheck', {
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
