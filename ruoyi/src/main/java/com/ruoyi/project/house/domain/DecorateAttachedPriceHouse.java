package com.ruoyi.project.house.domain;

import com.ruoyi.framework.web.domain.BaseEntity;

import java.util.List;

/**
 * 二次拆装费用
 * 
 * @author ruoyi
 */
public class DecorateAttachedPriceHouse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**attachedPriceHouseList*/
    private List<AttachedPriceHouse> attachedPriceHouseList;
    /**decoratePriceHouseList*/
    private List<DecoratePriceHouse> decoratePriceHouseList;

    public List<AttachedPriceHouse> getAttachedPriceHouseList() {
        return attachedPriceHouseList;
    }

    public void setAttachedPriceHouseList(List<AttachedPriceHouse> attachedPriceHouseList) {
        this.attachedPriceHouseList = attachedPriceHouseList;
    }

    public List<DecoratePriceHouse> getDecoratePriceHouseList() {
        return decoratePriceHouseList;
    }

    public void setDecoratePriceHouseList(List<DecoratePriceHouse> decoratePriceHouseList) {
        this.decoratePriceHouseList = decoratePriceHouseList;
    }
}
