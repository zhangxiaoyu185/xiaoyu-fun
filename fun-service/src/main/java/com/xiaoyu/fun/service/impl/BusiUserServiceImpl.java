package com.xiaoyu.fun.service.impl;

import java.util.List;
import com.xiaoyu.fun.service.BusiUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xiaoyu.fun.mybatis.dao.MyBatisDAO;
import com.xiaoyu.fun.entity.BusiUser;

@Service("busiUserService")
public class BusiUserServiceImpl implements BusiUserService {

	@Autowired
	private MyBatisDAO myBatisDAO;

	@Override
	public boolean insertBusiUser(BusiUser busiUser) {
		myBatisDAO.insert(busiUser);
		return true;
	}

	@Override
	public boolean updateBusiUser(BusiUser busiUser) {
		myBatisDAO.update(busiUser);
		return true;
	}

	@Override
	public boolean deleteBusiUser(BusiUser busiUser) {
		myBatisDAO.delete(busiUser);
		return true;
	}

	@Override
	public BusiUser getBusiUser(BusiUser busiUser) {
		return (BusiUser) myBatisDAO.findForObject(busiUser);
	}

//<=================定制内容开始==============
	private static final String GET_BUSI_USER_BY_CODE_AND_PWD_AND_PHONE = "getBusiUserByCodeAndPwdAndPhone";
	private static final String UPDATE_BUSI_USER_BY_LOGIN = "updateBusiUserByLogin";
	
	@SuppressWarnings("unchecked")
	@Override
	public BusiUser getBusiUserByCodeAndPwdAndPhone(BusiUser busiUser) {
		List<BusiUser> list = myBatisDAO.findForList(GET_BUSI_USER_BY_CODE_AND_PWD_AND_PHONE, busiUser);
		if(list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	
	@Override
	public boolean updateBusiUserByLogin(BusiUser busiUser) {
		myBatisDAO.update(UPDATE_BUSI_USER_BY_LOGIN, busiUser);
		return true;
	}
//==================定制内容结束==============>

}