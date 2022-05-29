/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.cm.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 收款计划Entity
 * @author wang_bo
 * @version 2022-05-30
 */
@Table(name="payment_plan", alias="a", label="收款计划信息", columns={
		@Column(name="num_code", attrName="numCode", label="编号", isPK=true),
		@Column(name="payment_name", attrName="paymentName", label="收款名称", queryType=QueryType.LIKE),
		@Column(name="payment_project", attrName="paymentProject", label="所属项目"),
		@Column(name="payment_type", attrName="paymentType", label="收款类型"),
		@Column(name="payment_sum", attrName="paymentSum", label="收款金额"),
		@Column(name="payment_sum_ca", attrName="paymentSumCa", label="收款金额大写"),
		@Column(name="payment_contract", attrName="paymentContract", label="所属合同"),
		@Column(name="first_unit", attrName="firstUnit", label="甲方单位"),
		@Column(name="bank_acc", attrName="bankAcc", label="银行账户"),
		@Column(name="sign_date", attrName="signDate", label="签订日期"),
		@Column(name="informant_user", attrName="informantUser", label="填报人"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class PaymentPlan extends DataEntity<PaymentPlan> {
	
	private static final long serialVersionUID = 1L;
	private String numCode;		// 编号
	private String paymentName;		// 收款名称
	private String paymentProject;		// 所属项目
	private String paymentType;		// 收款类型
	private String paymentSum;		// 收款金额
	private String paymentSumCa;		// 收款金额大写
	private String paymentContract;		// 所属合同
	private String firstUnit;		// 甲方单位
	private String bankAcc;		// 银行账户
	private String signDate;		// 签订日期
	private String informantUser;		// 填报人
	
	public PaymentPlan() {
		this(null);
	}

	public PaymentPlan(String id){
		super(id);
	}
	
	public String getNumCode() {
		return numCode;
	}

	public void setNumCode(String numCode) {
		this.numCode = numCode;
	}
	
	@Length(min=0, max=200, message="收款名称长度不能超过 200 个字符")
	public String getPaymentName() {
		return paymentName;
	}

	public void setPaymentName(String paymentName) {
		this.paymentName = paymentName;
	}
	
	@Length(min=0, max=200, message="所属项目长度不能超过 200 个字符")
	public String getPaymentProject() {
		return paymentProject;
	}

	public void setPaymentProject(String paymentProject) {
		this.paymentProject = paymentProject;
	}
	
	@Length(min=0, max=200, message="收款类型长度不能超过 200 个字符")
	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	
	@Length(min=0, max=200, message="收款金额长度不能超过 200 个字符")
	public String getPaymentSum() {
		return paymentSum;
	}

	public void setPaymentSum(String paymentSum) {
		this.paymentSum = paymentSum;
	}
	
	@Length(min=0, max=200, message="收款金额大写长度不能超过 200 个字符")
	public String getPaymentSumCa() {
		return paymentSumCa;
	}

	public void setPaymentSumCa(String paymentSumCa) {
		this.paymentSumCa = paymentSumCa;
	}
	
	@Length(min=0, max=200, message="所属合同长度不能超过 200 个字符")
	public String getPaymentContract() {
		return paymentContract;
	}

	public void setPaymentContract(String paymentContract) {
		this.paymentContract = paymentContract;
	}
	
	@Length(min=0, max=200, message="甲方单位长度不能超过 200 个字符")
	public String getFirstUnit() {
		return firstUnit;
	}

	public void setFirstUnit(String firstUnit) {
		this.firstUnit = firstUnit;
	}
	
	@Length(min=0, max=50, message="银行账户长度不能超过 50 个字符")
	public String getBankAcc() {
		return bankAcc;
	}

	public void setBankAcc(String bankAcc) {
		this.bankAcc = bankAcc;
	}
	
	@Length(min=0, max=50, message="签订日期长度不能超过 50 个字符")
	public String getSignDate() {
		return signDate;
	}

	public void setSignDate(String signDate) {
		this.signDate = signDate;
	}
	
	@Length(min=0, max=50, message="填报人长度不能超过 50 个字符")
	public String getInformantUser() {
		return informantUser;
	}

	public void setInformantUser(String informantUser) {
		this.informantUser = informantUser;
	}
	
}