package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 进货记录对象 purchase
 * 
 * @author a
 * @date 2025-01-03
 */
public class Purchase extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long purchaseId;

    /** 商品编码 */
    @Excel(name = "商品编码")
    private String commodityCode;

    /** 进货时间 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "进货时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date date;

    /** 进货数量 */
    @Excel(name = "进货数量")
    private Long number;

    /** 进货总价 */
    @Excel(name = "进货总价")
    private BigDecimal totalPrice;

    /** 进货单价 */
    @Excel(name = "进货单价")
    private BigDecimal unitPrice;

    public void setPurchaseId(Long purchaseId) 
    {
        this.purchaseId = purchaseId;
    }

    public Long getPurchaseId() 
    {
        return purchaseId;
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
            .append("purchaseId", getPurchaseId())
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
