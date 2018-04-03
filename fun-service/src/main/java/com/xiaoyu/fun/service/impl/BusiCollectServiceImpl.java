package com.xiaoyu.fun.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.xiaoyu.fun.service.BusiCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xiaoyu.fun.mybatis.dao.MyBatisDAO;
import com.xiaoyu.fun.entity.BusiCollect;

@Service("busiCollectService")
public class BusiCollectServiceImpl implements BusiCollectService {

	@Autowired
	private MyBatisDAO myBatisDAO;

	@Override
	public boolean insertBusiCollect(BusiCollect busiCollect) {
		myBatisDAO.insert(busiCollect);
		return true;
	}

	@Override
	public boolean updateBusiCollect(BusiCollect busiCollect) {
		myBatisDAO.update(busiCollect);
		return true;
	}

	@Override
	public boolean deleteBusiCollect(BusiCollect busiCollect) {
		myBatisDAO.delete(busiCollect);
		return true;
	}

	@Override
	public BusiCollect getBusiCollect(BusiCollect busiCollect) {
		return (BusiCollect) myBatisDAO.findForObject(busiCollect);
	}
//<=================定制内容开始==============	
	private static final String GET_BUSI_COLLECT_BY_USER_AND_FUN = "getBusiCollectByUserAndFUN";
	private static final String DELETE_BUSI_COLLECT_BY_FUN_AND_USER = "deleteBusiCollectByFunAndUser";
	
	@Override
	public BusiCollect getBusiCollectByUserAndFUN(BusiCollect busiCollect) {
		return (BusiCollect) myBatisDAO.findForObject(GET_BUSI_COLLECT_BY_USER_AND_FUN, busiCollect);
	}
	
	@Override
	public boolean deleteBusiCollectByFunAndUser(String bscltFun,
			String bscltUser) {
		Map<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("bscltFun", bscltFun);
		hashMap.put("bscltUser", bscltUser);
		myBatisDAO.delete(DELETE_BUSI_COLLECT_BY_FUN_AND_USER, hashMap);
		return true;
	}
//==================定制内容结束==============>

}