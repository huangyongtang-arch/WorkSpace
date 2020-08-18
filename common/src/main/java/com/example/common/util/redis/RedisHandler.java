package com.example.common.util.redis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
//import com.rratchet.scala.util.ObjectTranscoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.annotation.PostConstruct;
import java.util.*;


@Component
public class RedisHandler {

	private static JedisPool jedisPool;

	@Value("${spring.redis.host}")
	private String host;

	@Value("${spring.redis.port}")
	private int port;

	@Value("${spring.redis.password}")
	private String password;

	@Value("${spring.redis.database}")
	private int database;

	@Value("${spring.redis.timeout}")
	private int timeout;

	@Value("${spring.redis.pool.max-active}")
	private int maxActive;

	@Value("${spring.redis.pool.max-wait}")
	private long  maxWait;

	@Value("${spring.redis.pool.max-idle}")
	private int maxIdle;

	/**
	 * 初始化REDIS
	 */
	@PostConstruct
	public void init(){
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxIdle(this.maxIdle);
		poolConfig.setMaxTotal(this.maxActive);
		poolConfig.setMaxWaitMillis(this.maxWait);
		jedisPool = new JedisPool(poolConfig, this.host,this.port,this.timeout,this.password,this.database);
	}

	/**
	 * 发布
	 */
	public Long publish(String channel,String msg) {
		Jedis jedis = null;
		try {
			jedis = RedisHandler.getJedis();
			return jedis.publish(channel, msg);
		} catch (Exception e) {
			return -1L;
		}finally{
			this.closeConnect(jedis);
		}
	}

	/**
	 * 退出redis
	 */
	public static void close(){
		if(jedisPool != null){
			jedisPool.close();
		}
	}

	/**
	 * 回收REDIS连接
	 * @param jedis
	 */
	public void closeConnect(Jedis jedis) {
		try {
			jedis.close();
		} catch (Exception e) {
			if (jedis.isConnected()) {
				jedis.quit();
				jedis.disconnect();
			}
		}
	}

	/**
	 * 获取连接
	 * @return
	 */
	public static Jedis getJedis() {
		Jedis jedis = jedisPool.getResource();
		return jedis;
	}

