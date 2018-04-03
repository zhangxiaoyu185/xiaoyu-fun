package com.xiaoyu.fun.controller;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.xiaoyu.fun.cache.service.DataCacheService;
import com.xiaoyu.fun.controller.BaseController;
import com.xiaoyu.fun.entity.BusiAnswerquestion;
import com.xiaoyu.fun.entity.BusiQuestion;
import com.xiaoyu.fun.service.BusiAnswerquestionService;
import com.xiaoyu.fun.util.ResultMessageBuilder;
import com.xiaoyu.fun.vo.BusiAnswerquestionVO;

@Controller
@RequestMapping(value="/busiAnswerquestion")
public class BusiAnswerquestionController extends BaseController {

//<=================定制内容开始==============
	@Autowired
	private BusiAnswerquestionService  busiAnswerquestionService;
	
	@Autowired
	private DataCacheService dataCacheService;
	
	/**
	 * 更新用户的密保问题
	 * @return
	 */
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public void updateAnswerquestion(String bsaqnUser, String bsaqnQuestion, String bsaqnResult, HttpServletResponse response) {
		logger.info("[BusiAnswerquestionController.updateAnswerquestion]:updateAnswerquestion begin");
		//判断该问题是否存在
		BusiQuestion busiQuestion = dataCacheService.getSingleDataByTypeKey(BusiQuestion.class, bsaqnQuestion);
		if(busiQuestion == null) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "无该密保问题!"), response);
		    return;
		}
		BusiAnswerquestion busiAnswerquestion = new BusiAnswerquestion(bsaqnUser, bsaqnQuestion, bsaqnResult);
		//更新该用户的密保问题
		busiAnswerquestionService.updateBusiAnswerquestionByBsaqnUser(busiAnswerquestion);
		
		writeAjaxJSONResponse(ResultMessageBuilder.build(true, "更新密保问题成功!"), response);	     
	}

	/**
	 * 获取用户的密保问题
	 * @return
	 */
	@RequestMapping(value="/get", method=RequestMethod.POST)
	public void getAnswerquestion(String bsaqnUser, HttpServletResponse response) {
		logger.info("[BusiAnswerquestionController.getAnswerquestion]:getAnswerquestion begin");
		BusiAnswerquestion busiAnswerquestion = new BusiAnswerquestion(bsaqnUser, null, null);
		busiAnswerquestion = busiAnswerquestionService.getBusiAnswerquestionByBsaqnUser(busiAnswerquestion);
		BusiAnswerquestionVO vo = new BusiAnswerquestionVO();
		vo.convertPOToVO(busiAnswerquestion);
		writeAjaxJSONResponse(ResultMessageBuilder.build(true, "success!", vo), response);	     
	}
//==================定制内容结束==============>

}