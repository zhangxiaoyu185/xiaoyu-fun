package com.xiaoyu.fun.service;

import java.util.List;
import com.xiaoyu.fun.entity.BusiComment;

public interface BusiCommentService {

	/**
	* 添加
	* @param busiComment
	* @return
	*/
	public boolean insertBusiComment(BusiComment busiComment);

	/**
	* 修改
	* @param busiComment
	* @return
	*/
	public boolean updateBusiComment(BusiComment busiComment);

	/**
	* 删除
	* @param busiComment
	* @return
	*/
	public boolean deleteBusiComment(BusiComment busiComment);

	/**
	* 查询
	* @param busiComment
	* @return
	*/
	public BusiComment getBusiComment(BusiComment busiComment);

//<=================定制内容开始==============
	/**
	* 评论总数
	* @param
	* @return
	*/
	public int getCountComment(String bscotFun);
	
	/**
	* 评论列表
	* @param
	* @return
	*/
	public List<BusiComment> getBusiCommentByFun(int lastId, int limit, String bscotFun);
//==================定制内容结束==============>

}