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
 * 施工人员Entity
 * @author lyu
 * @version 2022-05-30
 */
@Table(name="construciton_personnel", alias="a", label="施工人员信息", columns={
		@Column(name="num_code", attrName="numCode", label="编号", isPK=true),
		@Column(name="name", attrName="name", label="姓名", queryType=QueryType.LIKE),
		@Column(name="sex", attrName="sex", label="性别"),
		@Column(name="id_card", attrName="idCard", label="身份证"),
		@Column(name="post", attrName="post", label="职位"),
		@Column(name="project_id", attrName="projectId", label="所属项目"),
		@Column(name="cu_company", attrName="cuCompany", label="所在单位"),
		@Column(name="phone", attrName="phone", label="联系电话"),
		@Column(name="native_place", attrName="nativePlace", label="籍贯"),
		@Column(name="address", attrName="address", label="所住地址"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class ConstrucitonPersonnel extends DataEntity<ConstrucitonPersonnel> {
	
	private static final long serialVersionUID = 1L;
	private String numCode;		// 编号
	private String name;		// 姓名
	private String sex;		// 性别
	private String idCard;		// 身份证
	private String post;		// 职位
	private String projectId;		// 所属项目
	private String cuCompany;		// 所在单位
	private String phone;		// 联系电话
	private String nativePlace;		// 籍贯
	private String address;		// 所住地址
	
	public ConstrucitonPersonnel() {
		this(null);
	}

	public ConstrucitonPersonnel(String id){
		super(id);
	}
	
	public String getNumCode() {
		return numCode;
	}

	public void setNumCode(String numCode) {
		this.numCode = numCode;
	}
	
	@Length(min=0, max=128, message="姓名长度不能超过 128 个字符")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=8, message="性别长度不能超过 8 个字符")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Length(min=0, max=255, message="身份证长度不能超过 255 个字符")
	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	
	@Length(min=0, max=32, message="职位长度不能超过 32 个字符")
	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}
	
	@Length(min=0, max=128, message="所属项目长度不能超过 128 个字符")
	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	
	@Length(min=0, max=128, message="所在单位长度不能超过 128 个字符")
	public String getCuCompany() {
		return cuCompany;
	}

	public void setCuCompany(String cuCompany) {
		this.cuCompany = cuCompany;
	}
	
	@Length(min=0, max=64, message="联系电话长度不能超过 64 个字符")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Length(min=0, max=255, message="籍贯长度不能超过 255 个字符")
	public String getNativePlace() {
		return nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}
	
	@Length(min=0, max=255, message="所住地址长度不能超过 255 个字符")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}