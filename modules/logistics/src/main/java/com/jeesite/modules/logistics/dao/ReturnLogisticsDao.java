/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.logistics.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.logistics.entity.ReturnLogistics;

/**
 * 退还管理DAO接口
 * @author wang_bo
 * @version 2022-05-24
 */
@MyBatisDao
public interface ReturnLogisticsDao extends CrudDao<ReturnLogistics> {
	
}