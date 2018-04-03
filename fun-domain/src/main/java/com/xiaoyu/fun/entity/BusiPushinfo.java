package com.xiaoyu.fun.entity;

import com.xiaoyu.fun.entity.BaseEntity;
import java.util.Date;

public class BusiPushinfo extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	*标识UNID
	*/
	private Integer bspioUnid;

	/**
	*标识UUID
	*/
	private String bspioUuid;

	/**
	*设备类型：1Android,2:IOS
	*/
	private Integer bspioType;

	/**
	*序列号
	*/
	private String bspioSn;

	/**
	*百度CHANNELID
	*/
	private String bspioChannelId;

	/**
	*百度USERID
	*/
	private String bspioUserId;

	/**
	*创建日期
	*/
	private Date bspioCdate;

	/**
	*修改日期
	*/
	private Date bspioUdate;

	/**
	*用户UUID
	*/
	private String bspioUser;

	public void setBspioUnid(Integer bspioUnid) {
		this.bspioUnid = bspioUnid;
	}

	public Integer getBspioUnid( ) {
		return bspioUnid;
	}

	public void setBspioUuid(String bspioUuid) {
		this.bspioUuid = bspioUuid;
	}

	public String getBspioUuid( ) {
		return bspioUuid;
	}

	public void setBspioType(Integer bspioType) {
		this.bspioType = bspioType;
	}

	public Integer getBspioType( ) {
		return bspioType;
	}

	public void setBspioSn(String bspioSn) {
		this.bspioSn = bspioSn;
	}

	public String getBspioSn( ) {
		return bspioSn;
	}

	public void setBspioChannelId(String bspioChannelId) {
		this.bspioChannelId = bspioChannelId;
	}

	public String getBspioChannelId( ) {
		return bspioChannelId;
	}

	public void setBspioUserId(String bspioUserId) {
		this.bspioUserId = bspioUserId;
	}

	public String getBspioUserId( ) {
		return bspioUserId;
	}

	public void setBspioCdate(Date bspioCdate) {
		this.bspioCdate = bspioCdate;
	}

	public Date getBspioCdate( ) {
		return bspioCdate;
	}

	public void setBspioUdate(Date bspioUdate) {
		this.bspioUdate = bspioUdate;
	}

	public Date getBspioUdate( ) {
		return bspioUdate;
	}

	public void setBspioUser(String bspioUser) {
		this.bspioUser = bspioUser;
	}

	public String getBspioUser( ) {
		return bspioUser;
	}

	public BusiPushinfo( ) { 
	}

//<=================定制内容开始==============
//==================定制内容结束==============>

}