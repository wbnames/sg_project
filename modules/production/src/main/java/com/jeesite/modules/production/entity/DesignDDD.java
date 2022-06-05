/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.production.entity;

import javax.validation.constraints.NotBlank;
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
 * 生产管理Entity
 * @author wang_bo
 * @version 2022-06-06
 */
@Table(name="design_paper", alias="a", label="生产管理信息", columns={
		@Column(name="num_code", attrName="numCode", label="编号", isPK=true),
		@Column(name="production_code", attrName="productionCode.numCode", label="编号"),
		@Column(name="design_paper_name", attrName="designPaperName", label="设计图纸名称", queryType=QueryType.LIKE),
		@Column(name="design_project", attrName="designProject", label="所属项目"),
		@Column(name="design_contractl", attrName="designContractl", label="所属合同"),
		@Column(name="design_date", attrName="designDate", label="日期"),
		@Column(name="sub_user", attrName="subUser", label="填报人"),
		@Column(includeEntity=DataEntity.class),
		@Column(name="constru_id", attrName="construId", label="constru_id"),
	}, orderBy="a.create_date ASC"
)
public class DesignDDD extends DataEntity<DesignDDD> {
	
	private static final long serialVersionUID = 1L;
	private String numCode;		// 编号
	private ProductionManager productionCode;		// 编号 父类
	private String designPaperName;		// 设计图纸名称
	private String designProject;		// 所属项目
	private String designContractl;		// 所属合同
	private Date designDate;		// 日期
	private String subUser;		// 填报人
	private String construId;		// constru_id
	
	public DesignDDD() {
		this(null);
	}


	public DesignDDD(ProductionManager productionCode){
		this.productionCode = productionCode;
	}
	
	public String getNumCode() {
		return numCode;
	}

	public void setNumCode(String numCode) {
		this.numCode = numCode;
	}
	
	@NotBlank(message="编号不能为空")
	@Length(min=0, max=200, message="编号长度不能超过 200 个字符")
	public ProductionManager getProductionCode() {
		return productionCode;
	}

	public void setProductionCode(ProductionManager productionCode) {
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
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
	
}