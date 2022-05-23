/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.logistics.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.logistics.entity.SignLogistics;
import com.jeesite.modules.logistics.dao.SignLogisticsDao;
import com.jeesite.modules.file.utils.FileUploadUtils;

/**
 * 签收管理Service
 * @author wang_bo
 * @version 2022-05-24
 */
@Service
@Transactional(readOnly=true)
public class SignLogisticsService extends CrudService<SignLogisticsDao, SignLogistics> {
	
	/**
	 * 获取单条数据
	 * @param signLogistics
	 * @return
	 */
	@Override
	public SignLogistics get(SignLogistics signLogistics) {
		return super.get(signLogistics);
	}
	
	/**
	 * 查询分页数据
	 * @param signLogistics 查询条件
	 * @param signLogistics.page 分页对象
	 * @return
	 */
	@Override
	public Page<SignLogistics> findPage(SignLogistics signLogistics) {
		return super.findPage(signLogistics);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param signLogistics
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(SignLogistics signLogistics) {
		super.save(signLogistics);
		// 保存上传附件
		FileUploadUtils.saveFileUpload(signLogistics, signLogistics.getId(), "signLogistics_file");
	}
	
	/**
	 * 更新状态
	 * @param signLogistics
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(SignLogistics signLogistics) {
		super.updateStatus(signLogistics);
	}
	
	/**
	 * 删除数据
	 * @param signLogistics
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(SignLogistics signLogistics) {
		super.delete(signLogistics);
	}
	
}