package com.xy.test;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;

import org.eclipse.jdt.internal.compiler.batch.Main;

import com.swetake.util.Qrcode;

public class TestQRCode {

	
	/**
	
	     * 生成一个二维码保存到指定路径  没有中间的logo
	
	     * @param path 二维码的保存地址
	
	     * @param size  二维码的版本  1-40   版本越高，生成的二维码越复杂 可存储的信息越大  
	
	     * @param content 二维码里面存放的信息
	
	     */
	
	    public static void createQRcode(String path,Integer size,String content){
	
	         BufferedImage bufImg = null;  
	
	            try {  
	
	                Qrcode qrcodeHandler = new Qrcode();  
	
	                // 设置二维码排错率，可选L(7%)、M(15%)、Q(25%)、H(30%)，排错率越高可存储的信息越少，但对二维码清晰度的要求越小  
	
	                qrcodeHandler.setQrcodeErrorCorrect('H');  
	
	                qrcodeHandler.setQrcodeEncodeMode('B');  

	                // 设置设置二维码尺寸，取值范围1-40，值越大尺寸越大，可存储的信息越大  
	
	                qrcodeHandler.setQrcodeVersion(size);  
	
	                // 获得内容的字节数组，设置编码格式  
	
	                byte[] contentBytes = content.getBytes("utf-8");  
	
	                // 图片尺寸  
	
	                int imgSize = 67 + 12 * (size - 1);  
	
	                bufImg = new BufferedImage(imgSize, imgSize, BufferedImage.TYPE_INT_RGB);  
	
	                Graphics2D gs = bufImg.createGraphics();  
	
	                // 设置背景颜色  
	
	                gs.setBackground(Color.WHITE);  
	
	                gs.clearRect(0, 0, imgSize, imgSize);  
	
	       
	
	                // 设定图像颜色> BLACK  
	
	                gs.setColor(Color.BLACK);  
	
	                // 设置偏移量，不设置可能导致解析出错  
	
	                int pixoff = 2;  
	
	                // 输出内容> 二维码  
	
	                if (contentBytes.length > 0 && contentBytes.length < 800) {  
	
	                    boolean[][] codeOut = qrcodeHandler.calQrcode(contentBytes);  
	
	                    for (int i = 0; i < codeOut.length; i++) {  
	
	                        for (int j = 0; j < codeOut.length; j++) {  
	
	                            if (codeOut[j][i]) {  
	
	                                gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);  
	
	                            }  
	
	                        }  
	
	                    }  
	
	                } else {  
	
	                    throw new Exception("QRCode content bytes length = " + contentBytes.length + " not in [0, 800].");  
	
	                }  
	
	                gs.dispose();  
	
	                bufImg.flush();  
	
	            } catch (Exception e) {  
	
	                e.printStackTrace();  
	
	            }  
	
	            try {
	
	                ImageIO.write(bufImg, "PNG", new FileOutputStream(path));
	
	            } catch (Exception e) {
	
	                e.printStackTrace();
	
	            }  
	
	    }
	    /**
	    
	     * 生成一个二维码保存到指定路径  中间有logo
	
	     * @param path 二维码的保存地址
	
	     * @param size  二维码的版本  1-40   版本越高，生成的二维码越复杂 可存储的信息越大  
	
	     * @param content 二维码里面存放的信息
	
	     * @param logopath 中间的logo的地址
	
	     */
	
	    public static void createQRcode(String path,Integer size,String content,String logopath){
	
	         BufferedImage bufImg = null;  
	
	            try {  
	
	                Qrcode qrcodeHandler = new Qrcode();  
	
	                // 设置二维码排错率，可选L(7%)、M(15%)、Q(25%)、H(30%)，排错率越高可存储的信息越少，但对二维码清晰度的要求越小  
	
	                qrcodeHandler.setQrcodeErrorCorrect('H');  
	
	                qrcodeHandler.setQrcodeEncodeMode('B');  
	
	                // 设置设置二维码尺寸，取值范围1-40，值越大尺寸越大，可存储的信息越大  
	
	                qrcodeHandler.setQrcodeVersion(size);  
	
	                // 获得内容的字节数组，设置编码格式  
	
	                byte[] contentBytes = content.getBytes("utf-8");  
	
	                // 图片尺寸  
	
	                int imgSize = 67 + 12 * (size - 1);  
	
	                bufImg = new BufferedImage(imgSize, imgSize, BufferedImage.TYPE_INT_RGB);  
	
	                Graphics2D gs = bufImg.createGraphics();  
	
	                // 设置背景颜色  
	
	                gs.setBackground(Color.WHITE);  
	
	                gs.clearRect(0, 0, imgSize, imgSize);  
	
	       
	
	                // 设定图像颜色> BLACK  
	
	                gs.setColor(Color.BLACK);  
	
	                // 设置偏移量，不设置可能导致解析出错  
	
	                int pixoff = 2;  
	
	                // 输出内容> 二维码  
	
	                if (contentBytes.length > 0 && contentBytes.length < 800) {  
	
	                    boolean[][] codeOut = qrcodeHandler.calQrcode(contentBytes);  
	
	                    for (int i = 0; i < codeOut.length; i++) {  
	
	                        for (int j = 0; j < codeOut.length; j++) {  
	
	                           if (codeOut[j][i]) {  
	
	                                gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);  
	
	                            }  
	
	                        }  
	
	                    }  
	
	                } else {  
	
	                    throw new Exception("QRCode content bytes length = " + contentBytes.length + " not in [0, 800].");  
	
	                }  
	
	                //构造login图片对象
	
	                Image img=ImageIO.read(new File(logopath));
	
	                
	
	                //放中间的图片
	
	                /**
	
	                 * qWidth代表生成的中间的logo距离图片左边和上边的的距离
	
	                 * iWidth  代表生成的中间的logo的长和宽
	
	                 */
	
	                int iWidth=imgSize/6;
	
	                int qWidth=imgSize/2-iWidth/2;
	
	                gs.drawImage(img, qWidth, qWidth, iWidth, iWidth, null); 
	
	                gs.dispose();  
	
	                bufImg.flush();  
	
	            } catch (Exception e) {  
	
	                e.printStackTrace();  
	
	            }  
	
	            try {
	
	                ImageIO.write(bufImg, "PNG", new FileOutputStream(path));
	
	            } catch (Exception e) {
	
	                e.printStackTrace();
	
	            }  
	
	    }
	    public static void main(String[] args) {
			
	    	String content1="老雷";
	    	 createQRcode("D:/qrcode1.png", 20, content1);
	    
	    	 createQRcode("D:/qrcode2.png", 20, content1,"e:/2.jpg");
		}
	    
}
