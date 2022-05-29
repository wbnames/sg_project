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
 * @version 2022-05-26
 */
@Table(name="product_classify", alias="a", label="产品分类信息", columns={
		@Column(name="num_code", attrName="numCode", label="产品编号", isPK=true),
		@Column(name="pm_name", attrName="pmName", label="产品名称", queryType=QueryType.LIKE),
		@Column(name="pm_location", attrName="pmLocation", label="位置"),
		@Column(name="pm_color", attrName="pmColor", label="颜色"),
		@Column(name="pm_thickness", attrName="pmThickness", label="厚度"),
		@Column(name="pm_spec", attrName="pmSpec", label="规格"),
		@Column(name="pm_area", attrName="pmArea", label="单价面积", comment="单价面积(平方米)"),
		@Column(name="pm_count", attrName="pmCount", label="数量", comment="数量(件数)"),
		@Column(name="pm_total_area", attrName="pmTotalArea", label="合计面积", comment="合计面积(平方米)"),
		@Column(name="status", attrName="status", label="状态", comment="状态（0正常 1删除 2停用）", isUpdate=false),
		@Column(name="create_by", attrName="createBy", label="创建者", isUpdate=false, isQuery=false),
		@Column(name="create_date", attrName="createDate", label="创建时间", isUpdate=false, isQuery=false),
		@Column(name="update_by", attrName="updateBy", label="更新者", isQuery=false),
		@Column(name="update_date", attrName="updateDate", label="更新时间", isQuery=false),
		@Column(name="remarks1", attrName="remarks1", label="备注1", queryType=QueryType.LIKE),
		@Column(name="remarks2", attrName="remarks2", label="备注2", queryType=QueryType.LIKE),
		@Column(name="remarks3", attrName="remarks3", label="备注3", queryType=QueryType.LIKE),
	}, orderBy="a.update_date DESC"
)
public class ProductClassify extends DataEntity<ProductClassify> {
	
	private static final long serialVersionUID = 1L;
	private String numCode;		// 产品编号
	private String pmName;		// 产品名称
	private String pmLocation;		// 位置
	private Long pmColor;		// 颜色
	private String pmThickness;		// 厚度
	private String pmSpec;		// 规格
	private String pmArea;		// 单价面积(平方米)
	private String pmCount;		// 数量(件数)
	private String pmTotalArea;		// 合计面积(平方米)
	private String remarks1;		// 备注1
	private String remarks2;		// 备注2
	private String remarks3;		// 备注3
	
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
	
	@Length(min=0, max=64, message="产品名称长度不能超过 64 个字符")
	public String getPmName() {
		return pmName;
	}

	public void setPmName(String pmName) {
		this.pmName = pmName;
	}
	
	@Length(min=0, max=64, message="位置长度不能超过 64 个字符")
	public String getPmLocation() {
		return pmLocation;
	}

	public void setPmLocation(String pmLocation) {
		this.pmLocation = pmLocation;
	}
	
	public Long getPmColor() {
		return pmColor;
	}

	public void setPmColor(Long pmColor) {
		this.pmColor = pmColor;
	}
	
	@Length(min=0, max=128, message="厚度长度不能超过 128 个字符")
	public String getPmThickness() {
		return pmThickness;
	}

	public void setPmThickness(String pmThickness) {
		this.pmThickness = pmThickness;
	}
	
	@Length(min=0, max=255, message="规格长度不能超过 255 个字符")
	public String getPmSpec() {
		return pmSpec;
	}

	public void setPmSpec(String pmSpec) {
		this.pmSpec = pmSpec;
	}
	
	@Length(min=0, max=255, message="单价面积长度不能超过 255 个字符")
	public String getPmArea() {
		return pmArea;
	}

	public void setPmArea(String pmArea) {
		this.pmArea = pmArea;
	}
	
	@Length(min=0, max=255, message="数量长度不能超过 255 个字符")
	public String getPmCount() {
		return pmCount;
	}

	public void setPmCount(String pmCount) {
		this.pmCount = pmCount;
	}
	
	@Length(min=0, max=255, message="合计面积长度不能超过 255 个字符")
	public String getPmTotalArea() {
		return pmTotalArea;
	}

	public void setPmTotalArea(String pmTotalArea) {
		this.pmTotalArea = pmTotalArea;
	}
	
	@Length(min=0, max=500, message="备注1长度不能超过 500 个字符")
	public String getRemarks1() {
		return remarks1;
	}

	public void setRemarks1(String remarks1) {
		this.remarks1 = remarks1;
	}
	
	@Length(min=0, max=255, message="备注2长度不能超过 255 个字符")
	public String getRemarks2() {
		return remarks2;
	}

	public void setRemarks2(String remarks2) {
		this.remarks2 = remarks2;
	}
	
	@Length(min=0, max=255, message="备注3长度不能超过 255 个字符")
	public String getRemarks3() {
		return remarks3;
	}

	public void setRemarks3(String remarks3) {
		this.remarks3 = remarks3;
	}
	
}