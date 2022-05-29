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
import com.jeesite.modules.constru.entity.ConstruTaskLog;
import com.jeesite.modules.constru.service.ConstruTaskLogService;

/**
 * 施工日志Controller
 * @author lyu
 * @version 2022-05-26
 */
@Controller
@RequestMapping(value = "${adminPath}/constru/construTaskLog")
public class ConstruTaskLogController extends BaseController {

	@Autowired
	private ConstruTaskLogService construTaskLogService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public ConstruTaskLog get(String numCode, boolean isNewRecord) {
		return construTaskLogService.get(numCode, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("constru:construTaskLog:view")
	@RequestMapping(value = {"list", ""})
	public String list(ConstruTaskLog construTaskLog, Model model) {
		model.addAttribute("construTaskLog", construTaskLog);
		return "modules/constru/construTaskLogList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("constru:construTaskLog:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<ConstruTaskLog> listData(ConstruTaskLog construTaskLog, HttpServletRequest request, HttpServletResponse response) {
		construTaskLog.setPage(new Page<>(request, response));
		Page<ConstruTaskLog> page = construTaskLogService.findPage(construTaskLog);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("constru:construTaskLog:view")
	@RequestMapping(value = "form")
	public String form(ConstruTaskLog construTaskLog, Model model) {
		model.addAttribute("construTaskLog", construTaskLog);
		return "modules/constru/construTaskLogForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("constru:construTaskLog:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated ConstruTaskLog construTaskLog) {
		construTaskLogService.save(construTaskLog);
		return renderResult(Global.TRUE, text("保存施工日志成功！"));
	}
	
	/**
	 * 停用数据
	 */
	@RequiresPermissions("constru:construTaskLog:edit")
	@RequestMapping(value = "disable")
	@ResponseBody
	public String disable(ConstruTaskLog construTaskLog) {
		construTaskLog.setStatus(ConstruTaskLog.STATUS_DISABLE);
		construTaskLogService.updateStatus(construTaskLog);
		return renderResult(Global.TRUE, text("停用施工日志成功"));
	}
	
	/**
	 * 启用数据
	 */
	@RequiresPermissions("constru:construTaskLog:edit")
	@RequestMapping(value = "enable")
	@ResponseBody
	public String enable(ConstruTaskLog construTaskLog) {
		construTaskLog.setStatus(ConstruTaskLog.STATUS_NORMAL);
		construTaskLogService.updateStatus(construTaskLog);
		return renderResult(Global.TRUE, text("启用施工日志成功"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("constru:construTaskLog:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(ConstruTaskLog construTaskLog) {
		construTaskLogService.delete(construTaskLog);
		return renderResult(Global.TRUE, text("删除施工日志成功！"));
	}
	
}