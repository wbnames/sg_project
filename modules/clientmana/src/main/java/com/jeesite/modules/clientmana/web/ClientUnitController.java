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
import com.jeesite.modules.clientmana.entity.ClientUnit;
import com.jeesite.modules.clientmana.service.ClientUnitService;

/**
 * 客户单位Controller
 * @author lyu
 * @version 2022-05-24
 */
@Controller
@RequestMapping(value = "${adminPath}/clientmana/clientUnit")
public class ClientUnitController extends BaseController {

	@Autowired
	private ClientUnitService clientUnitService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public ClientUnit get(String numCode, boolean isNewRecord) {
		return clientUnitService.get(numCode, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("clientmana:clientUnit:view")
	@RequestMapping(value = {"list", ""})
	public String list(ClientUnit clientUnit, Model model) {
		model.addAttribute("clientUnit", clientUnit);
		return "modules/clientmana/clientUnitList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("clientmana:clientUnit:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<ClientUnit> listData(ClientUnit clientUnit, HttpServletRequest request, HttpServletResponse response) {
		clientUnit.setPage(new Page<>(request, response));
		Page<ClientUnit> page = clientUnitService.findPage(clientUnit);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("clientmana:clientUnit:view")
	@RequestMapping(value = "form")
	public String form(ClientUnit clientUnit, Model model) {
		model.addAttribute("clientUnit", clientUnit);
		return "modules/clientmana/clientUnitForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("clientmana:clientUnit:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated ClientUnit clientUnit) {
		clientUnitService.save(clientUnit);
		return renderResult(Global.TRUE, text("保存客户单位成功！"));
	}
	
	/**
	 * 停用数据
	 */
	@RequiresPermissions("clientmana:clientUnit:edit")
	@RequestMapping(value = "disable")
	@ResponseBody
	public String disable(ClientUnit clientUnit) {
		clientUnit.setStatus(ClientUnit.STATUS_DISABLE);
		clientUnitService.updateStatus(clientUnit);
		return renderResult(Global.TRUE, text("停用客户单位成功"));
	}
	
	/**
	 * 启用数据
	 */
	@RequiresPermissions("clientmana:clientUnit:edit")
	@RequestMapping(value = "enable")
	@ResponseBody
	public String enable(ClientUnit clientUnit) {
		clientUnit.setStatus(ClientUnit.STATUS_NORMAL);
		clientUnitService.updateStatus(clientUnit);
		return renderResult(Global.TRUE, text("启用客户单位成功"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("clientmana:clientUnit:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(ClientUnit clientUnit) {
		clientUnitService.delete(clientUnit);
		return renderResult(Global.TRUE, text("删除客户单位成功！"));
	}
	
}