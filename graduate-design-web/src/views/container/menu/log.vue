<template>
    <el-table :data="tableData" stripe style="width: 100%">
            <el-table-column prop="date" label="登录时间" width="180" />
            <el-table-column prop="address" label="登录地址" />
        </el-table>
</template>
<script setup lang='ts'>
import { ref, reactive } from 'vue'
const tableData = [
  {
    date: '2016-05-03',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
  {
    date: '2016-05-02',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
  {
    date: '2016-05-04',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
  {
    date: '2016-05-01',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
]
</script>
<style scoped lang='scss'>
</style>