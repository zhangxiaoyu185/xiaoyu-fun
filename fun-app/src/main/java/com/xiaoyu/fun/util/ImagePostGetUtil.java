package com.xiaoyu.fun.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.ByteArrayPartSource;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.apache.commons.io.IOUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImagePostGetUtil {

	private static final Logger imgLog = LoggerFactory.getLogger("BASE_LOGGER");

	private static String CONFIG_FILE = "image_url_config.xml";

	private static Map<String, String> configMap;

	public static final String CODE_001 = "001"; //上传头像
	public static final String CODE_002 = "002"; //获取头像
	public static final String CODE_003 = "003"; //上传趣事图片
	public static final String CODE_004 = "004"; //获取趣事原图
	public static final String CODE_005 = "005"; //获取趣事缩略图

	static {
		ImageUrlConfigReader reader = new ImageUrlConfigReader(CONFIG_FILE);
		configMap = reader.getConfigMap();
	}

	private ImagePostGetUtil() {
	}

	/**
	 * 上传图片到app后台
	 * @param urlCode
	 * @param fileName
	 * @param content
	 */
	public static void postImageFile(String urlCode, String fileName,
			byte[] content) {
		String url = configMap.get(urlCode);
		PostMethod filePost = new PostMethod(url);
		try {
			ByteArrayPartSource bp = new ByteArrayPartSource(fileName, content);
			Part[] parts = { new StringPart("fileName", fileName),
					new FilePart("imgFile", bp) };
			filePost.setRequestEntity(new MultipartRequestEntity(parts,
					filePost.getParams()));
			HttpClient client = new HttpClient();
			//client.getHttpConnectionManager().getParams().setConnectionTimeout(5000);
			int status = client.executeMethod(filePost);
			if (status == HttpStatus.SC_OK) {
				imgLog.info("status:" + status + ";" + url + fileName + "上传成功");
			} else {
				imgLog.info("status:" + status + ";" + url + fileName + "上传失败");
			}
		} catch (Exception ex) {
			imgLog.info(url + fileName + "上传失败！");
		} finally {
			filePost.releaseConnection();
		}
	}

	public static boolean saveFunImageFile(String fileName, String fileUrl) {
		downloadImage(fileUrl);
		File targetFile = new File("C:\\255.jpg"); //指定上传文件
		String targetURL = "http://localhost:8080/fun-app/image/fun/save"; //指定URL
		PostMethod filePost = new PostMethod(targetURL);
		try {
			Part[] parts = { new StringPart("picName", fileName),
					new FilePart("imgFile", targetFile) };
			filePost.setRequestEntity(new MultipartRequestEntity(parts,
					filePost.getParams()));
			HttpClient client = new HttpClient();
			client.getHttpConnectionManager().getParams()
					.setConnectionTimeout(5000);
			int status = client.executeMethod(filePost);
			if (status == HttpStatus.SC_OK) {
				return true;
			} else {
				return false;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		} finally {
			filePost.releaseConnection();
		}
	}
	
	/**
	 * 从app后台获取图片
	 * @param urlCode
	 * @param fileName
	 * @return
	 */
	public static byte[] getImageFile(String urlCode, String fileName) {
		String url = configMap.get(urlCode) + fileName;
		HttpClient client = new HttpClient();
		GetMethod get = new GetMethod(url);
		try {
			int status = client.executeMethod(get);
			if (status == HttpStatus.SC_OK) {
				imgLog.info("status:" + status + ";" + url + fileName + "下载成功");
				return get.getResponseBody();
			} else {
				imgLog.info("status:" + status + ";" + url + fileName + "下载失败");
				return null;
			}
		} catch (Exception ex) {
			imgLog.info(url + fileName + "获取失败！");
			return null;
		} finally {
			get.releaseConnection();
		}
	}
	
	/**
	 * 下载URL图片
	 */
	public static void downloadImage(String picUrl) {
		HttpClient httpClient = new HttpClient();
		GetMethod getMethod = new GetMethod(picUrl);
		try {
			// 执行getMethod
			int statusCode = httpClient.executeMethod(getMethod);
			if (statusCode != HttpStatus.SC_OK) {
				System.err.println("Method failed: "+ getMethod.getStatusLine());
			}
			// 读取内容
			String picName = "C://255.jpg";
			InputStream inputStream = getMethod.getResponseBodyAsStream();
			OutputStream outStream = new FileOutputStream(picName);
			IOUtils.copy(inputStream, outStream);
			outStream.close();
			//System.out.println("OK!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 释放连接
			getMethod.releaseConnection();
		}
	}
	
	public static void main(String args[]) {
		//downloadImage();
		if(saveFunImageFile("1.jpg", "C:\\255.jpg")) {
			System.out.println("上传成功");
		} else {
			System.out.println("上传失败");
		}
	}
}

class ImageUrlConfigReader extends Dom4JXMLReader {

	private Map<String, String> map = new HashMap<String, String>();

	public ImageUrlConfigReader(String fileName) {
		super(fileName);
		Document doc = super.getDocument();
		Element root = doc.getRootElement();
		for (Iterator ie = root.elementIterator(); ie.hasNext();) {
			Element element = (Element) ie.next();
			String key = element.attributeValue("code");
			String url = element.attributeValue("url");
			map.put(key, url);
		}
	}

	@Override
	protected List<?> getXMLInfoList() {
		return null;
	}

	public Map<String, String> getConfigMap() {
		return map;
	}

}