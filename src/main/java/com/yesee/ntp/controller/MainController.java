package com.yesee.ntp.controller;

import java.util.*;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;



import com.yesee.ntp.model.bean.UserInfo;

import com.yesee.ntp.model.bean.BookInfo;
import com.yesee.ntp.model.bean.ReplyInfo;

import com.yesee.ntp.model.service.LoginService;

import com.yesee.ntp.model.service.BookService;

@Controller

public class MainController {

	@Autowired
	private LoginService service;
	@Autowired
	private BookService bookservice;
	
	@RequestMapping(value = {"/"}, method = RequestMethod.GET, produces="application/json")
	@ResponseBody
	public  ModelAndView index() {		
       List<UserInfo> user = (List<UserInfo>)service.findUser();    
       return new ModelAndView("index","finduser",user);
       
	}
	
	
	
	@RequestMapping(value ="/login", method = RequestMethod.POST, produces="application/json")
	@ResponseBody
	public boolean loginCheck(UserInfo userinfo,HttpSession session) {
	boolean flag = false;	
	String name	= userinfo.getName();
	String pwd	= userinfo.getPassword();
	UserInfo logincheck = new UserInfo();
	logincheck.setName(name);
	logincheck.setPassword(pwd);
	List<UserInfo> login = service.loginCheck(logincheck);
	if (login.size()>0){
	    session.setAttribute("name",login.get(0).getName());
	    session.setAttribute("usertype",login.get(0).getUsertype());
	    session.setAttribute("email",login.get(0).getEmail());
		flag = true;
	}
	 return flag;
	}

	@RequestMapping(value ="/insertView", method = RequestMethod.POST)
	public String insertView() {			
		return "insert";
	}
    
	@RequestMapping(value ="/insert", method = RequestMethod.POST, produces="application/json")
	@ResponseBody
	public boolean userInsert(UserInfo userinfo) {
	boolean flag = false;	
	String name	= userinfo.getName();
	String pwd	= userinfo.getPassword();
	String em	= userinfo.getEmail();
	UserInfo insertuser = new UserInfo();
	insertuser.setName(name);
	insertuser.setPassword(pwd);
	insertuser.setEmail(em);
	
	List<UserInfo> check = service.checkUser(insertuser);
	//System.out.print(check.size());
	if(check.size()==0){
	flag = service.insertUser(insertuser);
	}
	 return flag;
	}
    
	
	@RequestMapping(value = {"/bookIndex"}, method = RequestMethod.GET)
	
	public ModelAndView bookindex(ModelMap model,HttpSession session,HttpServletRequest request) {
		 
	int usertype=(int)request.getSession().getAttribute("usertype");
    model.addAttribute("usertype", usertype);
    
    List<BookInfo> book = (List<BookInfo>)bookservice.findBook();
    if (book.size() != 0) {
    	for (BookInfo bookInfo : book){
    		if (bookInfo.getContent().length() > 100) {
    			bookInfo.setContent(bookInfo.getContent().substring(0, 101) + "...");
    		}
    	}
    }
    
    return new ModelAndView("bookIndex","findbook",book);
    
	}
	
	@RequestMapping(value ="/updateView", method = RequestMethod.POST)
	public String updateView() {			
		return "update";
	}
	
	@RequestMapping(value ="/update", method = RequestMethod.POST, produces="application/json")
	@ResponseBody
	public boolean userUpdate(UserInfo userinfo) {
	boolean flag = false;	
	String name	= userinfo.getName();
	String pwd	= userinfo.getPassword();
	String em	= userinfo.getEmail();
	UserInfo updateuser = new UserInfo();
	updateuser.setName(name);
	updateuser.setPassword(pwd);
	updateuser.setEmail(em);
	
    flag = service.updateUser(updateuser);
	
	 return flag;
	}
	
	@RequestMapping(value ="/updateallChoose", method = RequestMethod.POST)
	public ModelAndView updateallChoose() {	
		
	List<UserInfo> user = (List<UserInfo>)service.findUser();    
	return new ModelAndView("updateAllchoose","finduser",user);
		
	}
	
	@RequestMapping(value ="/updateallView", method = RequestMethod.POST, produces="application/json")
    @ResponseBody
	public ModelAndView updateallView(UserInfo userinfo) {	
    int id	= userinfo.getId();
    UserInfo findupdateuser = new UserInfo();
	findupdateuser.setId(id);
	
	List<UserInfo> user = (List<UserInfo>)service.findUpdateuser(findupdateuser);
	
	return new ModelAndView("updateAllview","findupdateuser",user);
		
	}
	
