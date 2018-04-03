package com.xiaoyu.fun.vo;

import com.xiaoyu.fun.entity.CoreRole;
import com.xiaoyu.fun.util.BaseVO;
import com.xiaoyu.fun.util.DateUtil;

public class CoreRoleVO implements BaseVO {

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
	private String crrolCdate;

	/**
	*修改日期
	*/
	private String crrolUdate;

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

	public void setCrrolCdate(String crrolCdate) {
		this.crrolCdate = crrolCdate;
	}

	public String getCrrolCdate( ) {
		return crrolCdate;
	}

	public void setCrrolUdate(String crrolUdate) {
		this.crrolUdate = crrolUdate;
	}

	public String getCrrolUdate( ) {
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

	public CoreRoleVO( ) { 
	}

	@Override
	public void convertPOToVO(Object poObj) {
		if (null == poObj) {
			return;
		}

		CoreRole po = (CoreRole) poObj;
		this.crrolUuid = po.getCrrolUuid();
		this.crrolCractUuid = po.getCrrolCractUuid();
		this.crrolName = po.getCrrolName();
		this.crrolStatus = po.getCrrolStatus();
		this.crrolCdate = po.getCrrolCdate()!=null?DateUtil.formatDefaultDate(po.getCrrolCdate()):"";
		this.crrolUdate = po.getCrrolUdate()!=null?DateUtil.formatDefaultDate(po.getCrrolUdate()):"";
		this.crrolOrd = po.getCrrolOrd();
		this.crrolFun = po.getCrrolFun();
		this.crrolDesc = po.getCrrolDesc();
	}
//<=================定制内容开始==============
//==================定制内容结束==============>

}