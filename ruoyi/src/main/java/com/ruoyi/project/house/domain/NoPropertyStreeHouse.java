package com.ruoyi.project.house.domain;

import com.ruoyi.framework.web.domain.BaseEntity;

import java.util.List;

/**
 * 未确权房屋/非沿街往改非
 * 
 * @author ruoyi
 */
public class NoPropertyStreeHouse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**nonStreetHouseList*/
    private List<NonStreetHouse> nonStreetHouseList;
    /**noPropertyHouseList*/
    private List<NoPropertyHouse> noPropertyHouseList;

    public List<NonStreetHouse> getNonStreetHouseList() {
        return nonStreetHouseList;
    }

    public void setNonStreetHouseList(List<NonStreetHouse> nonStreetHouseList) {
        this.nonStreetHouseList = nonStreetHouseList;
    }

    public List<NoPropertyHouse> getNoPropertyHouseList() {
        return noPropertyHouseList;
    }

    public void setNoPropertyHouseList(List<NoPropertyHouse> noPropertyHouseList) {
        this.noPropertyHouseList = noPropertyHouseList;
    }
}
