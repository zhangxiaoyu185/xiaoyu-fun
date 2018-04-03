package com.xiaoyu.fun.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFileChooser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.xiaoyu.fun.controller.BaseController;
import com.xiaoyu.fun.entity.BusiPushinfo;
import com.xiaoyu.fun.service.AnalysisService;
import com.xiaoyu.fun.service.BusiPushinfoService;
import com.xiaoyu.fun.util.DateUtil;
import com.xiaoyu.fun.util.ResultMessageBuilder;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

@Controller
@RequestMapping(value = "/admin/analysis")
public class AnalysisController extends BaseController {

	@Autowired
	private AnalysisService analysisService;

	@Autowired
	private BusiPushinfoService busiPushinfoService;
	
	@RequestMapping(value = "/daytime/{daytime}", method = RequestMethod.POST)
	public void findByDay(@RequestParam String daytime,
			HttpServletResponse response) {
		logger.info("[AnalysisController.findByDay]:findByDay begin.");
		String filename = "";
		try {
			filename = analysisService.analysisByDay(daytime);
			writeAjaxJSONResponse(ResultMessageBuilder.build(filename), response);
		} catch (IOException e) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "读取异常"), response);
		}
		logger.info("[AnalysisController.findByDay]:findByDay end.");
	}

	@RequestMapping(value = "/monthtime/{monthtime}", method = RequestMethod.POST)
	public void findByMonth(@RequestParam String monthtime,
			HttpServletResponse response) {
		logger.info("[AnalysisController.findByMonth]:findByMonth begin.");
		String filename = "";
		try {
			filename = analysisService.analyByMonth(monthtime);
			writeAjaxJSONResponse(ResultMessageBuilder.build(filename), response);
		} catch (IOException e) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "读取异常"), response);
		}
		logger.info("[AnalysisController.findByMonth]:findByMonth end.");
	}
	
	@RequestMapping(value = "/version/monthtime/{monthtime}", method = RequestMethod.POST)
	public void findVersionByMonth(@RequestParam String monthtime,
			HttpServletResponse response) {
		logger.info("[AnalysisController.findVersionByMonth]:findVersionByMonth begin.");
		String filename = "";
		try {
			filename = analysisService.findVersionByMonth(monthtime);
			writeAjaxJSONResponse(ResultMessageBuilder.build(filename), response);
		} catch (IOException e) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "读取异常"), response);
		}
		logger.info("[AnalysisController.findVersionByMonth]:findVersionByMonth end.");
	}
	
	/**
	 * 在线人员列表
	 * @param param
	 * @param response
	 */
	@RequestMapping(value = "/online/person", method = RequestMethod.POST)
	public void onlinePerson(int pageIndex, int pageSize, HttpServletResponse response) {
		logger.info("[AnalysisController.onlinePerson]:onlinePerson begin.");
		Map<String, Object> result = new HashMap<String, Object>();
		List<BusiPushinfo> mobileUserList = busiPushinfoService.selAllBusiPushinfo();
		List<BusiPushinfo> listFenYe = new ArrayList<BusiPushinfo>();
		if (mobileUserList.size() != 0 && pageIndex <= (mobileUserList.size() / pageSize)) {
			for (int i = pageIndex * pageSize; i < (pageIndex + 1) * pageSize; i++) {	
				if (i < mobileUserList.size()) {
					listFenYe.add(mobileUserList.get(i));
				} else {
					break;
				}
			}
		}
		result.put("data", listFenYe);
		result.put("total", mobileUserList.size());
		writeAjaxJSONResponse(result, response);
		logger.info("[AnalysisController.onlinePerson]:onlinePerson end.");
	}

	/**
	 * 导出在线人员列表
	 * @param param
	 * @param response
	 */
	@RequestMapping(value = "/online/person/check", method = RequestMethod.POST)
	public void onlinePersonCheck(HttpServletResponse response) {
		logger.info("[AnalysisController.onlinePersonCheck]:onlinePersonCheck begin.");
		List<BusiPushinfo> mobileUserList = busiPushinfoService.selAllBusiPushinfo();
		JFileChooser fileChooser = new JFileChooser("D:\\");
    	fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = fileChooser.showOpenDialog(fileChooser);
        String outDirPath = "";
        if(returnVal == JFileChooser.APPROVE_OPTION) {       
        	outDirPath = fileChooser.getSelectedFile().getAbsolutePath();//选择的文件夹的路径
    	}
        if(returnVal == JFileChooser.CANCEL_OPTION) {
        	writeAjaxJSONResponse(ResultMessageBuilder.build(true, "取消成功！"), response);
        	return;
        }
        if(!outDirPath.endsWith(".xls")&&!outDirPath.endsWith(".xlsx")) {
        	writeAjaxJSONResponse(ResultMessageBuilder.build(false, "路径错误！"), response);
        	return;
        }
        if(mobileUserList == null || mobileUserList.size() < 1) {
        	writeAjaxJSONResponse(ResultMessageBuilder.build(false, "无数据！"), response);
        	return;
        }
        String[][] contentList = new String[mobileUserList.size()][4];
        int i = 0;
        for(;i < mobileUserList.size(); i++) {
        	if(mobileUserList.get(i).getBspioType() == 1) {
        		contentList[i][0] = "Android";
        	}else {
        		contentList[i][0] = "IOS";
        	}
        	contentList[i][1] = mobileUserList.get(i).getBspioSn();
        	contentList[i][2] = DateUtil.formatDefaultDate(mobileUserList.get(i).getBspioCdate());
        	contentList[i][3] = mobileUserList.get(i).getBspioUser();
        }
        CreateXmlByPoi(outDirPath, contentList);
        writeAjaxJSONResponse(ResultMessageBuilder.build(true, "success!"), response);
		logger.info("[AnalysisController.onlinePersonCheck]:onlinePersonCheck end.");
	}
	
	/**
	 * POI生成Excel
	 * @param strPath
	 * @param ContentList
	 */
	public static void CreateXmlByPoi(String outPath, String[][] contentList) {
		try {
			HSSFWorkbook workbook = new HSSFWorkbook();// 创建新的Excel工作薄
			HSSFSheet sheet = workbook.createSheet("在线人数统计");
			sheet.setDefaultColumnWidth(25);
			
			HSSFFont f = workbook.createFont(); 
			f.setFontHeightInPoints((short) 10); // 字体高度
			f.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); //加粗
			HSSFCellStyle style = workbook.createCellStyle();
			style.setFont(f); 
			
			HSSFRow headRow = sheet.createRow(0);
			HSSFCell headCell = headRow.createCell(0);
			headCell.setCellStyle(style);
			headCell.setCellType(HSSFCell.CELL_TYPE_STRING);// 定义单元格为字符串类型
			headCell.setCellValue("设备名"); // 设置文本内容
			headCell = headRow.createCell(1);
			headCell.setCellStyle(style);
			headCell.setCellType(HSSFCell.CELL_TYPE_STRING);// 定义单元格为字符串类型
			headCell.setCellValue("序列号"); // 设置文本内容
			headCell = headRow.createCell(2);
			headCell.setCellStyle(style);
			headCell.setCellType(HSSFCell.CELL_TYPE_STRING);// 定义单元格为字符串类型
			headCell.setCellValue("创建时间"); // 设置文本内容
			headCell = headRow.createCell(3);
			headCell.setCellStyle(style);
			headCell.setCellType(HSSFCell.CELL_TYPE_STRING);// 定义单元格为字符串类型
			headCell.setCellValue("用户"); // 设置文本内容
			headCell = headRow.createCell(4);
			
			for (int i = 1; i < contentList.length+1; i++) {
				HSSFRow row = sheet.createRow(i);
				for (int j = 0; j < contentList[0].length; j++) {
					HSSFCell cell = row.createCell(j);
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);// 定义单元格为字符串类型
					cell.setCellValue(contentList[i-1][j]);// 设置文本内容
				}
			}
			
			FileOutputStream fOut = new FileOutputStream(outPath);
			workbook.write(fOut); // 把相应的excel工作表保存到硬盘上
			fOut.flush();
			fOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}