<template>
    <div class="logincontainer">
        <el-form
            class="registerForm"
            :model="registerModel"
            ref="registerFormRef"
            :rules="rules"
            :inline="false"
        >
            <el-form-item>
                <div class="loginTitle" style="align: center">注册</div>
            </el-form-item>
            <el-form-item label="昵称" prop="username">
                <el-input placeholder="请输入昵称" v-model="registerModel.username"></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="password">
                <el-input placeholder="请输入密码" type="password" v-model="registerModel.password"></el-input>
            </el-form-item>
            <!-- <el-form-item label="" prop="password">
                <el-input placeholder="请输入密码" type="password" v-model="registerModel.password"></el-input>
            </el-form-item> -->
            <el-form-item label="邮箱" prop="email">
                <el-input placeholder="请输入邮箱" type="email" v-model="registerModel.email"></el-input>
            </el-form-item>
            <el-form-item label="手机" prop="telephone">
                <el-input placeholder="请输入手机号" v-model="registerModel.telephone"></el-input>
            </el-form-item>
            <el-form-item label="验证码" prop="code">
                <el-row :gutter="20">
                    <el-col :span="12">
                        <el-input placeholder="请输入验证码" v-model="registerModel.code"></el-input>
                    </el-col>
                    <el-col :span="8">
                        <img class="imageSrc" alt="点击刷新" :src="imageSrc" @click="send" />
                    </el-col>
                </el-row>
            </el-form-item>
            <el-form-item>
                <el-button plain class="mybtn" @click="register" size="default">提交</el-button>
            </el-form-item>
            <el-form-item>
                <div class="forget" @click="login">登录</div>
            </el-form-item>
        </el-form>
    </div>
</template>
<script setup lang='ts'>
import { formProps } from 'element-plus'
import { ref, reactive } from 'vue'
import baseRegister from './baseRegister'
import { codeLogin } from '../login/logic'
import registerApi from './register'

// 表单验证、ref引用、表单值
const { registerFormRef, registerModel, rules } = baseRegister();
// 获取验证码
const { imageSrc, send } = codeLogin();
// 提交
const {register,login} = registerApi(registerModel);

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
    .registerForm {
        height: 400px;
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
        .mybtn {
            width: 100%;
            display: flex;
        }
    }
    .forget {
        display: block;
        cursor: pointer;
    }
}
</style>