/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.production.entity;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 生产管理Entity
 * @author wang_bo
 * @version 2022-05-24
 */
@Table(name="design_product", alias="a", label="生产管理信息", columns={
		@Column(name="num_code", attrName="numCode", label="编号", isPK=true),
		@Column(name="contractl_code", attrName="contractlCode", label="合同编号"),
		@Column(name="product_name", attrName="productName", label="产品名称", queryType=QueryType.LIKE),
		@Column(name="production_code", attrName="productionCode.numCode", label="编号"),
		@Column(name="product_specification", attrName="productSpecification", label="产品规格"),
		@Column(name="product_version", attrName="productVersion", label="产品型号"),
		@Column(name="product_type", attrName="productType", label="分类"),
		@Column(name="product_unit", attrName="productUnit", label="产品单位"),
		@Column(name="product_num", attrName="productNum", label="产品数量"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.create_date ASC"
)
public class DesignProductProduction extends DataEntity<DesignProductProduction> {
	
	private static final long serialVersionUID = 1L;
	private String numCode;		// 编号
	private String contractlCode;		// 合同编号
	private String productName;		// 产品名称
	private ProductionManager productionCode;		// 编号 父类
	private String productSpecification;		// 产品规格
	private String productVersion;		// 产品型号
	private String productType;		// 分类
	private String productUnit;		// 产品单位
	private String productNum;		// 产品数量
	
	public DesignProductProduction() {
		this(null);
	}


	public DesignProductProduction(ProductionManager productionCode){
		this.productionCode = productionCode;
	}
	
	public String getNumCode() {
		return numCode;
	}

	public void setNumCode(String numCode) {
		this.numCode = numCode;
	}
	
	@NotBlank(message="合同编号不能为空")
	@Length(min=0, max=200, message="合同编号长度不能超过 200 个字符")
	public String getContractlCode() {
		return contractlCode;
	}

	public void setContractlCode(String contractlCode) {
		this.contractlCode = contractlCode;
	}
	
	@Length(min=0, max=200, message="产品名称长度不能超过 200 个字符")
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	@NotBlank(message="编号不能为空")
	@Length(min=0, max=200, message="编号长度不能超过 200 个字符")
	public ProductionManager getProductionCode() {
		return productionCode;
	}

	public void setProductionCode(ProductionManager productionCode) {
		this.productionCode = productionCode;
	}
	
	@Length(min=0, max=200, message="产品规格长度不能超过 200 个字符")
	public String getProductSpecification() {
		return productSpecification;
	}

	public void setProductSpecification(String productSpecification) {
		this.productSpecification = productSpecification;
	}
	
	@Length(min=0, max=200, message="产品型号长度不能超过 200 个字符")
	public String getProductVersion() {
		return productVersion;
	}

	public void setProductVersion(String productVersion) {
		this.productVersion = productVersion;
	}
	
	@Length(min=0, max=200, message="分类长度不能超过 200 个字符")
	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}
	
	@Length(min=0, max=200, message="产品单位长度不能超过 200 个字符")
	public String getProductUnit() {
		return productUnit;
	}

	public void setProductUnit(String productUnit) {
		this.productUnit = productUnit;
	}
	
	@Length(min=0, max=200, message="产品数量长度不能超过 200 个字符")
	public String getProductNum() {
		return productNum;
	}

	public void setProductNum(String productNum) {
		this.productNum = productNum;
	}
	
}