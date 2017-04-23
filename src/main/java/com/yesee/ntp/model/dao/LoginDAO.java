package com.yesee.ntp.model.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.catalina.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.mapping.Map;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yesee.ntp.model.bean.UserInfo;

@Repository
public class LoginDAO {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.openSession();

		// return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<UserInfo> findUser() {

		List<UserInfo> finduser = new ArrayList<UserInfo>();

		// Query query = getSession().createSQLQuery("select * from user");
		// finduser = query.list();
		// Criteria criteria = getSession().createCriteria(user.class).list();
		// finduser = getSession().createQuery("select * from user").list();
		Query query = getSession().createQuery("from UserInfo");
		finduser = query.list();

		return finduser;

	}
    
	@SuppressWarnings("unchecked")
	public List<UserInfo> checkUser(UserInfo checkuser) {
		
		List<UserInfo> user = new ArrayList<UserInfo>();
		String name = checkuser.getName();

		Query query = getSession().createQuery("from UserInfo user where user.username=?0");
		query.setString("0", name);	
		user = query.list();
		
		// System.out.println("123"+checkuser.getName());
		return user;
	}
	
	@SuppressWarnings("unchecked")
	public List<UserInfo> loginCheck(UserInfo logincheck) {
		
		List<UserInfo> user = new ArrayList<UserInfo>();
		String name = logincheck.getName();
		String pwd = logincheck.getPassword();

		Query query = getSession().createQuery("from UserInfo user where user.username=?0 and user.password=?1");
		query.setString("0", name);
		query.setString("1", pwd);
		user = query.list();
		
		return user;
	}
	
	
	public boolean insertUser(UserInfo insertuser) {
		boolean flag = true;
		UserInfo adduser = new UserInfo();
		String name = insertuser.getName();
		String pwd = insertuser.getPassword();
		String em = insertuser.getEmail();
		
		adduser.setName(name);
		adduser.setPassword(pwd);
		adduser.setEmail(em);
		adduser.setUsertype(1);
		
		getSession().save(adduser);
		
		return flag;
	}


	public boolean updateUser(UserInfo updateuser) {
		boolean flag = true;
	
		String name = updateuser.getName();
		String pwd = updateuser.getPassword();
		String em = updateuser.getEmail();
				
		Query query = getSession().createQuery("update UserInfo user set user.password=?0,user.email=?1 where user.username=?2");
		query.setString("0", pwd);
		query.setString("1", em);
		query.setString("2", name);
		query.executeUpdate();
				
		return flag;
	}
	
	@SuppressWarnings("unchecked")
	public List<UserInfo> findUpdateuser(UserInfo findupdateuser) {

		List<UserInfo> user = new ArrayList<UserInfo>();
        int id = findupdateuser.getId();
		
		Query query = getSession().createQuery("from UserInfo user where user.id=?0");
		query.setInteger("0", id);
		user = query.list();

		return user;

	}
	
	public boolean updatechooseUser(UserInfo updatechooseuser) {
		boolean flag = true;
	
		String name = updatechooseuser.getName();
		String pwd = updatechooseuser.getPassword();
		String em = updatechooseuser.getEmail();
		int ut = updatechooseuser.getUsertype();
			
		Query query = getSession().createQuery("update UserInfo user set user.password=?0,user.email=?1,user.usertype=?2 where user.username=?3");
		query.setString("0", pwd);
		query.setString("1", em);
		query.setInteger("2", ut);
		query.setString("3", name);
		query.executeUpdate();
				
		return flag;
	}
	
	public boolean  deleteUser(UserInfo deleteuser) {
		boolean flag = true;
		
        int id = deleteuser.getId();
		
		Query query = getSession().createQuery("delete UserInfo user where user.id=?0");
		query.setInteger("0", id);
		query.executeUpdate();

		return flag;

	}
	
}
