package com.ruoyi.project.house.domain;

import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 房屋其他及复核价格信息 h_check_price_house
 * 
 * @author ruoyi
 */
public class CheckPriceHouse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**id*/
    private String id;
    /**菜单名称*/
    private String categoryName;
    /**名称*/
    private String name;
    /**单价*/
    private String unitPrice;
    /**公式*/
    private String formula;
    /**数量*/
    private String number;
   /**成新率*/
    private String  newRate;
    /**评估值*/
    private String assessmentValue;
    /**序号*/
    private String serialNumber;
    /**单位*/
    private String unit;
    /**项目id*/
    private String projectId;
    /**房屋id*/
    private String houseBaseId;

    public String getHouseBaseId() {
        return houseBaseId;
    }

    public void setHouseBaseId(String houseBaseId) {
        this.houseBaseId = houseBaseId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNewRate() {
        return newRate;
    }

    public void setNewRate(String newRate) {
        this.newRate = newRate;
    }

    public String getAssessmentValue() {
        return assessmentValue;
    }

    public void setAssessmentValue(String assessmentValue) {
        this.assessmentValue = assessmentValue;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
}
