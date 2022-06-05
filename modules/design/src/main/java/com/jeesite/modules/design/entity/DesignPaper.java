/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.design.entity;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import java.util.Date;
import java.util.List;
import com.jeesite.common.collect.ListUtils;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 设计图纸Entity
 * @author wang_bo
 * @version 2022-05-30
 */
@Table(name="design_paper", alias="a", label="设计图纸信息", columns={
		@Column(name="num_code", attrName="numCode", label="编号", isPK=true),
		@Column(name="production_code", attrName="productionCode", label="编号"),
		@Column(name="design_paper_name", attrName="designPaperName", label="设计图纸名称", queryType=QueryType.LIKE),
		@Column(name="design_project", attrName="designProject", label="所属项目"),
		@Column(name="design_contractl", attrName="designContractl", label="所属合同"),
		@Column(name="design_date", attrName="designDate", label="日期"),
		@Column(name="sub_user", attrName="subUser", label="填报人"),
		@Column(includeEntity=DataEntity.class),
		@Column(name="constru_id", attrName="construId", label="constru_id"),
	}, orderBy="a.update_date DESC"
)
public class DesignPaper extends DataEntity<DesignPaper> {
	
	private static final long serialVersionUID = 1L;
	private String numCode;		// 编号
	private String productionCode;		// 编号
	private String designPaperName;		// 设计图纸名称
	private String designProject;		// 所属项目
	private String designContractl;		// 所属合同
	private Date designDate;		// 日期
	private String subUser;		// 填报人
	private String construId;		// constru_id
	private List<DesignPP> designPPList = ListUtils.newArrayList();		// 子表列表
	
	public DesignPaper() {
		this(null);
	}

	public DesignPaper(String id){
		super(id);
	}
	
	public String getNumCode() {
		return numCode;
	}

	public void setNumCode(String numCode) {
		this.numCode = numCode;
	}
	
	@NotBlank(message="编号不能为空")
	@Length(min=0, max=200, message="编号长度不能超过 200 个字符")
	public String getProductionCode() {
		return productionCode;
	}

	public void setProductionCode(String productionCode) {
		this.productionCode = productionCode;
	}
	
	@Length(min=0, max=200, message="设计图纸名称长度不能超过 200 个字符")
	public String getDesignPaperName() {
		return designPaperName;
	}

	public void setDesignPaperName(String designPaperName) {
		this.designPaperName = designPaperName;
	}
	
	@Length(min=0, max=128, message="所属项目长度不能超过 128 个字符")
	public String getDesignProject() {
		return designProject;
	}

	public void setDesignProject(String designProject) {
		this.designProject = designProject;
	}
	
	@Length(min=0, max=200, message="所属合同长度不能超过 200 个字符")
	public String getDesignContractl() {
		return designContractl;
	}

	public void setDesignContractl(String designContractl) {
		this.designContractl = designContractl;
	}
	
	@Length(min=0, max=200, message="日期长度不能超过 200 个字符")
	public Date getDesignDate() {
		return designDate;
	}

	public void setDesignDate(Date designDate) {
		this.designDate = designDate;
	}
	
	@Length(min=0, max=64, message="填报人长度不能超过 64 个字符")
	public String getSubUser() {
		return subUser;
	}

	public void setSubUser(String subUser) {
		this.subUser = subUser;
	}
	
	@Length(min=0, max=255, message="constru_id长度不能超过 255 个字符")
	public String getConstruId() {
		return construId;
	}

	public void setConstruId(String construId) {
		this.construId = construId;
	}
	
	public List<DesignPP> getDesignPPList() {
		return designPPList;
	}

	public void setDesignPPList(List<DesignPP> designPPList) {
		this.designPPList = designPPList;
	}
	
}