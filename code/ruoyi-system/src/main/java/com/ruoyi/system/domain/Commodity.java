package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品对象 commodity
 * 
 * @author a
 * @date 2025-01-03
 */
public class Commodity extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long commodityId;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String name;

    /** 商品编码 */
    @Excel(name = "商品编码")
    private String code;

    /** 供应商 */
    @Excel(name = "供应商")
    private String supplier;

    /** 商品分类 */
    @Excel(name = "商品分类")
    private String category;

    /** 商品价格 */
    @Excel(name = "商品价格")
    private BigDecimal price;

    /** 商品描述 */
    @Excel(name = "商品描述")
    private String description;

    public void setCommodityId(Long commodityId) 
    {
        this.commodityId = commodityId;
    }

    public Long getCommodityId() 
    {
        return commodityId;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }

    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }

    public void setSupplier(String supplier) 
    {
        this.supplier = supplier;
    }

    public String getSupplier() 
    {
        return supplier;
    }

    public void setCategory(String category) 
    {
        this.category = category;
    }

    public String getCategory() 
    {
        return category;
    }

    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("commodityId", getCommodityId())
            .append("name", getName())
            .append("code", getCode())
            .append("supplier", getSupplier())
            .append("category", getCategory())
            .append("price", getPrice())
            .append("description", getDescription())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
