package com.ruoyi.project.house.service;

import java.util.List;

import com.ruoyi.project.house.domain.HouseBase;

/**
 * 房产基本信息  业务层
 * 
 * @author ruoyi
 */
public interface IHouseService
{
    /**
     * 根据条件分页查询房产基本列表
     * 
     * @param house 房产基本信息
     * @return 房产基本信息集合信息
     */
    public List<HouseBase> selectHouseList(HouseBase house);


    /**
     * 新增房产基本信息
     * 
     * @param house 房产基本信息
     * @return 结果
     */
    public int insertHouse(HouseBase house);

    /**
     * 修改房产基本信息
     * 
     * @param house 房产基本信息
     * @return 结果
     */
    public int updateHouse(HouseBase house);


    /**
     * 通过房产基本ID删除房产基本
     * 
     * @param houseId 房产基本ID
     * @return 结果
     */
    public int deleteHouseById(String houseId);

}
