<template>
    <a-drawer
            title="修改"
            :maskClosable="false"
            width=650
            placement="right"
            :closable="false"
            @close="onClose"
            :visible="editVisiable"
            style="height: calc(100% - 55px);overflow: auto;padding-bottom: 53px;">
        <a-form :form="form">
                <a-form-item
                        v-bind="formItemLayout"
                        label="主键自增">
                        <a-input placeholder="请输入主键自增" v-decorator="['id', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="用户帐号">
                        <a-input placeholder="请输入用户帐号" v-decorator="['username', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="病案号">
                        <a-input placeholder="请输入病案号" v-decorator="['fileNo', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="姓名">
                        <a-input placeholder="请输入姓名" v-decorator="['name', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="血气结果时间">
                        <a-input placeholder="请输入血气结果时间" v-decorator="['xqtype', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="PH">
                        <a-input placeholder="请输入PH" v-decorator="['ph', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="PO2">
                        <a-input placeholder="请输入PO2" v-decorator="['po2', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="PCO2">
                        <a-input placeholder="请输入PCO2" v-decorator="['pco2', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="K+">
                        <a-input placeholder="请输入K+" v-decorator="['k', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="Na+">
                        <a-input placeholder="请输入Na+" v-decorator="['na', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="Ca+">
                        <a-input placeholder="请输入Ca+" v-decorator="['ca', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="GLU">
                        <a-input placeholder="请输入GLU" v-decorator="['glu', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="BE">
                        <a-input placeholder="请输入BE" v-decorator="['be', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="Lac">
                        <a-input placeholder="请输入Lac" v-decorator="['lac', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="Hb">
                        <a-input placeholder="请输入Hb" v-decorator="['hb', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="FiaO2">
                        <a-input placeholder="请输入FiaO2" v-decorator="['fiao2', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="备注">
                        <a-input placeholder="请输入备注" v-decorator="['note', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="是否删除">
                        <a-input placeholder="请输入是否删除" v-decorator="['isDeletemark', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="创建时间">
                        <a-date-picker showTime format='YYYY-MM-DD HH:mm:ss' v-decorator="[ 'createTime', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="修改时间">
                        <a-date-picker showTime format='YYYY-MM-DD HH:mm:ss' v-decorator="[ 'modifyTime', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="创建人">
                        <a-input placeholder="请输入创建人" v-decorator="['createUserId', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="修改人">
                        <a-input placeholder="请输入修改人" v-decorator="['modifyUserId', {}]" />
                </a-form-item>
        </a-form>
        <div class="drawer-bootom-button">
            <a-popconfirm title="确定放弃编辑？" @confirm="onClose" okText="确定" cancelText="取消">
                <a-button style="margin-right: .8rem">取消</a-button>
            </a-popconfirm>
            <a-button @click="handleSubmit" type="primary" :loading="loading">提交</a-button>
        </div>
    </a-drawer>
</template>
<script>
    import moment from 'moment'

    const formItemLayout = {
        labelCol: { span: 3 },
        wrapperCol: { span: 18 }
    }
    export default {
        name: 'HeartBShzlxqEdit',
        props: {
            editVisiable: {
                default: false
            }
        },
        data () {
            return {
                loading: false,
                formItemLayout,
                form: this.$form.createForm(this),
            heartBShzlxq: {}
        }
        },
        methods: {
            reset () {
                this.loading = false
                this.form.resetFields()
            },
            onClose () {
                this.reset()
                this.$emit('close')
            },
            setFormValues ({...heartBShzlxq}) {
                let fields = [  'id'     ,  'username'     ,  'fileNo'     ,  'name'     ,  'xqtype'     ,  'ph'     ,  'po2'     ,  'pco2'     ,  'k'     ,  'na'     ,  'ca'     ,  'glu'     ,  'be'     ,  'lac'     ,  'hb'     ,  'fiao2'     ,  'note'     ,  'isDeletemark'     ,  'createTime'     ,  'modifyTime'     ,  'createUserId'     ,  'modifyUserId'   ]
                let fieldDates = [                                                         'createTime'         , 'modifyTime'           ]
                Object.keys(heartBShzlxq).forEach((key) => {
                    if (fields.indexOf(key) !== -1) {
                    this.form.getFieldDecorator(key)
                    let obj = {}
                    if(fieldDates.indexOf(key)!==-1)
                    {
                        if(heartBShzlxq[key]!=='') {
                            obj[key] = moment(heartBShzlxq[key])
                        }
                        else
                        {
                            obj[key] =''
                        }
                    } else {
                        obj[key] = heartBShzlxq[key]
                    }
                    this.form.setFieldsValue(obj)
                }
            })
                this.heartBShzlxq.id = heartBShzlxq.id
            },
            handleSubmit () {
                this.form.validateFields((err, values) => {
                    if (!err) {
                    let heartBShzlxq = this.form.getFieldsValue()
                        heartBShzlxq.id = this.heartBShzlxq.id
                    this.$put('heartBShzlxq', {
                        ...heartBShzlxq
                    }).then(() => {
                        this.reset()
                        this.$emit('success')
                    }).catch(() => {
                        this.loading = false
                    })
                }
            })
            }
        }
    }
</script>
