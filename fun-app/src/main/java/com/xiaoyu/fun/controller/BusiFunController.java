package com.xiaoyu.fun.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.xiaoyu.fun.controller.BaseController;
import com.xiaoyu.fun.entity.BusiFun;
import com.xiaoyu.fun.entity.BusiUser;
import com.xiaoyu.fun.service.BusiFunService;
import com.xiaoyu.fun.service.BusiUserService;
import com.xiaoyu.fun.util.RandomUtil;
import com.xiaoyu.fun.util.ResultMessageBuilder;
import com.xiaoyu.fun.util.StringUtil;
import com.xiaoyu.fun.vo.BusiFunListVO;
import com.xiaoyu.fun.vo.BusiFunVO;

@Controller
@RequestMapping(value="/busiFun")
public class BusiFunController extends BaseController {

//<=================定制内容开始==============

	@Autowired
	private BusiFunService  busiFunService;
	
	@Autowired
	private BusiUserService  busiUserService;
	
	/**
	 * 趣事内容列表（最新/热门）
	 * @param sortBy 默认、1:最新 2:热门
	 * @return
	 */
	@RequestMapping(value="/content/list", method=RequestMethod.POST)
	public void findContentList(Integer lastId, Integer sortBy, Integer type, int limit, HttpServletResponse response) {
		logger.info("[BusiFunController.findContentList]:findContentList begin");
		if(lastId == null) {
			lastId = Integer.MAX_VALUE;
		}
		if(type == null) {
			type = 0;
		}
		if(sortBy == null) {
			sortBy = 1;
		}
		BusiFunListVO busiFunListVO = new BusiFunListVO();
		List<BusiFun> busiFunList = busiFunService.getBusiFunByLastId(lastId, sortBy, type, limit, null);
		if(busiFunList == null || busiFunList.size() <= 0) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(true, "无数据！", busiFunListVO), response);
			return;
		}
		BusiFunVO vo = new BusiFunVO();
		List<BusiFunVO> voList = new ArrayList<BusiFunVO>();
		for(BusiFun busiFun : busiFunList) {
			if(busiFun.getBsfunUnid() < lastId) {
				lastId = busiFun.getBsfunUnid();
			}
			vo = new BusiFunVO();
			vo.convertPOToVO(busiFun);
			if(busiFun.getBsfunContent() != null) {
				if(busiFun.getBsfunContent().length() > 100)
					vo.setBsfunContent(busiFun.getBsfunContent().substring(0, 97) + "...");
				else {
					vo.setBsfunContent(busiFun.getBsfunContent());
				}
			}
			BusiUser user = new BusiUser(busiFun.getBsfunPushUser());
			user = busiUserService.getBusiUser(user);
			if(user != null) {
				vo.setBsfunPushUserCode(user.getBsusrCode());
				vo.setBsfunPushUserHead(user.getBsusrHeadUrl());
			}
			voList.add(vo);
		}
		busiFunListVO.setLastId(lastId);
		busiFunListVO.setVoList(voList);
		writeAjaxJSONResponse(ResultMessageBuilder.build(true, "", busiFunListVO), response);
	}

	/**
	 * 趣事详情
	 * @param bsfunUuid
	 * @return
	 */
	@RequestMapping(value="/content/detail", method=RequestMethod.POST)
	public void findContentDetail(String bsfunUuid, HttpServletResponse response) {
		logger.info("[BusiFunController.findContentDetail]:findContentDetail begin");
		if(StringUtil.isEmpty(bsfunUuid)) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "缺少bsfunUuid参数！"), response);
			return;
		}
		BusiFun busiFun = new BusiFun(bsfunUuid);
		busiFun = busiFunService.getBusiFun(busiFun);
		if(busiFun == null) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "无该趣事详情！"), response);
			return;
		}
		BusiFunVO vo = new BusiFunVO();
		vo.convertPOToVO(busiFun);
		vo.setBsfunContent(busiFun.getBsfunContent());
		BusiUser user = new BusiUser(busiFun.getBsfunPushUser());
		user = busiUserService.getBusiUser(user);
		if(user != null) {
			vo.setBsfunPushUserCode(user.getBsusrCode());
			vo.setBsfunPushUserHead(user.getBsusrHeadUrl());
		}		
		writeAjaxJSONResponse(ResultMessageBuilder.build(true, "", vo), response);
	}
	
	/**
	 * 发布趣事
	 * @param busiFun
	 * @return
	 */
	@RequestMapping(value="/content/add", method=RequestMethod.POST)
	public void addFun(BusiFun busiFun, HttpServletResponse response) {
		logger.info("[BusiFunController.addFun]:addFun begin");
		if(StringUtil.isEmpty(busiFun.getBsfunPushUser())) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "缺少用户UUID!"), response);
			return;
		}
		if(!StringUtil.isEmpty(busiFun.getBsfunContent())) {
			if(busiFun.getBsfunContent().length() > 500) {
				writeAjaxJSONResponse(ResultMessageBuilder.build(false, "趣事内容请控制在五百字以内!"), response);
				return;
			}
		}
		if(busiFun.getBsfunType() == null) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "缺少趣事类型！"), response);
			return;
		}
		busiFun.setBsfunUuid(busiFun.getBsfunType() + RandomUtil.generateUpperString(31));
		busiFunService.insertBusiFun(busiFun);
		writeAjaxJSONResponse(ResultMessageBuilder.build(true, "SUCCESS！", busiFun.getBsfunUuid()), response);
	}

	/**
	 * 我参与的趣事
	 * @param
	 * @return
	 */
	@RequestMapping(value="/my/hand", method=RequestMethod.POST)
	public void findMyHandIn(Integer lastId, String userUuid, int limit, HttpServletResponse response) {
		logger.info("[BusiFunController.findMyHandIn]:findMyHandIn begin");		
		if(lastId == null) {
			lastId = Integer.MAX_VALUE;
		}
		if(StringUtil.isEmpty(userUuid)) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "缺少用户UUID!"), response);
			return;
		}
		BusiFunListVO busiFunListVO = new BusiFunListVO();
		List<BusiFun> busiFunList = busiFunService.getBusiFunByMyHandIn(lastId, limit, userUuid);
		if(busiFunList == null || busiFunList.size() <= 0) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(true, "无数据！", busiFunListVO), response);
			return;
		}
		BusiFunVO vo = new BusiFunVO();
		List<BusiFunVO> voList = new ArrayList<BusiFunVO>();
		for(BusiFun busiFun : busiFunList) {
			if(busiFun.getBsfunUnid() < lastId) {
				lastId = busiFun.getBsfunUnid();
			}
			vo = new BusiFunVO();
			vo.convertPOToVO(busiFun);
			if(busiFun.getBsfunContent() != null) {
				if(busiFun.getBsfunContent().length() > 100)
					vo.setBsfunContent(busiFun.getBsfunContent().substring(0, 97) + "...");
				else {
					vo.setBsfunContent(busiFun.getBsfunContent());
				}
			}
			BusiUser user = new BusiUser(busiFun.getBsfunPushUser());
			user = busiUserService.getBusiUser(user);
			if(user != null) {
				vo.setBsfunPushUserCode(user.getBsusrCode());
				vo.setBsfunPushUserHead(user.getBsusrHeadUrl());
			}
			voList.add(vo);
		}
		busiFunListVO.setLastId(lastId);
		busiFunListVO.setVoList(voList);
		writeAjaxJSONResponse(ResultMessageBuilder.build(true, "", busiFunListVO), response);
	}

	/**
	 * 我发布的趣事
	 * @param
	 * @return
	 */
	@RequestMapping(value="/my/push", method=RequestMethod.POST)
	public void findMyPush(Integer lastId, String userUuid, int limit, HttpServletResponse response) {
		logger.info("[BusiFunController.findMyPush]:findMyPush begin");		
		if(lastId == null) {
			lastId = Integer.MAX_VALUE;
		}
		if(StringUtil.isEmpty(userUuid)) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "缺少用户UUID!"), response);
			return;
		}
		BusiFunListVO busiFunListVO = new BusiFunListVO();
		List<BusiFun> busiFunList = busiFunService.getBusiFunByLastId(lastId, 1, null, limit, userUuid);
		if(busiFunList == null || busiFunList.size() <= 0) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(true, "无数据！", busiFunListVO), response);
			return;
		}
		BusiFunVO vo = new BusiFunVO();
		List<BusiFunVO> voList = new ArrayList<BusiFunVO>();
		for(BusiFun busiFun : busiFunList) {
			if(busiFun.getBsfunUnid() < lastId) {
				lastId = busiFun.getBsfunUnid();
			}
			vo = new BusiFunVO();
			vo.convertPOToVO(busiFun);
			if(busiFun.getBsfunContent() != null) {
				if(busiFun.getBsfunContent().length() > 100)
					vo.setBsfunContent(busiFun.getBsfunContent().substring(0, 97) + "...");
				else {
					vo.setBsfunContent(busiFun.getBsfunContent());
				}
			}
			BusiUser user = new BusiUser(busiFun.getBsfunPushUser());
			user = busiUserService.getBusiUser(user);
			if(user != null) {
				vo.setBsfunPushUserCode(user.getBsusrCode());
				vo.setBsfunPushUserHead(user.getBsusrHeadUrl());
			}
			voList.add(vo);
		}
		busiFunListVO.setLastId(lastId);
		busiFunListVO.setVoList(voList);
		writeAjaxJSONResponse(ResultMessageBuilder.build(true, "", busiFunListVO), response);
	}

	/**
	 * 我收藏的趣事
	 * @param
	 * @return
	 */
	@RequestMapping(value="/my/collect", method=RequestMethod.POST)
	public void findMyCollect(Integer lastId, String userUuid, int limit, HttpServletResponse response) {
		logger.info("[BusiFunController.findMyCollect]:findMyCollect begin");		
		if(lastId == null) {
			lastId = Integer.MAX_VALUE;
		}
		if(StringUtil.isEmpty(userUuid)) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "缺少用户UUID!"), response);
			return;
		}
		BusiFunListVO busiFunListVO = new BusiFunListVO();
		List<BusiFun> busiFunList = busiFunService.getBusiFunByMyCollect(lastId, limit, userUuid);
		if(busiFunList == null || busiFunList.size() <= 0) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(true, "无数据！", busiFunListVO), response);
			return;
		}
		BusiFunVO vo = new BusiFunVO();
		List<BusiFunVO> voList = new ArrayList<BusiFunVO>();
		for(BusiFun busiFun : busiFunList) {
			if(busiFun.getBsfunUnid() < lastId) {
				lastId = busiFun.getBsfunUnid();
			}
			vo = new BusiFunVO();
			vo.convertPOToVO(busiFun);
			if(busiFun.getBsfunContent() != null) {
				if(busiFun.getBsfunContent().length() > 100)
					vo.setBsfunContent(busiFun.getBsfunContent().substring(0, 97) + "...");
				else {
					vo.setBsfunContent(busiFun.getBsfunContent());
				}
			}
			BusiUser user = new BusiUser(busiFun.getBsfunPushUser());
			user = busiUserService.getBusiUser(user);
			if(user != null) {
				vo.setBsfunPushUserCode(user.getBsusrCode());
				vo.setBsfunPushUserHead(user.getBsusrHeadUrl());
			}
			voList.add(vo);
		}
		busiFunListVO.setLastId(lastId);
		busiFunListVO.setVoList(voList);
		writeAjaxJSONResponse(ResultMessageBuilder.build(true, "", busiFunListVO), response);
	}
	
	/**
	 * 赞（审核通过）
	 * @param bsfunUuid
	 * @param userUuid(审核时用)
	 * @return
	 */
	@RequestMapping(value="/content/good", method=RequestMethod.POST)
	public void goodContent(String bsfunUuid, String userUuid, HttpServletResponse response) {
		logger.info("[BusiFunController.goodContent]:goodContent begin");
		if(StringUtil.isEmpty(bsfunUuid)) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "缺少bsfunUuid参数!"), response);
			return;
		}
		busiFunService.updateBusiFunGood(bsfunUuid, userUuid);
		writeAjaxJSONResponse(ResultMessageBuilder.build(true, "SUCCESS！"), response);
	}

	/**
	 * 不赞（审核失败）
	 * @param bsfunUuid
	 * @param userUuid(审核时用)
	 * @return
	 */
	@RequestMapping(value="/content/fail", method=RequestMethod.POST)
	public void failContent(String bsfunUuid, String userUuid, HttpServletResponse response) {
		logger.info("[BusiFunController.failContent]:failContent begin");
		if(StringUtil.isEmpty(bsfunUuid)) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "缺少bsfunUuid参数!"), response);
			return;
		}
		busiFunService.updateBusiFunFail(bsfunUuid, userUuid);
		writeAjaxJSONResponse(ResultMessageBuilder.build(true, "SUCCESS！"), response);
	}

	/**
	 * 跳过(下一个)
	 * @param
	 * @return
	 */
	@RequestMapping(value="/content/jump", method=RequestMethod.POST)
	public void jumpContent(String userUuid, HttpServletResponse response) {
		logger.info("[BusiFunController.jumpContent]:jumpContent begin");		
		if(StringUtil.isEmpty(userUuid)) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "缺少用户UUID!"), response);
			return;
		}
		List<BusiFun> busiFunList = busiFunService.getBusiFunByNoVerify(userUuid);
		if(busiFunList == null || busiFunList.size() <= 0) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(true, "无数据！"), response);
			return;
		}
		Random random = new Random();
		int i = random.nextInt(busiFunList.size());
		BusiFunVO vo = new BusiFunVO();
		vo.convertPOToVO(busiFunList.get(i));
		vo.setBsfunContent(busiFunList.get(i).getBsfunContent());
		BusiUser user = new BusiUser(busiFunList.get(i).getBsfunPushUser());
		user = busiUserService.getBusiUser(user);
		if(user != null) {
			vo.setBsfunPushUserCode(user.getBsusrCode());
			vo.setBsfunPushUserHead(user.getBsusrHeadUrl());
		}
		writeAjaxJSONResponse(ResultMessageBuilder.build(true, "", vo), response);
	}
//==================定制内容结束==============>

}