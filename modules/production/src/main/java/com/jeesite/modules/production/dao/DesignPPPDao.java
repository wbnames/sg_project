/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.production.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.production.entity.DesignPPP;

/**
 * 生产管理DAO接口
 * @author wang_bo
 * @version 2022-06-06
 */
@MyBatisDao
public interface DesignPPPDao extends CrudDao<DesignPPP> {
	
}