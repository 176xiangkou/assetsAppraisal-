package com.ruoyi.project.system.service.impl;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.exception.CustomException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.aspectj.lang.annotation.DataScope;
import com.ruoyi.project.system.domain.*;
import com.ruoyi.project.system.mapper.*;
import com.ruoyi.project.system.service.ISysPriceService;
import com.ruoyi.project.system.service.ISysPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 价格 业务层处理
 *
 * @author ruoyi
 */
@Service
public class SysPriceServiceImpl implements ISysPriceService
{


    @Autowired
    private SysPriceMapper priceMapper;

    /**
     * 根据条件分页查询价格数据
     *
     * @param price  价格信息
     * @return 价格数据集合信息
     */
    @Override
    public List<SysPrice> selectPriceList(SysPrice price)
    {
        return priceMapper.selectPriceList(price);
    }


  

    /**
     * 通过价格ID查询价格
     *
     * @param priceId 价格ID
     * @return 价格对象信息
     */
    public List<SysPrice> selectPriceById(Long priceId)
    {
        return priceMapper.selectPriceById(priceId);
    }



    /**
     * 新增保存价格信息
     *
     * @param Price 价格信息
     * @return 结果
     */
    @Override
    @Transactional
    public int insertPrice(SysPrice Price)
    {
        // 新增价格信息
        return priceMapper.insertPrice(Price);
    }

    /**
     * 修改保存价格信息
     *
     * @param Price 价格信息
     * @return 结果
     */
    @Override
    @Transactional
    public int updatePrice(SysPrice Price)
    {
        // 修改价格信息
        return priceMapper.updatePrice(Price);
    }

    /**
     * 通过价格ID删除价格
     *
     * @param priceId 价格ID
     * @return 结果
     */
    @Override
    public int deletePriceById(Long priceId)
    {
        return priceMapper.deletePriceById(priceId);
    }

    /**
     * 批量删除价格信息
     *
     * @param priceIds 需要删除的价格ID
     * @return 结果
     */
    public int deletePriceByIds(Long[] priceIds)
    {
        return priceMapper.deletePriceByIds(priceIds);
    }
}
