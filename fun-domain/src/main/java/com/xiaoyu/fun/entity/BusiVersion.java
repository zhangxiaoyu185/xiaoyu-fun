package com.xiaoyu.fun.entity;

import com.xiaoyu.fun.entity.BaseEntity;

public class BusiVersion extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	*标识UNID
	*/
	private Integer bsvsnUnid;

	/**
	*标识UUID
	*/
	private String bsvsnUuid;

	/**
	*版本号
	*/
	private String bsvsnNo;

	/**
	*版本路径
	*/
	private String bsvsnUrl;

	/**
	*设备类型：1Android,2:IOS
	*/
	private Integer bsvsnType;

	/**
	*是否强制更新：1是，0否
	*/
	private Integer bsvsnMust;

	/**
	*更新内容
	*/
	private String bsvsnContent;

	public void setBsvsnUnid(Integer bsvsnUnid) {
		this.bsvsnUnid = bsvsnUnid;
	}

	public Integer getBsvsnUnid( ) {
		return bsvsnUnid;
	}

	public void setBsvsnUuid(String bsvsnUuid) {
		this.bsvsnUuid = bsvsnUuid;
	}

	public String getBsvsnUuid( ) {
		return bsvsnUuid;
	}

	public void setBsvsnNo(String bsvsnNo) {
		this.bsvsnNo = bsvsnNo;
	}

	public String getBsvsnNo( ) {
		return bsvsnNo;
	}

	public void setBsvsnUrl(String bsvsnUrl) {
		this.bsvsnUrl = bsvsnUrl;
	}

	public String getBsvsnUrl( ) {
		return bsvsnUrl;
	}

	public void setBsvsnType(Integer bsvsnType) {
		this.bsvsnType = bsvsnType;
	}

	public Integer getBsvsnType( ) {
		return bsvsnType;
	}

	public void setBsvsnMust(Integer bsvsnMust) {
		this.bsvsnMust = bsvsnMust;
	}

	public Integer getBsvsnMust( ) {
		return bsvsnMust;
	}

	public void setBsvsnContent(String bsvsnContent) {
		this.bsvsnContent = bsvsnContent;
	}

	public String getBsvsnContent( ) {
		return bsvsnContent;
	}

	public BusiVersion( ) { 
	}

//<=================定制内容开始==============
//==================定制内容结束==============>

}