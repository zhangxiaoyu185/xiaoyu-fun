package com.xiaoyu.fun.job;

import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.htmlparser.util.NodeList;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.quartz.QuartzJobBean;
import com.xiaoyu.fun.entity.BusiFun;
import com.xiaoyu.fun.service.BusiFunService;
import com.xiaoyu.fun.util.GetWebUtil;
import com.xiaoyu.fun.util.HtmlRegexpUtil;
import com.xiaoyu.fun.util.ImagePostGetUtil;
import com.xiaoyu.fun.util.RandomUtil;

public class GetBaoManJob extends QuartzJobBean{

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
		//暴漫3-暴走漫画：http://baozoumanhua.com/all/day/page/1000
		Object item = redisTemplate.opsForValue().get("FUN_BAOMAN_ITEM");
		if (item == null) {
			item = 1000;
		}
		NodeList rt = GetWebUtil.getNodeList("http://baozoumanhua.com/all/day/page/"+ item);
		String strHtml = HtmlRegexpUtil.replaceText(HtmlRegexpUtil.filterHtml(rt.toHtml(), "<span.*?</span>"));
		//String strHtml = HtmlRegexpUtil.replaceText(rt.toHtml());	
		Pattern pattern = Pattern.compile("target=\"_blank\"><imgalt=\".*?/></a>");
		Matcher matcher = pattern.matcher(strHtml);
		boolean result = matcher.find();
		BusiFun busiFun = new BusiFun();
		while (result) {
			busiFun = new BusiFun();
			busiFun.setBsfunUuid(3 + RandomUtil.generateUpperString(31));
			String str1 = matcher.group();
			int index = str1.indexOf("src=");
			str1 = str1.substring(index + 5);
			index = str1.indexOf("\"");
			str1 = str1.substring(0, index);
			if(!str1.contains("http://wanzao2.b0.upaiyun.com/system/avatars/0/original/missing.png")) {			
				ImagePostGetUtil.saveFunImageFile(busiFun.getBsfunUuid() + ".jpg", str1);
				logger.info("[GetBaoManJob:" + busiFun.getBsfunUuid() + ":" + str1);
				//System.out.println(str1);		
				busiFun.setBsfunContent("");
				String[] strUuids = new String[]{"UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWA","UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWB",
						"UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWC","UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWD","UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWE",
						"AGKFMRMEDVVPGEXAUTTEFNHHPTTXYBEC","EUWVQPZSMRQJHMNPCLJLYSGBRZSHCPAB","VDOCNAALZQOQDNSMXNKSNUJRAWMQREUS","MZXGSGAWZKPURRQQOEFNIWUMCGQDFYTL"};
				Random random = new Random();
				int i = random.nextInt(9);
				busiFun.setBsfunPushUser(strUuids[i]);
				busiFun.setBsfunType(3);
				busiFun.setBsfunPicurl("YES");
				busiFun.setBsfunIntegral(5);
				busiFun.setBsfunCheckTime(new Date());						
				busiFunService.insertBusiFun(busiFun);
				logger.info("[GetBaoManJob:" + busiFun.getBsfunUuid() + ":" + str1);
				//System.out.println(str1);
			}
			result = matcher.find();
		}
		if((int)item != 1) {
			redisTemplate.opsForValue().set("FUN_BAOMAN_ITEM", (int)item - 1);
		}
	}
	
}