package com.xiaoyu.fun.service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xiaoyu.fun.entity.BusiPushinfo;
import com.xiaoyu.fun.entity.push.MqPushMessage;
import com.xiaoyu.fun.service.BusiPushinfoService;
import com.xiaoyu.fun.service.MqPushSendService;
import com.xiaoyu.fun.util.BaiduYunPushUtil;
import com.xiaoyu.fun.util.StringUtil;

@Service("mqPushSendService")
public class MqPushSendServiceImpl implements MqPushSendService {
	
	@Autowired
	private BusiPushinfoService busiPushinfoService;
		
	protected final Logger push_logger = LoggerFactory.getLogger("PUSH_LOGGER");
	
	@Override
	public void sendMqPush(MqPushMessage mqMessage) {
		push_logger.info("[MqPushSendServiceImpl.sendMqPush] sendMqPush begin. msgType:" + mqMessage.getMsgType()==null?null:mqMessage.getMsgType()+",content:"+mqMessage.getContent());
		if(mqMessage.getPushType() == 0 && !StringUtil.isEmpty(mqMessage.getUserUuid())) {
			List<BusiPushinfo> infoList = busiPushinfoService.getBusiPushinfo(mqMessage.getUserUuid());			
			for(BusiPushinfo info : infoList) {
				String pushContent = "";
				if(info.getBspioType() == 1){
					pushContent = BaiduYunPushUtil.generateAndroidPushContent(mqMessage.getUuid(), mqMessage.getContent(), BaiduYunPushUtil.psTypeMap.get(mqMessage.getMsgType()));
					BaiduYunPushUtil.androidPushUnicast(Long.valueOf(info.getBspioChannelId()), info.getBspioUser(), pushContent);
				}
				if(info.getBspioType() == 2){
					pushContent = BaiduYunPushUtil.generateIosPushContent(mqMessage.getUuid(), mqMessage.getContent(), BaiduYunPushUtil.psTypeMap.get(mqMessage.getMsgType()));
					BaiduYunPushUtil.iosPushUnicast(Long.valueOf(info.getBspioChannelId()), info.getBspioUser(), pushContent);
				}					
			}
			push_logger.info("[MqPushSendServiceImpl.sendMqPush] push pushMessage success.");
		}else {
			BaiduYunPushUtil.androidPushBroadcast(BaiduYunPushUtil.generateAndroidPushContent(mqMessage.getUuid(), mqMessage.getContent(), BaiduYunPushUtil.psTypeMap.get(mqMessage.getMsgType())));
			BaiduYunPushUtil.iosPushBroadcast(BaiduYunPushUtil.generateIosPushContent(mqMessage.getUuid(), mqMessage.getContent(), BaiduYunPushUtil.psTypeMap.get(mqMessage.getMsgType())));
			push_logger.info("[MqPushSendServiceImpl.sendMqPush] push pushMessage success.");
		}
	}

}