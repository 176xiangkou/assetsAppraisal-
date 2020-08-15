package com.ruoyi.project.house.controller;

import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.house.domain.AttachedPriceHouse;
import com.ruoyi.project.house.domain.DecorateAttachedPriceHouse;
import com.ruoyi.project.house.domain.DecoratePriceHouse;
import com.ruoyi.project.house.service.IAttachedPriceHouseService;
import com.ruoyi.project.house.service.IDecoratePriceHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 二次拆装费用
 * 
 * @author ruoyi
 */
@RestController
@RequestMapping("/house/decorateAttached")
public class DecorateAttachedPriceHouseController extends BaseController
{

    @Autowired
    private IDecoratePriceHouseService DecoratePriceHouseService;
    @Autowired
    private IAttachedPriceHouseService AttachedPriceHouseService;



    /**
     * 根据项目编号获取详细信息
     */
    @GetMapping(value = "/{houseBaseId}")
    public AjaxResult getInfo(@PathVariable String houseBaseId) {
        DecoratePriceHouse decoratePriceHouse = new DecoratePriceHouse();
        decoratePriceHouse.setHouseBaseId(houseBaseId);
        AttachedPriceHouse attachedPriceHouse = new AttachedPriceHouse();
        attachedPriceHouse.setHouseBaseId(houseBaseId);
        DecorateAttachedPriceHouse decorateAttachedPriceHouse = new DecorateAttachedPriceHouse();
        List<DecoratePriceHouse> decoratePriceHouseList = DecoratePriceHouseService.selectDecoratePriceHouseList(decoratePriceHouse);
        List<AttachedPriceHouse> attachedPriceHouseList = AttachedPriceHouseService.selectAttachedPriceHouseList(attachedPriceHouse);
        decorateAttachedPriceHouse.setDecoratePriceHouseList(decoratePriceHouseList);
        decorateAttachedPriceHouse.setAttachedPriceHouseList(attachedPriceHouseList);

        return AjaxResult.success(decorateAttachedPriceHouse);
    }

    /**
     * 变更项目
     */
    @Log(title = "二次拆装费用\n", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DecorateAttachedPriceHouse decorateAttachedPriceHouse) {

        int row = DecoratePriceHouseService.updateDecoratePriceHouse(decorateAttachedPriceHouse.getDecoratePriceHouseList());
        row = AttachedPriceHouseService.updateAttachedPriceHouse(decorateAttachedPriceHouse.getAttachedPriceHouseList());
        return toAjax(row);

    }

}