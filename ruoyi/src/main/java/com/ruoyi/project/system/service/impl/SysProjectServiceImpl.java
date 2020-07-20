package com.ruoyi.project.system.service.impl;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.exception.CustomException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.aspectj.lang.annotation.DataScope;
import com.ruoyi.project.system.domain.SysProject;
import com.ruoyi.project.system.domain.SysRole;
import com.ruoyi.project.system.domain.SysRoleDept;
import com.ruoyi.project.system.domain.SysRoleMenu;
import com.ruoyi.project.system.mapper.*;
import com.ruoyi.project.system.service.ISysProjectService;
import com.ruoyi.project.system.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 项目 业务层处理
 * 
 * @author ruoyi
 */
@Service
public class SysProjectServiceImpl implements ISysProjectService
{
    @Autowired
    private SysRoleMapper roleMapper;

    @Autowired
    private SysProjectMapper projectMapper;

    @Autowired
    private SysRoleMenuMapper roleMenuMapper;

    @Autowired
    private SysUserRoleMapper userRoleMapper;

    @Autowired
    private SysRoleDeptMapper roleDeptMapper;

    /**
     * 根据条件分页查询项目数据
     * 
     * @param project 项目信息
     * @return 项目数据集合信息
     */
    @Override
    @DataScope(deptAlias = "d")
    public List<SysProject> selectProjectList(SysProject project)
    {
        return projectMapper.selectProjectList(project);
    }

    /**
     * 根据用户ID查询权限
     * 
     * @param userId 用户ID
     * @return 权限列表
     */
    @Override
    public Set<String> selectRolePermissionByUserId(Long userId)
    {
        List<SysRole> perms = roleMapper.selectRolePermissionByUserId(userId);
        Set<String> permsSet = new HashSet<>();
        for (SysRole perm : perms)
        {
            if (StringUtils.isNotNull(perm))
            {
                permsSet.addAll(Arrays.asList(perm.getRoleKey().trim().split(",")));
            }
        }
        return permsSet;
    }

    /**
     * 查询所有项目
     * 
     * @return 项目列表
     */
    public List<SysRole> selectRoleAll()
    {
        return roleMapper.selectRoleAll();
    }

    /**
     * 根据用户ID获取项目选择框列表
     * 
     * @param userId 用户ID
     * @return 选中项目ID列表
     */
    public List<Integer> selectRoleListByUserId(Long userId)
    {
        return roleMapper.selectRoleListByUserId(userId);
    }

    /**
     * 通过项目ID查询项目
     * 
     * @param projectId 项目ID
     * @return 项目对象信息
     */
    public SysProject selectProjectById(Long projectId)
    {
        return projectMapper.selectProjectById(projectId);
    }

    /**
     * 校验项目名称是否唯一
     * 
     * @param role 项目信息
     * @return 结果
     */
    @Override
    public String checkRoleNameUnique(SysRole role)
    {
        Long roleId = StringUtils.isNull(role.getRoleId()) ? -1L : role.getRoleId();
        SysRole info = roleMapper.checkRoleNameUnique(role.getRoleName());
        if (StringUtils.isNotNull(info) && info.getRoleId().longValue() != roleId.longValue())
        {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * 校验项目权限是否唯一
     * 
     * @param role 项目信息
     * @return 结果
     */
    @Override
    public String checkRoleKeyUnique(SysRole role)
    {
        Long roleId = StringUtils.isNull(role.getRoleId()) ? -1L : role.getRoleId();
        SysRole info = roleMapper.checkRoleKeyUnique(role.getRoleKey());
        if (StringUtils.isNotNull(info) && info.getRoleId().longValue() != roleId.longValue())
        {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * 校验项目是否允许操作
     * 
     * @param role 项目信息
     */
    public void checkRoleAllowed(SysRole role)
    {
        if (StringUtils.isNotNull(role.getRoleId()) && role.isAdmin())
        {
            throw new CustomException("不允许操作超级管理员项目");
        }
    }

    /**
     * 通过项目ID查询项目使用数量
     * 
     * @param roleId 项目ID
     * @return 结果
     */
    @Override
    public int countUserRoleByRoleId(Long roleId)
    {
        return userRoleMapper.countUserRoleByRoleId(roleId);
    }

    /**
     * 新增保存项目信息
     * 
     * @param project 项目信息
     * @return 结果
     */
    @Override
    @Transactional
    public int insertProject(SysProject project)
    {
        // 新增项目信息
        return projectMapper.insertProject(project);
    }

    /**
     * 修改保存项目信息
     * 
     * @param project 项目信息
     * @return 结果
     */
    @Override
    @Transactional
    public int updateProject(SysProject project)
    {
        // 修改项目信息
        return projectMapper.updateProject(project);
    }

    @Override
    public int updateRoleStatus(SysRole role) {
        return 0;
    }

    /**
     * 修改项目状态
     * 
     * @param project 项目信息
     * @return 结果
     */
    public int updateRoleStatus(SysProject project)
    {
        return projectMapper.updateProject(project);
    }

    /**
     * 修改数据权限信息
     * 
     * @param role 项目信息
     * @return 结果
     */
    @Override
    @Transactional
    public int authDataScope(SysRole role)
    {
         
        // 删除项目与部门关联
        roleDeptMapper.deleteRoleDeptByRoleId(role.getRoleId());
        // 新增项目和部门信息（数据权限）
        return insertRoleDept(role);
    }

    /**
     * 新增项目菜单信息
     * 
     * @param role 项目对象
     */
    public int insertRoleMenu(SysRole role)
    {
        int rows = 1;
        // 新增用户与项目管理
        List<SysRoleMenu> list = new ArrayList<SysRoleMenu>();
        for (Long menuId : role.getMenuIds())
        {
            SysRoleMenu rm = new SysRoleMenu();
            rm.setRoleId(role.getRoleId());
            rm.setMenuId(menuId);
            list.add(rm);
        }
        if (list.size() > 0)
        {
            rows = roleMenuMapper.batchRoleMenu(list);
        }
        return rows;
    }

    /**
     * 新增项目部门信息(数据权限)
     *
     * @param role 项目对象
     */
    public int insertRoleDept(SysRole role)
    {
        int rows = 1;
        // 新增项目与部门（数据权限）管理
        List<SysRoleDept> list = new ArrayList<SysRoleDept>();
        for (Long deptId : role.getDeptIds())
        {
            SysRoleDept rd = new SysRoleDept();
            rd.setRoleId(role.getRoleId());
            rd.setDeptId(deptId);
            list.add(rd);
        }
        if (list.size() > 0)
        {
            rows = roleDeptMapper.batchRoleDept(list);
        }
        return rows;
    }

    /**
     * 通过项目ID删除项目
     * 
     * @param projectId 项目ID
     * @return 结果
     */
    @Override
    public int deleteProjectById(Long projectId)
    {
        return projectMapper.deleteProjectById(projectId);
    }

    /**
     * 批量删除项目信息
     * 
     * @param projectIds 需要删除的项目ID
     * @return 结果
     */
    public int deleteProjectByIds(Long[] projectIds)
    {
        return projectMapper.deleteProjectByIds(projectIds);
    }
}
