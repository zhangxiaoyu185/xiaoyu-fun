package com.xiaoyu.fun.service;

import com.xiaoyu.fun.entity.BusiUser;

public interface BusiUserService {

	/**
	* 添加
	* @param busiUser
	* @return
	*/
	public boolean insertBusiUser(BusiUser busiUser);

	/**
	* 修改
	* @param busiUser
	* @return
	*/
	public boolean updateBusiUser(BusiUser busiUser);

	/**
	* 删除
	* @param busiUser
	* @return
	*/
	public boolean deleteBusiUser(BusiUser busiUser);

	/**
	* 查询
	* @param busiUser
	* @return
	*/
	public BusiUser getBusiUser(BusiUser busiUser);

//<=================定制内容开始==============
	/**
	 * 根据昵称、密码和号码查询用户
	 * @param busiUser
	 * @return
	 */
	public BusiUser getBusiUserByCodeAndPwdAndPhone(BusiUser busiUser);
	
	/**
	* 登录后操作 
	* @param busiUser
	* @return
	*/
	public boolean updateBusiUserByLogin(BusiUser busiUser);
//==================定制内容结束==============>

}