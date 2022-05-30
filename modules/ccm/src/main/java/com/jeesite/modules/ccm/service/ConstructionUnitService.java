/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.ccm.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.ccm.entity.ConstructionUnit;
import com.jeesite.modules.ccm.dao.ConstructionUnitDao;

/**
 * 施工单位Service
 * @author lyu
 * @version 2022-05-30
 */
@Service
@Transactional(readOnly=true)
public class ConstructionUnitService extends CrudService<ConstructionUnitDao, ConstructionUnit> {
	
	/**
	 * 获取单条数据
	 * @param constructionUnit
	 * @return
	 */
	@Override
	public ConstructionUnit get(ConstructionUnit constructionUnit) {
		return super.get(constructionUnit);
	}
	
	/**
	 * 查询分页数据
	 * @param constructionUnit 查询条件
	 * @param constructionUnit.page 分页对象
	 * @return
	 */
	@Override
	public Page<ConstructionUnit> findPage(ConstructionUnit constructionUnit) {
		return super.findPage(constructionUnit);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param constructionUnit
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(ConstructionUnit constructionUnit) {
		super.save(constructionUnit);
	}
	
	/**
	 * 更新状态
	 * @param constructionUnit
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(ConstructionUnit constructionUnit) {
		super.updateStatus(constructionUnit);
	}
	
	/**
	 * 删除数据
	 * @param constructionUnit
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(ConstructionUnit constructionUnit) {
		super.delete(constructionUnit);
	}
	
}