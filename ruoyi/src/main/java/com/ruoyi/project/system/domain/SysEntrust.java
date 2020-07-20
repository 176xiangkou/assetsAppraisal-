package com.ruoyi.project.system.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.aspectj.lang.annotation.Excel.ColumnType;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 委托方表 sys_project
 * 
 * @author ruoyi
 */
public class SysEntrust extends BaseEntity
{
    private static final long serialVersionUID = 1L;

   

    /** 委托方ID */
    @Excel(name = "委托方序号", cellType = ColumnType.NUMERIC)
    private Long entrustId;

    /** 委托方名称 */
    @Excel(name = "委托方名称")
    private String entrustName;

    public Long getEntrustId() {
        return entrustId;
    }

    public void setEntrustId(Long entrustId) {
        this.entrustId = entrustId;
    }

    public String getEntrustName() {
        return entrustName;
    }

    public void setEntrustName(String entrustName) {
        this.entrustName = entrustName;
    }

    @Override
    public String toString() {
        return "SysEntrust{" +
                "entrustId=" + entrustId +
                ", entrusttName='" + entrustName + '\'' +
                '}';
    }
}
