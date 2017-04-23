package com.yesee.ntp.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yesee.ntp.model.bean.BookInfo;
import com.yesee.ntp.model.bean.ReplyInfo;

@Repository
public class BookDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.openSession();		
	}
	
	
	@SuppressWarnings("unchecked")
	public List<BookInfo> findBook() {

		List<BookInfo> findbook = new ArrayList<BookInfo>();
	
		Query query = getSession().createQuery("from BookInfo");
		findbook = query.list();

		return findbook;

	}
    
	@SuppressWarnings("unchecked")
	public List<ReplyInfo> findReply(ReplyInfo replyDetail) {

		List<ReplyInfo> replydetail = new ArrayList<ReplyInfo>();
		int id = replyDetail.getId();
		
		Query query = getSession().createQuery("from ReplyInfo reply where reply.bid=?0");
		query.setInteger("0", id);
		replydetail = query.list();

		return replydetail;

	}
	
	@SuppressWarnings("unchecked")
	public List<BookInfo> findBookdetail(BookInfo bookdetail) {

		List<BookInfo> findbookdetail = new ArrayList<BookInfo>();
		int id = bookdetail.getId();
		
		Query query = getSession().createQuery("from BookInfo book where book.id=?0");
		query.setInteger("0", id);
		findbookdetail = query.list();

		return findbookdetail;

	}

	public boolean insertReply(ReplyInfo insertReply) {
		boolean flag = true;
		ReplyInfo reply = new ReplyInfo();
		int bid = insertReply.getBid();
		String content = insertReply.getContent();
		String user = insertReply.getUser();
		String createtime = insertReply.getCreatetime();
		
		reply.setBid(bid);
		reply.setContent(content);
		reply.setUser(user);
		reply.setCreatetime(createtime);
		
		getSession().save(reply);
		
		return flag;

	}

	public boolean insertBook(BookInfo bookdetail) {
		boolean flag = true;
		BookInfo insertbook = new BookInfo();
		String subject = bookdetail.getSubject();
		String content = bookdetail.getContent();
		String user = bookdetail.getUser();
		String createtime = bookdetail.getCreatetime();
		String endupdate = bookdetail.getEndupdate();
		String filelist = bookdetail.getFilelist();
		
		insertbook.setSubject(subject);;
		insertbook.setContent(content);
		insertbook.setUser(user);
		insertbook.setCreatetime(createtime);
		insertbook.setEndupdate(endupdate);
		insertbook.setFilelist(filelist);
		
		getSession().save(insertbook);
		
		return flag;

	}
	
	@SuppressWarnings("unchecked")
	public List<BookInfo> findownBook(BookInfo bookdetail) {
		
		String user = bookdetail.getUser();
		List<BookInfo> insertbook = new ArrayList<BookInfo>();
		
		Query query = getSession().createQuery("from BookInfo book where book.user=?0");
		query.setString("0", user);
		insertbook = query.list();
		
		return insertbook;

	}
	@SuppressWarnings("unchecked")
	public List<BookInfo> updateBookview(BookInfo bookdetail) {
		
		int id = bookdetail.getId();
		List<BookInfo> updatebookview = new ArrayList<BookInfo>();
		
		Query query = getSession().createQuery("from BookInfo book where book.id=?0");
		query.setInteger("0", id);
		updatebookview = query.list();
		
		return updatebookview;

	}
	

	public boolean updateBook(BookInfo bookdetail) {
		boolean flag = true;
		int id = bookdetail.getId();
		String subject = bookdetail.getSubject();
		String content = bookdetail.getContent();
		String endupdate = bookdetail.getEndupdate();
		String filelist = bookdetail.getFilelist();
		
		Query query = getSession().createQuery("update BookInfo book set book.subject=?0,book.content=?1,book.endupdate=?2,book.filelist=?3 where user.id=?4");
		query.setString("0", subject);
		query.setString("1", content);
		query.setString("2", endupdate);
		query.setString("3", filelist);
		query.setInteger("4", id);
		query.executeUpdate();
				
		return flag;

	}

	public boolean deleteBook(BookInfo bookdetail) {
		boolean flag = true;
		int id = bookdetail.getId();
			
		Query query = getSession().createQuery("delete BookInfo book where book.id=?0");
		query.setInteger("0", id);
		query.executeUpdate();
				
		return flag;
	}
	public boolean deletereply(ReplyInfo replyinfo) {
		boolean flag = true;
		int bid = replyinfo.getBid();
			
		Query query = getSession().createQuery("delete ReplyInfo reply where reply.bid=?0");
		query.setInteger("0", bid);
		query.executeUpdate();
				
		return flag;
	}
	
	@SuppressWarnings("unchecked")
	public List<BookInfo> searchBook(String search) {
		
		String s = search.toString();
     List<BookInfo> searchbook = new ArrayList<BookInfo>();
		
		Query query = getSession().createQuery("from BookInfo book where book.subject like ?0 or book.content like ?1 or book.createtime like ?2 or book.user like ?3");
		query.setString("0", "%"+s+"%");
		query.setString("1", "%"+s+"%");
		query.setString("2",  s);
		query.setString("3", "%"+s+"%");
		searchbook = query.list();
		
				
		return searchbook;
	}
}
