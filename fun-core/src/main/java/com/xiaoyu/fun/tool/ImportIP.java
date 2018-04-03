package com.xiaoyu.fun.tool;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;

public class ImportIP {

	public static void importIp(String path) throws Exception {
		//读取文件
		BufferedReader in = new BufferedReader(new FileReader(path));
		String line;
		String[] lineList;
		String[] ipList;
		Connection con = DBUtil.getConnection();
		int i = 0;
		Long startTime = System.currentTimeMillis();
		con.setAutoCommit(false); 
		PreparedStatement pst = (PreparedStatement) con.prepareStatement("insert into CORE_IPADDRESS(CRIPS_UUID,CRIPS_START,CRIPS_STARTIP,CRIPS_END,CRIPS_ENDIP,CRIPS_ADDRESS,CRIPS_NET) values (?,?,?,?,?,?,?)");  
		while ((line = in.readLine()) != null) {
			//解析后插入数据库
			lineList = line.split(",");
			pst.setString(1, get32Random());
			ipList = lineList[0].split("\\.");
			Long startIp = Long.valueOf(ipList[0])*256*256*256+Long.valueOf(ipList[1])*256*256+Long.valueOf(ipList[2])*256+Long.valueOf(ipList[3]);
			pst.setLong(2, startIp);
			pst.setString(3, lineList[0]);
			ipList = lineList[1].split("\\.");
			Long endIp = Long.valueOf(ipList[0])*256*256*256+Long.valueOf(ipList[1])*256*256+Long.valueOf(ipList[2])*256+Long.valueOf(ipList[3]);
			pst.setLong(4, endIp);
			pst.setString(5, lineList[1]);
			pst.setString(6, lineList[2]);
			if(lineList[3]!=null)
				pst.setString(7, lineList[3]);
			else
				pst.setString(7, "");
		    pst.addBatch();
		    System.out.println(i);
			i++;
		}
		// 执行批量更新  
		pst.executeBatch();  
		// 语句执行完毕，提交本事务  
		con.commit();
		Long endTime = System.currentTimeMillis();  
		System.out.println(i+"条数据用时：" + (endTime - startTime));    
		pst.close();  
		con.close();  
		in.close();
	}
	
	public static String get32Random() { 
		Random r=new Random();
		String str = "";
		for(int i=0;i<32;i++){ 
			str += r.nextInt(10); 
		}
		return str;
	}
	
	public static void main(String[] args) throws Exception {
		importIp("E:\\安徽IP1.txt");
	}
}
