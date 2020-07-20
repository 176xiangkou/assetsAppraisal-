package com.ruoyi.project.house.domain;

import java.util.Date;
import java.util.List;

import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 房产项目基础信息 h_project
 * 
 * @author ruoyi
 */
public class HouseBase extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */

    private Long id;
    /** 项目名称*/
    private String projectName;
    /** 房屋坐落*/
    private String houseLocated;
    /** 房屋产权人*/
    private String propertyOwner;
    /** 产权证编号*/
    private String titleCertificateNumber;
    /** 土地证号*/
    private String landNumber;
    /** 房屋面积*/
    private String floorSpace;
    /** 估价时点*/
    private String evaluateTime;
    /** 承租人*/
    private String tenant;
    /** 记录员*/
    private String registrar;
    /** 签收日期*/
    private Date lodgmentTime;
    /** 评估员*/
    private String evaluator;
    /** 估价师*/
    private String valuer;
    /** 区位基准价*/
    private String referencePrice;
    /** 报告编号*/
    private String reportNumber;
    /** 报告年份*/
    private Date reportDate;
    /** 报告样式*/
    private String reportForm;
    /** 住改非面积*/
    private String zgfArea;
    /** 经营年限*/
    private String manageYear;
    /** 单位简称*/
    private String unitAs;
    /** 土地性质*/
    private String landProperty;
    /** 委托方*/
    private String entrustingParty;
    /** 报告标题*/
    private String reportTitle;
    /** 区位级别*/
    private String regionalLevel;
    /** 结构等级*/
    private String structureLevel;
    /** 层次*/
    private String level;
    /** 朝向*/
    private String toward;
    /** 成套是否*/
    private String isComplete;
    /** 地大于房单价*/
    private String ddyfPrice;
    /** 表格备注*/
    private String tableNote;
    /** 地大于房面积*/
    private String ddyfArea;
    /** 新建不满5年补偿%*/
    private String xjbmwnCompensation;
    /** 土地用途*/
    private String landUse;
    /** 容积率*/
    private String plotratio;
    /** 评估目的*/
    private String evaluationPurpose;
    /** 评估单位*/
    private String assessmentUnit;
    /** 土地重新取得价格*/
    private String landGetPrice;
    /** 备注*/
    private String mark;
    /** 房产基本信息id*/
    private String projectId;
    /** 房产基本信息id*/
    private String landArea;
    /** 房产基本信息id*/
    private String landUseTypy;
    /** 房产基本信息id*/
    private String examinationMember;

    public String getLandArea() {
        return landArea;
    }

    public void setLandArea(String landArea) {
        this.landArea = landArea;
    }

    public String getLandUseTypy() {
        return landUseTypy;
    }

    public void setLandUseTypy(String landUseTypy) {
        this.landUseTypy = landUseTypy;
    }

    public String getExaminationMember() {
        return examinationMember;
    }

    public void setExaminationMember(String examinationMember) {
        this.examinationMember = examinationMember;
    }

    private List<HouseInfo> houseInfo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getHouseLocated() {
        return houseLocated;
    }

    public void setHouseLocated(String houseLocated) {
        this.houseLocated = houseLocated;
    }

    public String getPropertyOwner() {
        return propertyOwner;
    }

    public void setPropertyOwner(String propertyOwner) {
        this.propertyOwner = propertyOwner;
    }

    public String getTitleCertificateNumber() {
        return titleCertificateNumber;
    }

    public void setTitleCertificateNumber(String titleCertificateNumber) {
        this.titleCertificateNumber = titleCertificateNumber;
    }

    public String getLandNumber() {
        return landNumber;
    }

    public void setLandNumber(String landNumber) {
        this.landNumber = landNumber;
    }

    public String getFloorSpace() {
        return floorSpace;
    }

    public void setFloorSpace(String floorSpace) {
        this.floorSpace = floorSpace;
    }

    public String getEvaluateTime() {
        return evaluateTime;
    }

    public void setEvaluateTime(String evaluateTime) {
        this.evaluateTime = evaluateTime;
    }

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public String getRegistrar() {
        return registrar;
    }

    public void setRegistrar(String registrar) {
        this.registrar = registrar;
    }

    public Date getLodgmentTime() {
        return lodgmentTime;
    }

    public void setLodgmentTime(Date lodgmentTime) {
        this.lodgmentTime = lodgmentTime;
    }

    public String getEvaluator() {
        return evaluator;
    }

    public void setEvaluator(String evaluator) {
        this.evaluator = evaluator;
    }

    public String getValuer() {
        return valuer;
    }

    public void setValuer(String valuer) {
        this.valuer = valuer;
    }

    public String getReferencePrice() {
        return referencePrice;
    }

    public void setReferencePrice(String referencePrice) {
        this.referencePrice = referencePrice;
    }

    public String getReportNumber() {
        return reportNumber;
    }

    public void setReportNumber(String reportNumber) {
        this.reportNumber = reportNumber;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getReportForm() {
        return reportForm;
    }

    public void setReportForm(String reportForm) {
        this.reportForm = reportForm;
    }

    public String getZgfArea() {
        return zgfArea;
    }

    public void setZgfArea(String zgfArea) {
        this.zgfArea = zgfArea;
    }

    public String getManageYear() {
        return manageYear;
    }

    public void setManageYear(String manageYear) {
        this.manageYear = manageYear;
    }

    public String getUnitAs() {
        return unitAs;
    }

    public void setUnitAs(String unitAs) {
        this.unitAs = unitAs;
    }

    public String getLandProperty() {
        return landProperty;
    }

    public void setLandProperty(String landProperty) {
        this.landProperty = landProperty;
    }

    public String getEntrustingParty() {
        return entrustingParty;
    }

    public void setEntrustingParty(String entrustingParty) {
        this.entrustingParty = entrustingParty;
    }

    public String getReportTitle() {
        return reportTitle;
    }

    public void setReportTitle(String reportTitle) {
        this.reportTitle = reportTitle;
    }

    public String getRegionalLevel() {
        return regionalLevel;
    }

    public void setRegionalLevel(String regionalLevel) {
        this.regionalLevel = regionalLevel;
    }

    public String getStructureLevel() {
        return structureLevel;
    }

    public void setStructureLevel(String structureLevel) {
        this.structureLevel = structureLevel;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getToward() {
        return toward;
    }

    public void setToward(String toward) {
        this.toward = toward;
    }

    public String getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(String isComplete) {
        this.isComplete = isComplete;
    }

    public String getDdyfPrice() {
        return ddyfPrice;
    }

    public void setDdyfPrice(String ddyfPrice) {
        this.ddyfPrice = ddyfPrice;
    }

    public String getTableNote() {
        return tableNote;
    }

    public void setTableNote(String tableNote) {
        this.tableNote = tableNote;
    }

    public String getDdyfArea() {
        return ddyfArea;
    }

    public void setDdyfArea(String ddyfArea) {
        this.ddyfArea = ddyfArea;
    }

    public String getXjbmwnCompensation() {
        return xjbmwnCompensation;
    }

    public void setXjbmwnCompensation(String xjbmwnCompensation) {
        this.xjbmwnCompensation = xjbmwnCompensation;
    }

    public String getLandUse() {
        return landUse;
    }

    public void setLandUse(String landUse) {
        this.landUse = landUse;
    }

    public String getPlotratio() {
        return plotratio;
    }

    public void setPlotratio(String plotratio) {
        this.plotratio = plotratio;
    }

    public String getEvaluationPurpose() {
        return evaluationPurpose;
    }

    public void setEvaluationPurpose(String evaluationPurpose) {
        this.evaluationPurpose = evaluationPurpose;
    }

    public String getAssessmentUnit() {
        return assessmentUnit;
    }

    public void setAssessmentUnit(String assessmentUnit) {
        this.assessmentUnit = assessmentUnit;
    }

    public String getLandGetPrice() {
        return landGetPrice;
    }

    public void setLandGetPrice(String landGetPrice) {
        this.landGetPrice = landGetPrice;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public List<HouseInfo> getHouseInfo() {
        return houseInfo;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public void setHouseInfo(List<HouseInfo> houseInfo) {
        this.houseInfo = houseInfo;
    }

    @Override
    public String toString() {
        return "HouseBase{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", houseLocated='" + houseLocated + '\'' +
                ", propertyOwner='" + propertyOwner + '\'' +
                ", titleCertificateNumber='" + titleCertificateNumber + '\'' +
                ", landNumber='" + landNumber + '\'' +
                ", floorSpace='" + floorSpace + '\'' +
                ", evaluateTime='" + evaluateTime + '\'' +
                ", tenant='" + tenant + '\'' +
                ", registrar='" + registrar + '\'' +
                ", lodgmentTime=" + lodgmentTime +
                ", evaluator='" + evaluator + '\'' +
                ", valuer='" + valuer + '\'' +
                ", referencePrice='" + referencePrice + '\'' +
                ", reportNumber='" + reportNumber + '\'' +
                ", reportDate=" + reportDate +
                ", reportForm='" + reportForm + '\'' +
                ", zgfArea='" + zgfArea + '\'' +
                ", manageYear='" + manageYear + '\'' +
                ", unitAs='" + unitAs + '\'' +
                ", landProperty='" + landProperty + '\'' +
                ", entrustingParty='" + entrustingParty + '\'' +
                ", reportTitle='" + reportTitle + '\'' +
                ", regionalLevel='" + regionalLevel + '\'' +
                ", structureLevel='" + structureLevel + '\'' +
                ", level='" + level + '\'' +
                ", toward='" + toward + '\'' +
                ", isComplete='" + isComplete + '\'' +
                ", ddyfPrice='" + ddyfPrice + '\'' +
                ", tableNote='" + tableNote + '\'' +
                ", ddyfArea='" + ddyfArea + '\'' +
                ", xjbmwnCompensation='" + xjbmwnCompensation + '\'' +
                ", landUse='" + landUse + '\'' +
                ", plotratio='" + plotratio + '\'' +
                ", evaluationPurpose='" + evaluationPurpose + '\'' +
                ", assessmentUnit='" + assessmentUnit + '\'' +
                ", landGetPrice='" + landGetPrice + '\'' +
                ", mark='" + mark + '\'' +
                ", houseInfo=" + houseInfo +
                '}';
    }
}
