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
                        label="年龄">
                        <a-input placeholder="请输入年龄" v-decorator="['age', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="性别">
                        <a-input placeholder="请输入性别" v-decorator="['gender', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="身高">
                        <a-input placeholder="请输入身高" v-decorator="['height', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="体重">
                        <a-input placeholder="请输入体重" v-decorator="['weight', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="省">
                        <a-input placeholder="请输入省" v-decorator="['province', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="市">
                        <a-input placeholder="请输入市" v-decorator="['city', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="区">
                        <a-input placeholder="请输入区" v-decorator="['area', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="详细地址">
                        <a-input placeholder="请输入详细地址" v-decorator="['address', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="联系方式">
                        <a-input placeholder="请输入联系方式" v-decorator="['telphone', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="入诊日期和时间">
                        <a-date-picker showTime format='YYYY-MM-DD HH:mm:ss' v-decorator="[ 'inCheck', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="发病-就诊时间">
                        <a-input placeholder="请输入发病-就诊时间" v-decorator="['toCheck', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="疼痛部位">
                        <a-input placeholder="请输入疼痛部位" v-decorator="['painPos', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="症状和体征">
                        <a-input placeholder="请输入症状和体征" v-decorator="['symptoms', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="症状和体征">
                        <a-input placeholder="请输入症状和体征" v-decorator="['otherSymptoms', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="急诊转归">
                        <a-input placeholder="请输入急诊转归" v-decorator="['emergency', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="死亡原因">
                        <a-input placeholder="请输入死亡原因" v-decorator="['deathCause', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="死亡时间">
                        <a-date-picker v-decorator="[ 'deathDate', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="急诊转归备注">
                        <a-input placeholder="请输入急诊转归备注" v-decorator="['emergencyNote', {}]" />
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
        name: 'HeartBPatientinfoEdit',
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
            heartBPatientinfo: {}
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
            setFormValues ({...heartBPatientinfo}) {
                let fields = [  'id'     ,  'username'     ,  'fileNo'     ,  'name'     ,  'age'     ,  'gender'     ,  'height'     ,  'weight'     ,  'province'     ,  'city'     ,  'area'     ,  'address'     ,  'telphone'     ,  'inCheck'     ,  'toCheck'     ,  'painPos'     ,  'symptoms'     ,  'otherSymptoms'     ,  'emergency'     ,  'deathCause'     ,  'deathDate'     ,  'emergencyNote'     ,  'isDeletemark'     ,  'createTime'     ,  'modifyTime'     ,  'createUserId'     ,  'modifyUserId'   ]
                let fieldDates = [                                          'inCheck'                           , 'deathDate'               , 'createTime'         , 'modifyTime'           ]
                Object.keys(heartBPatientinfo).forEach((key) => {
                    if (fields.indexOf(key) !== -1) {
                    this.form.getFieldDecorator(key)
                    let obj = {}
                    if(fieldDates.indexOf(key)!==-1)
                    {
                        if(heartBPatientinfo[key]!=='') {
                            obj[key] = moment(heartBPatientinfo[key])
                        }
                        else
                        {
                            obj[key] =''
                        }
                    } else {
                        obj[key] = heartBPatientinfo[key]
                    }
                    this.form.setFieldsValue(obj)
                }
            })
                this.heartBPatientinfo.id = heartBPatientinfo.id
            },
            handleSubmit () {
                this.form.validateFields((err, values) => {
                    if (!err) {
                    let heartBPatientinfo = this.form.getFieldsValue()
                        heartBPatientinfo.id = this.heartBPatientinfo.id
                    this.$put('heartBPatientinfo', {
                        ...heartBPatientinfo
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
