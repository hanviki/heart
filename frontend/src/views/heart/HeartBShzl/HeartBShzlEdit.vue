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
                        label="手术时间">
                        <a-date-picker v-decorator="[ 'ssDate', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="术后入住ICU总天数">
                        <a-input placeholder="请输入术后入住ICU总天数" v-decorator="['icuDay', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="再次入住ICU">
                        <a-input placeholder="请输入再次入住ICU" v-decorator="['icuAgain', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="意识状态">
                        <a-input placeholder="请输入意识状态" v-decorator="['yszt', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="意识状态备注">
                        <a-input placeholder="请输入意识状态备注" v-decorator="['ysztNote', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="有创机械通气时长">
                        <a-input placeholder="请输入有创机械通气时长" v-decorator="['ycjxsc', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="无创辅助时间">
                        <a-input placeholder="请输入无创辅助时间" v-decorator="['wcfzsjDay', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="无创辅助时间">
                        <a-input placeholder="请输入无创辅助时间" v-decorator="['wcfzsjHour', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="无创辅助时间备注">
                        <a-input placeholder="请输入无创辅助时间备注" v-decorator="['wcfzsjNote', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="疼痛评分CPOT/NRS">
                        <a-input placeholder="请输入疼痛评分CPOT/NRS" v-decorator="['painScore', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="RASS评分">
                        <a-input placeholder="请输入RASS评分" v-decorator="['rass', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="GCS评分">
                        <a-input placeholder="请输入GCS评分" v-decorator="['gcs', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="Braden评分">
                        <a-input placeholder="请输入Braden评分" v-decorator="['braden', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="人工有创气道置管时间">
                        <a-input placeholder="请输入人工有创气道置管时间" v-decorator="['rgcqdzHour', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="插管部位">
                        <a-input placeholder="请输入插管部位" v-decorator="['cgbw', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="CVC留置时间">
                        <a-input placeholder="请输入CVC留置时间" v-decorator="['cvc', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="留置部位">
                        <a-input placeholder="请输入留置部位" v-decorator="['lzbw', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="血透">
                        <a-input placeholder="请输入血透" v-decorator="['xuetou', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="IABP置管时间">
                        <a-input placeholder="请输入IABP置管时间" v-decorator="['iabp', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="营养评估（NRS2002）">
                        <a-input placeholder="请输入营养评估（NRS2002）" v-decorator="['nrs', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="肠内营养">
                        <a-input placeholder="请输入肠内营养" v-decorator="['cnyy', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="肠外营养">
                        <a-input placeholder="请输入肠外营养" v-decorator="['cwyy', {}]" />
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
        name: 'HeartBShzlEdit',
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
            heartBShzl: {}
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
            setFormValues ({...heartBShzl}) {
                let fields = [  'id'     ,  'username'     ,  'fileNo'     ,  'name'     ,  'ssDate'     ,  'icuDay'     ,  'icuAgain'     ,  'yszt'     ,  'ysztNote'     ,  'ycjxsc'     ,  'wcfzsjDay'     ,  'wcfzsjHour'     ,  'wcfzsjNote'     ,  'painScore'     ,  'rass'     ,  'gcs'     ,  'braden'     ,  'rgcqdzHour'     ,  'cgbw'     ,  'cvc'     ,  'lzbw'     ,  'xuetou'     ,  'iabp'     ,  'nrs'     ,  'cnyy'     ,  'cwyy'     ,  'isDeletemark'     ,  'createTime'     ,  'modifyTime'     ,  'createUserId'     ,  'modifyUserId'   ]
                let fieldDates = [               'ssDate'                                                                           , 'createTime'         , 'modifyTime'           ]
                Object.keys(heartBShzl).forEach((key) => {
                    if (fields.indexOf(key) !== -1) {
                    this.form.getFieldDecorator(key)
                    let obj = {}
                    if(fieldDates.indexOf(key)!==-1)
                    {
                        if(heartBShzl[key]!=='') {
                            obj[key] = moment(heartBShzl[key])
                        }
                        else
                        {
                            obj[key] =''
                        }
                    } else {
                        obj[key] = heartBShzl[key]
                    }
                    this.form.setFieldsValue(obj)
                }
            })
                this.heartBShzl.id = heartBShzl.id
            },
            handleSubmit () {
                this.form.validateFields((err, values) => {
                    if (!err) {
                    let heartBShzl = this.form.getFieldsValue()
                        heartBShzl.id = this.heartBShzl.id
                    this.$put('heartBShzl', {
                        ...heartBShzl
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
