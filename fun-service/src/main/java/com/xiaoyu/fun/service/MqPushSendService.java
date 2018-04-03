package com.xiaoyu.fun.service;

import com.xiaoyu.fun.entity.push.MqPushMessage;

public interface MqPushSendService {

	/**
	 * 发送mq信息
	 * @param mqMessage
	 */
	void sendMqPush(MqPushMessage mqMessage);
}
