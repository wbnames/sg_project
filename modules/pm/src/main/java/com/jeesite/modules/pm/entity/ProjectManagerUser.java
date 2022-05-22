/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.pm.entity;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 项目管理Entity
 * @author wang_bo
 * @version 2022-05-22
 */
@Table(name="project_manager_user", alias="a", label="项目管理信息", columns={
		@Column(name="user_code", attrName="userCode", label="用户编码", isPK=true),
		@Column(name="serial_number", attrName="serialNumber.serialNumber", label="序号"),
		@Column(name="user_desc", attrName="userDesc", label="用户介绍"),
		@Column(name="status", attrName="status", label="状态", isUpdate=false),
	}, orderBy="a.user_code ASC"
)
public class ProjectManagerUser extends DataEntity<ProjectManagerUser> {
	
	private static final long serialVersionUID = 1L;
	private String userCode;		// 用户编码
	private ProjectManager serialNumber;		// 序号 父类
	private String userDesc;		// 用户介绍
	
	public ProjectManagerUser() {
		this(null);
	}


	public ProjectManagerUser(ProjectManager serialNumber){
		this.serialNumber = serialNumber;
	}
	
	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	
	@NotBlank(message="序号不能为空")
	@Length(min=0, max=200, message="序号长度不能超过 200 个字符")
	public ProjectManager getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(ProjectManager serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	@Length(min=0, max=200, message="用户介绍长度不能超过 200 个字符")
	public String getUserDesc() {
		return userDesc;
	}

	public void setUserDesc(String userDesc) {
		this.userDesc = userDesc;
	}
	
}