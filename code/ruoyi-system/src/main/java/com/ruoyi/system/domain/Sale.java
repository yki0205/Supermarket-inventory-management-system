package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 销售记录对象 sale
 * 
 * @author aa
 * @date 2025-01-03
 */
public class Sale extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long saleId;

    /** 商品编码 */
    @Excel(name = "商品编码")
    private String commodityCode;

    /** 销售时间 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "销售时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date date;

    /** 销售数量 */
    @Excel(name = "销售数量")
    private Long number;

    /** 销售总价 */
    @Excel(name = "销售总价")
    private BigDecimal totalPrice;

    /** 销售单价 */
    @Excel(name = "销售单价")
    private BigDecimal unitPrice;

    public void setSaleId(Long saleId) 
    {
        this.saleId = saleId;
    }

    public Long getSaleId() 
    {
        return saleId;
    }

    public void setCommodityCode(String commodityCode) 
    {
        this.commodityCode = commodityCode;
    }

    public String getCommodityCode() 
    {
        return commodityCode;
    }

    public void setDate(Date date) 
    {
        this.date = date;
    }

    public Date getDate() 
    {
        return date;
    }

    public void setNumber(Long number) 
    {
        this.number = number;
    }

    public Long getNumber() 
    {
        return number;
    }

    public void setTotalPrice(BigDecimal totalPrice) 
    {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalPrice() 
    {
        return totalPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) 
    {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getUnitPrice() 
    {
        return unitPrice;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("saleId", getSaleId())
            .append("commodityCode", getCommodityCode())
            .append("date", getDate())
            .append("number", getNumber())
            .append("totalPrice", getTotalPrice())
            .append("unitPrice", getUnitPrice())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
