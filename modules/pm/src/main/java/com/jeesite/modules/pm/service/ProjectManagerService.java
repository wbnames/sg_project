/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.pm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.pm.entity.ProjectManager;
import com.jeesite.modules.pm.dao.ProjectManagerDao;
import com.jeesite.modules.file.utils.FileUploadUtils;
import com.jeesite.modules.pm.entity.ProjectManagerUser;
import com.jeesite.modules.pm.dao.ProjectManagerUserDao;

/**
 * 项目管理Service
 * @author wang_bo
 * @version 2022-05-23
 */
@Service
@Transactional(readOnly=true)
public class ProjectManagerService extends CrudService<ProjectManagerDao, ProjectManager> {
	
	@Autowired
	private ProjectManagerUserDao projectManagerUserDao;
	
	/**
	 * 获取单条数据
	 * @param projectManager
	 * @return
	 */
	@Override
	public ProjectManager get(ProjectManager projectManager) {
		ProjectManager entity = super.get(projectManager);
		if (entity != null){
			ProjectManagerUser projectManagerUser = new ProjectManagerUser(entity);
			projectManagerUser.setStatus(ProjectManagerUser.STATUS_NORMAL);
			entity.setProjectManagerUserList(projectManagerUserDao.findList(projectManagerUser));
		}
		return entity;
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
	 * 查询子表分页数据
	 * @param projectManagerUser
	 * @param projectManagerUser.page 分页对象
	 * @return
	 */
	public Page<ProjectManagerUser> findSubPage(ProjectManagerUser projectManagerUser) {
		Page<ProjectManagerUser> page = projectManagerUser.getPage();
		page.setList(projectManagerUserDao.findList(projectManagerUser));
		return page;
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
		// 保存 ProjectManager子表
		for (ProjectManagerUser projectManagerUser : projectManager.getProjectManagerUserList()){
			if (!ProjectManagerUser.STATUS_DELETE.equals(projectManagerUser.getStatus())){
				projectManagerUser.setSerialNumber(projectManager);
				if (projectManagerUser.getIsNewRecord()){
					projectManagerUserDao.insert(projectManagerUser);
				}else{
					projectManagerUserDao.update(projectManagerUser);
				}
			}else{
				projectManagerUserDao.delete(projectManagerUser);
			}
		}
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
		ProjectManagerUser projectManagerUser = new ProjectManagerUser();
		projectManagerUser.setSerialNumber(projectManager);
		projectManagerUserDao.deleteByEntity(projectManagerUser);
	}
	
}