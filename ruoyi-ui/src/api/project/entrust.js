import request from '@/utils/request'

// 查询委托方列表
export function listEntrust(query) {
  return request({
    url: '/system/entrust/list',
    method: 'get',
    params: query
  })
}

// 查询委托方详细
export function getEntrust(entrustId) {
  return request({
    url: '/system/entrust/' + entrustId,
    method: 'get'
  })
}

// 新增委托方
export function addEntrust(data) {
  return request({
    url: '/system/entrust',
    method: 'post',
    data: data
  })
}

// 修改委托方
export function updateEntrust(data) {
  return request({
    url: '/system/entrust',
    method: 'put',
    data: data
  })
}

// 委托方数据权限
export function dataScope(data) {
  return request({
    url: '/system/role/dataScope',
    method: 'put',
    data: data
  })
}

// 委托方状态修改
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

// 删除委托方
export function delEntrust(entrustId) {
  return request({
    url: '/system/entrust/' + entrustId,
    method: 'delete'
  })
}

// 导出委托方
export function exportRole(query) {
  return request({
    url: '/system/role/export',
    method: 'get',
    params: query
  })
}