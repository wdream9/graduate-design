<template>
  <div class="files">
    <template v-for="(item, index) in lists" :key="index">
      <div v-if="item.fileType == 'f'" class="images">
        <imageVue :name="item.originName" :previewList="previewSrc"></imageVue>
      </div>
    </template>
  </div>
</template>
<script setup lang='ts'>
import { on } from 'events';
import { ref, reactive, onMounted, Ref } from 'vue'
import imageVue from '../../download/image.vue';
import { downRequest } from '@/utils/http'
import { FileInfo } from './file'

// 图片列表
var lists = ref<FileInfo[]>([]);
// 预览地址列表
var previewSrc = [] as any;
onMounted(() => {
  downRequest.post({
    url: '/hdfs/info'
  }).then((res: any) => {
    lists.value = res.data;
    let list = res.data;
    for (const key in list) {
      previewSrc.splice(-1,0,"http://localhost:8801/api/download/hdfs/download/" + list[key].originName) 
    }
    console.log(previewSrc)
  })
})
</script>
<style scoped lang='scss'>
.files {
  height: 89.9%;
  width: auto;
  padding: 0px;
  margin: 0px;
  overflow-y: auto;
}
.images {
  // margin: 20px;
  padding: 35px;
  display: inline;
  float: left;
}
</style>