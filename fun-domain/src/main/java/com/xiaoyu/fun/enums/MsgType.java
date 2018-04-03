package com.xiaoyu.fun.enums;

/**
 * 消息类型
 */
public enum MsgType {

	/**
	 * 趣事推送消息
	 */
	FUN_PUSH_INFO,
	/**
	 * 趣事审核成功
	 */
	FUN_VERIFY_SUCCESS;

	public String getChineseStr(){
        switch (this){
            case FUN_PUSH_INFO:
                return "趣事推送消息";
            case FUN_VERIFY_SUCCESS:
                return "趣事审核成功";
            default:
                return "";
        }
    }
}
