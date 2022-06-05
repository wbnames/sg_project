/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.cm.entity;

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
 * 合同管理Entity
 * @author wang_bo
 * @version 2022-06-06
 */
@Table(name="contract_manager", alias="a", label="合同管理信息", columns={
		@Column(name="num_code", attrName="numCode", label="编号", isPK=true),
		@Column(name="contract_name", attrName="contractName", label="合同名称", queryType=QueryType.LIKE),
		@Column(name="contract_code", attrName="contractCode", label="合同编号"),
		@Column(name="contract_project", attrName="contractProject", label="所属项目"),
		@Column(name="date_signing", attrName="dateSigning", label="签订日期"),
		@Column(name="contract_type", attrName="contractType", label="合同类型"),
		@Column(name="contract_sum", attrName="contractSum", label="合同金额"),
		@Column(name="first_unit", attrName="firstUnit", label="甲方单位"),
		@Column(name="sign_user", attrName="signUser", label="签订人"),
		@Column(includeEntity=DataEntity.class),
		@Column(name="pay_method", attrName="payMethod", label="付款方式"),
		@Column(name="close_method", attrName="closeMethod", label="结算方式"),
		@Column(name="advances_received", attrName="advancesReceived", label="预收款"),
		@Column(name="earnest_money", attrName="earnestMoney", label="保证金"),
		@Column(name="collection_terms", attrName="collectionTerms", label="收款条件"),
		@Column(name="main_clause", attrName="mainClause", label="主要条款"),
	}, orderBy="a.update_date DESC"
)
public class ContractManager extends DataEntity<ContractManager> {
	
	private static final long serialVersionUID = 1L;
	private String numCode;		// 编号
	private String contractName;		// 合同名称
	private String contractCode;		// 合同编号
	private String contractProject;		// 所属项目
	private Date dateSigning;		// 签订日期
	private String contractType;		// 合同类型
	private String contractSum;		// 合同金额
	private String firstUnit;		// 甲方单位
	private String signUser;		// 签订人
	private String payMethod;		// 付款方式
	private String closeMethod;		// 结算方式
	private String advancesReceived;		// 预收款
	private String earnestMoney;		// 保证金
	private String collectionTerms;		// 收款条件
	private String mainClause;		// 主要条款
	
	public ContractManager() {
		this(null);
	}

	public ContractManager(String id){
		super(id);
	}
	
	public String getNumCode() {
		return numCode;
	}

	public void setNumCode(String numCode) {
		this.numCode = numCode;
	}
	
	@Length(min=0, max=200, message="合同名称长度不能超过 200 个字符")
	public String getContractName() {
		return contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}
	
	@Length(min=0, max=200, message="合同编号长度不能超过 200 个字符")
	public String getContractCode() {
		return contractCode;
	}

	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}
	
	@Length(min=0, max=200, message="所属项目长度不能超过 200 个字符")
	public String getContractProject() {
		return contractProject;
	}

	public void setContractProject(String contractProject) {
		this.contractProject = contractProject;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getDateSigning() {
		return dateSigning;
	}

	public void setDateSigning(Date dateSigning) {
		this.dateSigning = dateSigning;
	}
	
	@Length(min=0, max=200, message="合同类型长度不能超过 200 个字符")
	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}
	
	@Length(min=0, max=200, message="合同金额长度不能超过 200 个字符")
	public String getContractSum() {
		return contractSum;
	}

	public void setContractSum(String contractSum) {
		this.contractSum = contractSum;
	}
	
	@Length(min=0, max=200, message="甲方单位长度不能超过 200 个字符")
	public String getFirstUnit() {
		return firstUnit;
	}

	public void setFirstUnit(String firstUnit) {
		this.firstUnit = firstUnit;
	}
	
	@Length(min=0, max=200, message="签订人长度不能超过 200 个字符")
	public String getSignUser() {
		return signUser;
	}

	public void setSignUser(String signUser) {
		this.signUser = signUser;
	}
	
	@Length(min=0, max=200, message="付款方式长度不能超过 200 个字符")
	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
	
	@Length(min=0, max=200, message="结算方式长度不能超过 200 个字符")
	public String getCloseMethod() {
		return closeMethod;
	}

	public void setCloseMethod(String closeMethod) {
		this.closeMethod = closeMethod;
	}
	
	@Length(min=0, max=200, message="预收款长度不能超过 200 个字符")
	public String getAdvancesReceived() {
		return advancesReceived;
	}

	public void setAdvancesReceived(String advancesReceived) {
		this.advancesReceived = advancesReceived;
	}
	
	@Length(min=0, max=200, message="保证金长度不能超过 200 个字符")
	public String getEarnestMoney() {
		return earnestMoney;
	}

	public void setEarnestMoney(String earnestMoney) {
		this.earnestMoney = earnestMoney;
	}
	
	@Length(min=0, max=200, message="收款条件长度不能超过 200 个字符")
	public String getCollectionTerms() {
		return collectionTerms;
	}

	public void setCollectionTerms(String collectionTerms) {
		this.collectionTerms = collectionTerms;
	}
	
	@Length(min=0, max=200, message="主要条款长度不能超过 200 个字符")
	public String getMainClause() {
		return mainClause;
	}

	public void setMainClause(String mainClause) {
		this.mainClause = mainClause;
	}
	
}