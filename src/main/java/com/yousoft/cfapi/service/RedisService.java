package com.yousoft.cfapi.service;

import java.util.List;

import com.yousoft.cfapi.entity.model.NewsView;

public interface RedisService {

	/**
	 * 添加评论信息
	 * 
	 * @param userid
	 *            当前用户ID
	 * @param usersrcid
	 *            评论/回复人
	 * @param content
	 *            评论内容
	 * @param contentType
	 *            0评论 1回复
	 */
	public void addListValue(String userid, String usersrcid, String content,
			String contenttype);

	/**
	 * 获取用户最新消息列表
	 * 
	 * @param userid
	 *            用户ID
	 * @return 消息列表
	 */
	public List<NewsView> findNewsViewList(String userid);

}
