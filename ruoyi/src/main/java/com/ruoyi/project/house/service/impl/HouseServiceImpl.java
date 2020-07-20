package com.ruoyi.project.house.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ruoyi.project.house.domain.HouseBase;
import com.ruoyi.project.house.domain.HouseBaseInfo;
import com.ruoyi.project.house.domain.HouseInfo;
import com.ruoyi.project.house.mapper.HouseMapper;
import com.ruoyi.project.house.service.IHouseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.project.system.service.ISysConfigService;
import com.ruoyi.project.system.service.ISysUserService;

/**
 * 房产基本 业务层处理
 * 
 * @author ruoyi
 */
@Service
public class HouseServiceImpl implements IHouseService
{
    private static final Logger log = LoggerFactory.getLogger(HouseServiceImpl.class);

    @Autowired
    private HouseMapper houseMapper; 

    @Autowired
    private ISysConfigService configService;

    /**
     * 根据条件分页查询房产基本列表
     *
     * @param house 房产基本信息
     * @return 房产基本信息集合信息
     */
    public List<HouseBase> selectHouseList(HouseBase house)
    {
        List<HouseBase> houseBaseList = houseMapper.selectHouseList(house);
        for(int i = 0;i < houseBaseList.size();i ++ ){
            List<HouseInfo> list = houseMapper.selectHouseInfoListByProjectId(houseBaseList.get(i).getProjectId());
             houseBaseList.get(i).setHouseInfo(list);
        }
        return houseBaseList;
    }


    /**
     * 新增房产基本信息
     *
     * @param house 房产基本信息
     * @return 结果
     */
    public int insertHouse(HouseBase house)
    {
        // 新增房产基本信息
        String projectId = UUID.randomUUID().toString();
        house.setProjectId(projectId);
        int rows = houseMapper.insertHouse(house);
        List<HouseInfo> houseInfoList = house.getHouseInfo();
        for(HouseInfo h : houseInfoList){
            String houseInfoId = UUID.randomUUID().toString();
            h.setHouseInfoId(houseInfoId);
            // 新增房fa信息
            int row = houseMapper.insertHouseInfo(h);
            HouseBaseInfo houseBaseInfo = new HouseBaseInfo();
            houseBaseInfo.setProjectId(projectId);
            houseBaseInfo.setHouseId(houseInfoId);
            houseMapper.insertHouseBaseInfo(houseBaseInfo);
        }

        return rows;
    }

    /**
     * 修改保存房产基本信息
     * 
     * @param house 房产基本信息
     * @return 结果
     */
    @Override
    @Transactional
    public int updateHouse(HouseBase house)
    {
        return houseMapper.updateHouse(house);
    }


    /**
     * 通过房产基本ID删除房产基本
     * 
     * @param projectId 房产基本ID
     * @return 结果
     */
    @Override
    public int deleteHouseById(String projectId)
    {
        return houseMapper.deleteHouseById(projectId);
    }



}
