import Mock from 'mockjs'
import table from './data/table'

Mock.mock('/user/login', 'post', table.login)
// Mock.mock('/table/delete', 'post', table.delete)

export default Mock