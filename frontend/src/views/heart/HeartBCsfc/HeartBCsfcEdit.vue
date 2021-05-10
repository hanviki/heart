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
                        label="主键">
                        <a-input placeholder="请输入主键" v-decorator="['id', {}]" />
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
                        label="文件名">
                        <a-input placeholder="请输入文件名" v-decorator="['fileName', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="文件地址">
                        <a-input placeholder="请输入文件地址" v-decorator="['fileUrl', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="AVR">
                        <a-input placeholder="请输入AVR" v-decorator="['avr', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="MVR">
                        <a-input placeholder="请输入MVR" v-decorator="['mvr', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="室壁运动异常位置(如无,则不填)">
                        <a-input placeholder="请输入室壁运动异常位置(如无,则不填)" v-decorator="['sbydycwz', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="心包积液">
                        <a-input placeholder="请输入心包积液" v-decorator="['xbjy', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="EF(%)">
                        <a-input placeholder="请输入EF(%)" v-decorator="['ef', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="左室舒张末内径(mm)">
                        <a-input placeholder="请输入左室舒张末内径(mm)" v-decorator="['zsszwnj', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="主动脉瓣环直径(mm)">
                        <a-input placeholder="请输入主动脉瓣环直径(mm)" v-decorator="['zdmbhzj', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="主动脉窦直径(mm)">
                        <a-input placeholder="请输入主动脉窦直径(mm)" v-decorator="['zdmdzj', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="主动脉窦直径(mm)">
                        <a-input placeholder="请输入主动脉窦直径(mm)" v-decorator="['sdmdzj', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="升主动脉直径(mm)">
                        <a-input placeholder="请输入升主动脉直径(mm)" v-decorator="['szdmdzj', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="超声检查时间">
                        <a-date-picker v-decorator="[ 'csjcsj', {}]" />
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
        name: 'HeartBCsfcEdit',
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
            heartBCsfc: {}
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
            setFormValues ({...heartBCsfc}) {
                let fields = [  'id'     ,  'username'     ,  'fileNo'     ,  'name'     ,  'fileName'     ,  'fileUrl'     ,  'avr'     ,  'mvr'     ,  'sbydycwz'     ,  'xbjy'     ,  'ef'     ,  'zsszwnj'     ,  'zdmbhzj'     ,  'zdmdzj'     ,  'sdmdzj'     ,  'szdmdzj'     ,  'csjcsj'     ,  'isDeletemark'     ,  'createTime'     ,  'modifyTime'     ,  'createUserId'     ,  'modifyUserId'   ]
                let fieldDates = [                                                   'csjcsj'            , 'createTime'         , 'modifyTime'           ]
                Object.keys(heartBCsfc).forEach((key) => {
                    if (fields.indexOf(key) !== -1) {
                    this.form.getFieldDecorator(key)
                    let obj = {}
                    if(fieldDates.indexOf(key)!==-1)
                    {
                        if(heartBCsfc[key]!=='') {
                            obj[key] = moment(heartBCsfc[key])
                        }
                        else
                        {
                            obj[key] =''
                        }
                    } else {
                        obj[key] = heartBCsfc[key]
                    }
                    this.form.setFieldsValue(obj)
                }
            })
                this.heartBCsfc.id = heartBCsfc.id
            },
            handleSubmit () {
                this.form.validateFields((err, values) => {
                    if (!err) {
                    let heartBCsfc = this.form.getFieldsValue()
                        heartBCsfc.id = this.heartBCsfc.id
                    this.$put('heartBCsfc', {
                        ...heartBCsfc
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
