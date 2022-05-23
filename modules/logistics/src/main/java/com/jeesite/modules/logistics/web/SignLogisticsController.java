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
import com.jeesite.modules.logistics.entity.SignLogistics;
import com.jeesite.modules.logistics.service.SignLogisticsService;

/**
 * 签收管理Controller
 * @author wang_bo
 * @version 2022-05-24
 */
@Controller
@RequestMapping(value = "${adminPath}/logistics/signLogistics")
public class SignLogisticsController extends BaseController {

	@Autowired
	private SignLogisticsService signLogisticsService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public SignLogistics get(String numCode, boolean isNewRecord) {
		return signLogisticsService.get(numCode, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("logistics:signLogistics:view")
	@RequestMapping(value = {"list", ""})
	public String list(SignLogistics signLogistics, Model model) {
		model.addAttribute("signLogistics", signLogistics);
		return "modules/logistics/signLogisticsList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("logistics:signLogistics:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<SignLogistics> listData(SignLogistics signLogistics, HttpServletRequest request, HttpServletResponse response) {
		signLogistics.setPage(new Page<>(request, response));
		Page<SignLogistics> page = signLogisticsService.findPage(signLogistics);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("logistics:signLogistics:view")
	@RequestMapping(value = "form")
	public String form(SignLogistics signLogistics, Model model) {
		model.addAttribute("signLogistics", signLogistics);
		return "modules/logistics/signLogisticsForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("logistics:signLogistics:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated SignLogistics signLogistics) {
		signLogisticsService.save(signLogistics);
		return renderResult(Global.TRUE, text("保存签收管理成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("logistics:signLogistics:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(SignLogistics signLogistics) {
		signLogisticsService.delete(signLogistics);
		return renderResult(Global.TRUE, text("删除签收管理成功！"));
	}
	
}