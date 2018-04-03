package com.xiaoyu.fun.entity;

import com.xiaoyu.fun.entity.BaseEntity;
import java.util.Date;

public class CoreDict extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	*标识UNID
	*/
	private Integer crdctUnid;

	/**
	*标识UUID
	*/
	private String crdctUuid;

	/**
	*名称
	*/
	private String crdctName;

	/**
	*代码值
	*/
	private String crdctValue;

	/**
	*层级编码
	*/
	private String crdctLevelCode;

	/**
	*创建者
	*/
	private String crdctCractUuid;

	/**
	*创建日期
	*/
	private Date crdctCdate;

	/**
	*修改日期
	*/
	private Date crdctUdate;

	/**
	*状态
	*/
	private Integer crdctStatus;

	/**
	*排序号
	*/
	private Integer crdctOrd;

	/**
	*备注
	*/
	private String crdctRemarks;

	public void setCrdctUnid(Integer crdctUnid) {
		this.crdctUnid = crdctUnid;
	}

	public Integer getCrdctUnid( ) {
		return crdctUnid;
	}

	public void setCrdctUuid(String crdctUuid) {
		this.crdctUuid = crdctUuid;
	}

	public String getCrdctUuid( ) {
		return crdctUuid;
	}

	public void setCrdctName(String crdctName) {
		this.crdctName = crdctName;
	}

	public String getCrdctName( ) {
		return crdctName;
	}

	public void setCrdctValue(String crdctValue) {
		this.crdctValue = crdctValue;
	}

	public String getCrdctValue( ) {
		return crdctValue;
	}

	public void setCrdctLevelCode(String crdctLevelCode) {
		this.crdctLevelCode = crdctLevelCode;
	}

	public String getCrdctLevelCode( ) {
		return crdctLevelCode;
	}

	public void setCrdctCractUuid(String crdctCractUuid) {
		this.crdctCractUuid = crdctCractUuid;
	}

	public String getCrdctCractUuid( ) {
		return crdctCractUuid;
	}

	public void setCrdctCdate(Date crdctCdate) {
		this.crdctCdate = crdctCdate;
	}

	public Date getCrdctCdate( ) {
		return crdctCdate;
	}

	public void setCrdctUdate(Date crdctUdate) {
		this.crdctUdate = crdctUdate;
	}

	public Date getCrdctUdate( ) {
		return crdctUdate;
	}

	public void setCrdctStatus(Integer crdctStatus) {
		this.crdctStatus = crdctStatus;
	}

	public Integer getCrdctStatus( ) {
		return crdctStatus;
	}

	public void setCrdctOrd(Integer crdctOrd) {
		this.crdctOrd = crdctOrd;
	}

	public Integer getCrdctOrd( ) {
		return crdctOrd;
	}

	public void setCrdctRemarks(String crdctRemarks) {
		this.crdctRemarks = crdctRemarks;
	}

	public String getCrdctRemarks( ) {
		return crdctRemarks;
	}

	public CoreDict( ) { 
	}

//<=================定制内容开始==============
//==================定制内容结束==============>

}