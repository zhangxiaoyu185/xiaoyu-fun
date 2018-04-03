package com.xiaoyu.fun.vo;

import com.xiaoyu.fun.entity.BusiPushinfo;
import com.xiaoyu.fun.util.BaseVO;
import com.xiaoyu.fun.util.DateUtil;

public class BusiPushinfoVO implements BaseVO {

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
	private String bspioCdate;

	/**
	*修改日期
	*/
	private String bspioUdate;

	/**
	*用户UUID
	*/
	private String bspioUser;

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

	public void setBspioCdate(String bspioCdate) {
		this.bspioCdate = bspioCdate;
	}

	public String getBspioCdate( ) {
		return bspioCdate;
	}

	public void setBspioUdate(String bspioUdate) {
		this.bspioUdate = bspioUdate;
	}

	public String getBspioUdate( ) {
		return bspioUdate;
	}

	public void setBspioUser(String bspioUser) {
		this.bspioUser = bspioUser;
	}

	public String getBspioUser( ) {
		return bspioUser;
	}

	public BusiPushinfoVO( ) { 
	}

	@Override
	public void convertPOToVO(Object poObj) {
		if (null == poObj) {
			return;
		}

		BusiPushinfo po = (BusiPushinfo) poObj;
		this.bspioUuid = po.getBspioUuid();
		this.bspioType = po.getBspioType();
		this.bspioSn = po.getBspioSn();
		this.bspioChannelId = po.getBspioChannelId();
		this.bspioUserId = po.getBspioUserId();
		this.bspioCdate = po.getBspioCdate()!=null?DateUtil.formatDefaultDate(po.getBspioCdate()):"";
		this.bspioUdate = po.getBspioUdate()!=null?DateUtil.formatDefaultDate(po.getBspioUdate()):"";
		this.bspioUser = po.getBspioUser();
	}
//<=================定制内容开始==============
//==================定制内容结束==============>

}