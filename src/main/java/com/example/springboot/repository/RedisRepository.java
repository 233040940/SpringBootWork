package com.example.springboot.repository;

import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author yc
 * @version 1.0
 * @project springboot
 * @description redis仓库
 * @date 2019-04-13 21:48
 */

@Component
public class RedisRepository {

    @Autowired
    @Qualifier("stringRedisTemplate")
    private RedisTemplate redisTemplate;

    public boolean isExist(String key) {
        return redisTemplate.hasKey(key);
    }

    public long countExist(Collection<String> keys) {
        return redisTemplate.countExistingKeys(keys);
    }

    public boolean expire(String key, long timeout, TimeUnit unit) {
        return redisTemplate.expire(key,timeout,unit);
    }

    public boolean expireAt(String key, Date date) {
        return redisTemplate.expireAt(key,date);
    }

    public long getExpire(String key, TimeUnit timeUnit) {
        return redisTemplate.getExpire(key,timeUnit);
    }

    public Set<String> getKeys(String pattern) {
        return redisTemplate.keys(pattern);
    }

    public void reKeyName(String oldKey, String newKey) {
        redisTemplate.rename(oldKey,newKey);
    }

    public boolean reKeyNameIfAbsent(String oldKey, String newKey) { return redisTemplate.renameIfAbsent(oldKey,newKey); }

    public boolean removeExpire(String key) {
        return redisTemplate.persist(key);
    }

    public long deleteKeys(String... keys) {
        return redisTemplate.delete(Sets.newHashSet(keys));
    }
}
