package org.leesia.resource.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Auther: leesia
 * @Date: 2018/7/25 13:19
 * @Description:
 */
@Service("redisService")
public class RedisService {
    @Autowired
    StringRedisTemplate stringRedisTemplate;


    @Resource(name = "stringRedisTemplate")
    ValueOperations<String, String> stringValues;

    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    @Resource(name = "redisTemplate")
    ValueOperations<Object, Object> objectValues;

    /**
     * 根据指定key获取String
     *
     * @param key
     * @return
     */
    public String getString(String key) {
        return stringValues.get(key);
    }

    /**
     * 设置Str缓存
     *
     * @param key
     * @param val
     */
    public void setString(String key, String val) {
        stringValues.set(key, val);
    }

    /**
     * 删除指定key
     *
     * @param key
     */
    public void deleteString(String key) {
        stringRedisTemplate.delete(key);
    }

    /**
     * 根据指定o获取Object
     *
     * @param o
     * @return
     */
    public Object getObject(Object o) {
        return objectValues.get(o);
    }

    /**
     * 设置obj缓存
     *
     * @param o1
     * @param o2
     */
    public void setObject(Object o1, Object o2) {
        objectValues.set(o1, o2);
    }

    /**
     * 删除Obj缓存
     *
     * @param o
     */
    public void deleteObject(Object o) {
        redisTemplate.delete(o);
    }
}
