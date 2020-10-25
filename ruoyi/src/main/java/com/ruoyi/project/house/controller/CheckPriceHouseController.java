package com.ruoyi.project.house.controller;

import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.house.domain.CheckPriceHouse;
import com.ruoyi.project.house.service.ICheckPriceHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 复核价格名称信息
 * 
 * @author ruoyi
 */
@RestController
@RequestMapping("/house/check")
public class CheckPriceHouseController extends BaseController
{
    @Autowired
    private ICheckPriceHouseService CheckPriceHouseService;


    /**
     * 根据项目编号获取详细信息
     */
    @GetMapping(value = "/{houseBaseId}")
    public AjaxResult getInfo(@PathVariable String houseBaseId)
    {
        CheckPriceHouse checkPriceHouse = new CheckPriceHouse();
        checkPriceHouse.setHouseBaseId(houseBaseId);
        List<CheckPriceHouse> checkPriceHouseList = CheckPriceHouseService.selectCheckPriceHouseList(checkPriceHouse);
        return AjaxResult.success(checkPriceHouseList);
    }



    /**
     * 修改保存项目
     */
    @Log(title = "复核价格管理", businessType = BusinessType.UPDATE)
    @PostMapping
    public AjaxResult edit( @RequestBody List<CheckPriceHouse> checkPriceHouseList)
    {
        return toAjax(CheckPriceHouseService.updateCheckPriceHouse(checkPriceHouseList));
    }




}