package com.xiaoyu.fun.entity;

import com.xiaoyu.fun.entity.BaseEntity;
import java.util.Date;

public class BusiUser extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	*标识UNID
	*/
	private Integer bsusrUnid;

	/**
	*标识UUID
	*/
	private String bsusrUuid;

	/**
	*昵称
	*/
	private String bsusrCode;

	/**
	*密码
	*/
	private String bsusrPwd;
	
	/**
	*个性签名
	*/
	private String bsusrSignature;

	/**
	*出生年月
	*/
	private String bsusrBirthday;

	/**
	*性别:1男,0女,2其它
	*/
	private Integer bsusrSex;

	/**
	*兴趣爱好
	*/
	private String bsusrHobby;

	/**
	*所在城市
	*/
	private String bsusrCity;

	/**
	*头像URL
	*/
	private String bsusrHeadUrl;

	/**
	*个人说明
	*/
	private String bsusrPersonalNote;

	/**
	*手机号
	*/
	private String bsusrPhone;

	/**
	*最近登录时间
	*/
	private Date bsusrLastTime;

	/**
	*创建日期
	*/
	private Date bsusrCdate;

	/**
	*修改日期
	*/
	private Date bsusrUdate;

	/**
	*状态:1启用,0禁用
	*/
	private Integer bsusrStatus;

	/**
	*排序号
	*/
	private Integer bsusrOrd;

	/**
	*登录次数
	*/
	private Integer bsusrCount;

	public void setBsusrUnid(Integer bsusrUnid) {
		this.bsusrUnid = bsusrUnid;
	}

	public Integer getBsusrUnid( ) {
		return bsusrUnid;
	}

	public void setBsusrUuid(String bsusrUuid) {
		this.bsusrUuid = bsusrUuid;
	}

	public String getBsusrUuid( ) {
		return bsusrUuid;
	}

	public void setBsusrCode(String bsusrCode) {
		this.bsusrCode = bsusrCode;
	}

	public String getBsusrCode( ) {
		return bsusrCode;
	}

	public String getBsusrPwd() {
		return bsusrPwd;
	}

	public void setBsusrPwd(String bsusrPwd) {
		this.bsusrPwd = bsusrPwd;
	}

	public void setBsusrSignature(String bsusrSignature) {
		this.bsusrSignature = bsusrSignature;
	}

	public String getBsusrSignature( ) {
		return bsusrSignature;
	}

	public void setBsusrBirthday(String bsusrBirthday) {
		this.bsusrBirthday = bsusrBirthday;
	}

	public String getBsusrBirthday( ) {
		return bsusrBirthday;
	}

	public void setBsusrSex(Integer bsusrSex) {
		this.bsusrSex = bsusrSex;
	}

	public Integer getBsusrSex( ) {
		return bsusrSex;
	}

	public void setBsusrHobby(String bsusrHobby) {
		this.bsusrHobby = bsusrHobby;
	}

	public String getBsusrHobby( ) {
		return bsusrHobby;
	}

	public void setBsusrCity(String bsusrCity) {
		this.bsusrCity = bsusrCity;
	}

	public String getBsusrCity( ) {
		return bsusrCity;
	}

	public void setBsusrHeadUrl(String bsusrHeadUrl) {
		this.bsusrHeadUrl = bsusrHeadUrl;
	}

	public String getBsusrHeadUrl( ) {
		return bsusrHeadUrl;
	}

	public void setBsusrPersonalNote(String bsusrPersonalNote) {
		this.bsusrPersonalNote = bsusrPersonalNote;
	}

	public String getBsusrPersonalNote( ) {
		return bsusrPersonalNote;
	}

	public void setBsusrPhone(String bsusrPhone) {
		this.bsusrPhone = bsusrPhone;
	}

	public String getBsusrPhone( ) {
		return bsusrPhone;
	}

	public void setBsusrLastTime(Date bsusrLastTime) {
		this.bsusrLastTime = bsusrLastTime;
	}

	public Date getBsusrLastTime( ) {
		return bsusrLastTime;
	}

	public void setBsusrCdate(Date bsusrCdate) {
		this.bsusrCdate = bsusrCdate;
	}

	public Date getBsusrCdate( ) {
		return bsusrCdate;
	}

	public void setBsusrUdate(Date bsusrUdate) {
		this.bsusrUdate = bsusrUdate;
	}

	public Date getBsusrUdate( ) {
		return bsusrUdate;
	}

	public void setBsusrStatus(Integer bsusrStatus) {
		this.bsusrStatus = bsusrStatus;
	}

	public Integer getBsusrStatus( ) {
		return bsusrStatus;
	}

	public void setBsusrOrd(Integer bsusrOrd) {
		this.bsusrOrd = bsusrOrd;
	}

	public Integer getBsusrOrd( ) {
		return bsusrOrd;
	}

	public void setBsusrCount(Integer bsusrCount) {
		this.bsusrCount = bsusrCount;
	}

	public Integer getBsusrCount( ) {
		return bsusrCount;
	}

	public BusiUser( ) { 
	}

	public BusiUser(String bsusrCode, String bsusrPwd) {
		this.bsusrCode = bsusrCode;
		this.bsusrPwd = bsusrPwd;
	}
	
	public BusiUser(String bsusrUuid) {
		this.bsusrUuid = bsusrUuid;
	}
//<=================定制内容开始==============
//==================定制内容结束==============>

}