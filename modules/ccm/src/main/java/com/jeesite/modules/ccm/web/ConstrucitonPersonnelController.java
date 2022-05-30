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
import com.jeesite.modules.ccm.entity.ConstrucitonPersonnel;
import com.jeesite.modules.ccm.service.ConstrucitonPersonnelService;

/**
 * 施工人员Controller
 * @author lyu
 * @version 2022-05-30
 */
@Controller
@RequestMapping(value = "${adminPath}/ccm/construcitonPersonnel")
public class ConstrucitonPersonnelController extends BaseController {

	@Autowired
	private ConstrucitonPersonnelService construcitonPersonnelService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public ConstrucitonPersonnel get(String numCode, boolean isNewRecord) {
		return construcitonPersonnelService.get(numCode, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("ccm:construcitonPersonnel:view")
	@RequestMapping(value = {"list", ""})
	public String list(ConstrucitonPersonnel construcitonPersonnel, Model model) {
		model.addAttribute("construcitonPersonnel", construcitonPersonnel);
		return "modules/ccm/construcitonPersonnelList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("ccm:construcitonPersonnel:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<ConstrucitonPersonnel> listData(ConstrucitonPersonnel construcitonPersonnel, HttpServletRequest request, HttpServletResponse response) {
		construcitonPersonnel.setPage(new Page<>(request, response));
		Page<ConstrucitonPersonnel> page = construcitonPersonnelService.findPage(construcitonPersonnel);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("ccm:construcitonPersonnel:view")
	@RequestMapping(value = "form")
	public String form(ConstrucitonPersonnel construcitonPersonnel, Model model) {
		model.addAttribute("construcitonPersonnel", construcitonPersonnel);
		return "modules/ccm/construcitonPersonnelForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("ccm:construcitonPersonnel:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated ConstrucitonPersonnel construcitonPersonnel) {
		construcitonPersonnelService.save(construcitonPersonnel);
		return renderResult(Global.TRUE, text("保存施工人员成功！"));
	}
	
	/**
	 * 停用数据
	 */
	@RequiresPermissions("ccm:construcitonPersonnel:edit")
	@RequestMapping(value = "disable")
	@ResponseBody
	public String disable(ConstrucitonPersonnel construcitonPersonnel) {
		construcitonPersonnel.setStatus(ConstrucitonPersonnel.STATUS_DISABLE);
		construcitonPersonnelService.updateStatus(construcitonPersonnel);
		return renderResult(Global.TRUE, text("停用施工人员成功"));
	}
	
	/**
	 * 启用数据
	 */
	@RequiresPermissions("ccm:construcitonPersonnel:edit")
	@RequestMapping(value = "enable")
	@ResponseBody
	public String enable(ConstrucitonPersonnel construcitonPersonnel) {
		construcitonPersonnel.setStatus(ConstrucitonPersonnel.STATUS_NORMAL);
		construcitonPersonnelService.updateStatus(construcitonPersonnel);
		return renderResult(Global.TRUE, text("启用施工人员成功"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("ccm:construcitonPersonnel:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(ConstrucitonPersonnel construcitonPersonnel) {
		construcitonPersonnelService.delete(construcitonPersonnel);
		return renderResult(Global.TRUE, text("删除施工人员成功！"));
	}
	
}