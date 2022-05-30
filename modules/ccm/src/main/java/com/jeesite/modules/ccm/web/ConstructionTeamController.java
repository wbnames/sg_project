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
import com.jeesite.modules.ccm.entity.ConstructionTeam;
import com.jeesite.modules.ccm.service.ConstructionTeamService;

/**
 * 施工班组Controller
 * @author lyu
 * @version 2022-05-30
 */
@Controller
@RequestMapping(value = "${adminPath}/ccm/constructionTeam")
public class ConstructionTeamController extends BaseController {

	@Autowired
	private ConstructionTeamService constructionTeamService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public ConstructionTeam get(String numCode, boolean isNewRecord) {
		return constructionTeamService.get(numCode, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("ccm:constructionTeam:view")
	@RequestMapping(value = {"list", ""})
	public String list(ConstructionTeam constructionTeam, Model model) {
		model.addAttribute("constructionTeam", constructionTeam);
		return "modules/ccm/constructionTeamList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("ccm:constructionTeam:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<ConstructionTeam> listData(ConstructionTeam constructionTeam, HttpServletRequest request, HttpServletResponse response) {
		constructionTeam.setPage(new Page<>(request, response));
		Page<ConstructionTeam> page = constructionTeamService.findPage(constructionTeam);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("ccm:constructionTeam:view")
	@RequestMapping(value = "form")
	public String form(ConstructionTeam constructionTeam, Model model) {
		model.addAttribute("constructionTeam", constructionTeam);
		return "modules/ccm/constructionTeamForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("ccm:constructionTeam:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated ConstructionTeam constructionTeam) {
		constructionTeamService.save(constructionTeam);
		return renderResult(Global.TRUE, text("保存施工班组成功！"));
	}
	
	/**
	 * 停用数据
	 */
	@RequiresPermissions("ccm:constructionTeam:edit")
	@RequestMapping(value = "disable")
	@ResponseBody
	public String disable(ConstructionTeam constructionTeam) {
		constructionTeam.setStatus(ConstructionTeam.STATUS_DISABLE);
		constructionTeamService.updateStatus(constructionTeam);
		return renderResult(Global.TRUE, text("停用施工班组成功"));
	}
	
	/**
	 * 启用数据
	 */
	@RequiresPermissions("ccm:constructionTeam:edit")
	@RequestMapping(value = "enable")
	@ResponseBody
	public String enable(ConstructionTeam constructionTeam) {
		constructionTeam.setStatus(ConstructionTeam.STATUS_NORMAL);
		constructionTeamService.updateStatus(constructionTeam);
		return renderResult(Global.TRUE, text("启用施工班组成功"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("ccm:constructionTeam:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(ConstructionTeam constructionTeam) {
		constructionTeamService.delete(constructionTeam);
		return renderResult(Global.TRUE, text("删除施工班组成功！"));
	}
	
}