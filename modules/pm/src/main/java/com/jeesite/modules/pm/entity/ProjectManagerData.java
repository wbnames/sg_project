/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.pm.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 项目管理-建设单位Entity
 * @author wang_bo
 * @version 2022-05-22
 */
@Table(name="project_manager_data", alias="a", label="项目管理-建设单位信息", columns={
		@Column(name="serial_number", attrName="serialNumber", label="serial_number", isPK=true),
		@Column(name="construction_unit", attrName="constructionUnit", label="construction_unit"),
	}, orderBy="a.serial_number DESC"
)
public class ProjectManagerData extends DataEntity<ProjectManagerData> {
	
	private static final long serialVersionUID = 1L;
	private String serialNumber;		// serial_number
	private String constructionUnit;		// construction_unit
	
	public ProjectManagerData() {
		this(null);
	}

	public ProjectManagerData(String id){
		super(id);
	}
	
	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	@Length(min=0, max=200, message="construction_unit长度不能超过 200 个字符")
	public String getConstructionUnit() {
		return constructionUnit;
	}

	public void setConstructionUnit(String constructionUnit) {
		this.constructionUnit = constructionUnit;
	}
	
}