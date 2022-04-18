<template>
  <el-container class="layout">
    <el-aside class="asside" width="auto">
      <MenuBarVue></MenuBarVue>
    </el-aside>
    <el-main class="main">
      <span class="nick">
        {{ nickName }}
      </span>
      <div class="bread">
        <div class="t1">
          <BreadcrumbVue></BreadcrumbVue>
        </div>
        <div class="t2">
          <UploadButton></UploadButton>
        </div>
      </div>
      <router-view></router-view>
    </el-main>
  </el-container>
</template>
<script setup lang='ts'>
import { ref, reactive, onMounted, computed } from 'vue'
import { useStore } from '@/store';
import MenuBarVue from './MenuBar.vue'
import BreadcrumbVue from './Breadcrumb.vue';
import Upload from '../upload/index.vue'
import UploadButton from '../upload/index2.vue'
import { useRouter } from 'vue-router';
import useInstance from '@/hooks/useInstance'
// import UpLoad from '@/views/upload/index.vue'
const router = useRouter();
const store = useStore()
const nickName = computed(() => {
  return store.getters['getNick'];
})
const {proxy,global} = useInstance();
onMounted(() => {
  console.log(proxy,global)
  router.push({ path: '/file' })

})
</script>
<style scoped lang='scss'>
.layout {
  height: 100%;
  .asside {
    background-color: rgb(235, 233, 236);
  }
  .main {
    margin: 0px;
    padding: 0px;
    background-color: rgb(220, 226, 226);
    .nick {
      height: 10%;
      padding-top: 15px;
      width: 150px;
      display: block;
      float: left;
      font-size: 30px;
      white-space: nowrap;
      text-overflow: ellipsis;
      overflow: hidden;
      word-break: break-all;
    }
    .bread {
      height: 10%;
      align-items: center;
      border-bottom: 1px solid #c2ddd1 !important;
      .t1 {
        padding-top: 30px;
        float: left;
      }
      .t2 {
        padding-top: 20px;
        margin-right: 50px;
        float: right;
      }
    }
  }
}
</style>