package com.xiaoyu.fun.service;

import com.xiaoyu.fun.entity.BusiFeedback;

public interface BusiFeedbackService {

	/**
	* 添加
	* @param busiFeedback
	* @return
	*/
	public boolean insertBusiFeedback(BusiFeedback busiFeedback);

	/**
	* 修改
	* @param busiFeedback
	* @return
	*/
	public boolean updateBusiFeedback(BusiFeedback busiFeedback);

	/**
	* 删除
	* @param busiFeedback
	* @return
	*/
	public boolean deleteBusiFeedback(BusiFeedback busiFeedback);

	/**
	* 查询
	* @param busiFeedback
	* @return
	*/
	public BusiFeedback getBusiFeedback(BusiFeedback busiFeedback);

//<=================定制内容开始==============
//==================定制内容结束==============>

}