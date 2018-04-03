package com.xiaoyu.fun.controller;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import com.xiaoyu.fun.service.ImageManageService;
import com.xiaoyu.fun.util.FileConstants;
import com.xiaoyu.fun.util.FileUtil;
import com.xiaoyu.fun.util.ResultMessageBuilder;


@Controller
@RequestMapping("/image")
public class ImageManageController extends BaseController {

	private static final String DEFAULT_HEAD_IMAGE = "head";
	
	//private static final String DEFAULT_FUN_IMAGE = "fun";
	
	//private static final String DEFAULT_S_FUN_IMAGE = "s_fun";
	
	private static final String IMAGE_SUFFIX_JPG = ".jpg";

	private static final String IMAGE_SUFFIX_PNG = ".png";

	private static final String IMAGE_SUFFIX_BMP = ".bmp";

	private static final Logger imgLog = LoggerFactory.getLogger("BASE_LOGGER");

	@Autowired
	private ImageManageService imageManageService;

	/**
	 * 获取账户头像
	 * @param picName
	 * @param response
	 */
	@RequestMapping(value = "/account/head/get/{picName}", method = RequestMethod.GET)
	public void getAccountHeadPic(@PathVariable String picName, HttpServletResponse response) {	
		String folder = FileConstants.HEAD_PICTURE  + File.separator;
		Random rand = new Random();
		int i = rand.nextInt(3);
		if (null == picName) {
			imgLog.warn("数据库中pic_name is null");
			byte[] stream = FileUtil.getBytes(folder, DEFAULT_HEAD_IMAGE + i + IMAGE_SUFFIX_PNG);
			writePicStream(response, stream);
			return;
		}
		byte[] stream = FileUtil.getBytes(folder, picName);
		if (stream == null)
			stream = FileUtil.getBytes(folder, picName + IMAGE_SUFFIX_JPG);
		if (stream == null)
			stream = FileUtil.getBytes(folder, picName + IMAGE_SUFFIX_BMP);
		if (stream == null)
			stream = FileUtil.getBytes(folder, picName + IMAGE_SUFFIX_PNG);
		if (stream == null)
			stream = FileUtil.getBytes(folder, DEFAULT_HEAD_IMAGE + i + IMAGE_SUFFIX_PNG);
		writePicStream(response, stream);
	}	

    /**
     * 获取趣事原图
     * @param picName 图片名称
     * @param response
     */
    @RequestMapping(value="/fun/get/original/{picName}", method=RequestMethod.GET)
    public void getFunPicOriginal(@PathVariable String picName, HttpServletResponse response){
    	String folder = FileConstants.STORY_PICTURE  + File.separator;
    	//Random rand = new Random();
		//int i = rand.nextInt(9);
		if (null == picName) {
			imgLog.warn("数据库中pic_name is null");			
			//byte[] stream = FileUtil.getBytes(folder, DEFAULT_FUN_IMAGE + i + IMAGE_SUFFIX_JPG);
			//writePicStream(response, stream);
			return;
		}
		byte[] stream = FileUtil.getBytes(folder, picName);
		if (stream == null)
			stream = FileUtil.getBytes(folder, picName + IMAGE_SUFFIX_JPG);
		if (stream == null)
			stream = FileUtil.getBytes(folder, picName + IMAGE_SUFFIX_BMP);
		if (stream == null)
			stream = FileUtil.getBytes(folder, picName + IMAGE_SUFFIX_PNG);
		//if (stream == null)
			//stream = FileUtil.getBytes(folder, DEFAULT_FUN_IMAGE + i + IMAGE_SUFFIX_JPG);
		if(stream == null)
			return;
		writePicStream(response, stream);
    }

//    /**
//     * 获取趣事缩略图
//     * @param picName 图片名称
//     * @param response
//     */
//    @RequestMapping(value="/fun/get/thumbnail/{picName}", method=RequestMethod.GET)
//    public void getFunPicThumbnail(@PathVariable String picName, HttpServletResponse response){
//    	
//    	String folder = FileConstants.STORY_PICTURE  + File.separator;
//    	//Random rand = new Random();
//		//int i = rand.nextInt(9);
//		if (null == picName) {
//			picName = "s_" + picName;
//			imgLog.warn("数据库中pic_name is null");			
//			//byte[] stream = FileUtil.getBytes(folder, DEFAULT_S_FUN_IMAGE + i + IMAGE_SUFFIX_JPG);
//			//writePicStream(response, stream);
//			return;
//		}
//		picName = "s_" + picName;
//		byte[] stream = FileUtil.getBytes(folder, picName);
//		if (stream == null)
//			stream = FileUtil.getBytes(folder, picName + IMAGE_SUFFIX_JPG);
//		if (stream == null)
//			stream = FileUtil.getBytes(folder, picName + IMAGE_SUFFIX_BMP);
//		if (stream == null)
//			stream = FileUtil.getBytes(folder, picName + IMAGE_SUFFIX_PNG);
//		//if (stream == null)
//			//stream = FileUtil.getBytes(folder, DEFAULT_S_FUN_IMAGE + i + IMAGE_SUFFIX_JPG);
//		writePicStream(response, stream);
//    }
    
