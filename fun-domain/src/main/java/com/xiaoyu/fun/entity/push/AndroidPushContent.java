package com.xiaoyu.fun.entity.push;

/**
 * 安卓推送内容
 */
public class AndroidPushContent {

	/**
	 * 提示标题
	 */
	private String title;
	
	/**
	 * 描述性内容
	 */
	private String description;
	
	/**
	 * 安卓自定义字段
	 */
	private AndroidCustomField custom_content;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AndroidCustomField getCustom_content() {
		return custom_content;
	}

	public void setCustom_content(AndroidCustomField custom_content) {
		this.custom_content = custom_content;
	}
}
