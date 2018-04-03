package com.xiaoyu.fun.service.impl;

import com.xiaoyu.fun.service.CoreFunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xiaoyu.fun.mybatis.dao.MyBatisDAO;
import com.xiaoyu.fun.entity.CoreFunction;

@Service("coreFunctionService")
public class CoreFunctionServiceImpl implements CoreFunctionService {

	@Autowired
	private MyBatisDAO myBatisDAO;

	@Override
	public boolean insertCoreFunction(CoreFunction coreFunction) {
		myBatisDAO.insert(coreFunction);
		return true;
	}

	@Override
	public boolean updateCoreFunction(CoreFunction coreFunction) {
		myBatisDAO.update(coreFunction);
		return true;
	}

	@Override
	public boolean deleteCoreFunction(CoreFunction coreFunction) {
		myBatisDAO.delete(coreFunction);
		return true;
	}

	@Override
	public CoreFunction getCoreFunction(CoreFunction coreFunction) {
		return (CoreFunction) myBatisDAO.findForObject(coreFunction);
	}

//<=================定制内容开始==============
//==================定制内容结束==============>

}