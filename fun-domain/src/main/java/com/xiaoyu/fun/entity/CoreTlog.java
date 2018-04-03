package com.xiaoyu.fun.entity;

import com.xiaoyu.fun.entity.BaseEntity;
import java.util.Date;

public class CoreTlog extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	*标识UNID
	*/
	private Integer crtogUnid;

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
	private Date crtogOdate;

	/**
	*操作IP地址
	*/
	private String crtogIp;

	/**
	*MAC地址
	*/
	private String crtogMacAddress;

	public void setCrtogUnid(Integer crtogUnid) {
		this.crtogUnid = crtogUnid;
	}

	public Integer getCrtogUnid( ) {
		return crtogUnid;
	}

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

	public void setCrtogOdate(Date crtogOdate) {
		this.crtogOdate = crtogOdate;
	}

	public Date getCrtogOdate( ) {
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

	public CoreTlog( ) { 
	}

//<=================定制内容开始==============
//==================定制内容结束==============>

}