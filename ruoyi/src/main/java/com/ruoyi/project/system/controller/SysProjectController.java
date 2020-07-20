package com.ruoyi.project.system.controller;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
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
 * 项目信息
 * 
 * @author ruoyi
 */
@RestController
@RequestMapping("/system/project")
public class SysProjectController extends BaseController
{
    @Autowired
    private ISysRoleService roleService;
    @Autowired
    private ISysProjectService projectService;
    @Autowired
    private ISysEntrustService entrustService;

    @PreAuthorize("@ss.hasPermi('system:project:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysProject project)
    {
        startPage();
        List<SysProject> list = projectService.selectProjectList(project);
        return getDataTable(list);
    }

    @Log(title = "项目管理", businessType = BusinessType.EXPORT)
    @PreAuthorize("@ss.hasPermi('system:role:export')")
    @GetMapping("/export")
    public AjaxResult export(SysRole role)
    {
        List<SysRole> list = roleService.selectRoleList(role);
        ExcelUtil<SysRole> util = new ExcelUtil<SysRole>(SysRole.class);
        return util.exportExcel(list, "项目数据");
    }
    /**
     * 查询所有委托方数据
     */
    @PreAuthorize("@ss.hasPermi('system:project:query')")
    @GetMapping(value = "allEntrust")
    public AjaxResult getAllEntrust()
    {
        return AjaxResult.success(entrustService.selectEntrustList(null));
    }
    /**
     * 根据项目编号获取详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:project:query')")
    @GetMapping(value = "/{projectId}")
    public AjaxResult getInfo(@PathVariable Long projectId)
    {AjaxResult ajax = AjaxResult.success();
        ajax.put(AjaxResult.DATA_TAG, projectService.selectProjectById(projectId));
        ajax.put("entrusts", entrustService.selectEntrustById(null));
        //AjaxResult.success(projectService.selectProjectById(projectId));
        return ajax;
    }

    /**
     * 新增项目
     */
    @PreAuthorize("@ss.hasPermi('system:project:add')")
    @Log(title = "项目管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody SysProject project)
    {
        project.setCreateBy(SecurityUtils.getUsername());
        return toAjax(projectService.insertProject(project));

    }

    /**
     * 修改保存项目
     */
    @PreAuthorize("@ss.hasPermi('system:project:edit')")
    @Log(title = "项目管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody SysProject project)
    {
        project.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(projectService.updateProject(project));
    }

    /**
     * 修改保存数据权限
     */
    @PreAuthorize("@ss.hasPermi('system:role:edit')")
    @Log(title = "项目管理", businessType = BusinessType.UPDATE)
    @PutMapping("/dataScope")
    public AjaxResult dataScope(@RequestBody SysRole role)
    {
        roleService.checkRoleAllowed(role);
        return toAjax(roleService.authDataScope(role));
    }

    /**
     * 状态修改
     */
    @PreAuthorize("@ss.hasPermi('system:project:edit')")
    @Log(title = "项目管理", businessType = BusinessType.UPDATE)
    @PutMapping("/changeStatus")
    public AjaxResult changeStatus(@RequestBody SysRole role)
    {
        roleService.checkRoleAllowed(role);
        role.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(roleService.updateRoleStatus(role));
    }

    /**
     * 删除项目
     */
    @PreAuthorize("@ss.hasPermi('system:project:remove')")
    @Log(title = "项目管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{projectIds}")
    public AjaxResult remove(@PathVariable Long[] projectIds)
    {
        return toAjax(projectService.deleteProjectByIds(projectIds));
    }

    /**
     * 获取项目选择框列表
     */
    @PreAuthorize("@ss.hasPermi('system:role:query')")
    @GetMapping("/optionselect")
    public AjaxResult optionselect()
    {
        return AjaxResult.success(roleService.selectRoleAll());
    }
}