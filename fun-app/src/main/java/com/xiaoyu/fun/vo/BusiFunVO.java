package com.xiaoyu.fun.vo;

import com.xiaoyu.fun.entity.BusiFun;
import com.xiaoyu.fun.util.BaseVO;
import com.xiaoyu.fun.util.DateUtil;

public class BusiFunVO implements BaseVO {

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
	*发表人昵称
	*/
	private String bsfunPushUserCode;
	
	/**
	*发表人头像
	*/
	private String bsfunPushUserHead;
	
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
	private String bsfunCdate;

	/**
	*审核通过时间
	*/
	private String bsfunCheckTime;

	/**
	*状态:1启用,0禁用
	*/
	private Integer bsfunStatus;

	/**
	*排序号
	*/
	private Integer bsfunOrd;

	public Integer getBsfunUnid() {
		return bsfunUnid;
	}

	public void setBsfunUnid(Integer bsfunUnid) {
		this.bsfunUnid = bsfunUnid;
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

	public void setBsfunCdate(String bsfunCdate) {
		this.bsfunCdate = bsfunCdate;
	}

	public String getBsfunCdate( ) {
		return bsfunCdate;
	}

	public void setBsfunCheckTime(String bsfunCheckTime) {
		this.bsfunCheckTime = bsfunCheckTime;
	}

	public String getBsfunCheckTime( ) {
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

	public String getBsfunPushUserCode() {
		return bsfunPushUserCode;
	}

	public void setBsfunPushUserCode(String bsfunPushUserCode) {
		this.bsfunPushUserCode = bsfunPushUserCode;
	}

	public String getBsfunPushUserHead() {
		return bsfunPushUserHead;
	}

	public void setBsfunPushUserHead(String bsfunPushUserHead) {
		this.bsfunPushUserHead = bsfunPushUserHead;
	}

	public BusiFunVO( ) { 
	}

	@Override
	public void convertPOToVO(Object poObj) {
		if (null == poObj) {
			return;
		}

		BusiFun po = (BusiFun) poObj;
		this.bsfunUnid = po.getBsfunUnid();
		this.bsfunUuid = po.getBsfunUuid();
		this.bsfunSource = po.getBsfunSource();
		this.bsfunPicurl = po.getBsfunPicurl();
		this.bsfunPushUser = po.getBsfunPushUser();
		this.bsfunCheckUser = po.getBsfunCheckUser();
		this.bsfunIntegral = po.getBsfunIntegral();
		this.bsfunIntegralNot = po.getBsfunIntegralNot();
		this.bsfunType = po.getBsfunType();
		this.bsfunCdate = "";
		if(po.getBsfunCdate() != null) {
			this.bsfunCdate = String.valueOf(System.currentTimeMillis() - po.getBsfunCdate().getTime());
		}
		this.bsfunCheckTime = po.getBsfunCheckTime()!=null?DateUtil.formatDefaultDate(po.getBsfunCheckTime()):"";
		this.bsfunStatus = po.getBsfunStatus();
		this.bsfunOrd = po.getBsfunOrd();
	}
//<=================定制内容开始==============
//==================定制内容结束==============>

}