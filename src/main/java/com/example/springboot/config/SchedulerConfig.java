package com.example.springboot.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.util.ErrorHandler;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author yc
 * @version 1.0
 * @project springboot
 * @description TODO
 * @date 2019-04-26 19:14
 */

@Configuration
@Slf4j
public class SchedulerConfig {

    /**
      * @Description  注册调度任务线程池，spring scheduler默认是单线程
      * @Param []
      * @return org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler
      * @Author yc
      * @Date 2019-05-16 02:01
      * @version 1.0
      */


    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {

        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(3);         //核心线程数为3
        scheduler.setThreadNamePrefix("scheduler-");
        scheduler.setErrorHandler((throwable)-> {log.error("------scheduler appear exception----");throwable.printStackTrace();});   //简单处理调度任务异常
        scheduler.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());        //设置线程池拒绝策略
        scheduler.setAwaitTerminationSeconds(10);                     //设置等待时间
        scheduler.setWaitForTasksToCompleteOnShutdown(true);         //设置是否等待线程执行完毕再关闭

        return scheduler;
    }

}
