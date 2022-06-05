/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.constru.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 施工任务Entity
 * @author lyu
 * @version 2022-06-06
 */
@Table(name="construction_team_copy1", alias="a", label="施工任务信息", columns={
		@Column(name="num_code", attrName="numCode", label="编号", isPK=true),
		@Column(name="name", attrName="name", label="班组名称", queryType=QueryType.LIKE),
		@Column(name="leader", attrName="leader", label="班组长名称"),
		@Column(name="leader_phone", attrName="leaderPhone", label="班组长联系电话"),
		@Column(name="project_name", attrName="projectName", label="项目名称", queryType=QueryType.LIKE),
		@Column(name="company", attrName="company", label="所属企业"),
		@Column(includeEntity=DataEntity.class),
		@Column(name="constru_id", attrName="construId.numCode", label="constru_id"),
	}, orderBy="a.create_date ASC"
)
public class ConstructionTeamCopy1 extends DataEntity<ConstructionTeamCopy1> {
	
	private static final long serialVersionUID = 1L;
	private String numCode;		// 编号
	private String name;		// 班组名称
	private String leader;		// 班组长名称
	private String leaderPhone;		// 班组长联系电话
	private String projectName;		// 项目名称
	private String company;		// 所属企业
	private ConstruTask construId;		// constru_id 父类
	
	public ConstructionTeamCopy1() {
		this(null);
	}


	public ConstructionTeamCopy1(ConstruTask construId){
		this.construId = construId;
	}
	
	public String getNumCode() {
		return numCode;
	}

	public void setNumCode(String numCode) {
		this.numCode = numCode;
	}
	
	@Length(min=0, max=64, message="班组名称长度不能超过 64 个字符")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=64, message="班组长名称长度不能超过 64 个字符")
	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}
	
	@Length(min=0, max=64, message="班组长联系电话长度不能超过 64 个字符")
	public String getLeaderPhone() {
		return leaderPhone;
	}

	public void setLeaderPhone(String leaderPhone) {
		this.leaderPhone = leaderPhone;
	}
	
	@Length(min=0, max=64, message="项目名称长度不能超过 64 个字符")
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	@Length(min=0, max=64, message="所属企业长度不能超过 64 个字符")
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	@Length(min=0, max=128, message="constru_id长度不能超过 128 个字符")
	public ConstruTask getConstruId() {
		return construId;
	}

	public void setConstruId(ConstruTask construId) {
		this.construId = construId;
	}
	
}