<template>
    <a-drawer
            title="新增"
            :maskClosable="false"
            width=650
            placement="right"
            :closable="false"
            @close="onClose"
            :visible="addVisiable"
            style="height: calc(100% - 55px);overflow: auto;padding-bottom: 53px;">
        <a-form :form="form">
                <a-form-item v-bind="formItemLayout"
                    label="主键自增">
                        <a-input placeholder="请输入主键自增" v-decorator="['id', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="用户帐号">
                        <a-input placeholder="请输入用户帐号" v-decorator="['username', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="病案号">
                        <a-input placeholder="请输入病案号" v-decorator="['fileNo', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="姓名">
                        <a-input placeholder="请输入姓名" v-decorator="['name', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="累计辅助通气时间">
                        <a-input placeholder="请输入累计辅助通气时间" v-decorator="['shLjfztqsj', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="再次气管插管">
                        <a-input placeholder="请输入再次气管插管" v-decorator="['shZcqgcg', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="术后ICU停留时间">
                        <a-input placeholder="请输入术后ICU停留时间" v-decorator="['shShicutime', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="再次进入ICU">
                        <a-input placeholder="请输入再次进入ICU" v-decorator="['shZcicu', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="再次ICU停留时间">
                        <a-input placeholder="请输入再次ICU停留时间" v-decorator="['shZcicutime', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="术后开胸止血">
                        <a-input placeholder="请输入术后开胸止血" v-decorator="['shShkxzx', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="其他再次手术原因">
                        <a-input placeholder="请输入其他再次手术原因" v-decorator="['shQtzcssyy', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="术后并发症">
                        <a-input placeholder="请输入术后并发症" v-decorator="['shShbfz', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="备注">
                        <a-input placeholder="请输入备注" v-decorator="['shNote', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="主诉">
                        <a-input placeholder="请输入主诉" v-decorator="['shsfZs', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="生存状态">
                        <a-input placeholder="请输入生存状态" v-decorator="['shsfSczt', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="死亡原因">
                        <a-input placeholder="请输入死亡原因" v-decorator="['shsfDeath', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="死亡日期">
                        <a-date-picker v-decorator="[ 'shsfDeathDate', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="心血管再次干预">
                        <a-input placeholder="请输入心血管再次干预" v-decorator="['shsfXxgzcgy', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="再次干预时间">
                        <a-date-picker v-decorator="[ 'shsfZcgysj', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="新发疾病">
                        <a-input placeholder="请输入新发疾病" v-decorator="['shsfXfjb', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="新发疾病时间">
                        <a-date-picker v-decorator="[ 'shsfXfjbsj', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="其他并发症">
                        <a-input placeholder="请输入其他并发症" v-decorator="['shsfQtbfz', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="是否删除">
                        <a-input placeholder="请输入是否删除" v-decorator="['isDeletemark', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="创建时间">
                        <a-date-picker showTime format='YYYY-MM-DD HH:mm:ss' v-decorator="[ 'createTime', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="修改时间">
                        <a-date-picker showTime format='YYYY-MM-DD HH:mm:ss' v-decorator="[ 'modifyTime', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="创建人">
                        <a-input placeholder="请输入创建人" v-decorator="['createUserId', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
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
    const formItemLayout = {
        labelCol: { span: 3 },
        wrapperCol: { span: 18 }
    }
    export default {
        name: 'HeartBSurgicalafterAdd',
        props: {
            addVisiable: {
                default: false
            }
        },
        data () {
            return {
                loading: false,
                formItemLayout,
                form: this.$form.createForm(this),
                heartBSurgicalafter: {}
            }
        },
        methods: {
            reset () {
                this.loading = false
                this.heartBSurgicalafter = {}
                this.form.resetFields()
            },
            onClose () {
                this.reset()
                this.$emit('close')
            },
            handleSubmit () {
                this.form.validateFields((err, values) => {
                    if (!err) {
                    this.setFields()
                    this.$post('heartBSurgicalafter', {
                        ...this.heartBSurgicalafter
                    }).then(() => {
                        this.reset()
                        this.$emit('success')
                    }).catch(() => {
                        this.loading = false
                    })
                }
            })
            },
            setFields () {
                let values = this.form.getFieldsValue([  'id'     ,  'username'     ,  'fileNo'     ,  'name'     ,  'shLjfztqsj'     ,  'shZcqgcg'     ,  'shShicutime'     ,  'shZcicu'     ,  'shZcicutime'     ,  'shShkxzx'     ,  'shQtzcssyy'     ,  'shShbfz'     ,  'shNote'     ,  'shsfZs'     ,  'shsfSczt'     ,  'shsfDeath'     ,  'shsfDeathDate'     ,  'shsfXxgzcgy'     ,  'shsfZcgysj'     ,  'shsfXfjb'     ,  'shsfXfjbsj'     ,  'shsfQtbfz'     ,  'isDeletemark'     ,  'createTime'     ,  'modifyTime'     ,  'createUserId'     ,  'modifyUserId'   ])
                if (typeof values !== 'undefined') {
                    Object.keys(values).forEach(_key => { this.heartBSurgicalafter[_key] = values[_key] })
                }
            }
        }
    }
</script>
