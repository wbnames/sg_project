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
 * @version 2022-05-24
 */
@Table(name="product_classify_copy1", alias="a", label="施工任务信息", columns={
		@Column(name="num_code", attrName="numCode", label="编号", isPK=true),
		@Column(name="pm_code", attrName="pmCode", label="产品分类代码"),
		@Column(name="pm_unit", attrName="pmUnit", label="产品单位"),
		@Column(name="pm_conut", attrName="pmConut", label="产品数量"),
		@Column(name="pm_size", attrName="pmSize", label="产品尺寸"),
		@Column(includeEntity=DataEntity.class),
		@Column(name="constru_id", attrName="construId.numCode", label="constru_id", isPK=true),
	}, orderBy="a.create_date ASC"
)
public class ProductClassifyCopy1 extends DataEntity<ProductClassifyCopy1> {
	
	private static final long serialVersionUID = 1L;
	private String numCode;		// 编号
	private String pmCode;		// 产品分类代码
	private String pmUnit;		// 产品单位
	private Long pmConut;		// 产品数量
	private String pmSize;		// 产品尺寸
	private ConstruTask construId;		// constru_id 父类
	
	public ProductClassifyCopy1() {
		this(null);
	}


	public ProductClassifyCopy1(ConstruTask construId){
		this.construId = construId;
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
	
	public ConstruTask getConstruId() {
		return construId;
	}

	public void setConstruId(ConstruTask construId) {
		this.construId = construId;
	}
	
}