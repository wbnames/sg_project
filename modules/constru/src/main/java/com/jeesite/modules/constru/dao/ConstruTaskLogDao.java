/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.constru.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.constru.entity.ConstruTaskLog;

/**
 * 施工日志DAO接口
 * @author lyu
 * @version 2022-05-30
 */
@MyBatisDao
public interface ConstruTaskLogDao extends CrudDao<ConstruTaskLog> {
	
}