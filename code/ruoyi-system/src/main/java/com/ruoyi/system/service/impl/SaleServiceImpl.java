package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SaleMapper;
import com.ruoyi.system.domain.Sale;
import com.ruoyi.system.service.ISaleService;
import com.ruoyi.common.core.text.Convert;

/**
 * 销售记录Service业务层处理
 * 
 * @author aa
 * @date 2025-01-03
 */
@Service
public class SaleServiceImpl implements ISaleService 
{
    @Autowired
    private SaleMapper saleMapper;

    /**
     * 查询销售记录
     * 
     * @param saleId 销售记录主键
     * @return 销售记录
     */
    @Override
    public Sale selectSaleBySaleId(Long saleId)
    {
        return saleMapper.selectSaleBySaleId(saleId);
    }

    /**
     * 查询销售记录列表
     * 
     * @param sale 销售记录
     * @return 销售记录
     */
    @Override
    public List<Sale> selectSaleList(Sale sale)
    {
        return saleMapper.selectSaleList(sale);
    }

    /**
     * 新增销售记录
     * 
     * @param sale 销售记录
     * @return 结果
     */
    @Override
    public int insertSale(Sale sale)
    {
        sale.setCreateTime(DateUtils.getNowDate());
        return saleMapper.insertSale(sale);
    }

    /**
     * 修改销售记录
     * 
     * @param sale 销售记录
     * @return 结果
     */
    @Override
    public int updateSale(Sale sale)
    {
        sale.setUpdateTime(DateUtils.getNowDate());
        return saleMapper.updateSale(sale);
    }

    /**
     * 批量删除销售记录
     * 
     * @param saleIds 需要删除的销售记录主键
     * @return 结果
     */
    @Override
    public int deleteSaleBySaleIds(String saleIds)
    {
        return saleMapper.deleteSaleBySaleIds(Convert.toStrArray(saleIds));
    }

    /**
     * 删除销售记录信息
     * 
     * @param saleId 销售记录主键
     * @return 结果
     */
    @Override
    public int deleteSaleBySaleId(Long saleId)
    {
        return saleMapper.deleteSaleBySaleId(saleId);
    }
}
