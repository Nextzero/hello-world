package nextzero.example.quartz;

import org.quartz.*;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.quartz.impl.triggers.SimpleTriggerImpl;

import java.text.ParseException;
import java.util.Date;

public class TestMain {

    public static void main(String[] args) throws SchedulerException, ParseException {
        //1. 创建调度器实例
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();

        //2. 创建任务描述信息
        JobDetailImpl jobDetail = new JobDetailImpl();
        jobDetail.setName("helloQuartz");
        jobDetail.setGroup(Scheduler.DEFAULT_GROUP);
        jobDetail.setJobClass(HelloWorldJob.class);

        //3. 创建任务触发器
        String cronExpression = "30 * * * * ?"; // 每分钟的30s起，每5s触发任务
        CronTriggerImpl cronTrigger = new CronTriggerImpl();
        cronTrigger.setName("cronTrigger");
        cronTrigger.setGroup(Scheduler.DEFAULT_GROUP);
        cronTrigger.setCronExpression(cronExpression);

        //4. 关联调度
        scheduler.scheduleJob(jobDetail, cronTrigger);

        //5. 启动
        scheduler.start();
    }
}
