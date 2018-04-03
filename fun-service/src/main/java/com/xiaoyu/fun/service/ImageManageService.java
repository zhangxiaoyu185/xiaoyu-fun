package com.xiaoyu.fun.service;

public interface ImageManageService {

	/**
	 * 获取账户头像
	 * @param picName 图片名称
	 * @return 二进制流的照片
	 */
	public byte[] getAccountHeadPic(String picName);
	
	/**
	 * 获取趣事图片
	 * @param picName
	 * @return
	 */
	public byte[] getFunPic(String picName);

	/**
	 * 保存账户头像
	 * @param picName 图片名称
	 * @param picture 二进制流的照片
	 * return				
	 */
	public void saveAccountHeadPic(String picName, byte[] picture);

	/**
	 * 保存趣事图片
	 * @param picName 图片名称
	 * @param picture 二进制流的照片
	 * return
	 */
	public void saveFunPic(String picName, byte[] picture);

}