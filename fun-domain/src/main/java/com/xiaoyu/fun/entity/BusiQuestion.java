package com.xiaoyu.fun.entity;

import com.xiaoyu.fun.entity.BaseEntity;

public class BusiQuestion extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	*标识UNID
	*/
	private Integer bsqsnUnid;

	/**
	*标识UUID
	*/
	private String bsqsnUuid;

	/**
	*密保问题
	*/
	private String bsqsnContent;

	public void setBsqsnUnid(Integer bsqsnUnid) {
		this.bsqsnUnid = bsqsnUnid;
	}

	public Integer getBsqsnUnid( ) {
		return bsqsnUnid;
	}

	public void setBsqsnUuid(String bsqsnUuid) {
		this.bsqsnUuid = bsqsnUuid;
	}

	public String getBsqsnUuid( ) {
		return bsqsnUuid;
	}

	public void setBsqsnContent(String bsqsnContent) {
		this.bsqsnContent = bsqsnContent;
	}

	public String getBsqsnContent( ) {
		return bsqsnContent;
	}

	public BusiQuestion( ) { 
	}

//<=================定制内容开始==============
//==================定制内容结束==============>

}