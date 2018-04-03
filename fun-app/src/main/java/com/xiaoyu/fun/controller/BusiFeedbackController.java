package com.xiaoyu.fun.controller;

import java.util.Date;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.xiaoyu.fun.controller.BaseController;
import com.xiaoyu.fun.entity.BusiFeedback;
import com.xiaoyu.fun.entity.BusiUser;
import com.xiaoyu.fun.service.BusiFeedbackService;
import com.xiaoyu.fun.service.BusiUserService;
import com.xiaoyu.fun.util.RandomUtil;
import com.xiaoyu.fun.util.ResultMessageBuilder;

@Controller
@RequestMapping(value="/busiFeedback")
public class BusiFeedbackController extends BaseController {

//<=================定制内容开始==============
	@Autowired
	private BusiFeedbackService busiFeedbackService;
	
	@Autowired
	private BusiUserService  busiUserService;
	
	/**
	 * 添加意见反馈
	 * @return
	 */
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public void addFeedback(String bsfbkContent, String bsfbkUser, String bsfbkRelation, HttpServletResponse response) {
		logger.info("[BusiFeedbackController.addFeedback]:addFeedback begin");
		BusiFeedback busiFeedback = new BusiFeedback(bsfbkContent, bsfbkUser, bsfbkRelation);
		BusiUser user = busiUserService.getBusiUser(new BusiUser(bsfbkUser));
		if(user == null) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "该用户不存在!"), response);	
			return;
		}
		busiFeedback.setBsfbkCode(user.getBsusrCode());
		busiFeedback.setBsfbkBackTime(new Date());
		busiFeedback.setBsfbkUuid(RandomUtil.generateUpperString(32));
		busiFeedbackService.insertBusiFeedback(busiFeedback);
		
		writeAjaxJSONResponse(ResultMessageBuilder.build(true, "反馈意见成功!"), response);	     
	}
//==================定制内容结束==============>

}