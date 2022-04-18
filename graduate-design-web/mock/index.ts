// 使用 Mock
var Mock = require('mockjs')
var data = Mock.mock({
    // 属性值是数组，从数组中随机获1-10个对象
    'list|1-10': [{
        // 属性 id 是一个自增数，起始值为 1，每次增 1
        'id|+1': 1
    }]
})
