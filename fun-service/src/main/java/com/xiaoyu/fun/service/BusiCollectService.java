package com.xiaoyu.fun.service;

import com.xiaoyu.fun.entity.BusiCollect;

public interface BusiCollectService {

	/**
	* 添加
	* @param busiCollect
	* @return
	*/
	public boolean insertBusiCollect(BusiCollect busiCollect);

	/**
	* 修改
	* @param busiCollect
	* @return
	*/
	public boolean updateBusiCollect(BusiCollect busiCollect);

	/**
	* 删除
	* @param busiCollect
	* @return
	*/
	public boolean deleteBusiCollect(BusiCollect busiCollect);

	/**
	* 查询
	* @param busiCollect
	* @return
	*/
	public BusiCollect getBusiCollect(BusiCollect busiCollect);

//<=================定制内容开始==============
	/**
	* 根据用户和趣事查询
	* @param busiCollect
	* @return
	*/
	public BusiCollect getBusiCollectByUserAndFUN(BusiCollect busiCollect);
	
	/**
	* 根据趣事和用户删除收藏
	* @param bscltFun
	* @param bscltUser
	* @return
	*/
	public boolean deleteBusiCollectByFunAndUser(String bscltFun, String bscltUser);
//==================定制内容结束==============>

}