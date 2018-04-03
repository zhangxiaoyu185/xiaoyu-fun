package com.xiaoyu.fun.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.xiaoyu.fun.controller.BaseController;
import com.xiaoyu.fun.entity.BusiComment;
import com.xiaoyu.fun.entity.BusiUser;
import com.xiaoyu.fun.service.BusiCommentService;
import com.xiaoyu.fun.service.BusiUserService;
import com.xiaoyu.fun.util.RandomUtil;
import com.xiaoyu.fun.util.ResultMessageBuilder;
import com.xiaoyu.fun.util.StringUtil;
import com.xiaoyu.fun.vo.BusiCommentListVO;
import com.xiaoyu.fun.vo.BusiCommentVO;

@Controller
@RequestMapping(value="/busiComment")
public class BusiCommentController extends BaseController {

//<=================定制内容开始==============
	
	@Autowired
	private BusiCommentService  busiCommentService;
	
	@Autowired
	private BusiUserService  busiUserService;
	
	/**
	 * 添加评论
	 * @param busiComment
	 * @return
	 */
	@RequestMapping(value="/comment/add", method=RequestMethod.POST)
	public void addComment(BusiComment busiComment, HttpServletResponse response) {
		logger.info("[BusiCommentController.addComment]:addComment begin");
		if(StringUtil.isEmpty(busiComment.getBscotFun())) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "缺少趣事UUID!"), response);
			return;
		}
		if(StringUtil.isEmpty(busiComment.getBscotUser())) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "缺少用户UUID!"), response);
			return;
		}
		if(StringUtil.isEmpty(busiComment.getBscotContent())) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "请输入评论内容!"), response);
			return;
		}
		busiComment.setBscotTime(new Date());
		busiComment.setBscotUuid(RandomUtil.generateUpperString(32));
		busiCommentService.insertBusiComment(busiComment);
		writeAjaxJSONResponse(ResultMessageBuilder.build(true, "SUCCESS！"), response);
	}

	/**
	 * 评论列表
	 * @param
	 * @return
	 */
	@RequestMapping(value="/comment/list", method=RequestMethod.POST)
	public void findBusiCommentByFun(Integer lastId, int limit, String bscotFun, HttpServletResponse response) {
		logger.info("[BusiCommentController.findBusiCommentByFun]:findBusiCommentByFun begin");		
		if(lastId == null) {
			lastId = Integer.MAX_VALUE;
		}
		if(StringUtil.isEmpty(bscotFun)) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "缺少趣事UUID!"), response);
			return;
		}
		BusiCommentListVO busiCommentListVO = new BusiCommentListVO();		
		List<BusiComment> busiCommentList = busiCommentService.getBusiCommentByFun(lastId, limit, bscotFun);
		if(busiCommentList == null || busiCommentList.size() <= 0) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(true, "无数据！", busiCommentListVO), response);
			return;
		}
		int total = busiCommentService.getCountComment(bscotFun);
		BusiCommentVO vo = new BusiCommentVO();
		List<BusiCommentVO> voList = new ArrayList<BusiCommentVO>();
		for(BusiComment busiCommnt : busiCommentList) {
			if(busiCommnt.getBscotUnid() < lastId) {
				lastId = busiCommnt.getBscotUnid();
			}
			vo = new BusiCommentVO();
			vo.convertPOToVO(busiCommnt);
			if(busiCommnt.getBscotContent() != null) {
				if(busiCommnt.getBscotContent().length() > 100)
					vo.setBscotContent(busiCommnt.getBscotContent().substring(0, 97) + "...");
				else {
					vo.setBscotContent(busiCommnt.getBscotContent());
				}
			}
			BusiUser user = new BusiUser(busiCommnt.getBscotUser());
			user = busiUserService.getBusiUser(user);
			if(user != null) {
				vo.setBscotUserCode(user.getBsusrCode());
				vo.setBscotUserHead(user.getBsusrHeadUrl());
			}
			voList.add(vo);
		}
		busiCommentListVO.setLastId(lastId);
		busiCommentListVO.setTotal(total);
		busiCommentListVO.setVoList(voList);
		writeAjaxJSONResponse(ResultMessageBuilder.build(true, "", busiCommentListVO), response);
	}
//==================定制内容结束==============>

}