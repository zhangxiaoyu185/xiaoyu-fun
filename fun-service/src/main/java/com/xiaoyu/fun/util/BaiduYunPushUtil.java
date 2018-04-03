package com.xiaoyu.fun.util;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSON;
import com.baidu.yun.channel.auth.ChannelKeyPair;
import com.baidu.yun.channel.client.BaiduChannelClient;
import com.baidu.yun.channel.exception.ChannelClientException;
import com.baidu.yun.channel.exception.ChannelServerException;
import com.baidu.yun.channel.model.PushBroadcastMessageRequest;
import com.baidu.yun.channel.model.PushBroadcastMessageResponse;
import com.baidu.yun.channel.model.PushUnicastMessageRequest;
import com.baidu.yun.channel.model.PushUnicastMessageResponse;
import com.baidu.yun.core.log.YunLogEvent;
import com.baidu.yun.core.log.YunLogHandler;
import com.xiaoyu.fun.entity.push.AndroidCustomField;
import com.xiaoyu.fun.entity.push.AndroidPushContent;
import com.xiaoyu.fun.entity.push.IosPushAps;
import com.xiaoyu.fun.entity.push.IosPushContent;
import com.xiaoyu.fun.enums.MsgType;
import com.xiaoyu.fun.spring.adapter.PropertyHolder;

/**
 * 百度云推送工具类
 */
public class BaiduYunPushUtil {

	private static String API_KEY = PropertyHolder.getProperty("baidu_api_key");
	
	private static Integer DEPLOY_STATUS = Integer.valueOf(PropertyHolder.getProperty("baidu_push_deploy_status"));//1代表开发状态；2代表产品环境
	
	private static String SECRET_KEY = PropertyHolder.getProperty("baidu_secret_key");

	protected static final Logger logger = LoggerFactory.getLogger("PUSH_LOGGER");
	
	private static final int MESSAGE_TYPE_MSG = 0;//消息（默认）
	private static final int MESSAGE_TYPE_NOTIFY = 1;//通知（统一用通知）	
	private static final int DEVICE_TYPE_WEB = 1;
	private static final int DEVICE_TYPE_PC = 2;
	private static final int DEVICE_TYPE_ANDROID = 3;
	private static final int DEVICE_TYPE_IOS = 4;
	private static final int DEVICE_TYPE_WP = 5;
	
	/**
	 * android打开方式：1：打开URL 2：打开应用
	 */
	public static int ANDROID_OPEN_TYPE = 2;
	
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
	
	public static final Map<MsgType, Integer> psTypeMap = new HashMap<MsgType, Integer>();
	
	static {
		psTypeMap.put(MsgType.FUN_PUSH_INFO, 1);
		psTypeMap.put(MsgType.FUN_VERIFY_SUCCESS, 2);
	}
	
	public static int androidPushBroadcast(String content) {
		ChannelKeyPair pair = new ChannelKeyPair(API_KEY, SECRET_KEY);
		BaiduChannelClient channelClient = new BaiduChannelClient(pair);
		
		// 注册YunLogHandler类，打印交互细节
		channelClient.setChannelLogHandler(new YunLogHandler() {
			@Override
			public void onHandle(YunLogEvent event) {
				logger.info("android broadcast push event:" + event.getMessage());
			}
		});
		
		try {
			PushBroadcastMessageRequest request = new PushBroadcastMessageRequest();
			request.setDeviceType(DEVICE_TYPE_ANDROID);
			request.setMessage(content);
			request.setMessageType(MESSAGE_TYPE_NOTIFY);
			PushBroadcastMessageResponse response = channelClient.pushBroadcastMessage(request);
			
			return response.getSuccessAmount(); 
		} catch (ChannelClientException | ChannelServerException e) {
			// 处理客户端错误异常
			logger.error("fail to push:",e);				
			//e.printStackTrace();
			return 0;
		}
	}

