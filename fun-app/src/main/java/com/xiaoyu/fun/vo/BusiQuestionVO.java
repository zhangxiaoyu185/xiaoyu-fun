package com.xiaoyu.fun.vo;

import com.xiaoyu.fun.entity.BusiQuestion;
import com.xiaoyu.fun.util.BaseVO;

public class BusiQuestionVO implements BaseVO {

	/**
	*标识UUID
	*/
	private String bsqsnUuid;

	/**
	*密保问题
	*/
	private String bsqsnContent;

	public void setBsqsnUuid(String bsqsnUuid) {
		this.bsqsnUuid = bsqsnUuid;
	}

	public String getBsqsnUuid( ) {
		return bsqsnUuid;
	}

	public void setBsqsnContent(String bsqsnContent) {
		this.bsqsnContent = bsqsnContent;
	}

	public String getBsqsnContent( ) {
		return bsqsnContent;
	}

	public BusiQuestionVO( ) { 
	}

	@Override
	public void convertPOToVO(Object poObj) {
		if (null == poObj) {
			return;
		}

		BusiQuestion po = (BusiQuestion) poObj;
		this.bsqsnUuid = po.getBsqsnUuid();
		this.bsqsnContent = po.getBsqsnContent();
	}
//<=================定制内容开始==============
//==================定制内容结束==============>

}