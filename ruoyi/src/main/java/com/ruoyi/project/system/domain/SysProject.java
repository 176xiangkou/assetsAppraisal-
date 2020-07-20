package com.ruoyi.project.system.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.aspectj.lang.annotation.Excel.ColumnType;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 项目表 sys_project
 * 
 * @author ruoyi
 */
public class SysProject extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 项目ID */
    @Excel(name = "项目序号", cellType = ColumnType.NUMERIC)
    private Long projectId;

    /** 委托方ID */
    @Excel(name = "委托方序号", cellType = ColumnType.NUMERIC)
    private Long entrustId;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projectName;

    /** 牵头人 */
    @Excel(name = "牵头人")
    private String initiator;

    /** 技术负责人 */
    @Excel(name = "技术负责人")
    private String technicalDirector;

    /** 图像复核 */
    @Excel(name = "图像复核")
    private String drawingReview;

    /** 委托方名称 */
    @Excel(name = "委托方名称")
    private String entrustName;

    /** 创建人 */
    @Excel(name = "创建人")
    private String entrustCreateBy;

    /** 创建时间 */
    @Excel(name = "创建时间")
    private String entrustCreateTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getEntrustName() {
        return entrustName;
    }

    public void setEntrustName(String entrustName) {
        this.entrustName = entrustName;
    }

    public String getEntrustCreateBy() {
        return entrustCreateBy;
    }

    public void setEntrustCreateBy(String entrustCreateBy) {
        this.entrustCreateBy = entrustCreateBy;
    }

    public String getEntrustCreateTime() {
        return entrustCreateTime;
    }

    public void setEntrustCreateTime(String entrustCreateTime) {
        this.entrustCreateTime = entrustCreateTime;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getEntrustId() {
        return entrustId;
    }

    public void setEntrustId(Long entrustId) {
        this.entrustId = entrustId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getInitiator() {
        return initiator;
    }

    public void setInitiator(String initiator) {
        this.initiator = initiator;
    }

    public String getTechnicalDirector() {
        return technicalDirector;
    }

    public void setTechnicalDirector(String technicalDirector) {
        this.technicalDirector = technicalDirector;
    }

    public String getDrawingReview() {
        return drawingReview;
    }

    public void setDrawingReview(String drawingReview) {
        this.drawingReview = drawingReview;
    }

    public SysProject()
    {

    }

    @Override
    public String toString() {
        return "SysProject{" +
                "projectId=" + projectId +
                ", entrustId=" + entrustId +
                ", projectName='" + projectName + '\'' +
                ", initiator='" + initiator + '\'' +
                ", technicalDirector='" + technicalDirector + '\'' +
                ", drawingReview='" + drawingReview + '\'' +
                ", entrustName='" + entrustName + '\'' +
                ", entrustCreateBy='" + entrustCreateBy + '\'' +
                ", entrustCreateTime='" + entrustCreateTime + '\'' +
                '}';
    }
}
