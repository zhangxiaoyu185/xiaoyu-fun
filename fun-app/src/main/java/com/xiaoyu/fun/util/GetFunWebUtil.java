package com.xiaoyu.fun.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.htmlparser.util.NodeList;

public class GetFunWebUtil {

	public static List<String> getFunUrl(String strUrl) {
		List<String> strList = new ArrayList<String>();
		NodeList rt = GetWebUtil.getNodeList(strUrl);
		//String strHtml = HtmlRegexpUtil.replaceText(HtmlRegexpUtil.filterHtml(rt.toHtml(), "<span.*?</span>"));
		String strHtml = HtmlRegexpUtil.replaceText(rt.toHtml());
		Pattern pattern = Pattern.compile("<divclass=\"list_title\"><ul>.*?</ul></div>");
		Matcher matcher = pattern.matcher(strHtml);
		boolean result = matcher.find();
		if (result) {
			String str1 = matcher.group();
			Pattern pattern1 = Pattern.compile("<ahref=\".*?\"target=\"_blank\">.*?</a>");
			Matcher matcher1 = pattern1.matcher(str1);
			boolean result1 = matcher1.find();
			while (result1) {
				String str2 = matcher1.group();
				strList.add(str2);
				result1 = matcher1.find();
			}
		}
		List<String> strList1 = new ArrayList<String>();
		for(String str : strList) {
			String str1 = "http://www.jokeji.cn" + str.substring(8, str.indexOf("\"target=\"_blank\">")).replace("冷笑话", "%E5%86%B7%E7%AC%91%E8%AF%9D");
			strList1.add(str1);
			//System.out.println(str1);
		}
		return strList1;
	}
	
	public static List<String> getFunContent(String strUrls) {
		List<String> contentList = new ArrayList<String>();
		List<String> strList = getFunUrl(strUrls);
		for(String strUrl : strList) {			
			NodeList rt = GetWebUtil.getNodeList(strUrl);
			String strHtml = HtmlRegexpUtil.replaceText(rt.toHtml());
			Pattern pattern = Pattern.compile("<spanid=\"text110\">.*?</P><P><Ahref=");
			Matcher matcher = pattern.matcher(strHtml);
			boolean result = matcher.find();
			if(!result) {
				pattern = Pattern.compile("<spanid=\"text110\">.*?</span>");
				matcher = pattern.matcher(strHtml);
				result = matcher.find();
			}
			if (result) {
				String str1 = matcher.group();
				str1 = str1.replaceAll("<FONT.*?>", "").replaceAll("</FONT>", "").replaceAll("<STRONG>", "").replace("</STRONG>", "").replaceAll("<SPAN.*?>", "").replaceAll("</SPAN>", "").replaceAll("</DIV>", "").replaceAll("DIV.*?>", "").replaceAll("<IMG.*?>", "");
				Pattern pattern1 = Pattern.compile("<P>.*?</P>");
				Matcher matcher1 = pattern1.matcher(str1);
				boolean result1 = matcher1.find();
				if(!result1) {
					str1 = str1.replaceAll("</P>", "").replaceAll("<P>", "");
					str1 = str1.substring(18, str1.length() - 7).trim();
					if(str1.startsWith(".")) {
						str1 = str1.substring(1).trim();
					}
					if((str1.length() > 2) && (str1.length() <= 500)) {
						contentList.add(str1);
					}
				}
				if(result1) {
					if(str1.length() > 503) {
						while (result1) {
							String str2 = matcher1.group().replaceAll("</P>", "").replaceAll("<P>", "").trim();
							if(str2.startsWith(".")) {
								str2 = str2.substring(1).trim();
							}
							if((str2.length() > 2) && (str2.length() <= 500)) {
								contentList.add(str2);
							}
							result1 = matcher1.find();
						}
					}else {
						String str3 = "";
						while (result1) {
							String str2 = matcher1.group().replaceAll("</P>", "").replaceAll("<P>", "").trim();
							if(str2.startsWith(".")) {
								str2 = str2.substring(1).trim();
							}
							if((str2.length() > 2) && (str2.length() <= 496)) {
								str3 += str2 + "\n\n";
							}
							result1 = matcher1.find();
						}
						contentList.add(str3);
					}
				}								
			}
		}
		return contentList;
	}
	
