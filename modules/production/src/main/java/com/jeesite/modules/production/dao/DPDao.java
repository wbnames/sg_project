/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.production.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.production.entity.DP;

/**
 * 生产管理DAO接口
 * @author wang_bo
 * @version 2022-05-30
 */
@MyBatisDao
public interface DPDao extends CrudDao<DP> {
	
}