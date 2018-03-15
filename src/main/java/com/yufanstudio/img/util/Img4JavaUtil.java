package com.yufanstudio.img.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.im4java.core.ConvertCmd;
import org.im4java.core.IM4JavaException;
import org.im4java.core.IMOperation;
import org.im4java.core.ImageCommand;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class Img4JavaUtil {
	
    private static final String IMAGE_MAGICK_PATH = "E:/Program Files/GraphicsMagick-1.3.28-Q8";

	//1 调用Java Api 重置图片为制定宽高
	public static void resizeImage(boolean isHttp, 
				String srcImagePath, String toImagePath, int width, int height){
		

		
		ImageCommand cmd=new ConvertCmd(true);
		cmd.setGlobalSearchPath(IMAGE_MAGICK_PATH);
		
		IMOperation op = new IMOperation();
        op.addImage(srcImagePath);
        op.resize(width, height);
        op.addImage(toImagePath);
        ConvertCmd convert = new ConvertCmd(true);
        try {
			convert.run(op);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IM4JavaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//重置图片失败
	

	
}

