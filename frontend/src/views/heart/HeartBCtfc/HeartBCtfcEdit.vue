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
                        label="图片名">
                        <a-input placeholder="请输入图片名" v-decorator="['fileName', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="图片地址">
                        <a-input placeholder="请输入图片地址" v-decorator="['fileUrl', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="CT复查时间">
                        <a-date-picker v-decorator="[ 'ctDate', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="支架末端位置(胸椎序号)">
                        <a-input placeholder="请输入支架末端位置(胸椎序号)" v-decorator="['zjwdwzCode', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="窦直径">
                        <a-input placeholder="请输入窦直径" v-decorator="['dzj', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="升主脉动直径">
                        <a-input placeholder="请输入升主脉动直径" v-decorator="['szmdzj', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="主动脉弓直径">
                        <a-input placeholder="请输入主动脉弓直径" v-decorator="['zdmgzj', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="胸主动脉上段直径">
                        <a-input placeholder="请输入胸主动脉上段直径" v-decorator="['xzdmsdzj', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="胸主动脉上段假腔/血肿直径">
                        <a-input placeholder="请输入胸主动脉上段假腔/血肿直径" v-decorator="['xzdmsdjqxzzj', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="胸主动脉中段直径">
                        <a-input placeholder="请输入胸主动脉中段直径" v-decorator="['xzdmzdzj', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="胸主动脉中段假腔/血肿直径">
                        <a-input placeholder="请输入胸主动脉中段假腔/血肿直径" v-decorator="['xzdmzdjqzj', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="胸主动脉下段直径">
                        <a-input placeholder="请输入胸主动脉下段直径" v-decorator="['xzdmxdzj', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="胸主动脉下段假腔/血肿直径">
                        <a-input placeholder="请输入胸主动脉下段假腔/血肿直径" v-decorator="['xzdmxdjqzj', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="腹主动脉上段直径">
                        <a-input placeholder="请输入腹主动脉上段直径" v-decorator="['fzdmsdzj', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="腹主动脉上段假腔/血肿直径">
                        <a-input placeholder="请输入腹主动脉上段假腔/血肿直径" v-decorator="['fzdmsdjqzj', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="腹主动脉下段直径">
                        <a-input placeholder="请输入腹主动脉下段直径" v-decorator="['fzdmxdzj', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="腹主动脉下段假腔/血肿直径">
                        <a-input placeholder="请输入腹主动脉下段假腔/血肿直径" v-decorator="['fzdmxdjqzj', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="近端吻合口漏">
                        <a-input placeholder="请输入近端吻合口漏" v-decorator="['jdwhkl', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="远端吻合口漏">
                        <a-input placeholder="请输入远端吻合口漏" v-decorator="['ydwhkl', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="升主周围血肿">
                        <a-input placeholder="请输入升主周围血肿" v-decorator="['szzwxz', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="弓部血肿">
                        <a-input placeholder="请输入弓部血肿" v-decorator="['gbxz', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="假腔转归">
                        <a-input placeholder="请输入假腔转归" v-decorator="['jqzg', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="腹腔干转归">
                        <a-input placeholder="请输入腹腔干转归" v-decorator="['fqqzg', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="左肾脉动转归">
                        <a-input placeholder="请输入左肾脉动转归" v-decorator="['zsmdzg', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="右肾脉动转归">
                        <a-input placeholder="请输入右肾脉动转归" v-decorator="['ysmdzg', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="左髂总转归">
                        <a-input placeholder="请输入左髂总转归" v-decorator="['zkzzg', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="右髂总转归">
                        <a-input placeholder="请输入右髂总转归" v-decorator="['ykzzg', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="人工血管异常说明">
                        <a-input placeholder="请输入人工血管异常说明" v-decorator="['rgxgycsm', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="动脉瘤样扩张">
                        <a-input placeholder="请输入动脉瘤样扩张" v-decorator="['dmlykz', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="支架异常说明">
                        <a-input placeholder="请输入支架异常说明" v-decorator="['zjycsm', {}]" />
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
        name: 'HeartBCtfcEdit',
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
            heartBCtfc: {}
        }
        },
        methods: {
            reset () {
                this.loading = false
                this.heartBCtfc = []
                this.form.resetFields()
            },
            onClose () {
                this.reset()
                this.$emit('close')
            },
            setFormValues ({...heartBCtfc}) {
                let fields = [  'id'     ,  'username'     ,  'fileNo'     ,  'name'     ,  'fileName'     ,  'fileUrl'     ,  'ctDate'     ,  'zjwdwzCode'     ,  'dzj'     ,  'szmdzj'     ,  'zdmgzj'     ,  'xzdmsdzj'     ,  'xzdmsdjqxzzj'     ,  'xzdmzdzj'     ,  'xzdmzdjqzj'     ,  'xzdmxdzj'     ,  'xzdmxdjqzj'     ,  'fzdmsdzj'     ,  'fzdmsdjqzj'     ,  'fzdmxdzj'     ,  'fzdmxdjqzj'     ,  'jdwhkl'     ,  'ydwhkl'     ,  'szzwxz'     ,  'gbxz'     ,  'jqzg'     ,  'fqqzg'     ,  'zsmdzg'     ,  'ysmdzg'     ,  'zkzzg'     ,  'ykzzg'     ,  'rgxgycsm'     ,  'dmlykz'     ,  'zjycsm'     ,  'isDeletemark'     ,  'createTime'     ,  'modifyTime'     ,  'createUserId'     ,  'modifyUserId'   ]
                let fieldDates = [                     'ctDate'                                                                                             , 'createTime'         , 'modifyTime'           ]
                Object.keys(heartBCtfc).forEach((key) => {
                    if (fields.indexOf(key) !== -1) {
                    this.form.getFieldDecorator(key)
                    let obj = {}
                    if(fieldDates.indexOf(key)!==-1)
                    {
                        if(heartBCtfc[key]!=='') {
                            obj[key] = moment(heartBCtfc[key])
                        }
                        else
                        {
                            obj[key] =''
                        }
                    } else {
                        obj[key] = heartBCtfc[key]
                    }
                    this.form.setFieldsValue(obj)
                }
            })
                this.heartBCtfc.id = heartBCtfc.id
            },
            handleSubmit () {
                this.form.validateFields((err, values) => {
                    if (!err) {
                    let heartBCtfc = this.form.getFieldsValue()
                        heartBCtfc.id = this.heartBCtfc.id
                    this.$put('heartBCtfc', {
                        ...heartBCtfc
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
