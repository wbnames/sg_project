/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.design.web;

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
import com.jeesite.modules.design.entity.DesignPaper;
import com.jeesite.modules.design.entity.DesignFFF;
import com.jeesite.modules.design.service.DesignPaperService;

/**
 * 设计图纸Controller
 * @author wang_bo
 * @version 2022-06-06
 */
@Controller
@RequestMapping(value = "${adminPath}/design/designPaper")
public class DesignPaperController extends BaseController {

	@Autowired
	private DesignPaperService designPaperService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public DesignPaper get(String numCode, boolean isNewRecord) {
		return designPaperService.get(numCode, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("design:designPaper:view")
	@RequestMapping(value = {"list", ""})
	public String list(DesignPaper designPaper, Model model) {
		model.addAttribute("designPaper", designPaper);
		return "modules/design/designPaperList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("design:designPaper:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<DesignPaper> listData(DesignPaper designPaper, HttpServletRequest request, HttpServletResponse response) {
		designPaper.setPage(new Page<>(request, response));
		Page<DesignPaper> page = designPaperService.findPage(designPaper);
		return page;
	}
	
	/**
	 * 查询子表数据
	 */
	@RequiresPermissions("design:designPaper:view")
	@RequestMapping(value = "designFFFListData")
	@ResponseBody
	public Page<DesignFFF> subListData(DesignFFF designFFF, HttpServletRequest request, HttpServletResponse response) {
		designFFF.setPage(new Page<>(request, response));
		Page<DesignFFF> page = designPaperService.findSubPage(designFFF);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("design:designPaper:view")
	@RequestMapping(value = "form")
	public String form(DesignPaper designPaper, Model model) {
		model.addAttribute("designPaper", designPaper);
		return "modules/design/designPaperForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("design:designPaper:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated DesignPaper designPaper) {
		designPaperService.save(designPaper);
		return renderResult(Global.TRUE, text("保存设计图纸成功！"));
	}
	
	/**
	 * 停用数据
	 */
	@RequiresPermissions("design:designPaper:edit")
	@RequestMapping(value = "disable")
	@ResponseBody
	public String disable(DesignPaper designPaper) {
		designPaper.setStatus(DesignPaper.STATUS_DISABLE);
		designPaperService.updateStatus(designPaper);
		return renderResult(Global.TRUE, text("停用设计图纸成功"));
	}
	
	/**
	 * 启用数据
	 */
	@RequiresPermissions("design:designPaper:edit")
	@RequestMapping(value = "enable")
	@ResponseBody
	public String enable(DesignPaper designPaper) {
		designPaper.setStatus(DesignPaper.STATUS_NORMAL);
		designPaperService.updateStatus(designPaper);
		return renderResult(Global.TRUE, text("启用设计图纸成功"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("design:designPaper:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(DesignPaper designPaper) {
		designPaperService.delete(designPaper);
		return renderResult(Global.TRUE, text("删除设计图纸成功！"));
	}
	
}