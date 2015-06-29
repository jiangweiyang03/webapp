package com.yousoft.cfapi.service;

public interface ContentService {
	
	/**
	 * 发布内容信息
	 * @param content 内容信息
	 * @param photolist 照片列表信息
	 * @param userid 当前用户ID
	 * @return
	 */
	public int pubContent(String content,String photolist,String userid);

}
