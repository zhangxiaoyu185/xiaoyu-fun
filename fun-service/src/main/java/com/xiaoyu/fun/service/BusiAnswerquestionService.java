package com.xiaoyu.fun.service;

import com.xiaoyu.fun.entity.BusiAnswerquestion;

public interface BusiAnswerquestionService {

	/**
	* 添加
	* @param busiAnswerquestion
	* @return
	*/
	public boolean insertBusiAnswerquestion(BusiAnswerquestion busiAnswerquestion);

	/**
	* 修改
	* @param busiAnswerquestion
	* @return
	*/
	public boolean updateBusiAnswerquestion(BusiAnswerquestion busiAnswerquestion);

	/**
	* 删除
	* @param busiAnswerquestion
	* @return
	*/
	public boolean deleteBusiAnswerquestion(BusiAnswerquestion busiAnswerquestion);

	/**
	* 查询
	* @param busiAnswerquestion
	* @return
	*/
	public BusiAnswerquestion getBusiAnswerquestion(BusiAnswerquestion busiAnswerquestion);

//<=================定制内容开始==============
	/**
	* 根据用户修改
	* @param busiAnswerquestion
	* @return
	*/
	public boolean updateBusiAnswerquestionByBsaqnUser(BusiAnswerquestion busiAnswerquestion);
	
	/**
	* 根据用户查询
	* @param busiAnswerquestion
	* @return
	*/
	public BusiAnswerquestion getBusiAnswerquestionByBsaqnUser(BusiAnswerquestion busiAnswerquestion);
//==================定制内容结束==============>

}