<template>
  <el-upload class="upload-demo" :action="'http://localhost:8801/api/upload/hdfs/uploads/' + id"
    :on-preview="handlePreview" :on-remove="handleRemove" :before-remove="beforeRemove" multiple :limit="10"
    :on-exceed="handleExceed" :file-list="fileList">
    <el-button type="primary">upload</el-button>
  </el-upload>
</template>
<script lang="ts" setup>
import { ref } from 'vue'


import { ElMessage, ElMessageBox } from 'element-plus'

import type { UploadUserFile, UploadProps } from 'element-plus'
import { getUserIdSession } from '@/utils/auth/auth';


const id = getUserIdSession();

const fileList = ref<UploadUserFile[]>([])

const handleRemove: UploadProps['onRemove'] = (file, uploadFiles) => {
  console.log(file, uploadFiles)
}

const handlePreview: UploadProps['onPreview'] = (uploadFile) => {
  console.log(uploadFile)
}

const handleExceed: UploadProps['onExceed'] = (files, uploadFiles) => {
  ElMessage.warning(
    `The limit is 3, you selected ${files.length} files this time, add up to ${files.length + uploadFiles.length
    } totally`
  )
}

const beforeRemove: UploadProps['beforeRemove'] = (uploadFile, uploadFiles) => {
  return ElMessageBox.confirm(
    `Cancel the transfert of ${uploadFile.name} ?`
  ).then(
    () => true,
    () => false
  )
}
</script>