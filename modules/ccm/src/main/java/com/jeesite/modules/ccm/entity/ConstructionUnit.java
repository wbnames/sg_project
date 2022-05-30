/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.ccm.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 施工单位Entity
 * @author lyu
 * @version 2022-05-30
 */
@Table(name="construction_unit", alias="a", label="施工单位信息", columns={
		@Column(name="num_code", attrName="numCode", label="编号", isPK=true),
		@Column(name="name", attrName="name", label="单位名称", queryType=QueryType.LIKE),
		@Column(name="area", attrName="area", label="所在区域"),
		@Column(name="address", attrName="address", label="详细地址"),
		@Column(name="phone", attrName="phone", label="联系电话"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class ConstructionUnit extends DataEntity<ConstructionUnit> {
	
	private static final long serialVersionUID = 1L;
	private String numCode;		// 编号
	private String name;		// 单位名称
	private String area;		// 所在区域
	private String address;		// 详细地址
	private Long phone;		// 联系电话
	
	public ConstructionUnit() {
		this(null);
	}

	public ConstructionUnit(String id){
		super(id);
	}
	
	public String getNumCode() {
		return numCode;
	}

	public void setNumCode(String numCode) {
		this.numCode = numCode;
	}
	
	@Length(min=0, max=128, message="单位名称长度不能超过 128 个字符")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=128, message="所在区域长度不能超过 128 个字符")
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	@Length(min=0, max=256, message="详细地址长度不能超过 256 个字符")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}
	
}