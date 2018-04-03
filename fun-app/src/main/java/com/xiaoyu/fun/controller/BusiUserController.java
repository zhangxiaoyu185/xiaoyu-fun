package com.xiaoyu.fun.controller;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.xiaoyu.fun.controller.BaseController;
import com.xiaoyu.fun.entity.BusiAnswerquestion;
import com.xiaoyu.fun.entity.BusiUser;
import com.xiaoyu.fun.service.BusiAnswerquestionService;
import com.xiaoyu.fun.service.BusiUserService;
import com.xiaoyu.fun.util.RandomUtil;
import com.xiaoyu.fun.util.ResultMessageBuilder;
import com.xiaoyu.fun.vo.BusiUserVO;

@Controller
@RequestMapping(value="/busiUser")
public class BusiUserController extends BaseController {

//<=================定制内容开始==============
	@Autowired
	private BusiUserService  busiUserService;
	
	@Autowired
	private BusiAnswerquestionService  busiAnswerquestionService;
	
	/**
	 * 用户注册
	 * @return
	 */
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public void register(String bsusrCode, String bsusrPwd, String confirmPwd, String bsaqnQuestion, String bsaqnResult, String version, HttpServletRequest request, HttpServletResponse response) {
		logger.info("[BusiUserController.register]:register begin");
		analysisLogger.info("version:" + version);
		if (StringUtils.isBlank(bsusrCode)) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "请输入昵称！"), response);
			return;
		}
		
		if (StringUtils.isBlank(bsusrPwd)) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "请输入密码！"), response);
			return;
		}

		if (StringUtils.isBlank(confirmPwd)) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "请输入确认密码！"), response);
			return;
		}

		if (StringUtils.isBlank(bsaqnResult)) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "请输入密保问题答案！"), response);
			return;
		}
		
		if (!bsusrPwd.equals(confirmPwd)) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "密码输入不一致！"), response);
			return;
		}
		BusiUser busiUser = new BusiUser(bsusrCode, null);
		if(busiUserService.getBusiUserByCodeAndPwdAndPhone(busiUser) != null) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "该昵称已存在，请重新输入！"), response);
			return;
		}
		busiUser.setBsusrPwd(bsusrPwd);
		busiUser.setBsusrUuid(RandomUtil.generateUpperString(32));
		busiUser.setBsusrCount(0);
		busiUserService.insertBusiUser(busiUser);
		//添加密保问题
		BusiAnswerquestion answer = new BusiAnswerquestion(busiUser.getBsusrUuid(), bsaqnQuestion, bsaqnResult);
		answer.setBsaqnUuid(RandomUtil.generateUpperString(32));
		busiAnswerquestionService.insertBusiAnswerquestion(answer);
		
		//super.removeSession(request);
		//super.setSession(request, bsusrCode);
		
		BusiUserVO vo = new BusiUserVO();
		vo.convertPOToVO(busiUser);
		writeAjaxJSONResponse(ResultMessageBuilder.build(true, "注册成功！", vo), response);
	}

	/**
	 * 用户登录
	 * @return
	 */
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public void login(String bsusrCode, String bsusrPwd, String version, HttpServletRequest request, HttpServletResponse response) {
		logger.info("[BusiUserController.login]:login begin");
		analysisLogger.info("version:" + version);
		if (StringUtils.isBlank(bsusrCode)) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "请输入昵称！"), response);
			return;
		}
		
		if (StringUtils.isBlank(bsusrPwd)) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "请输入密码！"), response);
			return;
		}
		
		BusiUser busiUser = new BusiUser(bsusrCode, bsusrPwd);
		BusiUser model = busiUserService.getBusiUserByCodeAndPwdAndPhone(busiUser);
		if(model == null) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "昵称或密码错误，请重新输入！"), response);
			return;
		}
		busiUserService.updateBusiUserByLogin(model);
		BusiUserVO vo = new BusiUserVO();
		vo.convertPOToVO(model);
		//super.removeSession(request);
		//super.setSession(request, bsusrCode);
		writeAjaxJSONResponse(ResultMessageBuilder.build(true, "登录成功！", vo), response);
	}
	
	/**
	 * 登出
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public void logout(HttpServletRequest request, HttpServletResponse response){
		logger.info("[BusiUserController.logout]:logout begin");
		//request.getSession().invalidate();
		writeAjaxJSONResponse(ResultMessageBuilder.build(true, "success!"), response);
	}
	
	/**
	 * 忘记密码
	 * @return
	 */
	@RequestMapping(value="/forget/pwd", method=RequestMethod.POST)
	public void forgetPwd(String bsusrCode, String newPwd, String confirmPwd, String bsaqnQuestion, String bsaqnResult, HttpServletResponse response) {
		logger.info("[BusiUserController.forgetPwd]:forgetPwd begin");
		if (StringUtils.isBlank(bsusrCode)) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "请输入用户昵称！"), response);
			return;
		}
		
		if (StringUtils.isBlank(newPwd)) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "请输入新密码！"), response);
			return;
		}
		
		if (StringUtils.isBlank(confirmPwd)) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "请输入确认密码！"), response);
			return;
		}

		if (StringUtils.isBlank(bsaqnResult)) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "请输入密保问题答案！"), response);
			return;
		}
		
		if (!newPwd.equals(confirmPwd)) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "密码输入不一致！"), response);
			return;
		}
		//根据昵称查找UUID
		BusiUser busiUser = new BusiUser(bsusrCode, null);
		BusiUser user = busiUserService.getBusiUserByCodeAndPwdAndPhone(busiUser);
		if(user == null) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "该用户不存在，请重新输入！"), response);
			return;
		}
		//判断密保问题是否成功
		BusiAnswerquestion answer = new BusiAnswerquestion(user.getBsusrUuid(), bsaqnQuestion, bsaqnResult);
		BusiAnswerquestion model = busiAnswerquestionService.getBusiAnswerquestionByBsaqnUser(answer);
		if(model == null) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "密保问题验证失败！"), response);
			return;
		}else {
			if((!bsaqnQuestion.equals(model.getBsaqnQuestion())) || (!bsaqnResult.equals(model.getBsaqnResult()))) {
				writeAjaxJSONResponse(ResultMessageBuilder.build(false, "密保问题验证失败！"), response);
				return;
			}
		}
		busiUser.setBsusrUuid(user.getBsusrUuid());
		busiUser.setBsusrPwd(newPwd);
		busiUser.setBsusrUdate(new Date());
		busiUserService.updateBusiUser(busiUser);
		writeAjaxJSONResponse(ResultMessageBuilder.build(true, "忘记密码更新成功！"), response);
	}
	
	/**
	 * 修改密码
	 * @return
	 */
	@RequestMapping(value="/update/pwd", method=RequestMethod.POST)
	public void updatePwd(String bsusrUuid, String oldPwd, String newPwd, String confirmPwd, HttpServletRequest request, HttpServletResponse response) {
		logger.info("[BusiUserController.updatePwd]:updatePwd begin");
		//if (isSession(request)) {
    	//	writeAjaxJSONResponse(ResultMessageBuilder.build(false, SESSION_TIMEOUTCODE, "您的操作已过时，请重新登录"), response);
		//	return;
		//}
		
		if (StringUtils.isBlank(bsusrUuid)) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "请输入用户编号！"), response);
			return;
		}
		
		if (StringUtils.isBlank(oldPwd)) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "请输入旧密码！"), response);
			return;
		}
		
		if (StringUtils.isBlank(newPwd)) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "请输入新密码！"), response);
			return;
		}
		
		if (StringUtils.isBlank(confirmPwd)) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "请输入确认密码！"), response);
			return;
		}
		
		if (!newPwd.equals(confirmPwd)) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "密码输入不一致！"), response);
			return;
		}
		
		BusiUser oldBusiUser = new BusiUser();
		oldBusiUser.setBsusrUuid(bsusrUuid);
		BusiUser model = busiUserService.getBusiUser(oldBusiUser);
		if(model == null || !(oldPwd).equals(model.getBsusrPwd())) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "原密码错误！"), response);
			return;
		}
		
		BusiUser busiUser = new BusiUser();
		busiUser.setBsusrUuid(bsusrUuid);
		busiUser.setBsusrPwd(newPwd);
		busiUser.setBsusrUdate(new Date());
		busiUserService.updateBusiUser(busiUser);
		writeAjaxJSONResponse(ResultMessageBuilder.build(true, "修改密码成功！"), response);
	}
	
	/**
	 * 更新个人信息
	 * @return
	 */
	@RequestMapping(value="/update/user/info", method=RequestMethod.POST)
	public void updateUesrInfo(String bsusrUuid, String bsusrCode, String bsusrSignature, String bsusrBirthday, Integer bsusrSex, String bsusrHobby, String bsusrCity, String bsusrHeadUrl, String bsusrPersonalNote, String bsusrPhone, HttpServletRequest request, HttpServletResponse response) {
		logger.info("[BusiUserController.updateUesrInfo]:updateUesrInfo begin");
		if (StringUtils.isBlank(bsusrUuid)) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "缺少bsusrUuid参数！"), response);
			return;
		}
		if (StringUtils.isBlank(bsusrCode)) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "请输入昵称！"), response);
			return;
		}
		BusiUser newbusiUser = new BusiUser(bsusrUuid);
		newbusiUser = busiUserService.getBusiUser(newbusiUser);
		if(!newbusiUser.getBsusrCode().equals(bsusrCode)) {
			newbusiUser = new BusiUser(bsusrCode, null);
			if(busiUserService.getBusiUserByCodeAndPwdAndPhone(newbusiUser) != null) {
				writeAjaxJSONResponse(ResultMessageBuilder.build(false, "该昵称已存在，请重新输入！"), response);
				return;
			}
		}
		if(bsusrSex == null) {
			bsusrSex = 0;
		}
		BusiUser busiUser = new BusiUser();
		busiUser.setBsusrUuid(bsusrUuid);
		busiUser.setBsusrCode(bsusrCode);
		busiUser.setBsusrSignature(bsusrSignature);
		busiUser.setBsusrBirthday(bsusrBirthday);
		busiUser.setBsusrSex(bsusrSex);
		busiUser.setBsusrHobby(bsusrHobby);
		busiUser.setBsusrCity(bsusrCity);
		busiUser.setBsusrHeadUrl(bsusrHeadUrl);
		busiUser.setBsusrPersonalNote(bsusrPersonalNote);
		busiUser.setBsusrPhone(bsusrPhone);
		busiUser.setBsusrUdate(new Date());
		busiUserService.updateBusiUser(busiUser);
		busiUser = busiUserService.getBusiUser(busiUser);
		BusiUserVO vo = new BusiUserVO();
		vo.convertPOToVO(busiUser);
		writeAjaxJSONResponse(ResultMessageBuilder.build(true, "更新个人信息成功！", vo), response);
	}
	
	/**
	 * 查询个人信息
	 * @return
	 */
	@RequestMapping(value="/find/user/info", method=RequestMethod.POST)
	public void findUesrInfo(String bsusrUuid, HttpServletResponse response) {
		logger.info("[BusiUserController.findUesrInfo]:findUesrInfo begin");
		BusiUser busiUser = busiUserService.getBusiUser(new BusiUser(bsusrUuid));
		BusiUserVO vo = new BusiUserVO();
		vo.convertPOToVO(busiUser);
		writeAjaxJSONResponse(ResultMessageBuilder.build(true, "查询个人信息成功！", vo), response);		
	}
//==================定制内容结束==============>

}