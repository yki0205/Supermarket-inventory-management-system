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
import com.ruoyi.system.domain.Purchase;
import com.ruoyi.system.service.IPurchaseService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 进货记录Controller
 * 
 * @author a
 * @date 2025-01-03
 */
@Controller
@RequestMapping("/system/purchase")
public class PurchaseController extends BaseController
{
    private String prefix = "system/purchase";

    @Autowired
    private IPurchaseService purchaseService;
    @Autowired
    private ICommodityService commodityService;
    @Autowired
    private IInventoryService inventoryService;

    @RequiresPermissions("system:purchase:view")
    @GetMapping()
    public String purchase()
    {
        return prefix + "/purchase";
    }

    /**
     * 查询进货记录列表
     */
    @RequiresPermissions("system:purchase:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Purchase purchase)
    {
        startPage();
        List<Purchase> list = purchaseService.selectPurchaseList(purchase);
        return getDataTable(list);
    }

    /**
     * 导出进货记录列表
     */
    @RequiresPermissions("system:purchase:export")
    @Log(title = "进货记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Purchase purchase)
    {
        List<Purchase> list = purchaseService.selectPurchaseList(purchase);
        ExcelUtil<Purchase> util = new ExcelUtil<Purchase>(Purchase.class);
        return util.exportExcel(list, "进货记录数据");
    }

    /**
     * 新增进货记录
     */
    @RequiresPermissions("system:purchase:add")
    @GetMapping("/add")
    public String add(ModelMap modelMap)
    {
        Commodity commodity = new Commodity();
        List<Commodity> commoditylist = commodityService.selectCommodityList(commodity);
        modelMap.put("commoditylist",commoditylist);
        return prefix + "/add";
    }

    /**
     * 新增保存进货记录
     */
    @RequiresPermissions("system:purchase:add")
    @Log(title = "进货记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Purchase purchase)
    {
        Inventory inventory = inventoryService.selectInventoryByspCode(purchase.getCommodityCode());
        if(inventory==null){
            Inventory inventory1 = new Inventory();
            inventory1.setRemainder(purchase.getNumber());
            inventory1.setCommodityCode(purchase.getCommodityCode());
            inventoryService.insertInventory(inventory1);
        }else{
            inventory.setRemainder(inventory.getRemainder()+purchase.getNumber());
            inventoryService.updateInventory(inventory);

        }

        return toAjax(purchaseService.insertPurchase(purchase));
    }

    /**
     * 修改进货记录
     */
    @RequiresPermissions("system:purchase:edit")
    @GetMapping("/edit/{purchaseId}")
    public String edit(@PathVariable("purchaseId") Long purchaseId, ModelMap mmap)
    {
        Purchase purchase = purchaseService.selectPurchaseByPurchaseId(purchaseId);
        mmap.put("purchase", purchase);
        return prefix + "/edit";
    }

    /**
     * 修改保存进货记录
     */
    @RequiresPermissions("system:purchase:edit")
    @Log(title = "进货记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Purchase purchase)
    {
        return toAjax(purchaseService.updatePurchase(purchase));
    }

    /**
     * 删除进货记录
     */
    @RequiresPermissions("system:purchase:remove")
    @Log(title = "进货记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(purchaseService.deletePurchaseByPurchaseIds(ids));
    }
}
