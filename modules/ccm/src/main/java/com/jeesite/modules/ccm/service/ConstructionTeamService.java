/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.ccm.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.ccm.entity.ConstructionTeam;
import com.jeesite.modules.ccm.dao.ConstructionTeamDao;

/**
 * 施工班组Service
 * @author lyu
 * @version 2022-05-24
 */
@Service
@Transactional(readOnly=true)
public class ConstructionTeamService extends CrudService<ConstructionTeamDao, ConstructionTeam> {
	
	/**
	 * 获取单条数据
	 * @param constructionTeam
	 * @return
	 */
	@Override
	public ConstructionTeam get(ConstructionTeam constructionTeam) {
		return super.get(constructionTeam);
	}
	
	/**
	 * 查询分页数据
	 * @param constructionTeam 查询条件
	 * @param constructionTeam.page 分页对象
	 * @return
	 */
	@Override
	public Page<ConstructionTeam> findPage(ConstructionTeam constructionTeam) {
		return super.findPage(constructionTeam);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param constructionTeam
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(ConstructionTeam constructionTeam) {
		super.save(constructionTeam);
	}
	
	/**
	 * 更新状态
	 * @param constructionTeam
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(ConstructionTeam constructionTeam) {
		super.updateStatus(constructionTeam);
	}
	
	/**
	 * 删除数据
	 * @param constructionTeam
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(ConstructionTeam constructionTeam) {
		super.delete(constructionTeam);
	}
	
}