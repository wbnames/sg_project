/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.pm.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.pm.entity.ProjectManagerData;
import com.jeesite.modules.pm.dao.ProjectManagerDataDao;

/**
 * 项目管理-建设单位Service
 * @author wang_bo
 * @version 2022-05-22
 */
@Service
@Transactional(readOnly=true)
public class ProjectManagerDataService extends CrudService<ProjectManagerDataDao, ProjectManagerData> {
	
	/**
	 * 获取单条数据
	 * @param projectManagerData
	 * @return
	 */
	@Override
	public ProjectManagerData get(ProjectManagerData projectManagerData) {
		return super.get(projectManagerData);
	}
	
	/**
	 * 查询分页数据
	 * @param projectManagerData 查询条件
	 * @param projectManagerData.page 分页对象
	 * @return
	 */
	@Override
	public Page<ProjectManagerData> findPage(ProjectManagerData projectManagerData) {
		return super.findPage(projectManagerData);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param projectManagerData
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(ProjectManagerData projectManagerData) {
		super.save(projectManagerData);
	}
	
	/**
	 * 更新状态
	 * @param projectManagerData
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(ProjectManagerData projectManagerData) {
		super.updateStatus(projectManagerData);
	}
	
	/**
	 * 删除数据
	 * @param projectManagerData
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(ProjectManagerData projectManagerData) {
		super.delete(projectManagerData);
	}
	
}