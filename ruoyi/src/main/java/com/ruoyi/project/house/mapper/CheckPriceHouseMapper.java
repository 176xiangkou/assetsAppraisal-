package com.ruoyi.project.house.mapper;

import com.ruoyi.project.house.domain.CheckPriceHouse;
import com.ruoyi.project.system.domain.SysPrice;

import java.util.List;

/**
 * 委托方表 数据层
 * 
 * @author ruoyi
 */
public interface CheckPriceHouseMapper
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
    public int insertCheckPriceHouse(CheckPriceHouse CheckPriceHouse);

    /**
     * 修改保存复核价格信息
     *
     * @param CheckPriceHouse 复核价格信息
     * @return 结果
     */
    public int updateCheckPriceHouse(CheckPriceHouse CheckPriceHouse);
    /**
     * 通过房屋ID删除未确权房屋
     *
     * @param houseBaseId
     * @return 结果
     */
    public int deleteCheckPriceHouseByHouseBaseId(String houseBaseId);

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
