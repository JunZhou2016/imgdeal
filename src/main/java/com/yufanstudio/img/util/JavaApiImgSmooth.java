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

public class JavaApiImgSmooth {
	
	
	//1 调用Java Api 重置图片为制定宽高
	public static void resizeImage(boolean isHttp, 
				String srcImagePath, String toImagePath, int width, int height){
		
		FileOutputStream out = null;
		try{
		
			 //读入文件的流
			 BufferedImage src = null;
		
			 if (isHttp){
					URL url = new URL(srcImagePath);
					src = ImageIO.read(url);
			 } else{
					File file = new File(srcImagePath);
					if(null!=file && file.canRead())
					src = javax.imageio.ImageIO.read(file);
			 }

			 // 构造Image对象 缩放边长
			 BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			 // 绘制放大后的图片
			 tag.getGraphics().drawImage(src.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);
			 out = new FileOutputStream(toImagePath);
			
			 JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			 encoder.encode(tag);
		
			 
		} catch (IOException e){
			e.printStackTrace();
			return ;
		}finally {
			if(out!=null){
				try {
					out.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				 
			 }
		}
		
	}//重置图片失败
	

	
}

