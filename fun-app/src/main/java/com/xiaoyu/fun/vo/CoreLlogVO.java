package com.xiaoyu.fun.vo;

import com.xiaoyu.fun.entity.CoreLlog;
import com.xiaoyu.fun.util.BaseVO;
import com.xiaoyu.fun.util.DateUtil;

public class CoreLlogVO implements BaseVO {

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
	private String crlogLdate;

	/**
	*操作系统
	*/
	private String crlogOperating;

	/**
	*MAC地址
	*/
	private String crlogMacAddress;

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

	public void setCrlogLdate(String crlogLdate) {
		this.crlogLdate = crlogLdate;
	}

	public String getCrlogLdate( ) {
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

	public CoreLlogVO( ) { 
	}

	@Override
	public void convertPOToVO(Object poObj) {
		if (null == poObj) {
			return;
		}

		CoreLlog po = (CoreLlog) poObj;
		this.crlogUuid = po.getCrlogUuid();
		this.crlogCractUuid = po.getCrlogCractUuid();
		this.crlogIp = po.getCrlogIp();
		this.crlogType = po.getCrlogType();
		this.crlogLdate = po.getCrlogLdate()!=null?DateUtil.formatDefaultDate(po.getCrlogLdate()):"";
		this.crlogOperating = po.getCrlogOperating();
		this.crlogMacAddress = po.getCrlogMacAddress();
	}
//<=================定制内容开始==============
//==================定制内容结束==============>

}