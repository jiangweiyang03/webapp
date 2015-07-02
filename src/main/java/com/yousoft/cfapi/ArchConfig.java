package com.yousoft.cfapi;

public class ArchConfig {
	/**Redis缓存配置**/
	public static String RedisAddr = "localhost";
	public static int RedisPort = 6379;
	public static String AuthValue = "admin";
	public static int MaxActive = 1024;
    public static int MaxIdel = 200;
    public static int MaxWait = 10000;
    public static int TimeOut = 10000;
    public static boolean TestOnBorrow = true;
	public static String getRedisAddr() {
		return RedisAddr;
	}
	public static void setRedisAddr(String redisAddr) {
		RedisAddr = redisAddr;
	}
	public static int getRedisPort() {
		return RedisPort;
	}
	public static void setRedisPort(int redisPort) {
		RedisPort = redisPort;
	}
	public static String getAuthValue() {
		return AuthValue;
	}
	public static void setAuthValue(String authValue) {
		AuthValue = authValue;
	}
	public static int getMaxActive() {
		return MaxActive;
	}
	public static void setMaxActive(int maxActive) {
		MaxActive = maxActive;
	}
	public static int getMaxIdel() {
		return MaxIdel;
	}
	public static void setMaxIdel(int maxIdel) {
		MaxIdel = maxIdel;
	}
	public static int getMaxWait() {
		return MaxWait;
	}
	public static void setMaxWait(int maxWait) {
		MaxWait = maxWait;
	}
	public static int getTimeOut() {
		return TimeOut;
	}
	public static void setTimeOut(int timeOut) {
		TimeOut = timeOut;
	}
	public static boolean isTestOnBorrow() {
		return TestOnBorrow;
	}
	public static void setTestOnBorrow(boolean testOnBorrow) {
		TestOnBorrow = testOnBorrow;
	}
}
