package com.xiaoyu.fun.entity.push;

/**
 * IOS推送固定格式部分
 */
public class IosPushAps {

	/**
	 * 提示内容
	 */
	private String alert;
	
	/**
	 * 声音
	 */
	private String sound="1";
	
	/**
	 * 右角消息标记
	 */
	private int badge=1;

	public String getAlert() {
		return alert;
	}

	public void setAlert(String alert) {
		this.alert = alert;
	}

	public String getSound() {
		return sound;
	}

	public void setSound(String sound) {
		this.sound = sound;
	}

	public int getBadge() {
		return badge;
	}

	public void setBadge(int badge) {
		this.badge = badge;
	}
	
}