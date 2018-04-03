package com.xiaoyu.fun.service;

import com.xiaoyu.fun.entity.CoreRole;

public interface CoreRoleService {

	/**
	* 添加
	* @param coreRole
	* @return
	*/
	public boolean insertCoreRole(CoreRole coreRole);

	/**
	* 修改
	* @param coreRole
	* @return
	*/
	public boolean updateCoreRole(CoreRole coreRole);

	/**
	* 删除
	* @param coreRole
	* @return
	*/
	public boolean deleteCoreRole(CoreRole coreRole);

	/**
	* 查询
	* @param coreRole
	* @return
	*/
	public CoreRole getCoreRole(CoreRole coreRole);

//<=================定制内容开始==============
//==================定制内容结束==============>

}