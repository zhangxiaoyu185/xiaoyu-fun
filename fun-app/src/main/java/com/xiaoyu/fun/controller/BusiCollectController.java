package com.xiaoyu.fun.controller;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.xiaoyu.fun.controller.BaseController;
import com.xiaoyu.fun.entity.BusiCollect;
import com.xiaoyu.fun.service.BusiCollectService;
import com.xiaoyu.fun.util.RandomUtil;
import com.xiaoyu.fun.util.ResultMessageBuilder;
import com.xiaoyu.fun.util.StringUtil;

@Controller
@RequestMapping(value="/busiCollect")
public class BusiCollectController extends BaseController {

//<=================定制内容开始==============
	@Autowired
	private BusiCollectService  busiCollectService;

	/**
	 * 收藏趣事
	 * @param busiCollect
	 * @return
	 */
	@RequestMapping(value="/collect/add", method=RequestMethod.POST)
	public void addCollect(BusiCollect busiCollect, HttpServletResponse response) {
		logger.info("[BusiCollectController.addCollect]:addCollect begin");
		if(StringUtil.isEmpty(busiCollect.getBscltUser())) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "缺少收藏人UUID！"), response);
			return;
		}
		if(StringUtil.isEmpty(busiCollect.getBscltFun())) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "缺少趣事UUID!"), response);
			return;
		}
		//判断是否收藏过
		BusiCollect collect = busiCollectService.getBusiCollectByUserAndFUN(busiCollect);
		if(collect != null && collect.getBscltTime() != null) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "您已收藏过该趣事！"), response);
			return;
		}
		busiCollect.setBscltTime(new Date());
		busiCollect.setBscltUuid(RandomUtil.generateUpperString(32));
		busiCollectService.insertBusiCollect(busiCollect);
		writeAjaxJSONResponse(ResultMessageBuilder.build(true, "SUCCESS！"), response);
	}
	
	/**
	 * 取消收藏
	 * @param busiCollect
	 * @return
	 */
	@RequestMapping(value="/collect/cancel", method=RequestMethod.POST)
	public void cancelCollect(String bscltFun, String bscltUser, HttpServletResponse response) {
		logger.info("[BusiCollectController.cancelCollect]:cancelCollect begin");
		if(StringUtil.isEmpty(bscltUser)) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "缺少收藏人UUID！"), response);
			return;
		}
		if(StringUtil.isEmpty(bscltFun)) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "缺少趣事UUID!"), response);
			return;
		}
		busiCollectService.deleteBusiCollectByFunAndUser(bscltFun, bscltUser);
		writeAjaxJSONResponse(ResultMessageBuilder.build(true, "SUCCESS！"), response);
	}
//==================定制内容结束==============>

}