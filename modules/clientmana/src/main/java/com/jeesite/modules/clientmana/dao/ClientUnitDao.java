/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.clientmana.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.clientmana.entity.ClientUnit;

/**
 * 客户单位DAO接口
 * @author lyu
 * @version 2022-05-24
 */
@MyBatisDao
public interface ClientUnitDao extends CrudDao<ClientUnit> {
	
}