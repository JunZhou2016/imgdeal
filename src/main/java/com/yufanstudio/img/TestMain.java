package com.yufanstudio.img;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.yufanstudio.img.util.Img4JavaUtil;
import com.yufanstudio.img.util.JavaApiImg;
import com.yufanstudio.img.util.JavaApiImgSmooth;
import com.yufanstudio.img.util.ThumbnailatorImg;

/**
 * Hello world!
 *
 */
public class TestMain {
    public static void main( String[] args ){
    	
    	String sourceImg="https://www.baidu.com/img/bd_logo1.png";
    	String sourceImgLocal="C:/Users/Administrator/Desktop/img/logo.jpg";
    	
    	String sourceImgJavaApi="C:/Users/Administrator/Desktop/img/logo_JavaApi_172254.jpg";
    	String sourceImgJavaApiSmooth="C:/Users/Administrator/Desktop/img/balifanzuixianchang_javaapi172254_http_smooth.jpg";
    	String sourceImgThumbnailator="C:/Users/Administrator/Desktop/img/balifanzuixianchang_javaapi172254_local_thumbnailator.jpg";

    	String sourceImgGraphicsMagick="C:/Users/Administrator/Desktop/img/balifanzuixianchang_javaapi172254_local_graphicsMagick.jpg";

    	
    	int width=172;
    	int height=254;
    	
    	JavaApiImg.resizeImage(true, sourceImg, sourceImgJavaApi, width, height);
    	JavaApiImgSmooth.resizeImage(true, sourceImg, sourceImgJavaApiSmooth, width, height);
    	ThumbnailatorImg.resizeImage(false, sourceImgLocal, sourceImgThumbnailator, width, height);
    	Img4JavaUtil.resizeImage(false, sourceImgLocal, sourceImgGraphicsMagick, width, height);
    	
    	//个人使用习惯(仅针对指定宽高缩放)
    	//JavaApiImgSmooth 效果最好
    	//ThumbnailatorImg  ===Img4JavaUtil  效果类似
    	//JavaApiImg 没有平衡处理 花影效果显著
    	
    	//最喜欢使用:  ThumbnailatorImg  (等比例压缩建立使用这个  当然还是根据实际效果测试)
    	
    	System.out.println( "Hello World!" );
    }
}

