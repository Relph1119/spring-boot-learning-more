package com.teapot.job;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class JobMain {
    public static void main(String[] args) throws SchedulerException {
        // 1. 创建Job对象
        JobDetail job = JobBuilder.newJob(MyJob.class).build();

        // 2. 创建Trigger对象
        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?"))
                .build();

        // 3. 创建Scheduler对象
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.scheduleJob(job, trigger);

        // 4. 启动
        scheduler.start();
    }
}
