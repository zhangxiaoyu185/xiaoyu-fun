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

public class GetQiuShiPengFuJob extends QuartzJobBean{

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
		//糗事0-捧腹网：http://www.pengfu.com/xiaohua_18654.html
		Object item = redisTemplate.opsForValue().get("FUN_QIUSHIPENGFU_ITEM");
		if (item == null) {
			item = 18654;
		}
		if((int)item == 0) {
			return;
		}
		NodeList rt = GetWebUtil.getNodeList("http://www.pengfu.com/xiaohua_"+ item +".html");
		//String strHtml = HtmlRegexpUtil.replaceText(HtmlRegexpUtil.filterHtml(rt.toHtml(), "<span.*?</span>"));
		String strHtml = HtmlRegexpUtil.replaceText(rt.toHtml()).replaceAll("<spanclass=\"watermark\">@捧腹网</span>", "").replaceAll("</p>", "").replaceAll("<p>", "");	
		BusiFun busiFun = new BusiFun();
		Pattern pattern = Pattern.compile("class=\"humordatacontent\"style=\"display:none\".*?</div");
		Matcher matcher = pattern.matcher(strHtml);
		boolean result = matcher.find();
		while(result) {
			String str = matcher.group();
			str = str.replaceAll("class=\"humordatacontent\"style=\"display:none\">", "").replaceAll("</div", "");
			if((str.length() > 2) && (str.length() <= 500)) {
				busiFun = new BusiFun();
				busiFun.setBsfunContent(str);
				String[] strUuids = new String[]{"UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWA","UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWB",
						"UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWC","UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWD","UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWE",
						"AGKFMRMEDVVPGEXAUTTEFNHHPTTXYBEC","EUWVQPZSMRQJHMNPCLJLYSGBRZSHCPAB","VDOCNAALZQOQDNSMXNKSNUJRAWMQREUS","MZXGSGAWZKPURRQQOEFNIWUMCGQDFYTL"};
				Random random = new Random();
				int i = random.nextInt(9);
				busiFun.setBsfunPushUser(strUuids[i]);
				busiFun.setBsfunType(0);
				busiFun.setBsfunIntegral(5);
				busiFun.setBsfunCheckTime(new Date());
				busiFun.setBsfunUuid(0 + RandomUtil.generateUpperString(31));
				busiFunService.insertBusiFun(busiFun);
				logger.info("[GetQiuShiPengFuJob:" + busiFun.getBsfunUuid() + ":" + str);
				//System.out.println(str);
			}			
			result = matcher.find();
		}
		redisTemplate.opsForValue().set("FUN_QIUSHIPENGFU_ITEM", (int)item - 1);
	}
	
}