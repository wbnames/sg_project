/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.constru.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.common.mybatis.annotation.JoinTable.Type;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 施工日志Entity
 * @author lyu
 * @version 2022-05-30
 */
@Table(name="constru_task_log", alias="a", label="施工日志信息", columns={
		@Column(name="num_code", attrName="numCode", label="编号", isPK=true),
		@Column(name="constru_task_id", attrName="construTaskId", label="施工任务"),
		@Column(name="subject", attrName="subject", label="日志主题"),
		@Column(name="record_date", attrName="recordDate", label="登记日期"),
		@Column(name="man_hour", attrName="manHour", label="工时"),
		@Column(name="record_user", attrName="recordUser", label="填报人"),
		@Column(name="constru_progress", attrName="construProgress", label="施工进展"),
		@Column(name="constru_work", attrName="construWork", label="施工有关主要工作"),
		@Column(name="product", attrName="product", label="所属项目"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class ConstruTaskLog extends DataEntity<ConstruTaskLog> {
	
	private static final long serialVersionUID = 1L;
	private String numCode;		// 编号
	private String construTaskId;		// 施工任务
	private String subject;		// 日志主题
	private Date recordDate;		// 登记日期
	private Double manHour;		// 工时
	private String recordUser;		// 填报人
	private String construProgress;		// 施工进展
	private String construWork;		// 施工有关主要工作
	private String product;		// 所属项目
	
	public ConstruTaskLog() {
		this(null);
	}

	public ConstruTaskLog(String id){
		super(id);
	}
	
	public String getNumCode() {
		return numCode;
	}

	public void setNumCode(String numCode) {
		this.numCode = numCode;
	}
	
	@Length(min=0, max=64, message="施工任务长度不能超过 64 个字符")
	public String getConstruTaskId() {
		return construTaskId;
	}

	public void setConstruTaskId(String construTaskId) {
		this.construTaskId = construTaskId;
	}
	
	@Length(min=0, max=128, message="日志主题长度不能超过 128 个字符")
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}
	
	public Double getManHour() {
		return manHour;
	}

	public void setManHour(Double manHour) {
		this.manHour = manHour;
	}
	
	@Length(min=0, max=32, message="填报人长度不能超过 32 个字符")
	public String getRecordUser() {
		return recordUser;
	}

	public void setRecordUser(String recordUser) {
		this.recordUser = recordUser;
	}
	
	@Length(min=0, max=512, message="施工进展长度不能超过 512 个字符")
	public String getConstruProgress() {
		return construProgress;
	}

	public void setConstruProgress(String construProgress) {
		this.construProgress = construProgress;
	}
	
	@Length(min=0, max=1024, message="施工有关主要工作长度不能超过 1024 个字符")
	public String getConstruWork() {
		return construWork;
	}

	public void setConstruWork(String construWork) {
		this.construWork = construWork;
	}
	
	@Length(min=0, max=64, message="所属项目长度不能超过 64 个字符")
	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}
	
}