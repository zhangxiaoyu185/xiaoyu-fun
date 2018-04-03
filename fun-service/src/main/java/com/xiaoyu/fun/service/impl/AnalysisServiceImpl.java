package com.xiaoyu.fun.service.impl;

import java.awt.Font;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.TextAnchor;
import org.springframework.stereotype.Service;
import com.xiaoyu.fun.service.AnalysisService;
import com.xiaoyu.fun.util.ParseFile;

@Service("analysisService")
public class AnalysisServiceImpl implements AnalysisService {

	private HttpSession session;
	
	// log文件地址
	private final static String LOG_URL = "C:\\log\\xiaoyu\\analysis";
	
	// log文件名
	private final static String ANALYSIS_LOG = "fun_analysis.log";

	@Override
	public String analysisByDay(String daytime) throws IOException {
		Integer i_busiAnswerquestion = 0; //密保问题
		Integer i_busiCollect = 0; //收藏举报
		Integer i_busiFeedback = 0; //意见反馈
		Integer i_busiFun = 0; //趣事评论
		Integer i_busiPushinfo = 0; //推送
		Integer i_busiUser = 0; //个人中心
		Integer i_busiVersion = 0; //版本控制
		
		List<String> contentList = ParseFile.operation(LOG_URL, ANALYSIS_LOG, "ANALYSIS_LOGGER", daytime);

		for (String line : contentList) {
			if (daytime.equals(line.substring(0, 10))) {
				if(!line.contains("exception")) {
					if (line.contains("/busiAnswerquestion")||line.contains("/busiQuestion")) {
						i_busiAnswerquestion++;
					}
					if (line.contains("/busiCollect")||line.contains("/busiReport")) {
						i_busiCollect++;
					}
					if (line.contains("/busiVersion")) {
						i_busiVersion++;
					}
					if (line.contains("/busiUser")) {
						i_busiUser++;
					}
					if (line.contains("/busiComment")||line.contains("/busiFun")) {
						i_busiFun++;
					}
					if (line.contains("/busiFeedback")) {
						i_busiFeedback++;
					}
					if (line.contains("/busiPushinfo")) {
						i_busiPushinfo++;
					}
				}
			}
		}
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(i_busiAnswerquestion, "密保问题", "密保问题");
		dataset.addValue(i_busiCollect, "收藏举报", "收藏举报");
		dataset.addValue(i_busiVersion, "版本", "版本");
		dataset.addValue(i_busiUser, "个人中心", "个人中心");
		dataset.addValue(i_busiFun, "趣事评论", "趣事评论");
		dataset.addValue(i_busiFeedback, "意见反馈", "意见反馈");
		dataset.addValue(i_busiPushinfo, "推送", "推送");
		
		StandardChartTheme standardChartTheme = new StandardChartTheme("CN");
		// 设置标题字体
		standardChartTheme.setExtraLargeFont(new Font("隶书", Font.BOLD, 20));
		// 设置图例的字体
		standardChartTheme.setRegularFont(new Font("宋书", Font.PLAIN, 15));
		// 设置轴向的字体
		standardChartTheme.setLargeFont(new Font("宋书", Font.PLAIN, 15));
		// 应用主题样式
		ChartFactory.setChartTheme(standardChartTheme);
		JFreeChart chart = ChartFactory
				.createBarChart3D("模块统计图", "模块", "使用次数", dataset,
						PlotOrientation.VERTICAL, true, false, false);
		CategoryPlot plot = chart.getCategoryPlot();
		CategoryAxis domainAxis = plot.getDomainAxis();
		domainAxis.setCategoryLabelPositions(CategoryLabelPositions
                .createUpRotationLabelPositions(Math.PI / 6.0));
		BarRenderer renderer = (BarRenderer) plot.getRenderer();
		renderer.setItemMargin(0.0);
		domainAxis.setLowerMargin(0.01);
        domainAxis.setUpperMargin(0.01);       
        ValueAxis rAxis = plot.getRangeAxis();
        rAxis.setUpperMargin(0.15);
        rAxis.setLowerMargin(0.15);
		renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer.setBaseItemLabelsVisible(true);
		renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(
				ItemLabelAnchor.OUTSIDE3, TextAnchor.BASELINE_RIGHT));
		renderer.setItemLabelAnchorOffset(20D);
		plot.setRenderer(renderer);
		String filename = ServletUtilities.saveChartAsPNG(chart, 1000, 550,
				null, session);
		String url = "/fun-app/DisplayChart?filename=" + filename;
		return url;
	}

	@Override
	public String analyByMonth(String monthtime) throws IOException {
		Integer i_busiAnswerquestion = 0; //密保问题
		Integer i_busiCollect = 0; //收藏举报
		Integer i_busiFeedback = 0; //意见反馈
		Integer i_busiFun = 0; //趣事评论
		Integer i_busiPushinfo = 0; //推送
		Integer i_busiUser = 0; //个人中心
		Integer i_busiVersion = 0; //版本控制
		
		List<String> contentList = ParseFile.operation(LOG_URL, ANALYSIS_LOG, "ANALYSIS_LOGGER", monthtime);

		for (String line : contentList) {
			if (monthtime.equals(line.substring(0, 7))) {
				if(!line.contains("exception")) {
					if (line.contains("/busiAnswerquestion")||line.contains("/busiQuestion")) {
						i_busiAnswerquestion++;
					}
					if (line.contains("/busiCollect")||line.contains("/busiReport")) {
						i_busiCollect++;
					}
					if (line.contains("/busiVersion")) {
						i_busiVersion++;
					}
					if (line.contains("/busiUser")) {
						i_busiUser++;
					}
					if (line.contains("/busiComment")||line.contains("/busiFun")) {
						i_busiFun++;
					}
					if (line.contains("/busiFeedback")) {
						i_busiFeedback++;
					}
					if (line.contains("/busiPushinfo")) {
						i_busiPushinfo++;
					}
				}
			}
		}
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(i_busiAnswerquestion, "密保问题", "密保问题");
		dataset.addValue(i_busiCollect, "收藏举报", "收藏举报");
		dataset.addValue(i_busiVersion, "版本", "版本");
		dataset.addValue(i_busiUser, "个人中心", "个人中心");
		dataset.addValue(i_busiFun, "趣事评论", "趣事评论");
		dataset.addValue(i_busiFeedback, "意见反馈", "意见反馈");
		dataset.addValue(i_busiPushinfo, "推送", "推送");
		
		StandardChartTheme standardChartTheme = new StandardChartTheme("CN");
		standardChartTheme.setExtraLargeFont(new Font("隶书", Font.BOLD, 20));
		standardChartTheme.setRegularFont(new Font("宋书", Font.PLAIN, 15));
		standardChartTheme.setLargeFont(new Font("宋书", Font.PLAIN, 15));
		ChartFactory.setChartTheme(standardChartTheme);
		JFreeChart chart = ChartFactory
				.createBarChart3D("模块统计图", "模块", "使用次数", dataset,
						PlotOrientation.VERTICAL, true, false, false);
		CategoryPlot plot = chart.getCategoryPlot();
		CategoryAxis domainAxis = plot.getDomainAxis();
		domainAxis.setCategoryLabelPositions(CategoryLabelPositions
                .createUpRotationLabelPositions(Math.PI / 6.0));
		BarRenderer renderer = (BarRenderer) plot.getRenderer();
		renderer.setItemMargin(0.0);
		domainAxis.setLowerMargin(0.01);
        domainAxis.setUpperMargin(0.01);       
        ValueAxis rAxis = plot.getRangeAxis();
        rAxis.setUpperMargin(0.15);
        rAxis.setLowerMargin(0.15);
		renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer.setBaseItemLabelsVisible(true);
		renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(
				ItemLabelAnchor.OUTSIDE3, TextAnchor.BASELINE_RIGHT));
		renderer.setItemLabelAnchorOffset(20D);
		plot.setRenderer(renderer);
		String filename = ServletUtilities.saveChartAsPNG(chart, 1000, 550,
				null, session);
		String url = "/fun-app/DisplayChart?filename=" + filename;
		return url;
	}

	@Override
	public String findVersionByMonth(String monthtime) throws IOException {
		Integer i_versionV_1_0_0 = 0; //版本1.0
		Integer i_versionV_1_1_0 = 0; //版本1.1
		Integer i_versionV_1_2_0 = 0; //版本1.2
		Integer i_versionV_1_3_0 = 0; //版本1.3
		Integer i_versionV_2_0_0 = 0; //版本2.0
		
		List<String> contentList = ParseFile.operation(LOG_URL, ANALYSIS_LOG, "ANALYSIS_LOGGER", monthtime);

		for (String line : contentList) {
			if (monthtime.equals(line.substring(0, 7))) {
				if(!line.contains("exception")) {
					if (line.contains("version:V1.0.0")) {
						i_versionV_1_0_0++;
					}
					if (line.contains("version:V1.1.0")) {
						i_versionV_1_1_0++;
					}
					if (line.contains("version:V1.2.0")) {
						i_versionV_1_2_0++;
					}
					if (line.contains("version:V1.3.0")) {
						i_versionV_1_3_0++;
					}
					if (line.contains("version:V2.0.0")) {
						i_versionV_2_0_0++;
					}
				}
			}
		}
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(i_versionV_1_0_0, "V1.0.0", "V1.0.0");
		dataset.addValue(i_versionV_1_1_0, "V1.1.0", "V1.1.0");
		dataset.addValue(i_versionV_1_2_0, "V1.2.0", "V1.2.0");
		dataset.addValue(i_versionV_1_3_0, "V1.3.0", "V1.3.0");
		dataset.addValue(i_versionV_2_0_0, "V2.0.0", "V2.0.0");
		
		StandardChartTheme standardChartTheme = new StandardChartTheme("CN");
		standardChartTheme.setExtraLargeFont(new Font("隶书", Font.BOLD, 20));
		standardChartTheme.setRegularFont(new Font("宋书", Font.PLAIN, 15));
		standardChartTheme.setLargeFont(new Font("宋书", Font.PLAIN, 15));
		ChartFactory.setChartTheme(standardChartTheme);
		JFreeChart chart = ChartFactory
				.createBarChart3D("模块统计图", "模块", "使用次数", dataset,
						PlotOrientation.VERTICAL, true, false, false);
		CategoryPlot plot = chart.getCategoryPlot();
		CategoryAxis domainAxis = plot.getDomainAxis();
		domainAxis.setCategoryLabelPositions(CategoryLabelPositions
                .createUpRotationLabelPositions(Math.PI / 6.0));
		BarRenderer renderer = (BarRenderer) plot.getRenderer();
		renderer.setItemMargin(0.0);
		domainAxis.setLowerMargin(0.01);
        domainAxis.setUpperMargin(0.01);       
        ValueAxis rAxis = plot.getRangeAxis();
        rAxis.setUpperMargin(0.15);
        rAxis.setLowerMargin(0.15);
		renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer.setBaseItemLabelsVisible(true);
		renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(
				ItemLabelAnchor.OUTSIDE3, TextAnchor.BASELINE_RIGHT));
		renderer.setItemLabelAnchorOffset(20D);
		plot.setRenderer(renderer);
		String filename = ServletUtilities.saveChartAsPNG(chart, 1000, 550,
				null, session);
		String url = "/fun-app/DisplayChart?filename=" + filename;
		return url;
	}

}