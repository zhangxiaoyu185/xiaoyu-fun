package com.xiaoyu.fun.vo;

import com.xiaoyu.fun.entity.BusiReport;
import com.xiaoyu.fun.util.BaseVO;
import com.xiaoyu.fun.util.DateUtil;

public class BusiReportVO implements BaseVO {

	/**
	*标识UUID
	*/
	private String bsretUuid;

	/**
	*被举报趣事UUID
	*/
	private String bsretFun;

	/**
	*创建日期
	*/
	private String bsretCdate;

	/**
	*修改日期
	*/
	private String bsretUdate;

	/**
	*处理结果（1.未处理，2.已处理）
	*/
	private Integer bsretStatus;

	/**
	*排序号
	*/
	private Integer bsretOrd;

	/**
	*举报人UUID
	*/
	private String bsretUser;

	public void setBsretUuid(String bsretUuid) {
		this.bsretUuid = bsretUuid;
	}

	public String getBsretUuid( ) {
		return bsretUuid;
	}

	public void setBsretFun(String bsretFun) {
		this.bsretFun = bsretFun;
	}

	public String getBsretFun( ) {
		return bsretFun;
	}

	public void setBsretCdate(String bsretCdate) {
		this.bsretCdate = bsretCdate;
	}

	public String getBsretCdate( ) {
		return bsretCdate;
	}

	public void setBsretUdate(String bsretUdate) {
		this.bsretUdate = bsretUdate;
	}

	public String getBsretUdate( ) {
		return bsretUdate;
	}

	public void setBsretStatus(Integer bsretStatus) {
		this.bsretStatus = bsretStatus;
	}

	public Integer getBsretStatus( ) {
		return bsretStatus;
	}

	public void setBsretOrd(Integer bsretOrd) {
		this.bsretOrd = bsretOrd;
	}

	public Integer getBsretOrd( ) {
		return bsretOrd;
	}

	public void setBsretUser(String bsretUser) {
		this.bsretUser = bsretUser;
	}

	public String getBsretUser( ) {
		return bsretUser;
	}

	public BusiReportVO( ) { 
	}

	@Override
	public void convertPOToVO(Object poObj) {
		if (null == poObj) {
			return;
		}

		BusiReport po = (BusiReport) poObj;
		this.bsretUuid = po.getBsretUuid();
		this.bsretFun = po.getBsretFun();
		this.bsretCdate = po.getBsretCdate()!=null?DateUtil.formatDefaultDate(po.getBsretCdate()):"";
		this.bsretUdate = po.getBsretUdate()!=null?DateUtil.formatDefaultDate(po.getBsretUdate()):"";
		this.bsretStatus = po.getBsretStatus();
		this.bsretOrd = po.getBsretOrd();
		this.bsretUser = po.getBsretUser();
	}
//<=================定制内容开始==============
//==================定制内容结束==============>

}