<template>
  <a-drawer
    title="新增"
    :maskClosable="false"
    width=650
    placement="right"
    :closable="false"
    @close="onClose"
    :visible="addVisiable"
    style="height: calc(100% - 55px);overflow: auto;padding-bottom: 53px;"
  >
    <a-form :form="form">
      <a-form-item
        v-bind="formItemLayout"
        label="主键自增"
      >
        <a-input
          placeholder="请输入主键自增"
          v-decorator="['id', {rules:[{max:100,message:'最长不超过100'}]}]"
        />
      </a-form-item>
      <a-form-item
        v-bind="formItemLayout"
        label="用户帐号"
      >
        <a-input
          placeholder="请输入用户帐号"
          v-decorator="['username', {rules:[{max:100,message:'最长不超过100'}]}]"
        />
      </a-form-item>
      <a-form-item
        v-bind="formItemLayout"
        label="病案号"
      >
        <a-input
          placeholder="请输入病案号"
          v-decorator="['fileNo', {rules:[{max:100,message:'最长不超过100'}]}]"
        />
      </a-form-item>
      <a-form-item
        v-bind="formItemLayout"
        label="姓名"
      >
        <a-input
          placeholder="请输入姓名"
          v-decorator="['name', {rules:[{max:100,message:'最长不超过100'}]}]"
        />
      </a-form-item>
      <a-form-item
        v-bind="formItemLayout"
        label="肌红蛋白"
      >
        <a-input
          placeholder="请输入肌红蛋白"
          v-decorator="['jhdb', {rules:[{max:100,message:'最长不超过100'}]}]"
        />
      </a-form-item>
      <a-form-item
        v-bind="formItemLayout"
        label="肌钙蛋白"
      >
        <a-input
          placeholder="请输入肌钙蛋白"
          v-decorator="['jgdb', {rules:[{max:100,message:'最长不超过100'}]}]"
        />
      </a-form-item>
      <a-form-item
        v-bind="formItemLayout"
        label="CK-MB"
      >
        <a-input
          placeholder="请输入CK-MB"
          v-decorator="['ckmb', {rules:[{max:100,message:'最长不超过100'}]}]"
        />
      </a-form-item>
      <a-form-item
        v-bind="formItemLayout"
        label="超敏肌钙蛋白（optional）"
      >
        <a-input
          placeholder="请输入超敏肌钙蛋白（optional）"
          v-decorator="['cmjgdb', {rules:[{max:100,message:'最长不超过100'}]}]"
        />
      </a-form-item>
      <a-form-item
        v-bind="formItemLayout"
        label="红细胞计数"
      >
        <a-input
          placeholder="请输入红细胞计数"
          v-decorator="['hxbjs', {rules:[{max:100,message:'最长不超过100'}]}]"
        />
      </a-form-item>
      <a-form-item
        v-bind="formItemLayout"
        label="血红蛋白"
      >
        <a-input
          placeholder="请输入血红蛋白"
          v-decorator="['xhdb', {rules:[{max:100,message:'最长不超过100'}]}]"
        />
      </a-form-item>
      <a-form-item
        v-bind="formItemLayout"
        label="白细胞计数"
      >
        <a-input
          placeholder="请输入白细胞计数"
          v-decorator="['bxbjs', {rules:[{max:100,message:'最长不超过100'}]}]"
        />
      </a-form-item>
      <a-form-item
        v-bind="formItemLayout"
        label="中性粒细胞百分比"
      >
        <a-input
          placeholder="请输入中性粒细胞百分比"
          v-decorator="['zxlxbbfb', {rules:[{max:100,message:'最长不超过100'}]}]"
        />
      </a-form-item>
      <a-form-item
        v-bind="formItemLayout"
        label="血小板计数"
      >
        <a-input
          placeholder="请输入血小板计数"
          v-decorator="['xxbjs', {rules:[{max:100,message:'最长不超过100'}]}]"
        />
      </a-form-item>
      <a-form-item
        v-bind="formItemLayout"
        label="PH"
      >
        <a-input
          placeholder="请输入PH"
          v-decorator="['ph', {rules:[{max:100,message:'最长不超过100'}]}]"
        />
      </a-form-item>
      <a-form-item
        v-bind="formItemLayout"
        label="乳酸"
      >
        <a-input
          placeholder="请输入乳酸"
          v-decorator="['rs', {rules:[{max:100,message:'最长不超过100'}]}]"
        />
      </a-form-item>
      <a-form-item
        v-bind="formItemLayout"
        label="BE"
      >
        <a-input
          placeholder="请输入BE"
          v-decorator="['be', {rules:[{max:100,message:'最长不超过100'}]}]"
        />
      </a-form-item>
      <a-form-item
        v-bind="formItemLayout"
        label="SO2"
      >
        <a-input
          placeholder="请输入SO2"
          v-decorator="['so2', {rules:[{max:100,message:'最长不超过100'}]}]"
        />
      </a-form-item>
      <a-form-item
        v-bind="formItemLayout"
        label="PO2"
      >
        <a-input
          placeholder="请输入PO2"
          v-decorator="['po2', {rules:[{max:100,message:'最长不超过100'}]}]"
        />
      </a-form-item>
      <a-form-item
        v-bind="formItemLayout"
        label="PCO2"
      >
        <a-input
          placeholder="请输入PCO2"
          v-decorator="['pco2', {rules:[{max:100,message:'最长不超过100'}]}]"
        />
      </a-form-item>
      <a-form-item
        v-bind="formItemLayout"
        label="血肌肝"
      >
        <a-input
          placeholder="请输入血肌肝"
          v-decorator="['xjg', {rules:[{max:100,message:'最长不超过100'}]}]"
        />
      </a-form-item>
      <a-form-item
        v-bind="formItemLayout"
        label="ALT"
      >
        <a-input
          placeholder="请输入ALT"
          v-decorator="['alt', {rules:[{max:100,message:'最长不超过100'}]}]"
        />
      </a-form-item>
      <a-form-item
        v-bind="formItemLayout"
        label="AST"
      >
        <a-input
          placeholder="请输入AST"
          v-decorator="['ast', {rules:[{max:100,message:'最长不超过100'}]}]"
        />
      </a-form-item>
      <a-form-item
        v-bind="formItemLayout"
        label="总胆红素"
      >
        <a-input
          placeholder="请输入总胆红素"
          v-decorator="['zdhs', {rules:[{max:100,message:'最长不超过100'}]}]"
        />
      </a-form-item>
      <a-form-item
        v-bind="formItemLayout"
        label="直接胆红素"
      >
        <a-input
          placeholder="请输入直接胆红素"
          v-decorator="['zjdhs', {rules:[{max:100,message:'最长不超过100'}]}]"
        />
      </a-form-item>
      <a-form-item
        v-bind="formItemLayout"
        label="淀粉酶"
      >
        <a-input
          placeholder="请输入淀粉酶"
          v-decorator="['dfm', {rules:[{max:100,message:'最长不超过100'}]}]"
        />
      </a-form-item>
      <a-form-item
        v-bind="formItemLayout"
        label="D二聚体"
      >
        <a-input
          placeholder="请输入D二聚体"
          v-decorator="['d2jt', {rules:[{max:100,message:'最长不超过100'}]}]"
        />
      </a-form-item>
      <a-form-item
        v-bind="formItemLayout"
        label="FDP"
      >
        <a-input
          placeholder="请输入FDP"
          v-decorator="['fdp', {rules:[{max:100,message:'最长不超过100'}]}]"
        />
      </a-form-item>
      <a-form-item
        v-bind="formItemLayout"
        label="PT"
      >
        <a-input
          placeholder="请输入PT"
          v-decorator="['pt', {rules:[{max:100,message:'最长不超过100'}]}]"
        />
      </a-form-item>
      <a-form-item
        v-bind="formItemLayout"
        label="APTT"
      >
        <a-input
          placeholder="请输入APTT"
          v-decorator="['aptt', {rules:[{max:100,message:'最长不超过100'}]}]"
        />
      </a-form-item>
      <a-form-item
        v-bind="formItemLayout"
        label="是否删除"
      >
        <a-input
          placeholder="请输入是否删除"
          v-decorator="['isDeletemark', {rules:[{max:100,message:'最长不超过100'}]}]"
        />
      </a-form-item>
      <a-form-item
        v-bind="formItemLayout"
        label="创建时间"
      >
        <a-date-picker
          showTime
          format='YYYY-MM-DD HH:mm:ss'
          v-decorator="[ 'createTime', {}]"
        />
      </a-form-item>
      <a-form-item
        v-bind="formItemLayout"
        label="修改时间"
      >
        <a-date-picker
          showTime
          format='YYYY-MM-DD HH:mm:ss'
          v-decorator="[ 'modifyTime', {}]"
        />
      </a-form-item>
      <a-form-item
        v-bind="formItemLayout"
        label="创建人"
      >
        <a-input
          placeholder="请输入创建人"
          v-decorator="['createUserId', {rules:[{max:100,message:'最长不超过100'}]}]"
        />
      </a-form-item>
      <a-form-item
        v-bind="formItemLayout"
        label="修改人"
      >
        <a-input
          placeholder="请输入修改人"
          v-decorator="['modifyUserId', {rules:[{max:100,message:'最长不超过100'}]}]"
        />
      </a-form-item>
    </a-form>
    <div class="drawer-bootom-button">
      <a-popconfirm
        title="确定放弃编辑？"
        @confirm="onClose"
        okText="确定"
        cancelText="取消"
      >
        <a-button style="margin-right: .8rem">取消</a-button>
      </a-popconfirm>
      <a-button
        @click="handleSubmit"
        type="primary"
        :loading="loading"
      >提交</a-button>
    </div>
  </a-drawer>
</template>
<script>
const formItemLayout = {
  labelCol: { span: 3 },
  wrapperCol: { span: 18 }
}
export default {
  name: 'HeartBCheckAdd',
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
      heartBCheck: {}
    }
  },
  methods: {
    reset () {
      this.loading = false
      this.heartBCheck = {}
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
          this.$post('heartBCheck', {
            ...this.heartBCheck
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
      let values = this.form.getFieldsValue(['id', 'username', 'fileNo', 'name', 'jhdb', 'jgdb', 'ckmb', 'cmjgdb', 'hxbjs', 'xhdb', 'bxbjs', 'zxlxbbfb', 'xxbjs', 'ph', 'rs', 'be', 'so2', 'po2', 'pco2', 'xjg', 'alt', 'ast', 'zdhs', 'zjdhs', 'dfm', 'd2jt', 'fdp', 'pt', 'aptt', 'isDeletemark', 'createTime', 'modifyTime', 'createUserId', 'modifyUserId'])
      if (typeof values !== 'undefined') {
        Object.keys(values).forEach(_key => { this.heartBCheck[_key] = values[_key] })
      }
    }
  }
}
</script>
