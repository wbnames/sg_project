/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.product.web;

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
import com.jeesite.modules.product.entity.ProductClassify;
import com.jeesite.modules.product.service.ProductClassifyService;

/**
 * 产品分类Controller
 * @author lyu
 * @version 2022-05-24
 */
@Controller
@RequestMapping(value = "${adminPath}/product/productClassify")
public class ProductClassifyController extends BaseController {

	@Autowired
	private ProductClassifyService productClassifyService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public ProductClassify get(String numCode, boolean isNewRecord) {
		return productClassifyService.get(numCode, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("product:productClassify:view")
	@RequestMapping(value = {"list", ""})
	public String list(ProductClassify productClassify, Model model) {
		model.addAttribute("productClassify", productClassify);
		return "modules/product/productClassifyList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("product:productClassify:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<ProductClassify> listData(ProductClassify productClassify, HttpServletRequest request, HttpServletResponse response) {
		productClassify.setPage(new Page<>(request, response));
		Page<ProductClassify> page = productClassifyService.findPage(productClassify);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("product:productClassify:view")
	@RequestMapping(value = "form")
	public String form(ProductClassify productClassify, Model model) {
		model.addAttribute("productClassify", productClassify);
		return "modules/product/productClassifyForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("product:productClassify:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated ProductClassify productClassify) {
		productClassifyService.save(productClassify);
		return renderResult(Global.TRUE, text("保存产品分类成功！"));
	}
	
	/**
	 * 停用数据
	 */
	@RequiresPermissions("product:productClassify:edit")
	@RequestMapping(value = "disable")
	@ResponseBody
	public String disable(ProductClassify productClassify) {
		productClassify.setStatus(ProductClassify.STATUS_DISABLE);
		productClassifyService.updateStatus(productClassify);
		return renderResult(Global.TRUE, text("停用产品分类成功"));
	}
	
	/**
	 * 启用数据
	 */
	@RequiresPermissions("product:productClassify:edit")
	@RequestMapping(value = "enable")
	@ResponseBody
	public String enable(ProductClassify productClassify) {
		productClassify.setStatus(ProductClassify.STATUS_NORMAL);
		productClassifyService.updateStatus(productClassify);
		return renderResult(Global.TRUE, text("启用产品分类成功"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("product:productClassify:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(ProductClassify productClassify) {
		productClassifyService.delete(productClassify);
		return renderResult(Global.TRUE, text("删除产品分类成功！"));
	}
	
}