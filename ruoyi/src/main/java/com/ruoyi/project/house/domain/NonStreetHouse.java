package com.ruoyi.project.house.domain;

import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 非沿街住改非房屋 h_non_street_house
 * 
 * @author ruoyi
 */
public class NonStreetHouse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**id*/
    private String id;
    /**房号*/
    private String houseNumber;
    /**住非改面积S3面积*/
    private String nonRedevelopedArea;
    /**经营年限*/
    private String operationsDuration;
    /**非沿街住改非定额补助标准*/
    private String nonStreetResidents;
    /**住非改增加补偿金额*/
    private String  increaseAmountCompensation;
    /**项目id*/
    private String projectId;
    /**房屋id*/
    private String houseBaseId;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getNonRedevelopedArea() {
        return nonRedevelopedArea;
    }

    public void setNonRedevelopedArea(String nonRedevelopedArea) {
        this.nonRedevelopedArea = nonRedevelopedArea;
    }

    public String getOperationsDuration() {
        return operationsDuration;
    }

    public void setOperationsDuration(String operationsDuration) {
        this.operationsDuration = operationsDuration;
    }

    public String getNonStreetResidents() {
        return nonStreetResidents;
    }

    public void setNonStreetResidents(String nonStreetResidents) {
        this.nonStreetResidents = nonStreetResidents;
    }

    public String getIncreaseAmountCompensation() {
        return increaseAmountCompensation;
    }

    public void setIncreaseAmountCompensation(String increaseAmountCompensation) {
        this.increaseAmountCompensation = increaseAmountCompensation;
    }

    public String getHouseBaseId() {
        return houseBaseId;
    }

    public void setHouseBaseId(String houseBaseId) {
        this.houseBaseId = houseBaseId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
}
