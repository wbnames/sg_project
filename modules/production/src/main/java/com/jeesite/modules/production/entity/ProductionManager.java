/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.production.entity;

import org.hibernate.validator.constraints.Length;
import java.util.List;
import com.jeesite.common.collect.ListUtils;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 生产管理Entity
 * @author wang_bo
 * @version 2022-05-24
 */
@Table(name="production_manager", alias="a", label="生产管理信息", columns={
		@Column(name="num_code", attrName="numCode", label="编号", isPK=true),
		@Column(name="production_project", attrName="productionProject", label="关联项目"),
		@Column(name="production_manu", attrName="productionManu", label="生产厂家"),
		@Column(name="production_user", attrName="productionUser", label="填报人"),
		@Column(name="production_status", attrName="productionStatus", label="任务状态"),
		@Column(name="plan_date", attrName="planDate", label="计划完成日期"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class ProductionManager extends DataEntity<ProductionManager> {
	
	private static final long serialVersionUID = 1L;
	private String numCode;		// 编号
	private String productionProject;		// 关联项目
	private String productionManu;		// 生产厂家
	private String productionUser;		// 填报人
	private String productionStatus;		// 任务状态
	private String planDate;		// 计划完成日期
	private List<DesignProductProduction> designProductProductionList = ListUtils.newArrayList();		// 子表列表
	private List<DesignPaperProduction> designPaperProductionList = ListUtils.newArrayList();		// 子表列表
	
	public ProductionManager() {
		this(null);
	}

	public ProductionManager(String id){
		super(id);
	}
	
	public String getNumCode() {
		return numCode;
	}

	public void setNumCode(String numCode) {
		this.numCode = numCode;
	}
	
	@Length(min=0, max=200, message="关联项目长度不能超过 200 个字符")
	public String getProductionProject() {
		return productionProject;
	}

	public void setProductionProject(String productionProject) {
		this.productionProject = productionProject;
	}
	
	@Length(min=0, max=200, message="生产厂家长度不能超过 200 个字符")
	public String getProductionManu() {
		return productionManu;
	}

	public void setProductionManu(String productionManu) {
		this.productionManu = productionManu;
	}
	
	@Length(min=0, max=200, message="填报人长度不能超过 200 个字符")
	public String getProductionUser() {
		return productionUser;
	}

	public void setProductionUser(String productionUser) {
		this.productionUser = productionUser;
	}
	
	@Length(min=0, max=200, message="任务状态长度不能超过 200 个字符")
	public String getProductionStatus() {
		return productionStatus;
	}

	public void setProductionStatus(String productionStatus) {
		this.productionStatus = productionStatus;
	}
	
	@Length(min=0, max=200, message="计划完成日期长度不能超过 200 个字符")
	public String getPlanDate() {
		return planDate;
	}

	public void setPlanDate(String planDate) {
		this.planDate = planDate;
	}
	
	public List<DesignProductProduction> getDesignProductProductionList() {
		return designProductProductionList;
	}

	public void setDesignProductProductionList(List<DesignProductProduction> designProductProductionList) {
		this.designProductProductionList = designProductProductionList;
	}
	
	public List<DesignPaperProduction> getDesignPaperProductionList() {
		return designPaperProductionList;
	}

	public void setDesignPaperProductionList(List<DesignPaperProduction> designPaperProductionList) {
		this.designPaperProductionList = designPaperProductionList;
	}
	
}