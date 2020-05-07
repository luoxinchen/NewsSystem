package com.demo.editor.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.demo.editor.mapper.newhtmlServiceImpl;
import com.demo.editor.mapper.uploadServiceImpl;
import com.demo.editor.pojo.ImageDB;
import com.demo.editor.pojo.NewHtml;
import com.demo.editor.pojo.PingLun;
import com.demo.editor.pojo.TopImage;
import com.demo.editor.pojo.Users;
import com.demo.editor.pojo.UsersMassage;
import com.demo.editor.pojo.WriteArticle;
import com.demo.login_logout.mapper.login_logoutServiceImpl;
import com.demo.news.mapper.newsServiceImpl;
import com.demo.pinglun.mapper.pinglunServiceImpl;
import com.demo.toutiao.mapper.ToutiaoServiceImpl;
import com.demo.user.mapper.usermsgserviceImpl;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.sun.tools.internal.ws.processor.model.Request;

@Controller
@SessionAttributes(value = {"userName","TopNews","ImageDBtitle","list1","list2","list3","usersMassage","editorName","xinwendeshijian"})
public class EditorController {

	@Autowired
	private uploadServiceImpl uploadServiceImpl;
	
	@Autowired
	private ToutiaoServiceImpl toutiaoServiceImpl;
	
	@Autowired
	private newsServiceImpl newsServiceimpl;
	
	@Autowired
	private usermsgserviceImpl usermsgserviceImpl;
	
	@Autowired
	private pinglunServiceImpl pinglunServiceimpl; 
//		——————————————————————————————————————————————————————————————
	
	//跳转到文章编辑界面
		@RequestMapping("/index")
		public String index(Model model){
			
			//-----------------------------------------------
			//得到最新的头条文章对象的全部信息；
			int showImageId = toutiaoServiceImpl.showImageId();
			
			ImageDB imageDB = toutiaoServiceImpl.setImageDB(showImageId);
			String title = imageDB.getTitle();
			model.addAttribute("ImageDBtitle",title);
			//-----------------------------------------------
			//得到最新的普通文章对象的全部信息；
			List<ImageDB> newslist = newsServiceimpl.getNews();
			
			//定义一个list集合，找出放在第一列中的数据；
			//	——————————————————————————————————————————————————			
			List<ImageDB> list1 = new ArrayList<ImageDB>();
			for(int i=1;i<=newslist.size();i++){
				if(i%3==1){
					list1.add(newslist.get(i-1));
				}
			}
			//	——————————————————————————————————————————————————			
			//定义一个list集合，找出放在第二列中的数据；
			//	——————————————————————————————————————————————————				
			List<ImageDB> list2 = new ArrayList<ImageDB>();
			
			for(int i=1;i<=newslist.size();i++){
					if(i%3==2){
						list2.add(newslist.get(i-1));
					}
				}
			//	——————————————————————————————————————————————————		
			//定义一个list集合，找出放在第二列中的数据；
			//	——————————————————————————————————————————————————				
			List<ImageDB> list3 = new ArrayList<ImageDB>();
				
			for(int i=1;i<=newslist.size();i++){
				if(i%3==0){
					list3.add(newslist.get(i-1));
				}
			}
			//	——————————————————————————————————————————————————			
			model.addAttribute("list1",list1);
			model.addAttribute("list2",list2);
			model.addAttribute("list3",list3);
			//  --------------普通新闻已存储于集合中---------------
			
			return "index";
		}	
//		——————————————————————————————————————————————————————————————
	
	//跳转到文章编辑界面
	@RequestMapping("/editor")
	public String editor(String name,Model model){
		model.addAttribute("editorName",name);
		return "editor";
	}	
		
	
//	——————————————————————————————————————————————————————————————
	
