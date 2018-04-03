package com.xiaoyu.fun.controller;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.xiaoyu.fun.controller.BaseController;
import com.xiaoyu.fun.entity.BusiReport;
import com.xiaoyu.fun.service.BusiReportService;
import com.xiaoyu.fun.util.RandomUtil;
import com.xiaoyu.fun.util.ResultMessageBuilder;
import com.xiaoyu.fun.util.StringUtil;

@Controller
@RequestMapping(value="/busiReport")
public class BusiReportController extends BaseController {

//<=================定制内容开始==============	
	@Autowired
	private BusiReportService  busiReportService;

	/**
	 * 举报趣事
	 * @param busiReport
	 * @return
	 */
	@RequestMapping(value="/report/add", method=RequestMethod.POST)
	public void addReport(BusiReport busiReport, HttpServletResponse response) {
		logger.info("[BusiReportController.addReport]:addReport begin");
		if(StringUtil.isEmpty(busiReport.getBsretUser())) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "缺少举报人UUID！"), response);
			return;
		}
		if(StringUtil.isEmpty(busiReport.getBsretFun())) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "缺少趣事UUID!"), response);
			return;
		}
		//判断是否举报过		
		BusiReport report = busiReportService.getBusiReportByUserAndFUN(busiReport);		
		if(report != null && report.getBsretCdate() != null) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "您已举报过该趣事！"), response);
			return;
		}
		busiReport.setBsretUuid(RandomUtil.generateUpperString(32));
		busiReport.setBsretUdate(new Date());
		busiReportService.insertBusiReport(busiReport);
		writeAjaxJSONResponse(ResultMessageBuilder.build(true, "SUCCESS！"), response);
	}
//==================定制内容结束==============>

}