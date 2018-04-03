package com.xiaoyu.fun.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.xiaoyu.fun.controller.BaseController;
import com.xiaoyu.fun.entity.BusiQuestion;
import com.xiaoyu.fun.service.BusiQuestionService;
import com.xiaoyu.fun.util.ResultMessageBuilder;
import com.xiaoyu.fun.vo.BusiQuestionVO;

@Controller
@RequestMapping(value="/busiQuestion")
public class BusiQuestionController extends BaseController {

//<=================定制内容开始==============
	@Autowired
	private BusiQuestionService  busiQuestionService;
	
	/**
	 * 获取密保问题列表
	 * @return
	 */
	@RequestMapping(value="/sel", method=RequestMethod.POST)
	public void getAllSafeQuestions(HttpServletResponse response) {
		logger.info("[BusiQuestionController.getAllSafeQuestions]:getAllSafeQuestions begin");
		// 获取所有问题列表
		List<BusiQuestionVO> voList = new ArrayList<BusiQuestionVO>();
		List<BusiQuestion> list = busiQuestionService.getAllSafeQuestions();
		if (CollectionUtils.isEmpty(list)) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(true, "没有密保问题!", voList), response);
		    return;
		}
		BusiQuestionVO vo;
	    for(BusiQuestion po : list) {
	    	vo = new BusiQuestionVO();
	    	vo.convertPOToVO(po);
	    	voList.add(vo);
	    }
		
		writeAjaxJSONResponse(ResultMessageBuilder.build(true, "获取密保问题成功!", voList), response);	     
	}
//==================定制内容结束==============>

}