/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.pm.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.pm.entity.ProjectManager;
import com.jeesite.modules.pm.dao.ProjectManagerDao;
import com.jeesite.modules.file.utils.FileUploadUtils;

/**
 * 项目管理Service
 * @author wang_bo
 * @version 2022-05-21
 */
@Service
@Transactional(readOnly=true)
public class ProjectManagerService extends CrudService<ProjectManagerDao, ProjectManager> {
	
	/**
	 * 获取单条数据
	 * @param projectManager
	 * @return
	 */
	@Override
	public ProjectManager get(ProjectManager projectManager) {
		return super.get(projectManager);
	}
	
	/**
	 * 查询分页数据
	 * @param projectManager 查询条件
	 * @param projectManager.page 分页对象
	 * @return
	 */
	@Override
	public Page<ProjectManager> findPage(ProjectManager projectManager) {
		return super.findPage(projectManager);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param projectManager
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(ProjectManager projectManager) {
		super.save(projectManager);
		// 保存上传图片
		FileUploadUtils.saveFileUpload(projectManager, projectManager.getId(), "projectManager_image");
		// 保存上传附件
		FileUploadUtils.saveFileUpload(projectManager, projectManager.getId(), "projectManager_file");
	}
	
	/**
	 * 更新状态
	 * @param projectManager
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(ProjectManager projectManager) {
		super.updateStatus(projectManager);
	}
	
	/**
	 * 删除数据
	 * @param projectManager
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(ProjectManager projectManager) {
		super.delete(projectManager);
	}
	
}