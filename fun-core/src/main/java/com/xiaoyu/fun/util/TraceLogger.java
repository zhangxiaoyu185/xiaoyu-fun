package com.xiaoyu.fun.util;

import org.apache.log4j.Logger;

public class TraceLogger {

	private Logger logger;

	public TraceLogger(Class<?> user) {
		logger = Logger.getLogger(user);
	}

	public void printDebug(Object msg) {
		if (logger.isDebugEnabled())
			logger.debug(msg);
	}

	public void printInfo(Object msg) {
		if (logger.isInfoEnabled())
			logger.info(msg);
	}
	
	public void printWarn(Object msg){
		logger.warn(msg);
	}

	public void printError(Object msg) {
		logger.error(msg);
	}
}