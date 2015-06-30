package com.yousoft.cfapi.entity.model;

import java.util.List;

public class FriendPageView {
	
	private String userid;
	
	private List<FContentView> contentlist;
	
	public FriendPageView(){}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public List<FContentView> getContentlist() {
		return contentlist;
	}

	public void setContentlist(List<FContentView> contentlist) {
		this.contentlist = contentlist;
	}

}
