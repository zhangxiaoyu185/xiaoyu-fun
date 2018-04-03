package com.xiaoyu.fun.util;

import com.alibaba.fastjson.JSON;
import com.xiaoyu.fun.entity.push.AndroidCustomField;
import com.xiaoyu.fun.entity.push.AndroidPushContent;
import com.xiaoyu.fun.entity.push.IosPushAps;
import com.xiaoyu.fun.entity.push.IosPushContent;

public class PushMessageUtil {

	/**
	 * 百度云开发者平台提供的api_key,现网必须以公司重新申请 http://developer.baidu.com/cloud/push
	 */
	// public static String API_KEY = "lXKWNofx3g0wrgzlZrcMrgmt";
	public static String API_KEY = "FWg3tjTM0SjLjgqlfzZzlRg7";

	/**
	 * 百度云开发者平台提供的secret_key,现网时必须以公司重新申请
	 */
	// public static String SECRET_KEY = "xb5Za8VHaETyPpogCF3nvpgxWUmwRxym";
	public static String SECRET_KEY = "YZ77zH3j6mEsTzRr2NG7VoXUW0AT0kj2";

	/**
	 * 生产模式，部署上现网必须是生产模式（开发模式：1 生产模式：2）
	 */
	public static int APP_PUBLISH_DEPLOY_STATUS = 2;

	/**
	 * 单播通知
	 */
	public static int PUSH_TYPE_UNICAST = 1;

	/**
	 * 组播通知
	 */
	public static int PUSH_TYPE_BROADCAST = 0;

	/**
	 * 未推送通知状态
	 */
	public static String PUSH_MSG_STATUS_NOT_PUBLISH = "0";

	/**
	 * 已推送状态
	 */
	public static String PUSH_MSG_STATUS_PUBLISH = "1";

	/**
	 * 未读状态
	 */
	public static String PUSH_MSG_STATUS_NOT_READ = "0";

	/**
	 * 用户在线
	 */
	public static int USER_ONLINE_STATUS_ONLIONE = 1;

	/**
	 * 用户不在线
	 */
	public static int USER_ONLINE_STATUS_OFFLINE = 0;

	/**
	 * android打开方式：1：打开URL 2：打开应用
	 */
	public static int ANDROID_OPEN_TYPE = 2;

	/**
	 * 默认获取消息条数
	 */
	public static int DEFAULT_MSG_COUNT = 20;

	/**
	 * 构造请求信息
	 * 
	 * @param title
	 * @param content
	 * @param url
	 * @return
	 */
	public static String buildPushMessage(String title, String content,
			String url) {
		String message = "";
		if (!"".equals(url) && null != url) {
			// 打开APP应用
			message = "{\"title\":"
					+ title
					+ ",\"description\":"
					+ content
					+ ",\"open_type\":\"2\",\"custom_content\":\"{type_code:1,type_content:XXXX}\"}";
		} else {
			// 简单消息通知
			message = "{\"title\":\"" + title + "\",\"description\":\""
					+ content + "\"}";
		}
		return message;
	}

	/**
	 * 生成IOS所需的推送内容
	 * 
	 * @param commonContent
	 *            推送的内容
	 * @param psType
	 *            推送的消息类别
	 * @param badge
	 *            未读消息数
	 * @return
	 */
	public static String generateIosPushContent(String commonContent,
			int badge, int psType) {
		IosPushContent iosContent = new IosPushContent();
		IosPushAps iosAps = new IosPushAps();
		iosAps.setAlert(commonContent);
		iosAps.setBadge(badge);
		iosContent.setAps(iosAps);
		iosContent.setPsType(psType);

		return JSON.toJSONString(iosContent);
	}

	/**
	 * 生成ANDROID所需的推送内容，例如：{"custom_content":{"ps_type":2},"title":"消息标题",
	 * "description":
	 * "路痴不要紧，别TM找个“黑摩的”也是路痴。愣是转了2小时。这会儿哥坐着出租，那货跟着我走","open_type":2}
	 * 
	 * @param title
	 *            标题
	 * @param description
	 *            说明
	 * @param psType
	 *            推送的消息类别
	 * @param openType
	 * @return
	 */
	public static String generateAndroidPushContent(String title,
			String description, int openType, int psType) {
		AndroidPushContent androidContent = new AndroidPushContent();
		AndroidCustomField field = new AndroidCustomField();
		field.setPs_type(psType);
		androidContent.setTitle(title);
		androidContent.setDescription(description);
		androidContent.setCustom_content(field);
//		androidContent.setOpen_type(openType);

		return JSON.toJSONString(androidContent);
	}
}