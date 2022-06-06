/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.logistics.web;

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
import com.jeesite.modules.logistics.entity.ShipmentsLogistics;
import com.jeesite.modules.logistics.service.ShipmentsLogisticsService;

/**
 * 发货管理Controller
 * @author wang_bo
 * @version 2022-06-06
 */
@Controller
@RequestMapping(value = "${adminPath}/logistics/shipmentsLogistics")
public class ShipmentsLogisticsController extends BaseController {

	@Autowired
	private ShipmentsLogisticsService shipmentsLogisticsService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public ShipmentsLogistics get(String numCode, boolean isNewRecord) {
		return shipmentsLogisticsService.get(numCode, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("logistics:shipmentsLogistics:view")
	@RequestMapping(value = {"list", ""})
	public String list(ShipmentsLogistics shipmentsLogistics, Model model) {
		model.addAttribute("shipmentsLogistics", shipmentsLogistics);
		return "modules/logistics/shipmentsLogisticsList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("logistics:shipmentsLogistics:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<ShipmentsLogistics> listData(ShipmentsLogistics shipmentsLogistics, HttpServletRequest request, HttpServletResponse response) {
		shipmentsLogistics.setPage(new Page<>(request, response));
		Page<ShipmentsLogistics> page = shipmentsLogisticsService.findPage(shipmentsLogistics);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("logistics:shipmentsLogistics:view")
	@RequestMapping(value = "form")
	public String form(ShipmentsLogistics shipmentsLogistics, Model model) {
		model.addAttribute("shipmentsLogistics", shipmentsLogistics);
		return "modules/logistics/shipmentsLogisticsForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("logistics:shipmentsLogistics:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated ShipmentsLogistics shipmentsLogistics) {
		shipmentsLogisticsService.save(shipmentsLogistics);
		return renderResult(Global.TRUE, text("保存发货管理成功！"));
	}
	
	/**
	 * 停用数据
	 */
	@RequiresPermissions("logistics:shipmentsLogistics:edit")
	@RequestMapping(value = "disable")
	@ResponseBody
	public String disable(ShipmentsLogistics shipmentsLogistics) {
		shipmentsLogistics.setStatus(ShipmentsLogistics.STATUS_DISABLE);
		shipmentsLogisticsService.updateStatus(shipmentsLogistics);
		return renderResult(Global.TRUE, text("停用发货管理成功"));
	}
	
	/**
	 * 启用数据
	 */
	@RequiresPermissions("logistics:shipmentsLogistics:edit")
	@RequestMapping(value = "enable")
	@ResponseBody
	public String enable(ShipmentsLogistics shipmentsLogistics) {
		shipmentsLogistics.setStatus(ShipmentsLogistics.STATUS_NORMAL);
		shipmentsLogisticsService.updateStatus(shipmentsLogistics);
		return renderResult(Global.TRUE, text("启用发货管理成功"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("logistics:shipmentsLogistics:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(ShipmentsLogistics shipmentsLogistics) {
		shipmentsLogisticsService.delete(shipmentsLogistics);
		return renderResult(Global.TRUE, text("删除发货管理成功！"));
	}
	
}