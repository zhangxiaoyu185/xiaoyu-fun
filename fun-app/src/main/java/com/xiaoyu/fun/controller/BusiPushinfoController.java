package com.xiaoyu.fun.controller;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.xiaoyu.fun.controller.BaseController;
import com.xiaoyu.fun.entity.BusiPushinfo;
import com.xiaoyu.fun.enums.MsgType;
import com.xiaoyu.fun.service.BusiPushinfoService;
import com.xiaoyu.fun.util.ResultMessageBuilder;

@Controller
@RequestMapping(value="/busiPushinfo")
public class BusiPushinfoController extends BaseController {

//<=================定制内容开始==============
	@Autowired
	private BusiPushinfoService busiPushinfoService;
	
	/**
	 * 单播推送
	 * @param userId
	 * @param content 消息内容
	 * @param msgType 消息类型
	 * @param response
	 */
	@RequestMapping(value = "/cast", method = RequestMethod.POST)
	public void pushMsgcast(String userUuid,String content, MsgType msgType, HttpServletResponse response){
		try{
			if(userUuid != null && !("").equals(userUuid)) {
				busiPushinfoService.pushMsgUnicast("", userUuid, content, msgType);
			} else {
				busiPushinfoService.pushMsgBroadcast("", content, msgType);
			}
			writeAjaxJSONResponse(
					ResultMessageBuilder.build(true, "推送成功"), response);
		}catch(Exception ex){
			writeAjaxJSONResponse(
					ResultMessageBuilder.build(false, "推送失败"), response);
		}
	}
//==================定制内容结束==============>

}