package com.xiaoyu.fun.service;

import java.util.List;
import com.xiaoyu.fun.entity.BusiPushinfo;
import com.xiaoyu.fun.enums.MsgType;

public interface BusiPushinfoService {

	/**
	* 添加
	* @param busiPushinfo
	* @return
	*/
	public boolean insertBusiPushinfo(BusiPushinfo busiPushinfo);

	/**
	* 修改
	* @param busiPushinfo
	* @return
	*/
	public boolean updateBusiPushinfo(BusiPushinfo busiPushinfo);

	/**
	* 删除
	* @param busiPushinfo
	* @return
	*/
	public boolean deleteBusiPushinfo(BusiPushinfo busiPushinfo);

	/**
	* 查询
	* @param busiPushinfo
	* @return
	*/
	public BusiPushinfo getBusiPushinfo(BusiPushinfo busiPushinfo);

//<=================定制内容开始==============	
	/**
	 * 查询移动设备相关信息
	 * @param bspioUser
	 * @return
	 */
	List<BusiPushinfo> getBusiPushinfo(String bspioUser);
	
	/**
	 * 删除移动设备相关信息
	 * @param bspioUser
	 */
	void deleteBusiPushinfo(String bspioUser);
	
	/**
	 * 广播推送消息
	 * @param uuid 趣事uuid
	 * @param title
	 * @param msgType
	 */
	public void pushMsgBroadcast(String uuid, String title, MsgType msgType);
	
	/**
	 * 单播推送消息
	 * @param uuid
	 * @param userUuid
	 * @param title
	 * @param msgType
	 */
	public void pushMsgUnicast(String uuid, String userUuid, String title, MsgType msgType);
	
	/**
	 * 查询所有在线移动设备
	 * @return
	 */
	List<BusiPushinfo> selAllBusiPushinfo();
//==================定制内容结束==============>

}