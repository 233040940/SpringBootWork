package com.example.springboot.task;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@EnableAsync
@Slf4j
public class AsyncTaskTest {

    @Autowired
    private AsyncTask task;

    /**
      * @Description  注意观察任务的执行时间，以及task睡眠的时间总和。task1 睡眠8s task2 睡眠10s,需要 传统单线程需要18S才能执行完毕，而采用异步线程则仅仅只需要10s就执行完毕
      * 应用场景：比如涉及到对excel的导入导出，采用异步任务是非常好的选择。
      *notice：spring 默认线程池是单线程，本例是自定义ThreadPoolTaskScheduler线程池采用3个核心线程数,与scheduler共用一个线程池，具体配置参见com.example.springboot.config.SchedulerConfig.java。
      * 也可详见spring 源码TaskExecutor 各自定义线程池
      * @Param []
      * @return void
      * @Author yc
      * @Date 2019-05-16 04:14
      * @version 1.0
      */

    @Test
    public void main() throws InterruptedException, ExecutionException {

        long start = System.currentTimeMillis();
        Future<String> future = task.task1();
        Future<String> future2 = task.task2();

        while(true) {
            if (future.isDone() && future2.isDone()) {

                log.info("两个任务成功执行完毕，并返回"+future.get()+future2.get());
                break;
            }
            Thread.sleep(1000);     //如果两个任务其中一个还未执行完，则睡眠一秒，直到两个任务执行完毕成功返回

        }

        log.info("--异步任务执行总耗时--" + Long.toString(System.currentTimeMillis() - start)+"ms");

    }

}