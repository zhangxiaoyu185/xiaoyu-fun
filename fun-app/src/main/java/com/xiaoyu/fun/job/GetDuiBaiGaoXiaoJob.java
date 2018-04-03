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
import com.xiaoyu.fun.util.RandomUtil;

public class GetDuiBaiGaoXiaoJob extends QuartzJobBean{

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
		//对白搞笑4-指客网：http://www.zk008.com/duanxin/lb-132-p100.html
		Object item = redisTemplate.opsForValue().get("FUN_DUIBAIGAOXIAO_ITEM");
		if (item == null) {
			item = 100;
		}
		NodeList rt = GetWebUtil.getNodeList("http://www.zk008.com/duanxin/lb-132-p"+ item +".html");
		//String strHtml = HtmlRegexpUtil.replaceText(HtmlRegexpUtil.filterHtml(rt.toHtml(), "<span.*?</span>"));
		String strHtml = HtmlRegexpUtil.replaceText(rt.toHtml());	
		BusiFun busiFun = new BusiFun();
		Pattern pattern = Pattern.compile("<span>.*?</span>");
		Matcher matcher = pattern.matcher(strHtml);
		boolean result = matcher.find();
		while(result) {
			String str = matcher.group();
			str = str.replaceAll("<span>", "").replaceAll("</span>", "");
			if((str.length() > 2) && (str.length() <= 500)) {
				busiFun = new BusiFun();
				busiFun.setBsfunContent(str);
				String[] strUuids = new String[]{"UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWA","UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWB",
						"UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWC","UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWD","UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWE",
						"AGKFMRMEDVVPGEXAUTTEFNHHPTTXYBEC","EUWVQPZSMRQJHMNPCLJLYSGBRZSHCPAB","VDOCNAALZQOQDNSMXNKSNUJRAWMQREUS","MZXGSGAWZKPURRQQOEFNIWUMCGQDFYTL"};
				Random random = new Random();
				int i = random.nextInt(9);
				busiFun.setBsfunPushUser(strUuids[i]);
				busiFun.setBsfunType(4);
				busiFun.setBsfunIntegral(5);
				busiFun.setBsfunCheckTime(new Date());
				busiFun.setBsfunUuid(4 + RandomUtil.generateUpperString(31));
				busiFunService.insertBusiFun(busiFun);
				logger.info("[GetDuiBaiGaoXiaoJob:" + busiFun.getBsfunUuid() + ":" + str);
				//System.out.println(str);
			}			
			result = matcher.find();
		}
		if((int)item != 1) {
			redisTemplate.opsForValue().set("FUN_DUIBAIGAOXIAO_ITEM", (int)item - 1);
		}
	}
	
}