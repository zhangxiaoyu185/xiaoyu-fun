package com.xiaoyu.fun.service;

import com.xiaoyu.fun.entity.CoreLlog;

public interface CoreLlogService {

	/**
	* 添加
	* @param coreLlog
	* @return
	*/
	public boolean insertCoreLlog(CoreLlog coreLlog);

	/**
	* 修改
	* @param coreLlog
	* @return
	*/
	public boolean updateCoreLlog(CoreLlog coreLlog);

	/**
	* 删除
	* @param coreLlog
	* @return
	*/
	public boolean deleteCoreLlog(CoreLlog coreLlog);

	/**
	* 查询
	* @param coreLlog
	* @return
	*/
	public CoreLlog getCoreLlog(CoreLlog coreLlog);

//<=================定制内容开始==============
//==================定制内容结束==============>

}