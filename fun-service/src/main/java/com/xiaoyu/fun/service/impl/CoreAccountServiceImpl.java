package com.xiaoyu.fun.service.impl;

import com.xiaoyu.fun.service.CoreAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xiaoyu.fun.mybatis.dao.MyBatisDAO;
import com.xiaoyu.fun.entity.CoreAccount;

@Service("coreAccountService")
public class CoreAccountServiceImpl implements CoreAccountService {

	@Autowired
	private MyBatisDAO myBatisDAO;

	@Override
	public boolean insertCoreAccount(CoreAccount coreAccount) {
		myBatisDAO.insert(coreAccount);
		return true;
	}

	@Override
	public boolean updateCoreAccount(CoreAccount coreAccount) {
		myBatisDAO.update(coreAccount);
		return true;
	}

	@Override
	public boolean deleteCoreAccount(CoreAccount coreAccount) {
		myBatisDAO.delete(coreAccount);
		return true;
	}

	@Override
	public CoreAccount getCoreAccount(CoreAccount coreAccount) {
		return (CoreAccount) myBatisDAO.findForObject(coreAccount);
	}

//<=================定制内容开始==============
	private static final String GET_CORE_ACCOUNT_BY_NAME_AND_PWD = "getCoreAccountByNameAndPwd";
	
	@Override
	public CoreAccount getCoreAccountByNameAndPwd(CoreAccount coreAccount) {
		return (CoreAccount) myBatisDAO.findForObject(GET_CORE_ACCOUNT_BY_NAME_AND_PWD, coreAccount);
	}
//==================定制内容结束==============>

}