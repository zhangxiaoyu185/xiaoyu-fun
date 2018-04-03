package com.xiaoyu.fun.service;

import java.util.List;
import com.xiaoyu.fun.entity.BusiQuestion;

public interface BusiQuestionService {

	/**
	* 添加
	* @param busiQuestion
	* @return
	*/
	public boolean insertBusiQuestion(BusiQuestion busiQuestion);

	/**
	* 修改
	* @param busiQuestion
	* @return
	*/
	public boolean updateBusiQuestion(BusiQuestion busiQuestion);

	/**
	* 删除
	* @param busiQuestion
	* @return
	*/
	public boolean deleteBusiQuestion(BusiQuestion busiQuestion);

	/**
	* 查询
	* @param busiQuestion
	* @return
	*/
	public BusiQuestion getBusiQuestion(BusiQuestion busiQuestion);

//<=================定制内容开始==============
	/**
	 * 获取密保问题列表
	 * @return
	 */
	public List<BusiQuestion> getAllSafeQuestions();
//==================定制内容结束==============>

}