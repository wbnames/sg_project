/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.constru.web;

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
import com.jeesite.modules.constru.entity.ConstruTask;
import com.jeesite.modules.constru.entity.DesignPaperCopy1;
import com.jeesite.modules.constru.entity.ProductClassifyCopy1;
import com.jeesite.modules.constru.entity.ConstructionTeamCopy1;
import com.jeesite.modules.constru.service.ConstruTaskService;

/**
 * 施工任务Controller
 * @author lyu
 * @version 2022-06-06
 */
@Controller
@RequestMapping(value = "${adminPath}/constru/construTask")
public class ConstruTaskController extends BaseController {

	@Autowired
	private ConstruTaskService construTaskService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public ConstruTask get(String numCode, boolean isNewRecord) {
		return construTaskService.get(numCode, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("constru:construTask:view")
	@RequestMapping(value = {"list", ""})
	public String list(ConstruTask construTask, Model model) {
		model.addAttribute("construTask", construTask);
		return "modules/constru/construTaskList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("constru:construTask:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<ConstruTask> listData(ConstruTask construTask, HttpServletRequest request, HttpServletResponse response) {
		construTask.setPage(new Page<>(request, response));
		Page<ConstruTask> page = construTaskService.findPage(construTask);
		return page;
	}
	
	/**
	 * 查询子表数据
	 */
	@RequiresPermissions("constru:construTask:view")
	@RequestMapping(value = "designPaperCopy1ListData")
	@ResponseBody
	public Page<DesignPaperCopy1> subListData(DesignPaperCopy1 designPaperCopy1, HttpServletRequest request, HttpServletResponse response) {
		designPaperCopy1.setPage(new Page<>(request, response));
		Page<DesignPaperCopy1> page = construTaskService.findSubPage(designPaperCopy1);
		return page;
	}
	
	/**
	 * 查询子表数据
	 */
	@RequiresPermissions("constru:construTask:view")
	@RequestMapping(value = "productClassifyCopy1ListData")
	@ResponseBody
	public Page<ProductClassifyCopy1> subListData(ProductClassifyCopy1 productClassifyCopy1, HttpServletRequest request, HttpServletResponse response) {
		productClassifyCopy1.setPage(new Page<>(request, response));
		Page<ProductClassifyCopy1> page = construTaskService.findSubPage(productClassifyCopy1);
		return page;
	}
	
	/**
	 * 查询子表数据
	 */
	@RequiresPermissions("constru:construTask:view")
	@RequestMapping(value = "constructionTeamCopy1ListData")
	@ResponseBody
	public Page<ConstructionTeamCopy1> subListData(ConstructionTeamCopy1 constructionTeamCopy1, HttpServletRequest request, HttpServletResponse response) {
		constructionTeamCopy1.setPage(new Page<>(request, response));
		Page<ConstructionTeamCopy1> page = construTaskService.findSubPage(constructionTeamCopy1);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("constru:construTask:view")
	@RequestMapping(value = "form")
	public String form(ConstruTask construTask, Model model) {
		model.addAttribute("construTask", construTask);
		return "modules/constru/construTaskForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("constru:construTask:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated ConstruTask construTask) {
		construTaskService.save(construTask);
		return renderResult(Global.TRUE, text("保存施工任务成功！"));
	}
	
	/**
	 * 停用数据
	 */
	@RequiresPermissions("constru:construTask:edit")
	@RequestMapping(value = "disable")
	@ResponseBody
	public String disable(ConstruTask construTask) {
		construTask.setStatus(ConstruTask.STATUS_DISABLE);
		construTaskService.updateStatus(construTask);
		return renderResult(Global.TRUE, text("停用施工任务成功"));
	}
	
	/**
	 * 启用数据
	 */
	@RequiresPermissions("constru:construTask:edit")
	@RequestMapping(value = "enable")
	@ResponseBody
	public String enable(ConstruTask construTask) {
		construTask.setStatus(ConstruTask.STATUS_NORMAL);
		construTaskService.updateStatus(construTask);
		return renderResult(Global.TRUE, text("启用施工任务成功"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("constru:construTask:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(ConstruTask construTask) {
		construTaskService.delete(construTask);
		return renderResult(Global.TRUE, text("删除施工任务成功！"));
	}
	
}