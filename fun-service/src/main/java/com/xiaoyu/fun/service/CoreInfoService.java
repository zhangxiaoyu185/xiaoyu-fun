package com.xiaoyu.fun.service;

import com.xiaoyu.fun.entity.CoreInfo;

public interface CoreInfoService {

	/**
	* 添加
	* @param coreInfo
	* @return
	*/
	public boolean insertCoreInfo(CoreInfo coreInfo);

	/**
	* 修改
	* @param coreInfo
	* @return
	*/
	public boolean updateCoreInfo(CoreInfo coreInfo);

	/**
	* 删除
	* @param coreInfo
	* @return
	*/
	public boolean deleteCoreInfo(CoreInfo coreInfo);

	/**
	* 查询
	* @param coreInfo
	* @return
	*/
	public CoreInfo getCoreInfo(CoreInfo coreInfo);

//<=================定制内容开始==============
//==================定制内容结束==============>

}