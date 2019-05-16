package com.example.springboot.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yc
 * @version 1.0
 * @project springboot
 * @description TODO
 * @date 2019-04-25 21:18
 */
@Component
@Slf4j
public class SchedulerTask {

   @Scheduled(cron = "0/20 * * * * *")     //通过cron表达式设置调度任务
    public void task1() throws InterruptedException {
        Thread.sleep(15000);
       log.info("thread name---"+Thread.currentThread().getName());
        log.info("SchedulerTask task 1 执行时间："+new SimpleDateFormat("yyyy:MM:dd hh:mm:ss").format(new Date())+" 睡眠15S");
    }

   @Scheduled(fixedDelay = 5000,initialDelay = 2000)    //fixedDelay：通过固定时间设置调度任务 initialDelay：表示第一次延迟2s再执行调度任务
    public void task2(){

        log.info("thread name---"+Thread.currentThread().getName());
        log.info("SchedulerTask task 2 执行时间："+new SimpleDateFormat("yyyy:MM:dd hh:mm:ss").format(new Date()));

    }

    @Scheduled(fixedRate = 3000)           //fixedRate：通过固定频率实现调度任务
    public  void  task3(){

        log.info("thread name---"+Thread.currentThread().getName());
        log.info("SchedulerTask task 2 执行时间："+new SimpleDateFormat("yyyy:MM:dd hh:mm:ss").format(new Date()));
    }
}
