package com.xiaoyu.fun.util;

public class SystemConfigUtil {

	private static SystemConfig SYSTEM_CONFIG = null;

	/**
	 * 获取系统配置
	 * 
	 * @param hospitalId
	 * @return
	 */
	public static SystemConfig getSystemConfig() {
		if (null == SYSTEM_CONFIG) {
			// 被动初始化
			SYSTEM_CONFIG = SystemConfigParser.parse();
		}

		return SYSTEM_CONFIG;
	}
}