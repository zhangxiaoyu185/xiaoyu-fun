package com.xiaoyu.fun.service.impl;

import com.xiaoyu.fun.service.BusiReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xiaoyu.fun.mybatis.dao.MyBatisDAO;
import com.xiaoyu.fun.entity.BusiReport;

@Service("busiReportService")
public class BusiReportServiceImpl implements BusiReportService {

	@Autowired
	private MyBatisDAO myBatisDAO;

	@Override
	public boolean insertBusiReport(BusiReport busiReport) {
		myBatisDAO.insert(busiReport);
		return true;
	}

	@Override
	public boolean updateBusiReport(BusiReport busiReport) {
		myBatisDAO.update(busiReport);
		return true;
	}

	@Override
	public boolean deleteBusiReport(BusiReport busiReport) {
		myBatisDAO.delete(busiReport);
		return true;
	}

	@Override
	public BusiReport getBusiReport(BusiReport busiReport) {
		return (BusiReport) myBatisDAO.findForObject(busiReport);
	}

//<=================定制内容开始==============	
	private static final String GET_BUSI_REPORT_BY_USER_AND_FUN = "getBusiReportByUserAndFUN";
	
	@Override
	public BusiReport getBusiReportByUserAndFUN(BusiReport busiReport) {
		return (BusiReport) myBatisDAO.findForObject(GET_BUSI_REPORT_BY_USER_AND_FUN, busiReport);
	}
//==================定制内容结束==============>

}