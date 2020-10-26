package com.ruoyi.project.house.mapper;

import java.util.List;

import com.ruoyi.project.house.domain.HouseBase;
import com.ruoyi.project.house.domain.HouseBaseInfo;
import com.ruoyi.project.house.domain.HouseInfo;
import org.apache.ibatis.annotations.Param;

/**
 * 房产基础表 数据层
 *
 * @author ruoyi
 */
public interface HouseMapper
{
    /**
     * 根据条件分页查询房产基本列表
     *
     * @param house 房产基本信息
     * @return 房产基本信息集合信息
     */
    public List<HouseBase> selectHouseList(HouseBase house);
    /**
     * 根据条件分页查询房屋列表
     *
     * @param houseBaseId 房产ID
     * @return 房屋集合信息
     */
    public List<HouseInfo> selectHouseInfoListByProjectId(@Param("houseBaseId") String houseBaseId);


    /**
     * 新增房产基本信息
     *
     * @param house 房产基本信息
     * @return 结果
     */
    public int insertHouse(HouseBase house);

    /**
     * 新增房屋信息
     *
     * @param houseInfo 房屋信息
     * @return 结果
     */
    public int insertHouseInfo(HouseInfo houseInfo);

    /**
     * 新增房产房屋对应信息
     *
     * @param houseBaseInfo 房产房屋对应信息
     * @return 结果
     */
    public int insertHouseBaseInfo(HouseBaseInfo houseBaseInfo);

    /**
     * 修改房产基本信息
     *
     * @param house 房产基本信息
     * @return 结果
     */
    public int updateHouse(HouseBase house);
    /**
     * 修改房屋信息
     *
     * @param houseInfo 房房屋信息
     * @return 结果
     */
    public int updateHouseInfo(HouseInfo houseInfo);


    /**
     * 通过房产基本ID删除房产基本
     *
     * @param houseBaseId 房产基本ID
     * @return 结果
     */
    public int deleteHouseById(@Param("houseBaseId") String houseBaseId);

    /**
     * 通过房产基本ID删除房屋信息
     *
     * @param houseBaseId 房产基本ID
     * @return 结果
     */
    public int deleteHouseInfoById(@Param("houseBaseId") String houseBaseId);
    /**
     * 通过房产基本ID删除房产房屋关系信息
     *
     * @param houseBaseId 房产基本ID
     * @return 结果
     */
    public int deleteProjectHouseById(@Param("houseBaseId") String houseBaseId);
    /**
     * 通过房产基本ID查询房产房屋关系信息
     *
     * @param houseBaseId 房产基本ID
     * @return 结果
     */
    public List<HouseBaseInfo> selectProjectHouseById(@Param("houseBaseId") String houseBaseId);

}
