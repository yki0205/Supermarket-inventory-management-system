package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Sale;

/**
 * 销售记录Service接口
 * 
 * @author aa
 * @date 2025-01-03
 */
public interface ISaleService 
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
     * 批量删除销售记录
     * 
     * @param saleIds 需要删除的销售记录主键集合
     * @return 结果
     */
    public int deleteSaleBySaleIds(String saleIds);

    /**
     * 删除销售记录信息
     * 
     * @param saleId 销售记录主键
     * @return 结果
     */
    public int deleteSaleBySaleId(Long saleId);
}
