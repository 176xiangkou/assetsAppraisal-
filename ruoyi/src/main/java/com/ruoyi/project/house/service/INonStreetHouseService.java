package com.ruoyi.project.house.service;

import com.ruoyi.project.house.domain.NonStreetHouse; 

import java.util.List;

/**
 * 非沿街住改非房屋业务层
 * 
 * @author ruoyi
 */
public interface INonStreetHouseService
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
     * @param nonStreetHouseList 非沿街住改非房屋
     * @return 结果
     */
    public int insertNonStreetHouse(List<NonStreetHouse> nonStreetHouseList);

    /**
     * 修改保存非沿街住改非房屋
     * 
     * @param NonStreetHouse 非沿街住改非房屋
     * @return 结果
     */
    public int updateNonStreetHouse(List<NonStreetHouse> NonStreetHouse);


    /**
     * 通过ID删除非沿街住改非房屋
     * 
     * @param NonStreetHouseId 价格ID
     * @return 结果
     */
    public int deleteNonStreetHouseById(Long NonStreetHouseId);

    /**
     * 批量删除非沿街住改非房屋
     * 
     * @param NonStreetHouseIds 需要删除的价格ID
     * @return 结果
     */
    public int deleteNonStreetHouseByIds(Long[] NonStreetHouseIds);
}
