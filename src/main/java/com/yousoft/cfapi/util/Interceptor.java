package com.yousoft.cfapi.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 程序拦截器,用于记录请求前后的相应处理数据
 * @author jiangweiyang01
 * @version 1.0
 * @since 2015/06/02
 */
public class Interceptor implements HandlerInterceptor {
	
	private static Logger logger = LoggerFactory.getLogger(Interceptor.class);
	
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
//		logger.info("afterCompletion....");
//		logger.info(RequestUtil.getRequestParams(request));
	}
	
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
//		logger.info("postHandle....");
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// 请求处理之前处理
//		logger.info("preHandle....");
		return true;
	}

}
