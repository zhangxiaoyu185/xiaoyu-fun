package com.xiaoyu.fun.vo;

import com.xiaoyu.fun.entity.CoreInfo;
import com.xiaoyu.fun.util.BaseVO;
import com.xiaoyu.fun.util.DateUtil;

public class CoreInfoVO implements BaseVO {

	/**
	*标识UUID
	*/
	private String crinfUuid;

	/**
	*标题
	*/
	private String crinfTitle;

	/**
	*内容
	*/
	private String crinfContent;

	/**
	*类型:1.新闻资讯2.公告公示3.站内通知4.资源文件
	*/
	private Integer crinfType;

	/**
	*发布时间
	*/
	private String crinfPdate;

	/**
	*创建日期
	*/
	private String crinfCdate;

	/**
	*修改日期
	*/
	private String crinfUdate;

	/**
	*状态
	*/
	private Integer crinfStatus;

	/**
	*排序号
	*/
	private Integer crinfOrd;

	/**
	*发布者
	*/
	private String crinfAuthor;

	public void setCrinfUuid(String crinfUuid) {
		this.crinfUuid = crinfUuid;
	}

	public String getCrinfUuid( ) {
		return crinfUuid;
	}

	public void setCrinfTitle(String crinfTitle) {
		this.crinfTitle = crinfTitle;
	}

	public String getCrinfTitle( ) {
		return crinfTitle;
	}

	public void setCrinfContent(String crinfContent) {
		this.crinfContent = crinfContent;
	}

	public String getCrinfContent( ) {
		return crinfContent;
	}

	public void setCrinfType(Integer crinfType) {
		this.crinfType = crinfType;
	}

	public Integer getCrinfType( ) {
		return crinfType;
	}

	public void setCrinfPdate(String crinfPdate) {
		this.crinfPdate = crinfPdate;
	}

	public String getCrinfPdate( ) {
		return crinfPdate;
	}

	public void setCrinfCdate(String crinfCdate) {
		this.crinfCdate = crinfCdate;
	}

	public String getCrinfCdate( ) {
		return crinfCdate;
	}

	public void setCrinfUdate(String crinfUdate) {
		this.crinfUdate = crinfUdate;
	}

	public String getCrinfUdate( ) {
		return crinfUdate;
	}

	public void setCrinfStatus(Integer crinfStatus) {
		this.crinfStatus = crinfStatus;
	}

	public Integer getCrinfStatus( ) {
		return crinfStatus;
	}

	public void setCrinfOrd(Integer crinfOrd) {
		this.crinfOrd = crinfOrd;
	}

	public Integer getCrinfOrd( ) {
		return crinfOrd;
	}

	public void setCrinfAuthor(String crinfAuthor) {
		this.crinfAuthor = crinfAuthor;
	}

	public String getCrinfAuthor( ) {
		return crinfAuthor;
	}

	public CoreInfoVO( ) { 
	}

	@Override
	public void convertPOToVO(Object poObj) {
		if (null == poObj) {
			return;
		}

		CoreInfo po = (CoreInfo) poObj;
		this.crinfUuid = po.getCrinfUuid();
		this.crinfTitle = po.getCrinfTitle();
		this.crinfContent = po.getCrinfContent();
		this.crinfType = po.getCrinfType();
		this.crinfPdate = po.getCrinfPdate()!=null?DateUtil.formatDefaultDate(po.getCrinfPdate()):"";
		this.crinfCdate = po.getCrinfCdate()!=null?DateUtil.formatDefaultDate(po.getCrinfCdate()):"";
		this.crinfUdate = po.getCrinfUdate()!=null?DateUtil.formatDefaultDate(po.getCrinfUdate()):"";
		this.crinfStatus = po.getCrinfStatus();
		this.crinfOrd = po.getCrinfOrd();
		this.crinfAuthor = po.getCrinfAuthor();
	}
//<=================定制内容开始==============
//==================定制内容结束==============>

}