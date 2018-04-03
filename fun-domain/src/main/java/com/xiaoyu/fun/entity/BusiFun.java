package com.xiaoyu.fun.entity;

import com.xiaoyu.fun.entity.BaseEntity;
import java.util.Date;

public class BusiFun extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	*标识UNID
	*/
	private Integer bsfunUnid;

	/**
	*标识UUID
	*/
	private String bsfunUuid;

	/**
	*文本内容
	*/
	private String bsfunContent;

	/**
	*语音URL
	*/
	private String bsfunSource;

	/**
	*图片URL
	*/
	private String bsfunPicurl;

	/**
	*发表人UUID
	*/
	private String bsfunPushUser;

	/**
	*审核人集合
	*/
	private String bsfunCheckUser;
	
	/**
	*赞积分
	*/
	private Integer bsfunIntegral;

	/**
	*不赞积分
	*/
	private Integer bsfunIntegralNot;

	/**
	*类型:0糗事,1奇闻,2家庭,3职场,4社会,5校园
	*/
	private Integer bsfunType;

	/**
	*创建日期
	*/
	private Date bsfunCdate;

	/**
	*修改日期
	*/
	private Date bsfunUdate;

	/**
	*审核通过时间
	*/
	private Date bsfunCheckTime;

	/**
	*状态:1启用,0禁用
	*/
	private Integer bsfunStatus;

	/**
	*排序号
	*/
	private Integer bsfunOrd;

	public void setBsfunUnid(Integer bsfunUnid) {
		this.bsfunUnid = bsfunUnid;
	}

	public Integer getBsfunUnid( ) {
		return bsfunUnid;
	}

	public void setBsfunUuid(String bsfunUuid) {
		this.bsfunUuid = bsfunUuid;
	}

	public String getBsfunUuid( ) {
		return bsfunUuid;
	}

	public void setBsfunContent(String bsfunContent) {
		this.bsfunContent = bsfunContent;
	}

	public String getBsfunContent( ) {
		return bsfunContent;
	}

	public String getBsfunSource() {
		return bsfunSource;
	}

	public void setBsfunSource(String bsfunSource) {
		this.bsfunSource = bsfunSource;
	}

	public void setBsfunPicurl(String bsfunPicurl) {
		this.bsfunPicurl = bsfunPicurl;
	}

	public String getBsfunPicurl( ) {
		return bsfunPicurl;
	}

	public void setBsfunPushUser(String bsfunPushUser) {
		this.bsfunPushUser = bsfunPushUser;
	}

	public String getBsfunPushUser( ) {
		return bsfunPushUser;
	}

	public String getBsfunCheckUser() {
		return bsfunCheckUser;
	}

	public void setBsfunCheckUser(String bsfunCheckUser) {
		this.bsfunCheckUser = bsfunCheckUser;
	}

	public void setBsfunIntegral(Integer bsfunIntegral) {
		this.bsfunIntegral = bsfunIntegral;
	}

	public Integer getBsfunIntegral( ) {
		return bsfunIntegral;
	}

	public Integer getBsfunIntegralNot() {
		return bsfunIntegralNot;
	}

	public void setBsfunIntegralNot(Integer bsfunIntegralNot) {
		this.bsfunIntegralNot = bsfunIntegralNot;
	}

	public void setBsfunType(Integer bsfunType) {
		this.bsfunType = bsfunType;
	}

	public Integer getBsfunType( ) {
		return bsfunType;
	}

	public void setBsfunCdate(Date bsfunCdate) {
		this.bsfunCdate = bsfunCdate;
	}

	public Date getBsfunCdate( ) {
		return bsfunCdate;
	}

	public void setBsfunUdate(Date bsfunUdate) {
		this.bsfunUdate = bsfunUdate;
	}

	public Date getBsfunUdate( ) {
		return bsfunUdate;
	}

	public void setBsfunCheckTime(Date bsfunCheckTime) {
		this.bsfunCheckTime = bsfunCheckTime;
	}

	public Date getBsfunCheckTime( ) {
		return bsfunCheckTime;
	}

	public void setBsfunStatus(Integer bsfunStatus) {
		this.bsfunStatus = bsfunStatus;
	}

	public Integer getBsfunStatus( ) {
		return bsfunStatus;
	}

	public void setBsfunOrd(Integer bsfunOrd) {
		this.bsfunOrd = bsfunOrd;
	}

	public Integer getBsfunOrd( ) {
		return bsfunOrd;
	}

	public BusiFun( ) { 
	}

	public BusiFun(String bsfunUuid) {
		this.bsfunUuid = bsfunUuid;
	}
//<=================定制内容开始==============
//==================定制内容结束==============>

}