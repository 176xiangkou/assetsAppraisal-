import request from '@/utils/request'

// 查询价格列表
export function getAllPrice() {
  return request({
    url: '/system/price/allPrice' ,
    method: 'get'
  })
}
// 查询价格列表
export function listPrice(query) {
  return request({
    url: '/system/price/list',
    method: 'get',
    params: query
  })
}

// 查询价格详细
export function getPrice(id) {
  return request({
    url: '/system/price/' + id,
    method: 'get'
  })
}

// 新增价格
export function addPrice(data) {
  return request({
    url: '/system/price',
    method: 'post',
    data: data
  })
}

// 修改价格
export function updatePrice(data) {
  return request({
    url: '/system/price',
    method: 'put',
    data: data
  })
}

// 项目数据权限
export function dataScope(data) {
  return request({
    url: '/system/role/dataScope',
    method: 'put',
    data: data
  })
}

// 项目状态修改
export function changeRoleStatus(roleId, status) {
  const data = {
    roleId,
    status
  }
  return request({
    url: '/system/role/changeStatus',
    method: 'put',
    data: data
  })
}

// 删除价格
export function delPrice(id) {
  return request({
    url: '/system/price/' + id,
    method: 'delete'
  })
}

// 导出项目
export function exportRole(query) {
  return request({
    url: '/system/role/export',
    method: 'get',
    params: query
  })
}