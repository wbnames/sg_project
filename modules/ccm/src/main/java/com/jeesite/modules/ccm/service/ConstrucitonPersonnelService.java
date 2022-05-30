/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.ccm.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.ccm.entity.ConstrucitonPersonnel;
import com.jeesite.modules.ccm.dao.ConstrucitonPersonnelDao;
import com.jeesite.modules.file.utils.FileUploadUtils;

/**
 * 施工人员Service
 * @author lyu
 * @version 2022-05-30
 */
@Service
@Transactional(readOnly=true)
public class ConstrucitonPersonnelService extends CrudService<ConstrucitonPersonnelDao, ConstrucitonPersonnel> {
	
	/**
	 * 获取单条数据
	 * @param construcitonPersonnel
	 * @return
	 */
	@Override
	public ConstrucitonPersonnel get(ConstrucitonPersonnel construcitonPersonnel) {
		return super.get(construcitonPersonnel);
	}
	
	/**
	 * 查询分页数据
	 * @param construcitonPersonnel 查询条件
	 * @param construcitonPersonnel.page 分页对象
	 * @return
	 */
	@Override
	public Page<ConstrucitonPersonnel> findPage(ConstrucitonPersonnel construcitonPersonnel) {
		return super.findPage(construcitonPersonnel);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param construcitonPersonnel
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(ConstrucitonPersonnel construcitonPersonnel) {
		super.save(construcitonPersonnel);
		// 保存上传图片
		FileUploadUtils.saveFileUpload(construcitonPersonnel, construcitonPersonnel.getId(), "construcitonPersonnel_image");
	}
	
	/**
	 * 更新状态
	 * @param construcitonPersonnel
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(ConstrucitonPersonnel construcitonPersonnel) {
		super.updateStatus(construcitonPersonnel);
	}
	
	/**
	 * 删除数据
	 * @param construcitonPersonnel
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(ConstrucitonPersonnel construcitonPersonnel) {
		super.delete(construcitonPersonnel);
	}
	
}