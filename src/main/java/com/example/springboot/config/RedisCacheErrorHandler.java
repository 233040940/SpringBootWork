package com.example.springboot.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.interceptor.CacheErrorHandler;

/**
 * @author yc
 * @version 1.0
 * @project springboot
 * @description redisCacheErrorHandler  简单处理redis缓存出现异常情况,以免导致程序不能继续执行
 * @date 2019-05-15 18:57
 */
@Slf4j
public class RedisCacheErrorHandler implements CacheErrorHandler {


    @Override
    public void handleCacheGetError(RuntimeException exception, Cache cache, Object key) {

        log.warn("------handleCacheGetError" + exception.getMessage() + ",cache:" + cache.getName() + ",key" + key);
    }

    @Override
    public void handleCachePutError(RuntimeException exception, Cache cache, Object key, Object value) {


        log.warn("------handleCachePutError" + exception.getMessage() + ",cache:" + cache.getName() + ",key" + key);
    }

    @Override
    public void handleCacheEvictError(RuntimeException exception, Cache cache, Object key) {


        log.warn("------handleCacheEvictError" + exception.getMessage() + ",cache:" + cache.getName() + ",key" + key);
    }

    @Override
    public void handleCacheClearError(RuntimeException exception, Cache cache) {


        log.warn("------handleCacheClearError" + exception.getMessage() + ",cache:" + cache.getName());
    }
}
