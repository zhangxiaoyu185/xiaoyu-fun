package com.xiaoyu.fun.service;

import com.xiaoyu.fun.entity.CoreLink;

public interface CoreLinkService {

	/**
	* 添加
	* @param coreLink
	* @return
	*/
	public boolean insertCoreLink(CoreLink coreLink);

	/**
	* 修改
	* @param coreLink
	* @return
	*/
	public boolean updateCoreLink(CoreLink coreLink);

	/**
	* 删除
	* @param coreLink
	* @return
	*/
	public boolean deleteCoreLink(CoreLink coreLink);

	/**
	* 查询
	* @param coreLink
	* @return
	*/
	public CoreLink getCoreLink(CoreLink coreLink);

//<=================定制内容开始==============
//==================定制内容结束==============>

}