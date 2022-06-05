/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.logistics.entity;

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
 * 发货管理Entity
 * @author wang_bo
 * @version 2022-06-06
 */
@Table(name="shipments_logistics", alias="a", label="发货管理信息", columns={
		@Column(name="num_code", attrName="numCode", label="编码", isPK=true),
		@Column(name="shipments_name", attrName="shipmentsName", label="发货主题", queryType=QueryType.LIKE),
		@Column(name="shipments_project", attrName="shipmentsProject", label="所属项目"),
		@Column(name="shipments_manufacturer", attrName="shipmentsManufacturer", label="发货厂商"),
		@Column(name="shipments_user", attrName="shipmentsUser", label="发货人"),
		@Column(name="shipments_user_phone", attrName="shipmentsUserPhone", label="发货人电话"),
		@Column(name="shipments_date", attrName="shipmentsDate", label="发货日期"),
		@Column(name="shipments_address", attrName="shipmentsAddress", label="发货地址"),
		@Column(name="shipments_odd", attrName="shipmentsOdd", label="发货单号"),
		@Column(name="shipments_cost", attrName="shipmentsCost", label="快递费用"),
		@Column(name="shipments_com", attrName="shipmentsCom", label="快递公司"),
		@Column(name="shipments_status", attrName="shipmentsStatus", label="发货状态"),
		@Column(name="consignee", attrName="consignee", label="收货人"),
		@Column(name="consignee_phone", attrName="consigneePhone", label="收货人电话"),
		@Column(name="consignee_address", attrName="consigneeAddress", label="收货人地址"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class ShipmentsLogistics extends DataEntity<ShipmentsLogistics> {
	
	private static final long serialVersionUID = 1L;
	private String numCode;		// 编码
	private String shipmentsName;		// 发货主题
	private String shipmentsProject;		// 所属项目
	private String shipmentsManufacturer;		// 发货厂商
	private String shipmentsUser;		// 发货人
	private String shipmentsUserPhone;		// 发货人电话
	private Date shipmentsDate;		// 发货日期
	private String shipmentsAddress;		// 发货地址
	private String shipmentsOdd;		// 发货单号
	private String shipmentsCost;		// 快递费用
	private String shipmentsCom;		// 快递公司
	private String shipmentsStatus;		// 发货状态
	private String consignee;		// 收货人
	private String consigneePhone;		// 收货人电话
	private String consigneeAddress;		// 收货人地址
	
	public ShipmentsLogistics() {
		this(null);
	}

	public ShipmentsLogistics(String id){
		super(id);
	}
	
	public String getNumCode() {
		return numCode;
	}

	public void setNumCode(String numCode) {
		this.numCode = numCode;
	}
	
	@Length(min=0, max=200, message="发货主题长度不能超过 200 个字符")
	public String getShipmentsName() {
		return shipmentsName;
	}

	public void setShipmentsName(String shipmentsName) {
		this.shipmentsName = shipmentsName;
	}
	
	@Length(min=0, max=200, message="所属项目长度不能超过 200 个字符")
	public String getShipmentsProject() {
		return shipmentsProject;
	}

	public void setShipmentsProject(String shipmentsProject) {
		this.shipmentsProject = shipmentsProject;
	}
	
	@Length(min=0, max=200, message="发货厂商长度不能超过 200 个字符")
	public String getShipmentsManufacturer() {
		return shipmentsManufacturer;
	}

	public void setShipmentsManufacturer(String shipmentsManufacturer) {
		this.shipmentsManufacturer = shipmentsManufacturer;
	}
	
	@Length(min=0, max=200, message="发货人长度不能超过 200 个字符")
	public String getShipmentsUser() {
		return shipmentsUser;
	}

	public void setShipmentsUser(String shipmentsUser) {
		this.shipmentsUser = shipmentsUser;
	}
	
	@Length(min=0, max=200, message="发货人电话长度不能超过 200 个字符")
	public String getShipmentsUserPhone() {
		return shipmentsUserPhone;
	}

	public void setShipmentsUserPhone(String shipmentsUserPhone) {
		this.shipmentsUserPhone = shipmentsUserPhone;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getShipmentsDate() {
		return shipmentsDate;
	}

	public void setShipmentsDate(Date shipmentsDate) {
		this.shipmentsDate = shipmentsDate;
	}
	
	@Length(min=0, max=200, message="发货地址长度不能超过 200 个字符")
	public String getShipmentsAddress() {
		return shipmentsAddress;
	}

	public void setShipmentsAddress(String shipmentsAddress) {
		this.shipmentsAddress = shipmentsAddress;
	}
	
	@Length(min=0, max=200, message="发货单号长度不能超过 200 个字符")
	public String getShipmentsOdd() {
		return shipmentsOdd;
	}

	public void setShipmentsOdd(String shipmentsOdd) {
		this.shipmentsOdd = shipmentsOdd;
	}
	
	@Length(min=0, max=200, message="快递费用长度不能超过 200 个字符")
	public String getShipmentsCost() {
		return shipmentsCost;
	}

	public void setShipmentsCost(String shipmentsCost) {
		this.shipmentsCost = shipmentsCost;
	}
	
	@Length(min=0, max=200, message="快递公司长度不能超过 200 个字符")
	public String getShipmentsCom() {
		return shipmentsCom;
	}

	public void setShipmentsCom(String shipmentsCom) {
		this.shipmentsCom = shipmentsCom;
	}
	
	@Length(min=0, max=200, message="发货状态长度不能超过 200 个字符")
	public String getShipmentsStatus() {
		return shipmentsStatus;
	}

	public void setShipmentsStatus(String shipmentsStatus) {
		this.shipmentsStatus = shipmentsStatus;
	}
	
	@Length(min=0, max=200, message="收货人长度不能超过 200 个字符")
	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	
	@Length(min=0, max=200, message="收货人电话长度不能超过 200 个字符")
	public String getConsigneePhone() {
		return consigneePhone;
	}

	public void setConsigneePhone(String consigneePhone) {
		this.consigneePhone = consigneePhone;
	}
	
	@Length(min=0, max=200, message="收货人地址长度不能超过 200 个字符")
	public String getConsigneeAddress() {
		return consigneeAddress;
	}

	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
	}
	
}