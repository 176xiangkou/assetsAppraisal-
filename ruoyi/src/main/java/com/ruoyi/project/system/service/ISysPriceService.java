package com.ruoyi.project.system.service;

import com.ruoyi.project.system.domain.SysPrice;
import com.ruoyi.project.system.domain.SysPrice;
import com.ruoyi.project.system.domain.SysRole;

import java.util.List;
import java.util.Set;

/**
 * 价格名称业务层
 * 
 * @author ruoyi
 */
public interface ISysPriceService
{
    /**
     * 根据条件分页查询价格数据
     * 
     * @param price 价格信息
     * @return 价格数据集合信息
     */
    public List<SysPrice> selectPriceList(SysPrice price);

    /**
     * 通过价格ID查询价格
     * 
     * @param PriceId 价格ID
     * @return 价格对象信息
     */
    public List<SysPrice> selectPriceById(Long PriceId);




    /**
     * 新增保存价格信息
     * 
     * @param Price 价格信息
     * @return 结果
     */
    public int insertPrice(SysPrice Price);

    /**
     * 修改保存价格信息
     * 
     * @param Price 价格信息
     * @return 结果
     */
    public int updatePrice(SysPrice Price);


    /**
     * 通过价格ID删除价格
     * 
     * @param PriceId 价格ID
     * @return 结果
     */
    public int deletePriceById(Long PriceId);

    /**
     * 批量删除价格信息
     * 
     * @param PriceIds 需要删除的价格ID
     * @return 结果
     */
    public int deletePriceByIds(Long[] PriceIds);
}
