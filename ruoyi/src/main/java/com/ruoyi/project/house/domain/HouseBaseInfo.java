package com.ruoyi.project.house.domain;

/**
 * 用户登录对象
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
