package com.xiaoyu.fun.service.impl;

import com.xiaoyu.fun.service.CoreAttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xiaoyu.fun.mybatis.dao.MyBatisDAO;
import com.xiaoyu.fun.entity.CoreAttachment;

@Service("coreAttachmentService")
public class CoreAttachmentServiceImpl implements CoreAttachmentService {

	@Autowired
	private MyBatisDAO myBatisDAO;

	@Override
	public boolean insertCoreAttachment(CoreAttachment coreAttachment) {
		myBatisDAO.insert(coreAttachment);
		return true;
	}

	@Override
	public boolean updateCoreAttachment(CoreAttachment coreAttachment) {
		myBatisDAO.update(coreAttachment);
		return true;
	}

	@Override
	public boolean deleteCoreAttachment(CoreAttachment coreAttachment) {
		myBatisDAO.delete(coreAttachment);
		return true;
	}

	@Override
	public CoreAttachment getCoreAttachment(CoreAttachment coreAttachment) {
		return (CoreAttachment) myBatisDAO.findForObject(coreAttachment);
	}

//<=================定制内容开始==============
//==================定制内容结束==============>

}