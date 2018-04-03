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

public class GetTuCaoJob extends QuartzJobBean{

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
		//吐槽2-吐槽网：http://www.tucao.biz/index-88.html
		Object item = redisTemplate.opsForValue().get("FUN_TUCAO_ITEM");
		if (item == null) {
			item = 88;
		}
		NodeList rt = GetWebUtil.getNodeList("http://www.tucao.biz/index-"+ item +".html");
		//String strHtml = HtmlRegexpUtil.replaceText(HtmlRegexpUtil.filterHtml(rt.toHtml(), "<span.*?</span>"));
		String strHtml = HtmlRegexpUtil.replaceText(rt.toHtml());	
		Pattern pattern = Pattern.compile("<divclass=\"content\"><p>.*?</p></div>");
		Matcher matcher = pattern.matcher(strHtml);
		boolean result = matcher.find();
		BusiFun busiFun = new BusiFun();
		while (result) {
			busiFun = new BusiFun();
			busiFun.setBsfunUuid(2 + RandomUtil.generateUpperString(31));
			String str1 = matcher.group();
			Pattern pattern1 = Pattern.compile("<p><imgsrc=\".*?\"/></p>");
			Matcher matcher1 = pattern1.matcher(str1);
			boolean result1 = matcher1.find();
			int index = 0;
			if (result1) {
				String str2 = matcher1.group().replaceAll("<p><imgsrc=\"", "").replaceAll("\"/></p>", "");
				ImagePostGetUtil.saveFunImageFile(busiFun.getBsfunUuid() + ".jpg", str2);
				logger.info("[GetTuCaoJob:" + busiFun.getBsfunUuid() + ":" + str2);
				//System.out.println(str2);
				index = str1.indexOf("</p>") + 3;
				busiFun.setBsfunPicurl("YES");
			}
			if(index < str1.length()) {
				str1 = str1.substring(index, str1.length());
				Pattern pattern2 = Pattern.compile("<p>.*?</p>");
				Matcher matcher2 = pattern2.matcher(str1);
				boolean result2 = matcher2.find();
				if (result2) {
					String str2 = matcher2.group().replaceAll("<p>", "").replaceAll("</p>", "");
					if(str2.startsWith(".")) {
						str2.substring(1).trim();
					}
					if((str2.length() > 2) && (str2.length() <= 500)) {						
						busiFun.setBsfunContent(str2);
						String[] strUuids = new String[]{"UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWA","UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWB",
								"UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWC","UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWD","UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWE",
								"AGKFMRMEDVVPGEXAUTTEFNHHPTTXYBEC","EUWVQPZSMRQJHMNPCLJLYSGBRZSHCPAB","VDOCNAALZQOQDNSMXNKSNUJRAWMQREUS","MZXGSGAWZKPURRQQOEFNIWUMCGQDFYTL"};
						Random random = new Random();
						int i = random.nextInt(9);
						busiFun.setBsfunPushUser(strUuids[i]);
						busiFun.setBsfunType(2);
						busiFun.setBsfunIntegral(5);
						busiFun.setBsfunCheckTime(new Date());						
						busiFunService.insertBusiFun(busiFun);
						logger.info("[GetTuCaoJob:" + busiFun.getBsfunUuid() + ":" + str2);
						//System.out.println(str2);
					}
				}
			}			
			result = matcher.find();
		}
		if((int)item != 1) {
			redisTemplate.opsForValue().set("FUN_TUCAO_ITEM", (int)item - 1);
		}
	}
	
}