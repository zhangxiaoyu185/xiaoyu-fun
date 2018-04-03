package com.xiaoyu.fun.util;

import java.text.MessageFormat;
import java.util.Random;

public class StringUtil {
	
	private static char[] hexDigits = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
	
	public static boolean isEmpty(String input) {
		return input == null || input.trim().isEmpty();
	}
	
	/**
	 * 把指定的数据转化为16进制格式的字符串
	 * @param data 待转化的数据
	 * @return 16进制表示的数据
	 */
	public static String toHexString(byte[] data) {
		return toHexString(data,0,data.length);
	}
	
	/**
	 * 把指定的数据转化为16进制格式的字符串，
	 * 如toHexString({8,9,12,4},1,3) = "090C"
	 * @param data 待转化的数据
	 * @param beginIndex 需转化的数据的起始索引
	 * @param endIndex 需转化的数据的结束索引
	 * @return 16进制表示的数据
	 */
	public static String toHexString(byte[] data,int beginIndex,int endIndex) {
		if (data == null || beginIndex < 0) return null;
		StringBuilder strBuilder = new StringBuilder();
		for (int i = beginIndex;i < endIndex;i++) {
			strBuilder.append(hexDigits[data[i] >>> 4 & 0xf]);
			strBuilder.append(hexDigits[data[i]& 0xf]);
		}
		return strBuilder.toString();		
	}

	
    /**
     * 使用<code>MessageFormat</code>格式化字符串.
     *
     * @param message 要格式化的字符串
     * @param params 参数表
     *
     * @return 格式化的字符串，如果message为<code>null</code>，则返回<code>null</code>
     */
    public static String formatMessage(String message, Object... params) {
        if ((message == null) || (params == null) || (params.length == 0)) {
            return message;
        }

        return MessageFormat.format(message, params);
    }

    
    /** 
     * 使用java正则表达式去掉多余的.与0 
     * @param s 
     * @return  
     */  
    public static String subZeroAndDot(String s){  
        if(s.indexOf(".") > 0){  
            s = s.replaceAll("0+?$", "");//去掉多余的0  
            s = s.replaceAll("[.]$", "");//如最后一位是.则去掉  
        }  
        return s;  
    }
    
    /**
     * 根据输入的字符串，生成指定长度的随机字符串
     * @param strPool
     * @param length
     * @return
     */
    public static String randomString(String strPool,int length) {
		if (strPool==null || length < 1) {
			return null;
		}
				
		Random randGen = new Random();
		char[] numbersAndLetters = (strPool).toCharArray();

		char[] randBuffer = new char[length];
		for (int i = 0; i < randBuffer.length; i++) {
			randBuffer[i] = numbersAndLetters[randGen.nextInt(strPool.length())];
		}
		return new String(randBuffer);
	}
}
