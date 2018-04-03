package com.xiaoyu.fun.entity;

import com.xiaoyu.fun.entity.BaseEntity;
import java.util.Date;

public class BusiFeedback extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	*标识UNID
	*/
	private Integer bsfbkUnid;

	/**
	*标识UUID
	*/
	private String bsfbkUuid;

	/**
	*反馈内容
	*/
	private String bsfbkContent;

	/**
	*用户UUID
	*/
	private String bsfbkUser;

	/**
	*账户昵称
	*/
	private String bsfbkCode;

	/**
	*联系方式（QQ或邮箱）
	*/
	private String bsfbkRelation;

	/**
	*处理状态:1未处理,2已处理，3忽略
	*/
	private Integer bsfbkStatus;

	/**
	*反馈时间
	*/
	private Date bsfbkBackTime;

	/**
	*处理时间
	*/
	private Date bsfbkHandleTime;

	/**
	*处理结果
	*/
	private String bsfbkResult;

	public void setBsfbkUnid(Integer bsfbkUnid) {
		this.bsfbkUnid = bsfbkUnid;
	}

	public Integer getBsfbkUnid( ) {
		return bsfbkUnid;
	}

	public void setBsfbkUuid(String bsfbkUuid) {
		this.bsfbkUuid = bsfbkUuid;
	}

	public String getBsfbkUuid( ) {
		return bsfbkUuid;
	}

	public void setBsfbkContent(String bsfbkContent) {
		this.bsfbkContent = bsfbkContent;
	}

	public String getBsfbkContent( ) {
		return bsfbkContent;
	}

	public void setBsfbkUser(String bsfbkUser) {
		this.bsfbkUser = bsfbkUser;
	}

	public String getBsfbkUser( ) {
		return bsfbkUser;
	}

	public void setBsfbkCode(String bsfbkCode) {
		this.bsfbkCode = bsfbkCode;
	}

	public String getBsfbkCode( ) {
		return bsfbkCode;
	}

	public void setBsfbkRelation(String bsfbkRelation) {
		this.bsfbkRelation = bsfbkRelation;
	}

	public String getBsfbkRelation( ) {
		return bsfbkRelation;
	}

	public void setBsfbkStatus(Integer bsfbkStatus) {
		this.bsfbkStatus = bsfbkStatus;
	}

	public Integer getBsfbkStatus( ) {
		return bsfbkStatus;
	}

	public void setBsfbkBackTime(Date bsfbkBackTime) {
		this.bsfbkBackTime = bsfbkBackTime;
	}

	public Date getBsfbkBackTime( ) {
		return bsfbkBackTime;
	}

	public void setBsfbkHandleTime(Date bsfbkHandleTime) {
		this.bsfbkHandleTime = bsfbkHandleTime;
	}

	public Date getBsfbkHandleTime( ) {
		return bsfbkHandleTime;
	}

	public void setBsfbkResult(String bsfbkResult) {
		this.bsfbkResult = bsfbkResult;
	}

	public String getBsfbkResult( ) {
		return bsfbkResult;
	}

	public BusiFeedback( ) { 
	}
	
	public BusiFeedback(String bsfbkContent, String bsfbkUser, String bsfbkRelation) {
		this.bsfbkContent = bsfbkContent;
		this.bsfbkUser = bsfbkUser;
		this.bsfbkRelation = bsfbkRelation;
	}	
//<=================定制内容开始==============
//==================定制内容结束==============>

}