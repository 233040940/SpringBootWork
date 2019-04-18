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
 * @description TODO
 * @date 2019-04-13 21:48
 */

@Component
public class RedisRepositoryImpl implements RedisRepository {

    @Autowired
    @Qualifier("stringRedisTemplate")
    private RedisTemplate redisTemplate;
    @Override
    public boolean isExist(String key) {
        return redisTemplate.hasKey(key);
    }

    @Override
    public long countExist(Collection<String> keys) {
        return redisTemplate.countExistingKeys(keys);
    }

    @Override
    public boolean expire(String key, long timeout, TimeUnit unit) {
        return redisTemplate.expire(key,timeout,unit);
    }

    @Override
    public boolean expireAt(String key, Date date) {
        return redisTemplate.expireAt(key,date);
    }

    @Override
    public long getExpire(String key, TimeUnit timeUnit) {
        return redisTemplate.getExpire(key,timeUnit);
    }

    @Override
    public Set<String> getKeys(String pattern) {
        return redisTemplate.keys(pattern);
    }

    @Override
    public void reKeyName(String oldKey, String newKey) {
        redisTemplate.rename(oldKey,newKey);
    }

    @Override
    public boolean reKeyNameIfAbsent(String oldKey, String newKey) {
        return redisTemplate.renameIfAbsent(oldKey,newKey);
    }

    @Override
    public boolean deleteExpire(String key) {
        return redisTemplate.persist(key);
    }

    @Override
    public long deleteKeys(String... keys) {
        return redisTemplate.delete(Sets.newHashSet(keys));
    }
}
