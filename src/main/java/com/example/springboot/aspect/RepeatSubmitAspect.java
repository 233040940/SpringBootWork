package com.example.springboot.aspect;

import com.example.springboot.ResponseResult;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * @author yc
 * @version 1.0
 * @project springboot
 * @description 采用spring aop自定义注解做重复提交拦截
 * @date 2019-04-20 18:03
 */
@Aspect
@Component
@Slf4j
public final class RepeatSubmitAspect {

    private static final Cache<String, String> CACHES = CacheBuilder.newBuilder()         //采用guava包提供的Cache

            .maximumSize(100)             // 最大缓存 100 个
            .expireAfterWrite(30, TimeUnit.SECONDS)       // 设置缓存过期时间为30S
            .build();

    @Pointcut("@annotation(com.example.springboot.annotation.RepeatSubmitValidate)")    //根据自定义注解，定义切点
    public final void poinCut() {
    }

    @Around(value = "poinCut()")
    public final Object validRepeatSubmit(final ProceedingJoinPoint joinPoint) throws Throwable {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();       //获取request

        Object args = joinPoint.getArgs()[0];      //获取第一个方法参数，本例采用json格式封装对象，所以只有一个。实际开发参数可能多个采用循环遍历，只做演示

        String key = cacheKeyGenerator(request);    //生成key

        if (!StringUtils.isEmpty(key)) {

            if (CACHES.getIfPresent(key) != null) {            //存在key则返回，表示重复提交

                String value = CACHES.get(key, () -> "");

                if (args.toString().equals(value)) {

                    log.info("---请勿重复提交---");

                    return  ResponseResult.builder().code(400).message("fail").data("30S内请勿重复提交").build();
                }

            }

            CACHES.put(key, args.toString());         //不存在将key 和value存入缓存 【key表示requestURL,value表示提交的数据】
        }

        return joinPoint.proceed();
    }

    /**
     * @return java.lang.String
     * @Description 单服务器创建cachekey策略，仅采用简单的requestURL，多服务器可采用跨域解决方案判断是否为同一用户提交
     * @Param [request]
     * @Author yc
     * @Date 2019-05-16 01:11
     * @version 1.0
     */

    private final String cacheKeyGenerator(final HttpServletRequest request) {


        String url = request.getRequestURL().toString();

        return url;
    }

}