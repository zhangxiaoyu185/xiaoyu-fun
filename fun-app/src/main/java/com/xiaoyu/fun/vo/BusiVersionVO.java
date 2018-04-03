package com.xiaoyu.fun.vo;

import com.xiaoyu.fun.entity.BusiVersion;
import com.xiaoyu.fun.util.BaseVO;

public class BusiVersionVO implements BaseVO {

	/**
	*标识UUID
	*/
	private String bsvsnUuid;

	/**
	*版本号
	*/
	private String bsvsnNo;

	/**
	*版本路径
	*/
	private String bsvsnUrl;

	/**
	*设备类型：1Android,2:IOS
	*/
	private Integer bsvsnType;

	/**
	*是否强制更新：1是，0否
	*/
	private Integer bsvsnMust;

	/**
	*更新内容
	*/
	private String bsvsnContent;

	public void setBsvsnUuid(String bsvsnUuid) {
		this.bsvsnUuid = bsvsnUuid;
	}

	public String getBsvsnUuid( ) {
		return bsvsnUuid;
	}

	public void setBsvsnNo(String bsvsnNo) {
		this.bsvsnNo = bsvsnNo;
	}

	public String getBsvsnNo( ) {
		return bsvsnNo;
	}

	public void setBsvsnUrl(String bsvsnUrl) {
		this.bsvsnUrl = bsvsnUrl;
	}

	public String getBsvsnUrl( ) {
		return bsvsnUrl;
	}

	public void setBsvsnType(Integer bsvsnType) {
		this.bsvsnType = bsvsnType;
	}

	public Integer getBsvsnType( ) {
		return bsvsnType;
	}

	public void setBsvsnMust(Integer bsvsnMust) {
		this.bsvsnMust = bsvsnMust;
	}

	public Integer getBsvsnMust( ) {
		return bsvsnMust;
	}

	public void setBsvsnContent(String bsvsnContent) {
		this.bsvsnContent = bsvsnContent;
	}

	public String getBsvsnContent( ) {
		return bsvsnContent;
	}

	public BusiVersionVO( ) { 
	}

	@Override
	public void convertPOToVO(Object poObj) {
		if (null == poObj) {
			return;
		}

		BusiVersion po = (BusiVersion) poObj;
		this.bsvsnUuid = po.getBsvsnUuid();
		this.bsvsnNo = po.getBsvsnNo();
		this.bsvsnUrl = po.getBsvsnUrl();
		this.bsvsnType = po.getBsvsnType();
		this.bsvsnMust = po.getBsvsnMust();
		this.bsvsnContent = po.getBsvsnContent();
	}
//<=================定制内容开始==============
//==================定制内容结束==============>

}