	//普通新闻图片展现在index页面上
		@RequestMapping("{id}")
		public String id(@PathVariable("id") String time,HttpServletRequest request,HttpServletResponse response,Model model) throws IOException{
			
				//得到最新的普通文章对象的全部信息，并把每条新闻的id收集在一个集合中；
				List<ImageDB> newslist = newsServiceimpl.getNews();
				
				
				//判断前端传过来的id整体是什么类型的；
				if(time.indexOf("-")!=4){
					//前端传入的值为int
					int id1 = Integer.parseInt(time);
					for (ImageDB imageDB : newslist) {
						if(id1==imageDB.getId()){
							ServletOutputStream outputStream = response.getOutputStream();
							//输出图片
							outputStream.write(imageDB.getImage());
							//输出
							outputStream.flush();
							//关闭输出
							outputStream.close();
						}
					}
				}else{
					
					//传入的值为String
					List<PingLun> pinglun = pinglunServiceimpl.setPinglun(time);
				
					
					
					//跳转到ok页面，然后用语句展现该条普通新闻的内容
					for (ImageDB imageDB2 : newslist) {
						if(imageDB2.getTime().equals(time)){
							
							model.addAttribute("xinwendeshijian", time);
							
							response.setContentType("text/html;charset=utf-8");
							
							try {
								response.getWriter().write("<html>");
								response.getWriter().write("<head>");
								response.getWriter().write("</head>");
								response.getWriter().write("<body>");
								response.getWriter().write("<h1><center>");
								response.getWriter().write(imageDB2.getTitle());
								response.getWriter().write("</h1></center><br/>");
								response.getWriter().write(imageDB2.getArticle());
								response.getWriter().write("<br/>");
								response.getWriter().write(imageDB2.getSource());
								response.getWriter().write("<br/>");
								response.getWriter().write(imageDB2.getEditor());
						        response.getWriter().write("<hr/>");
						        response.getWriter().write("评论区："+"<br/>");
						        
						        for (PingLun pingLun2 : pinglun) {
						        	response.getWriter().write("<table><tr><td>"+pingLun2.getPinglunzhe()+"&nbsp;&nbsp;&nbsp;&nbsp;"+pingLun2.getTime()+"</td></tr>");
									response.getWriter().write("<tr><td>"+ pingLun2.getPinglun() +"</td></tr>");
									response.getWriter().write("<tr><td>赞："+ pingLun2.getZan()+"&nbsp;&nbsp;&nbsp;&nbsp;踩："+pingLun2.getCai() +"</td></tr></table>");
								}
						        
						        
						        response.getWriter().write("<hr/>");
						        response.getWriter().write("写评论：");
						        
						        //此处判断是否登录，交给ok页面来处理；
						        
							    response.getWriter().write("</body>");
						        response.getWriter().write("</html>");
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							return "ok";
						}
					}
				}
				
			return null;
		}
		
//		——————————————————————————————————————————————————————————————
	/**
	 *此方法是接收前端发送的信息来完成文章的编写，然后存储进数据库的；
	 *	用WriteArticle类型的对象接收，然后转存入ImageDB的对象中，
	 *	让ImageDB的对象与SQL语句进行关联；
	 */
	@RequestMapping("/file")
	public String file(WriteArticle writeArticle,HttpServletRequest request) throws Exception {
		try {
			
				//-------------------------------------------------------------
				
				//先创建Image的对象,转存信息；
				ImageDB imageDB = new ImageDB();
				
				//转存文档id
				imageDB.setWriteId(writeArticle.getWriteId());
				
				//先获得本地时间,再转成String类型，放进imageDB的对象中；
				LocalDateTime localDateTime = LocalDateTime.now();
			    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			    imageDB.setTime(localDateTime.format(dtf));
			    
			    //转存文档主要文章
			    imageDB.setArticle(writeArticle.getArticle());
			    
			    //转存文档编辑者
			    imageDB.setEditor(writeArticle.getEditor());
			   
			    //转存文档标题
			    imageDB.setTitle(writeArticle.getTitle());
			    
			    //转存文档来源
			    imageDB.setSource(writeArticle.getSource());
			    
			    //转存文档封面图片
				MultipartFile filename = writeArticle.getImage();
				//此处把前端传入的图片转为二进制，再存入对应的图片类中；
				byte[] bytes = filename.getBytes();
				
				//获得传入图片的名称，存入对应的图片类中；此句没用到；
				String string = filename.getOriginalFilename();
				
				imageDB.setImage(bytes);
				
				if(request.getParameter("danxuan").equals("头条新闻")){
					//头条新闻插入数据库
					uploadServiceImpl.insertToutiao(imageDB);
				}
				if(request.getParameter("danxuan").equals("普通新闻")){
					uploadServiceImpl.insertNews(imageDB);
			}
			
	//	———————————————————————————————————————————
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "index";
	}
//	——————————————————————————————————————————————————————————————
	//此段代码是前端置顶图片区域来获取数据库中最新的图片
	@RequestMapping("/TopImageShow")
	public String TopImageShow(HttpServletResponse response) throws IOException{
		//获得最新的置顶图片的主键id；
		int showImageId = uploadServiceImpl.showImageId();
		try {
			TopImage showTopImage = uploadServiceImpl.showTopImage(showImageId);
			//打开输出流
			ServletOutputStream outputStream = response.getOutputStream();
			//输出图片
			outputStream.write(showTopImage.getImage());
			//输出
			outputStream.flush();
			//关闭输出
			outputStream.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
//	——————————————————————————————————————————————————————————————
	//此段代码是点击前端置顶图片区域跳转到TopNews.html的
	@RequestMapping("/TopNews")
	public String TopNews(Model model) {
		// TODO Auto-generated method stub
		int showImageId = uploadServiceImpl.showImageId();
		ImageDB imageDB = uploadServiceImpl.setImageDB(showImageId);
		model.addAttribute("TopNews", imageDB);
		return "TopNews";
	}
	
//	——————————————————————————————————————————————————————————————
	
	//登录功能代码
	
	@Autowired 
	login_logoutServiceImpl login_logoutServiceImpl;
	
	@RequestMapping("/login")
	public String login(Users users,Model model) { 
			//查询输入的账号和密码是否相同
			Users login_logout_users = login_logoutServiceImpl.setUsersName(users);
			if(users.getPassword().equals(login_logout_users.getPassword())){
				model.addAttribute("userName", login_logout_users.getName());
				return "redirect:index";
			}else 
				return "redirect:Error"; 
	}
		
//	——————————————————————————————————————————————————————————————

	//此段代码是前端置顶图片区域来获取数据库中最新的图片
		@RequestMapping("/toutiaoImageShow")
		public String toutiaoImageShow(HttpServletResponse response) throws IOException{
			//获得最新的头条图片的主键id；
			int showImageId = toutiaoServiceImpl.showImageId();
			
			try {
				TopImage showTopImage = toutiaoServiceImpl.showTopImage(showImageId);
				//打开输出流
				ServletOutputStream outputStream = response.getOutputStream();
				//输出图片
				outputStream.write(showTopImage.getImage());
				//输出
				outputStream.flush();
				//关闭输出
				outputStream.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return null;
		}
//		——————————————————————————————————————————————————————————————
//		用户的个人信息页
		@RequestMapping("/usermsg")
		public String usermsg(String name1,Model model){
			UsersMassage usersMassage = usermsgserviceImpl.setUsersMassage(name1);
			model.addAttribute("usersMassage",usersMassage);
			return "usermsg";
		}
	
}