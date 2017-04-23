package com.yesee.ntp.model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="bookreply")
public class ReplyInfo {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "bid")
	private int bid;
	@Column(name = "content")
	private String content;
	@Column(name = "createtime")
	private String createtime;
	
	@Column(name = "user")
	private String user;
	
	
	public int getId(){
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
	public int getBid(){
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
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
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	
}