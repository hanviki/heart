<template>
    <a-upload
      accept=".png,.jpg"
      :fileList="fileList"
      :remove="handleRemove"
      :beforeUpload="beforeUpload"
      @change="handleChange"
      :disabled="!isEdit"
    >
      <a-button  v-show="isEdit">
        <a-icon type="upload" /> 选择图片
      </a-button>
    </a-upload>
</template>
  
  <script>
export default {
  name: "file",
  data () {
    return {
      tstyle: { "color": "#0785fd", "font-weight": "bold", "background-color": "#ececec" },
      fileList: [],
      uploading: false,
      fileNow: {},
      fileId: ''
    }
  },
  props: {
    baseId: {
      default: ''
    },
    isEdit: {
      default: true
    }
  },
  watch: {
     baseId: function () {
       if(this.baseId!=''){
            var _this = this;
            _this.fetch(_this.baseId)
        }
     },
     immediate:true, // watch侦听操作内的函数会立刻被执行
     deep: true
 },
  methods: {
    handleRemove (file) {
      const index = this.fileList.indexOf(file)
      const newFileList = this.fileList.slice()
    console.info(newFileList[index].uid)
     this.$delete('comFile/'+newFileList[index].uid).then((r) => {
        newFileList.splice(index, 1)
        this.fileList = newFileList
        this.uploading = false
        this.$message.success('删除成功.')
      }).catch(() => {
        this.uploading = false
        this.$message.error('删除失败.')
      })

     
    },
    onChange (date, dateString) {
      console.log(date, dateString);
    },
    beforeUpload (file) {
      const isJPG =  (file.type === 'image/jpeg' || file.type === 'image/png')
      console.info(file.type)
      if (!isJPG) {
        this.$message.error('请只上传pdf文件!')
      }
      const isLt2M = file.size / 1024 / 1024 < 20
      if (!isLt2M) {
        this.$message.error('附件必须小于 20MB!')
      }
      if (isJPG && isLt2M) {
        this.fileNow = file
      }
      return isJPG && isLt2M;
    },
    handleChange (info) {
      if (info.file.status === 'uploading') {
        this.handleUpload()
      }
    },
    handleUpload () {
      const { fileNow  } = this
      const formData = new FormData()
      formData.append('file', fileNow)
      formData.append('baseId',this.baseId)
      this.uploading = true

      // You can use any AJAX library you like
      this.$upload('comFile/upload', formData).then((r) => {
        let comfile = r.data.data
        this.fileList =[...this.fileList, comfile]
        this.uploading = false
        this.$message.success('上传成功.')
      }).catch(() => {
        this.uploading = false
        this.$message.error('上传失败.')
      })
    },
    fetch (baseId) {
      this.fileList=[]
      this.$get('comFile/getAllFiles/' + baseId).then((r) => {
        let data = r.data.data
        console.info(data)
        if(data!=null) {
          this.fileList = [...data]
        }
      })
    },
    cancelAudit () {
      this.$emit("setFileId", this.fileId, this.fileUrl)
    },

  }
}
  </script>
  
  <style>
</style>