	@RequestMapping(value ="/updateChooseuser", method = RequestMethod.POST, produces="application/json")
	@ResponseBody
	public boolean updateChooseuser(UserInfo userinfo) {
	boolean flag = false;	
	String name	= userinfo.getName();
	String pwd	= userinfo.getPassword();
	String em	= userinfo.getEmail();
	int usertype = userinfo.getUsertype();
	
	
	UserInfo updatechooseuser = new UserInfo();
	updatechooseuser.setName(name);
	updatechooseuser.setPassword(pwd);
	updatechooseuser.setEmail(em);
	updatechooseuser.setUsertype(usertype);
	
    flag = service.updatechooseUser(updatechooseuser);
	
	 return flag;
	}
	
	@RequestMapping(value ="/deleteUser", method = RequestMethod.POST, produces="application/json")
	@ResponseBody
	public boolean deleteUser(UserInfo userinfo) {
	boolean flag = false;	
	int id	= userinfo.getId();
	UserInfo deleteuser = new UserInfo();
	deleteuser.setId(id);
	
    flag = service.deleteUser(deleteuser);
	
	 return flag;
	}
	
	@RequestMapping(value ="/logout", method = RequestMethod.POST)
	public String Logout(HttpSession session) {
	
	 session.invalidate();
    
	 return "bookIndex";
	}
	
	
	@RequestMapping(value ="/insertBookview", method = RequestMethod.POST)
	public String insertBookview() {			
		return "insertbook";
	}
	
	@RequestMapping(value ="/updateownBookview", method = RequestMethod.POST)
	public ModelAndView updateBookview(HttpSession session,HttpServletRequest request) {
		BookInfo bookdetail = new BookInfo();
		String name=(String)request.getSession().getAttribute("name");
		bookdetail.setUser(name);
		
		List<BookInfo> book = (List<BookInfo>)bookservice.findownBook(bookdetail);
		
			
		return new ModelAndView("updateownbookView","findownBook",book);
	}
	
	@RequestMapping(value ="/bookDetailview", method = RequestMethod.POST)
	public ModelAndView bookDetailview(ModelMap model,BookInfo bookinfo) {
		int id	= bookinfo.getId();
		BookInfo bookdetail = new BookInfo();
		ReplyInfo replydetail = new ReplyInfo();
		bookdetail.setId(id);
		replydetail.setId(id);
		
		List<BookInfo> book = (List<BookInfo>)bookservice.findBookdetail(bookdetail);
		List<ReplyInfo> reply = (List<ReplyInfo>)bookservice.findReply(replydetail);
		model.addAttribute("reply", reply);
		
		return new ModelAndView("bookdetail","findbookdetail",book);
	}
	
	
	@RequestMapping(value ="/replyBook", method = RequestMethod.POST, produces="application/json")
	@ResponseBody
	public ModelAndView replyBook(ReplyInfo replyinfo,HttpSession session,HttpServletRequest request,ModelMap model) {
		
		String user=(String)request.getSession().getAttribute("name");
		int bid = replyinfo.getBid();
		String content = replyinfo.getContent();
		
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd");
		String today = time.format(new Date());
		
		BookInfo bookdetail = new BookInfo();
		ReplyInfo replydetail = new ReplyInfo();
		bookdetail.setId(bid);
		replydetail.setId(bid);
		
		ReplyInfo insertReply = new ReplyInfo();
		insertReply.setBid(bid);
		insertReply.setContent(content);
		insertReply.setUser(user);
		insertReply.setCreatetime(today);
		
	    bookservice.insertReply(insertReply);
	    
	    List<BookInfo> book = (List<BookInfo>)bookservice.findBookdetail(bookdetail);
		List<ReplyInfo> reply = (List<ReplyInfo>)bookservice.findReply(replydetail);
		model.addAttribute("reply", reply);
	   
		return new ModelAndView("bookdetail","findbookdetail",book);
	}
	
	@RequestMapping(value ="/insertBook", method = RequestMethod.POST)
	public String insertBook(BookInfo bookinfo,HttpSession session,HttpServletRequest request) {
		
	
		String user=(String)request.getSession().getAttribute("name");
		String subject = bookinfo.getSubject();
		String content = bookinfo.getContent();
		String filelist = bookinfo.getFilelist();
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd");
		String today = time.format(new Date());
		
		BookInfo bookdetail = new BookInfo();
		bookdetail.setSubject(subject);
		bookdetail.setContent(content);
		bookdetail.setUser(user);
		bookdetail.setCreatetime(today);
		bookdetail.setEndupdate(today);
		bookdetail.setFilelist(filelist);
		
		bookservice.insertBook(bookdetail);
		
			
		return "bookIndex";
	}
	
	@RequestMapping(value ="/updateBookview", method = RequestMethod.POST)
	public ModelAndView updateBookview(BookInfo bookinfo) {
		int id = bookinfo.getId();
		BookInfo bookdetail = new BookInfo();	
		bookdetail.setId(id);
		
		List<BookInfo> book = (List<BookInfo>)bookservice.updateBookview(bookdetail);
		
			
		return new ModelAndView("updateBook","updateBook",book);
	}
	
