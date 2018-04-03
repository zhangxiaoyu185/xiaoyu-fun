package com.xiaoyu.fun.entity;

import com.xiaoyu.fun.entity.BaseEntity;
import java.util.Date;

public class BusiReport extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	*标识UNID
	*/
	private Integer bsretUnid;

	/**
	*标识UUID
	*/
	private String bsretUuid;

	/**
	*被举报趣事UUID
	*/
	private String bsretFun;

	/**
	*创建日期
	*/
	private Date bsretCdate;

	/**
	*修改日期
	*/
	private Date bsretUdate;

	/**
	*处理结果（1.未处理，2.已处理）
	*/
	private Integer bsretStatus;

	/**
	*排序号
	*/
	private Integer bsretOrd;

	/**
	*举报人UUID
	*/
	private String bsretUser;

	public void setBsretUnid(Integer bsretUnid) {
		this.bsretUnid = bsretUnid;
	}

	public Integer getBsretUnid( ) {
		return bsretUnid;
	}

	public void setBsretUuid(String bsretUuid) {
		this.bsretUuid = bsretUuid;
	}

	public String getBsretUuid( ) {
		return bsretUuid;
	}

	public void setBsretFun(String bsretFun) {
		this.bsretFun = bsretFun;
	}

	public String getBsretFun( ) {
		return bsretFun;
	}

	public void setBsretCdate(Date bsretCdate) {
		this.bsretCdate = bsretCdate;
	}

	public Date getBsretCdate( ) {
		return bsretCdate;
	}

	public void setBsretUdate(Date bsretUdate) {
		this.bsretUdate = bsretUdate;
	}

	public Date getBsretUdate( ) {
		return bsretUdate;
	}

	public void setBsretStatus(Integer bsretStatus) {
		this.bsretStatus = bsretStatus;
	}

	public Integer getBsretStatus( ) {
		return bsretStatus;
	}

	public void setBsretOrd(Integer bsretOrd) {
		this.bsretOrd = bsretOrd;
	}

	public Integer getBsretOrd( ) {
		return bsretOrd;
	}

	public void setBsretUser(String bsretUser) {
		this.bsretUser = bsretUser;
	}

	public String getBsretUser( ) {
		return bsretUser;
	}

	public BusiReport( ) { 
	}

//<=================定制内容开始==============
//==================定制内容结束==============>

}