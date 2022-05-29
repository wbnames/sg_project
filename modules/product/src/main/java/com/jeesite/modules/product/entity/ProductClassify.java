/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.product.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 产品分类Entity
 * @author lyu
 * @version 2022-05-24
 */
@Table(name="product_classify", alias="a", label="产品分类信息", columns={
		@Column(name="num_code", attrName="numCode", label="编号", isPK=true),
		@Column(name="pm_code", attrName="pmCode", label="产品分类代码"),
		@Column(name="pm_unit", attrName="pmUnit", label="产品单位"),
		@Column(name="pm_conut", attrName="pmConut", label="产品数量"),
		@Column(name="pm_size", attrName="pmSize", label="产品尺寸"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class ProductClassify extends DataEntity<ProductClassify> {
	
	private static final long serialVersionUID = 1L;
	private String numCode;		// 编号
	private String pmCode;		// 产品分类代码
	private String pmUnit;		// 产品单位
	private Long pmConut;		// 产品数量
	private String pmSize;		// 产品尺寸
	
	public ProductClassify() {
		this(null);
	}

	public ProductClassify(String id){
		super(id);
	}
	
	public String getNumCode() {
		return numCode;
	}

	public void setNumCode(String numCode) {
		this.numCode = numCode;
	}
	
	@Length(min=0, max=64, message="产品分类代码长度不能超过 64 个字符")
	public String getPmCode() {
		return pmCode;
	}

	public void setPmCode(String pmCode) {
		this.pmCode = pmCode;
	}
	
	@Length(min=0, max=64, message="产品单位长度不能超过 64 个字符")
	public String getPmUnit() {
		return pmUnit;
	}

	public void setPmUnit(String pmUnit) {
		this.pmUnit = pmUnit;
	}
	
	public Long getPmConut() {
		return pmConut;
	}

	public void setPmConut(Long pmConut) {
		this.pmConut = pmConut;
	}
	
	@Length(min=0, max=128, message="产品尺寸长度不能超过 128 个字符")
	public String getPmSize() {
		return pmSize;
	}

	public void setPmSize(String pmSize) {
		this.pmSize = pmSize;
	}
	
}