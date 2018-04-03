package com.xiaoyu.fun.entity;

import com.xiaoyu.fun.entity.BaseEntity;
import java.util.Date;

public class CoreRole extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	*标识UNID
	*/
	private Integer crrolUnid;

	/**
	*标识UUID
	*/
	private String crrolUuid;

	/**
	*创建者
	*/
	private String crrolCractUuid;

	/**
	*角色名称
	*/
	private String crrolName;

	/**
	*状态
	*/
	private Integer crrolStatus;

	/**
	*创建日期
	*/
	private Date crrolCdate;

	/**
	*修改日期
	*/
	private Date crrolUdate;

	/**
	*排序号
	*/
	private Integer crrolOrd;

	/**
	*功能菜单
	*/
	private String crrolFun;

	/**
	*角色描述
	*/
	private String crrolDesc;

	public void setCrrolUnid(Integer crrolUnid) {
		this.crrolUnid = crrolUnid;
	}

	public Integer getCrrolUnid( ) {
		return crrolUnid;
	}

	public void setCrrolUuid(String crrolUuid) {
		this.crrolUuid = crrolUuid;
	}

	public String getCrrolUuid( ) {
		return crrolUuid;
	}

	public void setCrrolCractUuid(String crrolCractUuid) {
		this.crrolCractUuid = crrolCractUuid;
	}

	public String getCrrolCractUuid( ) {
		return crrolCractUuid;
	}

	public void setCrrolName(String crrolName) {
		this.crrolName = crrolName;
	}

	public String getCrrolName( ) {
		return crrolName;
	}

	public void setCrrolStatus(Integer crrolStatus) {
		this.crrolStatus = crrolStatus;
	}

	public Integer getCrrolStatus( ) {
		return crrolStatus;
	}

	public void setCrrolCdate(Date crrolCdate) {
		this.crrolCdate = crrolCdate;
	}

	public Date getCrrolCdate( ) {
		return crrolCdate;
	}

	public void setCrrolUdate(Date crrolUdate) {
		this.crrolUdate = crrolUdate;
	}

	public Date getCrrolUdate( ) {
		return crrolUdate;
	}

	public void setCrrolOrd(Integer crrolOrd) {
		this.crrolOrd = crrolOrd;
	}

	public Integer getCrrolOrd( ) {
		return crrolOrd;
	}

	public void setCrrolFun(String crrolFun) {
		this.crrolFun = crrolFun;
	}

	public String getCrrolFun( ) {
		return crrolFun;
	}

	public void setCrrolDesc(String crrolDesc) {
		this.crrolDesc = crrolDesc;
	}

	public String getCrrolDesc( ) {
		return crrolDesc;
	}

	public CoreRole( ) { 
	}

//<=================定制内容开始==============
//==================定制内容结束==============>

}