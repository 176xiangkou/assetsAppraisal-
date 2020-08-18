package com.ruoyi.project.house.controller;

import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.house.domain.NoPropertyHouse;
import com.ruoyi.project.house.domain.NoPropertyStreeHouse;
import com.ruoyi.project.house.domain.NonStreetHouse;
import com.ruoyi.project.house.service.INoPropertyHouseService;
import com.ruoyi.project.house.service.INonStreetHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 未确权房屋/非沿街
 * 
 * @author ruoyi
 */
@RestController
@RequestMapping("/house/noPropertyStree")
public class NoPropertyStreeHouseController extends BaseController
{
    @Autowired
    private INoPropertyHouseService NoPropertyHouseService;
    @Autowired
    private INonStreetHouseService NonStreetHouseService;


    /**
     * 根据项目编号获取详细信息
     */
    @GetMapping(value = "/{houseBaseId}")
    public AjaxResult getInfo(@PathVariable String houseBaseId)
    {
        NoPropertyHouse noPropertyHouse = new NoPropertyHouse();
        noPropertyHouse.setHouseBaseId(houseBaseId);
        NonStreetHouse nonStreetHouse = new NonStreetHouse();
        nonStreetHouse.setHouseBaseId(houseBaseId);
        NoPropertyStreeHouse noPropertyStreeHouse = new NoPropertyStreeHouse();
        List<NoPropertyHouse> noPropertyHouseList = NoPropertyHouseService.selectNoPropertyHouseList(noPropertyHouse);
        List<NonStreetHouse> nonStreetHouseList = NonStreetHouseService.selectNonStreetHouseList(nonStreetHouse);
        noPropertyStreeHouse.setNoPropertyHouseList(noPropertyHouseList);
        noPropertyStreeHouse.setNonStreetHouseList(nonStreetHouseList);

        return AjaxResult.success(noPropertyStreeHouse);
    }

    /**
     * 变更项目
     */
    @Log(title = "未确权房屋管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add( @RequestBody NoPropertyStreeHouse noPropertyStreeHouse)
    {

        int row = NoPropertyHouseService.updateNoPropertyHouse(noPropertyStreeHouse.getNoPropertyHouseList());
          row = NonStreetHouseService.updateNonStreetHouse(noPropertyStreeHouse.getNonStreetHouseList());
        return toAjax(row);

    }


}