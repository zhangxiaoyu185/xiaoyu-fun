package com.xiaoyu.fun.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class FunFilter implements Filter {
	
	/**
	 * 性能分析统计
	 */
	protected final org.apache.log4j.Logger analysis_logger = org.apache.log4j.Logger.getLogger("ANALYSIS_LOGGER");
	
	public void destroy() {
	}

	public void doFilter(ServletRequest sReq, ServletResponse sRes,FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) sReq;		
		analysis_logger.info(request.getRequestURI());
		chain.doFilter(sReq, sRes);
	}

	public void init(FilterConfig arg0) throws ServletException {
	}
}
