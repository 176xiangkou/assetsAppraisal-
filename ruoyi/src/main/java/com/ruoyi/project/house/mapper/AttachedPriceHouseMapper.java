package com.ruoyi.project.house.mapper;

import com.ruoyi.project.house.domain.AttachedPriceHouse;

import java.util.List;

/**
 * 委托方表 数据层
 * 
 * @author ruoyi
 */
public interface AttachedPriceHouseMapper
{
    /**
     * 根据条件分页查询价格数据
     *
     * @param attachedPriceHouse 装修价格信息
     * @return 价格数据集合信息
     */
    public List<AttachedPriceHouse> selectAttachedPriceHouseList(AttachedPriceHouse attachedPriceHouse);

    /**
     * 通过价格ID查询价格
     *
     * @param attachedPriceHouseId 价格ID
     * @return 价格对象信息
     */
    public List<AttachedPriceHouse> selectAttachedPriceHouseById(Long attachedPriceHouseId);




    /**
     * 新增保存装修价格信息
     *
     * @param attachedPriceHouse 装修价格信息
     * @return 结果
     */
    public int insertAttachedPriceHouse(AttachedPriceHouse attachedPriceHouse);

    /**
     * 修改保存装修价格信息
     *
     * @param attachedPriceHouse 装修价格信息
     * @return 结果
     */
    public int updateAttachedPriceHouse(AttachedPriceHouse attachedPriceHouse);

    /**
     * 通过房屋ID删除未确权房屋
     *
     * @param houseBaseId
     * @return 结果
     */
    public int deleteAttachedPriceHouseByHouseBaseId(String houseBaseId);
    /**
     * 通过价格ID删除价格
     *
     * @param attachedPriceHouseId 价格ID
     * @return 结果
     */
    public int deleteAttachedPriceHouseById(Long attachedPriceHouseId);

    /**
     * 批量删除装修价格信息
     *
     * @param attachedPriceHouseIds 需要删除的价格ID
     * @return 结果
     */
    public int deleteAttachedPriceHouseByIds(Long[] attachedPriceHouseIds);
}
