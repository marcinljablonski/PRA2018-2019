package pesel;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;


public class Application {
    private static void run(){
        CLI cli;
        List<Person> people;
        people = new ArrayList<>();
        cli = new CLI(people);
//        cli.run();
        try {
            SchedulerFactory sf = new StdSchedulerFactory();
            Scheduler sched = sf.getScheduler();
            JobDetail job = newJob(SaveToFile.class)
            .withIdentity("job1", "group1")
            .build();
            sched.getContext().put("people", people);

            Trigger trigger = newTrigger()
            .withIdentity("trigger1", "group1")
            .withSchedule(cronSchedule("30 0/1 * * * ? "))
            .build();

            JobDetail job2 = newJob(TimeLeft.class)
                    .withIdentity("job2", "group2")
                    .build();

            Trigger trigger2 = newTrigger()
                    .withIdentity("trigger2", "group2")
                    .withSchedule(cronSchedule("0 0/1 * * * ? "))
                    .build();

            sched.scheduleJob(job, trigger);
            sched.scheduleJob(job2, trigger2);
            sched.start();

        } catch (SchedulerException se) {
            se.printStackTrace();
        }
        cli.run();
    }


    public static void main(String ... args) {
        try {
            FileIO.truncate();
        } catch (IOException e) {
            e.printStackTrace();
        }
        run();
    }
}
