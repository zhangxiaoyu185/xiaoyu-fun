package com.xiaoyu.fun.entity;

import com.xiaoyu.fun.entity.BaseEntity;
import java.util.Date;

public class CoreAccount extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	*标识UNID
	*/
	private Integer cractUnid;

	/**
	*标识UUID
	*/
	private String cractUuid;

	/**
	*帐户名称
	*/
	private String cractName;

	/**
	*真实姓名
	*/
	private String cractCode;

	/**
	*登录密码
	*/
	private String cractPassword;

	/**
	*身份证号
	*/
	private String cractIdNumber;

	/**
	*电子邮件
	*/
	private String cractEmail;

	/**
	*手机号码
	*/
	private String cractMobile;

	/**
	*帐户性质:0管理员,1普通前后台用户,2普通前台用户
	*/
	private Integer cractType;

	/**
	*状态:1启用,0禁用
	*/
	private Integer cractStatus;

	/**
	*角色UUID
	*/
	private String cractRoleUuid;

	/**
	*排序号
	*/
	private Integer cractOrd;

	/**
	*创建日期
	*/
	private Date cractCdate;

	/**
	*修改日期
	*/
	private Date cractUdate;

	/**
	*创建者
	*/
	private String cractCreator;

	/**
	*生日
	*/
	private String cractBirthday;

	/**
	*性别:1男,0女,2其它
	*/
	private Integer cractGender;

	/**
	*QQ
	*/
	private String cractQq;

	/**
	*地址
	*/
	private String cractAddress;

	/**
	*备注
	*/
	private String cractRemarks;

	public void setCractUnid(Integer cractUnid) {
		this.cractUnid = cractUnid;
	}

	public Integer getCractUnid( ) {
		return cractUnid;
	}

	public void setCractUuid(String cractUuid) {
		this.cractUuid = cractUuid;
	}

	public String getCractUuid( ) {
		return cractUuid;
	}

	public void setCractName(String cractName) {
		this.cractName = cractName;
	}

	public String getCractName( ) {
		return cractName;
	}

	public void setCractCode(String cractCode) {
		this.cractCode = cractCode;
	}

	public String getCractCode( ) {
		return cractCode;
	}

	public void setCractPassword(String cractPassword) {
		this.cractPassword = cractPassword;
	}

	public String getCractPassword( ) {
		return cractPassword;
	}

	public void setCractIdNumber(String cractIdNumber) {
		this.cractIdNumber = cractIdNumber;
	}

	public String getCractIdNumber( ) {
		return cractIdNumber;
	}

	public void setCractEmail(String cractEmail) {
		this.cractEmail = cractEmail;
	}

	public String getCractEmail( ) {
		return cractEmail;
	}

	public void setCractMobile(String cractMobile) {
		this.cractMobile = cractMobile;
	}

	public String getCractMobile( ) {
		return cractMobile;
	}

	public void setCractType(Integer cractType) {
		this.cractType = cractType;
	}

	public Integer getCractType( ) {
		return cractType;
	}

	public void setCractStatus(Integer cractStatus) {
		this.cractStatus = cractStatus;
	}

	public Integer getCractStatus( ) {
		return cractStatus;
	}

	public void setCractRoleUuid(String cractRoleUuid) {
		this.cractRoleUuid = cractRoleUuid;
	}

	public String getCractRoleUuid( ) {
		return cractRoleUuid;
	}

	public void setCractOrd(Integer cractOrd) {
		this.cractOrd = cractOrd;
	}

	public Integer getCractOrd( ) {
		return cractOrd;
	}

	public void setCractCdate(Date cractCdate) {
		this.cractCdate = cractCdate;
	}

	public Date getCractCdate( ) {
		return cractCdate;
	}

	public void setCractUdate(Date cractUdate) {
		this.cractUdate = cractUdate;
	}

	public Date getCractUdate( ) {
		return cractUdate;
	}

	public void setCractCreator(String cractCreator) {
		this.cractCreator = cractCreator;
	}

	public String getCractCreator( ) {
		return cractCreator;
	}

	public void setCractBirthday(String cractBirthday) {
		this.cractBirthday = cractBirthday;
	}

	public String getCractBirthday( ) {
		return cractBirthday;
	}

	public void setCractGender(Integer cractGender) {
		this.cractGender = cractGender;
	}

	public Integer getCractGender( ) {
		return cractGender;
	}

	public void setCractQq(String cractQq) {
		this.cractQq = cractQq;
	}

	public String getCractQq( ) {
		return cractQq;
	}

	public void setCractAddress(String cractAddress) {
		this.cractAddress = cractAddress;
	}

	public String getCractAddress( ) {
		return cractAddress;
	}

	public void setCractRemarks(String cractRemarks) {
		this.cractRemarks = cractRemarks;
	}

	public String getCractRemarks( ) {
		return cractRemarks;
	}

	public CoreAccount( ) { 
	}

	public CoreAccount(String cractName, String cractPassword) {
		this.cractName = cractName;
		this.cractPassword = cractPassword;
	}
	
//<=================定制内容开始==============
//==================定制内容结束==============>

}