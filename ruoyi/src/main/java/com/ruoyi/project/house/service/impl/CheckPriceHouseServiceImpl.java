package com.ruoyi.project.house.service.impl;
 
import com.ruoyi.project.house.domain.CheckPriceHouse;
import com.ruoyi.project.house.service.ICheckPriceHouseService;
import com.ruoyi.project.house.mapper.CheckPriceHouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 复核价格 业务层处理
 *
 * @author ruoyi
 */
@Service
public class CheckPriceHouseServiceImpl implements ICheckPriceHouseService
{


    @Autowired
    private CheckPriceHouseMapper checkPriceHouseMapper;

    /**
     * 根据条件分页查询复核价格数据
     *
     * @param CheckPriceHouse  复核价格信息
     * @return 复核价格数据集合信息
     */
    @Override
    public List<CheckPriceHouse> selectCheckPriceHouseList(CheckPriceHouse CheckPriceHouse)
    {
        return checkPriceHouseMapper.selectCheckPriceHouseList(CheckPriceHouse);
    }


  

    /**
     * 通过复核价格ID查询复核价格
     *
     * @param CheckPriceHouseId 复核价格ID
     * @return 复核价格对象信息
     */
    public List<CheckPriceHouse> selectCheckPriceHouseById(Long CheckPriceHouseId)
    {
        return checkPriceHouseMapper.selectCheckPriceHouseById(CheckPriceHouseId);
    }



    /**
     * 新增保存复核价格信息
     *
     * @param CheckPriceHouse 复核价格信息
     * @return 结果
     */
    @Override
    @Transactional
    public int insertCheckPriceHouse(List<CheckPriceHouse> CheckPriceHouse)
    {

        int row = 0;
        // 新增复核价格信息
        for(CheckPriceHouse n : CheckPriceHouse){
            row = checkPriceHouseMapper.insertCheckPriceHouse(n);
        }
        return row;

    }

    /**
     * 修改保存复核价格信息
     *
     * @param checkPriceHouseList 复核价格信息
     * @return 结果
     */
    @Override
    @Transactional
    public int updateCheckPriceHouse(List<CheckPriceHouse> checkPriceHouseList)
    {
        int row = 0;
        if(checkPriceHouseList != null && !("").equals(checkPriceHouseList.get(0).getHouseBaseId())) {
            checkPriceHouseMapper.deleteCheckPriceHouseByHouseBaseId(checkPriceHouseList.get(0).getHouseBaseId());
        }
        for(CheckPriceHouse n : checkPriceHouseList){
            row = checkPriceHouseMapper.insertCheckPriceHouse(n);
        }
        return row;
    }

    /**
     * 通过复核价格ID删除复核价格
     *
     * @param CheckPriceHouseId 复核价格ID
     * @return 结果
     */
    @Override
    public int deleteCheckPriceHouseById(Long CheckPriceHouseId)
    {
        return checkPriceHouseMapper.deleteCheckPriceHouseById(CheckPriceHouseId);
    }

    /**
     * 批量删除复核价格信息
     *
     * @param CheckPriceHouseIds 需要删除的复核价格ID
     * @return 结果
     */
    public int deleteCheckPriceHouseByIds(Long[] CheckPriceHouseIds)
    {
        return checkPriceHouseMapper.deleteCheckPriceHouseByIds(CheckPriceHouseIds);
    }
}
