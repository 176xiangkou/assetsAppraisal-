package com.ruoyi.project.house.controller;

import java.util.List;

import com.ruoyi.project.house.domain.HouseBase;
import com.ruoyi.project.house.service.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 房屋信息
 * 
 * @author ruoyi
 */
@RestController
@RequestMapping("/house/base")
public class HouseController extends BaseController
{
    @Autowired
    private IHouseService houseService;
 

    /**
     * 查询房产列表
     */
    @PreAuthorize("@ss.hasPermi('house:base:list')")
    @GetMapping("/list")
    public TableDataInfo list(@Validated @RequestBody HouseBase house)
    {
        startPage();
        List<HouseBase> list = houseService.selectHouseList(house);
        return getDataTable(list);
    }

    /**
     * 根据projectId查询房产信息
     */
    @PreAuthorize("@ss.hasPermi('house:base:getHouseBaseById')")
    @GetMapping("/getHouseBaseById")
    public TableDataInfo getHouseBaseById(String projectId)
    {
        AjaxResult ajax = AjaxResult.success();
        HouseBase house = new HouseBase();
        house.setProjectId(projectId);
        List<HouseBase> list = houseService.selectHouseList(house);
        return getDataTable(list);
    }
    /**
     * 新增房产
     */
    @PreAuthorize("@ss.hasPermi('house:base:add')")
    @Log(title = "房产管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HouseBase house)
    {
        house.setCreateBy(SecurityUtils.getUsername());
        return toAjax(houseService.insertHouse(house));
    }

    /**
     * 修改房产
     */
    @PreAuthorize("@ss.hasPermi('house:base:edit')")
    @Log(title = "房产管理", businessType = BusinessType.UPDATE)
    @PutMapping("/updateHouse")
    public AjaxResult edit( @RequestBody HouseBase house)
    {
        house.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(houseService.updateHouse(house));
    }

    /**
     * 删除房产
     */
    @PreAuthorize("@ss.hasPermi('house:base:remove')")
    @Log(title = "房产管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{projectId}")
    public AjaxResult remove(@PathVariable String projectId)
    {
        return toAjax(houseService.deleteHouseById(projectId));
    }

}