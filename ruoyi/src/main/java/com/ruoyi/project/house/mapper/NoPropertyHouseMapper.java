package com.ruoyi.project.house.mapper;

import com.ruoyi.project.house.domain.NoPropertyHouse;

import java.util.List;

/**
 * 委托方表 数据层
 * 
 * @author ruoyi
 */
public interface NoPropertyHouseMapper
{
    /**
     * 根据条件分页查询未确权房屋数据
     *
     * @param NoPropertyHouse 未确权房屋信息
     * @return 未确权房屋数据集合信息
     */
    public List<NoPropertyHouse> selectNoPropertyHouseList(NoPropertyHouse NoPropertyHouse);

    /**
     * 通过未确权房屋ID查询未确权房屋
     *
     * @param NoPropertyHouseId 未确权房屋ID
     * @return 未确权房屋对象信息
     */
    public List<NoPropertyHouse> selectNoPropertyHouseById(Long NoPropertyHouseId);




    /**
     * 新增保存未确权房屋信息
     *
     * @param NoPropertyHouse 未确权房屋信息
     * @return 结果
     */
    public int insertNoPropertyHouse(NoPropertyHouse NoPropertyHouse);

    /**
     * 修改保存未确权房屋信息
     *
     * @param NoPropertyHouse 未确权房屋信息
     * @return 结果
     */
    public int updateNoPropertyHouse(NoPropertyHouse NoPropertyHouse);


    /**
     * 通过未确权房屋ID删除未确权房屋
     *
     * @param id 未确权房屋ID
     * @return 结果
     */
    public int deleteNoPropertyHouseById(Long id);
    /**
     * 通过房屋ID删除未确权房屋
     *
     * @param houseBaseId
     * @return 结果
     */
    public int deleteNoPropertyHouseByHouseBaseId(String houseBaseId);

    /**
     * 批量删除未确权房屋信息
     *
     * @param NoPropertyHouseIds 需要删除的未确权房屋ID
     * @return 结果
     */
    public int deleteNoPropertyHouseByIds(Long[] NoPropertyHouseIds);
}
