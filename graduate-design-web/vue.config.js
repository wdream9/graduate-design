const path = require('path');
module.exports = {
    devServer: {
        before: require('./src/mock/index.ts')
    }
}