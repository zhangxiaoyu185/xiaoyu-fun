package com.xiaoyu.fun.job;

import java.util.Date;
import java.util.List;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import com.xiaoyu.fun.entity.BusiFun;
import com.xiaoyu.fun.enums.MsgType;
import com.xiaoyu.fun.service.BusiFunService;
import com.xiaoyu.fun.service.MqPushService;
//import com.xiaoyu.fun.util.BaiduYunPushUtil;
import com.xiaoyu.fun.util.StringUtil;

public class ApprovedFunPushJob extends QuartzJobBean{

	private final Logger logger = LoggerFactory.getLogger("PUSH_LOGGER");
	
	private BusiFunService busiFunService;
	
	private MqPushService mqPushService;
	
	public void setBusiFunService(BusiFunService busiFunService) {
		this.busiFunService = busiFunService;
	}

	public void setMqPushService(MqPushService mqPushService) {
		this.mqPushService = mqPushService;
	}

	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		
		List<BusiFun> list = busiFunService.getBusiFunByVerify();
		if(list != null && list.size() > 0) {
			for (BusiFun busiFun : list) {
				//通过审核,修改审核时间
				busiFun.setBsfunCheckTime(new Date());
				busiFunService.updateBusiFun(busiFun);
				
				/**
				//趣事推送加入MQ,推送
				String content = busiFun.getBsfunContent();
				if(StringUtil.isEmpty(content)) {
					content = "[语音]";
				}
				if(content.length() >= 20) {
					content = content.substring(0, 17) +"...";
				}
				logger.info("begin to push BusiFun BsfunUuid:" + busiFun.getBsfunUuid() +" content:" + content);
				mqPushService.addMqMessage(1, busiFun.getBsfunUuid(), content, busiFun.getBsfunPicurl(), "", MsgType.FUN_PUSH_INFO);
				//BaiduYunPushUtil.androidPushBroadcast(BaiduYunPushUtil.generateAndroidPushContent(busiFun.getBsfunUuid(), content, BaiduYunPushUtil.psTypeMap.get(MsgType.FUN_PUSH_INFO)));
				//BaiduYunPushUtil.iosPushBroadcast(BaiduYunPushUtil.generateIosPushContent(busiFun.getBsfunUuid(), content, BaiduYunPushUtil.psTypeMap.get(MsgType.FUN_PUSH_INFO)));
				logger.info("finish to push BusiFun BsfunUuid:" + busiFun.getBsfunUuid() +" content:" + content);
				
				//趣事审核通过，通知作者,推送
				logger.info("begin to push Verify BsfunUuid:" + busiFun.getBsfunUuid() +" content:" + content);
				mqPushService.addMqMessage(0, busiFun.getBsfunUuid(), "恭喜您发布的趣事审核通过！", busiFun.getBsfunPicurl(), busiFun.getBsfunPushUser(), MsgType.FUN_VERIFY_SUCCESS);
				logger.info("finish to push Verify BsfunUuid:" + busiFun.getBsfunUuid() +" content:" + content);
				**/
			}
		}
	}

}