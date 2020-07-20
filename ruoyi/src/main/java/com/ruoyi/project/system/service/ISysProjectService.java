package com.ruoyi.project.system.service;

import com.ruoyi.project.system.domain.SysProject;
import com.ruoyi.project.system.domain.SysRole;

import java.util.List;
import java.util.Set;

/**
 * 项目业务层
 * 
 * @author ruoyi
 */
public interface ISysProjectService
{
    /**
     * 根据条件分页查询项目数据
     * 
     * @param project 项目信息
     * @return 项目数据集合信息
     */
    public List<SysProject> selectProjectList(SysProject project);

    /**
     * 根据用户ID查询项目
     * 
     * @param userId 用户ID
     * @return 权限列表
     */
    public Set<String> selectRolePermissionByUserId(Long userId);

    /**
     * 查询所有项目
     * 
     * @return 项目列表
     */
    public List<SysRole> selectRoleAll();

    /**
     * 根据用户ID获取项目选择框列表
     * 
     * @param userId 用户ID
     * @return 选中项目ID列表
     */
    public List<Integer> selectRoleListByUserId(Long userId);

    /**
     * 通过项目ID查询项目
     * 
     * @param projectId 项目ID
     * @return 项目对象信息
     */
    public  SysProject selectProjectById(Long projectId);

    /**
     * 校验项目名称是否唯一
     * 
     * @param role 项目信息
     * @return 结果
     */
    public String checkRoleNameUnique(SysRole role);

    /**
     * 校验项目权限是否唯一
     * 
     * @param role 项目信息
     * @return 结果
     */
    public String checkRoleKeyUnique(SysRole role);

    /**
     * 校验项目是否允许操作
     * 
     * @param role 项目信息
     */
    public void checkRoleAllowed(SysRole role);

    /**
     * 通过项目ID查询项目使用数量
     * 
     * @param roleId 项目ID
     * @return 结果
     */
    public int countUserRoleByRoleId(Long roleId);

    /**
     * 新增保存项目信息
     * 
     * @param project 项目信息
     * @return 结果
     */
    public int insertProject(SysProject project);

    /**
     * 修改保存项目信息
     * 
     * @param project 项目信息
     * @return 结果
     */
    public int updateProject(SysProject project);

    /**
     * 修改项目状态
     * 
     * @param role 项目信息
     * @return 结果
     */
    public int updateRoleStatus(SysRole role);

    /**
     * 修改数据权限信息
     * 
     * @param role 项目信息
     * @return 结果
     */
    public int authDataScope(SysRole role);

    /**
     * 通过项目ID删除项目
     * 
     * @param projectId 项目ID
     * @return 结果
     */
    public int deleteProjectById(Long projectId);

    /**
     * 批量删除项目信息
     * 
     * @param projectIds 需要删除的项目ID
     * @return 结果
     */
    public int deleteProjectByIds(Long[] projectIds);
}
