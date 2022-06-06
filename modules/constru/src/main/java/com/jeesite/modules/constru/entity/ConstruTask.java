/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.constru.entity;

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
 * 施工任务Entity
 * @author lyu
 * @version 2022-05-24
 */
@Table(name="constru_task", alias="a", label="施工任务信息", columns={
		@Column(name="num_code", attrName="numCode", label="编号", isPK=true),
		@Column(name="task_name", attrName="taskName", label="任务名称", queryType=QueryType.LIKE),
		@Column(name="project_id", attrName="projectId", label="所属项目"),
		@Column(name="task_status", attrName="taskStatus", label="任务状态"),
		@Column(name="start_date", attrName="startDate", label="开始日期"),
		@Column(name="plan_accomplish_date", attrName="planAccomplishDate", label="计划完成日期"),
		@Column(name="total_time", attrName="totalTime", label="总体用时"),
		@Column(name="principal_id", attrName="principalId", label="负责人"),
		@Column(name="design_paper", attrName="designPaper", label="设计图纸"),
		@Column(name="product_record", attrName="productRecord", label="产品列表"),
		@Column(name="constru_team", attrName="construTeam", label="施工班组"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class ConstruTask extends DataEntity<ConstruTask> {
	
	private static final long serialVersionUID = 1L;
	private String numCode;		// 编号
	private String taskName;		// 任务名称
	private String projectId;		// 所属项目
	private Long taskStatus;		// 任务状态
	private Date startDate;		// 开始日期
	private Date planAccomplishDate;		// 计划完成日期
	private Double totalTime;		// 总体用时
	private String principalId;		// 负责人
	private String designPaper;		// 设计图纸
	private String productRecord;		// 产品列表
	private String construTeam;		// 施工班组
	private List<ProductClassifyCopy1> productClassifyCopy1List = ListUtils.newArrayList();		// 子表列表
	private List<ConstructionTeamCopy1> constructionTeamCopy1List = ListUtils.newArrayList();		// 子表列表
	private List<DesignPaperCopy1> designPaperCopy1List = ListUtils.newArrayList();		// 子表列表
	
	public ConstruTask() {
		this(null);
	}

	public ConstruTask(String id){
		super(id);
	}
	
	public String getNumCode() {
		return numCode;
	}

	public void setNumCode(String numCode) {
		this.numCode = numCode;
	}
	
	@Length(min=0, max=64, message="任务名称长度不能超过 64 个字符")
	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
	@Length(min=0, max=128, message="所属项目长度不能超过 128 个字符")
	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	
	public Long getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(Long taskStatus) {
		this.taskStatus = taskStatus;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getPlanAccomplishDate() {
		return planAccomplishDate;
	}

	public void setPlanAccomplishDate(Date planAccomplishDate) {
		this.planAccomplishDate = planAccomplishDate;
	}
	
	public Double getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(Double totalTime) {
		this.totalTime = totalTime;
	}
	
	@Length(min=0, max=64, message="负责人长度不能超过 64 个字符")
	public String getPrincipalId() {
		return principalId;
	}

	public void setPrincipalId(String principalId) {
		this.principalId = principalId;
	}
	
	@Length(min=0, max=64, message="设计图纸长度不能超过 64 个字符")
	public String getDesignPaper() {
		return designPaper;
	}

	public void setDesignPaper(String designPaper) {
		this.designPaper = designPaper;
	}
	
	@Length(min=0, max=128, message="产品列表长度不能超过 128 个字符")
	public String getProductRecord() {
		return productRecord;
	}

	public void setProductRecord(String productRecord) {
		this.productRecord = productRecord;
	}
	
	@Length(min=0, max=64, message="施工班组长度不能超过 64 个字符")
	public String getConstruTeam() {
		return construTeam;
	}

	public void setConstruTeam(String construTeam) {
		this.construTeam = construTeam;
	}
	
	public List<ProductClassifyCopy1> getProductClassifyCopy1List() {
		return productClassifyCopy1List;
	}

	public void setProductClassifyCopy1List(List<ProductClassifyCopy1> productClassifyCopy1List) {
		this.productClassifyCopy1List = productClassifyCopy1List;
	}
	
	public List<ConstructionTeamCopy1> getConstructionTeamCopy1List() {
		return constructionTeamCopy1List;
	}

	public void setConstructionTeamCopy1List(List<ConstructionTeamCopy1> constructionTeamCopy1List) {
		this.constructionTeamCopy1List = constructionTeamCopy1List;
	}
	
	public List<DesignPaperCopy1> getDesignPaperCopy1List() {
		return designPaperCopy1List;
	}

	public void setDesignPaperCopy1List(List<DesignPaperCopy1> designPaperCopy1List) {
		this.designPaperCopy1List = designPaperCopy1List;
	}
	
}