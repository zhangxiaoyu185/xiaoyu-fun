package com.xiaoyu.fun.service;

import com.xiaoyu.fun.entity.BusiVersion;

public interface BusiVersionService {

	/**
	* 添加
	* @param busiVersion
	* @return
	*/
	public boolean insertBusiVersion(BusiVersion busiVersion);

	/**
	* 修改
	* @param busiVersion
	* @return
	*/
	public boolean updateBusiVersion(BusiVersion busiVersion);

	/**
	* 删除
	* @param busiVersion
	* @return
	*/
	public boolean deleteBusiVersion(BusiVersion busiVersion);

	/**
	* 查询
	* @param busiVersion
	* @return
	*/
	public BusiVersion getBusiVersion(BusiVersion busiVersion);

//<=================定制内容开始==============
	/**
	* 查询
	* @param busiVersion
	* @return
	*/
	public BusiVersion getBusiVersionByType(BusiVersion busiVersion);
//==================定制内容结束==============>

}