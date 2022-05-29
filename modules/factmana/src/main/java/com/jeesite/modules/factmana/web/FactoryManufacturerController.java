/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.factmana.web;

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
import com.jeesite.modules.factmana.entity.FactoryManufacturer;
import com.jeesite.modules.factmana.service.FactoryManufacturerService;

/**
 * 生产厂商Controller
 * @author lyu
 * @version 2022-05-24
 */
@Controller
@RequestMapping(value = "${adminPath}/factmana/factoryManufacturer")
public class FactoryManufacturerController extends BaseController {

	@Autowired
	private FactoryManufacturerService factoryManufacturerService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public FactoryManufacturer get(String numCode, boolean isNewRecord) {
		return factoryManufacturerService.get(numCode, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("factmana:factoryManufacturer:view")
	@RequestMapping(value = {"list", ""})
	public String list(FactoryManufacturer factoryManufacturer, Model model) {
		model.addAttribute("factoryManufacturer", factoryManufacturer);
		return "modules/factmana/factoryManufacturerList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("factmana:factoryManufacturer:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<FactoryManufacturer> listData(FactoryManufacturer factoryManufacturer, HttpServletRequest request, HttpServletResponse response) {
		factoryManufacturer.setPage(new Page<>(request, response));
		Page<FactoryManufacturer> page = factoryManufacturerService.findPage(factoryManufacturer);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("factmana:factoryManufacturer:view")
	@RequestMapping(value = "form")
	public String form(FactoryManufacturer factoryManufacturer, Model model) {
		model.addAttribute("factoryManufacturer", factoryManufacturer);
		return "modules/factmana/factoryManufacturerForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("factmana:factoryManufacturer:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated FactoryManufacturer factoryManufacturer) {
		factoryManufacturerService.save(factoryManufacturer);
		return renderResult(Global.TRUE, text("保存生产厂商成功！"));
	}
	
	/**
	 * 停用数据
	 */
	@RequiresPermissions("factmana:factoryManufacturer:edit")
	@RequestMapping(value = "disable")
	@ResponseBody
	public String disable(FactoryManufacturer factoryManufacturer) {
		factoryManufacturer.setStatus(FactoryManufacturer.STATUS_DISABLE);
		factoryManufacturerService.updateStatus(factoryManufacturer);
		return renderResult(Global.TRUE, text("停用生产厂商成功"));
	}
	
	/**
	 * 启用数据
	 */
	@RequiresPermissions("factmana:factoryManufacturer:edit")
	@RequestMapping(value = "enable")
	@ResponseBody
	public String enable(FactoryManufacturer factoryManufacturer) {
		factoryManufacturer.setStatus(FactoryManufacturer.STATUS_NORMAL);
		factoryManufacturerService.updateStatus(factoryManufacturer);
		return renderResult(Global.TRUE, text("启用生产厂商成功"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("factmana:factoryManufacturer:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(FactoryManufacturer factoryManufacturer) {
		factoryManufacturerService.delete(factoryManufacturer);
		return renderResult(Global.TRUE, text("删除生产厂商成功！"));
	}
	
}