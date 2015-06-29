package com.yousoft.cfapi.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ResponseUtil {

	/**json处理中间转换工具**/
	private static ObjectMapper mapper = new ObjectMapper();
	
	/**
	 * 向前台返回成功信息
	 * @param object 返回结果对象
	 * @return	解析之后错误信息
	 */
	public static Object success(Object object) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("state", ArchState.SUCCESS.getState());
		map.put("message", ArchState.SUCCESS.getMessage());
		map.put("result", object);
		return new ResponseEntity<Object>(map, HttpStatus.OK);
	}
	
	/**
	 * 向前台返回异常信息
	 * @param object 返回结果对象
	 * @return	解析之后错误信息
	 */
	public static Object exception(Object object) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("state", ArchState.EXCEPTION.getState());
		map.put("message", ArchState.EXCEPTION.getMessage());
		map.put("result", object);
		return new ResponseEntity<Object>(map, HttpStatus.EXPECTATION_FAILED);
	}

}
