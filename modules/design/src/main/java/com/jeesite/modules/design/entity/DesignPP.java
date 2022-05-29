/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.design.entity;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotBlank;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 设计图纸Entity
 * @author wang_bo
 * @version 2022-05-30
 */
@Table(name="design_product", alias="a", label="设计图纸信息", columns={
		@Column(name="num_code", attrName="numCode", label="编号", isPK=true),
		@Column(name="contractl_code", attrName="contractlCode", label="合同编号"),
		@Column(name="product_name", attrName="productName", label="产品名称", queryType=QueryType.LIKE),
		@Column(name="product_local", attrName="productLocal", label="产品位置"),
		@Column(name="product_id", attrName="productId", label="产品编号"),
		@Column(name="product_color", attrName="productColor", label="产品颜色"),
		@Column(name="product_unit", attrName="productUnit", label="产品厚度"),
		@Column(name="product_type", attrName="productType", label="产品规格"),
		@Column(name="product_area", attrName="productArea", label="产品面积"),
		@Column(name="product_num", attrName="productNum", label="产品数量"),
		@Column(name="product_sum_area", attrName="productSumArea", label="合计面积"),
		@Column(name="remarks_1", attrName="remarks1", label="备注一", queryType=QueryType.LIKE),
		@Column(name="remarks_2", attrName="remarks2", label="备注二", queryType=QueryType.LIKE),
		@Column(name="remarks_3", attrName="remarks3", label="备注三", queryType=QueryType.LIKE),
		@Column(name="production_code", attrName="productionCode.numCode", label="图纸编号"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.create_date ASC"
)
public class DesignPP extends DataEntity<DesignPP> {
	
	private static final long serialVersionUID = 1L;
	private String numCode;		// 编号
	private String contractlCode;		// 合同编号
	private String productName;		// 产品名称
	private String productLocal;		// 产品位置
	private String productId;		// 产品编号
	private String productColor;		// 产品颜色
	private String productUnit;		// 产品厚度
	private String productType;		// 产品规格
	private String productArea;		// 产品面积
	private String productNum;		// 产品数量
	private String productSumArea;		// 合计面积
	private String remarks1;		// 备注一
	private String remarks2;		// 备注二
	private String remarks3;		// 备注三
	private DesignPaper productionCode;		// 图纸编号 父类
	
	public DesignPP() {
		this(null);
	}


	public DesignPP(DesignPaper productionCode){
		this.productionCode = productionCode;
	}
	
	public String getNumCode() {
		return numCode;
	}

	public void setNumCode(String numCode) {
		this.numCode = numCode;
	}
	
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
	
	@Length(min=0, max=200, message="产品位置长度不能超过 200 个字符")
	public String getProductLocal() {
		return productLocal;
	}

	public void setProductLocal(String productLocal) {
		this.productLocal = productLocal;
	}
	
	@Length(min=0, max=200, message="产品编号长度不能超过 200 个字符")
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	@Length(min=0, max=200, message="产品颜色长度不能超过 200 个字符")
	public String getProductColor() {
		return productColor;
	}

	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}
	
	@Length(min=0, max=200, message="产品厚度长度不能超过 200 个字符")
	public String getProductUnit() {
		return productUnit;
	}

	public void setProductUnit(String productUnit) {
		this.productUnit = productUnit;
	}
	
	@Length(min=0, max=200, message="产品规格长度不能超过 200 个字符")
	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}
	
	@Length(min=0, max=200, message="产品面积长度不能超过 200 个字符")
	public String getProductArea() {
		return productArea;
	}

	public void setProductArea(String productArea) {
		this.productArea = productArea;
	}
	
	@Length(min=0, max=200, message="产品数量长度不能超过 200 个字符")
	public String getProductNum() {
		return productNum;
	}

	public void setProductNum(String productNum) {
		this.productNum = productNum;
	}
	
	@Length(min=0, max=255, message="合计面积长度不能超过 255 个字符")
	public String getProductSumArea() {
		return productSumArea;
	}

	public void setProductSumArea(String productSumArea) {
		this.productSumArea = productSumArea;
	}
	
	@Length(min=0, max=255, message="备注一长度不能超过 255 个字符")
	public String getRemarks1() {
		return remarks1;
	}

	public void setRemarks1(String remarks1) {
		this.remarks1 = remarks1;
	}
	
	@Length(min=0, max=255, message="备注二长度不能超过 255 个字符")
	public String getRemarks2() {
		return remarks2;
	}

	public void setRemarks2(String remarks2) {
		this.remarks2 = remarks2;
	}
	
	@Length(min=0, max=255, message="备注三长度不能超过 255 个字符")
	public String getRemarks3() {
		return remarks3;
	}

	public void setRemarks3(String remarks3) {
		this.remarks3 = remarks3;
	}
	
	@NotBlank(message="图纸编号不能为空")
	@Length(min=0, max=200, message="图纸编号长度不能超过 200 个字符")
	public DesignPaper getProductionCode() {
		return productionCode;
	}

	public void setProductionCode(DesignPaper productionCode) {
		this.productionCode = productionCode;
	}
	
}