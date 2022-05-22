/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.pm.web;

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
import com.jeesite.modules.pm.entity.ProjectManager;
import com.jeesite.modules.pm.entity.ProjectManagerUser;
import com.jeesite.modules.pm.service.ProjectManagerService;

/**
 * 项目管理Controller
 * @author wang_bo
 * @version 2022-05-22
 */
@Controller
@RequestMapping(value = "${adminPath}/pm/projectManager")
public class ProjectManagerController extends BaseController {

	@Autowired
	private ProjectManagerService projectManagerService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public ProjectManager get(String serialNumber, boolean isNewRecord) {
		return projectManagerService.get(serialNumber, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("pm:projectManager:view")
	@RequestMapping(value = {"list", ""})
	public String list(ProjectManager projectManager, Model model) {
		model.addAttribute("projectManager", projectManager);
		return "modules/pm/projectManagerList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("pm:projectManager:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<ProjectManager> listData(ProjectManager projectManager, HttpServletRequest request, HttpServletResponse response) {
		projectManager.setPage(new Page<>(request, response));
		Page<ProjectManager> page = projectManagerService.findPage(projectManager);
		return page;
	}
	
	/**
	 * 查询子表数据
	 */
	@RequiresPermissions("pm:projectManager:view")
	@RequestMapping(value = "projectManagerUserListData")
	@ResponseBody
	public Page<ProjectManagerUser> subListData(ProjectManagerUser projectManagerUser, HttpServletRequest request, HttpServletResponse response) {
		projectManagerUser.setPage(new Page<>(request, response));
		Page<ProjectManagerUser> page = projectManagerService.findSubPage(projectManagerUser);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("pm:projectManager:view")
	@RequestMapping(value = "form")
	public String form(ProjectManager projectManager, Model model) {
		model.addAttribute("projectManager", projectManager);
		return "modules/pm/projectManagerForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("pm:projectManager:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated ProjectManager projectManager) {
		projectManagerService.save(projectManager);
		return renderResult(Global.TRUE, text("保存项目管理成功！"));
	}
	
	/**
	 * 停用数据
	 */
	@RequiresPermissions("pm:projectManager:edit")
	@RequestMapping(value = "disable")
	@ResponseBody
	public String disable(ProjectManager projectManager) {
		projectManager.setStatus(ProjectManager.STATUS_DISABLE);
		projectManagerService.updateStatus(projectManager);
		return renderResult(Global.TRUE, text("停用项目管理成功"));
	}
	
	/**
	 * 启用数据
	 */
	@RequiresPermissions("pm:projectManager:edit")
	@RequestMapping(value = "enable")
	@ResponseBody
	public String enable(ProjectManager projectManager) {
		projectManager.setStatus(ProjectManager.STATUS_NORMAL);
		projectManagerService.updateStatus(projectManager);
		return renderResult(Global.TRUE, text("启用项目管理成功"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("pm:projectManager:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(ProjectManager projectManager) {
		projectManagerService.delete(projectManager);
		return renderResult(Global.TRUE, text("删除项目管理成功！"));
	}
	
}