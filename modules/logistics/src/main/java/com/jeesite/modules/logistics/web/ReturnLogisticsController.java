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
import com.jeesite.modules.logistics.entity.ReturnLogistics;
import com.jeesite.modules.logistics.service.ReturnLogisticsService;

/**
 * 退还管理Controller
 * @author wang_bo
 * @version 2022-05-24
 */
@Controller
@RequestMapping(value = "${adminPath}/logistics/returnLogistics")
public class ReturnLogisticsController extends BaseController {

	@Autowired
	private ReturnLogisticsService returnLogisticsService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public ReturnLogistics get(String numCode, boolean isNewRecord) {
		return returnLogisticsService.get(numCode, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("logistics:returnLogistics:view")
	@RequestMapping(value = {"list", ""})
	public String list(ReturnLogistics returnLogistics, Model model) {
		model.addAttribute("returnLogistics", returnLogistics);
		return "modules/logistics/returnLogisticsList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("logistics:returnLogistics:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<ReturnLogistics> listData(ReturnLogistics returnLogistics, HttpServletRequest request, HttpServletResponse response) {
		returnLogistics.setPage(new Page<>(request, response));
		Page<ReturnLogistics> page = returnLogisticsService.findPage(returnLogistics);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("logistics:returnLogistics:view")
	@RequestMapping(value = "form")
	public String form(ReturnLogistics returnLogistics, Model model) {
		model.addAttribute("returnLogistics", returnLogistics);
		return "modules/logistics/returnLogisticsForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("logistics:returnLogistics:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated ReturnLogistics returnLogistics) {
		returnLogisticsService.save(returnLogistics);
		return renderResult(Global.TRUE, text("保存退还管理成功！"));
	}
	
	/**
	 * 停用数据
	 */
	@RequiresPermissions("logistics:returnLogistics:edit")
	@RequestMapping(value = "disable")
	@ResponseBody
	public String disable(ReturnLogistics returnLogistics) {
		returnLogistics.setStatus(ReturnLogistics.STATUS_DISABLE);
		returnLogisticsService.updateStatus(returnLogistics);
		return renderResult(Global.TRUE, text("停用退还管理成功"));
	}
	
	/**
	 * 启用数据
	 */
	@RequiresPermissions("logistics:returnLogistics:edit")
	@RequestMapping(value = "enable")
	@ResponseBody
	public String enable(ReturnLogistics returnLogistics) {
		returnLogistics.setStatus(ReturnLogistics.STATUS_NORMAL);
		returnLogisticsService.updateStatus(returnLogistics);
		return renderResult(Global.TRUE, text("启用退还管理成功"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("logistics:returnLogistics:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(ReturnLogistics returnLogistics) {
		returnLogisticsService.delete(returnLogistics);
		return renderResult(Global.TRUE, text("删除退还管理成功！"));
	}
	
}