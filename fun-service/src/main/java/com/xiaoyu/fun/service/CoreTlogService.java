package com.xiaoyu.fun.service;

import com.xiaoyu.fun.entity.CoreTlog;

public interface CoreTlogService {

	/**
	* 添加
	* @param coreTlog
	* @return
	*/
	public boolean insertCoreTlog(CoreTlog coreTlog);

	/**
	* 修改
	* @param coreTlog
	* @return
	*/
	public boolean updateCoreTlog(CoreTlog coreTlog);

	/**
	* 删除
	* @param coreTlog
	* @return
	*/
	public boolean deleteCoreTlog(CoreTlog coreTlog);

	/**
	* 查询
	* @param coreTlog
	* @return
	*/
	public CoreTlog getCoreTlog(CoreTlog coreTlog);

//<=================定制内容开始==============
//==================定制内容结束==============>

}