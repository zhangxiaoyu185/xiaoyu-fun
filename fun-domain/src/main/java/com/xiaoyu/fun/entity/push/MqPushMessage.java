package com.xiaoyu.fun.entity.push;

import com.xiaoyu.fun.enums.MsgType;

public class MqPushMessage {

	private int pushType; //0:单播，1：全播

	private String uuid; //趣事uuid
	
	private String content; //内容
	
	private String userUuid; //接收用户
	
	private MsgType msgType; //消息类型

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public int getPushType() {
		return pushType;
	}

	public void setPushType(int pushType) {
		this.pushType = pushType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserUuid() {
		return userUuid;
	}

	public void setUserUuid(String userUuid) {
		this.userUuid = userUuid;
	}

	public MsgType getMsgType() {
		return msgType;
	}

	public void setMsgType(MsgType msgType) {
		this.msgType = msgType;
	}
	
}