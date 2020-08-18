package com.ruoyi.project.house.domain;

import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 未确权房屋信息 h_no_property_house
 * 
 * @author ruoyi
 */
public class NoPropertyHouse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**id*/
    private String id;
    /**项目id*/
    private String projectId;
    /**房屋id*/
    private String houseBaseId;
    /**房号*/
    private String houseNumber;
    /**面积*/
    private String area;
    /**重置价格*/
    private String replacementPrice;
    /**状况修正系数*/
    private String conditionCorrectionFactor;
    /**层高修正系数*/
    private String heightCorrectionFactor;
    /**成新修正系数*/
    private String newCorrectionCoefficient;
    /**评估单价*/
    private String evaluatePrice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getConditionCorrectionFactor() {
        return conditionCorrectionFactor;
    }

    public void setConditionCorrectionFactor(String conditionCorrectionFactor) {
        this.conditionCorrectionFactor = conditionCorrectionFactor;
    }

    public String getHeightCorrectionFactor() {
        return heightCorrectionFactor;
    }

    public void setHeightCorrectionFactor(String heightCorrectionFactor) {
        this.heightCorrectionFactor = heightCorrectionFactor;
    }

    public String getNewCorrectionCoefficient() {
        return newCorrectionCoefficient;
    }

    public void setNewCorrectionCoefficient(String newCorrectionCoefficient) {
        this.newCorrectionCoefficient = newCorrectionCoefficient;
    }

    public String getEvaluatePrice() {
        return evaluatePrice;
    }

    public void setEvaluatePrice(String evaluatePrice) {
        this.evaluatePrice = evaluatePrice;
    }

    public String getReplacementPrice() {
        return replacementPrice;
    }

    public void setReplacementPrice(String replacementPrice) {
        this.replacementPrice = replacementPrice;
    }

    public String getHouseBaseId() {
        return houseBaseId;
    }

    public void setHouseBaseId(String houseBaseId) {
        this.houseBaseId = houseBaseId;
    }
}
