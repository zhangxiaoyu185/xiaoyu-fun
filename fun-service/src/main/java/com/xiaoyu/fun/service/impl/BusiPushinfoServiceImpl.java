package com.xiaoyu.fun.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import com.xiaoyu.fun.service.BusiPushinfoService;
import com.xiaoyu.fun.util.BaiduYunPushUtil;
import com.xiaoyu.fun.util.RandomUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import com.xiaoyu.fun.mybatis.dao.MyBatisDAO;
import com.xiaoyu.fun.entity.BusiPushinfo;
import com.xiaoyu.fun.enums.MsgType;

@Service("busiPushinfoService")
public class BusiPushinfoServiceImpl implements BusiPushinfoService {

	@Autowired
	private MyBatisDAO myBatisDAO;

	@Override
	public boolean insertBusiPushinfo(BusiPushinfo busiPushinfo) {
		busiPushinfo.setBspioCdate(new Date());
		busiPushinfo.setBspioUuid(RandomUtil.generateUpperString(32));
		myBatisDAO.insert(busiPushinfo);
		return true;
	}

	@Override
	public boolean updateBusiPushinfo(BusiPushinfo busiPushinfo) {
		myBatisDAO.update(busiPushinfo);
		return true;
	}

	@Override
	public boolean deleteBusiPushinfo(BusiPushinfo busiPushinfo) {
		myBatisDAO.delete(busiPushinfo);
		return true;
	}

	@Override
	public BusiPushinfo getBusiPushinfo(BusiPushinfo busiPushinfo) {
		return (BusiPushinfo) myBatisDAO.findForObject(busiPushinfo);
	}

//<=================定制内容开始==============
	private final Logger logger = LoggerFactory.getLogger("PUSH_LOGGER");
	
	private static final String GET_BUSI_PUSH_INFO_BY_USER = "getBusiPushinfoByUesr";
	
	private static final String DELETE_BUSI_PUSH_INFO_BY_USER = "deleteBusiPushinfoByUesr";
	
	private static final String SEL_ALL_BUSI_PUSH_INFO = "selAllBusiPushinfo";
	
	private final ExecutorService pushMsgService = Executors.newCachedThreadPool();

	@SuppressWarnings("unchecked")
	@Override
	public List<BusiPushinfo> getBusiPushinfo(String bspioUser) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("bspioUser", bspioUser);
		return myBatisDAO.findForList(GET_BUSI_PUSH_INFO_BY_USER, params);
	}

	@Override
	public void deleteBusiPushinfo(String bspioUser) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("bspioUser", bspioUser);
		myBatisDAO.delete(DELETE_BUSI_PUSH_INFO_BY_USER, params);
	}
	
	/**
	 * 异步广播推送
	 */
	@Override
	public void pushMsgBroadcast(final String uuid, final String title, final MsgType msgType) {
		logger.info("begin to push "+ msgType.toString() + "'{}'", title);
		pushMsgService.execute(new Runnable() {
			@Override
			public void run() {
				BaiduYunPushUtil.androidPushBroadcast(BaiduYunPushUtil.generateAndroidPushContent(uuid, title, BaiduYunPushUtil.psTypeMap.get(msgType)));
				BaiduYunPushUtil.iosPushBroadcast(BaiduYunPushUtil.generateIosPushContent(uuid, title, BaiduYunPushUtil.psTypeMap.get(msgType)));
				logger.info("广播异步推送："+title);
			}	
		});
		
		logger.info("finish to push "+ msgType.toString() + "'{}'", title);
	}
	
	@Override
	public void pushMsgUnicast(String uuid, String userUuid, String title, MsgType msgType) {
		logger.info("begin to push "+ msgType.toString() + "'{}'", title);
		List<BusiPushinfo> list= getBusiPushinfo(userUuid);
		if(!CollectionUtils.isEmpty(list)) {
			if(list.get(0).getBspioType() == 1){
				final String title1 = BaiduYunPushUtil.generateAndroidPushContent(uuid, title, BaiduYunPushUtil.psTypeMap.get(msgType));
				final long channelId = Long.valueOf(list.get(0).getBspioChannelId());
				final String deviceUserId = list.get(0).getBspioUserId();
				pushMsgService.execute(new Runnable() {
					@Override
					public void run() {
						BaiduYunPushUtil.androidPushUnicast(channelId, deviceUserId, title1);
						logger.info("android异步推送："+title1);
					}	
				});
			}
			if(list.get(0).getBspioType() == 2){
				final long channelId = Long.valueOf(list.get(0).getBspioChannelId());
				final String deviceUserId = list.get(0).getBspioUserId();
				final String title1 = BaiduYunPushUtil.generateIosPushContent(uuid, title, BaiduYunPushUtil.psTypeMap.get(msgType));
				pushMsgService.execute(new Runnable() {
					@Override
					public void run() {
						BaiduYunPushUtil.iosPushUnicast(channelId, deviceUserId, title1);
						logger.info("IOS异步推送："+title1);
					}	
				});
			}
		}
		logger.info("finish to push "+ msgType.toString() + "'{}'", title);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BusiPushinfo> selAllBusiPushinfo() {
		return myBatisDAO.findForList(SEL_ALL_BUSI_PUSH_INFO);
	}
//==================定制内容结束==============>

}