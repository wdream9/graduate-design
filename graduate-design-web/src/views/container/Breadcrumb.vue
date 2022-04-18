<template>
  <el-breadcrumb :separator-icon="ArrowRight">
    <el-breadcrumb-item v-for="tab in tabs" :key="tab">{{ tab.meta.title }}</el-breadcrumb-item>
  </el-breadcrumb>
</template>
<script setup lang='ts'>
import { ref, reactive, Ref, watch, onMounted } from 'vue'
import { useRoute, useRouter, RouteLocationMatched } from 'vue-router';
import { ArrowRight } from '@element-plus/icons-vue'

// 面包屑，导航数组
const tabs: Ref<RouteLocationMatched[]> = ref([]);
const route = useRoute();
const getBreadcrum = () => {
  // 获取所有的mete和title
  let mached = route.matched.filter(item => item.meta && item.meta.title);
  // 判断是否是首页，如果不是，构造一个
  const first = mached[0];
  // if (first && first.path != '/home') {
  //   // 构造一个
  //   mached = [{ path: '/file', meta: { title: '文件' } } as any].concat(mached)
  // }
  tabs.value = mached;


};

// 监听路由，路由变化就刷新，面包屑就显示当钱前的路由
watch(() => route.path, () => getBreadcrum());

//挂载时获取当前的路由展示
onMounted(() => {
  getBreadcrum();
})
</script>
<style scoped lang='scss'>
</style>