package nextzero.example.quartz;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.SimpleTriggerImpl;

import java.util.Date;

/**
 Job接口包含唯一方法execute()，将任务逻辑添加到该方法中。
 StdSchedulerFactory.getScheduler()返回一个可运行的实例，然后创建调度任务的JobDetail实例，并传递3个参数给构造方法。
 第一个参数是任务名，用于引用该任务。
 第二个参数是任务组名，这里使用默认名，任务组名用于引用集合起来的一组任务，如可以使用Scheduler.pauseJobGroup()来暂停一组任务，每个组中的任务名是唯一的。
 第三个参数是实现特定任务的类。
 创建JobDetail实例后，需要创建一个Trigger，这里使用的是SimpleTrigger类，它提供了JDK Timer风格的触发器行为。
 传递给SimpleTrigger构造方法的两个参数分别是触发器名和任务组名，触发器名在它所在的任务组中必须是唯一的。
 接下来是设置触发器的一些属性，setStartTime()是设置启动时间，setRepeatInterval()是设置重复间隔，setRepeatCount()是设置重复次数。
 最后，scheduler.start()启动调度，终止调度可以用stop()方法。
 */
public class TestMain {

    public static void main(String[] args) throws SchedulerException {
        //1. 创建调度器实例
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();

        //2. 创建任务描述信息
        JobDetailImpl jobDetail = new JobDetailImpl();
        jobDetail.setName("helloQuartz");
        jobDetail.setGroup(Scheduler.DEFAULT_GROUP);
        jobDetail.setJobClass(HelloWorldJob.class);

        //3. 创建任务触发器
        SimpleTriggerImpl simpleTrigger = new SimpleTriggerImpl();
        simpleTrigger.setName("simpleTrigger");
        simpleTrigger.setGroup(Scheduler.DEFAULT_GROUP);
        simpleTrigger.setStartTime(new Date(System.currentTimeMillis()));
        simpleTrigger.setRepeatInterval(5000);
        simpleTrigger.setRepeatCount(10);

        //4. 关联调度
        scheduler.scheduleJob(jobDetail, simpleTrigger);

        //5. 启动
        scheduler.start();
    }
}
