package com.xiaoyu.fun.service.impl;

import com.xiaoyu.fun.service.CoreDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xiaoyu.fun.mybatis.dao.MyBatisDAO;
import com.xiaoyu.fun.entity.CoreDict;

@Service("coreDictService")
public class CoreDictServiceImpl implements CoreDictService {

	@Autowired
	private MyBatisDAO myBatisDAO;

	@Override
	public boolean insertCoreDict(CoreDict coreDict) {
		myBatisDAO.insert(coreDict);
		return true;
	}

	@Override
	public boolean updateCoreDict(CoreDict coreDict) {
		myBatisDAO.update(coreDict);
		return true;
	}

	@Override
	public boolean deleteCoreDict(CoreDict coreDict) {
		myBatisDAO.delete(coreDict);
		return true;
	}

	@Override
	public CoreDict getCoreDict(CoreDict coreDict) {
		return (CoreDict) myBatisDAO.findForObject(coreDict);
	}

//<=================定制内容开始==============
//==================定制内容结束==============>

}