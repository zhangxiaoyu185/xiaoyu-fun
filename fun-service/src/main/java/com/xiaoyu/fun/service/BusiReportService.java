package com.xiaoyu.fun.service;

import com.xiaoyu.fun.entity.BusiReport;

public interface BusiReportService {

	/**
	* 添加
	* @param busiReport
	* @return
	*/
	public boolean insertBusiReport(BusiReport busiReport);

	/**
	* 修改
	* @param busiReport
	* @return
	*/
	public boolean updateBusiReport(BusiReport busiReport);

	/**
	* 删除
	* @param busiReport
	* @return
	*/
	public boolean deleteBusiReport(BusiReport busiReport);

	/**
	* 查询
	* @param busiReport
	* @return
	*/
	public BusiReport getBusiReport(BusiReport busiReport);

//<=================定制内容开始==============
	/**
	* 根据用户和趣事查询
	* @param busiReport
	* @return
	*/
	public BusiReport getBusiReportByUserAndFUN(BusiReport busiReport);
//==================定制内容结束==============>

}