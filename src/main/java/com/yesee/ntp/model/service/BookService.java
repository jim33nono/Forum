package com.yesee.ntp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yesee.ntp.model.bean.BookInfo;
import com.yesee.ntp.model.bean.ReplyInfo;

import com.yesee.ntp.model.dao.BookDAO;

@Service
public class BookService {
	
	@Autowired
    private BookDAO dao;
	
	 public List<BookInfo> findBook() {
	        return dao.findBook();
	    }
	 public List<BookInfo> findBookdetail(BookInfo bookdetail) {
	        return dao.findBookdetail(bookdetail);
	    }
	 public List<ReplyInfo> findReply(ReplyInfo replyDetail) {
	        return dao.findReply(replyDetail);
	    }
	 public  boolean insertReply(ReplyInfo insertReply) {
	        return dao.insertReply(insertReply);
	    }
	 public  boolean insertBook(BookInfo bookdetail) {
	        return dao.insertBook(bookdetail);
	    }
	 public  List<BookInfo> findownBook(BookInfo bookdetail) {
	        return dao.findownBook(bookdetail);
	    }
	 public  List<BookInfo> updateBookview(BookInfo bookdetail) {
	        return dao.updateBookview(bookdetail);
	    }
	 public  boolean updateBook(BookInfo bookdetail) {
	        return dao.updateBook(bookdetail);
	    }
	 public  boolean deleteBook(BookInfo bookdetail) {
	        return dao.deleteBook(bookdetail);
	    }
	 public  boolean deletereply(ReplyInfo replyinfo) {
	        return dao.deletereply(replyinfo);
	    }
	 public List<BookInfo> searchBook(String search) {
	        return dao.searchBook(search);
	    }
}
