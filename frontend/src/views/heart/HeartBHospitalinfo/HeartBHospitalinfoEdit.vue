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
                        label="主诉">
                        <a-input placeholder="请输入主诉" v-decorator="['zhusu', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="入院日期">
                        <a-date-picker showTime format='YYYY-MM-DD HH:mm:ss' v-decorator="[ 'inHospital', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="出院日期">
                        <a-date-picker showTime format='YYYY-MM-DD HH:mm:ss' v-decorator="[ 'outHospital', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="住院转归">
                        <a-input placeholder="请输入住院转归" v-decorator="['inRedirect', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="死亡原因">
                        <a-input placeholder="请输入死亡原因" v-decorator="['deathInfo', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="死亡日期">
                        <a-date-picker showTime format='YYYY-MM-DD HH:mm:ss' v-decorator="[ 'swsj', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="住院转归备注">
                        <a-input placeholder="请输入住院转归备注" v-decorator="['inRedirectnote', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="夹层诊断（阜外分型）">
                        <a-input placeholder="请输入夹层诊断（阜外分型）" v-decorator="['jczd', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="高血压">
                        <a-input placeholder="请输入高血压" v-decorator="['gxy', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="NYHA分级">
                        <a-input placeholder="请输入NYHA分级" v-decorator="['nyha', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="糖尿病">
                        <a-input placeholder="请输入糖尿病" v-decorator="['tnb', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="马凡综合征">
                        <a-input placeholder="请输入马凡综合征" v-decorator="['mfzhz', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="其他">
                        <a-input placeholder="请输入其他" v-decorator="['other', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="主动脉瓣手术">
                        <a-input placeholder="请输入主动脉瓣手术" v-decorator="['zdmbss', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="全弓置换">
                        <a-input placeholder="请输入全弓置换" v-decorator="['qgzh', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="其他主动干预">
                        <a-input placeholder="请输入其他主动干预" v-decorator="['qtzdgy', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="上次主动干预时间">
                        <a-date-picker showTime format='YYYY-MM-DD HH:mm:ss' v-decorator="[ 'sczdgysj', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="主动脉疾病家族史">
                        <a-input placeholder="请输入主动脉疾病家族史" v-decorator="['zdmjbjzs', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="吸烟">
                        <a-input placeholder="请输入吸烟" v-decorator="['xy', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="喝酒">
                        <a-input placeholder="请输入喝酒" v-decorator="['hj', {}]" />
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
        name: 'HeartBHospitalinfoEdit',
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
            heartBHospitalinfo: {}
        }
        },
        methods: {
            reset () {
                this.loading = false
                this.form.resetFields()
                this.heartBHospitalinfo = {}
            },
            onClose () {
                this.reset()
                this.$emit('close')
            },
            setFormValues ({...heartBHospitalinfo}) {
                let fields = [  'id'     ,  'username'     ,  'fileNo'     ,  'name'     ,  'zhusu'     ,  'inHospital'     ,  'outHospital'     ,  'inRedirect'     ,  'deathInfo'     ,  'swsj'     ,  'inRedirectnote'     ,  'jczd'     ,  'gxy'     ,  'nyha'     ,  'tnb'     ,  'mfzhz'     ,  'other'     ,  'zdmbss'     ,  'qgzh'     ,  'qtzdgy'     ,  'sczdgysj'     ,  'zdmjbjzs'     ,  'xy'     ,  'hj'     ,  'isDeletemark'     ,  'createTime'     ,  'modifyTime'     ,  'createUserId'     ,  'modifyUserId'   ]
                let fieldDates = [                  'inHospital'         , 'outHospital'               , 'swsj'                                       , 'sczdgysj'                     , 'createTime'         , 'modifyTime'           ]
                Object.keys(heartBHospitalinfo).forEach((key) => {
                    if (fields.indexOf(key) !== -1) {
                    this.form.getFieldDecorator(key)
                    let obj = {}
                    if(fieldDates.indexOf(key)!==-1)
                    {
                        if(heartBHospitalinfo[key]!=='') {
                            obj[key] = moment(heartBHospitalinfo[key])
                        }
                        else
                        {
                            obj[key] =''
                        }
                    } else {
                        obj[key] = heartBHospitalinfo[key]
                    }
                    this.form.setFieldsValue(obj)
                }
            })
                this.heartBHospitalinfo.id = heartBHospitalinfo.id
            },
            handleSubmit () {
                this.form.validateFields((err, values) => {
                    if (!err) {
                    let heartBHospitalinfo = this.form.getFieldsValue()
                        heartBHospitalinfo.id = this.heartBHospitalinfo.id
                    this.$put('heartBHospitalinfo', {
                        ...heartBHospitalinfo
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
