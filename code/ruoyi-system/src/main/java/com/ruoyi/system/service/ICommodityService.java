package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Commodity;

/**
 * 商品Service接口
 * 
 * @author a
 * @date 2025-01-03
 */
public interface ICommodityService 
{
    /**
     * 查询商品
     * 
     * @param commodityId 商品主键
     * @return 商品
     */
    public Commodity selectCommodityByCommodityId(Long commodityId);

    /**
     * 查询商品列表
     * 
     * @param commodity 商品
     * @return 商品集合
     */
    public List<Commodity> selectCommodityList(Commodity commodity);

    public Commodity selectCommodityByCode(String  code);

    /**
     * 新增商品
     * 
     * @param commodity 商品
     * @return 结果
     */
    public int insertCommodity(Commodity commodity);

    /**
     * 修改商品
     * 
     * @param commodity 商品
     * @return 结果
     */
    public int updateCommodity(Commodity commodity);

    /**
     * 批量删除商品
     * 
     * @param commodityIds 需要删除的商品主键集合
     * @return 结果
     */
    public int deleteCommodityByCommodityIds(String commodityIds);

    /**
     * 删除商品信息
     * 
     * @param commodityId 商品主键
     * @return 结果
     */
    public int deleteCommodityByCommodityId(Long commodityId);
}
