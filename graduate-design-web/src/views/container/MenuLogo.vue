<template>
    <div class="logo">
        <el-avatar :size="30" @error="errorHandler">
            <img src="@/assets/cloud.png" alt="logo" />
        </el-avatar>
        <span class="title">云存储网盘</span>
    </div>
</template>
<script setup lang="ts">

const errorHandler = ()=> true;
</script>
<style lang="scss" scoped>
.logo {
    background-color: #c8cad1;
    height: 10%;
    border: none;
    line-height: 50px;
    display: flex;
    align-items: center;
    padding-left: 15px;
    color: #fff;
    img {
        width: 32px;
        height: 32px;
        margin-right: 12px;
    }
    span {
        font-weight: 600;
        line-height: 50px;
        font-size: 16px;
        font-family: Avenir, Helvetica Neue, Arial, Helvetica, sans-serif;
        vertical-align: middle;
    }
}
</style>