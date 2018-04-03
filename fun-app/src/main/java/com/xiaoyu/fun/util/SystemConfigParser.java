package com.xiaoyu.fun.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SystemConfigParser {

	/**
	 * 解析器日志
	 */
	private static final Logger logger = LoggerFactory.getLogger(SystemConfigParser.class);

	private static final String CONFIG_FILE = "system_config.xml";

	/**
	 * 解析医院配置XML文件system_config.xml
	 * 
	 * @return SystemConfig
	 */
	public static SystemConfig parse() {
		logger.info("[SystemConfigParser.parse]:start parse system config.");
		String filePath = Thread.currentThread().getContextClassLoader()
				.getResource(CONFIG_FILE).getPath();
		logger.info("[SystemConfigParser.parse]:parse charge system file path is:"
				+ filePath);

		File file = new File(filePath);
		InputStream inputStream = null;
		SAXReader reader = new SAXReader();
		Document document = null;

		SystemConfig systemConfig = new SystemConfig();

		try {
			inputStream = new FileInputStream(file);
			document = reader.read(inputStream);

			Element root = document.getRootElement();
			@SuppressWarnings("unchecked")
			List<Element> elementList = root.elements();

			for (Element e : elementList) {
				if ("sessionOutUrl".equalsIgnoreCase(e.getName())) {
					systemConfig.setSessionOutUrl(e.getText());
				}
			}
			logger.info("[SystemConfigParser.parse]:parse system config success.");
		} catch (DocumentException e) {
			logger.error("[SystemConfigParser.parse]:parse system config occured an DocumentException:"
					+ e);
		} catch (FileNotFoundException e) {
			logger.error("[SystemConfigParser.parse]:parse system config occured an FileNotFoundException:"
					+ e);
		}
		logger.info("[SystemConfigParser.parse]:end parse system config.");
		return systemConfig;
	}
}