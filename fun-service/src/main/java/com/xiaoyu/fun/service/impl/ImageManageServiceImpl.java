package com.xiaoyu.fun.service.impl;

import org.springframework.stereotype.Service;

import com.xiaoyu.fun.service.ImageManageService;
import com.xiaoyu.fun.util.FileConstants;
import com.xiaoyu.fun.util.FileUtil;

@Service("imageManageService")
public class ImageManageServiceImpl implements ImageManageService {

	@Override
	public byte[] getAccountHeadPic(String picName) {
		return FileUtil.getBytes(FileConstants.HEAD_PICTURE, picName);
	}
	
	@Override
	public byte[] getFunPic(String picName) {
		return FileUtil.getBytes(FileConstants.STORY_PICTURE, picName);
	}

	@Override
	public void saveAccountHeadPic(String picName, byte[] picture) {
		FileUtil.writeBytes(picture, FileConstants.HEAD_PICTURE, picName);
	}

	@Override
	public void saveFunPic(String picName, byte[] picture) {
		FileUtil.writeBytes(picture, FileConstants.STORY_PICTURE, picName);
	}

}