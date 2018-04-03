package com.xiaoyu.fun.service;

import com.xiaoyu.fun.entity.CoreDict;

public interface CoreDictService {

	/**
	* 添加
	* @param coreDict
	* @return
	*/
	public boolean insertCoreDict(CoreDict coreDict);

	/**
	* 修改
	* @param coreDict
	* @return
	*/
	public boolean updateCoreDict(CoreDict coreDict);

	/**
	* 删除
	* @param coreDict
	* @return
	*/
	public boolean deleteCoreDict(CoreDict coreDict);

	/**
	* 查询
	* @param coreDict
	* @return
	*/
	public CoreDict getCoreDict(CoreDict coreDict);

//<=================定制内容开始==============
//==================定制内容结束==============>

}