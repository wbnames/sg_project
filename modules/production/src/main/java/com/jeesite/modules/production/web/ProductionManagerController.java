/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.production.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.production.entity.ProductionManager;
import com.jeesite.modules.production.entity.DesignDDD;
import com.jeesite.modules.production.entity.DesignPPP;
import com.jeesite.modules.production.service.ProductionManagerService;

/**
 * 生产管理Controller
 * @author wang_bo
 * @version 2022-05-30
 */
@Controller
@RequestMapping(value = "${adminPath}/production/productionManager")
public class ProductionManagerController extends BaseController {

	@Autowired
	private ProductionManagerService productionManagerService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public ProductionManager get(String numCode, boolean isNewRecord) {
		return productionManagerService.get(numCode, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("production:productionManager:view")
	@RequestMapping(value = {"list", ""})
	public String list(ProductionManager productionManager, Model model) {
		model.addAttribute("productionManager", productionManager);
		return "modules/production/productionManagerList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("production:productionManager:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<ProductionManager> listData(ProductionManager productionManager, HttpServletRequest request, HttpServletResponse response) {
		productionManager.setPage(new Page<>(request, response));
		Page<ProductionManager> page = productionManagerService.findPage(productionManager);
		return page;
	}
	
	/**
	 * 查询子表数据
	 */
	@RequiresPermissions("production:productionManager:view")
	@RequestMapping(value = "designDDDListData")
	@ResponseBody
	public Page<DesignDDD> subListData(DesignDDD designDDD, HttpServletRequest request, HttpServletResponse response) {
		designDDD.setPage(new Page<>(request, response));
		Page<DesignDDD> page = productionManagerService.findSubPage(designDDD);
		return page;
	}
	
	/**
	 * 查询子表数据
	 */
	@RequiresPermissions("production:productionManager:view")
	@RequestMapping(value = "designPPPListData")
	@ResponseBody
	public Page<DesignPPP> subListData(DesignPPP designPPP, HttpServletRequest request, HttpServletResponse response) {
		designPPP.setPage(new Page<>(request, response));
		Page<DesignPPP> page = productionManagerService.findSubPage(designPPP);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("production:productionManager:view")
	@RequestMapping(value = "form")
	public String form(ProductionManager productionManager, Model model) {
		model.addAttribute("productionManager", productionManager);
		return "modules/production/productionManagerForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("production:productionManager:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated ProductionManager productionManager) {
		productionManagerService.save(productionManager);
		return renderResult(Global.TRUE, text("保存生产管理成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("production:productionManager:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(ProductionManager productionManager) {
		productionManagerService.delete(productionManager);
		return renderResult(Global.TRUE, text("删除生产管理成功！"));
	}
	
}