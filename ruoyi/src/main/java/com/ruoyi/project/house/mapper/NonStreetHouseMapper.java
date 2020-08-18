package com.ruoyi.project.house.mapper;

import com.ruoyi.project.house.domain.NonStreetHouse;
import com.ruoyi.project.system.domain.SysPrice;

import java.util.List;

/**
 * 委托方表 数据层
 * 
 * @author ruoyi
 */
public interface NonStreetHouseMapper
{
    /**
     * 根据条件分页查询非沿街住改非房屋数据
     *
     * @param NonStreetHouse 非沿街住改非房屋
     * @return 价格数据集合信息
     */
    public List<NonStreetHouse> selectNonStreetHouseList(NonStreetHouse NonStreetHouse);

    /**
     * 通过价格ID查询非沿街住改非房屋
     *
     * @param NonStreetHouseId 价格ID
     * @return 价格对象信息
     */
    public List<NonStreetHouse> selectNonStreetHouseById(Long NonStreetHouseId);




    /**
     * 新增保存非沿街住改非房屋
     *
     * @param NonStreetHouse 非沿街住改非房屋
     * @return 结果
     */
    public int insertNonStreetHouse(NonStreetHouse NonStreetHouse);

    /**
     * 修改保存非沿街住改非房屋
     *
     * @param NonStreetHouse 非沿街住改非房屋
     * @return 结果
     */
    public int updateNonStreetHouse(NonStreetHouse NonStreetHouse);


    /**
     * 通过ID删除非沿街住改非房屋
     *
     * @param NonStreetHouseId 价格ID
     * @return 结果
     */
    public int deleteNonStreetHouseById(Long NonStreetHouseId);
    /**
     * 通过ID删除非沿街住改非房屋
     *
     * @param houseBaseId 价格ID
     * @return 结果
     */
    public int deleteNonStreetHouseByHouseBaseId(String houseBaseId);

    /**
     * 批量删除非沿街住改非房屋
     *
     * @param NonStreetHouseIds 需要删除的价格ID
     * @return 结果
     */
    public int deleteNonStreetHouseByIds(Long[] NonStreetHouseIds);
}
