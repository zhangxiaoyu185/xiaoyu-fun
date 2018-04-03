package com.xiaoyu.fun.service.impl;

import com.xiaoyu.fun.service.BusiVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xiaoyu.fun.mybatis.dao.MyBatisDAO;
import com.xiaoyu.fun.entity.BusiVersion;

@Service("busiVersionService")
public class BusiVersionServiceImpl implements BusiVersionService {

	@Autowired
	private MyBatisDAO myBatisDAO;

	@Override
	public boolean insertBusiVersion(BusiVersion busiVersion) {
		myBatisDAO.insert(busiVersion);
		return true;
	}

	@Override
	public boolean updateBusiVersion(BusiVersion busiVersion) {
		myBatisDAO.update(busiVersion);
		return true;
	}

	@Override
	public boolean deleteBusiVersion(BusiVersion busiVersion) {
		myBatisDAO.delete(busiVersion);
		return true;
	}

	@Override
	public BusiVersion getBusiVersion(BusiVersion busiVersion) {
		return (BusiVersion) myBatisDAO.findForObject(busiVersion);
	}

//<=================定制内容开始==============
	private static final String GET_BUSI_VERSION_BY_TYPE = "getBusiVersionByType";
	
	@Override
	public BusiVersion getBusiVersionByType(BusiVersion busiVersion) {
		return (BusiVersion) myBatisDAO.findForObject(GET_BUSI_VERSION_BY_TYPE, busiVersion);
	}
//==================定制内容结束==============>

}