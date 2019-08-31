package com.taotao.common.redis;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import com.alibaba.fastjson.JSONObject;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * redis连接池公共方法类
 * @author tedbai 2018-06-22
 *
 */
public class JeditCommon {

	private static JedisPool pool = null;

	/**
	 * 得到redis连接池中的连接实例
	 * @return
	 * @throws NullPointerException
	 */
	public static Jedis getJedis() throws NullPointerException{
		if (pool == null){
			throw new NullPointerException("获取redis连接实例时发生异常，连接池未初始化成功！");
		}
		return pool.getResource();
	}
	
	public static void init(String addr){
		init(null, addr);
	}
	
	public static void init(JedisPoolConfig jedisPoolConfig, String addr){
		if (jedisPoolConfig == null){
			pool = new JedisPool(new JedisPoolConfig(), addr);
		} else {
			pool = new JedisPool(jedisPoolConfig, addr);
		}
	}
	
	public static void init(String addr, int port){
		GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
//		poolConfig.setMaxTotal(8); // default 8
//		poolConfig.setMaxIdle(8); // default 8
//		poolConfig.setMinIdle(8); // default 8
		pool = new JedisPool(poolConfig, addr, port, 30000); // 30秒read timeout
	}
	
	public static void init(String addr, int port, String password){
		GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
//		poolConfig.setMaxTotal(8); // default 8
//		poolConfig.setMaxIdle(8); // default 8
//		poolConfig.setMinIdle(8); // default 8
		if (password == null || password.trim().length() == 0) {
			pool = new JedisPool(poolConfig, addr, port, 30000); // 30秒read timeout
		} else {
			pool = new JedisPool(poolConfig, addr, port, 30000, password); // 30秒read timeout
		}
		
	}

	public static String getCacheKey(String... args) {
		
		if (args == null){
			throw new NullPointerException("缓存key不能为空！");
		}
		String[] array = args;
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < args.length; i++){
			if (i != 0){
				sb.append("-");
			}
			sb.append(array[i]);
		}
		return sb.toString();
	}
	
	public static void set(String key, String value){
		Jedis jedis = JeditCommon.getJedis();
		try{
			jedis.set(key, value);
		} finally {
			jedis.close();
		}
	}
	
	public static String get(String key){
		Jedis jedis = JeditCommon.getJedis();
		try{
			return jedis.get(key);
		} finally {
			jedis.close();
		}
	}
	
	public static long expire(String key, int seconds){
		Jedis jedis = JeditCommon.getJedis();
		try{
			return jedis.expire(key, seconds);
		} finally {
			jedis.close();
		}
	}
	
	/**
	 * 设置key值和过期时间，当存在key值时，重置value和过期时间
	 * @param key
	 * @param seconds
	 * @param value
	 * @return
	 */
	public static String setex(String key, int seconds, String value){
		Jedis jedis = JeditCommon.getJedis();
		try{
			return jedis.setex(key, seconds, value);
		} finally {
			jedis.close();
		}
	}
	
	public static Long del(String key){
		Jedis jedis = JeditCommon.getJedis();
		try{
			Long effect = jedis.del(key);
			return effect;
		} finally {
			jedis.close();
		}
	}
	
	public static void redisLoad() {
		InputStream in;
		HashMap<String,String> resourceMap=new HashMap<>();
	    try{
	    	Properties prop = new Properties();   
	    	in = new FileInputStream("classpath:resource/resource.properties");
	        prop.load(in);
	        Iterator<String> it=prop.stringPropertyNames().iterator();
	        while(it.hasNext()){
	        	String key=it.next();
	               resourceMap.put(key, prop.getProperty(key));
	            }
	    	in.close();
	        }catch (Exception e) {
				e.printStackTrace();
			}
		init(resourceMap.get("redis_addr"), Integer.parseInt(resourceMap.get("redis_port")), resourceMap.get("redis_password"));
		set("resourceMap", JSONObject.toJSONString(resourceMap));
	}
}
