/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.cm.web;

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
import com.jeesite.modules.cm.entity.PaymentPlan;
import com.jeesite.modules.cm.service.PaymentPlanService;

/**
 * 收款计划Controller
 * @author wang_bo
 * @version 2022-05-23
 */
@Controller
@RequestMapping(value = "${adminPath}/cm/paymentPlan")
public class PaymentPlanController extends BaseController {

	@Autowired
	private PaymentPlanService paymentPlanService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public PaymentPlan get(String numCode, boolean isNewRecord) {
		return paymentPlanService.get(numCode, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("cm:paymentPlan:view")
	@RequestMapping(value = {"list", ""})
	public String list(PaymentPlan paymentPlan, Model model) {
		model.addAttribute("paymentPlan", paymentPlan);
		return "modules/cm/paymentPlanList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("cm:paymentPlan:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<PaymentPlan> listData(PaymentPlan paymentPlan, HttpServletRequest request, HttpServletResponse response) {
		paymentPlan.setPage(new Page<>(request, response));
		Page<PaymentPlan> page = paymentPlanService.findPage(paymentPlan);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("cm:paymentPlan:view")
	@RequestMapping(value = "form")
	public String form(PaymentPlan paymentPlan, Model model) {
		model.addAttribute("paymentPlan", paymentPlan);
		return "modules/cm/paymentPlanForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("cm:paymentPlan:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated PaymentPlan paymentPlan) {
		paymentPlanService.save(paymentPlan);
		return renderResult(Global.TRUE, text("保存收款计划成功！"));
	}
	
	/**
	 * 停用数据
	 */
	@RequiresPermissions("cm:paymentPlan:edit")
	@RequestMapping(value = "disable")
	@ResponseBody
	public String disable(PaymentPlan paymentPlan) {
		paymentPlan.setStatus(PaymentPlan.STATUS_DISABLE);
		paymentPlanService.updateStatus(paymentPlan);
		return renderResult(Global.TRUE, text("停用收款计划成功"));
	}
	
	/**
	 * 启用数据
	 */
	@RequiresPermissions("cm:paymentPlan:edit")
	@RequestMapping(value = "enable")
	@ResponseBody
	public String enable(PaymentPlan paymentPlan) {
		paymentPlan.setStatus(PaymentPlan.STATUS_NORMAL);
		paymentPlanService.updateStatus(paymentPlan);
		return renderResult(Global.TRUE, text("启用收款计划成功"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("cm:paymentPlan:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(PaymentPlan paymentPlan) {
		paymentPlanService.delete(paymentPlan);
		return renderResult(Global.TRUE, text("删除收款计划成功！"));
	}
	
}