package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.List;

/**
 * 库存对象 inventory
 * 
 * @author a
 * @date 2025-01-03
 */
public class Inventory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 库存id */
    private Long inventoryId;

    /** 商品编码 */
    @Excel(name = "商品编码")
    private String commodityCode;
    private String commodityName;
    List<Commodity> commodityCodes;

    /** 库存量 */
    @Excel(name = "库存量")
    private Long remainder;

    public void setInventoryId(Long inventoryId) 
    {
        this.inventoryId = inventoryId;
    }

    public Long getInventoryId() 
    {
        return inventoryId;
    }

    public void setCommodityCode(String commodityCode) 
    {
        this.commodityCode = commodityCode;
    }

    public String getCommodityCode() 
    {
        return commodityCode;
    }

    public void setRemainder(Long remainder) 
    {
        this.remainder = remainder;
    }

    public Long getRemainder() 
    {
        return remainder;
    }

    public List<Commodity> getCommodityCodes() {
        return commodityCodes;
    }

    public void setCommodityCodes(List<Commodity> commodityCodes) {
        this.commodityCodes = commodityCodes;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "inventoryId=" + inventoryId +
                ", commodityCode='" + commodityCode + '\'' +
                ", commodityName='" + commodityName + '\'' +
                ", commodityCodes=" + commodityCodes +
                ", remainder=" + remainder +
                '}';
    }
}
