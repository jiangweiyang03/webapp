package com.yousoft.cfapi.util;

import com.yousoft.cfapi.ArchConfig;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Redis操作工具类
 * @author jiangweiyang01
 * @version 1.0
 * @since 2015/07/02
 */
public class RedisUtils {
    
    private static String ADDR = ArchConfig.RedisAddr;
    private static int PORT = ArchConfig.RedisPort;
    private static String AUTH = ArchConfig.AuthValue;
    private static int MAX_ACTIVE = ArchConfig.MaxActive;
    private static int MAX_IDLE = ArchConfig.MaxIdel;
    private static int MAX_WAIT = ArchConfig.MaxWait;
    private static int TIMEOUT = ArchConfig.TimeOut;
    private static boolean TEST_ON_BORROW = ArchConfig.TestOnBorrow;
    
    private static JedisPool jedisPool = null;
    
    /**
     * 初始化Redis连接池
     */
    static {
        try {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(MAX_ACTIVE);
            config.setMaxIdle(MAX_IDLE);
            config.setMaxWaitMillis(MAX_WAIT);
            config.setTestOnBorrow(TEST_ON_BORROW);
            jedisPool = new JedisPool(config, ADDR, PORT, TIMEOUT, AUTH);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 获取Jedis实例
     * @return
     */
    protected synchronized static Jedis getJedis() {
        try {
            if (jedisPool != null) {
                Jedis resource = jedisPool.getResource();
                return resource;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * 释放jedis资源
     * @param jedis
     */
    protected static void returnResource(final Jedis jedis) {
        if (jedis != null) {
        	jedisPool.returnResourceObject(jedis);
        }
    }
}