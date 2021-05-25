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
                        label="意识状态">
                        <a-input placeholder="请输入意识状态" v-decorator="['yszt', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="皮肤黏膜">
                        <a-input placeholder="请输入皮肤黏膜" v-decorator="['pfnm', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="饮食">
                        <a-input placeholder="请输入饮食" v-decorator="['yinshi', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="排便">
                        <a-input placeholder="请输入排便" v-decorator="['paibian', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="排便备注">
                        <a-input placeholder="请输入排便备注" v-decorator="['paibianNote', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="排尿">
                        <a-input placeholder="请输入排尿" v-decorator="['painiao', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="过敏史">
                        <a-input placeholder="请输入过敏史" v-decorator="['guominshi', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="过敏史备注">
                        <a-input placeholder="请输入过敏史备注" v-decorator="['guominshiNote', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="吸烟史">
                        <a-input placeholder="请输入吸烟史" v-decorator="['xiyanshi', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="吸烟史备注">
                        <a-input placeholder="请输入吸烟史备注" v-decorator="['xiyanshiNote', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="饮酒史">
                        <a-input placeholder="请输入饮酒史" v-decorator="['yinjiushi', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="慢性病">
                        <a-input placeholder="请输入慢性病" v-decorator="['manxingbing', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="Barthel指数">
                        <a-input placeholder="请输入Barthel指数" v-decorator="['barthel', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="Braden评分">
                        <a-input placeholder="请输入Braden评分" v-decorator="['braden', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="压疮">
                        <a-input placeholder="请输入压疮" v-decorator="['yachuang', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="Caprini评分">
                        <a-input placeholder="请输入Caprini评分" v-decorator="['caprini', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="疼痛时长">
                        <a-input placeholder="请输入疼痛时长" v-decorator="['painTime', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="疼痛评分">
                        <a-input placeholder="请输入疼痛评分" v-decorator="['painScore', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="疼痛处理">
                        <a-input placeholder="请输入疼痛处理" v-decorator="['painHadle', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="疼痛处理备注">
                        <a-input placeholder="请输入疼痛处理备注" v-decorator="['painHadlenote', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="疼痛处理后再次评分">
                        <a-input placeholder="请输入疼痛处理后再次评分" v-decorator="['painScoreAgain', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="营养风险筛查评估（NRS2002）">
                        <a-input placeholder="请输入营养风险筛查评估（NRS2002）" v-decorator="['yingyangfxsc', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="营养风险筛查评估备注">
                        <a-input placeholder="请输入营养风险筛查评估备注" v-decorator="['yingyangfxscNote', {}]" />
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
        name: 'HeartBSqzlEdit',
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
            heartBSqzl: {}
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
            setFormValues ({...heartBSqzl}) {
                let fields = [  'id'     ,  'username'     ,  'fileNo'     ,  'name'     ,  'yszt'     ,  'pfnm'     ,  'yinshi'     ,  'paibian'     ,  'paibianNote'     ,  'painiao'     ,  'guominshi'     ,  'guominshiNote'     ,  'xiyanshi'     ,  'xiyanshiNote'     ,  'yinjiushi'     ,  'manxingbing'     ,  'barthel'     ,  'braden'     ,  'yachuang'     ,  'caprini'     ,  'painTime'     ,  'painScore'     ,  'painHadle'     ,  'painHadlenote'     ,  'painScoreAgain'     ,  'yingyangfxsc'     ,  'yingyangfxscNote'     ,  'isDeletemark'     ,  'createTime'     ,  'modifyTime'     ,  'createUserId'     ,  'modifyUserId'   ]
                let fieldDates = [                                                                                       'createTime'         , 'modifyTime'           ]
                Object.keys(heartBSqzl).forEach((key) => {
                    if (fields.indexOf(key) !== -1) {
                    this.form.getFieldDecorator(key)
                    let obj = {}
                    if(fieldDates.indexOf(key)!==-1)
                    {
                        if(heartBSqzl[key]!=='') {
                            obj[key] = moment(heartBSqzl[key])
                        }
                        else
                        {
                            obj[key] =''
                        }
                    } else {
                        obj[key] = heartBSqzl[key]
                    }
                    this.form.setFieldsValue(obj)
                }
            })
                this.heartBSqzl.id = heartBSqzl.id
            },
            handleSubmit () {
                this.form.validateFields((err, values) => {
                    if (!err) {
                    let heartBSqzl = this.form.getFieldsValue()
                        heartBSqzl.id = this.heartBSqzl.id
                    this.$put('heartBSqzl', {
                        ...heartBSqzl
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