	/**
	 * 自增
	 * @param strIncr
	 * @return
	 */
	public Long getInrc(String strIncr){
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.incr(strIncr);
		} catch (Exception e) {
			return (long) 0;
		}finally{
			this.closeConnect(jedis);
		}
	}

	/**
	 * 如果key不存在，创建key；如果key存在，返回创建key失败
	 * @param key
	 * @return
	 */
	public Long setIfNoExsitsKey(String key){
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.setnx(key, "0");
		} catch (Exception e) {
			return (long) 0;
		}finally{
			this.closeConnect(jedis);
		}
	}

	/**
	 * 如果key不存在，创建key；如果key存在，返回创建key失败
	 * 并且设置key过期时间
	 * @param key
	 * @return
	 */
	public Long setIfNoExsitsKeyAndSetKeyTimeOut(String key,String value,int timeOut){
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			long result = jedis.setnx(key, value);
			if(result == 1){
				jedis.expire(key, timeOut);
				return (long) 1;
			}else{
				return (long) 0;
			}
		} catch (Exception e) {
			return (long) 0;
		}finally{
			this.closeConnect(jedis);
		}
	}

	/**
	 * 设置key失效时间,key失效了会被自动删除
	 * @param key
	 * @return
	 */
	public Long setKeyTimeOut(String key,int timeOut){
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.expire(key, timeOut);
		} catch (Exception e) {
			return (long) 0;
		}finally{
			this.closeConnect(jedis);
		}
	}

	/**
	 * 设置key失效时间,key失效了会被自动删除
	 * @param key
	 * @return
	 */
	public Long setSerializeKeyTimeOut(String key,int timeOut){
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.expire(key.getBytes(), timeOut);
		} catch (Exception e) {
			return (long) 0;
		}finally{
			this.closeConnect(jedis);
		}
	}

	/**
	 * 判断是否存在key
	 * @param key
	 * @return
	 */
	public boolean exsitsKey(String key){
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.exists(key);
		} catch (Exception e) {
			return false;
		}finally{
			this.closeConnect(jedis);
		}
	}

	/**
	 * 获取value
	 * @return
	 */
	public String get(String key){
		Jedis jedis = null;
		String vulue = null;
		try {
			jedis = jedisPool.getResource();
			vulue = jedis.get(key);
		} catch (Exception e) {
			vulue = null;
		}finally{
			this.closeConnect(jedis);
		}
		return vulue;
	}

	/**
	 * 设置value
	 * @param key
	 * @param value
	 * @return
	 */
	public void set(String key,String value){
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.set(key, value);
		} catch (Exception e) {

		}finally{
			this.closeConnect(jedis);
		}
	}

	/**
	 * 设置value，累加value值
	 * @param key
	 * @param value
	 * @return
	 */
	public void incrBy(String key,Integer value){
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.incrBy(key, value);
		} catch (Exception e) {

		}finally{
			this.closeConnect(jedis);
		}
	}

	/**
	 * 设置value，累加value值 ，每次加1
	 * @param key
	 * @return
	 */
	public long incr(String key){
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.incr(key);
		} catch (Exception e) {
			return new Random().nextInt(9999);
		}finally{
			this.closeConnect(jedis);
		}
	}

	/**
	 * 设置value ,并且设置key的过期时间
	 * @param key
	 * @param value
	 * @return
	 */
	public void setAndSetKeyTimeOut(String key,String value,int timeOut){
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.set(key, value);
			jedis.expire(key, timeOut);
		} catch (Exception e) {

		}finally{
			this.closeConnect(jedis);
		}
	}

	/**
	 * 移除key
	 * @param key
	 * @return
	 */
	public Long delete(String key){
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.del(key);
		} catch (Exception e) {
			return (long) 0;
		}finally{
			this.closeConnect(jedis);
		}
	}

	/**
	 * 模糊移除所有key为前缀
	 * @param key
	 * @return
	 */
	public Long vagueDelete(String key){
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			Set<String> set = jedis.keys(key + "*");
			Iterator<String> it = set.iterator();
			while(it.hasNext()){
				String keyStr = it.next();
				jedis.del(keyStr);
			}
			return (long) 1;
		} catch (Exception e) {
			return (long) 0;
		}finally{
			this.closeConnect(jedis);
		}
	}

	/**
	 * 模糊移除所有包含key的记录
	 * @param key
	 * @return
	 */
	public Long vagueContainDelete(String key){
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			Set<String> set = jedis.keys("*"+ key + "*");
			Iterator<String> it = set.iterator();
			while(it.hasNext()){
				String keyStr = it.next();
				jedis.del(keyStr);
			}
			return (long) 1;
		} catch (Exception e) {
			return (long) 0;
		}finally{
			this.closeConnect(jedis);
		}
	}

	/**
	 * 模糊查找
	 * @param key
	 * @return
	 */
	public Set<String> vagueGet(String key){
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			Set<String> set = jedis.keys(key + "*");
			return set;
		} catch (Exception e) {
			return null;
		}finally{
			this.closeConnect(jedis);
		}
	}

	/**
	 * 获取List
	 * @param key
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Object> getList(String key) throws Exception{
		Jedis jedis = null;
		List<Object> value = null;
		try {
			jedis = jedisPool.getResource();
			List<String> entitys = jedis.lrange(key, 0, -1);
			if(entitys.size() > 0){
				value = JSON.parseObject(entitys.toString(), List.class);
			}
		} catch (Exception e) {
			throw new Exception();
		}finally{
			this.closeConnect(jedis);
		}
		return value;
	}

	/**
	 * 设置List
	 * @param key
	 * @param list
	 * @throws Exception
	 */
	public void setList(String key,List<Object> list) throws Exception{
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			for(Object object:list){
				jedis.lpush(key, JSON.toJSONString(object));
			}
		} catch (Exception e) {
			throw new Exception();
		}finally{
			this.closeConnect(jedis);
		}
	}

	/**
	 * 设置List
	 * @param key
	 * @param object
	 * @throws Exception
	 */
	public void lpush(String key,Object object) throws Exception{
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.lpush(key, JSON.toJSONString(object));
		} catch (Exception e) {
			throw new Exception();
		}finally{
			this.closeConnect(jedis);
		}
	}

	/**
	 * 移除List中指定不在指定范围的元素
	 * @param key
	 * @throws Exception
	 */
	public void ltrim(String key,int start,int end) throws Exception{
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.ltrim(key,start,end);
		} catch (Exception e) {
			throw new Exception();
		}finally{
			this.closeConnect(jedis);
		}
	}

	/**
	 * 移除List中指定
	 * @param key
	 * @throws Exception
	 */
	public void lrem(String key,long count,String value) throws Exception{
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.lrem(key,count,value);
		} catch (Exception e) {
			throw new Exception();
		}finally{
			this.closeConnect(jedis);
		}
	}

	/**
	 * 列表 key 下标为 index 的元素的值设置为 value
	 * @param key
	 * @throws Exception
	 */
	public void  lset(String key,int index,Object object) throws Exception{
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.lset(key,index,JSON.toJSONString(object));
		} catch (Exception e) {
			throw new Exception();
		}finally{
			this.closeConnect(jedis);
		}
	}

	/**
	 * 获取map
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public Map<String,String> getMap(String key) throws Exception{
		Jedis jedis = null;
		Map<String, String> value = null;
		try {
			jedis = jedisPool.getResource();
			value = jedis.hgetAll(key);
		} catch (Exception e) {
			throw new Exception();
		}finally{
			this.closeConnect(jedis);
		}
		return value;
	}

	/**
	 * 获取mapValue
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public String getMapValue(String key,String mapKey) throws Exception{
		Jedis jedis = null;
		String value = null;
		try {
			jedis = jedisPool.getResource();
			value = jedis.hget(key,mapKey);
		} catch (Exception e) {
			throw new Exception();
		}finally{
			this.closeConnect(jedis);
		}
		return value;
	}

	/**
	 * 设置map
	 * @param key
	 * @param mapKey
	 * @throws Exception
	 */
	public void setMapValue(String key,String mapKey,String mapValue) throws Exception{
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.hset(key,mapKey,mapValue);
		} catch (Exception e) {
			throw new Exception();
		}finally{
			this.closeConnect(jedis);
		}
	}

	/**
	 * 获取object
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public JSONObject getObject(String key ) throws Exception{
		Jedis jedis = null;
		JSONObject value = null;
		try {
			jedis = jedisPool.getResource();

			String result = jedis.get(key);
			if(result != null){
				value = JSON.parseObject(result);
			}
		} catch (Exception e) {
			throw new Exception();
		}finally{
			this.closeConnect(jedis);
		}
		return value;
	}

	/**
	 * 设置object
	 * @param key
	 * @throws Exception
	 */
	public void setObject(String key,Object t) throws Exception{
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.set(key, JSON.toJSONString(t));
		} catch (Exception e) {
			throw new Exception();
		}finally{
			this.closeConnect(jedis);
		}
	}

	/**
	 * 设置object
	 * @param key
	 * @throws Exception
	 */
//	public void setObjectAndTimeOut(String key,Object object,int timeOut) throws Exception{
//		Jedis jedis = null;
//		try {
//			jedis = jedisPool.getResource();
//			jedis.set(key.getBytes(), ObjectTranscoder.serialize(object));
//			jedis.expire(key.getBytes(), timeOut);
//		} catch (Exception e) {
//			throw new Exception();
//		}finally{
//			this.closeConnect(jedis);
//		}
//	}

	/**
	 * 获取key过期时间
	 * @return
	 */
	public Long getTTL(String key){
		Jedis jedis = null;
		long ttl = 0;
		try {
			jedis = jedisPool.getResource();
			ttl = jedis.ttl(key);
		} catch (Exception e) {
			ttl = -1;
		}finally{
			this.closeConnect(jedis);
		}
		return ttl;
	}

}
