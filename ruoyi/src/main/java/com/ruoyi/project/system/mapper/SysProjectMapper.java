package com.ruoyi.project.system.mapper;

import com.ruoyi.project.system.domain.SysProject;
import com.ruoyi.project.system.domain.SysRole;

import java.util.List;

/**
 * 项目表 数据层
 * 
 * @author ruoyi
 */
public interface SysProjectMapper
{
    /**
     * 根据条件分页查询项目数据
     * 
     * @param project 项目信息
     * @return 项目数据集合信息
     */
    List<SysProject> selectProjectList(SysProject project);

    /**
     * 根据用户ID查询项目
     * 
     * @param userId 用户ID
     * @return 项目列表
     */
    public List<SysRole> selectRolePermissionByUserId(Long userId);

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
     * 根据用户ID查询项目
     * 
     * @param userName 用户名
     * @return 项目列表
     */
    public List<SysRole> selectRolesByUserName(String userName);

    /**
     * 校验项目名称是否唯一
     * 
     * @param roleName 项目名称
     * @return 项目信息
     */
    public SysRole checkRoleNameUnique(String roleName);

    /**
     * 校验项目权限是否唯一
     * 
     * @param roleKey 项目权限
     * @return 项目信息
     */
    public SysRole checkRoleKeyUnique(String roleKey);

    /**
     * 修改项目信息
     * 
     * @param project 项目信息
     * @return 结果
     */
    public int updateProject(SysProject project);

    /**
     * 新增项目信息
     * 
     * @param project 项目信息
     * @return 结果
     */
    public int insertProject(SysProject project);

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