	/**
	 * 上传账户头像
	 * @param picName
	 * @param response
	 */
	@RequestMapping(value = "/account/head/save", method = RequestMethod.POST)
	public void saveAccountHeadPic(String picName, HttpServletRequest request,
			HttpServletResponse response) {
		byte[] bytes = null;
		try {
			if (request instanceof MultipartHttpServletRequest) {
				MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
				MultipartFile file = multipartRequest.getFile("imgFile");
				//response.setContentType("text/text;charset=UTF-8");
				if (null != file) {
                    ByteOutputStream out = new ByteOutputStream();
                    changeImage(file, 100, 100, out);
					bytes = out.getBytes();					
					out.close();
				}
				if (null != bytes && bytes.length > 0) {
					imageManageService.saveAccountHeadPic(picName, bytes);
				}
			}
		} catch (Exception e) {
			imgLog.warn("[ImageManageController.saveAccountHeadPic]:upload expert picture error: ", e);
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "上传失败!"), response);
			return;
		}
		writeAjaxJSONResponse(ResultMessageBuilder.build(true, "上传成功!"), response);
	}
    
  /**
   * 上传趣事图片
   * @param request
   * @param fileName
   * @param response
   */
    @RequestMapping(value = "/fun/save", method = RequestMethod.POST)
    public void saveFunPic(String picName, HttpServletRequest request, HttpServletResponse response){
        byte[] bytes = null;
        //byte[] bytes_thumb = null;
        try {
            if(request instanceof MultipartHttpServletRequest){
                MultipartHttpServletRequest multipartRequest  =  (MultipartHttpServletRequest) request;
                MultipartFile file = multipartRequest.getFile("imgFile");
                response.setContentType("text/text;charset=UTF-8");

                if(null!=file){
                    if(file.getSize()>1000000){
                        writeAjaxJSONResponse(ResultMessageBuilder.build(false, "文件大小超过1M！"), response);
                        return;
                    }
                    ByteOutputStream out = new ByteOutputStream();
                    //ByteOutputStream out_thumb = new ByteOutputStream();
                    if(file.getSize()>300000) { //大于300多KB
	                    //获得上传图片的宽度
	                    int width = getPicWidth(file);
	                    if(width != -1 && width != 0 && width > 700){
	                    	double times = width / 700.0;
	                    	int height = (int)(getPicHeight(file) / times);
	                    	changeImage(file, 700, height, out);
	                        //writeAjaxJSONResponse(ResultMessageBuilder.build(false, "上传图片的宽度不能超过1024像素！"), response);
	                        //return;
	                    }
                    }
                    //获得上传图片的高度
                    //if(getPicHeight(file)!=-1 && getPicHeight(file)>768){
                        //writeAjaxJSONResponse(ResultMessageBuilder.build(false, "上传图片的高度不能超过768像素！"), response);
                        //return;
                    //}
                    else {                   
                    	changeImage(file, ImageIO.read(file.getInputStream()).getWidth(), ImageIO.read(file.getInputStream()).getHeight(),out);
                    }
                    bytes = out.getBytes();
                    
                    //changeImage(file, 70, 50, out_thumb);
                    //bytes_thumb = out_thumb.getBytes();
                    
                    out.close();
                    //out_thumb.close();
                }

                if(null!=bytes && bytes.length >0){
                    imageManageService.saveFunPic(picName, bytes);
                }
                //if(null!=bytes_thumb && bytes_thumb.length >0){
                //    imageManageService.saveFunPic("s_"+picName,bytes_thumb);
                //}
            }
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            writeAjaxJSONResponse(ResultMessageBuilder.build(false, "上传失败！"), response);
            return;
        }
        writeAjaxJSONResponse(ResultMessageBuilder.build(true, "上传成功！"), response);
    }
	
    //重新生成图像
    private void changeImage(MultipartFile file, int width, int height, OutputStream out) {
        try {
            Image img = ImageIO.read(file.getInputStream());
            int newWidth; int newHeight;
            if(img.getHeight(null)<height && img.getWidth(null)<width){
                newWidth = img.getWidth(null);
                newHeight = img.getHeight(null);
            } else {
                newWidth = width;
                newHeight =img.getHeight(null)<height? img.getHeight(null):height;
            }
            BufferedImage tag = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
            tag.getGraphics().drawImage(img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH),0, 0, null);
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
            encoder.encode(tag);
            out.close();
        } catch (Exception e) {
            imgLog.error("unknown exception",e);
        }
    }

	private void writePicStream(HttpServletResponse response, byte[] byteStream) {
		if (byteStream == null) {
			return;
		}
		ServletOutputStream out = null;
		try {
			Date date = new Date();
			response.setDateHeader("Last-Modified", date.getTime()); // Last-Modified:页面的最后生成时间
			response.setDateHeader("Expires", date.getTime() + 86400000); // Expires:过时期限值
			response.setHeader("Cache-Control", "public, must-revalidate"); // Cache-Control来控制页面的缓存与否,public:浏览器和缓存服务器都可以缓存页面信息；
			response.setHeader("Pragma", "Pragma");
			out = response.getOutputStream();
			out.write(byteStream);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//获得上传图片文件的高度
    private int getPicHeight(MultipartFile file) {
        int picHeight = 0;
        try {
            Image img = ImageIO.read(file.getInputStream());
            picHeight=img.getHeight(null);
        } catch (IOException e) {
        	logger.error(e.getMessage(),e);
        }
        return picHeight;
    }

    //获得上传图片文件的宽度
    private int getPicWidth(MultipartFile file) {
        int picWidth=0;
        try {
            Image img = ImageIO.read(file.getInputStream());
            picWidth=img.getWidth(null);
        } catch (IOException e) {
            logger.error(e.getMessage(),e);
        }
        return picWidth;
    }

}