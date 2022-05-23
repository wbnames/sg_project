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
 * 退还管理Entity
 * @author wang_bo
 * @version 2022-05-24
 */
@Table(name="return_logistics", alias="a", label="退还管理信息", columns={
		@Column(name="num_code", attrName="numCode", label="编码", isPK=true),
		@Column(name="return_name", attrName="returnName", label="退还主题", queryType=QueryType.LIKE),
		@Column(name="return_project", attrName="returnProject", label="所属项目"),
		@Column(name="return_manufacturer", attrName="returnManufacturer", label="退还厂商"),
		@Column(name="consignee", attrName="consignee", label="收货人"),
		@Column(name="consignee_phone", attrName="consigneePhone", label="收货人电话"),
		@Column(name="return_date", attrName="returnDate", label="退还日期"),
		@Column(name="take_address", attrName="takeAddress", label="收货地址"),
		@Column(name="expressage_odd", attrName="expressageOdd", label="快递单号"),
		@Column(name="expressage_cost", attrName="expressageCost", label="快递费用"),
		@Column(name="expressage_com", attrName="expressageCom", label="快递公司"),
		@Column(name="return_status", attrName="returnStatus", label="退还状态"),
		@Column(name="addresser", attrName="addresser", label="发件人"),
		@Column(name="addresser_phone", attrName="addresserPhone", label="发件人电话"),
		@Column(name="addresser_address", attrName="addresserAddress", label="寄出地址"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class ReturnLogistics extends DataEntity<ReturnLogistics> {
	
	private static final long serialVersionUID = 1L;
	private String numCode;		// 编码
	private String returnName;		// 退还主题
	private String returnProject;		// 所属项目
	private String returnManufacturer;		// 退还厂商
	private String consignee;		// 收货人
	private String consigneePhone;		// 收货人电话
	private String returnDate;		// 退还日期
	private String takeAddress;		// 收货地址
	private String expressageOdd;		// 快递单号
	private String expressageCost;		// 快递费用
	private String expressageCom;		// 快递公司
	private String returnStatus;		// 退还状态
	private String addresser;		// 发件人
	private String addresserPhone;		// 发件人电话
	private String addresserAddress;		// 寄出地址
	
	public ReturnLogistics() {
		this(null);
	}

	public ReturnLogistics(String id){
		super(id);
	}
	
	public String getNumCode() {
		return numCode;
	}

	public void setNumCode(String numCode) {
		this.numCode = numCode;
	}
	
	@Length(min=0, max=200, message="退还主题长度不能超过 200 个字符")
	public String getReturnName() {
		return returnName;
	}

	public void setReturnName(String returnName) {
		this.returnName = returnName;
	}
	
	@Length(min=0, max=200, message="所属项目长度不能超过 200 个字符")
	public String getReturnProject() {
		return returnProject;
	}

	public void setReturnProject(String returnProject) {
		this.returnProject = returnProject;
	}
	
	@Length(min=0, max=200, message="退还厂商长度不能超过 200 个字符")
	public String getReturnManufacturer() {
		return returnManufacturer;
	}

	public void setReturnManufacturer(String returnManufacturer) {
		this.returnManufacturer = returnManufacturer;
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
	
	@Length(min=0, max=200, message="退还日期长度不能超过 200 个字符")
	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	
	@Length(min=0, max=200, message="收货地址长度不能超过 200 个字符")
	public String getTakeAddress() {
		return takeAddress;
	}

	public void setTakeAddress(String takeAddress) {
		this.takeAddress = takeAddress;
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
	
	@Length(min=0, max=64, message="退还状态长度不能超过 64 个字符")
	public String getReturnStatus() {
		return returnStatus;
	}

	public void setReturnStatus(String returnStatus) {
		this.returnStatus = returnStatus;
	}
	
	@Length(min=0, max=200, message="发件人长度不能超过 200 个字符")
	public String getAddresser() {
		return addresser;
	}

	public void setAddresser(String addresser) {
		this.addresser = addresser;
	}
	
	@Length(min=0, max=200, message="发件人电话长度不能超过 200 个字符")
	public String getAddresserPhone() {
		return addresserPhone;
	}

	public void setAddresserPhone(String addresserPhone) {
		this.addresserPhone = addresserPhone;
	}
	
	@Length(min=0, max=200, message="寄出地址长度不能超过 200 个字符")
	public String getAddresserAddress() {
		return addresserAddress;
	}

	public void setAddresserAddress(String addresserAddress) {
		this.addresserAddress = addresserAddress;
	}
	
}