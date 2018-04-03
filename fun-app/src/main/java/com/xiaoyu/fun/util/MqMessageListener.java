package com.xiaoyu.fun.util;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.common.json.JSON;
import com.xiaoyu.fun.entity.push.MqPushMessage;
import com.xiaoyu.fun.service.MqPushSendService;

public class MqMessageListener implements MessageListener {

	@Autowired
	public MqPushSendService mqPushSendService;
	
	@Override
	public void onMessage(Message message) {
		try {
			TextMessage textMessage = (TextMessage) message;
			if (null != textMessage) {
				String strText = textMessage.getText();
				Object obj = JSON.parse(strText, MqPushMessage.class);
				mqPushSendService.sendMqPush((MqPushMessage)obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
