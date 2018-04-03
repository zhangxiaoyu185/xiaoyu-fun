package com.xiaoyu.fun.entity;

import com.xiaoyu.fun.entity.BaseEntity;
import java.util.Date;

public class CoreAttachment extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	*标识UNID
	*/
	private Integer cratmUnid;

	/**
	*标识UUID
	*/
	private String cratmUuid;

	/**
	*操作用户UUID
	*/
	private String cratmCractUuid;

	/**
	*业务实体UUID
	*/
	private String cratmBusUuid;

	/**
	*名称
	*/
	private String cratmFileName;

	/**
	*服务器路径
	*/
	private String cratmServerPath;

	/**
	*文件扩展名
	*/
	private String cratmExtension;

	/**
	*创建日期
	*/
	private Date cratmCdate;

	/**
	*状态
	*/
	private Integer cratmStatus;

	/**
	*附件大小
	*/
	private String cratmSize;

	public void setCratmUnid(Integer cratmUnid) {
		this.cratmUnid = cratmUnid;
	}

	public Integer getCratmUnid( ) {
		return cratmUnid;
	}

	public void setCratmUuid(String cratmUuid) {
		this.cratmUuid = cratmUuid;
	}

	public String getCratmUuid( ) {
		return cratmUuid;
	}

	public void setCratmCractUuid(String cratmCractUuid) {
		this.cratmCractUuid = cratmCractUuid;
	}

	public String getCratmCractUuid( ) {
		return cratmCractUuid;
	}

	public void setCratmBusUuid(String cratmBusUuid) {
		this.cratmBusUuid = cratmBusUuid;
	}

	public String getCratmBusUuid( ) {
		return cratmBusUuid;
	}

	public void setCratmFileName(String cratmFileName) {
		this.cratmFileName = cratmFileName;
	}

	public String getCratmFileName( ) {
		return cratmFileName;
	}

	public void setCratmServerPath(String cratmServerPath) {
		this.cratmServerPath = cratmServerPath;
	}

	public String getCratmServerPath( ) {
		return cratmServerPath;
	}

	public void setCratmExtension(String cratmExtension) {
		this.cratmExtension = cratmExtension;
	}

	public String getCratmExtension( ) {
		return cratmExtension;
	}

	public void setCratmCdate(Date cratmCdate) {
		this.cratmCdate = cratmCdate;
	}

	public Date getCratmCdate( ) {
		return cratmCdate;
	}

	public void setCratmStatus(Integer cratmStatus) {
		this.cratmStatus = cratmStatus;
	}

	public Integer getCratmStatus( ) {
		return cratmStatus;
	}

	public void setCratmSize(String cratmSize) {
		this.cratmSize = cratmSize;
	}

	public String getCratmSize( ) {
		return cratmSize;
	}

	public CoreAttachment( ) { 
	}

//<=================定制内容开始==============
//==================定制内容结束==============>

}