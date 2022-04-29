<template>
    <div class="logincontainer">
        <el-form class="loginForm" :model="loginModel" ref="loginFormRef" :rules="rules" :inline="false">
            <el-form-item>
                <div class="loginTitle" style="align: center">登录</div>
            </el-form-item>
            <el-form-item prop="username">
                <el-input placeholder="请输入账户" v-model="loginModel.username"></el-input>
            </el-form-item>
            <el-form-item prop="password">
                <el-input placeholder="请输入密码" type="password" v-model="loginModel.password"></el-input>
            </el-form-item>
            <el-form-item prop="code">
                <el-row :gutter="20">
                    <el-col :span="16">
                        <el-input placeholder="请输入验证码" v-model="loginModel.code"></el-input>
                    </el-col>
                    <el-col :span="8">
                        <img class="imageSrc" :src="imageSrc" @click="send" />
                    </el-col>
                </el-row>
            </el-form-item>
            <el-form-item>
                <el-row :gutter="20" style="margin-top: 10px;">
                    <el-col :span="12">
                        <el-button class="mybtn" @click="login" type="primary" size="default">登录</el-button>
                    </el-col>
                    <el-col :span="12">
                        <el-button class="mybtn" @click="register" size="default">注册</el-button>
                    </el-col>
                </el-row>
            </el-form-item>
            <el-form-item>
                <div class="forget" @click="forget">忘记密码?</div>
            </el-form-item>
        </el-form>
        <br />
    </div>
</template>
<script setup lang='ts'>
import { ref, reactive } from 'vue'
import useBaseLogin from './useBaseLogin'
import userLogin from './useLogin'
import { codeLogin } from './logic'
// 基础数据
const { loginModel, rules, forget, loginFormRef } = useBaseLogin();
// 获取验证码
const { imageSrc, send } = codeLogin();
// 登录
const { login, register } = userLogin(loginModel);


</script>
<style scoped lang='scss'>
.logincontainer {
    height: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
    background: url("@/assets/loginBack.jpeg");
    background-size: 100% 100%;
    background-repeat: no-repeat;

    .loginForm {
        height: 320px;
        width: 400px;
        border-radius: 10px;
        padding: 20px 35px;
        box-shadow: 0 0 25px #cac6c6;

        .loginTitle {
            font-size: 24px;
            font-weight: 600;
            display: flex;
            justify-content: center;
            align-items: center;
            width: 100%;
        }
    }

    .mybtn {
        width: 190px;
        display: flex;
    }

    .forget {
        display: block;
        cursor: pointer;
    }
}
</style>
