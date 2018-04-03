package com.xiaoyu.fun.service;

import java.io.IOException;

public interface AnalysisService {
	
	/**
	 * 按天查看各模块的访问量
	 * @param daytime
	 * @return
	 * @throws IOException
	 */
	public String  analysisByDay(String daytime) throws IOException;
	
	/**
	 * 按月查询各模块的访问量
	 * @param monthtime
	 * @return
	 * @throws IOException
	 */
	public String analyByMonth(String monthtime) throws IOException;
	
	/**
	 * 按月查询版本统计
	 * @param monthtime
	 * @return
	 * @throws IOException
	 */
	public String findVersionByMonth(String monthtime) throws IOException;
	
}