package com.ruoyi.project.house.service;

import com.ruoyi.project.house.domain.CheckPriceHouse;

import java.util.List;

/**
 * 房屋其他及复核价格信息业务层
 * 
 * @author ruoyi
 */
public interface ICheckPriceHouseService
{
    /**
     * 根据条件分页查询价格数据
     * 
     * @param CheckPriceHouse 复核价格信息
     * @return 价格数据集合信息
     */
    public List<CheckPriceHouse> selectCheckPriceHouseList(CheckPriceHouse CheckPriceHouse);

    /**
     * 通过价格ID查询价格
     * 
     * @param CheckPriceHouseId 价格ID
     * @return 价格对象信息
     */
    public List<CheckPriceHouse> selectCheckPriceHouseById(Long CheckPriceHouseId);




    /**
     * 新增保存复核价格信息
     * 
     * @param CheckPriceHouse 复核价格信息
     * @return 结果
     */
    public int insertCheckPriceHouse(List<CheckPriceHouse> CheckPriceHouse);

    /**
     * 修改保存复核价格信息
     * 
     * @param checkPriceHouseList 复核价格信息
     * @return 结果
     */
    public int updateCheckPriceHouse(List<CheckPriceHouse> checkPriceHouseList);


    /**
     * 通过价格ID删除价格
     * 
     * @param CheckPriceHouseId 价格ID
     * @return 结果
     */
    public int deleteCheckPriceHouseById(Long CheckPriceHouseId);

    /**
     * 批量删除复核价格信息
     * 
     * @param CheckPriceHouseIds 需要删除的价格ID
     * @return 结果
     */
    public int deleteCheckPriceHouseByIds(Long[] CheckPriceHouseIds);
}
