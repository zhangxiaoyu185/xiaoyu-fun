package com.xiaoyu.fun.vo;

import com.xiaoyu.fun.entity.BusiComment;
import com.xiaoyu.fun.util.BaseVO;
import com.xiaoyu.fun.util.DateUtil;

public class BusiCommentVO implements BaseVO {

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
	private String bscotTime;

	/**
	*状态:1启用,0禁用
	*/
	private Integer bscotStatus;

	/**
	*发表人昵称
	*/
	private String bscotUserCode;
	
	/**
	*发表人头像
	*/
	private String bscotUserHead;
	
	/**
	*排序号
	*/
	private Integer bscotOrd;

	/**
	*评论人UUID
	*/
	private String bscotUser;

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

	public void setBscotTime(String bscotTime) {
		this.bscotTime = bscotTime;
	}

	public String getBscotTime( ) {
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

	public Integer getBscotUnid() {
		return bscotUnid;
	}

	public void setBscotUnid(Integer bscotUnid) {
		this.bscotUnid = bscotUnid;
	}

	public String getBscotUserCode() {
		return bscotUserCode;
	}

	public void setBscotUserCode(String bscotUserCode) {
		this.bscotUserCode = bscotUserCode;
	}

	public String getBscotUserHead() {
		return bscotUserHead;
	}

	public void setBscotUserHead(String bscotUserHead) {
		this.bscotUserHead = bscotUserHead;
	}

	public BusiCommentVO( ) { 
	}

	@Override
	public void convertPOToVO(Object poObj) {
		if (null == poObj) {
			return;
		}

		BusiComment po = (BusiComment) poObj;
		this.bscotUnid = po.getBscotUnid();
		this.bscotUuid = po.getBscotUuid();
		this.bscotFun = po.getBscotFun();
		this.bscotContent = po.getBscotContent();
		this.bscotTime = po.getBscotTime()!=null?DateUtil.formatDefaultDate(po.getBscotTime()):"";
		this.bscotStatus = po.getBscotStatus();
		this.bscotOrd = po.getBscotOrd();
		this.bscotUser = po.getBscotUser();
	}
//<=================定制内容开始==============
//==================定制内容结束==============>

}