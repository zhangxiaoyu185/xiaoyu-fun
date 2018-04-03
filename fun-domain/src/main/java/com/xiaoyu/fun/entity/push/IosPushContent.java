package com.xiaoyu.fun.entity.push;

/**
 * IOS推送内容
 */
public class IosPushContent {
	
	/**
	 * 固定格式部分
	 */
	private IosPushAps aps;
	
	/**
	 * 消息uuid
	 */
	private String uuid;
	
	/**
	 * 提示标题
	 */
	private String title;
	
	/**
	 * 推送消息类别
	 * 1.趣事推送消息1.趣事审核成功
	 */
	private int psType;

	/**
	 * 1：代开URL 2：打开应用
	 */
	private int open_type = 2;
	
	public IosPushAps getAps() {
		return aps;
	}

	public void setAps(IosPushAps aps) {
		this.aps = aps;
	}

	public int getPsType() {
		return psType;
	}

	public void setPsType(int psType) {
		this.psType = psType;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getOpen_type() {
		return open_type;
	}

	public void setOpen_type(int open_type) {
		this.open_type = open_type;
	}
	
}