package com.xiaoyu.fun.vo;

import com.xiaoyu.fun.entity.BusiCollect;
import com.xiaoyu.fun.util.BaseVO;
import com.xiaoyu.fun.util.DateUtil;

public class BusiCollectVO implements BaseVO {

	/**
	*标识UUID
	*/
	private String bscltUuid;

	/**
	*趣事UUID
	*/
	private String bscltFun;

	/**
	*收藏时间
	*/
	private String bscltTime;

	/**
	*状态:1启用,0禁用
	*/
	private Integer bscltStatus;

	/**
	*排序号
	*/
	private Integer bscltOrd;

	/**
	*收藏人UUID
	*/
	private String bscltUser;

	public void setBscltUuid(String bscltUuid) {
		this.bscltUuid = bscltUuid;
	}

	public String getBscltUuid( ) {
		return bscltUuid;
	}

	public void setBscltFun(String bscltFun) {
		this.bscltFun = bscltFun;
	}

	public String getBscltFun( ) {
		return bscltFun;
	}

	public void setBscltTime(String bscltTime) {
		this.bscltTime = bscltTime;
	}

	public String getBscltTime( ) {
		return bscltTime;
	}

	public void setBscltStatus(Integer bscltStatus) {
		this.bscltStatus = bscltStatus;
	}

	public Integer getBscltStatus( ) {
		return bscltStatus;
	}

	public void setBscltOrd(Integer bscltOrd) {
		this.bscltOrd = bscltOrd;
	}

	public Integer getBscltOrd( ) {
		return bscltOrd;
	}

	public void setBscltUser(String bscltUser) {
		this.bscltUser = bscltUser;
	}

	public String getBscltUser( ) {
		return bscltUser;
	}

	public BusiCollectVO( ) { 
	}

	@Override
	public void convertPOToVO(Object poObj) {
		if (null == poObj) {
			return;
		}

		BusiCollect po = (BusiCollect) poObj;
		this.bscltUuid = po.getBscltUuid();
		this.bscltFun = po.getBscltFun();
		this.bscltTime = po.getBscltTime()!=null?DateUtil.formatDefaultDate(po.getBscltTime()):"";
		this.bscltStatus = po.getBscltStatus();
		this.bscltOrd = po.getBscltOrd();
		this.bscltUser = po.getBscltUser();
	}
//<=================定制内容开始==============
//==================定制内容结束==============>

}