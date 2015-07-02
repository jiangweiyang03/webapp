package com.yousoft.cfapi.entity.model;

public class NewsView {
	
	private String newtype;
	
	private String usersrc;
	
	private String content;
	
	private String newtime;
	
	public NewsView(){}

	public String getNewtype() {
		return newtype;
	}

	public void setNewtype(String newtype) {
		this.newtype = newtype;
	}

	public String getUsersrc() {
		return usersrc;
	}

	public void setUsersrc(String usersrc) {
		this.usersrc = usersrc;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getNewtime() {
		return newtime;
	}

	public void setNewtime(String newtime) {
		this.newtime = newtime;
	}
	
}
