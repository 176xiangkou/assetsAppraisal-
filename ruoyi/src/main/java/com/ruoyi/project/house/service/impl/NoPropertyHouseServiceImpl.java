package com.ruoyi.project.house.service.impl; 
import com.ruoyi.project.house.domain.NoPropertyHouse;
import com.ruoyi.project.house.mapper.NoPropertyHouseMapper;
import com.ruoyi.project.house.service.INoPropertyHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 未确权房屋 业务层处理
 *
 * @author ruoyi
 */
@Service
public class NoPropertyHouseServiceImpl implements INoPropertyHouseService
{


    @Autowired
    private NoPropertyHouseMapper noPropertyHouseMapper;

    /**
     * 根据条件分页查询未确权房屋数据
     *
     * @param NoPropertyHouse  未确权房屋信息
     * @return 未确权房屋数据集合信息
     */
    @Override
    public List<NoPropertyHouse> selectNoPropertyHouseList(NoPropertyHouse NoPropertyHouse)
    {
        return noPropertyHouseMapper.selectNoPropertyHouseList(NoPropertyHouse);
    }


  

    /**
     * 通过未确权房屋ID查询未确权房屋
     *
     * @param NoPropertyHouseId 未确权房屋ID
     * @return 未确权房屋对象信息
     */
    public List<NoPropertyHouse> selectNoPropertyHouseById(Long NoPropertyHouseId)
    {
        return noPropertyHouseMapper.selectNoPropertyHouseById(NoPropertyHouseId);
    }





    /**
     * 变更保存未确权房屋信息
     *
     * @param noPropertyHouseList 未确权房屋信息
     * @return 结果
     */
    @Override
    @Transactional
    public int updateNoPropertyHouse(List<NoPropertyHouse> noPropertyHouseList)
    {
        // 修改未确权房屋信息
        int row = 0;
        noPropertyHouseMapper.deleteNoPropertyHouseByHouseBaseId(noPropertyHouseList.get(0).getHouseBaseId());
        for(NoPropertyHouse n : noPropertyHouseList){
            row = noPropertyHouseMapper.insertNoPropertyHouse(n);
        }
        return row;
    }

    /**
     * 通过未确权房屋ID删除未确权房屋
     *
     * @param NoPropertyHouseId 未确权房屋ID
     * @return 结果
     */
    @Override
    public int deleteNoPropertyHouseById(Long NoPropertyHouseId)
    {
        return noPropertyHouseMapper.deleteNoPropertyHouseById(NoPropertyHouseId);
    }

    /**
     * 批量删除未确权房屋信息
     *
     * @param NoPropertyHouseIds 需要删除的未确权房屋ID
     * @return 结果
     */
    public int deleteNoPropertyHouseByIds(Long[] NoPropertyHouseIds)
    {
        return noPropertyHouseMapper.deleteNoPropertyHouseByIds(NoPropertyHouseIds);
    }
}
