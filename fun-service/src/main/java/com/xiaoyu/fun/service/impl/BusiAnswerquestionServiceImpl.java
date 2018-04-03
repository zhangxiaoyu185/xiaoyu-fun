package com.xiaoyu.fun.service.impl;

import com.xiaoyu.fun.service.BusiAnswerquestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xiaoyu.fun.mybatis.dao.MyBatisDAO;
import com.xiaoyu.fun.entity.BusiAnswerquestion;

@Service("busiAnswerquestionService")
public class BusiAnswerquestionServiceImpl implements BusiAnswerquestionService {

	@Autowired
	private MyBatisDAO myBatisDAO;

	@Override
	public boolean insertBusiAnswerquestion(BusiAnswerquestion busiAnswerquestion) {
		myBatisDAO.insert(busiAnswerquestion);
		return true;
	}

	@Override
	public boolean updateBusiAnswerquestion(BusiAnswerquestion busiAnswerquestion) {
		myBatisDAO.update(busiAnswerquestion);
		return true;
	}

	@Override
	public boolean deleteBusiAnswerquestion(BusiAnswerquestion busiAnswerquestion) {
		myBatisDAO.delete(busiAnswerquestion);
		return true;
	}

	@Override
	public BusiAnswerquestion getBusiAnswerquestion(BusiAnswerquestion busiAnswerquestion) {
		return (BusiAnswerquestion) myBatisDAO.findForObject(busiAnswerquestion);
	}

//<=================定制内容开始==============
	private static final String UPDATE_BUSI_ANSWER_QUESTION_BY_BSAQNUSER = "updateBusiAnswerquestionByBsaqnUser";
	private static final String GET_BUSI_ANSWER_QUESTION_BY_BSAQNUSER = "getBusiAnswerquestionByBsaqnUser";
	
	@Override
	public boolean updateBusiAnswerquestionByBsaqnUser(
			BusiAnswerquestion busiAnswerquestion) {
		myBatisDAO.update(UPDATE_BUSI_ANSWER_QUESTION_BY_BSAQNUSER, busiAnswerquestion);
		return true;
	}

	@Override
	public BusiAnswerquestion getBusiAnswerquestionByBsaqnUser(
			BusiAnswerquestion busiAnswerquestion) {
		return (BusiAnswerquestion) myBatisDAO.findForObject(GET_BUSI_ANSWER_QUESTION_BY_BSAQNUSER, busiAnswerquestion);
	}
//==================定制内容结束==============>

}