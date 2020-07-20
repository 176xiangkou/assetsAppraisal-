package com.ruoyi.project.house.domain;

import com.ruoyi.framework.web.domain.BaseEntity;

import java.util.Date;

/**
 * 房屋信息 h_house
 * 
 * @author ruoyi
 */
public class HouseInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private String id;
    /** 房号 */
    private String roomNumber;
    /** 面积 */
    private String area;
    /** 住改非面积 */
    private String zgfArea;
    /** 基准价格 */
    private String benchmark;
    /** 成套修正系数 */
    private String setCorrectionFactor;
    /** 结构修正系数 */
    private String structuralCorrectionFactor;
    /** 成新修正系数 */
    private String newCorrectionFactor;
    /** 朝向修正系数 */
    private String orientationCorrectionFactor;
    /** 层次修正系数 */
    private String levelCorrectionFactor;
    /** 实体因素修正系数 */
    private String solidFactorCorrectionFactor;
    /** 评估单价 */
    private String evaluateUnitPrice;
    /** 产权人补偿 */
    private String tompensationPropertyOwner;
    /** 承租人补偿 */
    private String tenantCompensation;
    /** 基准价格vo */
    private String benchmarkVO;
    /** 商业用途修正系数 */
    private String commercialUseCorrectionFactor;
    /** 商业街道路线修正系数 */
    private String commercialStreetCorrectionFactor;
    /** 商业用途实体修正系数 */
    private String commercialEntityCorrectionFactor;
    /** 营业用房单价 */
    private String unitPrice;
    /** 非住宅加权 */
    private String nonresidentialWeightingw;
    /** 营业用房加权单价 */
    private String weightedUnitPriceBusinessPremises;
    /** 房屋id */
    private String houseInfoId;

    public String getHouseInfoId() {
        return houseInfoId;
    }

    public void setHouseInfoId(String houseInfoId) {
        this.houseInfoId = houseInfoId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getZgfArea() {
        return zgfArea;
    }

    public void setZgfArea(String zgfArea) {
        this.zgfArea = zgfArea;
    }

    public String getBenchmark() {
        return benchmark;
    }

    public void setBenchmark(String benchmark) {
        this.benchmark = benchmark;
    }

    public String getSetCorrectionFactor() {
        return setCorrectionFactor;
    }

    public void setSetCorrectionFactor(String setCorrectionFactor) {
        this.setCorrectionFactor = setCorrectionFactor;
    }

    public String getStructuralCorrectionFactor() {
        return structuralCorrectionFactor;
    }

    public void setStructuralCorrectionFactor(String structuralCorrectionFactor) {
        this.structuralCorrectionFactor = structuralCorrectionFactor;
    }

    public String getNewCorrectionFactor() {
        return newCorrectionFactor;
    }

    public void setNewCorrectionFactor(String newCorrectionFactor) {
        this.newCorrectionFactor = newCorrectionFactor;
    }

    public String getOrientationCorrectionFactor() {
        return orientationCorrectionFactor;
    }

    public void setOrientationCorrectionFactor(String orientationCorrectionFactor) {
        this.orientationCorrectionFactor = orientationCorrectionFactor;
    }

    public String getLevelCorrectionFactor() {
        return levelCorrectionFactor;
    }

    public void setLevelCorrectionFactor(String levelCorrectionFactor) {
        this.levelCorrectionFactor = levelCorrectionFactor;
    }

    public String getSolidFactorCorrectionFactor() {
        return solidFactorCorrectionFactor;
    }

    public void setSolidFactorCorrectionFactor(String solidFactorCorrectionFactor) {
        this.solidFactorCorrectionFactor = solidFactorCorrectionFactor;
    }

    public String getEvaluateUnitPrice() {
        return evaluateUnitPrice;
    }

    public void setEvaluateUnitPrice(String evaluateUnitPrice) {
        this.evaluateUnitPrice = evaluateUnitPrice;
    }

    public String getTompensationPropertyOwner() {
        return tompensationPropertyOwner;
    }

    public void setTompensationPropertyOwner(String tompensationPropertyOwner) {
        this.tompensationPropertyOwner = tompensationPropertyOwner;
    }

    public String getTenantCompensation() {
        return tenantCompensation;
    }

    public void setTenantCompensation(String tenantCompensation) {
        this.tenantCompensation = tenantCompensation;
    }

    public String getBenchmarkVO() {
        return benchmarkVO;
    }

    public void setBenchmarkVO(String benchmarkVO) {
        this.benchmarkVO = benchmarkVO;
    }

    public String getCommercialUseCorrectionFactor() {
        return commercialUseCorrectionFactor;
    }

    public void setCommercialUseCorrectionFactor(String commercialUseCorrectionFactor) {
        this.commercialUseCorrectionFactor = commercialUseCorrectionFactor;
    }

    public String getCommercialStreetCorrectionFactor() {
        return commercialStreetCorrectionFactor;
    }

    public void setCommercialStreetCorrectionFactor(String commercialStreetCorrectionFactor) {
        this.commercialStreetCorrectionFactor = commercialStreetCorrectionFactor;
    }

    public String getCommercialEntityCorrectionFactor() {
        return commercialEntityCorrectionFactor;
    }

    public void setCommercialEntityCorrectionFactor(String commercialEntityCorrectionFactor) {
        this.commercialEntityCorrectionFactor = commercialEntityCorrectionFactor;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getNonresidentialWeightingw() {
        return nonresidentialWeightingw;
    }

    public void setNonresidentialWeightingw(String nonresidentialWeightingw) {
        this.nonresidentialWeightingw = nonresidentialWeightingw;
    }

    public String getWeightedUnitPriceBusinessPremises() {
        return weightedUnitPriceBusinessPremises;
    }

    public void setWeightedUnitPriceBusinessPremises(String weightedUnitPriceBusinessPremises) {
        this.weightedUnitPriceBusinessPremises = weightedUnitPriceBusinessPremises;
    }

    @Override
    public String toString() {
        return "HouseInfo{" +
                "id='" + id + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", area='" + area + '\'' +
                ", zgfArea='" + zgfArea + '\'' +
                ", benchmark='" + benchmark + '\'' +
                ", setCorrectionFactor='" + setCorrectionFactor + '\'' +
                ", structuralCorrectionFactor='" + structuralCorrectionFactor + '\'' +
                ", newCorrectionFactor='" + newCorrectionFactor + '\'' +
                ", orientationCorrectionFactor='" + orientationCorrectionFactor + '\'' +
                ", levelCorrectionFactor='" + levelCorrectionFactor + '\'' +
                ", solidFactorCorrectionFactor='" + solidFactorCorrectionFactor + '\'' +
                ", evaluateUnitPrice='" + evaluateUnitPrice + '\'' +
                ", tompensationPropertyOwner='" + tompensationPropertyOwner + '\'' +
                ", tenantCompensation='" + tenantCompensation + '\'' +
                ", benchmarkVO='" + benchmarkVO + '\'' +
                ", commercialUseCorrectionFactor='" + commercialUseCorrectionFactor + '\'' +
                ", commercialStreetCorrectionFactor='" + commercialStreetCorrectionFactor + '\'' +
                ", commercialEntityCorrectionFactor='" + commercialEntityCorrectionFactor + '\'' +
                ", unitPrice='" + unitPrice + '\'' +
                ", nonresidentialWeightingw='" + nonresidentialWeightingw + '\'' +
                ", weightedUnitPriceBusinessPremises='" + weightedUnitPriceBusinessPremises + '\'' +
                '}';
    }
}
