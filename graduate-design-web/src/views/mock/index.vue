<template>
    <div>
        <el-button type="primary" size="default" @click="mock">mock请求</el-button>
    </div>
</template>
<script setup lang='ts'>
import { ref, reactive } from 'vue'
import {request} from '@/utils/http';
// import axios from 'axios';

// 发送请求
const mock = ()=>{
    // axios.get('/api/user/userinfo').then((res:any)=>{
    //     console.log(res)
    // })
    request.get({
        url:'/user/userinfo'
    }).then((res:any)=>{
        console.log(res)
    })
}

</script>
