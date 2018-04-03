package com.xiaoyu.fun.service;

import java.util.List;

import com.xiaoyu.fun.entity.BusiFun;

public interface BusiFunService {

	/**
	* 添加
	* @param busiFun
	* @return
	*/
	public boolean insertBusiFun(BusiFun busiFun);

	/**
	* 修改
	* @param busiFun
	* @return
	*/
	public boolean updateBusiFun(BusiFun busiFun);

	/**
	* 删除
	* @param busiFun
	* @return
	*/
	public boolean deleteBusiFun(BusiFun busiFun);

	/**
	* 查询
	* @param busiFun
	* @return
	*/
	public BusiFun getBusiFun(BusiFun busiFun);

//<=================定制内容开始==============
	
	/**
	* 查询趣事列表和我发布的趣事
	* @param
	* @return
	*/
	public List<BusiFun> getBusiFunByLastId(int lastId, int sortBy, Integer type, int limit, String userUuid);
	
	/**
	* 查询我参与的趣事
	* @param
	* @return
	*/
	public List<BusiFun> getBusiFunByMyHandIn(int lastId, int limit, String userUuid);
	
	/**
	* 查询我收藏的趣事
	* @param
	* @return
	*/
	public List<BusiFun> getBusiFunByMyCollect(int lastId, int limit, String userUuid);
	
	/**
	* 赞（审核通过）
	* @param bsfunUuid
	* @param userUuid(审核时用)
	* @return
	*/
	public boolean updateBusiFunGood(String bsfunUuid, String userUuid);
	
	/**
	* 不赞（审核失败
	* @param bsfunUuid
	* @param userUuid(审核时用)
	* @return
	*/
	public boolean updateBusiFunFail(String bsfunUuid, String userUuid);
	
	/**
	* 未审核趣事列表 
	* @param
	* @return
	*/
	public List<BusiFun> getBusiFunByNoVerify(String userUuid);
	
	/**
	* 通过审核趣事列表
	* @param
	* @return
	*/
	public List<BusiFun> getBusiFunByVerify();
//==================定制内容结束==============>

}