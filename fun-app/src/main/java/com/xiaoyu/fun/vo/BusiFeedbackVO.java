package com.xiaoyu.fun.vo;

import com.xiaoyu.fun.entity.BusiFeedback;
import com.xiaoyu.fun.util.BaseVO;
import com.xiaoyu.fun.util.DateUtil;

public class BusiFeedbackVO implements BaseVO {

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
	private String bsfbkBackTime;

	/**
	*处理时间
	*/
	private String bsfbkHandleTime;

	/**
	*处理结果
	*/
	private String bsfbkResult;

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

	public void setBsfbkBackTime(String bsfbkBackTime) {
		this.bsfbkBackTime = bsfbkBackTime;
	}

	public String getBsfbkBackTime( ) {
		return bsfbkBackTime;
	}

	public void setBsfbkHandleTime(String bsfbkHandleTime) {
		this.bsfbkHandleTime = bsfbkHandleTime;
	}

	public String getBsfbkHandleTime( ) {
		return bsfbkHandleTime;
	}

	public void setBsfbkResult(String bsfbkResult) {
		this.bsfbkResult = bsfbkResult;
	}

	public String getBsfbkResult( ) {
		return bsfbkResult;
	}

	public BusiFeedbackVO( ) { 
	}

	@Override
	public void convertPOToVO(Object poObj) {
		if (null == poObj) {
			return;
		}

		BusiFeedback po = (BusiFeedback) poObj;
		this.bsfbkUuid = po.getBsfbkUuid();
		this.bsfbkContent = po.getBsfbkContent();
		this.bsfbkUser = po.getBsfbkUser();
		this.bsfbkCode = po.getBsfbkCode();
		this.bsfbkRelation = po.getBsfbkRelation();
		this.bsfbkStatus = po.getBsfbkStatus();
		this.bsfbkBackTime = po.getBsfbkBackTime()!=null?DateUtil.formatDefaultDate(po.getBsfbkBackTime()):"";
		this.bsfbkHandleTime = po.getBsfbkHandleTime()!=null?DateUtil.formatDefaultDate(po.getBsfbkHandleTime()):"";
		this.bsfbkResult = po.getBsfbkResult();
	}
//<=================定制内容开始==============
//==================定制内容结束==============>

}