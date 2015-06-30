package com.yousoft.cfapi.entity.model;

/**
 * 评论View对象
 * @author jiangweiyang01
 *
 */
public class PlView {
	
	/**0全部评论 1回复评论**/
	private String type;
	/**回复人**/
	private String usersrc;
	/**被回复人**/
	private String userdest;
	/**回复内容**/
	private String content;
	
	public PlView(){}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUsersrc() {
		return usersrc;
	}

	public void setUsersrc(String usersrc) {
		this.usersrc = usersrc;
	}

	public String getUserdest() {
		return userdest;
	}

	public void setUserdest(String userdest) {
		this.userdest = userdest;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
