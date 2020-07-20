package com.ruoyi.project.system.mapper;

import com.ruoyi.project.system.domain.SysEntrust;
import com.ruoyi.project.system.domain.SysProject;
import com.ruoyi.project.system.domain.SysRole;

import java.util.List;

/**
 * 委托方表 数据层
 * 
 * @author ruoyi
 */
public interface SysEntrustMapper
{
    /**
     * 根据条件分页查询委托方数据
     * 
     * @param entrust 委托方信息
     * @return 委托方数据集合信息
     */
    List<SysEntrust> selectEntrustList(SysEntrust entrust);

    /**
     * 根据用户ID查询委托方
     * 
     * @param userId 用户ID
     * @return 委托方列表
     */
    public List<SysRole> selectRolePermissionByUserId(Long userId);

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
     * 根据用户ID查询委托方
     * 
     * @param userName 用户名
     * @return 委托方列表
     */
    public List<SysRole> selectRolesByUserName(String userName);

    /**
     * 校验委托方名称是否唯一
     * 
     * @param roleName 委托方名称
     * @return 委托方信息
     */
    public SysRole checkRoleNameUnique(String roleName);

    /**
     * 校验委托方权限是否唯一
     * 
     * @param roleKey 委托方权限
     * @return 委托方信息
     */
    public SysRole checkRoleKeyUnique(String roleKey);

    /**
     * 修改委托方信息
     * 
     * @param entrust 委托方信息
     * @return 结果
     */
    public int updateEntrust(SysEntrust entrust);

    /**
     * 新增委托方信息
     * 
     * @param entrust 委托方信息
     * @return 结果
     */
    public int insertEntrust(SysEntrust entrust);

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
