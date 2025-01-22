package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PurchaseMapper;
import com.ruoyi.system.domain.Purchase;
import com.ruoyi.system.service.IPurchaseService;
import com.ruoyi.common.core.text.Convert;

/**
 * 进货记录Service业务层处理
 * 
 * @author a
 * @date 2025-01-03
 */
@Service
public class PurchaseServiceImpl implements IPurchaseService 
{
    @Autowired
    private PurchaseMapper purchaseMapper;

    /**
     * 查询进货记录
     * 
     * @param purchaseId 进货记录主键
     * @return 进货记录
     */
    @Override
    public Purchase selectPurchaseByPurchaseId(Long purchaseId)
    {
        return purchaseMapper.selectPurchaseByPurchaseId(purchaseId);
    }

    /**
     * 查询进货记录列表
     * 
     * @param purchase 进货记录
     * @return 进货记录
     */
    @Override
    public List<Purchase> selectPurchaseList(Purchase purchase)
    {
        return purchaseMapper.selectPurchaseList(purchase);
    }

    /**
     * 新增进货记录
     * 
     * @param purchase 进货记录
     * @return 结果
     */
    @Override
    public int insertPurchase(Purchase purchase)
    {
        purchase.setCreateTime(DateUtils.getNowDate());
        return purchaseMapper.insertPurchase(purchase);
    }

    /**
     * 修改进货记录
     * 
     * @param purchase 进货记录
     * @return 结果
     */
    @Override
    public int updatePurchase(Purchase purchase)
    {
        purchase.setUpdateTime(DateUtils.getNowDate());
        return purchaseMapper.updatePurchase(purchase);
    }

    /**
     * 批量删除进货记录
     * 
     * @param purchaseIds 需要删除的进货记录主键
     * @return 结果
     */
    @Override
    public int deletePurchaseByPurchaseIds(String purchaseIds)
    {
        return purchaseMapper.deletePurchaseByPurchaseIds(Convert.toStrArray(purchaseIds));
    }

    /**
     * 删除进货记录信息
     * 
     * @param purchaseId 进货记录主键
     * @return 结果
     */
    @Override
    public int deletePurchaseByPurchaseId(Long purchaseId)
    {
        return purchaseMapper.deletePurchaseByPurchaseId(purchaseId);
    }
}
