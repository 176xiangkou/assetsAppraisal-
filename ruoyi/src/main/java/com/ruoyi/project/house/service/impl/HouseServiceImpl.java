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
            List<HouseInfo> list = houseMapper.selectHouseInfoListByProjectId(houseBaseList.get(i).getHouseBaseId());
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
        String houseBaseId = UUID.randomUUID().toString();
        house.setHouseBaseId(houseBaseId);
        int rows = 0;
        if("1".equals(house.getOnBaseInfo())){
             rows = houseMapper.insertHouse(house);
        }
        if("0".equals(house.getOnBaseInfo())) {
            List<HouseInfo> houseInfoList = house.getHouseInfo();
            if (houseInfoList.size() > 0) {
                for (HouseInfo h : houseInfoList) {
                    String houseInfoId = UUID.randomUUID().toString();
                    h.setHouseInfoId(houseInfoId);
                    // 新增房屋信息
                    int row = houseMapper.insertHouseInfo(h);
                    HouseBaseInfo houseBaseInfo = new HouseBaseInfo();
                    houseBaseInfo.setHouseBaseId(houseBaseId);
                    houseBaseInfo.setHouseId(houseInfoId);
                    rows = houseMapper.insertHouseBaseInfo(houseBaseInfo);
                }
            }

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
        int row = 0;
        if("1".equals(house.getOnBaseInfo())){
             row =    houseMapper.updateHouse(house);
        }
        if("0".equals(house.getOnBaseInfo())) {
            List <HouseBaseInfo> projectHouseList = houseMapper.selectProjectHouseById(house.getHouseBaseId());
            if(projectHouseList.size() > 0) {
                String houseId = projectHouseList.get(0).getHouseId();
                houseMapper.deleteHouseInfoById(house.getHouseBaseId());
                List<HouseInfo> list = house.getHouseInfo();
                for (HouseInfo h : list) {
                    h.setHouseInfoId(houseId);
                    row = houseMapper.insertHouseInfo(h);
                }
            }
        }
        return row;
    }


    /**
     * 通过房产基本ID删除房产基本
     *
     * @param houseBaseId 房产基本ID
     * @return 结果
     */
    @Override
    public int deleteHouseById(String houseBaseId)
    {
        int row = houseMapper.deleteHouseById(houseBaseId);
        houseMapper.deleteHouseInfoById(houseBaseId);
        houseMapper.deleteProjectHouseById(houseBaseId);
        return  row;
    }



}
