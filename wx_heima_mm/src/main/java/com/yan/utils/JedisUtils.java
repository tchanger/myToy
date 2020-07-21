package com.yan.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

/**
 * @author liuyp
 * @date 2020/07/02
 */
public class JedisUtils {
    private static JedisPool pool = null;
    static {
        //从类路径里加载
        ResourceBundle bundle = ResourceBundle.getBundle("jedis");

        String maxTotal = bundle.getString("jedis.maxTotal");
        String maxIdle = bundle.getString("jedis.maxIdle");
        String host = bundle.getString("jedis.host");
        String port = bundle.getString("jedis.port");

        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(Integer.parseInt(maxTotal));
        config.setMaxIdle(Integer.parseInt(maxIdle));

        pool = new JedisPool(config, host, Integer.parseInt(port));
    }

    public static Jedis getJedis(){
        return pool.getResource();
    }

    public static void set(String key, String value){
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.set(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public static String get(String key){
        Jedis jedis = null;
        try {
            jedis = JedisUtils.getJedis();
            return jedis.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return null;
    }

    public static void del(String key){
        Jedis jedis = null;
        try {
            jedis = JedisUtils.getJedis();
            jedis.del(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
}
