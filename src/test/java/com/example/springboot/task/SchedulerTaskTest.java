package com.example.springboot.task;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@EnableScheduling
@Slf4j

public class SchedulerTaskTest {
    @Autowired
    private SchedulerTask schedulerTask;

    @Test
    public void main() throws InterruptedException {

        schedulerTask.task1();
        schedulerTask.task2();
        schedulerTask.task3();
    }

}