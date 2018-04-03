package com.xiaoyu.fun.service.impl;

import java.util.List;
import com.xiaoyu.fun.service.BusiQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xiaoyu.fun.mybatis.dao.MyBatisDAO;
import com.xiaoyu.fun.entity.BusiQuestion;

@Service("busiQuestionService")
public class BusiQuestionServiceImpl implements BusiQuestionService {

	@Autowired
	private MyBatisDAO myBatisDAO;

	@Override
	public boolean insertBusiQuestion(BusiQuestion busiQuestion) {
		myBatisDAO.insert(busiQuestion);
		return true;
	}

	@Override
	public boolean updateBusiQuestion(BusiQuestion busiQuestion) {
		myBatisDAO.update(busiQuestion);
		return true;
	}

	@Override
	public boolean deleteBusiQuestion(BusiQuestion busiQuestion) {
		myBatisDAO.delete(busiQuestion);
		return true;
	}

	@Override
	public BusiQuestion getBusiQuestion(BusiQuestion busiQuestion) {
		return (BusiQuestion) myBatisDAO.findForObject(busiQuestion);
	}

//<=================定制内容开始==============
	private static final String SEL_ALL_QUESTION = "selAllQuestion";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BusiQuestion> getAllSafeQuestions() {
		return myBatisDAO.findForList(SEL_ALL_QUESTION, null);
	}
//==================定制内容结束==============>

}