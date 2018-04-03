package com.xiaoyu.fun.util;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

public class AnalyzerUtil {

	/**
	 * 把字符串进行切分，返回String类型链表
	 *
	 * @param srcStr
	 *            源字符串
	 * @param useSmart
	 *            是否使用智能切分(true:智能切分；false:最细粒度切分)
	 * @return List<String>
	 * 			      字符串结果链表
	 * @throws IOException
	 */
	public static List<String> getStrList(String srcStr, boolean useSmart) {


		if(null != srcStr){
			TraceLogger logger = new TraceLogger(AnalyzerUtil.class);

			StringReader reader = new StringReader(srcStr);
			IKSegmenter seg = new IKSegmenter(reader, useSmart);
			List<String> list = new ArrayList<String>();
			try {
				Lexeme lexeme = seg.next();

				while (lexeme != null) {
					list.add(lexeme.getLexemeText());
					lexeme = seg.next();
				}
			} catch (Exception e) {
				e.printStackTrace();
				logger.printError("Errors occured while lexeme analyzer were analysing...");
				throw new RuntimeException("Errors occured while lexeme analyzer were analysing...");
			}

			return (list.size() == 0 ? null : list);
		}

		return null;
	}

	/**
	 * 把字符串进行切分，返回字符串数组
	 *
	 * @param srcStr
	 *            源字符串
	 * @param useSmart
	 *            是否使用智能切分(true:智能切分；false:最细粒度切分)
	 * @return String[]
	 * 			      字符串结果数组
	 * @throws IOException
	 */
	public static String[] getStrArray(String srcStr, boolean useSmart) {

		if(null != srcStr){
			TraceLogger logger = new TraceLogger(AnalyzerUtil.class);

			StringReader reader = new StringReader(srcStr);
			IKSegmenter seg = new IKSegmenter(reader, useSmart);
			List<String> list = new ArrayList<String>();
			String[] array = null;
			try {
				Lexeme lexeme = seg.next();
				while (lexeme != null) {
					list.add(lexeme.getLexemeText());
					lexeme = seg.next();
				}
				array = list.toArray(new String[0]);
			} catch (Exception e) {
				e.printStackTrace();
				logger.printError("Errors occured while lexeme analyzer were analysing...");
				throw new RuntimeException("Errors occured while lexeme analyzer were analysing...");
			}

			return ((array == null ||array.length == 0)? null : array);
		}
		return null;

	}
}