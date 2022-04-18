<template>
    <div>
        <el-button icon="place" @click="dialogVisible = true" circle />

        <el-dialog v-model="dialogVisible" title="Tips" width="30%">
            <span>确认退出登录吗</span>
            <template #footer>
                <span class="dialog-footer">
                    <el-button @click="dialogVisible = false">取消</el-button>
                    <el-button type="primary" @click="quitlogin">确认</el-button>
                </span>
            </template>
        </el-dialog>
    </div>
</template>
<script setup lang='ts'>
import { ref, reactive } from 'vue'
import { ElMessageBox } from 'element-plus'
import { removeCookie, removeToken } from '@/utils/auth/auth'

const dialogVisible = ref(false)
const quitlogin = () => {
    console.log("asdfasdfasdf============================")
    dialogVisible.value = false;
    // 退出登录删除token
    removeCookie('netdisk');
    removeToken();
    location.reload();
}
</script>
<style scoped lang='scss'>
.dialog-footer button:first-child {
    margin-right: 10px;
}
</style>