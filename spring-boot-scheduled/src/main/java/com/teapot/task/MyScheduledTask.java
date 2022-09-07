package com.teapot.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyScheduledTask {

    /**
     * 定时任务方法
     */
    @Scheduled(cron = "0/2 * * * * ?")
    public void doSome() {
        System.out.println("定时任务执行了...." + new Date());
    }
}
