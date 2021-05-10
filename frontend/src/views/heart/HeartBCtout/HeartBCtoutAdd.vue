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
                    label="出院复查图片名称">
                        <a-input placeholder="请输入出院复查图片名称" v-decorator="['fctFileName', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="出院复查图片地址">
                        <a-input placeholder="请输入出院复查图片地址" v-decorator="['fctFilePath', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="支架末端位置(胸椎序号)">
                        <a-input placeholder="请输入支架末端位置(胸椎序号)" v-decorator="['fctZjwdwz', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="窦直径">
                        <a-input placeholder="请输入窦直径" v-decorator="['fctDzj', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="升主脉动直径">
                        <a-input placeholder="请输入升主脉动直径" v-decorator="['fctSzmdzj', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="主动脉弓直径">
                        <a-input placeholder="请输入主动脉弓直径" v-decorator="['fctZdmgzj', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="胸主动脉上段直径">
                        <a-input placeholder="请输入胸主动脉上段直径" v-decorator="['fctXzdmsdzj', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="胸主动脉上段假腔/血肿直径">
                        <a-input placeholder="请输入胸主动脉上段假腔/血肿直径" v-decorator="['fctXzdmsdjqxzzj', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="胸主动脉中段直径">
                        <a-input placeholder="请输入胸主动脉中段直径" v-decorator="['fctXzdmzdzj', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="胸主动脉中段假腔/血肿直径">
                        <a-input placeholder="请输入胸主动脉中段假腔/血肿直径" v-decorator="['fctXzdmzdjqzj', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="胸主动脉下段直径">
                        <a-input placeholder="请输入胸主动脉下段直径" v-decorator="['fctXzdmxdzj', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="胸主动脉下段假腔/血肿直径">
                        <a-input placeholder="请输入胸主动脉下段假腔/血肿直径" v-decorator="['fctXzdmxdjqzj', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="腹主动脉上段直径">
                        <a-input placeholder="请输入腹主动脉上段直径" v-decorator="['fctFzdmsdzj', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="腹主动脉上段假腔/血肿直径">
                        <a-input placeholder="请输入腹主动脉上段假腔/血肿直径" v-decorator="['fctFzdmsdjqzj', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="腹主动脉下段直径">
                        <a-input placeholder="请输入腹主动脉下段直径" v-decorator="['fctFzdmxdzj', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="腹主动脉下段假腔/血肿直径">
                        <a-input placeholder="请输入腹主动脉下段假腔/血肿直径" v-decorator="['fctFzdmxdjqzj', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="近端吻合口漏">
                        <a-input placeholder="请输入近端吻合口漏" v-decorator="['fctJdwhkl', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="远端吻合口漏">
                        <a-input placeholder="请输入远端吻合口漏" v-decorator="['fctYdwhkl', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="升主周围血肿">
                        <a-input placeholder="请输入升主周围血肿" v-decorator="['fctSzzwxz', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="弓部血肿">
                        <a-input placeholder="请输入弓部血肿" v-decorator="['fctGbxz', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="假腔转归">
                        <a-input placeholder="请输入假腔转归" v-decorator="['fctJqzg', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="腹腔干转归">
                        <a-input placeholder="请输入腹腔干转归" v-decorator="['fctFqqzg', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="左肾脉动转归">
                        <a-input placeholder="请输入左肾脉动转归" v-decorator="['fctZsmdzg', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="右肾脉动转归">
                        <a-input placeholder="请输入右肾脉动转归" v-decorator="['fctYsmdzg', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="左髂总转归">
                        <a-input placeholder="请输入左髂总转归" v-decorator="['fctZkzzg', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="右髂总转归">
                        <a-input placeholder="请输入右髂总转归" v-decorator="['fctYkzzg', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="人工血管异常说明">
                        <a-input placeholder="请输入人工血管异常说明" v-decorator="['fctRgxgycsm', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="动脉瘤样扩张">
                        <a-input placeholder="请输入动脉瘤样扩张" v-decorator="['fctDmlykz', {}]" />
                </a-form-item>
                <a-form-item v-bind="formItemLayout"
                    label="支架异常说明">
                        <a-input placeholder="请输入支架异常说明" v-decorator="['fctZjycsm', {}]" />
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
        name: 'HeartBCtoutAdd',
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
                heartBCtout: {}
            }
        },
        methods: {
            reset () {
                this.loading = false
                this.heartBCtout = {}
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
                    this.$post('heartBCtout', {
                        ...this.heartBCtout
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
                let values = this.form.getFieldsValue([  'id'     ,  'username'     ,  'fileNo'     ,  'name'     ,  'fctFileName'     ,  'fctFilePath'     ,  'fctZjwdwz'     ,  'fctDzj'     ,  'fctSzmdzj'     ,  'fctZdmgzj'     ,  'fctXzdmsdzj'     ,  'fctXzdmsdjqxzzj'     ,  'fctXzdmzdzj'     ,  'fctXzdmzdjqzj'     ,  'fctXzdmxdzj'     ,  'fctXzdmxdjqzj'     ,  'fctFzdmsdzj'     ,  'fctFzdmsdjqzj'     ,  'fctFzdmxdzj'     ,  'fctFzdmxdjqzj'     ,  'fctJdwhkl'     ,  'fctYdwhkl'     ,  'fctSzzwxz'     ,  'fctGbxz'     ,  'fctJqzg'     ,  'fctFqqzg'     ,  'fctZsmdzg'     ,  'fctYsmdzg'     ,  'fctZkzzg'     ,  'fctYkzzg'     ,  'fctRgxgycsm'     ,  'fctDmlykz'     ,  'fctZjycsm'     ,  'isDeletemark'     ,  'createTime'     ,  'modifyTime'     ,  'createUserId'     ,  'modifyUserId'   ])
                if (typeof values !== 'undefined') {
                    Object.keys(values).forEach(_key => { this.heartBCtout[_key] = values[_key] })
                }
            }
        }
    }
</script>
