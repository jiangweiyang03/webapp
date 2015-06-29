package com.yousoft.cfapi.util;

public interface CacheService {
	
	/**
	 * 往Cache中添加缓存数据
	 * @param key 缓存Key值
	 * @param value 缓存Value值
	 * @throws RuntimeException 程序运行过程中抛出的异常信息
	 */
	public void putCacheValue(String key,Object value) throws RuntimeException;
	
	/**
	 * 从Cache中获取缓存数据
	 * @param key 缓存Key值
	 * @return	缓存数据
	 * @throws RuntimeException	程序运行过程中抛出的异常信息
	 */
	public Object getCacheValue(String key) throws RuntimeException;
	
	/**
	 * 清空缓存数据
	 * @throws RuntimeException 程序运行中抛出的异常信息
	 */
	public void emptyCache() throws RuntimeException;
	
	/**
	 * 加载系统中基本的缓存信息
	 * @throws RuntimeException 程序运行中抛出的异常信息
	 */
	public void loadBasicCache() throws RuntimeException;
	

}
