package com.xiaoyu.fun.entity;

import com.xiaoyu.fun.entity.BaseEntity;
import java.util.Date;

public class CoreSuggest extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	*标识UNID
	*/
	private Integer crsgtUnid;

	/**
	*标识UUID
	*/
	private String crsgtUuid;

	/**
	*主题
	*/
	private String crsgtTitle;

	/**
	*提出人
	*/
	private String crsgtPeople;

	/**
	*创建日期
	*/
	private Date crsgtCdate;

	/**
	*修改日期
	*/
	private Date crsgtUdate;

	/**
	*处理状态:1未处理,0已处理
	*/
	private Integer crsgtStatus;

	/**
	*排序号
	*/
	private Integer crsgtOrd;

	/**
	*提出内容
	*/
	private String crsgtContent;

	public void setCrsgtUnid(Integer crsgtUnid) {
		this.crsgtUnid = crsgtUnid;
	}

	public Integer getCrsgtUnid( ) {
		return crsgtUnid;
	}

	public void setCrsgtUuid(String crsgtUuid) {
		this.crsgtUuid = crsgtUuid;
	}

	public String getCrsgtUuid( ) {
		return crsgtUuid;
	}

	public void setCrsgtTitle(String crsgtTitle) {
		this.crsgtTitle = crsgtTitle;
	}

	public String getCrsgtTitle( ) {
		return crsgtTitle;
	}

	public void setCrsgtPeople(String crsgtPeople) {
		this.crsgtPeople = crsgtPeople;
	}

	public String getCrsgtPeople( ) {
		return crsgtPeople;
	}

	public void setCrsgtCdate(Date crsgtCdate) {
		this.crsgtCdate = crsgtCdate;
	}

	public Date getCrsgtCdate( ) {
		return crsgtCdate;
	}

	public void setCrsgtUdate(Date crsgtUdate) {
		this.crsgtUdate = crsgtUdate;
	}

	public Date getCrsgtUdate( ) {
		return crsgtUdate;
	}

	public void setCrsgtStatus(Integer crsgtStatus) {
		this.crsgtStatus = crsgtStatus;
	}

	public Integer getCrsgtStatus( ) {
		return crsgtStatus;
	}

	public void setCrsgtOrd(Integer crsgtOrd) {
		this.crsgtOrd = crsgtOrd;
	}

	public Integer getCrsgtOrd( ) {
		return crsgtOrd;
	}

	public void setCrsgtContent(String crsgtContent) {
		this.crsgtContent = crsgtContent;
	}

	public String getCrsgtContent( ) {
		return crsgtContent;
	}

	public CoreSuggest( ) { 
	}

//<=================定制内容开始==============
//==================定制内容结束==============>

}