	public static int androidPushUnicast(Long channelId, String userId, String content) {
		ChannelKeyPair pair = new ChannelKeyPair(API_KEY, SECRET_KEY);
		BaiduChannelClient channelClient = new BaiduChannelClient(pair);
		
		channelClient.setChannelLogHandler(new YunLogHandler() {
			@Override
			public void onHandle(YunLogEvent event) {
				logger.info("android unicast push event:" + event.getMessage());
			}
		});
		
		try {
			//手机端的ChannelId， 手机端的UserId
			PushUnicastMessageRequest request = new PushUnicastMessageRequest();
			request.setDeviceType(DEVICE_TYPE_ANDROID);	
			request.setChannelId(channelId);	
			request.setUserId(userId);	 
			request.setMessage(content);
			request.setMessageType(MESSAGE_TYPE_NOTIFY);			
			PushUnicastMessageResponse response = channelClient.pushUnicastMessage(request);
			
			return response.getSuccessAmount(); 
		} catch (ChannelClientException | ChannelServerException e) {
			logger.error("fail to push:",e);				
			return 0;
		} 
		
	}

	public static int iosPushBroadcast(String content) {
		ChannelKeyPair pair = new ChannelKeyPair(API_KEY, SECRET_KEY);
		BaiduChannelClient channelClient = new BaiduChannelClient(pair);
	
		channelClient.setChannelLogHandler(new YunLogHandler() {
			@Override
			public void onHandle(YunLogEvent event) {
				logger.info("ios broadcast push event:" + event.getMessage());
			}
		});
		
		try {			
			PushBroadcastMessageRequest request = new PushBroadcastMessageRequest();
			request.setDeviceType(DEVICE_TYPE_IOS);
			request.setMessageType(MESSAGE_TYPE_NOTIFY);
			request.setDeployStatus(DEPLOY_STATUS); // DeployStatus => 1: Developer 2: Production
			request.setMessage(content);
 			
			PushBroadcastMessageResponse response = channelClient.pushBroadcastMessage(request);
				
			return response.getSuccessAmount(); 
			
		} catch (ChannelClientException | ChannelServerException e) {
			logger.error("fail to push:",e);
			return 0;
		}
	}

	public static int iosPushUnicast(Long channelId, String userId, String content) {
		ChannelKeyPair pair = new ChannelKeyPair(API_KEY, SECRET_KEY);
		BaiduChannelClient channelClient = new BaiduChannelClient(pair);
		
		channelClient.setChannelLogHandler(new YunLogHandler() {
			@Override
			public void onHandle(YunLogEvent event) {
				logger.info("ios unicast push event:" + event.getMessage());
			}
		});
		
		try {
			PushUnicastMessageRequest request = new PushUnicastMessageRequest();
			request.setDeviceType(DEVICE_TYPE_IOS);
			request.setDeployStatus(DEPLOY_STATUS);
			request.setChannelId(channelId);	
			request.setUserId(userId);	 
			
			request.setMessageType(MESSAGE_TYPE_NOTIFY);
			request.setMessage(content);
			
			PushUnicastMessageResponse response = channelClient.pushUnicastMessage(request);
				
			return response.getSuccessAmount(); 
			
		} catch (ChannelClientException | ChannelServerException e) {
			logger.error("fail to push:",e);				
			return 0;
		}
	}
	
	/**
	 * 生成IOS所需的推送内容
	 * 
	 * @param id
	 * @param commonContent
	 *            推送的内容
	 * @param psType
	 *            推送的消息类别          
	 * @return
	 */
	public static String generateIosPushContent(String uuid, String commonContent, int psType) {
		IosPushContent iosContent = new IosPushContent();
		IosPushAps iosAps = new IosPushAps();
		iosAps.setAlert(commonContent);		
		iosContent.setAps(iosAps);
		iosContent.setUuid(uuid);
		iosContent.setPsType(psType);

		return JSON.toJSONString(iosContent);
	}

	/**
	 * 生成ANDROID所需的推送内容
	 * @param id
	 * @param description
	 *            说明（必须）
	 * @param psType
	 *            推送的消息类别          
	 * @return
	 */
	public static String generateAndroidPushContent(String uuid, String description, int psType) {
		logger.info("uuid:"+uuid+";description:"+description+":psType:"+psType);
		AndroidPushContent androidContent = new AndroidPushContent();
		AndroidCustomField field = new AndroidCustomField();
		field.setPs_type(psType);
		field.setUuid(uuid);
		androidContent.setCustom_content(field);
		androidContent.setDescription(description);
		
		return JSON.toJSONString(androidContent);
	}
	
}