/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.constru.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.constru.entity.ConstruTaskLog;
import com.jeesite.modules.constru.dao.ConstruTaskLogDao;
import com.jeesite.modules.file.utils.FileUploadUtils;

/**
 * 施工日志Service
 * @author lyu
 * @version 2022-05-24
 */
@Service
@Transactional(readOnly=true)
public class ConstruTaskLogService extends CrudService<ConstruTaskLogDao, ConstruTaskLog> {
	
	/**
	 * 获取单条数据
	 * @param construTaskLog
	 * @return
	 */
	@Override
	public ConstruTaskLog get(ConstruTaskLog construTaskLog) {
		return super.get(construTaskLog);
	}
	
	/**
	 * 查询分页数据
	 * @param construTaskLog 查询条件
	 * @param construTaskLog.page 分页对象
	 * @return
	 */
	@Override
	public Page<ConstruTaskLog> findPage(ConstruTaskLog construTaskLog) {
		return super.findPage(construTaskLog);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param construTaskLog
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(ConstruTaskLog construTaskLog) {
		super.save(construTaskLog);
		// 保存上传图片
		FileUploadUtils.saveFileUpload(construTaskLog, construTaskLog.getId(), "construTaskLog_image");
		// 保存上传附件
		FileUploadUtils.saveFileUpload(construTaskLog, construTaskLog.getId(), "construTaskLog_file");
	}
	
	/**
	 * 更新状态
	 * @param construTaskLog
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(ConstruTaskLog construTaskLog) {
		super.updateStatus(construTaskLog);
	}
	
	/**
	 * 删除数据
	 * @param construTaskLog
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(ConstruTaskLog construTaskLog) {
		super.delete(construTaskLog);
	}
	
}