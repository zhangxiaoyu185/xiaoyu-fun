package com.xiaoyu.fun.util;

import java.io.File;

public class FunConstants {

	public static final String XIAOYU_CONFIG = "XIAOYU_CONFIG"; //环境变量
	
	public static String IMAGE_ROOT_FILE_DIR = ""; // 图片文件存储基本目录
	
	public static String VOICE_ROOT_FILE_DIR = "";// 语音文件存储目录
	
	public static String CUTY_CAPT_TOOL_DIR = "";// 网页截屏工具存储目录 

	public static String EXCEL_ROOT_FILE_DIR = "";// EXCEL文件存储目录 

	static { 
		IMAGE_ROOT_FILE_DIR = System.getenv(FunConstants.XIAOYU_CONFIG)+ File.separator + "images";
		VOICE_ROOT_FILE_DIR = System.getenv(FunConstants.XIAOYU_CONFIG) + File.separator + "voices";
		CUTY_CAPT_TOOL_DIR = System.getenv(FunConstants.XIAOYU_CONFIG) + File.separator + "tools" + File.separator + "cutyCapt";
		EXCEL_ROOT_FILE_DIR = System.getenv(FunConstants.XIAOYU_CONFIG) + File.separator + "excels";
	}

}
