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
                        label="备注">
                        <a-input placeholder="请输入备注" v-decorator="['ssNote', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="手术日期和时间">
                        <a-date-picker showTime format='YYYY-MM-DD HH:mm:ss' v-decorator="[ 'ssDate', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="手术结束日期和时间">
                        <a-date-picker showTime format='YYYY-MM-DD HH:mm:ss' v-decorator="[ 'ssDateend', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="手术医生姓名">
                        <a-input placeholder="请输入手术医生姓名" v-decorator="['ssDoctor', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="主动脉手术方式">
                        <a-input placeholder="请输入主动脉手术方式" v-decorator="['ssZdmssfs', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="合并手术">
                        <a-input placeholder="请输入合并手术" v-decorator="['ssHbss', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="主动脉窦成形">
                        <a-input placeholder="请输入主动脉窦成形" v-decorator="['ssZdmdcx', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="主动脉瓣成形">
                        <a-input placeholder="请输入主动脉瓣成形" v-decorator="['ssZdmbcx', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="术中失血量">
                        <a-input placeholder="请输入术中失血量" v-decorator="['ssSzsxl', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="红细胞输入量">
                        <a-input placeholder="请输入红细胞输入量" v-decorator="['ssHxbsrl', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="血浆输入量">
                        <a-input placeholder="请输入血浆输入量" v-decorator="['ssXjsrl', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="血小板输入量">
                        <a-input placeholder="请输入血小板输入量" v-decorator="['ssXxbsrl', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="CBP时间">
                        <a-input placeholder="请输入CBP时间" v-decorator="['ssCbptime', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="主动脉阻断时间">
                        <a-input placeholder="请输入主动脉阻断时间" v-decorator="['ssZdmzdsj', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="最低鼻咽温度">
                        <a-input placeholder="请输入最低鼻咽温度" v-decorator="['ssZdbywd', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="深低温停循环时间">
                        <a-input placeholder="请输入深低温停循环时间" v-decorator="['ssSdwtxhsj', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="最低直肠温">
                        <a-input placeholder="请输入最低直肠温" v-decorator="['ssZdzcw', {}]" />
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
        name: 'HeartBSurgicalEdit',
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
            heartBSurgical: {}
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
            setFormValues ({...heartBSurgical}) {
                let fields = [  'id'     ,  'username'     ,  'fileNo'     ,  'name'     ,  'ssNote'     ,  'ssDate'     ,  'ssDateend'     ,  'ssDoctor'     ,  'ssZdmssfs'     ,  'ssHbss'     ,  'ssZdmdcx'     ,  'ssZdmbcx'     ,  'ssSzsxl'     ,  'ssHxbsrl'     ,  'ssXjsrl'     ,  'ssXxbsrl'     ,  'ssCbptime'     ,  'ssZdmzdsj'     ,  'ssZdbywd'     ,  'ssSdwtxhsj'     ,  'ssZdzcw'     ,  'isDeletemark'     ,  'createTime'     ,  'modifyTime'     ,  'createUserId'     ,  'modifyUserId'   ]
                let fieldDates = [                  'ssDate'         , 'ssDateend'                                                      , 'createTime'         , 'modifyTime'           ]
                Object.keys(heartBSurgical).forEach((key) => {
                    if (fields.indexOf(key) !== -1) {
                    this.form.getFieldDecorator(key)
                    let obj = {}
                    if(fieldDates.indexOf(key)!==-1)
                    {
                        if(heartBSurgical[key]!=='') {
                            obj[key] = moment(heartBSurgical[key])
                        }
                        else
                        {
                            obj[key] =''
                        }
                    } else {
                        obj[key] = heartBSurgical[key]
                    }
                    this.form.setFieldsValue(obj)
                }
            })
                this.heartBSurgical.id = heartBSurgical.id
            },
            handleSubmit () {
                this.form.validateFields((err, values) => {
                    if (!err) {
                    let heartBSurgical = this.form.getFieldsValue()
                        heartBSurgical.id = this.heartBSurgical.id
                    this.$put('heartBSurgical', {
                        ...heartBSurgical
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
