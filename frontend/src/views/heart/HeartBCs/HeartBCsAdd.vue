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
                        <a-input placeholder="请输入主键自增" v-decorator="['id', {rules:[{max:100,message:'最长不超过100'}]}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="用户帐号">
                        <a-input placeholder="请输入用户帐号" v-decorator="['username', {rules:[{max:100,message:'最长不超过100'}]}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="病案号">
                        <a-input placeholder="请输入病案号" v-decorator="['fileNo', {rules:[{max:100,message:'最长不超过100'}]}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="姓名">
                        <a-input placeholder="请输入姓名" v-decorator="['name', {rules:[{max:100,message:'最长不超过100'}]}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="图片名称">
                        <a-input placeholder="请输入图片名称" v-decorator="['fileName', {rules:[{max:100,message:'最长不超过100'}]}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="图片地址">
                        <a-input placeholder="请输入图片地址" v-decorator="['filePath', {rules:[{max:100,message:'最长不超过100'}]}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="AVR">
                        <a-input placeholder="请输入AVR" v-decorator="['avr', {rules:[{max:100,message:'最长不超过100'}]}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="MVR">
                        <a-input placeholder="请输入MVR" v-decorator="['mvr', {rules:[{max:100,message:'最长不超过100'}]}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="室壁运动异常位置">
                        <a-input placeholder="请输入室壁运动异常位置" v-decorator="['sbydycwz', {rules:[{max:100,message:'最长不超过100'}]}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="心包积液">
                        <a-input placeholder="请输入心包积液" v-decorator="['xbjy', {rules:[{max:100,message:'最长不超过100'}]}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="EF">
                        <a-input placeholder="请输入EF" v-decorator="['ef', {rules:[{max:100,message:'最长不超过100'}]}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="左室舒张末内径">
                        <a-input placeholder="请输入左室舒张末内径" v-decorator="['zsszwnj', {rules:[{max:100,message:'最长不超过100'}]}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="主动脉闭环直径">
                        <a-input placeholder="请输入主动脉闭环直径" v-decorator="['zdmbhzj', {rules:[{max:100,message:'最长不超过100'}]}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="主动脉窦直径">
                        <a-input placeholder="请输入主动脉窦直径" v-decorator="['zdmdzj', {rules:[{max:100,message:'最长不超过100'}]}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="升主动脉直径">
                        <a-input placeholder="请输入升主动脉直径" v-decorator="['szdmzj', {rules:[{max:100,message:'最长不超过100'}]}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="是否删除">
                        <a-input placeholder="请输入是否删除" v-decorator="['isDeletemark', {rules:[{max:100,message:'最长不超过100'}]}]" />
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
                        <a-input placeholder="请输入创建人" v-decorator="['createUserId', {rules:[{max:100,message:'最长不超过100'}]}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="修改人">
                        <a-input placeholder="请输入修改人" v-decorator="['modifyUserId', {rules:[{max:100,message:'最长不超过100'}]}]" />
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
        name: 'HeartBCsAdd',
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
                heartBCs: {}
            }
        },
        methods: {
            reset () {
                this.loading = false
                this.heartBCs = {}
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
                    this.$post('heartBCs', {
                        ...this.heartBCs
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
                let values = this.form.getFieldsValue([  'id'     ,  'username'     ,  'fileNo'     ,  'name'     ,  'fileName'     ,  'filePath'     ,  'avr'     ,  'mvr'     ,  'sbydycwz'     ,  'xbjy'     ,  'ef'     ,  'zsszwnj'     ,  'zdmbhzj'     ,  'zdmdzj'     ,  'szdmzj'     ,  'isDeletemark'     ,  'createTime'     ,  'modifyTime'     ,  'createUserId'     ,  'modifyUserId'   ])
                if (typeof values !== 'undefined') {
                    Object.keys(values).forEach(_key => { this.heartBCs[_key] = values[_key] })
                }
            }
        }
    }
</script>
