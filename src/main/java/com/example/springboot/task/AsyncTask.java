package com.example.springboot.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;


/**
 * @author yc
 * @version 1.0
 * @project springboot
 * @description TODO
 * @date 2019-04-26 00:03
 */
@Slf4j
@Component
public class AsyncTask {

    @Async
    public Future<String> task1() throws InterruptedException {

        log.info("--异步线程task1开始执行任务--" + System.currentTimeMillis());
        Thread.sleep(8000);         //线程睡眠模拟执行任务需要消耗的时间，比如查询数据库，做其他的任务
        log.info("--异步线程task1任务执行完成--" + System.currentTimeMillis());
        return new AsyncResult("welcome");
    }

    @Async
    public Future<String> task2() throws InterruptedException {

        log.info("--异步线程task2开始执行任务--" + System.currentTimeMillis());
        Thread.sleep(10000);      //线程睡眠模拟执行任务需要消耗的时间，比如查询数据库，做其他的任务
        log.info("--异步线程task2任务执行完成--" + System.currentTimeMillis());
        return new AsyncResult("，hello");
    }
}
