package com.example.springboot.repository;

import java.util.Collection;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author yc
 * @version 1.0
 * @project redis 仓储接口
 * @description TODO
 * @date 2019-04-13 21:07
 */
public interface RedisRepository {

    boolean isExist(String key);            //验证是否存在key

    long countExist(Collection<String> keys);     //通过给定的key集合，验证存在几个key

    boolean expire(String key, long timeout, TimeUnit unit);      //通过给定的过期时间TimeUnit设置key过期

    boolean expireAt(String key, Date date);         //通过给定的日期 date 设置key过期

    long getExpire(String key, TimeUnit timeUnit);          //通过指定的key 获取过期时间

    Set<String> getKeys(String pattern);            //通过指定的表达式 获取keys

    void reKeyName(String oldKey, String newKey);       //将旧的key设置为新key

    boolean reKeyNameIfAbsent(String oldKey, String newKey);      //仅当newKey不存在时，将oldKey设置为newKey

    boolean deleteExpire(String key);            //通过指定的key移除过期时间

    long deleteKeys(String... keys);         //删除指定的key


}
