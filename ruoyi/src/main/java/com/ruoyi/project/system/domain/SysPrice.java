package com.ruoyi.project.system.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.aspectj.lang.annotation.Excel.ColumnType;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 委托方表 sys_project
 * 
 * @author ruoyi
 */
public class SysPrice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

   

    /** id */
    private Long id;
    /** 委托方ID */
    @Excel(name = "价格" )
    private String price;

    /** 委托方名称 */
    @Excel(name = "名称")
    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SysPrice{" +
                "id=" + id +
                ", price='" + price + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
