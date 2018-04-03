package com.xiaoyu.fun.service.impl;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;
import com.xiaoyu.fun.entity.push.MqPushMessage;
import com.xiaoyu.fun.enums.MsgType;
import com.xiaoyu.fun.service.MqPushService;

@Service("mqPushService")
public class MqPushServiceImpl implements MqPushService {

	private JmsTemplate jmsTemplate;

	private Destination pushMsgQueueDestination;
	
	protected final Logger push_logger = LoggerFactory.getLogger("PUSH_LOGGER");
	
	@Override
	public void addMqMessage(int pushType, String uuid, String content, String picName, String userUuid, MsgType msgType) {
		push_logger.info("[MqPushServiceImpl.addMqMessage] addMqMessage begin. msgType:" + msgType+",content:"+ content);
		final MqPushMessage mqMessage = new MqPushMessage();
		mqMessage.setPushType(pushType);
		mqMessage.setUuid(uuid);
		mqMessage.setContent(content);
		mqMessage.setUserUuid(userUuid);
		mqMessage.setMsgType(msgType);
		jmsTemplate.send(pushMsgQueueDestination, new MessageCreator() {  
			public Message createMessage(Session session) throws JMSException {  
				return session.createTextMessage(JSON.toJSONString(mqMessage));  
			}  
		});
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void setPushMsgQueueDestination(Destination pushMsgQueueDestination) {
		this.pushMsgQueueDestination = pushMsgQueueDestination;
	}
	
}