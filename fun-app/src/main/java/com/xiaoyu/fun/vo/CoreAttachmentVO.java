package com.xiaoyu.fun.vo;

import com.xiaoyu.fun.entity.CoreAttachment;
import com.xiaoyu.fun.util.BaseVO;
import com.xiaoyu.fun.util.DateUtil;

public class CoreAttachmentVO implements BaseVO {

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
	private String cratmCdate;

	/**
	*状态
	*/
	private Integer cratmStatus;

	/**
	*附件大小
	*/
	private String cratmSize;

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

	public void setCratmCdate(String cratmCdate) {
		this.cratmCdate = cratmCdate;
	}

	public String getCratmCdate( ) {
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

	public CoreAttachmentVO( ) { 
	}

	@Override
	public void convertPOToVO(Object poObj) {
		if (null == poObj) {
			return;
		}

		CoreAttachment  po = (CoreAttachment) poObj;
		this.cratmUuid = po.getCratmUuid();
		this.cratmCractUuid = po.getCratmCractUuid();
		this.cratmBusUuid = po.getCratmBusUuid();
		this.cratmFileName = po.getCratmFileName();
		this.cratmServerPath = po.getCratmServerPath();
		this.cratmExtension = po.getCratmExtension();
		this.cratmCdate = po.getCratmCdate()!=null?DateUtil.formatDefaultDate(po.getCratmCdate()):"";
		this.cratmStatus = po.getCratmStatus();
		this.cratmSize = po.getCratmSize();
	}
//<=================定制内容开始==============
//==================定制内容结束==============>

}