package com.ruoyi.project.system.service.impl;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.exception.CustomException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.aspectj.lang.annotation.DataScope;
import com.ruoyi.project.system.domain.*;
import com.ruoyi.project.system.mapper.*;
import com.ruoyi.project.system.service.ISysEntrustService;
import com.ruoyi.project.system.service.ISysProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 委托方 业务层处理
 *
 * @author ruoyi
 */
@Service
public class SysEntrustServiceImpl implements ISysEntrustService
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

    @Autowired
    private SysEntrustMapper entrustMapper;

    /**
     * 根据条件分页查询委托方数据
     *
     * @param  委托方信息
     * @return 委托方数据集合信息
     */
    @Override
    @DataScope(deptAlias = "d")
    public List<SysEntrust> selectEntrustList(SysEntrust entrust)
    {
        return entrustMapper.selectEntrustList(entrust);
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
     * 查询所有委托方
     *
     * @return 委托方列表
     */
    public List<SysRole> selectRoleAll()
    {
        return roleMapper.selectRoleAll();
    }

    /**
     * 根据用户ID获取委托方选择框列表
     *
     * @param userId 用户ID
     * @return 选中委托方ID列表
     */
    public List<Integer> selectRoleListByUserId(Long userId)
    {
        return roleMapper.selectRoleListByUserId(userId);
    }

    /**
     * 通过委托方ID查询委托方
     *
     * @param entrustId 委托方ID
     * @return 委托方对象信息
     */
    public List<SysEntrust> selectEntrustById(Long entrustId)
    {
        return entrustMapper.selectEntrustById(entrustId);
    }

    /**
     * 校验委托方名称是否唯一
     *
     * @param role 委托方信息
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
     * 校验委托方权限是否唯一
     *
     * @param role 委托方信息
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
     * 校验委托方是否允许操作
     *
     * @param role 委托方信息
     */
    public void checkRoleAllowed(SysRole role)
    {
        if (StringUtils.isNotNull(role.getRoleId()) && role.isAdmin())
        {
            throw new CustomException("不允许操作超级管理员委托方");
        }
    }

    /**
     * 通过委托方ID查询委托方使用数量
     *
     * @param roleId 委托方ID
     * @return 结果
     */
    @Override
    public int countUserRoleByRoleId(Long roleId)
    {
        return userRoleMapper.countUserRoleByRoleId(roleId);
    }

    /**
     * 新增保存委托方信息
     *
     * @param entrust 委托方信息
     * @return 结果
     */
    @Override
    @Transactional
    public int insertEntrust(SysEntrust entrust)
    {
        // 新增委托方信息
        return entrustMapper.insertEntrust(entrust);
    }

    /**
     * 修改保存委托方信息
     *
     * @param entrust 委托方信息
     * @return 结果
     */
    @Override
    @Transactional
    public int updateEntrust(SysEntrust entrust)
    {
        // 修改委托方信息
        return entrustMapper.updateEntrust(entrust);
    }

    @Override
    public int updateRoleStatus(SysRole role) {
        return 0;
    }

    /**
     * 修改委托方状态
     *
     * @param project 委托方信息
     * @return 结果
     */
    public int updateRoleStatus(SysProject project)
    {
        return projectMapper.updateProject(project);
    }

    /**
     * 修改数据权限信息
     *
     * @param role 委托方信息
     * @return 结果
     */
    @Override
    @Transactional
    public int authDataScope(SysRole role)
    {

        // 删除委托方与部门关联
        roleDeptMapper.deleteRoleDeptByRoleId(role.getRoleId());
        // 新增委托方和部门信息（数据权限）
        return insertRoleDept(role);
    }

    /**
     * 新增委托方菜单信息
     *
     * @param role 委托方对象
     */
    public int insertRoleMenu(SysRole role)
    {
        int rows = 1;
        // 新增用户与委托方管理
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
     * 新增委托方部门信息(数据权限)
     *
     * @param role 委托方对象
     */
    public int insertRoleDept(SysRole role)
    {
        int rows = 1;
        // 新增委托方与部门（数据权限）管理
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
     * 通过委托方ID删除委托方
     *
     * @param entrustId 委托方ID
     * @return 结果
     */
    @Override
    public int deleteEntrustById(Long entrustId)
    {
        return entrustMapper.deleteEntrustById(entrustId);
    }

    /**
     * 批量删除委托方信息
     *
     * @param entrustIds 需要删除的委托方ID
     * @return 结果
     */
    public int deleteEntrustByIds(Long[] entrustIds)
    {
        return entrustMapper.deleteEntrustByIds(entrustIds);
    }
}
