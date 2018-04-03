package com.xiaoyu.fun.enums;

import javax.xml.bind.annotation.XmlType;

/**
 * 性别枚举
 * 
 * @author Bergson
 *
 */
@XmlType(name = "WSSexType")
public enum SexType {
	
	MALE("男"), FEMALE("女"), OTHERS("未知");
	
	String chineseStr;

	private SexType(String chineseStr) {

		this.chineseStr = chineseStr;
	}

	public String getChineseStr() {
		return chineseStr;
	}
}
