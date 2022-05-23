/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.logistics.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 签收管理Entity
 * @author wang_bo
 * @version 2022-05-24
 */
@Table(name="sign_logistics", alias="a", label="签收管理信息", columns={
		@Column(name="num_code", attrName="numCode", label="编号", isPK=true),
		@Column(name="sign_name", attrName="signName", label="签收主题", queryType=QueryType.LIKE),
		@Column(name="sign_delivery", attrName="signDelivery", label="关联发货单"),
		@Column(name="shipments_manufacturer", attrName="shipmentsManufacturer", label="发货厂商"),
		@Column(name="addresser", attrName="addresser", label="发货人"),
		@Column(name="addresser_phone", attrName="addresserPhone", label="发货人电话"),
		@Column(name="sign_date", attrName="signDate", label="签收日期"),
		@Column(name="task_address", attrName="taskAddress", label="收货地址"),
		@Column(name="expressage_odd", attrName="expressageOdd", label="快递单号"),
		@Column(name="expressage_cost", attrName="expressageCost", label="快递费用"),
		@Column(name="expressage_com", attrName="expressageCom", label="快递公司"),
		@Column(name="consignee", attrName="consignee", label="收货人"),
		@Column(name="sign_user", attrName="signUser", label="签收人"),
		@Column(name="sign_phone", attrName="signPhone", label="签收人电话"),
		@Column(name="sign_address", attrName="signAddress", label="签收人地址"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class SignLogistics extends DataEntity<SignLogistics> {
	
	private static final long serialVersionUID = 1L;
	private String numCode;		// 编号
	private String signName;		// 签收主题
	private String signDelivery;		// 关联发货单
	private String shipmentsManufacturer;		// 发货厂商
	private String addresser;		// 发货人
	private String addresserPhone;		// 发货人电话
	private String signDate;		// 签收日期
	private String taskAddress;		// 收货地址
	private String expressageOdd;		// 快递单号
	private String expressageCost;		// 快递费用
	private String expressageCom;		// 快递公司
	private String consignee;		// 收货人
	private String signUser;		// 签收人
	private String signPhone;		// 签收人电话
	private String signAddress;		// 签收人地址
	
	public SignLogistics() {
		this(null);
	}

	public SignLogistics(String id){
		super(id);
	}
	
	public String getNumCode() {
		return numCode;
	}

	public void setNumCode(String numCode) {
		this.numCode = numCode;
	}
	
	@Length(min=0, max=200, message="签收主题长度不能超过 200 个字符")
	public String getSignName() {
		return signName;
	}

	public void setSignName(String signName) {
		this.signName = signName;
	}
	
	@Length(min=0, max=200, message="关联发货单长度不能超过 200 个字符")
	public String getSignDelivery() {
		return signDelivery;
	}

	public void setSignDelivery(String signDelivery) {
		this.signDelivery = signDelivery;
	}
	
	@Length(min=0, max=200, message="发货厂商长度不能超过 200 个字符")
	public String getShipmentsManufacturer() {
		return shipmentsManufacturer;
	}

	public void setShipmentsManufacturer(String shipmentsManufacturer) {
		this.shipmentsManufacturer = shipmentsManufacturer;
	}
	
	@Length(min=0, max=200, message="发货人长度不能超过 200 个字符")
	public String getAddresser() {
		return addresser;
	}

	public void setAddresser(String addresser) {
		this.addresser = addresser;
	}
	
	@Length(min=0, max=200, message="发货人电话长度不能超过 200 个字符")
	public String getAddresserPhone() {
		return addresserPhone;
	}

	public void setAddresserPhone(String addresserPhone) {
		this.addresserPhone = addresserPhone;
	}
	
	@Length(min=0, max=200, message="签收日期长度不能超过 200 个字符")
	public String getSignDate() {
		return signDate;
	}

	public void setSignDate(String signDate) {
		this.signDate = signDate;
	}
	
	@Length(min=0, max=200, message="收货地址长度不能超过 200 个字符")
	public String getTaskAddress() {
		return taskAddress;
	}

	public void setTaskAddress(String taskAddress) {
		this.taskAddress = taskAddress;
	}
	
	@Length(min=0, max=200, message="快递单号长度不能超过 200 个字符")
	public String getExpressageOdd() {
		return expressageOdd;
	}

	public void setExpressageOdd(String expressageOdd) {
		this.expressageOdd = expressageOdd;
	}
	
	@Length(min=0, max=200, message="快递费用长度不能超过 200 个字符")
	public String getExpressageCost() {
		return expressageCost;
	}

	public void setExpressageCost(String expressageCost) {
		this.expressageCost = expressageCost;
	}
	
	@Length(min=0, max=200, message="快递公司长度不能超过 200 个字符")
	public String getExpressageCom() {
		return expressageCom;
	}

	public void setExpressageCom(String expressageCom) {
		this.expressageCom = expressageCom;
	}
	
	@Length(min=0, max=200, message="收货人长度不能超过 200 个字符")
	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	
	@Length(min=0, max=200, message="签收人长度不能超过 200 个字符")
	public String getSignUser() {
		return signUser;
	}

	public void setSignUser(String signUser) {
		this.signUser = signUser;
	}
	
	@Length(min=0, max=200, message="签收人电话长度不能超过 200 个字符")
	public String getSignPhone() {
		return signPhone;
	}

	public void setSignPhone(String signPhone) {
		this.signPhone = signPhone;
	}
	
	@Length(min=0, max=200, message="签收人地址长度不能超过 200 个字符")
	public String getSignAddress() {
		return signAddress;
	}

	public void setSignAddress(String signAddress) {
		this.signAddress = signAddress;
	}
	
}