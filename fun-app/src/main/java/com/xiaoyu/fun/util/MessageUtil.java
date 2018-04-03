package com.xiaoyu.fun.util;

import com.baidu.yun.channel.auth.ChannelKeyPair;
import com.baidu.yun.channel.client.BaiduChannelClient;
import com.baidu.yun.channel.exception.ChannelClientException;
import com.baidu.yun.channel.exception.ChannelServerException;
import com.baidu.yun.channel.model.PushBroadcastMessageRequest;
import com.baidu.yun.channel.model.PushBroadcastMessageResponse;
import com.baidu.yun.core.log.YunLogEvent;
import com.baidu.yun.core.log.YunLogHandler;

public class MessageUtil {

	private static void iosPushBroadcastNotification(String jsonMessage) {
		ChannelKeyPair pair = new ChannelKeyPair("wkU28jQSMQoh1wCXB9TlIG7V",
				"chuD9KLxBKDhSoYtjAlAZ91EcxAamnx8");
		BaiduChannelClient channelClient = new BaiduChannelClient(pair);
		channelClient.setChannelLogHandler(new YunLogHandler() {
			@Override
			public void onHandle(YunLogEvent event) {
				System.out.println(event.getMessage());
			}
		});
		try {
			PushBroadcastMessageRequest request = new PushBroadcastMessageRequest();
			request.setDeviceType(4); // device_type => 1: web 2: pc 3:android
										// 4:ios 5:wp
			request.setMessageType(1);
			request.setDeployStatus(1); // DeployStatus => 1: Developer 2:
										// Production
			request.setMessage(jsonMessage);
			PushBroadcastMessageResponse response = channelClient
					.pushBroadcastMessage(request);
			System.out.println("push amount : " + response.getSuccessAmount());
		} catch (ChannelClientException e) {
			e.printStackTrace();
		} catch (ChannelServerException e) {
			System.out.println(String.format(
					"request_id: %d, error_code: %d, error_message: %s",
					e.getRequestId(), e.getErrorCode(), e.getErrorMsg()));
		}
	}

	public static void main(String[] args) {
		iosPushBroadcastNotification("{\"aps\":{\"alert\":\"121\",\"badge\":1,\"sound\":\"default\"},\"id\":127,\"open_type\":2,\"psType\":2}");
	}
}