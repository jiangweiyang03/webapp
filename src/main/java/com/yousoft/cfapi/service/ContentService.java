package com.yousoft.cfapi.service;

import java.util.List;

import com.yousoft.cfapi.entity.model.ContentView;
import com.yousoft.cfapi.entity.model.FriendPageView;

public interface ContentService {

	/**
	 * 发布内容信息
	 * 
	 * @param content
	 *            内容信息
	 * @param photolist
	 *            照片列表信息
	 * @param userid
	 *            当前用户ID
	 * @return
	 */
	public int pubContent(String content, String photolist, String userid);

	/**
	 * 展现当前用户朋友圈列表
	 * 
	 * @param userid
	 *            当前用户ID
	 * @param pagenum
	 *            展现当前页码
	 * @param pagesize
	 *            展现当前条目数
	 * @return
	 */
	public List<ContentView> findUserList(String userid, int pagenum,
			int pagesize);

	/**
	 * 展现朋友列表信息
	 * @param userid 	朋友ID
	 * @param pagenum   当前页码
	 * @param pagesize 	页面条数
	 * @return
	 */
	public FriendPageView findFriendPage(String userid, int pagenum,
			int pagesize);
	
	
	/**
	 * 根据消息ID展现消息详情
	 * @param textid  消息ID
	 * @return 消息详情
	 */
	public ContentView findContentDetails(String textid);

}
