package com.xiaoyu.fun.vo;

import com.xiaoyu.fun.entity.CoreLink;
import com.xiaoyu.fun.util.BaseVO;
import com.xiaoyu.fun.util.DateUtil;

public class CoreLinkVO implements BaseVO {

	/**
	*标识UUID
	*/
	private String crlinUuid;

	/**
	*名称
	*/
	private String crlinName;

	/**
	*链接URL
	*/
	private String crlinUrl;

	/**
	*类型:1.站内链接2.站外链接
	*/
	private Integer crlinType;

	/**
	*创建日期
	*/
	private String crlinCdate;

	/**
	*修改日期
	*/
	private String crlinUdate;

	/**
	*状态
	*/
	private Integer crlinStatus;

	/**
	*排序号
	*/
	private Integer crlinOrd;

	/**
	*发布者
	*/
	private String crlinAuthor;

	public void setCrlinUuid(String crlinUuid) {
		this.crlinUuid = crlinUuid;
	}

	public String getCrlinUuid( ) {
		return crlinUuid;
	}

	public void setCrlinName(String crlinName) {
		this.crlinName = crlinName;
	}

	public String getCrlinName( ) {
		return crlinName;
	}

	public void setCrlinUrl(String crlinUrl) {
		this.crlinUrl = crlinUrl;
	}

	public String getCrlinUrl( ) {
		return crlinUrl;
	}

	public void setCrlinType(Integer crlinType) {
		this.crlinType = crlinType;
	}

	public Integer getCrlinType( ) {
		return crlinType;
	}

	public void setCrlinCdate(String crlinCdate) {
		this.crlinCdate = crlinCdate;
	}

	public String getCrlinCdate( ) {
		return crlinCdate;
	}

	public void setCrlinUdate(String crlinUdate) {
		this.crlinUdate = crlinUdate;
	}

	public String getCrlinUdate( ) {
		return crlinUdate;
	}

	public void setCrlinStatus(Integer crlinStatus) {
		this.crlinStatus = crlinStatus;
	}

	public Integer getCrlinStatus( ) {
		return crlinStatus;
	}

	public void setCrlinOrd(Integer crlinOrd) {
		this.crlinOrd = crlinOrd;
	}

	public Integer getCrlinOrd( ) {
		return crlinOrd;
	}

	public void setCrlinAuthor(String crlinAuthor) {
		this.crlinAuthor = crlinAuthor;
	}

	public String getCrlinAuthor( ) {
		return crlinAuthor;
	}

	public CoreLinkVO( ) { 
	}

	@Override
	public void convertPOToVO(Object poObj) {
		if (null == poObj) {
			return;
		}

		CoreLink po = (CoreLink) poObj;
		this.crlinUuid = po.getCrlinUuid();
		this.crlinName = po.getCrlinName();
		this.crlinUrl = po.getCrlinUrl();
		this.crlinType = po.getCrlinType();
		this.crlinCdate = po.getCrlinCdate()!=null?DateUtil.formatDefaultDate(po.getCrlinCdate()):"";
		this.crlinUdate = po.getCrlinUdate()!=null?DateUtil.formatDefaultDate(po.getCrlinUdate()):"";
		this.crlinStatus = po.getCrlinStatus();
		this.crlinOrd = po.getCrlinOrd();
		this.crlinAuthor = po.getCrlinAuthor();
	}
//<=================定制内容开始==============
//==================定制内容结束==============>

}