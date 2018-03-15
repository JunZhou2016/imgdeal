package com.yufanstudio.img.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import net.coobird.thumbnailator.Thumbnails;

public class ThumbnailatorImg {
	
	
	//1 调用Java Api 重置图片为制定宽高  可以接受流    文件    文件路径  url网络地址
	public static void resizeImage(boolean isHttp, 
				String srcImagePath, String toImagePath, int width, int height){
		try {
			
			if(isHttp){
				URL url = new URL(srcImagePath);
				Thumbnails.of(url)  
			    .size(width, height)  
			    .keepAspectRatio(false)  
			    //.outputQuality(1.0)
			    .toFile(toImagePath); 
			}else{
				Thumbnails.of(srcImagePath)  
			    .size(width, height)  
			    .keepAspectRatio(false)  
			    //.outputQuality(1.0)
			    .toFile(toImagePath); 
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
	}//重置图片失败
	

	
}

