package com.xiaoyu.fun.controller;

import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.xiaoyu.fun.controller.BaseController;
import com.xiaoyu.fun.entity.CoreAccount;
import com.xiaoyu.fun.service.CoreAccountService;
import com.xiaoyu.fun.util.ResultMessageBuilder;

@Controller
@RequestMapping(value="/coreAccount")
public class CoreAccountController extends BaseController {

//<=================定制内容开始==============
	@Autowired
	private CoreAccountService coreAccountService;
	
	/**
	 * 登录
	 * 
	 * @param userName
	 * @param password
	 * @param response
	 */
	@RequestMapping(value = "/login/{userName}/{password}", method = RequestMethod.POST)
	public void login(@PathVariable String userName,
			@PathVariable String password, HttpServletResponse response) {
		logger.info("[CoreAccountController.login]:begin login.");
		if (StringUtils.isBlank(userName)) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "请输入昵称！"), response);
			return;
		}
		
		if (StringUtils.isBlank(password)) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "请输入密码！"), response);
			return;
		}
		
		CoreAccount coreAccount = new CoreAccount(userName, password);
		CoreAccount model = coreAccountService.getCoreAccountByNameAndPwd(coreAccount);
		if(model == null) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "昵称或密码错误，请重新输入！"), response);
			return;
		}
		writeAjaxJSONResponse(ResultMessageBuilder.build(true, "登录成功"), response);
		logger.info("[CoreAccountController.login]:end login.");
	}
//==================定制内容结束==============>

}