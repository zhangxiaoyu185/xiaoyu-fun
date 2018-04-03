package com.xiaoyu.fun.vo;

import com.xiaoyu.fun.entity.BusiAnswerquestion;
import com.xiaoyu.fun.util.BaseVO;
import com.xiaoyu.fun.util.DateUtil;

public class BusiAnswerquestionVO implements BaseVO {

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
	private String bsaqnTime;

	/**
	*答案
	*/
	private String bsaqnResult;

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

	public void setBsaqnTime(String bsaqnTime) {
		this.bsaqnTime = bsaqnTime;
	}

	public String getBsaqnTime( ) {
		return bsaqnTime;
	}

	public void setBsaqnResult(String bsaqnResult) {
		this.bsaqnResult = bsaqnResult;
	}

	public String getBsaqnResult( ) {
		return bsaqnResult;
	}

	public BusiAnswerquestionVO( ) { 
	}

	@Override
	public void convertPOToVO(Object poObj) {
		if (null == poObj) {
			return;
		}

		BusiAnswerquestion po = (BusiAnswerquestion) poObj;
		this.bsaqnUuid = po.getBsaqnUuid();
		this.bsaqnUser = po.getBsaqnUser();
		this.bsaqnQuestion = po.getBsaqnQuestion();
		this.bsaqnTime = po.getBsaqnTime()!=null?DateUtil.formatDefaultDate(po.getBsaqnTime()):"";
		this.bsaqnResult = po.getBsaqnResult();
	}
//<=================定制内容开始==============
//==================定制内容结束==============>

}