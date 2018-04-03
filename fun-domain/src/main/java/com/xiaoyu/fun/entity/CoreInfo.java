package com.xiaoyu.fun.entity;

import com.xiaoyu.fun.entity.BaseEntity;
import java.util.Date;

public class CoreInfo extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	*标识UNID
	*/
	private Integer crinfUnid;

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
	private Date crinfPdate;

	/**
	*创建日期
	*/
	private Date crinfCdate;

	/**
	*修改日期
	*/
	private Date crinfUdate;

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

	public void setCrinfUnid(Integer crinfUnid) {
		this.crinfUnid = crinfUnid;
	}

	public Integer getCrinfUnid( ) {
		return crinfUnid;
	}

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

	public void setCrinfPdate(Date crinfPdate) {
		this.crinfPdate = crinfPdate;
	}

	public Date getCrinfPdate( ) {
		return crinfPdate;
	}

	public void setCrinfCdate(Date crinfCdate) {
		this.crinfCdate = crinfCdate;
	}

	public Date getCrinfCdate( ) {
		return crinfCdate;
	}

	public void setCrinfUdate(Date crinfUdate) {
		this.crinfUdate = crinfUdate;
	}

	public Date getCrinfUdate( ) {
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

	public CoreInfo( ) { 
	}

//<=================定制内容开始==============
//==================定制内容结束==============>

}