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

public class GetXiaoHuaZhongHeJob extends QuartzJobBean{

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
		//笑话1-冷笑话-校园-综合-短信笑话-夫妻-爆笑签名：
		//冷笑话:http://www.jokeji.cn/list43_41.htm
		//校园：http://www.jokeji.cn/list5_34.htm
		//综合：http://www.jokeji.cn/list27_22.htm
		//短信笑话：http://www.jokeji.cn/list36_13.htm
		//夫妻：http://www.jokeji.cn/list1_27.htm
		//爆笑签名：http://www.jokeji.cn/list40_20.htm
		List<String> strList = new ArrayList<String>();
		Object item = redisTemplate.opsForValue().get("FUN_XHZH_GAOLENG_ITEM");
		if (item == null) {
			item = 41;
		}
		if((int)item != 0) {
			strList = GetFunWebUtil.getFunContent("http://www.jokeji.cn/list43_"+ item +".htm");
			logger.info("[GetXiaoHuaZhongHeJob-GAOLENG");
			redisTemplate.opsForValue().set("FUN_XHZH_GAOLENG_ITEM", (int)item - 1);					
		}else {
			item = redisTemplate.opsForValue().get("FUN_XHZH_XIAOYUAN_ITEM");
			if (item == null) {
				item = 34;
			}
			if((int)item != 0) {
				strList = GetFunWebUtil.getFunContent("http://www.jokeji.cn/list5_"+ item +".htm");
				logger.info("[GetXiaoHuaZhongHeJob-XIAOYUAN");		
				redisTemplate.opsForValue().set("FUN_XHZH_XIAOYUAN_ITEM", (int)item - 1);
			}else {
				item = redisTemplate.opsForValue().get("FUN_XHZH_ZHONGHE_ITEM");
				if (item == null) {
					item = 22;
				}
				if((int)item != 0) {
					strList = GetFunWebUtil.getFunContent("http://www.jokeji.cn/list27_"+ item +".htm");
					logger.info("[GetXiaoHuaZhongHeJob-ZHONGHE");		
					redisTemplate.opsForValue().set("FUN_XHZH_ZHONGHE_ITEM", (int)item - 1);
				}else {
					item = redisTemplate.opsForValue().get("FUN_XHZH_DUANXIN_ITEM");
					if (item == null) {
						item = 13;
					}
					if((int)item != 0) {
						strList = GetFunWebUtil.getFunContent("http://www.jokeji.cn/list36_"+ item +".htm");
						logger.info("[GetXiaoHuaZhongHeJob-DUANXIN");		
						redisTemplate.opsForValue().set("FUN_XHZH_DUANXIN_ITEM", (int)item - 1);
					}else {
						item = redisTemplate.opsForValue().get("FUN_XHZH_FUQI_ITEM");
						if (item == null) {
							item = 27;
						}
						if((int)item != 0) {
							strList = GetFunWebUtil.getFunContent("http://www.jokeji.cn/list1_"+ item +".htm");
							logger.info("[GetXiaoHuaZhongHeJob-FUQI");		
							redisTemplate.opsForValue().set("FUN_XHZH_FUQI_ITEM", (int)item - 1);
						}else {
							item = redisTemplate.opsForValue().get("FUN_XHZH_QIANMING_ITEM");
							if (item == null) {
								item = 40;
							}
							if((int)item != 0) {
								strList = GetFunWebUtil.getFunContent("http://www.jokeji.cn/list20_"+ item +".htm");
								logger.info("[GetXiaoHuaZhongHeJob-QIANMING");		
								redisTemplate.opsForValue().set("FUN_XHZH_QIANMING_ITEM", (int)item - 1);
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