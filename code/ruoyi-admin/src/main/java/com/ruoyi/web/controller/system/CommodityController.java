package com.ruoyi.web.controller.system;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Commodity;
import com.ruoyi.system.service.ICommodityService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品Controller
 * 
 * @author a
 * @date 2025-01-03
 */
@Controller
@RequestMapping("/system/commodity")
public class CommodityController extends BaseController
{
    private String prefix = "system/commodity";

    @Autowired
    private ICommodityService commodityService;

    @RequiresPermissions("system:commodity:view")
    @GetMapping()
    public String commodity()
    {
        return prefix + "/commodity";
    }

    /**
     * 查询商品列表
     */
    @RequiresPermissions("system:commodity:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Commodity commodity)
    {
        startPage();
        List<Commodity> list = commodityService.selectCommodityList(commodity);
        return getDataTable(list);
    }

    /**
     * 导出商品列表
     */
    @RequiresPermissions("system:commodity:export")
    @Log(title = "商品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Commodity commodity)
    {
        List<Commodity> list = commodityService.selectCommodityList(commodity);
        ExcelUtil<Commodity> util = new ExcelUtil<Commodity>(Commodity.class);
        return util.exportExcel(list, "商品数据");
    }

    /**
     * 新增商品
     */
    @RequiresPermissions("system:commodity:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存商品
     */
    @RequiresPermissions("system:commodity:add")
    @Log(title = "商品", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Commodity commodity)
    {
        return toAjax(commodityService.insertCommodity(commodity));
    }

    /**
     * 修改商品
     */
    @RequiresPermissions("system:commodity:edit")
    @GetMapping("/edit/{commodityId}")
    public String edit(@PathVariable("commodityId") Long commodityId, ModelMap mmap)
    {
        Commodity commodity = commodityService.selectCommodityByCommodityId(commodityId);
        mmap.put("commodity", commodity);
        return prefix + "/edit";
    }

    /**
     * 修改保存商品
     */
    @RequiresPermissions("system:commodity:edit")
    @Log(title = "商品", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Commodity commodity)
    {
        return toAjax(commodityService.updateCommodity(commodity));
    }

    /**
     * 删除商品
     */
    @RequiresPermissions("system:commodity:remove")
    @Log(title = "商品", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(commodityService.deleteCommodityByCommodityIds(ids));
    }
}
