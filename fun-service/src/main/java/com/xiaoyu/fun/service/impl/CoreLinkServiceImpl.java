package com.xiaoyu.fun.service.impl;

import com.xiaoyu.fun.service.CoreLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xiaoyu.fun.mybatis.dao.MyBatisDAO;
import com.xiaoyu.fun.entity.CoreLink;

@Service("coreLinkService")
public class CoreLinkServiceImpl implements CoreLinkService {

	@Autowired
	private MyBatisDAO myBatisDAO;

	@Override
	public boolean insertCoreLink(CoreLink coreLink) {
		myBatisDAO.insert(coreLink);
		return true;
	}

	@Override
	public boolean updateCoreLink(CoreLink coreLink) {
		myBatisDAO.update(coreLink);
		return true;
	}

	@Override
	public boolean deleteCoreLink(CoreLink coreLink) {
		myBatisDAO.delete(coreLink);
		return true;
	}

	@Override
	public CoreLink getCoreLink(CoreLink coreLink) {
		return (CoreLink) myBatisDAO.findForObject(coreLink);
	}

//<=================定制内容开始==============
//==================定制内容结束==============>

}