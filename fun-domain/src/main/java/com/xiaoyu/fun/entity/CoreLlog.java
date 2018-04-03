package com.xiaoyu.fun.entity;

import com.xiaoyu.fun.entity.BaseEntity;
import java.util.Date;

public class CoreLlog extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	*标识UNID
	*/
	private Integer crlogUnid;

	/**
	*标识UUID
	*/
	private String crlogUuid;

	/**
	*登录用户UUID
	*/
	private String crlogCractUuid;

	/**
	*登录IP
	*/
	private String crlogIp;

	/**
	*浏览器类型
	*/
	private String crlogType;

	/**
	*登录时间
	*/
	private Date crlogLdate;

	/**
	*操作系统
	*/
	private String crlogOperating;

	/**
	*MAC地址
	*/
	private String crlogMacAddress;

	public void setCrlogUnid(Integer crlogUnid) {
		this.crlogUnid = crlogUnid;
	}

	public Integer getCrlogUnid( ) {
		return crlogUnid;
	}

	public void setCrlogUuid(String crlogUuid) {
		this.crlogUuid = crlogUuid;
	}

	public String getCrlogUuid( ) {
		return crlogUuid;
	}

	public void setCrlogCractUuid(String crlogCractUuid) {
		this.crlogCractUuid = crlogCractUuid;
	}

	public String getCrlogCractUuid( ) {
		return crlogCractUuid;
	}

	public void setCrlogIp(String crlogIp) {
		this.crlogIp = crlogIp;
	}

	public String getCrlogIp( ) {
		return crlogIp;
	}

	public void setCrlogType(String crlogType) {
		this.crlogType = crlogType;
	}

	public String getCrlogType( ) {
		return crlogType;
	}

	public void setCrlogLdate(Date crlogLdate) {
		this.crlogLdate = crlogLdate;
	}

	public Date getCrlogLdate( ) {
		return crlogLdate;
	}

	public void setCrlogOperating(String crlogOperating) {
		this.crlogOperating = crlogOperating;
	}

	public String getCrlogOperating( ) {
		return crlogOperating;
	}

	public void setCrlogMacAddress(String crlogMacAddress) {
		this.crlogMacAddress = crlogMacAddress;
	}

	public String getCrlogMacAddress( ) {
		return crlogMacAddress;
	}

	public CoreLlog( ) { 
	}

//<=================定制内容开始==============
//==================定制内容结束==============>

}