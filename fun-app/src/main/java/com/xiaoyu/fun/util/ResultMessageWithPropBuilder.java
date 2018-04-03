package com.xiaoyu.fun.util;

import java.text.MessageFormat;

public class ResultMessageWithPropBuilder extends ResultMessageBuilder {
	
	public static ResultMessage buildWithProp(boolean success, String key, Object[] dataArr) {
		String message = OutputMessageUtil.getProperty(key);
		if (null != dataArr) {
			message = new MessageFormat(message).format(dataArr);
		}
		
		return new ResultMessage(success, message);
	}
	
}
