/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.ccm.web;

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
import com.jeesite.modules.ccm.entity.ConstructionUnit;
import com.jeesite.modules.ccm.service.ConstructionUnitService;

/**
 * 施工单位Controller
 * @author lyu
 * @version 2022-05-30
 */
@Controller
@RequestMapping(value = "${adminPath}/ccm/constructionUnit")
public class ConstructionUnitController extends BaseController {

	@Autowired
	private ConstructionUnitService constructionUnitService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public ConstructionUnit get(String numCode, boolean isNewRecord) {
		return constructionUnitService.get(numCode, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("ccm:constructionUnit:view")
	@RequestMapping(value = {"list", ""})
	public String list(ConstructionUnit constructionUnit, Model model) {
		model.addAttribute("constructionUnit", constructionUnit);
		return "modules/ccm/constructionUnitList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("ccm:constructionUnit:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<ConstructionUnit> listData(ConstructionUnit constructionUnit, HttpServletRequest request, HttpServletResponse response) {
		constructionUnit.setPage(new Page<>(request, response));
		Page<ConstructionUnit> page = constructionUnitService.findPage(constructionUnit);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("ccm:constructionUnit:view")
	@RequestMapping(value = "form")
	public String form(ConstructionUnit constructionUnit, Model model) {
		model.addAttribute("constructionUnit", constructionUnit);
		return "modules/ccm/constructionUnitForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("ccm:constructionUnit:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated ConstructionUnit constructionUnit) {
		constructionUnitService.save(constructionUnit);
		return renderResult(Global.TRUE, text("保存施工单位成功！"));
	}
	
	/**
	 * 停用数据
	 */
	@RequiresPermissions("ccm:constructionUnit:edit")
	@RequestMapping(value = "disable")
	@ResponseBody
	public String disable(ConstructionUnit constructionUnit) {
		constructionUnit.setStatus(ConstructionUnit.STATUS_DISABLE);
		constructionUnitService.updateStatus(constructionUnit);
		return renderResult(Global.TRUE, text("停用施工单位成功"));
	}
	
	/**
	 * 启用数据
	 */
	@RequiresPermissions("ccm:constructionUnit:edit")
	@RequestMapping(value = "enable")
	@ResponseBody
	public String enable(ConstructionUnit constructionUnit) {
		constructionUnit.setStatus(ConstructionUnit.STATUS_NORMAL);
		constructionUnitService.updateStatus(constructionUnit);
		return renderResult(Global.TRUE, text("启用施工单位成功"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("ccm:constructionUnit:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(ConstructionUnit constructionUnit) {
		constructionUnitService.delete(constructionUnit);
		return renderResult(Global.TRUE, text("删除施工单位成功！"));
	}
	
}