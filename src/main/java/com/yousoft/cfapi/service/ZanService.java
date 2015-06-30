package com.yousoft.cfapi.service;

import java.util.List;

import com.yousoft.cfapi.entity.Zandetail;

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
	 * 根据文本ID获取所有的点赞信息
	 * @param textid 内容ID
	 * @return
	 */
	public List<Zandetail> getZanDetailsByTextId(String textid);

}