	@RequestMapping(value ="/updateBook", method = RequestMethod.POST)
	public ModelAndView updateBook(BookInfo bookinfo,HttpSession session,HttpServletRequest request) {
		int id = bookinfo.getId();
		String subject = bookinfo.getSubject();
		String content = bookinfo.getContent();
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd");
		String today = time.format(new Date());
		String name=(String)request.getSession().getAttribute("name");
		String filelist = bookinfo.getFilelist();
		
		BookInfo bookdetail = new BookInfo();
		
		bookdetail.setId(id);
		bookdetail.setUser(name);
		bookdetail.setSubject(subject);
		bookdetail.setContent(content);
		bookdetail.setEndupdate(today);
		bookdetail.setFilelist(filelist);
		
		bookservice.updateBook(bookdetail);
		
		List<BookInfo> book = (List<BookInfo>)bookservice.findownBook(bookdetail);
			
		return new ModelAndView("updateownbookView","findownBook",book);
	}
	
	@RequestMapping(value ="/deleteBook", method = RequestMethod.POST)
	public ModelAndView deleteBook(BookInfo bookinfo,HttpSession session,HttpServletRequest request) {
		int id = bookinfo.getId();
		String name=(String)request.getSession().getAttribute("name");
		
		BookInfo bookdetail = new BookInfo();
		ReplyInfo replyinfo = new ReplyInfo();
		
		bookdetail.setId(id);
		bookdetail.setUser(name);
		replyinfo.setBid(id);
		
		bookservice.deleteBook(bookdetail);
		bookservice.deletereply(replyinfo);
		
		List<BookInfo> book = (List<BookInfo>)bookservice.findownBook(bookdetail);
			
		return new ModelAndView("updateownbookView","findownBook",book);
	}
	
	@RequestMapping(value ="/searchBook", method = RequestMethod.POST)

	public String searchBook(HttpServletRequest request,ModelMap model) {
		String search = request.getParameter("search");
		
		List<BookInfo> book = (List<BookInfo>)bookservice.searchBook(search);
		
		model.addAttribute("Listsize", book.size());
		model.addAttribute("findbook", book);
			
		return  "bookIndex";
	}
	
	 @RequestMapping(value = "/doUpload", method = RequestMethod.POST)
	 @ResponseBody
	    public String upload(HttpServletRequest request, Model model,
	            @RequestParam("file") MultipartFile files) {
	
		    String msg = "fail";
			String name = files.getOriginalFilename();

			try {
				
				String filePath = "C://J2EE/J2EEwork/SpringMaven/src/main/webapp/upload/upload/"+ name ;
							
				files.transferTo(new File(filePath));
				msg = "Success";
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	      		
	        return msg;
	    } 
	 
	 @RequestMapping(value = "/doUpateupload", method = RequestMethod.POST)
	 @ResponseBody
	    public String doUpateupload(HttpServletRequest request, Model model,
	            @RequestParam("file") MultipartFile files) {
		    String ornm = request.getParameter("name");
		    String ornmpath = "C://J2EE/J2EEwork/SpringMaven/src/main/webapp/upload/"+ ornm ;
		    File ordata = new File(ornmpath);
		    if (ordata.isFile() && ordata.exists()) {		     
		    ordata.delete();
		    }
		    String msg = "fail";
			String name = files.getOriginalFilename();

			
			try {
				
				String filePath ="C://J2EE/J2EEwork/SpringMaven/src/main/webapp/upload/"+ name ;
							
				files.transferTo(new File(filePath));
				msg = "Success";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	      		
	        return msg;
	    }
//	 @RequestMapping(value = "/dl", method = RequestMethod.POST)
//	 @ResponseBody
//	    public String dl(HttpServletRequest request, Model model,HttpServletRequest response) {
//		    String filename = request.getParameter("filename");
//			
//		    System.out.println(filename);
//		   // String ornmpath = "C://J2EE/J2EEwork/SpringMaven/src/main/webapp/upload/"+ ornm ;
//		   
//
//		    
//		    utStream in = new BufferedInputStream(new FileInputStream(filename));
//	        FileCopyUtils.copy(in, response.getOutputStream());
//			return ornm;
//	 }  
//	    public ResponseEntity<byte[]> download(HttpServletRequest request,String fileName, File file)
//        { 
//	    String filename = request.getParameter("filename");
//        String dfileName = new String(fileName.getBytes("gb2312"), "iso8859-1"); 
//        HttpHeaders headers = new HttpHeaders(); 
//        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM); 
//        headers.setContentDispositionFormData("attachment", dfileName); 
//        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(), headers, HttpStatus.CREATED); 
//        }
}

