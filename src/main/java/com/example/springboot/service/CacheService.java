package com.example.springboot.service;


import com.example.springboot.ResponseResult;
import com.example.springboot.entity.UserPO;
import com.example.springboot.repository.UserRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yc
 * @version 1.0
 * @project springboot
 * @description 演示spring cache以redis作为缓存（默认spring cache采用ConcurrentMap作为缓存）
 * @date 2019-05-13 22:00
 */
@Service
@CacheConfig(cacheNames="products")
public class CacheService {

    @Autowired
    private UserRepository userRepository;
    @Cacheable(keyGenerator = "keyGenerator")
    public UserPO findUsers(int id){

      return userRepository.find(id);          //如果缓存不存在则查询数据库并写入缓存,存在则立即返回
    }

    @CachePut(keyGenerator="keyGenerator")
    public List cachePut(Object ...prams){

        return Lists.newArrayList("hello","world");       //只做演示，实际开发是插入数据库和写入缓存。它与@Cacheable区别在于就算存在缓存也会走数据库
    }

    @CacheEvict(keyGenerator="keyGenerator")
    public ResponseResult delet(Object...prams){

        return  ResponseResult.builder().code(200).message("success").build();      //只做演示，实际开发是走数据库删除，和删除缓存
    }

}
