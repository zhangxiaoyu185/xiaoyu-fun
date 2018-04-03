package com.xiaoyu.fun.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.htmlparser.Parser;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.htmlparser.visitors.HtmlPage;

public class GetWebUtil {

	// 抓取网页源代码
	public static void catchHtml(String urlPath) throws Exception {
		URL url = new URL(urlPath);
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		InputStreamReader input = new InputStreamReader(
				httpConn.getInputStream(), "utf-8");
		BufferedReader bufReader = new BufferedReader(input);
		String line = "";
		StringBuilder contentBuf = new StringBuilder();
		while ((line = bufReader.readLine()) != null) {
			contentBuf.append(line + "\n");
		}
		String buf = contentBuf.toString();
		System.out.println(buf);
	}

	// 抓取网页部分信息 UTF-8
	public static NodeList getNodeList(String url) {
		Parser parser = null;
		HtmlPage visitor = null;
		try {
			parser = new Parser(url);
			parser.setEncoding("UTF-8");
			visitor = new HtmlPage(parser);
			parser.visitAllNodesWith(visitor);
		} catch (ParserException e) {
			e.printStackTrace();
		}
		NodeList nodeList = visitor.getBody();
		return nodeList;
	}
	
	// 抓取网页部分信息 GB2312
	public static NodeList getNodeListByGB(String url) {
		Parser parser = null;
		HtmlPage visitor = null;
		try {
			parser = new Parser(url);
			parser.setEncoding("GB2312");
			visitor = new HtmlPage(parser);
			parser.visitAllNodesWith(visitor);
		} catch (ParserException e) {
			e.printStackTrace();
		}
		NodeList nodeList = visitor.getBody();
		return nodeList;
	}
}