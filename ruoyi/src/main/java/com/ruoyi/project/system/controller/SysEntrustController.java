package com.ruoyi.project.system.controller;

import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.domain.SysEntrust;
import com.ruoyi.project.system.domain.SysProject;
import com.ruoyi.project.system.domain.SysRole;
import com.ruoyi.project.system.service.ISysEntrustService;
import com.ruoyi.project.system.service.ISysProjectService;
import com.ruoyi.project.system.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 委托方信息
 * 
 * @author ruoyi
 */
@RestController
@RequestMapping("/system/entrust")
public class SysEntrustController extends BaseController
{
    @Autowired
    private ISysRoleService roleService;
    @Autowired
    private ISysEntrustService entrustService;
    @Autowired
    private ISysProjectService projectService;

    @PreAuthorize("@ss.hasPermi('system:entrust:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysEntrust entrust)
    {
        startPage();
        List<SysEntrust> list = entrustService.selectEntrustList(entrust);
        return getDataTable(list);
    }

    @Log(title = "委托方管理", businessType = BusinessType.EXPORT)
    @PreAuthorize("@ss.hasPermi('system:role:export')")
    @GetMapping("/export")
    public AjaxResult export(SysRole role)
    {
        List<SysRole> list = roleService.selectRoleList(role);
        ExcelUtil<SysRole> util = new ExcelUtil<SysRole>(SysRole.class);
        return util.exportExcel(list, "委托方数据");
    }


    /**
     * 根据委托方编号获取详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:entrust:query')")
    @GetMapping(value = "/{entrustId}")
    public AjaxResult getInfo(@PathVariable Long entrustId)
    {
        List<SysEntrust> sysEntrustList = entrustService.selectEntrustById(entrustId);
        return AjaxResult.success(sysEntrustList.get(0));
    }
    /**
     * 新增委托方
     */
    @PreAuthorize("@ss.hasPermi('system:entrust:add')")
    @Log(title = "委托方管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody SysEntrust entrust)
    {
        entrust.setCreateBy(SecurityUtils.getUsername());
        return toAjax(entrustService.insertEntrust(entrust));

    }

    /**
     * 修改保存委托方
     */
    @PreAuthorize("@ss.hasPermi('system:entrust:edit')")
    @Log(title = "委托方管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody SysEntrust entrust)
    {
        entrust.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(entrustService.updateEntrust(entrust));
    }

    /**
     * 修改保存数据权限
     */
    @PreAuthorize("@ss.hasPermi('system:role:edit')")
    @Log(title = "委托方管理", businessType = BusinessType.UPDATE)
    @PutMapping("/dataScope")
    public AjaxResult dataScope(@RequestBody SysRole role)
    {
        roleService.checkRoleAllowed(role);
        return toAjax(roleService.authDataScope(role));
    }

    /**
     * 状态修改
     */
    @PreAuthorize("@ss.hasPermi('system:role:edit')")
    @Log(title = "委托方管理", businessType = BusinessType.UPDATE)
    @PutMapping("/changeStatus")
    public AjaxResult changeStatus(@RequestBody SysRole role)
    {
        roleService.checkRoleAllowed(role);
        role.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(roleService.updateRoleStatus(role));
    }

    /**
     * 删除委托方
     */
    @PreAuthorize("@ss.hasPermi('system:entrust:remove')")
    @Log(title = "委托方管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{entrustIds}")
    public AjaxResult remove(@PathVariable Long[] entrustIds)
    {
        return toAjax(entrustService.deleteEntrustByIds(entrustIds));
    }

    /**
     * 获取委托方选择框列表
     */
    @PreAuthorize("@ss.hasPermi('system:role:query')")
    @GetMapping("/optionselect")
    public AjaxResult optionselect()
    {
        return AjaxResult.success(roleService.selectRoleAll());
    }
}