package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Purchase;

/**
 * 进货记录Service接口
 * 
 * @author a
 * @date 2025-01-03
 */
public interface IPurchaseService 
{
    /**
     * 查询进货记录
     * 
     * @param purchaseId 进货记录主键
     * @return 进货记录
     */
    public Purchase selectPurchaseByPurchaseId(Long purchaseId);

    /**
     * 查询进货记录列表
     * 
     * @param purchase 进货记录
     * @return 进货记录集合
     */
    public List<Purchase> selectPurchaseList(Purchase purchase);

    /**
     * 新增进货记录
     * 
     * @param purchase 进货记录
     * @return 结果
     */
    public int insertPurchase(Purchase purchase);

    /**
     * 修改进货记录
     * 
     * @param purchase 进货记录
     * @return 结果
     */
    public int updatePurchase(Purchase purchase);

    /**
     * 批量删除进货记录
     * 
     * @param purchaseIds 需要删除的进货记录主键集合
     * @return 结果
     */
    public int deletePurchaseByPurchaseIds(String purchaseIds);

    /**
     * 删除进货记录信息
     * 
     * @param purchaseId 进货记录主键
     * @return 结果
     */
    public int deletePurchaseByPurchaseId(Long purchaseId);
}
