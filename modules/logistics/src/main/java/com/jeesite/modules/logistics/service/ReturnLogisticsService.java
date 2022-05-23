/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.logistics.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.logistics.entity.ReturnLogistics;
import com.jeesite.modules.logistics.dao.ReturnLogisticsDao;
import com.jeesite.modules.file.utils.FileUploadUtils;

/**
 * 退还管理Service
 * @author wang_bo
 * @version 2022-05-24
 */
@Service
@Transactional(readOnly=true)
public class ReturnLogisticsService extends CrudService<ReturnLogisticsDao, ReturnLogistics> {
	
	/**
	 * 获取单条数据
	 * @param returnLogistics
	 * @return
	 */
	@Override
	public ReturnLogistics get(ReturnLogistics returnLogistics) {
		return super.get(returnLogistics);
	}
	
	/**
	 * 查询分页数据
	 * @param returnLogistics 查询条件
	 * @param returnLogistics.page 分页对象
	 * @return
	 */
	@Override
	public Page<ReturnLogistics> findPage(ReturnLogistics returnLogistics) {
		return super.findPage(returnLogistics);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param returnLogistics
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(ReturnLogistics returnLogistics) {
		super.save(returnLogistics);
		// 保存上传附件
		FileUploadUtils.saveFileUpload(returnLogistics, returnLogistics.getId(), "returnLogistics_file");
	}
	
	/**
	 * 更新状态
	 * @param returnLogistics
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(ReturnLogistics returnLogistics) {
		super.updateStatus(returnLogistics);
	}
	
	/**
	 * 删除数据
	 * @param returnLogistics
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(ReturnLogistics returnLogistics) {
		super.delete(returnLogistics);
	}
	
}