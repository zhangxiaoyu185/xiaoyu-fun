package com.xiaoyu.fun.vo;

import com.xiaoyu.fun.entity.CoreSuggest;
import com.xiaoyu.fun.util.BaseVO;
import com.xiaoyu.fun.util.DateUtil;

public class CoreSuggestVO implements BaseVO {

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
	private String crsgtCdate;

	/**
	*修改日期
	*/
	private String crsgtUdate;

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

	public void setCrsgtCdate(String crsgtCdate) {
		this.crsgtCdate = crsgtCdate;
	}

	public String getCrsgtCdate( ) {
		return crsgtCdate;
	}

	public void setCrsgtUdate(String crsgtUdate) {
		this.crsgtUdate = crsgtUdate;
	}

	public String getCrsgtUdate( ) {
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

	public CoreSuggestVO( ) { 
	}

	@Override
	public void convertPOToVO(Object poObj) {
		if (null == poObj) {
			return;
		}

		CoreSuggest po = (CoreSuggest) poObj;
		this.crsgtUuid = po.getCrsgtUuid();
		this.crsgtTitle = po.getCrsgtTitle();
		this.crsgtPeople = po.getCrsgtPeople();
		this.crsgtCdate = po.getCrsgtCdate()!=null?DateUtil.formatDefaultDate(po.getCrsgtCdate()):"";
		this.crsgtUdate = po.getCrsgtUdate()!=null?DateUtil.formatDefaultDate(po.getCrsgtUdate()):"";
		this.crsgtStatus = po.getCrsgtStatus();
		this.crsgtOrd = po.getCrsgtOrd();
		this.crsgtContent = po.getCrsgtContent();
	}
//<=================定制内容开始==============
//==================定制内容结束==============>

}