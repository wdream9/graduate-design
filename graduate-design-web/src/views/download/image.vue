<template>
    <div class="demo-image__preview">
        <el-image
            style="width: 150px; height: 180px;"
            :src="base_url + name"
            :preview-src-list="previewList"
            :initial-index="4"
            fit="cover"
        />
        <div class="imageName">{{ name }}</div>
    </div>
</template>

<script lang="ts" setup>
const base_url = "http://localhost:8801/api/download/hdfs/download/"
const props = defineProps({
    name: String,
    previewList: [],
})
</script>

<style scoped>
.demo-image__preview {
    height: 220px;
    width: 200px;
    position:relative;
}
.imageName {
    width: 150px;
    height: 20px;
    position: absolute;
    bottom:0;
    white-space: nowrap;
    text-overflow: ellipsis;
    overflow: hidden;
    word-break: break-all;
}
</style>