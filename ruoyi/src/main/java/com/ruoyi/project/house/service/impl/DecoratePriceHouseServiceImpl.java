package com.ruoyi.project.house.service.impl;

import com.ruoyi.project.house.domain.DecoratePriceHouse;
import com.ruoyi.project.house.mapper.DecoratePriceHouseMapper;
import com.ruoyi.project.house.service.IDecoratePriceHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 房装装修价格 业务层处理
 *
 * @author ruoyi
 */
@Service
public class DecoratePriceHouseServiceImpl implements IDecoratePriceHouseService
{


    @Autowired
    private DecoratePriceHouseMapper decoratePriceHouseMapper;

    /**
     * 根据条件分页查询房装装修价格数据
     *
     * @param DecoratePriceHouse  房装装修价格信息
     * @return 房装装修价格数据集合信息
     */
    @Override
    public List<DecoratePriceHouse> selectDecoratePriceHouseList(DecoratePriceHouse DecoratePriceHouse)
    {
        return decoratePriceHouseMapper.selectDecoratePriceHouseList(DecoratePriceHouse);
    }


  

    /**
     * 通过房装装修价格ID查询房装装修价格
     *
     * @param DecoratePriceHouseId 房装装修价格ID
     * @return 房装装修价格对象信息
     */
    public List<DecoratePriceHouse> selectDecoratePriceHouseById(Long DecoratePriceHouseId)
    {
        return decoratePriceHouseMapper.selectDecoratePriceHouseById(DecoratePriceHouseId);
    }



    /**
     * 新增保存房装装修价格信息
     *
     * @param DecoratePriceHouse 房装装修价格信息
     * @return 结果
     */
    @Override
    @Transactional
    public int insertDecoratePriceHouse(List<DecoratePriceHouse> DecoratePriceHouse)
    {
        int row = 0;
        // 新增房装装修价格信息
        for(DecoratePriceHouse n : DecoratePriceHouse){
            row = decoratePriceHouseMapper.insertDecoratePriceHouse(n);
        }
        return row;

    }

    /**
     * 修改保存房装装修价格信息
     *
     * @param decoratePriceHouseList 房装装修价格信息
     * @return 结果
     */
    @Override
    @Transactional
    public int updateDecoratePriceHouse(List<DecoratePriceHouse> decoratePriceHouseList)
    {
        int row = 0;
        if(decoratePriceHouseList != null && !("").equals(decoratePriceHouseList.get(0).getHouseBaseId())) {
            decoratePriceHouseMapper.deleteDecoratePriceHouseByHouseBaseId(decoratePriceHouseList.get(0).getHouseBaseId());
        }
        for(DecoratePriceHouse n : decoratePriceHouseList){
            row = decoratePriceHouseMapper.insertDecoratePriceHouse(n);
        }
        return row;
    }

    /**
     * 通过房装装修价格ID删除房装装修价格
     *
     * @param DecoratePriceHouseId 房装装修价格ID
     * @return 结果
     */
    @Override
    public int deleteDecoratePriceHouseById(Long DecoratePriceHouseId)
    {
        return decoratePriceHouseMapper.deleteDecoratePriceHouseById(DecoratePriceHouseId);
    }

    /**
     * 批量删除房装装修价格信息
     *
     * @param DecoratePriceHouseIds 需要删除的房装装修价格ID
     * @return 结果
     */
    public int deleteDecoratePriceHouseByIds(Long[] DecoratePriceHouseIds)
    {
        return decoratePriceHouseMapper.deleteDecoratePriceHouseByIds(DecoratePriceHouseIds);
    }
}