	public static void main(String[] args) throws Exception {
		//<a\s*href="?([\w\W]*?)"?[\s]*?[^>]>([\s\S]*?)(?=</a>)
		//<div class="content" title="?([\w\W]*?)">([\s\S]*?)(?=</div>)
		Date date = new Date();
		//getFunContent("http://www.gushijiuba.com/chuanqigushi/xuanyigushi/list_18_84.html");
//		for(int i = 18654; i>18650; i--) {
//			NodeList rt = GetWebUtil.getNodeList("http://www.pengfu.com/xiaohua_"+ i +".html");
//			//String strHtml = HtmlRegexpUtil.replaceText(HtmlRegexpUtil.filterHtml(rt.toHtml(), "<span.*?</span>"));
//			String strHtml = HtmlRegexpUtil.replaceText(rt.toHtml()).replaceAll("<spanclass=\"watermark\">@捧腹网</span>", "").replaceAll("</p>", "").replaceAll("<p>", "");
//			Pattern pattern = Pattern.compile("class=\"humordatacontent\"style=\"display:none\".*?</div");
//			Matcher matcher = pattern.matcher(strHtml);
//			boolean result = matcher.find();
//			while(result) {
//				String str = matcher.group();
//				str = str.replaceAll("class=\"humordatacontent\"style=\"display:none\">", "").replaceAll("</div", "");
//				if((str.length() > 2) && (str.length() <= 500)) {
//					System.out.println(str);
//				}
//				result = matcher.find();
//			}
//		}
//		List<String> strList = GetFunWebUtil.getFunContent("http://www.jokeji.cn/list5_34.htm");
//	    for(String strContent : strList) {
//			System.out.println(strContent);
//		}
		
//		NodeList rt = GetWebUtil.getNodeList("http://www.tucao.biz/index-"+ 86 +".html");
//		String strHtml = HtmlRegexpUtil.replaceText(rt.toHtml());	
//		Pattern pattern = Pattern.compile("<divclass=\"content\"><p>.*?</p></div>");
//		Matcher matcher = pattern.matcher(strHtml);
//		boolean result = matcher.find();
//		while (result) {
//			String str1 = matcher.group();
//			Pattern pattern1 = Pattern.compile("<p><imgsrc=\".*?\"/></p>");
//			Matcher matcher1 = pattern1.matcher(str1);
//			boolean result1 = matcher1.find();
//			int index = 0;
//			if (result1) {
//				String str2 = matcher1.group().replaceAll("<p><imgsrc=\"", "").replaceAll("\"/></p>", "");
//				System.out.println(str2);
//				index = str1.indexOf("</p>") + 3;
//			}
//			if(index < str1.length()) {
//				str1 = str1.substring(index, str1.length());
//				Pattern pattern2 = Pattern.compile("<p>.*?</p>");
//				Matcher matcher2 = pattern2.matcher(str1);
//				boolean result2 = matcher2.find();
//				if (result2) {
//					String str2 = matcher2.group().replaceAll("<p>", "").replaceAll("</p>", "");
//					if(str2.startsWith(".")) {
//						str2.substring(1).trim();
//					}
//					if((str2.length() > 2) && (str2.length() <= 500)) {						
//						System.out.println(str2);
//					}
//				}
//			}			
//			result = matcher.find();
//		}
		
//		NodeList rt = GetWebUtil.getNodeList("http://baozoumanhua.com/all/day/page/"+ 1000);
//		String strHtml = HtmlRegexpUtil.replaceText(HtmlRegexpUtil.filterHtml(rt.toHtml(), "<span.*?</span>"));
//		//String strHtml = HtmlRegexpUtil.replaceText(rt.toHtml());	
//		Pattern pattern = Pattern.compile("target=\"_blank\"><imgalt=\".*?/></a>");
//		Matcher matcher = pattern.matcher(strHtml);
//		boolean result = matcher.find();
//		while (result) {			
//			String str1 = matcher.group();
//			int index = str1.indexOf("src=");
//			str1 = str1.substring(index + 5);
//			index = str1.indexOf("\"");
//			str1 = str1.substring(0, index);
//			if(!str1.contains("http://wanzao2.b0.upaiyun.com/system/avatars/0/original/missing.png")) {			
//				System.out.println(str1);
//			}
//			result = matcher.find();
//		}
		
//		NodeList rt = GetWebUtil.getNodeList("http://www.zk008.com/duanxin/lb-132-p"+ 100 +".html");
//		String strHtml = HtmlRegexpUtil.replaceText(rt.toHtml());	
//		Pattern pattern = Pattern.compile("<span>.*?</span>");
//		Matcher matcher = pattern.matcher(strHtml);
//		boolean result = matcher.find();
//		while(result) {
//			String str = matcher.group();
//			str = str.replaceAll("<span>", "").replaceAll("</span>", "");
//			if((str.length() > 2) && (str.length() <= 500)) {
//				System.out.println(str);
//			}			
//			result = matcher.find();
//		}
		
		NodeList rt = GetWebUtil.getNodeListByGB("http://www.bug.cn/h/2014-05/67373p" + 101 + ".html");
		String strHtml = HtmlRegexpUtil.replaceText(HtmlRegexpUtil.filterHtml(rt.toHtml(), "<span.*?</span>"));
		//String strHtml = HtmlRegexpUtil.replaceText(rt.toHtml());	
		Pattern pattern = Pattern.compile("<IMGalt=\"\"align=centersrc=\".*?\">");
		Matcher matcher = pattern.matcher(strHtml);
		boolean result = matcher.find();
		while (result) {
			String str1 = matcher.group();
			str1 = str1.replaceAll("<IMGalt=\"\"align=centersrc=\"../../", "").replaceAll("\">", "");
			str1 = "http://www.bug.cn/" + str1;
			System.out.println(str1);
			result = matcher.find();
		}
		Date date1 = new Date();
		System.out.println(date1.getTime() - date.getTime());
	}
	
}