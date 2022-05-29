/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.ccm.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.ccm.entity.ConstructionUnit;

/**
 * 施工单位DAO接口
 * @author lyu
 * @version 2022-05-24
 */
@MyBatisDao
public interface ConstructionUnitDao extends CrudDao<ConstructionUnit> {
	
}