package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.system.domain.Commodity;
import com.ruoyi.system.domain.Inventory;
import com.ruoyi.system.service.ICommodityService;
import com.ruoyi.system.service.IInventoryService;
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
import com.ruoyi.system.domain.Sale;
import com.ruoyi.system.service.ISaleService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 销售记录Controller
 * 
 * @author aa
 * @date 2025-01-03
 */
@Controller
@RequestMapping("/system/sale")
public class SaleController extends BaseController
{
    private String prefix = "system/sale";

    @Autowired
    private ISaleService saleService;
    @Autowired
    private IInventoryService inventoryService;
    @Autowired
    private ICommodityService commodityService;
    @RequiresPermissions("system:sale:view")
    @GetMapping()
    public String sale()
    {
        return prefix + "/sale";
    }

    /**
     * 查询销售记录列表
     */
    @RequiresPermissions("system:sale:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Sale sale)
    {
        startPage();
        List<Sale> list = saleService.selectSaleList(sale);
        return getDataTable(list);
    }

    /**
     * 导出销售记录列表
     */
    @RequiresPermissions("system:sale:export")
    @Log(title = "销售记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Sale sale)
    {
        List<Sale> list = saleService.selectSaleList(sale);
        ExcelUtil<Sale> util = new ExcelUtil<Sale>(Sale.class);
        return util.exportExcel(list, "销售记录数据");
    }

    /**
     * 新增销售记录
     */
    @RequiresPermissions("system:sale:add")
    @GetMapping("/add")
    public String add(ModelMap modelMap)
    {
        Commodity commodity = new Commodity();
        List<Commodity> commoditylist = commodityService.selectCommodityList(commodity);
        modelMap.put("commoditylist",commoditylist);
        return prefix + "/add";
    }

    /**
     * 新增保存销售记录
     */
    @RequiresPermissions("system:sale:add")
    @Log(title = "销售记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Sale sale)
    {
        Inventory inventory = inventoryService.selectInventoryByspCode(sale.getCommodityCode());
        Long res = inventory.getRemainder()-sale.getNumber();
        if(res<0){
            return error("库存不足");
        }
        inventory.setRemainder(res);
        inventoryService.updateInventory(inventory);

        return toAjax(saleService.insertSale(sale));
    }

    /**
     * 修改销售记录
     */
    @RequiresPermissions("system:sale:edit")
    @GetMapping("/edit/{saleId}")
    public String edit(@PathVariable("saleId") Long saleId, ModelMap mmap)
    {
        Sale sale = saleService.selectSaleBySaleId(saleId);
        mmap.put("sale", sale);
        return prefix + "/edit";
    }

    /**
     * 修改保存销售记录
     */
    @RequiresPermissions("system:sale:edit")
    @Log(title = "销售记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Sale sale)
    {
        return toAjax(saleService.updateSale(sale));
    }

    /**
     * 删除销售记录
     */
    @RequiresPermissions("system:sale:remove")
    @Log(title = "销售记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(saleService.deleteSaleBySaleIds(ids));
    }
}
