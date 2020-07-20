package com.ruoyi.project.system.service;

import com.ruoyi.project.system.domain.SysEntrust;
import com.ruoyi.project.system.domain.SysProject;
import com.ruoyi.project.system.domain.SysRole;

import java.util.List;
import java.util.Set;

/**
 * 委托方业务层
 * 
 * @author ruoyi
 */
public interface ISysEntrustService
{
    /**
     * 根据条件分页查询委托方数据
     * 
     * @param entrust 委托方信息
     * @return 委托方数据集合信息
     */
    public List<SysEntrust> selectEntrustList(SysEntrust entrust);

    /**
     * 根据用户ID查询委托方
     * 
     * @param userId 用户ID
     * @return 权限列表
     */
    public Set<String> selectRolePermissionByUserId(Long userId);

    /**
     * 查询所有委托方
     * 
     * @return 委托方列表
     */
    public List<SysRole> selectRoleAll();

    /**
     * 根据用户ID获取委托方选择框列表
     * 
     * @param userId 用户ID
     * @return 选中委托方ID列表
     */
    public List<Integer> selectRoleListByUserId(Long userId);

    /**
     * 通过委托方ID查询委托方
     * 
     * @param entrustId 委托方ID
     * @return 委托方对象信息
     */
    public List<SysEntrust> selectEntrustById(Long entrustId);

    /**
     * 校验委托方名称是否唯一
     * 
     * @param role 委托方信息
     * @return 结果
     */
    public String checkRoleNameUnique(SysRole role);

    /**
     * 校验委托方权限是否唯一
     * 
     * @param role 委托方信息
     * @return 结果
     */
    public String checkRoleKeyUnique(SysRole role);

    /**
     * 校验委托方是否允许操作
     * 
     * @param role 委托方信息
     */
    public void checkRoleAllowed(SysRole role);

    /**
     * 通过委托方ID查询委托方使用数量
     * 
     * @param roleId 委托方ID
     * @return 结果
     */
    public int countUserRoleByRoleId(Long roleId);

    /**
     * 新增保存委托方信息
     * 
     * @param entrust 委托方信息
     * @return 结果
     */
    public int insertEntrust(SysEntrust entrust);

    /**
     * 修改保存委托方信息
     * 
     * @param entrust 委托方信息
     * @return 结果
     */
    public int updateEntrust(SysEntrust entrust);

    /**
     * 修改委托方状态
     * 
     * @param role 委托方信息
     * @return 结果
     */
    public int updateRoleStatus(SysRole role);

    /**
     * 修改数据权限信息
     * 
     * @param role 委托方信息
     * @return 结果
     */
    public int authDataScope(SysRole role);

    /**
     * 通过委托方ID删除委托方
     * 
     * @param entrustId 委托方ID
     * @return 结果
     */
    public int deleteEntrustById(Long entrustId);

    /**
     * 批量删除委托方信息
     * 
     * @param entrustIds 需要删除的委托方ID
     * @return 结果
     */
    public int deleteEntrustByIds(Long[] entrustIds);
}
