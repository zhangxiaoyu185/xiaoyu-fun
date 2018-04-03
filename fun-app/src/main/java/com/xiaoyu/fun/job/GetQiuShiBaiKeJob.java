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

public class GetQiuShiBaiKeJob extends QuartzJobBean{

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
		//糗事0-糗事百科：http://www.qiushibaike.com/
		Object item = redisTemplate.opsForValue().get("FUN_QIUSHIBAIKE_ITEM");
		if (item == null) {
			item = 35;
		}
		NodeList rt = GetWebUtil.getNodeList("http://www.qiushibaike.com/8hr/page/"+ item +"?s=4731632");
		String strHtml = HtmlRegexpUtil.replaceText(HtmlRegexpUtil.filterHtml(rt.toHtml(), "<span.*?</span>"));
		//String strHtml = HtmlRegexpUtil.replaceText(rt.toHtml());
		Pattern pattern = Pattern.compile("<divclass=\"articleblockuntaggedmb15\"id='?([\\w\\W]*?)'>([\\s\\S]*?)(?=</a></div></div></li></ul></div></div>)");
		Matcher matcher = pattern.matcher(strHtml);
		boolean result = matcher.find();
		BusiFun busiFun = new BusiFun();
		while (result) {
			String str1 = matcher.group();
			Pattern pattern1 = Pattern.compile("<divclass=\"content\"title=\".*?</div>");
			Matcher matcher1 = pattern1.matcher(str1);
			boolean result1 = matcher1.find();
			boolean flag = false;
			if (result1) {
				String str2 = matcher1.group().replace("</div>", "");
				str2 = str2.substring(46).trim();
				if(str2.startsWith(".")) {
					str2.substring(1).trim();
				}
				if((str2.length() > 2) && (str2.length() <= 500)) {
					busiFun = new BusiFun();
					busiFun.setBsfunContent(str2);
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
					flag = true;
					logger.info("[GetQiuShiBaiKeJob:" + busiFun.getBsfunUuid() + ":" + str2);
					//System.out.println(str2);
				}
			}
			Pattern pattern2 = Pattern.compile("<divclass=\"thumb\">.*?</div>");
			Matcher matcher2 = pattern2.matcher(str1);
			boolean result2 = matcher2.find();
			if (flag && result2) {
				String str3 = matcher2.group();
				Pattern pattern3 = Pattern.compile("<imgsrc=\".*?\"alt");
				Matcher matcher3 = pattern3.matcher(str3);
				boolean result3 = matcher3.find();
				if (result3) {
					String str4 = matcher3.group().substring(9);
					str4 = str4.substring(0, str4.lastIndexOf("alt")-1);
					ImagePostGetUtil.saveFunImageFile(busiFun.getBsfunUuid() + ".jpg", str4);
					logger.info("[GetQiuShiBaiKeJob:" + busiFun.getBsfunUuid() + ":" + str4);
					//System.out.println(str4);
				}
				busiFun.setBsfunPicurl("YES");
			}
			if (result1) {
				busiFunService.insertBusiFun(busiFun);
			}
			result = matcher.find();
		}
		if((int)item != 1) {
			redisTemplate.opsForValue().set("FUN_QIUSHIBAIKE_ITEM", (int)item - 1);
		}
	}
	
}