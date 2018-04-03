package com.xiaoyu.fun.entity;

import com.xiaoyu.fun.entity.BaseEntity;
import java.util.Date;

public class CoreLink extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	*标识UNID
	*/
	private Integer crlinUnid;

	/**
	*标识UUID
	*/
	private String crlinUuid;

	/**
	*名称
	*/
	private String crlinName;

	/**
	*链接URL
	*/
	private String crlinUrl;

	/**
	*类型:1.站内链接2.站外链接
	*/
	private Integer crlinType;

	/**
	*创建日期
	*/
	private Date crlinCdate;

	/**
	*修改日期
	*/
	private Date crlinUdate;

	/**
	*状态
	*/
	private Integer crlinStatus;

	/**
	*排序号
	*/
	private Integer crlinOrd;

	/**
	*发布者
	*/
	private String crlinAuthor;

	public void setCrlinUnid(Integer crlinUnid) {
		this.crlinUnid = crlinUnid;
	}

	public Integer getCrlinUnid( ) {
		return crlinUnid;
	}

	public void setCrlinUuid(String crlinUuid) {
		this.crlinUuid = crlinUuid;
	}

	public String getCrlinUuid( ) {
		return crlinUuid;
	}

	public void setCrlinName(String crlinName) {
		this.crlinName = crlinName;
	}

	public String getCrlinName( ) {
		return crlinName;
	}

	public void setCrlinUrl(String crlinUrl) {
		this.crlinUrl = crlinUrl;
	}

	public String getCrlinUrl( ) {
		return crlinUrl;
	}

	public void setCrlinType(Integer crlinType) {
		this.crlinType = crlinType;
	}

	public Integer getCrlinType( ) {
		return crlinType;
	}

	public void setCrlinCdate(Date crlinCdate) {
		this.crlinCdate = crlinCdate;
	}

	public Date getCrlinCdate( ) {
		return crlinCdate;
	}

	public void setCrlinUdate(Date crlinUdate) {
		this.crlinUdate = crlinUdate;
	}

	public Date getCrlinUdate( ) {
		return crlinUdate;
	}

	public void setCrlinStatus(Integer crlinStatus) {
		this.crlinStatus = crlinStatus;
	}

	public Integer getCrlinStatus( ) {
		return crlinStatus;
	}

	public void setCrlinOrd(Integer crlinOrd) {
		this.crlinOrd = crlinOrd;
	}

	public Integer getCrlinOrd( ) {
		return crlinOrd;
	}

	public void setCrlinAuthor(String crlinAuthor) {
		this.crlinAuthor = crlinAuthor;
	}

	public String getCrlinAuthor( ) {
		return crlinAuthor;
	}

	public CoreLink( ) { 
	}

//<=================定制内容开始==============
//==================定制内容结束==============>

}