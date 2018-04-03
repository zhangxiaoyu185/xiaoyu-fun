package com.xiaoyu.fun.service;

import com.xiaoyu.fun.entity.CoreAccount;

public interface CoreAccountService {

	/**
	* 添加
	* @param coreAccount
	* @return
	*/
	public boolean insertCoreAccount(CoreAccount coreAccount);

	/**
	* 修改
	* @param coreAccount
	* @return
	*/
	public boolean updateCoreAccount(CoreAccount coreAccount);

	/**
	* 删除
	* @param coreAccount
	* @return
	*/
	public boolean deleteCoreAccount(CoreAccount coreAccount);

	/**
	* 查询
	* @param coreAccount
	* @return
	*/
	public CoreAccount getCoreAccount(CoreAccount coreAccount);

//<=================定制内容开始==============
	/**
	 * 根据昵称、密码查询用户
	 * @param busiUser
	 * @return
	 */
	public CoreAccount getCoreAccountByNameAndPwd(CoreAccount coreAccount);
//==================定制内容结束==============>

}