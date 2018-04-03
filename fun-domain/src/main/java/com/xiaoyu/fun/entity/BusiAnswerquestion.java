package com.xiaoyu.fun.entity;

import com.xiaoyu.fun.entity.BaseEntity;
import java.util.Date;

public class BusiAnswerquestion extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	*标识UNID
	*/
	private Integer bsaqnUnid;

	/**
	*标识UUID
	*/
	private String bsaqnUuid;

	/**
	*用户UUID
	*/
	private String bsaqnUser;

	/**
	*密保问题UUID
	*/
	private String bsaqnQuestion;

	/**
	*回答时间
	*/
	private Date bsaqnTime;

	/**
	*答案
	*/
	private String bsaqnResult;

	public void setBsaqnUnid(Integer bsaqnUnid) {
		this.bsaqnUnid = bsaqnUnid;
	}

	public Integer getBsaqnUnid( ) {
		return bsaqnUnid;
	}

	public void setBsaqnUuid(String bsaqnUuid) {
		this.bsaqnUuid = bsaqnUuid;
	}

	public String getBsaqnUuid( ) {
		return bsaqnUuid;
	}

	public void setBsaqnUser(String bsaqnUser) {
		this.bsaqnUser = bsaqnUser;
	}

	public String getBsaqnUser( ) {
		return bsaqnUser;
	}

	public void setBsaqnQuestion(String bsaqnQuestion) {
		this.bsaqnQuestion = bsaqnQuestion;
	}

	public String getBsaqnQuestion( ) {
		return bsaqnQuestion;
	}

	public void setBsaqnTime(Date bsaqnTime) {
		this.bsaqnTime = bsaqnTime;
	}

	public Date getBsaqnTime( ) {
		return bsaqnTime;
	}

	public void setBsaqnResult(String bsaqnResult) {
		this.bsaqnResult = bsaqnResult;
	}

	public String getBsaqnResult( ) {
		return bsaqnResult;
	}

	public BusiAnswerquestion( ) { 
	}

//<=================定制内容开始==============
	public BusiAnswerquestion(String bsaqnUser, String bsaqnQuestion, String bsaqnResult) {
		this.bsaqnQuestion = bsaqnQuestion;
		this.bsaqnResult = bsaqnResult;
		this.bsaqnTime = new Date();
		this.bsaqnUser = bsaqnUser;
	}
//==================定制内容结束==============>

}