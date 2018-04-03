package com.xiaoyu.fun.service;

import com.xiaoyu.fun.enums.MsgType;

public interface MqPushService {

	/**
	 * 添加MQ信息
	 * @param pushType 0单播 1广播
	 * @param uuid
	 * @param content
	 * @param picName
	 * @param userUuid
	 * @param msgType
	 */
	void addMqMessage(int pushType, String uuid, String content, String picName, String userUuid, MsgType msgType);
}
