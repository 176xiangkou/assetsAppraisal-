package com.ruoyi.project.house.service.impl;

import com.ruoyi.project.house.domain.AttachedPriceHouse;
import com.ruoyi.project.house.service.IAttachedPriceHouseService;
import com.ruoyi.project.house.mapper.AttachedPriceHouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 房屋附属 业务层处理
 *
 * @author ruoyi
 */
@Service
public class AttachedPriceHouseServiceImpl implements IAttachedPriceHouseService
{


    @Autowired
    private AttachedPriceHouseMapper attachedPriceHouseMapper;

    /**
     * 根据条件分页查询房屋附属数据
     *
     * @param AttachedPriceHouse  房屋附属信息
     * @return 房屋附属数据集合信息
     */
    @Override
    public List<AttachedPriceHouse> selectAttachedPriceHouseList(AttachedPriceHouse AttachedPriceHouse)
    {
        return attachedPriceHouseMapper.selectAttachedPriceHouseList(AttachedPriceHouse);
    }


  

    /**
     * 通过房屋附属ID查询房屋附属
     *
     * @param AttachedPriceHouseId 房屋附属ID
     * @return 房屋附属对象信息
     */
    public List<AttachedPriceHouse> selectAttachedPriceHouseById(Long AttachedPriceHouseId)
    {
        return attachedPriceHouseMapper.selectAttachedPriceHouseById(AttachedPriceHouseId);
    }



    /**
     * 新增保存房屋附属信息
     *
     * @param AttachedPriceHouse 房屋附属信息
     * @return 结果
     */
    @Override
    @Transactional
    public int insertAttachedPriceHouse(List<AttachedPriceHouse> AttachedPriceHouse)
    {
        int row = 0;
        // 新增复核价格信息
        for(AttachedPriceHouse n : AttachedPriceHouse){
            row =  attachedPriceHouseMapper.insertAttachedPriceHouse(n);
        }
        return row;


    }

    /**
     * 修改保存房屋附属信息
     *
     * @param attachedPriceHouseList 房屋附属信息
     * @return 结果
     */
    @Override
    @Transactional
    public int updateAttachedPriceHouse(List<AttachedPriceHouse> attachedPriceHouseList)
    {
        int row = 0;
        if(attachedPriceHouseList != null && !("").equals(attachedPriceHouseList.get(0).getHouseBaseId())) {
            attachedPriceHouseMapper.deleteAttachedPriceHouseByHouseBaseId(attachedPriceHouseList.get(0).getHouseBaseId());
        }
        for(AttachedPriceHouse n : attachedPriceHouseList){
            row = attachedPriceHouseMapper.insertAttachedPriceHouse(n);
        }
        return row;
    }

    /**
     * 通过房屋附属ID删除房屋附属
     *
     * @param AttachedPriceHouseId 房屋附属ID
     * @return 结果
     */
    @Override
    public int deleteAttachedPriceHouseById(Long AttachedPriceHouseId)
    {
        return attachedPriceHouseMapper.deleteAttachedPriceHouseById(AttachedPriceHouseId);
    }

    /**
     * 批量删除房屋附属信息
     *
     * @param AttachedPriceHouseIds 需要删除的房屋附属ID
     * @return 结果
     */
    public int deleteAttachedPriceHouseByIds(Long[] AttachedPriceHouseIds)
    {
        return attachedPriceHouseMapper.deleteAttachedPriceHouseByIds(AttachedPriceHouseIds);
    }
}
