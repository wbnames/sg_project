/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.pm.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.pm.entity.ProjectManagerData;

/**
 * 项目管理-建设单位DAO接口
 * @author wang_bo
 * @version 2022-05-22
 */
@MyBatisDao
public interface ProjectManagerDataDao extends CrudDao<ProjectManagerData> {
	
}