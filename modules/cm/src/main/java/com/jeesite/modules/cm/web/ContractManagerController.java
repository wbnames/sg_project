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
import com.jeesite.modules.cm.entity.ContractManager;
import com.jeesite.modules.cm.service.ContractManagerService;

/**
 * 合同管理Controller
 * @author wang_bo
 * @version 2022-05-23
 */
@Controller
@RequestMapping(value = "${adminPath}/cm/contractManager")
public class ContractManagerController extends BaseController {

	@Autowired
	private ContractManagerService contractManagerService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public ContractManager get(String numCode, boolean isNewRecord) {
		return contractManagerService.get(numCode, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("cm:contractManager:view")
	@RequestMapping(value = {"list", ""})
	public String list(ContractManager contractManager, Model model) {
		model.addAttribute("contractManager", contractManager);
		return "modules/cm/contractManagerList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("cm:contractManager:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<ContractManager> listData(ContractManager contractManager, HttpServletRequest request, HttpServletResponse response) {
		contractManager.setPage(new Page<>(request, response));
		Page<ContractManager> page = contractManagerService.findPage(contractManager);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("cm:contractManager:view")
	@RequestMapping(value = "form")
	public String form(ContractManager contractManager, Model model) {
		model.addAttribute("contractManager", contractManager);
		return "modules/cm/contractManagerForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("cm:contractManager:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated ContractManager contractManager) {
		contractManagerService.save(contractManager);
		return renderResult(Global.TRUE, text("保存合同管理成功！"));
	}
	
	/**
	 * 停用数据
	 */
	@RequiresPermissions("cm:contractManager:edit")
	@RequestMapping(value = "disable")
	@ResponseBody
	public String disable(ContractManager contractManager) {
		contractManager.setStatus(ContractManager.STATUS_DISABLE);
		contractManagerService.updateStatus(contractManager);
		return renderResult(Global.TRUE, text("停用合同管理成功"));
	}
	
	/**
	 * 启用数据
	 */
	@RequiresPermissions("cm:contractManager:edit")
	@RequestMapping(value = "enable")
	@ResponseBody
	public String enable(ContractManager contractManager) {
		contractManager.setStatus(ContractManager.STATUS_NORMAL);
		contractManagerService.updateStatus(contractManager);
		return renderResult(Global.TRUE, text("启用合同管理成功"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("cm:contractManager:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(ContractManager contractManager) {
		contractManagerService.delete(contractManager);
		return renderResult(Global.TRUE, text("删除合同管理成功！"));
	}
	
}