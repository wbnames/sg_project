/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.clientmana.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 客户单位Entity
 * @author lyu
 * @version 2022-05-24
 */
@Table(name="client_unit", alias="a", label="客户单位信息", columns={
		@Column(name="num_code", attrName="numCode", label="编号", isPK=true),
		@Column(name="name", attrName="name", label="客户单位名称", queryType=QueryType.LIKE),
		@Column(name="area", attrName="area", label="单位区域"),
		@Column(name="address", attrName="address", label="详细地址"),
		@Column(name="office_phone", attrName="officePhone", label="办公电话"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class ClientUnit extends DataEntity<ClientUnit> {
	
	private static final long serialVersionUID = 1L;
	private String numCode;		// 编号
	private String name;		// 客户单位名称
	private String area;		// 单位区域
	private String address;		// 详细地址
	private Long officePhone;		// 办公电话
	
	public ClientUnit() {
		this(null);
	}

	public ClientUnit(String id){
		super(id);
	}
	
	public String getNumCode() {
		return numCode;
	}

	public void setNumCode(String numCode) {
		this.numCode = numCode;
	}
	
	@Length(min=0, max=64, message="客户单位名称长度不能超过 64 个字符")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=128, message="单位区域长度不能超过 128 个字符")
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	@Length(min=0, max=128, message="详细地址长度不能超过 128 个字符")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public Long getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(Long officePhone) {
		this.officePhone = officePhone;
	}
	
}