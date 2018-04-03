package com.xiaoyu.fun.service;

import com.xiaoyu.fun.entity.CoreAttachment;

public interface CoreAttachmentService {

	/**
	* 添加
	* @param coreAttachment
	* @return
	*/
	public boolean insertCoreAttachment(CoreAttachment coreAttachment);

	/**
	* 修改
	* @param coreAttachment
	* @return
	*/
	public boolean updateCoreAttachment(CoreAttachment coreAttachment);

	/**
	* 删除
	* @param coreAttachment
	* @return
	*/
	public boolean deleteCoreAttachment(CoreAttachment coreAttachment);

	/**
	* 查询
	* @param coreAttachment
	* @return
	*/
	public CoreAttachment getCoreAttachment(CoreAttachment coreAttachment);

//<=================定制内容开始==============
//==================定制内容结束==============>

}