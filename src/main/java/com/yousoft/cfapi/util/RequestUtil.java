package com.yousoft.cfapi.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpInputMessage;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Request Tools class
 * 
 * @author jiangweiyang01
 * @since 2015/06/02
 * @version 1.0
 */
public final class RequestUtil {
	
	/**logger object.**/
	private static final Logger logger = LoggerFactory.getLogger(RequestUtil.class);
	/** json parse object. **/
	private static ObjectMapper mapper = new ObjectMapper();
	/** ip length. **/
	private static final int IP_LENTH = 15;
	/** constructor. **/
	private RequestUtil() {
	}

	/**
	 * get request all paramters.
	 * 
	 * @param request
	 *            httprequest
	 * @return String
	 */
	public static String getRequestParams(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("realip", getRequestIp(request));
		map.put("paramters", getParamters(request));
		map.put("headers", getHeaders(request));
		map.put("cookie", getCookie(request));
		String jsonString = "";
		try {
			jsonString = mapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
		}
		return jsonString;
	}

	/**
	 * 获取客户端ip.
	 * 
	 * @param request
	 *            httprequest
	 * @return String
	 */
	private static String getRequestIp(HttpServletRequest request) {
		String ip = "";
		try {
			ip = request.getHeader("x-forwarded-for");
			if (ip == null || ip.length() == 0
					|| "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("Proxy-Client-IP");
			}
			if (ip == null || ip.length() == 0
					|| "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("WL-Proxy-Client-IP");
			}
			if (ip == null || ip.length() == 0
					|| "unknown".equalsIgnoreCase(ip)) {
				ip = request.getRemoteAddr();
			}
			// 防止多级ip代理，生成多个ip，第一个为真实ip
			if (!StringUtils.isEmpty(ip) && ip.length() > IP_LENTH
					&& ip.indexOf(",") > 0) {
				ip = ip.substring(0, ip.indexOf(","));
			}
		} catch (RuntimeException e) {
			logger.error("从request中获取ip失败,失败原因:" + ExceptionUtils.getMessage(e));
		}

		return ip;
	}

	/**
	 * get request parameters.
	 * 
	 * @param request
	 *            httprequest
	 * @return Map
	 */
	private static Map<String, String> getParamters(HttpServletRequest request) {
		Map<String, String[]> paramterMap = request.getParameterMap();
		Map<String, String> map = new HashMap<String, String>();
		Iterator<String> it = paramterMap.keySet().iterator();
		String key;
		String[] values;
		while (it.hasNext()) {
			key = it.next();
			values = paramterMap.get(key);
			map.put(key, values[0]);
		}
		return map;
	}

	/**
	 * get request headers.
	 * 
	 * @param request
	 *            httprequest
	 * @return Map
	 */
	private static Map<String, String> getHeaders(HttpServletRequest request) {
		Map<String, String> headers = new HashMap<String, String>();
		Enumeration<String> namesEnumeration = request.getHeaderNames();
		while (namesEnumeration.hasMoreElements()) {
			String name = namesEnumeration.nextElement();
			Enumeration<String> valueEnumeration = request.getHeaders(name);
			StringBuffer values = new StringBuffer();
			while (valueEnumeration.hasMoreElements()) {
				values.append(",").append(valueEnumeration.nextElement());
			}
			headers.put(name, values.deleteCharAt(0).toString());
		}
		return headers;
	}

	/**
	 * get cookie String.
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param key
	 *            String
	 * @return String
	 */
	public static String getCookie(HttpServletRequest request) {
		try {
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				StringBuffer buffer = new StringBuffer();
				for (final Cookie cookie : cookies) {
					buffer.append("[").append(cookie.getName()).append("]")
						.append(cookie.getValue()).append(";");
				}
				return buffer.toString();
			}
		} catch (RuntimeException e) {
			logger.error("获取cookie时发生错误:"+ExceptionUtils.getMessage(e));
		}
		return null;
	}
	
	
    /**
     * 
     * @param javaType JavaType
     * @param inputMessage HttpInputMessage
     * @param objectMapper ObjectMapper
     * @return Object
     * @throws IOException IOException
     */
    public static Object readRequestBody(JavaType javaType, HttpInputMessage inputMessage, ObjectMapper objectMapper)
            throws IOException {
        String data = null;
        Object paramters = null;
        // HttpHeaders HttpHeaders = inputMessage.getHeaders();
        InputStream in = inputMessage.getBody();
        StringBuffer out = new StringBuffer();
        byte[] b = new byte[4096];
        for (int n; (n = in.read(b)) != -1;) {
            out.append(new String(b, 0, n));
        }
        data = out.toString();
        if (data != null) {
            paramters = objectMapper.readValue(data, javaType);
        }
        return paramters;

    }

}
