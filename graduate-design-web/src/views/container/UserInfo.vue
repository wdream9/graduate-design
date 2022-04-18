<template>
    <div class="logo">
        <div class="demo-type">
            <div class="imagess">
                <el-avatar :size="45" @error="errorHandler">
                    <img src="@/assets/user.gif" />
                </el-avatar>
            </div>
            <span class="nick">
                {{ nickName }}
            </span>
            <div class="quit" >
                <UserQuitVue @quit="quitLogin"></UserQuitVue>
            </div>
        </div>
    </div>
</template>
<script setup lang='ts'>
import { ref, reactive, computed } from 'vue'
import { useStore } from '@/store';
import UserQuitVue from './UserQuit.vue';
const store = useStore();
const errorHandler = () => true
const nickName = computed(() => {
    return store.getters['getNick'];
})
const quitLogin = ()=>{
    console.log("quit login!")
}
</script>

<style scoped lang='scss'>
.logo {
    background-color: white;
    border-top: 1px solid #d4cfcf !important;
    height: 14.9%;
    border: none;
    line-height: 50px;
    display: flex;
    align-items: center;
    padding-left: 15px;
    color: rgb(179, 64, 64);

    .demo-type {
        width: 210px;
        .imagess{
            float: left;
        }
        .nick {
            height: 10%;
            display: block;
            width: 100px;
            padding-left: 20px;
            float: left;
            font-size: 15px;
            white-space: nowrap;
            text-overflow: ellipsis;
            overflow: hidden;
            word-break: break-all;
        }
        .quit{

        }
    }
}
</style>