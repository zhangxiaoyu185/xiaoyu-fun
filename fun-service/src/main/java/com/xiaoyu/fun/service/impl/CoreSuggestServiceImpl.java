package com.xiaoyu.fun.service.impl;

import com.xiaoyu.fun.service.CoreSuggestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xiaoyu.fun.mybatis.dao.MyBatisDAO;
import com.xiaoyu.fun.entity.CoreSuggest;

@Service("coreSuggestService")
public class CoreSuggestServiceImpl implements CoreSuggestService {

	@Autowired
	private MyBatisDAO myBatisDAO;

	@Override
	public boolean insertCoreSuggest(CoreSuggest coreSuggest) {
		myBatisDAO.insert(coreSuggest);
		return true;
	}

	@Override
	public boolean updateCoreSuggest(CoreSuggest coreSuggest) {
		myBatisDAO.update(coreSuggest);
		return true;
	}

	@Override
	public boolean deleteCoreSuggest(CoreSuggest coreSuggest) {
		myBatisDAO.delete(coreSuggest);
		return true;
	}

	@Override
	public CoreSuggest getCoreSuggest(CoreSuggest coreSuggest) {
		return (CoreSuggest) myBatisDAO.findForObject(coreSuggest);
	}

//<=================定制内容开始==============
//==================定制内容结束==============>

}