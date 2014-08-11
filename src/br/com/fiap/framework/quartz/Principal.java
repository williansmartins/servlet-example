package br.com.fiap.framework.quartz;
 
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class Principal {
	public static void main(String[] args) throws Exception{
 
		JobDetail job = JobBuilder.newJob(MeuJob.class)
			.withIdentity("dummyJobName", "group1").build();
 
		// Trigger the job to run on the next round minute
		Trigger trigger = TriggerBuilder
			.newTrigger()
			.withIdentity("dummyTriggerName", "group1")
			.withSchedule(
				SimpleScheduleBuilder.simpleSchedule()
					.withIntervalInSeconds(5).repeatForever())
			.build();
 
		// schedule it
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.start();
		scheduler.scheduleJob(job, trigger);
 
	}
}