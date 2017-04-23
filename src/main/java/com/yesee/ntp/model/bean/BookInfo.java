package com.yesee.ntp.model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="book")
public class BookInfo {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "subject")
	private String subject;
	@Column(name = "content")
	private String content;
	@Column(name = "createtime")
	private String createtime;
	@Column(name = "endupdate")
	private String endupdate;
	@Column(name = "user")
	private String user;
	@Column(name = "filelist")
	private String filelist;
	
	public int getId(){
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
	public String getSubject(){
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getEndupdate() {
		return endupdate;
	}
	public void setEndupdate(String endupdate) {
		this.endupdate = endupdate;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getFilelist() {
		return filelist;
	}
	public void setFilelist(String filelist) {
		this.filelist = filelist;
	}
	
}
