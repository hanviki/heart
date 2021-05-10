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
                        label="CT图片名称">
                        <a-input placeholder="请输入CT图片名称" v-decorator="['fileNamect', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="CT图片地址">
                        <a-input placeholder="请输入CT图片地址" v-decorator="['filePathct', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="主动脉窦直径">
                        <a-input placeholder="请输入主动脉窦直径" v-decorator="['ctZdmdzj', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="升主动脉直径">
                        <a-input placeholder="请输入升主动脉直径" v-decorator="['ctSzdmzj', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="主动脉弓直径">
                        <a-input placeholder="请输入主动脉弓直径" v-decorator="['ctZdmgzj', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="胸上主动脉直径">
                        <a-input placeholder="请输入胸上主动脉直径" v-decorator="['ctXszdmzj', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="胸中主动脉直径">
                        <a-input placeholder="请输入胸中主动脉直径" v-decorator="['ctXzzdmzj', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="胸下主动脉直径">
                        <a-input placeholder="请输入胸下主动脉直径" v-decorator="['ctXxzdmzj', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="腹主动脉上段直径">
                        <a-input placeholder="请输入腹主动脉上段直径" v-decorator="['ctFzdmsdzj', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="腹主动脉下段直径">
                        <a-input placeholder="请输入腹主动脉下段直径" v-decorator="['ctFzdmxdzj', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="升主动脉假腔直径">
                        <a-input placeholder="请输入升主动脉假腔直径" v-decorator="['ctSzdmjqzj', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="主动脉弓假腔直径">
                        <a-input placeholder="请输入主动脉弓假腔直径" v-decorator="['ctZdmgjqzj', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="胸上假腔直径">
                        <a-input placeholder="请输入胸上假腔直径" v-decorator="['ctXsjqzj', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="胸中假腔直径">
                        <a-input placeholder="请输入胸中假腔直径" v-decorator="['ctXzjqzj', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="胸下假腔直径">
                        <a-input placeholder="请输入胸下假腔直径" v-decorator="['ctXxjqzj', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="腹上假腔直径">
                        <a-input placeholder="请输入腹上假腔直径" v-decorator="['ctFsjqzj', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="腹下假腔直径">
                        <a-input placeholder="请输入腹下假腔直径" v-decorator="['ctFxjqzj', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="主动脉夹层阜外分型">
                        <a-input placeholder="请输入主动脉夹层阜外分型" v-decorator="['ctZdmjcfwfx', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="升主夹层病理">
                        <a-input placeholder="请输入升主夹层病理" v-decorator="['ctSzjcbl', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="主动脉弓假腔位置">
                        <a-input placeholder="请输入主动脉弓假腔位置" v-decorator="['ctZdmgjqwz', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="主动脉胸段病理">
                        <a-input placeholder="请输入主动脉胸段病理" v-decorator="['ctZdxdbl', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="主动脉胸段假腔位置">
                        <a-input placeholder="请输入主动脉胸段假腔位置" v-decorator="['ctZdxdjqwz', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="腹主动脉上段病理">
                        <a-input placeholder="请输入腹主动脉上段病理" v-decorator="['ctFzdmsdbl', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="腹主动脉假腔位置">
                        <a-input placeholder="请输入腹主动脉假腔位置" v-decorator="['ctFzdmjqwz', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="肾动脉下夹层病理">
                        <a-input placeholder="请输入肾动脉下夹层病理" v-decorator="['ctSdmxjcbl', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="肾下假腔位置">
                        <a-input placeholder="请输入肾下假腔位置" v-decorator="['ctSxjqwz', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="原发破口位置">
                        <a-input placeholder="请输入原发破口位置" v-decorator="['ctYfpkwz', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="原发破口大小">
                        <a-input placeholder="请输入原发破口大小" v-decorator="['ctYfpkdx', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="缺血或重度受压分支血管">
                        <a-input placeholder="请输入缺血或重度受压分支血管" v-decorator="['ctQxhzdsyfzxg', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="完全缺血器官">
                        <a-input placeholder="请输入完全缺血器官" v-decorator="['ctWqqxqg', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="夹层累及范围">
                        <a-input placeholder="请输入夹层累及范围" v-decorator="['ctJcljfw', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="主动脉夹层特殊征象">
                        <a-input placeholder="请输入主动脉夹层特殊征象" v-decorator="['ctZdmjctszx', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="假腔供血器官">
                        <a-input placeholder="请输入假腔供血器官" v-decorator="['ctJqgxqg', {}]" />
                </a-form-item>
                <a-form-item
                        v-bind="formItemLayout"
                        label="备注">
                        <a-input placeholder="请输入备注" v-decorator="['ctNote', {}]" />
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
        name: 'HeartBCtEdit',
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
            heartBCt: {}
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
            setFormValues ({...heartBCt}) {
                let fields = [  'id'     ,  'username'     ,  'fileNo'     ,  'name'     ,  'fileNamect'     ,  'filePathct'     ,  'ctZdmdzj'     ,  'ctSzdmzj'     ,  'ctZdmgzj'     ,  'ctXszdmzj'     ,  'ctXzzdmzj'     ,  'ctXxzdmzj'     ,  'ctFzdmsdzj'     ,  'ctFzdmxdzj'     ,  'ctSzdmjqzj'     ,  'ctZdmgjqzj'     ,  'ctXsjqzj'     ,  'ctXzjqzj'     ,  'ctXxjqzj'     ,  'ctFsjqzj'     ,  'ctFxjqzj'     ,  'ctZdmjcfwfx'     ,  'ctSzjcbl'     ,  'ctZdmgjqwz'     ,  'ctZdxdbl'     ,  'ctZdxdjqwz'     ,  'ctFzdmsdbl'     ,  'ctFzdmjqwz'     ,  'ctSdmxjcbl'     ,  'ctSxjqwz'     ,  'ctYfpkwz'     ,  'ctYfpkdx'     ,  'ctQxhzdsyfzxg'     ,  'ctWqqxqg'     ,  'ctJcljfw'     ,  'ctZdmjctszx'     ,  'ctJqgxqg'     ,  'ctNote'     ,  'isDeletemark'     ,  'createTime'     ,  'modifyTime'     ,  'createUserId'     ,  'modifyUserId'   ]
                let fieldDates = [                                                                                                                        'createTime'         , 'modifyTime'           ]
                Object.keys(heartBCt).forEach((key) => {
                    if (fields.indexOf(key) !== -1) {
                    this.form.getFieldDecorator(key)
                    let obj = {}
                    if(fieldDates.indexOf(key)!==-1)
                    {
                        if(heartBCt[key]!=='') {
                            obj[key] = moment(heartBCt[key])
                        }
                        else
                        {
                            obj[key] =''
                        }
                    } else {
                        obj[key] = heartBCt[key]
                    }
                    this.form.setFieldsValue(obj)
                }
            })
                this.heartBCt.id = heartBCt.id
            },
            handleSubmit () {
                this.form.validateFields((err, values) => {
                    if (!err) {
                    let heartBCt = this.form.getFieldsValue()
                        heartBCt.id = this.heartBCt.id
                    this.$put('heartBCt', {
                        ...heartBCt
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
