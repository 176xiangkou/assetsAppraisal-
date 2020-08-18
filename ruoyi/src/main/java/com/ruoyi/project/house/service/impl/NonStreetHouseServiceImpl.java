package com.ruoyi.project.house.service.impl;

import com.ruoyi.project.house.domain.NonStreetHouse;
import com.ruoyi.project.house.mapper.NonStreetHouseMapper;
import com.ruoyi.project.house.service.INonStreetHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 非沿街住改非房屋 业务层处理
 *
 * @author ruoyi
 */
@Service
public class NonStreetHouseServiceImpl implements INonStreetHouseService
{


    @Autowired
    private NonStreetHouseMapper nonStreetHouseMapper;

    /**
     * 根据条件分页查询非沿街住改非房屋数据
     *
     * @param NonStreetHouse  非沿街住改非房屋信息
     * @return 非沿街住改非房屋数据集合信息
     */
    @Override
    public List<NonStreetHouse> selectNonStreetHouseList(NonStreetHouse NonStreetHouse)
    {
        return nonStreetHouseMapper.selectNonStreetHouseList(NonStreetHouse);
    }


  

    /**
     * 通过非沿街住改非房屋ID查询非沿街住改非房屋
     *
     * @param NonStreetHouseId 非沿街住改非房屋ID
     * @return 非沿街住改非房屋对象信息
     */
    public List<NonStreetHouse> selectNonStreetHouseById(Long NonStreetHouseId)
    {
        return nonStreetHouseMapper.selectNonStreetHouseById(NonStreetHouseId);
    }



    /**
     * 新增保存非沿街住改非房屋信息
     *
     * @param NonStreetHouse 非沿街住改非房屋信息
     * @return 结果
     */
    @Override
    @Transactional
    public int insertNonStreetHouse(List<NonStreetHouse> NonStreetHouse)
    {
        int row = 0;
        // 新增非沿街住改非房屋信息
        for(NonStreetHouse n : NonStreetHouse){
            row = nonStreetHouseMapper.insertNonStreetHouse(n);
        }
        return row;

    }

    /**
     * 修改保存非沿街住改非房屋信息
     *
     * @param nonStreetHouseList 非沿街住改非房屋信息
     * @return 结果
     */
    @Override
    @Transactional
    public int updateNonStreetHouse(List<NonStreetHouse> nonStreetHouseList)
    {

        // 修改未确权房屋信息
        int row = 0;
        nonStreetHouseMapper.deleteNonStreetHouseByHouseBaseId(nonStreetHouseList.get(0).getHouseBaseId());
        for(NonStreetHouse n : nonStreetHouseList){
            row = nonStreetHouseMapper.insertNonStreetHouse(n);
        }
        return row;

    }

    /**
     * 通过非沿街住改非房屋ID删除非沿街住改非房屋
     *
     * @param NonStreetHouseId 非沿街住改非房屋ID
     * @return 结果
     */
    @Override
    public int deleteNonStreetHouseById(Long NonStreetHouseId)
    {
        return nonStreetHouseMapper.deleteNonStreetHouseById(NonStreetHouseId);
    }

    /**
     * 批量删除非沿街住改非房屋信息
     *
     * @param NonStreetHouseIds 需要删除的非沿街住改非房屋ID
     * @return 结果
     */
    public int deleteNonStreetHouseByIds(Long[] NonStreetHouseIds)
    {
        return nonStreetHouseMapper.deleteNonStreetHouseByIds(NonStreetHouseIds);
    }
}
