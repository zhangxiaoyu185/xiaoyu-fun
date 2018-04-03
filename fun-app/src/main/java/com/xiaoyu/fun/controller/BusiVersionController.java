package com.xiaoyu.fun.controller;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.xiaoyu.fun.controller.BaseController;
import com.xiaoyu.fun.entity.BusiVersion;
import com.xiaoyu.fun.service.BusiVersionService;
import com.xiaoyu.fun.util.ResultMessageBuilder;
import com.xiaoyu.fun.vo.BusiVersionVO;

@Controller
@RequestMapping(value="/busiVersion")
public class BusiVersionController extends BaseController {

//<=================定制内容开始==============
	@Autowired
	private BusiVersionService busiVersionService;
	
	/**
	 * 版本更新
	 * @return
	 */
	@RequestMapping(value="/get", method=RequestMethod.POST)
	public void getVersion(String bsvsnNo, Integer bsvsnType, HttpServletResponse response) {
		logger.info("[BusiVersionController.getVersion]:getVersion begin");
		BusiVersion busiVersion = new BusiVersion();
		busiVersion.setBsvsnType(bsvsnType);
		busiVersion = busiVersionService.getBusiVersionByType(busiVersion);
		if(busiVersion.getBsvsnType() == null || ("").equals(busiVersion.getBsvsnType())) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "该手机类型不支持!"), response);	
			return;
		}
		if(busiVersion.getBsvsnNo().compareTo(bsvsnNo) > 0) {
			BusiVersionVO vo = new BusiVersionVO();
			vo.convertPOToVO(busiVersion);
			writeAjaxJSONResponse(ResultMessageBuilder.build(true, "success!", vo), response);
			return;
		}
		writeAjaxJSONResponse(ResultMessageBuilder.build(false, "该版本"+busiVersion.getBsvsnNo()+"已是最新"), response);     
	}
//==================定制内容结束==============>

}