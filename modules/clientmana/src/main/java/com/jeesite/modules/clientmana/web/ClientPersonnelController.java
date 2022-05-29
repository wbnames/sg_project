/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.clientmana.web;

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
import com.jeesite.modules.clientmana.entity.ClientPersonnel;
import com.jeesite.modules.clientmana.service.ClientPersonnelService;

/**
 * 单位联系人Controller
 * @author lyu
 * @version 2022-05-24
 */
@Controller
@RequestMapping(value = "${adminPath}/clientmana/clientPersonnel")
public class ClientPersonnelController extends BaseController {

	@Autowired
	private ClientPersonnelService clientPersonnelService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public ClientPersonnel get(String numCode, boolean isNewRecord) {
		return clientPersonnelService.get(numCode, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("clientmana:clientPersonnel:view")
	@RequestMapping(value = {"list", ""})
	public String list(ClientPersonnel clientPersonnel, Model model) {
		model.addAttribute("clientPersonnel", clientPersonnel);
		return "modules/clientmana/clientPersonnelList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("clientmana:clientPersonnel:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<ClientPersonnel> listData(ClientPersonnel clientPersonnel, HttpServletRequest request, HttpServletResponse response) {
		clientPersonnel.setPage(new Page<>(request, response));
		Page<ClientPersonnel> page = clientPersonnelService.findPage(clientPersonnel);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("clientmana:clientPersonnel:view")
	@RequestMapping(value = "form")
	public String form(ClientPersonnel clientPersonnel, Model model) {
		model.addAttribute("clientPersonnel", clientPersonnel);
		return "modules/clientmana/clientPersonnelForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("clientmana:clientPersonnel:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated ClientPersonnel clientPersonnel) {
		clientPersonnelService.save(clientPersonnel);
		return renderResult(Global.TRUE, text("保存单位联系人成功！"));
	}
	
	/**
	 * 停用数据
	 */
	@RequiresPermissions("clientmana:clientPersonnel:edit")
	@RequestMapping(value = "disable")
	@ResponseBody
	public String disable(ClientPersonnel clientPersonnel) {
		clientPersonnel.setStatus(ClientPersonnel.STATUS_DISABLE);
		clientPersonnelService.updateStatus(clientPersonnel);
		return renderResult(Global.TRUE, text("停用单位联系人成功"));
	}
	
	/**
	 * 启用数据
	 */
	@RequiresPermissions("clientmana:clientPersonnel:edit")
	@RequestMapping(value = "enable")
	@ResponseBody
	public String enable(ClientPersonnel clientPersonnel) {
		clientPersonnel.setStatus(ClientPersonnel.STATUS_NORMAL);
		clientPersonnelService.updateStatus(clientPersonnel);
		return renderResult(Global.TRUE, text("启用单位联系人成功"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("clientmana:clientPersonnel:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(ClientPersonnel clientPersonnel) {
		clientPersonnelService.delete(clientPersonnel);
		return renderResult(Global.TRUE, text("删除单位联系人成功！"));
	}
	
}