package com.yousoft.cfapi.service;

/**
 * 朋友圈权限设置事宜
 * @author jiangwy
 * @date 2015/07/04
 */
public interface PrivilegeService {
	
	/**好友关系超过一组**/
	public static int MORERELATION = 1;
	/**没有找到匹配的好友关系**/
	public static int NOTFOUND = 2;
	
	
	/**
	 * 不看对方朋友圈列表信息
	 * @param userid		当前用户ＩＤ
	 * @param destuserid	对方朋友用户ＩＤ
	 * @param value		修改权限值
	 */
	public int proOthersList(String userid,String destuserid,String value);
	
	
	/**
	 * 不希望朋友看自己的朋友圈信息
	 * @param userid		当前用户ＩＤ
	 * @param destuserid	对方朋友用户ＩＤ
	 * @param value 修改权限值
	 */
	public int proSelfToOthers(String userid,String destuserid,String value);
	
	/**
	 * 关联用户与朋友的对应关系
	 * @param userid		当前用户ＩＤ
	 * @param destuserid	朋友用户ＩＤ
	 * @param type			关系处理类型 0确认 1取消
	 * @return
	 */
	public int relationDeal(String userid,String destuserid,String type);

}
