<template>
    <MenuLogo></MenuLogo>
    <el-menu default-active="/file" class="el-menu-vertical-demo" :collapse="isCollapse" router>
        <template v-for="menu in menuList" :key="menu.path">
            <el-menu-item :index="menu.path">
                <el-icon :size="size" class="icons">
                    <component :is="menu.meta.icon" />
                </el-icon>
                <template #title>{{ menu.meta.title }}</template>
            </el-menu-item>
        </template>
    </el-menu>
    <UserInfo></UserInfo>
</template>
<script lang="ts" setup>
import MenuLogo from './MenuLogo.vue'
import { ref, reactive } from 'vue';
import UserInfo from './UserInfo.vue'
//控制菜单展开和关闭
const isCollapse = ref(false);
const size = ref('30px')
//菜单数据
let menuList = reactive([
    {
        path: '/file',
        component: "File",
        meta: {
            title: "文件",
            icon: "notebook",
            roles: []
        },
        children: []
    },
    {
        path: '/favorites',
        component: "Favorites",
        meta: {
            title: "收藏夹",
            icon: "message-box",
            roles: []
        },
        children: []
    },
    {
        path: '/encrypt',
        component: "Encrypt",
        meta: {
            title: "加密箱",
            icon: "briefcase",
            roles: []
        },
        children: []
    },
    {
        path: '/subscribe',
        component: "Subscribe",
        meta: {
            title: "订阅栏",
            icon: "van",
            roles: []
        },
        children: []
    },
    {
        path: '/recovery',
        component: "Recovery",
        meta: {
            title: "回收站",
            icon: "delete-filled",
            roles: []
        },
        children: []
    },
    {
        path: '/log',
        component: "Log",
        meta: {
            title: "登录日志",
            icon: "notebook",
            roles: []
        },
        children: []
    },
])
</script>
<style scoped>
.el-menu-vertical-demo:not(.el-menu--collapse) {
    width: 230px;
    min-height: 400px;
    height: 75%;
}
.icons {
    margin-right: 20px;
}
</style>