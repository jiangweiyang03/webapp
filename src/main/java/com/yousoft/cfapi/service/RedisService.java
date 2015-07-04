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
	 *            0评论 1回复 2点赞
	 * @param value 0确认 1删除
	 */
	public void addListValue(String userid, String usersrcid, String content,
			String contenttype, String value);

	/**
	 * 获取用户最新消息列表
	 * 
	 * @param userid
	 *            用户ID
	 * @return 消息列表
	 */
	public List<NewsView> findNewsViewList(String userid);

	/**
	 * 发布者发布新内容
	 * 
	 * @param userid
	 *            发布者用户ＩＤ
	 */
	public void addNews(String userid);

	/**
	 * 判断用户当前是否有新的朋友圈更新
	 * 
	 * @param userid
	 *            当前用户ＩＤ
	 * @return
	 */
	public boolean isNews(String userid);

	/**
	 * 更新朋友关系
	 * 
	 * @param userid
	 *            当前用户ＩＤ
	 * @param userdestid
	 *            朋友用户ＩＤ
	 * @param relationtype
	 *            更新类型0确认 1取消
	 */
	public void updateRelation(String userid, String userdestid,
			String relationtype);

	/**
	 * 更新权限信息权限
	 * 
	 * @param userid
	 *            当前用户ID
	 * @param userdestid
	 *            朋友用户ID
	 * @param pritype
	 *            权限类型 0不看对方朋友圈 1不让朋友看自己的朋友圈
	 * @param privalue
	 *            权限值 0确认 1取消
	 */
	public void updatePrivilege(String userid, String userdestid,
			String pritype, String privalue);

}
