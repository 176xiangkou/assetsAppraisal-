import request from '@/utils/request'

// 提交
export function houseBaseAdd(data) {
  return request({
    url: '/house/base' ,
    method: 'post',
    data
  })
}
// 修改项目
export function updateHouseBase(data) {
  return request({
    url: '/house/base/updateHouse',
    method: 'put',
    data
  })
}
// 删除项目
export function houseBaseDelete(id) {
  return request({
    url: '/house/base/' + id,
    method: 'delete'
  })
}
// 查询项目列表
export function baseList(query) {
  return request({
    url: '/house/base/list',
    method: 'get',
    params: query
  })
}
// 查询项目列表
export function getHouseBaseById(params) {
  return request({
    url: '/house/base/getHouseBaseById',
    method: 'get',
    params
  })
}

// 查询项目详细
export function getProjectDetail(params) {
  return request({
    url: '/house/base/getHouseBaseByHouseBaseId',
    method: 'get',
    params
  })
}

// 新增项目
export function addProject(data) {
  return request({
    url: '/system/project',
    method: 'post',
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



// 导出项目
export function exportRole(query) {
  return request({
    url: '/system/role/export',
    method: 'get',
    params: query
  })
}
