package com.ruoyi.project.house.controller;

import java.util.List;

import com.ruoyi.project.house.domain.HouseBase;
import com.ruoyi.project.house.domain.HouseInfo;
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
     * 查询用户
     */
    @PreAuthorize("@ss.hasPermi('house:base:getUser')")
    @GetMapping("/getUser")
    public String getUser()
    {
        return SecurityUtils.getUsername();
    }
    /**
     * 根据projectId查询房产列表
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
     * 根据houseBaseId查询房产信息
     */
    @PreAuthorize("@ss.hasPermi('house:base:getHouseBaseByHouseBaseId')")
    @GetMapping("/getHouseBaseByHouseBaseId")
    public AjaxResult getHouseBaseByHouseBaseId(String houseBaseId)
    {
        AjaxResult ajax = AjaxResult.success();
        HouseBase house = new HouseBase();
        house.setHouseBaseId(houseBaseId);
        List<HouseBase> list = houseService.selectHouseList(house);
        ajax.put("house",list.get(0));
        return  ajax;
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
        return AjaxResult.success(houseService.insertHouse(house));
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
        return AjaxResult.success(houseService.updateHouse(house));
    }

    /**
     * 删除房产
     */
    @PreAuthorize("@ss.hasPermi('house:base:remove')")
    @Log(title = "房产管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{houseBaseId}")
    public AjaxResult remove(@PathVariable String houseBaseId)
    {
        return AjaxResult.success(houseService.deleteHouseById(houseBaseId));
    }

    /**
     * 根据houseBaseId获取房屋面积总和
     */
    @PreAuthorize("@ss.hasPermi('house:base:getHouseBaseArea')")
    @GetMapping("/getHouseBaseArea")
    public AjaxResult getHouseBaseArea(String houseBaseId)
    {
        AjaxResult ajax = AjaxResult.success();
        HouseBase house = new HouseBase();
        house.setHouseBaseId(houseBaseId);
        List<HouseBase> list = houseService.selectHouseList(house);

          List<HouseInfo> houseInfoList = list.get(0).getHouseInfo();
        double sumCount = 0;
        double zgf = 0;
        for(HouseInfo n : houseInfoList){
            if(n.getArea() != null && !"".equals(n.getArea())){
                sumCount = sumCount + Double.parseDouble(n.getArea());
            }
            if(n.getZgfArea() != null && !"".equals(n.getZgfArea())){
                zgf = zgf + Double.parseDouble(n.getZgfArea());
            }
        }
        ajax.put("sumCount",sumCount);
        ajax.put("zgf",zgf);
        return  ajax;
    }

}
