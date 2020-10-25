package com.ruoyi.project.house.mapper;

import com.ruoyi.project.house.domain.DecoratePriceHouse;
import com.ruoyi.project.system.domain.SysPrice;

import java.util.List;

/**
 *   数据层
 * 
 * @author ruoyi
 */
public interface DecoratePriceHouseMapper
{
    /**
     * 根据条件分页查询价格数据
     *
     * @param DecoratePriceHouse 房装装修价格信息
     * @return 价格数据集合信息
     */
    public List<DecoratePriceHouse> selectDecoratePriceHouseList(DecoratePriceHouse DecoratePriceHouse);

    /**
     * 通过价格ID查询价格
     *
     * @param DecoratePriceHouseId 价格ID
     * @return 价格对象信息
     */
    public List<DecoratePriceHouse> selectDecoratePriceHouseById(Long DecoratePriceHouseId);




    /**
     * 新增保存房装装修价格信息
     *
     * @param DecoratePriceHouse 房装装修价格信息
     * @return 结果
     */
    public int insertDecoratePriceHouse(DecoratePriceHouse DecoratePriceHouse);

    /**
     * 修改保存房装装修价格信息
     *
     * @param DecoratePriceHouse 房装装修价格信息
     * @return 结果
     */
    public int updateDecoratePriceHouse(DecoratePriceHouse DecoratePriceHouse);

    /**
     * 通过房屋ID删除未确权房屋
     *
     * @param houseBaseId
     * @return 结果
     */
    public int deleteDecoratePriceHouseByHouseBaseId(String houseBaseId);

    /**
     * 通过价格ID删除价格
     *
     * @param DecoratePriceHouseId 价格ID
     * @return 结果
     */
    public int deleteDecoratePriceHouseById(Long DecoratePriceHouseId);

    /**
     * 批量删除房装装修价格信息
     *
     * @param DecoratePriceHouseIds 需要删除的价格ID
     * @return 结果
     */
    public int deleteDecoratePriceHouseByIds(Long[] DecoratePriceHouseIds);
}
