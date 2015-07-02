package com.yousoft.cfapi.service;

import java.util.List;

/**
 * 赞接口
 * @author jiangweiyang01
 */
public interface ZanService {
	
	/**
	 * 根据消息ID查询所有点赞用户ID集合
	 * @param textid 内容ID
	 * @return
	 */
	public List<String> findUserIdListByTextId(String textid);
	
	/**
	 * 为消息点赞
	 * @param textid 消息ID
	 * @param userid 当前赞的用户ID
	 */
	public void addZan(String textid,String userid);
	
	/**
	 * 取消消息赞
	 * @param textid 消息ID
	 * @param userid 当前取消赞的用户ID
	 */
	public void cancleZan(String textid,String userid);
	
}
