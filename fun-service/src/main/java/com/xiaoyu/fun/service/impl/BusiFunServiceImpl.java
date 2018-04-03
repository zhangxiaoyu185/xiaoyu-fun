package com.xiaoyu.fun.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xiaoyu.fun.service.BusiFunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xiaoyu.fun.mybatis.dao.MyBatisDAO;
import com.xiaoyu.fun.entity.BusiFun;

@Service("busiFunService")
public class BusiFunServiceImpl implements BusiFunService {

	@Autowired
	private MyBatisDAO myBatisDAO;

	@Override
	public boolean insertBusiFun(BusiFun busiFun) {
		myBatisDAO.insert(busiFun);
		return true;
	}

	@Override
	public boolean updateBusiFun(BusiFun busiFun) {
		myBatisDAO.update(busiFun);
		return true;
	}

	@Override
	public boolean deleteBusiFun(BusiFun busiFun) {
		myBatisDAO.delete(busiFun);
		return true;
	}

	@Override
	public BusiFun getBusiFun(BusiFun busiFun) {
		return (BusiFun) myBatisDAO.findForObject(busiFun);
	}

//<=================定制内容开始==============
	private static final String GET_BUSI_FUN_BY_LASTID = "getBusiFunByLastId";
	private static final String GET_BUSI_FUN_BY_MY_HAND_IN = "getBusiFunByMyHandIn";
	private static final String GET_BUSI_FUN_BY_MY_COLLECT = "getBusiFunByMyCollect";
	private static final String UPDATE_BUSI_FUN_GOOD = "updateBusiFunGood";
	private static final String UPDATE_BUSI_FUN_FAIL = "updateBusiFunFail";
	private static final String GET_BUSI_FUN_BY_NO_VERIFY = "getBusiFunByNoVerify";
	private static final String GET_BUSI_FUN_BY_VERIFY = "getBusiFunByVerify";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BusiFun> getBusiFunByLastId(int lastId, int sortBy, Integer type, int limit, String userUuid) {
		Map<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("lastId", lastId);
		hashMap.put("sortBy", sortBy);
		if(type != null) {
			hashMap.put("type", type);
		}
		if(userUuid != null) {
			hashMap.put("userUuid", userUuid);
		}
		return myBatisDAO.findForList(GET_BUSI_FUN_BY_LASTID, hashMap, 0, limit);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BusiFun> getBusiFunByMyHandIn(int lastId, int limit, String userUuid) {
		Map<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("lastId", lastId);
		hashMap.put("userUuid", userUuid);
		return myBatisDAO.findForList(GET_BUSI_FUN_BY_MY_HAND_IN, hashMap, 0, limit);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BusiFun> getBusiFunByMyCollect(int lastId, int limit,
			String userUuid) {
		Map<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("lastId", lastId);
		hashMap.put("userUuid", userUuid);
		return myBatisDAO.findForList(GET_BUSI_FUN_BY_MY_COLLECT, hashMap, 0, limit);
	}
	
	@Override
	public boolean updateBusiFunGood(String bsfunUuid, String userUuid) {
		Map<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("bsfunUuid", bsfunUuid);
		hashMap.put("userUuid", userUuid);
		myBatisDAO.update(UPDATE_BUSI_FUN_GOOD, hashMap);
		return true;
	}

	@Override
	public boolean updateBusiFunFail(String bsfunUuid, String userUuid) {
		Map<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("bsfunUuid", bsfunUuid);
		hashMap.put("userUuid", userUuid);
		myBatisDAO.update(UPDATE_BUSI_FUN_FAIL, hashMap);
		return true;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BusiFun> getBusiFunByNoVerify(String userUuid) {
		Map<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("userUuid", userUuid);
		return myBatisDAO.findForList(GET_BUSI_FUN_BY_NO_VERIFY, hashMap);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BusiFun> getBusiFunByVerify() {
		return myBatisDAO.findForList(GET_BUSI_FUN_BY_VERIFY, null);
	}
//==================定制内容结束==============>

}