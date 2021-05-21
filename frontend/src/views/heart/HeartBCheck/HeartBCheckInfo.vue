<template>
    <div>
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
                             label="肌红蛋白">
                        <a-input placeholder="请输入肌红蛋白" v-decorator="['jhdb', {rules:[{max:100,message:'最长不超过100'}]}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                             label="肌钙蛋白">
                        <a-input placeholder="请输入肌钙蛋白" v-decorator="['jgdb', {rules:[{max:100,message:'最长不超过100'}]}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                             label="CK-MB">
                        <a-input placeholder="请输入CK-MB" v-decorator="['ckmb', {rules:[{max:100,message:'最长不超过100'}]}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                             label="超敏肌钙蛋白（optional）">
                        <a-input placeholder="请输入超敏肌钙蛋白（optional）" v-decorator="['cmjgdb', {rules:[{max:100,message:'最长不超过100'}]}]" />
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
    </div>
</template>

<script>
    export default {
        data () {
            return {
                loading: false,
                form: this.$form.createForm(this),
                csfcInfo:{

                },
                baseId: ''
            }
        },
        mounted () {
            // this.fetch()
        },
        components: {} ,
        methods: {
            reset () {
                this.loading = false
                this.csfcInfo = {}
                this.form.resetFields()
                this.baseId = ''
            },
            setFields () {
                let values = this.form.getFieldsValue([                        'jhdb'    ,                         'jgdb'    ,                         'ckmb'    ,                         'cmjgdb'                   ])
                if (typeof values !== 'undefined') {
                    Object.keys(values).forEach(_key => {
                        if (values[_key] !== undefined) {
                        this.csfcInfo[_key] = values[_key]
                    }

                })
                }
                this.csfcInfo.id= this.baseId
                return this.csfcInfo
            },
            fetch () {
                this.$get('comFile/getUid?time='+ new Date().getTime()).then(res => {
                    this.baseId =res.data.data
                })
                console.log('CsfcInfo Id 创建成功.')
            }
        }
    }
</script>

<style>
</style>