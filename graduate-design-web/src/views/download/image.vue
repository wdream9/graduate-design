<template>
    <div class="demo-image__preview">
        <el-image style="width: 150px; height: 180px;" :src="base_url + name" :preview-src-list="previewList"
            :initial-index="4" fit="cover" />
        <div class="imageName"><a :href="base_url + name" target="_blank">{{ name }}</a></div>
    </div>
</template>

<script lang="ts" setup>import { getUserIdSession } from '@/utils/auth/auth';

const base_url = "http://localhost:8801/api/download/hdfs/download/" + getUserIdSession() + "/"
const download = () => {
    const url = "https://tutu.txt"
    const a = document.createElement('a')
    // 设置图片地址
    a.href = base_url + props.name
    //模拟点击事件，实现图片文件的同源下载
    a.click()
}
const props = defineProps({
    name: String,
    previewList: [],
})
</script>

<style scoped>
.demo-image__preview {
    height: 220px;
    width: 200px;
    position: relative;
}

.imageName {
    width: 150px;
    height: 20px;
    position: absolute;
    bottom: 0;
    white-space: nowrap;
    text-overflow: ellipsis;
    overflow: hidden;
    word-break: break-all;
}
</style>