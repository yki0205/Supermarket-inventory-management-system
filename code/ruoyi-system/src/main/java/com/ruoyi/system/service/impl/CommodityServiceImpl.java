package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CommodityMapper;
import com.ruoyi.system.domain.Commodity;
import com.ruoyi.system.service.ICommodityService;
import com.ruoyi.common.core.text.Convert;

/**
 * 商品Service业务层处理
 * 
 * @author a
 * @date 2025-01-03
 */
@Service
public class CommodityServiceImpl implements ICommodityService 
{
    @Autowired
    private CommodityMapper commodityMapper;

    /**
     * 查询商品
     * 
     * @param commodityId 商品主键
     * @return 商品
     */
    @Override
    public Commodity selectCommodityByCommodityId(Long commodityId)
    {
        return commodityMapper.selectCommodityByCommodityId(commodityId);
    }

    /**
     * 查询商品列表
     * 
     * @param commodity 商品
     * @return 商品
     */
    @Override
    public List<Commodity> selectCommodityList(Commodity commodity)
    {
        return commodityMapper.selectCommodityList(commodity);
    }

    @Override
    public Commodity selectCommodityByCode(String code)
    {
        return commodityMapper.selectCommodityByCode(code);
    }

    /**
     * 新增商品
     * 
     * @param commodity 商品
     * @return 结果
     */
    @Override
    public int insertCommodity(Commodity commodity)
    {
        commodity.setCreateTime(DateUtils.getNowDate());
        return commodityMapper.insertCommodity(commodity);
    }

    /**
     * 修改商品
     * 
     * @param commodity 商品
     * @return 结果
     */
    @Override
    public int updateCommodity(Commodity commodity)
    {
        commodity.setUpdateTime(DateUtils.getNowDate());
        return commodityMapper.updateCommodity(commodity);
    }

    /**
     * 批量删除商品
     * 
     * @param commodityIds 需要删除的商品主键
     * @return 结果
     */
    @Override
    public int deleteCommodityByCommodityIds(String commodityIds)
    {
        return commodityMapper.deleteCommodityByCommodityIds(Convert.toStrArray(commodityIds));
    }

    /**
     * 删除商品信息
     * 
     * @param commodityId 商品主键
     * @return 结果
     */
    @Override
    public int deleteCommodityByCommodityId(Long commodityId)
    {
        return commodityMapper.deleteCommodityByCommodityId(commodityId);
    }
}
