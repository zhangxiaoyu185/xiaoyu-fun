package com.xiaoyu.fun.entity.push;

/**
 * 安卓推送自定义字段
 */
public class AndroidCustomField {

	/**
	 * 消息uuid
	 */
	private String uuid;
	
	/**
	 * 推送消息类别
	 * 1.趣事推送消息2.趣事审核成功
	 */
	private int ps_type;

	public int getPs_type() {
		return ps_type;
	}

	public void setPs_type(int ps_type) {
		this.ps_type = ps_type;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
}