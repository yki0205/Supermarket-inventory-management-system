package com.ruoyi.web.controller.system;

import java.util.ArrayList;
import java.util.List;

import com.ruoyi.system.domain.Commodity;
import com.ruoyi.system.service.ICommodityService;
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
import com.ruoyi.system.domain.Inventory;
import com.ruoyi.system.service.IInventoryService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 库存Controller
 * 
 * @author a
 * @date 2025-01-03
 */
@Controller
@RequestMapping("/system/inventory")
public class InventoryController extends BaseController
{
    private String prefix = "system/inventory";

    @Autowired
    private IInventoryService inventoryService;
    @Autowired
    private ICommodityService commodityService;


    @RequiresPermissions("system:inventory:view")
    @GetMapping()
    public String inventory()
    {
        return prefix + "/inventory";
    }

    /**
     * 查询库存列表
     */
    @RequiresPermissions("system:inventory:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Inventory inventory)
    {
        startPage();
        List<Inventory> list = inventoryService.selectInventoryList(inventory);
        List<Inventory> listres = new ArrayList<Inventory>();
       for(Inventory inventory1 : list){
           Commodity commodity = commodityService.selectCommodityByCode(inventory1.getCommodityCode());
           inventory1.setCommodityName(commodity.getName());
           listres.add(inventory1);
       }
        return getDataTable(listres);
    }

    /**
     * 导出库存列表
     */
    @RequiresPermissions("system:inventory:export")
    @Log(title = "库存", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Inventory inventory)
    {
        List<Inventory> list = inventoryService.selectInventoryList(inventory);
        ExcelUtil<Inventory> util = new ExcelUtil<Inventory>(Inventory.class);
        return util.exportExcel(list, "库存数据");
    }

    /**
     * 新增库存
     */
    @RequiresPermissions("system:inventory:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存库存
     */
    @RequiresPermissions("system:inventory:add")
    @Log(title = "库存", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Inventory inventory)
    {
        return toAjax(inventoryService.insertInventory(inventory));
    }

    /**
     * 修改库存
     */
    @RequiresPermissions("system:inventory:edit")
    @GetMapping("/edit/{inventoryId}")
    public String edit(@PathVariable("inventoryId") Long inventoryId, ModelMap mmap)
    {
        Inventory inventory = inventoryService.selectInventoryByInventoryId(inventoryId);
        mmap.put("inventory", inventory);
        return prefix + "/edit";
    }

    /**
     * 修改保存库存
     */
    @RequiresPermissions("system:inventory:edit")
    @Log(title = "库存", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Inventory inventory)
    {
        return toAjax(inventoryService.updateInventory(inventory));
    }

    /**
     * 删除库存
     */
    @RequiresPermissions("system:inventory:remove")
    @Log(title = "库存", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(inventoryService.deleteInventoryByInventoryIds(ids));
    }
}
