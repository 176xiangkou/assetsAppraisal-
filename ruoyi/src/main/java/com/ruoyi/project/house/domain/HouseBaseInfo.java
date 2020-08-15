package com.ruoyi.project.house.domain;

/**
 * 房产房屋对应表 h_projecthouse
 * 
 * @author ruoyi
 */
public class HouseBaseInfo
{
    /**
     * id
     */
    private int id;

    /**
     * 房产基本信息id
     */
    private String houseBaseId;

    /**
     * 房屋id
     */
    private String houseId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHouseBaseId() {
        return houseBaseId;
    }

    public void setHouseBaseId(String houseBaseId) {
        this.houseBaseId = houseBaseId;
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }
}
