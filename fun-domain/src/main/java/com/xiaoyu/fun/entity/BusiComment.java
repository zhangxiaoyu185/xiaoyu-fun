package com.xiaoyu.fun.entity;

import com.xiaoyu.fun.entity.BaseEntity;
import java.util.Date;

public class BusiComment extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	*标识UNID
	*/
	private Integer bscotUnid;

	/**
	*标识UUID
	*/
	private String bscotUuid;

	/**
	*趣事UUID
	*/
	private String bscotFun;

	/**
	*评论内容
	*/
	private String bscotContent;

	/**
	*评论时间
	*/
	private Date bscotTime;

	/**
	*状态:1启用,0禁用
	*/
	private Integer bscotStatus;

	/**
	*排序号
	*/
	private Integer bscotOrd;

	/**
	*评论人UUID
	*/
	private String bscotUser;

	public void setBscotUnid(Integer bscotUnid) {
		this.bscotUnid = bscotUnid;
	}

	public Integer getBscotUnid( ) {
		return bscotUnid;
	}

	public void setBscotUuid(String bscotUuid) {
		this.bscotUuid = bscotUuid;
	}

	public String getBscotUuid( ) {
		return bscotUuid;
	}

	public void setBscotFun(String bscotFun) {
		this.bscotFun = bscotFun;
	}

	public String getBscotFun( ) {
		return bscotFun;
	}

	public void setBscotContent(String bscotContent) {
		this.bscotContent = bscotContent;
	}

	public String getBscotContent( ) {
		return bscotContent;
	}

	public void setBscotTime(Date bscotTime) {
		this.bscotTime = bscotTime;
	}

	public Date getBscotTime( ) {
		return bscotTime;
	}

	public void setBscotStatus(Integer bscotStatus) {
		this.bscotStatus = bscotStatus;
	}

	public Integer getBscotStatus( ) {
		return bscotStatus;
	}

	public void setBscotOrd(Integer bscotOrd) {
		this.bscotOrd = bscotOrd;
	}

	public Integer getBscotOrd( ) {
		return bscotOrd;
	}

	public void setBscotUser(String bscotUser) {
		this.bscotUser = bscotUser;
	}

	public String getBscotUser( ) {
		return bscotUser;
	}

	public BusiComment( ) { 
	}

//<=================定制内容开始==============
//==================定制内容结束==============>

}