package com.xiaoyu.fun.vo;

import com.xiaoyu.fun.entity.CoreFunction;
import com.xiaoyu.fun.util.BaseVO;
import com.xiaoyu.fun.util.DateUtil;

public class CoreFunctionVO implements BaseVO {

	/**
	*标识UUID
	*/
	private String crfntUuid;

	/**
	*层级编码
	*/
	private String crfntLevelCode;

	/**
	*功能项名称
	*/
	private String crfntFunName;

	/**
	*资源请求地址
	*/
	private String crfntResource;

	/**
	*类型:1后台,0前台
	*/
	private Integer crfntType;

	/**
	*状态
	*/
	private Integer crfntStatus;

	/**
	*创建日期
	*/
	private String crfntCdate;

	/**
	*修改日期
	*/
	private String crfntUdate;

	/**
	*排序号
	*/
	private Integer crfntOrd;

	/**
	*创建者
	*/
	private String crfntCractUuid;

	public void setCrfntUuid(String crfntUuid) {
		this.crfntUuid = crfntUuid;
	}

	public String getCrfntUuid( ) {
		return crfntUuid;
	}

	public void setCrfntLevelCode(String crfntLevelCode) {
		this.crfntLevelCode = crfntLevelCode;
	}

	public String getCrfntLevelCode( ) {
		return crfntLevelCode;
	}

	public void setCrfntFunName(String crfntFunName) {
		this.crfntFunName = crfntFunName;
	}

	public String getCrfntFunName( ) {
		return crfntFunName;
	}

	public void setCrfntResource(String crfntResource) {
		this.crfntResource = crfntResource;
	}

	public String getCrfntResource( ) {
		return crfntResource;
	}

	public void setCrfntType(Integer crfntType) {
		this.crfntType = crfntType;
	}

	public Integer getCrfntType( ) {
		return crfntType;
	}

	public void setCrfntStatus(Integer crfntStatus) {
		this.crfntStatus = crfntStatus;
	}

	public Integer getCrfntStatus( ) {
		return crfntStatus;
	}

	public void setCrfntCdate(String crfntCdate) {
		this.crfntCdate = crfntCdate;
	}

	public String getCrfntCdate( ) {
		return crfntCdate;
	}

	public void setCrfntUdate(String crfntUdate) {
		this.crfntUdate = crfntUdate;
	}

	public String getCrfntUdate( ) {
		return crfntUdate;
	}

	public void setCrfntOrd(Integer crfntOrd) {
		this.crfntOrd = crfntOrd;
	}

	public Integer getCrfntOrd( ) {
		return crfntOrd;
	}

	public void setCrfntCractUuid(String crfntCractUuid) {
		this.crfntCractUuid = crfntCractUuid;
	}

	public String getCrfntCractUuid( ) {
		return crfntCractUuid;
	}

	public CoreFunctionVO( ) { 
	}

	@Override
	public void convertPOToVO(Object poObj) {
		if (null == poObj) {
			return;
		}

		CoreFunction po = (CoreFunction) poObj;
		this.crfntUuid = po.getCrfntUuid();
		this.crfntLevelCode = po.getCrfntLevelCode();
		this.crfntFunName = po.getCrfntFunName();
		this.crfntResource = po.getCrfntResource();
		this.crfntType = po.getCrfntType();
		this.crfntStatus = po.getCrfntStatus();
		this.crfntCdate = po.getCrfntCdate()!=null?DateUtil.formatDefaultDate(po.getCrfntCdate()):"";
		this.crfntUdate = po.getCrfntUdate()!=null?DateUtil.formatDefaultDate(po.getCrfntUdate()):"";
		this.crfntOrd = po.getCrfntOrd();
		this.crfntCractUuid = po.getCrfntCractUuid();
	}
//<=================定制内容开始==============
//==================定制内容结束==============>

}