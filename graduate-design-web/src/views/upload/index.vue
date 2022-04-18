<template>
  <el-upload
    action="http://localhost:8801/api/upload/hdfs/uploads"
    list-type="picture-card"
    :on-preview="handlePictureCardPreview"
    :on-remove="handleRemove"
    :file-list="fileList"
    multiple
  >
    <el-icon><Plus /></el-icon>
  </el-upload>
  <el-dialog v-model="dialogVisible">
    <img style="width: 100%" :src="dialogImageUrl" alt="" />
  </el-dialog>
</template>

<script lang="ts" setup>
import { ref } from 'vue'
import { Plus } from '@element-plus/icons-vue'

import type { UploadFile, UploadRawFile } from 'element-plus'

const fileList = ref<UploadRawFile[]>([
])

const dialogImageUrl = ref('')
const dialogVisible = ref(false)

const handleRemove = (file: UploadFile, fileList: UploadFile[]) => {
  console.log(file, fileList)
}
const handlePictureCardPreview = (file: UploadFile) => {
  dialogImageUrl.value = file.url!
  dialogVisible.value = true
}
</script>