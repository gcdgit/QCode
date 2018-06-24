package com.xy.test;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 访问路径：http://localhost:8080/QCode/index.jsp
 * Servlet implementation class QRCodeServlet
 */
@WebServlet("/QRCodeServlet")
public class QRCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QRCodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		StringBuffer s = new StringBuffer();
		s.append("肖烨"+"\n");
		s.append("男"+"\n");
		s.append("湖南");
		String string = s.toString();
		/*TestQRCode.createQRcode("D:/qrcode1.png", 20, string);
		TestQRCode.createQRcode("D:/qrcode2.png", 20, string, "e:/1.jpg");*/
		
		BufferedImage image=JavaQRCode.qRCodeCommon(string, "png", 20);
		ImageIO.write(image, "JPEG", response.getOutputStream());
	}

}
