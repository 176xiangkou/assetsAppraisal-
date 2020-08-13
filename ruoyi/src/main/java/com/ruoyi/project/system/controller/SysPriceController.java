package com.ruoyi.project.system.controller;

import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.domain.SysPrice;
import com.ruoyi.project.system.domain.SysProject;
import com.ruoyi.project.system.domain.SysRole;
import com.ruoyi.project.system.service.ISysPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 价格名称信息
 * 
 * @author ruoyi
 */
@RestController
@RequestMapping("/system/price")
public class SysPriceController extends BaseController
{
    @Autowired
    private ISysPriceService priceService;

    @PreAuthorize("@ss.hasPermi('system:price:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysPrice price)
    {
        startPage();
        List<SysPrice> list = priceService.selectPriceList(price);
        return getDataTable(list);
    }

    @Log(title = "价格管理", businessType = BusinessType.EXPORT)
    @PreAuthorize("@ss.hasPermi('system:price:export')")
    @GetMapping("/export")
    public AjaxResult export(SysPrice price)
    {
        List<SysPrice> list = priceService.selectPriceList(price);
        ExcelUtil<SysPrice> util = new ExcelUtil<SysPrice>(SysPrice.class);
        return util.exportExcel(list, "价格数据");
    }
    /**
     * 查询所有数据
     */
    @PreAuthorize("@ss.hasPermi('system:price:query')")
    @GetMapping(value = "allPrice")
    public AjaxResult getAllEntrust()
    {
        return AjaxResult.success(priceService.selectPriceList(null));
    }
    /**
     * 根据项目编号获取详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:project:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable Long id)
    {

        return AjaxResult.success(priceService.selectPriceById(id).get(0));
    }

    /**
     * 新增项目
     */
    @PreAuthorize("@ss.hasPermi('system:price:add')")
    @Log(title = "价格管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody SysPrice price)
    {
        price.setCreateBy(SecurityUtils.getUsername());
        return toAjax(priceService.insertPrice(price));

    }

    /**
     * 修改保存项目
     */
    @PreAuthorize("@ss.hasPermi('system:price:edit')")
    @Log(title = "价格管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody SysPrice price)
    {
        price.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(priceService.updatePrice(price));
    }





    /**
     * 删除项目
     */
    @PreAuthorize("@ss.hasPermi('system:price:remove')")
    @Log(title = "项目管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(priceService.deletePriceByIds(ids));
    }


}