package com.demo.editor.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.editor.mapper.newhtmlServiceImpl;
import com.demo.editor.mapper.uploadServiceImpl;
import com.demo.editor.pojo.ImageDB;
import com.demo.editor.pojo.NewHtml;

/**
 * 此类作用：
 * 		用户发布的文章显示
 */


@Controller
public class NewHtmlController {
	@Autowired
	private uploadServiceImpl uploadServiceImpl;
	
	@Autowired
	private newhtmlServiceImpl newhtmlServiceImpl;
	
	@RequestMapping("users/txt/{id}")
	public String newhtml(@PathVariable("id") int id,HttpServletResponse response) {
		
		ImageDB imageDB = uploadServiceImpl.setImageDB(id);
		
		//设置响应编码格式
        	response.setContentType("text/html;charset=utf-8");
		
		try {
			response.getWriter().write("<html>");
			response.getWriter().write("<head>");
			response.getWriter().write("</head>");
			response.getWriter().write("<body>");
			response.getWriter().write("<h1><center>");
			response.getWriter().write(imageDB.getTitle());
			response.getWriter().write("</h1></center><br/>");
			response.getWriter().write(imageDB.getArticle());
			response.getWriter().write("<br/>");
			response.getWriter().write(imageDB.getSource());
			response.getWriter().write("<br/>");
			response.getWriter().write(imageDB.getEditor());
	        response.getWriter().write("</body>");
	        response.getWriter().write("</html>");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return "ok";
	}
}
		
		
		//--------------此处生成html文件--------------------------------
			/**此处生成一个字符串，之所以不用String，Stringbuffer是因为这两个，只有StringBuffer效率高，
			StringBuffer和StringBuilder，前者没有后者效率高，因为，前者是线程安全的，在源码中，StringBuffer
			的方法是synchronized的，所以效率相对来说较低；
			*/
//		StringBuilder sb = new StringBuilder();
//		
//		try {
//			//创建一个news.html，并用PrintStream封装好，之后把字符打印进文件
//			OutputStream outputStream = new FileOutputStream("news.html");
//			PrintStream printStream = new PrintStream(outputStream);
//			//把html语句添加进字符串；
//			sb.append("<!DOCTYPE HTML>"); 
//			sb.append("<html>"); 
//			sb.append("<head>"); 
//			sb.append("<meta charset='UTF-8'/>"); 
//			sb.append("<title>默认生成的html文件</title>"); 
//			sb.append("</head>"); 
//			sb.append("<body>"); 
//			sb.append("张三"); 
//			sb.append("</body>"); 
//			sb.append("</html>"); 
//			
//			System.out.println(sb);
//			//此处利用PrintStream打印流，把字符打印进news.html文件中；
//			printStream.println(sb.toString());	
//			
//			//实例化NewHtml；
//			NewHtml newHtml = new NewHtml();
//
//			//文件存入类中；
//	        try {
//	        	//实例化一个二进制数组，把文件二进制化进数组中；
//	        	byte[] buffer = new byte[4096];
//	        	outputStream.write(buffer);
//				newHtml.setHtmlfile(buffer);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	        
//			//先获得本地时间,再转成String类型，放进NewHtml的对象中；
//			LocalDateTime localDateTime = LocalDateTime.now();
//		    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//		    newHtml.setTime(localDateTime.format(dtf));
//
//		    //存储文章编辑者
//		    newHtml.setEditor("李四");
//		    
//			//把文件存入数据库
//			newhtmlServiceImpl.inserthtmlservice(newHtml);
//			
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//			
		
