package com.xiaoyu.fun.entity;

import com.xiaoyu.fun.entity.BaseEntity;
import java.util.Date;

public class BusiCollect extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	*标识UNID
	*/
	private Integer bscltUnid;

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
	private Date bscltTime;

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

	public void setBscltUnid(Integer bscltUnid) {
		this.bscltUnid = bscltUnid;
	}

	public Integer getBscltUnid( ) {
		return bscltUnid;
	}

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

	public void setBscltTime(Date bscltTime) {
		this.bscltTime = bscltTime;
	}

	public Date getBscltTime( ) {
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

	public BusiCollect( ) { 
	}

//<=================定制内容开始==============
//==================定制内容结束==============>

}