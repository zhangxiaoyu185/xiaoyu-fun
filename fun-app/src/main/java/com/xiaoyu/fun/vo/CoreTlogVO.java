package com.xiaoyu.fun.vo;

import com.xiaoyu.fun.entity.CoreTlog;
import com.xiaoyu.fun.util.BaseVO;
import com.xiaoyu.fun.util.DateUtil;

public class CoreTlogVO implements BaseVO {

	/**
	*标识UUID
	*/
	private String crtogUuid;

	/**
	*操作用户UUID
	*/
	private String crtogCractUuid;

	/**
	*操作类型
	*/
	private String crtogType;

	/**
	*操作说明
	*/
	private String crtogDesc;

	/**
	*操作日期
	*/
	private String crtogOdate;

	/**
	*操作IP地址
	*/
	private String crtogIp;

	/**
	*MAC地址
	*/
	private String crtogMacAddress;

	public void setCrtogUuid(String crtogUuid) {
		this.crtogUuid = crtogUuid;
	}

	public String getCrtogUuid( ) {
		return crtogUuid;
	}

	public void setCrtogCractUuid(String crtogCractUuid) {
		this.crtogCractUuid = crtogCractUuid;
	}

	public String getCrtogCractUuid( ) {
		return crtogCractUuid;
	}

	public void setCrtogType(String crtogType) {
		this.crtogType = crtogType;
	}

	public String getCrtogType( ) {
		return crtogType;
	}

	public void setCrtogDesc(String crtogDesc) {
		this.crtogDesc = crtogDesc;
	}

	public String getCrtogDesc( ) {
		return crtogDesc;
	}

	public void setCrtogOdate(String crtogOdate) {
		this.crtogOdate = crtogOdate;
	}

	public String getCrtogOdate( ) {
		return crtogOdate;
	}

	public void setCrtogIp(String crtogIp) {
		this.crtogIp = crtogIp;
	}

	public String getCrtogIp( ) {
		return crtogIp;
	}

	public void setCrtogMacAddress(String crtogMacAddress) {
		this.crtogMacAddress = crtogMacAddress;
	}

	public String getCrtogMacAddress( ) {
		return crtogMacAddress;
	}

	public CoreTlogVO( ) { 
	}

	@Override
	public void convertPOToVO(Object poObj) {
		if (null == poObj) {
			return;
		}

		CoreTlog po = (CoreTlog) poObj;
		this.crtogUuid = po.getCrtogUuid();
		this.crtogCractUuid = po.getCrtogCractUuid();
		this.crtogType = po.getCrtogType();
		this.crtogDesc = po.getCrtogDesc();
		this.crtogOdate = po.getCrtogOdate()!=null?DateUtil.formatDefaultDate(po.getCrtogOdate()):"";
		this.crtogIp = po.getCrtogIp();
		this.crtogMacAddress = po.getCrtogMacAddress();
	}
//<=================定制内容开始==============
//==================定制内容结束==============>

}