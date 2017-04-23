package com.yesee.ntp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yesee.ntp.model.bean.UserInfo;
import com.yesee.ntp.model.dao.LoginDAO;

@Service
public class LoginService {
	
	@Autowired
    private LoginDAO dao;
	 
	  public List<UserInfo> findUser() {
	        return dao.findUser();
	    }
	  public  List<UserInfo> checkUser(UserInfo checkuser) {		  
	        return dao.checkUser(checkuser);
	    }
	  public List<UserInfo> loginCheck(UserInfo logincheck) {		  
	        return dao.loginCheck(logincheck);
	    }
	  public boolean insertUser(UserInfo insertuser) {		  
	        return dao.insertUser(insertuser);
	    }
	  public boolean updateUser(UserInfo updateuser) {		  
	        return dao.updateUser(updateuser);
	    }
	  public List<UserInfo> findUpdateuser(UserInfo findupdateuser) {
	        return dao.findUpdateuser(findupdateuser);
	    }
	  public boolean updatechooseUser(UserInfo updatechooseuser) {		  
	        return dao.updatechooseUser(updatechooseuser);
	    }
	  public boolean deleteUser(UserInfo deleteuser) {		  
	        return dao.deleteUser(deleteuser);
	    }
}
