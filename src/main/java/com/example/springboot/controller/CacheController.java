package com.example.springboot.controller;

import com.example.springboot.ResponseResult;
import com.example.springboot.entity.UserPO;
import com.example.springboot.service.CacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author yc
 * @version 1.0
 * @project springboot
 * @description TODO
 * @date 2019-05-13 22:02
 */
@Controller
@Slf4j
public class CacheController {

    @Autowired
    private CacheService cacheService;


    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;


    @RequestMapping("/cache")
    @ResponseBody
    public ResponseResult findUser(@RequestParam Integer id) {

        UserPO po=cacheService.findUsers(id);

         // redisTemplate.opsForValue().set("test::user::1",po,1, TimeUnit.MINUTES);

        return ResponseResult.builder().code(200).message("success").data(po).build();
    }
}
