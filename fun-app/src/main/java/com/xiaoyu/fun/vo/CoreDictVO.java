package com.xiaoyu.fun.vo;

import com.xiaoyu.fun.entity.CoreDict;
import com.xiaoyu.fun.util.BaseVO;
import com.xiaoyu.fun.util.DateUtil;

public class CoreDictVO implements BaseVO {

	/**
	*标识UUID
	*/
	private String crdctUuid;

	/**
	*名称
	*/
	private String crdctName;

	/**
	*代码值
	*/
	private String crdctValue;

	/**
	*层级编码
	*/
	private String crdctLevelCode;

	/**
	*创建者
	*/
	private String crdctCractUuid;

	/**
	*创建日期
	*/
	private String crdctCdate;

	/**
	*修改日期
	*/
	private String crdctUdate;

	/**
	*状态
	*/
	private Integer crdctStatus;

	/**
	*排序号
	*/
	private Integer crdctOrd;

	/**
	*备注
	*/
	private String crdctRemarks;

	public void setCrdctUuid(String crdctUuid) {
		this.crdctUuid = crdctUuid;
	}

	public String getCrdctUuid( ) {
		return crdctUuid;
	}

	public void setCrdctName(String crdctName) {
		this.crdctName = crdctName;
	}

	public String getCrdctName( ) {
		return crdctName;
	}

	public void setCrdctValue(String crdctValue) {
		this.crdctValue = crdctValue;
	}

	public String getCrdctValue( ) {
		return crdctValue;
	}

	public void setCrdctLevelCode(String crdctLevelCode) {
		this.crdctLevelCode = crdctLevelCode;
	}

	public String getCrdctLevelCode( ) {
		return crdctLevelCode;
	}

	public void setCrdctCractUuid(String crdctCractUuid) {
		this.crdctCractUuid = crdctCractUuid;
	}

	public String getCrdctCractUuid( ) {
		return crdctCractUuid;
	}

	public void setCrdctCdate(String crdctCdate) {
		this.crdctCdate = crdctCdate;
	}

	public String getCrdctCdate( ) {
		return crdctCdate;
	}

	public void setCrdctUdate(String crdctUdate) {
		this.crdctUdate = crdctUdate;
	}

	public String getCrdctUdate( ) {
		return crdctUdate;
	}

	public void setCrdctStatus(Integer crdctStatus) {
		this.crdctStatus = crdctStatus;
	}

	public Integer getCrdctStatus( ) {
		return crdctStatus;
	}

	public void setCrdctOrd(Integer crdctOrd) {
		this.crdctOrd = crdctOrd;
	}

	public Integer getCrdctOrd( ) {
		return crdctOrd;
	}

	public void setCrdctRemarks(String crdctRemarks) {
		this.crdctRemarks = crdctRemarks;
	}

	public String getCrdctRemarks( ) {
		return crdctRemarks;
	}

	public CoreDictVO( ) { 
	}

	@Override
	public void convertPOToVO(Object poObj) {
		if (null == poObj) {
			return;
		}

		CoreDict po = (CoreDict) poObj;
		this.crdctUuid = po.getCrdctUuid();
		this.crdctName = po.getCrdctName();
		this.crdctValue = po.getCrdctValue();
		this.crdctLevelCode = po.getCrdctLevelCode();
		this.crdctCractUuid = po.getCrdctCractUuid();
		this.crdctCdate = po.getCrdctCdate()!=null?DateUtil.formatDefaultDate(po.getCrdctCdate()):"";
		this.crdctUdate = po.getCrdctUdate()!=null?DateUtil.formatDefaultDate(po.getCrdctUdate()):"";
		this.crdctStatus = po.getCrdctStatus();
		this.crdctOrd = po.getCrdctOrd();
		this.crdctRemarks = po.getCrdctRemarks();
	}
//<=================定制内容开始==============
//==================定制内容结束==============>

}