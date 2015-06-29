package com.yousoft.cfapi.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/***
 * 抽象控制器
 * 
 * @author jiangweiyang01
 * @version 1.0
 * @since
 */
public abstract class AbstractArchController {
	/** 当前用户对象 **/
	public static final String CURRENTUSER = "currentuser";

	/**
	 * 封装返回的参数信息
	 * 
	 * @param value
	 *            封装result结果信息
	 * @return 返回到前端的结果封装体
	 */
	public Object success(Object value) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("status", "0");
		resultMap.put("result", value);
		return resultMap;
	}
	

	/**
	 * 封装返回的参数信息
	 * 
	 * @param value
	 *            封装result结果信息
	 * @return 返回至前端的结果封装体
	 */
	public Object error(Object value) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("status", 1);
		resultMap.put("result", value);
		return resultMap;
	}


}
