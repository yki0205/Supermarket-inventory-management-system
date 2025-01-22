package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Sale;

/**
 * 销售记录Mapper接口
 * 
 * @author aa
 * @date 2025-01-03
 */
public interface SaleMapper 
{
    /**
     * 查询销售记录
     * 
     * @param saleId 销售记录主键
     * @return 销售记录
     */
    public Sale selectSaleBySaleId(Long saleId);

    /**
     * 查询销售记录列表
     * 
     * @param sale 销售记录
     * @return 销售记录集合
     */
    public List<Sale> selectSaleList(Sale sale);

    /**
     * 新增销售记录
     * 
     * @param sale 销售记录
     * @return 结果
     */
    public int insertSale(Sale sale);

    /**
     * 修改销售记录
     * 
     * @param sale 销售记录
     * @return 结果
     */
    public int updateSale(Sale sale);

    /**
     * 删除销售记录
     * 
     * @param saleId 销售记录主键
     * @return 结果
     */
    public int deleteSaleBySaleId(Long saleId);

    /**
     * 批量删除销售记录
     * 
     * @param saleIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSaleBySaleIds(String[] saleIds);
}
