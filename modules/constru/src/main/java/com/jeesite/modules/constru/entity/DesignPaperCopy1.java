/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.constru.entity;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 施工任务Entity
 * @author lyu
 * @version 2022-05-24
 */
@Table(name="design_paper_copy1", alias="a", label="施工任务信息", columns={
		@Column(name="num_code", attrName="numCode", label="编号", isPK=true),
		@Column(name="production_code", attrName="productionCode", label="编号"),
		@Column(name="design_paper_name", attrName="designPaperName", label="设计图纸名称", queryType=QueryType.LIKE),
		@Column(name="design_project", attrName="designProject", label="所属项目"),
		@Column(name="design_contractl", attrName="designContractl", label="所属合同"),
		@Column(name="payment_sum", attrName="paymentSum", label="金额"),
		@Column(name="payment_sum_ac", attrName="paymentSumAc", label="金额大写"),
		@Column(name="sub_unit", attrName="subUnit", label="提交单位"),
		@Column(name="design_date", attrName="designDate", label="日期"),
		@Column(name="sub_user", attrName="subUser", label="填报人"),
		@Column(includeEntity=DataEntity.class),
		@Column(name="constru_id", attrName="construId.numCode", label="constru_id"),
	}, orderBy="a.create_date ASC"
)
public class DesignPaperCopy1 extends DataEntity<DesignPaperCopy1> {
	
	private static final long serialVersionUID = 1L;
	private String numCode;		// 编号
	private String productionCode;		// 编号
	private String designPaperName;		// 设计图纸名称
	private String designProject;		// 所属项目
	private String designContractl;		// 所属合同
	private String paymentSum;		// 金额
	private String paymentSumAc;		// 金额大写
	private String subUnit;		// 提交单位
	private String designDate;		// 日期
	private String subUser;		// 填报人
	private ConstruTask construId;		// constru_id 父类
	
	public DesignPaperCopy1() {
		this(null);
	}


	public DesignPaperCopy1(ConstruTask construId){
		this.construId = construId;
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
	
	@Length(min=0, max=64, message="金额长度不能超过 64 个字符")
	public String getPaymentSum() {
		return paymentSum;
	}

	public void setPaymentSum(String paymentSum) {
		this.paymentSum = paymentSum;
	}
	
	@Length(min=0, max=64, message="金额大写长度不能超过 64 个字符")
	public String getPaymentSumAc() {
		return paymentSumAc;
	}

	public void setPaymentSumAc(String paymentSumAc) {
		this.paymentSumAc = paymentSumAc;
	}
	
	@Length(min=0, max=128, message="提交单位长度不能超过 128 个字符")
	public String getSubUnit() {
		return subUnit;
	}

	public void setSubUnit(String subUnit) {
		this.subUnit = subUnit;
	}
	
	@Length(min=0, max=200, message="日期长度不能超过 200 个字符")
	public String getDesignDate() {
		return designDate;
	}

	public void setDesignDate(String designDate) {
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
	public ConstruTask getConstruId() {
		return construId;
	}

	public void setConstruId(ConstruTask construId) {
		this.construId = construId;
	}
	
}