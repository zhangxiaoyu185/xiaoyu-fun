package com.xiaoyu.fun.job;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.quartz.QuartzJobBean;
import com.xiaoyu.fun.entity.BusiFun;
import com.xiaoyu.fun.service.BusiFunService;
import com.xiaoyu.fun.util.GetFunWebUtil;
import com.xiaoyu.fun.util.RandomUtil;

public class GetXiaoHuaBaoXiaoJob extends QuartzJobBean{

	private final Logger logger = LoggerFactory.getLogger("BASE_LOGGER");
	
	private BusiFunService  busiFunService;
	
	private RedisTemplate<Object,Object> redisTemplate;
	
	public void setBusiFunService(BusiFunService busiFunService) {
		this.busiFunService = busiFunService;
	}

	public void setRedisTemplate(RedisTemplate<Object, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
	
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		//笑话1-爆笑男女-儿童-家庭-动物-社会-职场：
		//爆笑男女:http://www.jokeji.cn/list29_65.htm
		//儿童：http://www.jokeji.cn/list7_24.htm
		//家庭：http://www.jokeji.cn/list4_18.htm
		//动物：http://www.jokeji.cn/list12_15.htm
		//社会：http://www.jokeji.cn/list13_42.htm
		//职场：http://www.jokeji.cn/list16_15.htm
		List<String> strList = new ArrayList<String>();
		Object item = redisTemplate.opsForValue().get("FUN_XHZH_NANNV_ITEM");
		if (item == null) {
			item = 65;
		}
		if((int)item != 0) {
			strList = GetFunWebUtil.getFunContent("http://www.jokeji.cn/list29_"+ item +".htm");
			logger.info("[GetXiaoHuaBaoXiaoJob-NANNV");
			redisTemplate.opsForValue().set("FUN_XHZH_NANNV_ITEM", (int)item - 1);					
		}else {
			item = redisTemplate.opsForValue().get("FUN_XHZH_ERTONG_ITEM");
			if (item == null) {
				item = 24;
			}
			if((int)item != 0) {
				strList = GetFunWebUtil.getFunContent("http://www.jokeji.cn/list7_"+ item +".htm");
				logger.info("[GetXiaoHuaBaoXiaoJob-ERTONG");		
				redisTemplate.opsForValue().set("FUN_XHZH_ERTONG_ITEM", (int)item - 1);
			}else {
				item = redisTemplate.opsForValue().get("FUN_XHZH_JIATING_ITEM");
				if (item == null) {
					item = 18;
				}
				if((int)item != 0) {
					strList = GetFunWebUtil.getFunContent("http://www.jokeji.cn/list4_"+ item +".htm");
					logger.info("[GetXiaoHuaBaoXiaoJob-JIATING");		
					redisTemplate.opsForValue().set("FUN_XHZH_JIATING_ITEM", (int)item - 1);
				}else {
					item = redisTemplate.opsForValue().get("FUN_XHZH_DONGWU_ITEM");
					if (item == null) {
						item = 15;
					}
					if((int)item != 0) {
						strList = GetFunWebUtil.getFunContent("http://www.jokeji.cn/list12_"+ item +".htm");
						logger.info("[GetXiaoHuaBaoXiaoJob-DONGWU");		
						redisTemplate.opsForValue().set("FUN_XHZH_DONGWU_ITEM", (int)item - 1);
					}else {
						item = redisTemplate.opsForValue().get("FUN_XHZH_SHEHUI_ITEM");
						if (item == null) {
							item = 42;
						}
						if((int)item != 0) {
							strList = GetFunWebUtil.getFunContent("http://www.jokeji.cn/list13_"+ item +".htm");
							logger.info("[GetXiaoHuaBaoXiaoJob-SHEHUI");		
							redisTemplate.opsForValue().set("FUN_XHZH_SHEHUI_ITEM", (int)item - 1);
						}else {
							item = redisTemplate.opsForValue().get("FUN_XHZH_ZHICHANG_ITEM");
							if (item == null) {
								item = 15;
							}
							if((int)item != 0) {
								strList = GetFunWebUtil.getFunContent("http://www.jokeji.cn/list16_"+ item +".htm");
								logger.info("[GetXiaoHuaBaoXiaoJob-ZHICHANG");		
								redisTemplate.opsForValue().set("FUN_XHZH_ZHICHANG_ITEM", (int)item - 1);
							}
						}
					}
				}
			}
			
		}
		BusiFun busiFun = new BusiFun();
		for(String strContent : strList) {
			busiFun = new BusiFun();
			busiFun.setBsfunContent(strContent);
			String[] strUuids = new String[]{"UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWA","UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWB",
					"UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWC","UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWD","UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWE",
					"AGKFMRMEDVVPGEXAUTTEFNHHPTTXYBEC","EUWVQPZSMRQJHMNPCLJLYSGBRZSHCPAB","VDOCNAALZQOQDNSMXNKSNUJRAWMQREUS","MZXGSGAWZKPURRQQOEFNIWUMCGQDFYTL"};
			Random random = new Random();
			int i = random.nextInt(9);
			busiFun.setBsfunPushUser(strUuids[i]);
			busiFun.setBsfunType(1);
			busiFun.setBsfunIntegral(5);
			busiFun.setBsfunCheckTime(new Date());
			busiFun.setBsfunUuid(1 + RandomUtil.generateUpperString(31));
			busiFunService.insertBusiFun(busiFun);			
		}		
	}
	
}