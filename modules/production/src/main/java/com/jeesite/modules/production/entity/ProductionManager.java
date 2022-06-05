/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.production.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.common.mybatis.annotation.JoinTable.Type;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.List;
import com.jeesite.common.collect.ListUtils;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 生产管理Entity
 * @author wang_bo
 * @version 2022-06-06
 */
@Table(name="production_manager", alias="a", label="生产管理信息", columns={
		@Column(name="num_code", attrName="numCode", label="编号", isPK=true),
		@Column(name="production_project", attrName="productionProject", label="关联项目"),
		@Column(name="production_manu", attrName="productionManu", label="生产厂商"),
		@Column(name="production_user", attrName="productionUser", label="填报人"),
		@Column(name="production_status", attrName="productionStatus", label="任务状态"),
		@Column(name="plan_start_date", attrName="planStartDate", label="计划开始日期"),
		@Column(name="plan_end_date", attrName="planEndDate", label="计划完成日期"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class ProductionManager extends DataEntity<ProductionManager> {
	
	private static final long serialVersionUID = 1L;
	private String numCode;		// 编号
	private String productionProject;		// 关联项目
	private String productionManu;		// 生产厂商
	private String productionUser;		// 填报人
	private String productionStatus;		// 任务状态
	private Date planStartDate;		// 计划开始日期
	private Date planEndDate;		// 计划完成日期
	private List<DesignPPP> designPPPList = ListUtils.newArrayList();		// 子表列表
	private List<DesignDDD> designDDDList = ListUtils.newArrayList();		// 子表列表
	
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
	
	@Length(min=0, max=200, message="生产厂商长度不能超过 200 个字符")
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
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getPlanStartDate() {
		return planStartDate;
	}

	public void setPlanStartDate(Date planStartDate) {
		this.planStartDate = planStartDate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getPlanEndDate() {
		return planEndDate;
	}

	public void setPlanEndDate(Date planEndDate) {
		this.planEndDate = planEndDate;
	}
	
	public List<DesignPPP> getDesignPPPList() {
		return designPPPList;
	}

	public void setDesignPPPList(List<DesignPPP> designPPPList) {
		this.designPPPList = designPPPList;
	}
	
	public List<DesignDDD> getDesignDDDList() {
		return designDDDList;
	}

	public void setDesignDDDList(List<DesignDDD> designDDDList) {
		this.designDDDList = designDDDList;
	}
	
}