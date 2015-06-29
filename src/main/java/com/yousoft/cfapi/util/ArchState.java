package com.yousoft.cfapi.util;

public enum ArchState {
	
	SUCCESS(0,"处理成功"),EXCEPTION(1,"程序出现异常"),ERROR(2,"程序出现错误");

	private int state;
	private String message;
	
	ArchState(int state,String message){
		this.state = state;
		this.message = message;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
