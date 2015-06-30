package com.yousoft.cfapi.service;

import java.util.List;

import com.yousoft.cfapi.entity.model.PlView;

public interface PlService {

	/**
	 * 添加回复信息
	 * 
	 * @param usersrc
	 *            回复人ID
	 * @param userdest
	 *            被回复人ID
	 * @param content
	 *            回复内容
	 * @return
	 */
	public int addReply(String textid, String usersrc, String userdest,
			String content);

	/**
	 * 添加评论信息
	 * 
	 * @param textid
	 *            消息ID
	 * @param usersrc
	 *            评论人ID
	 * @param content
	 *            评论内容
	 * @return
	 */
	public int addPl(String textid, String usersrc, String content);
	
	
	/**
	 * 根据消息ID查询所有评论集合
	 * @param textid
	 * @return
	 */
	public List<PlView> findPlViewListByTextId(Integer textid);
	
}
	
