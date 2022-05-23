/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.pm.entity;

import org.hibernate.validator.constraints.Length;
import java.util.List;
import com.jeesite.common.collect.ListUtils;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 项目管理Entity
 * @author wang_bo
 * @version 2022-05-23
 */
@Table(name="project_manager", alias="a", label="项目管理信息", columns={
		@Column(name="serial_number", attrName="serialNumber", label="序号", isPK=true),
		@Column(name="name", attrName="name", label="项目名称", queryType=QueryType.LIKE),
		@Column(name="area", attrName="area", label="所在区域"),
		@Column(name="regulators", attrName="regulators", label="行业监管单位"),
		@Column(name="project_status", attrName="projectStatus", label="工程状态"),
		@Column(name="construction_unit", attrName="constructionUnit", label="建设单位"),
		@Column(name="main_contractor", attrName="mainContractor", label="总承包建设单位"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class ProjectManager extends DataEntity<ProjectManager> {
	
	private static final long serialVersionUID = 1L;
	private String serialNumber;		// 序号
	private String name;		// 项目名称
	private String area;		// 所在区域
	private String regulators;		// 行业监管单位
	private String projectStatus;		// 工程状态
	private String constructionUnit;		// 建设单位
	private String mainContractor;		// 总承包建设单位
	private List<ProjectManagerUser> projectManagerUserList = ListUtils.newArrayList();		// 子表列表
	
	public ProjectManager() {
		this(null);
	}

	public ProjectManager(String id){
		super(id);
	}
	
	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	@Length(min=0, max=200, message="项目名称长度不能超过 200 个字符")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=200, message="所在区域长度不能超过 200 个字符")
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	@Length(min=0, max=200, message="行业监管单位长度不能超过 200 个字符")
	public String getRegulators() {
		return regulators;
	}

	public void setRegulators(String regulators) {
		this.regulators = regulators;
	}
	
	@Length(min=0, max=200, message="工程状态长度不能超过 200 个字符")
	public String getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}
	
	@Length(min=0, max=255, message="建设单位长度不能超过 255 个字符")
	public String getConstructionUnit() {
		return constructionUnit;
	}

	public void setConstructionUnit(String constructionUnit) {
		this.constructionUnit = constructionUnit;
	}
	
	@Length(min=0, max=200, message="总承包建设单位长度不能超过 200 个字符")
	public String getMainContractor() {
		return mainContractor;
	}

	public void setMainContractor(String mainContractor) {
		this.mainContractor = mainContractor;
	}
	
	public List<ProjectManagerUser> getProjectManagerUserList() {
		return projectManagerUserList;
	}

	public void setProjectManagerUserList(List<ProjectManagerUser> projectManagerUserList) {
		this.projectManagerUserList = projectManagerUserList;
	}
	
}