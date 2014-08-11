package br.com.fiap.framework.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MeuJob implements Job
{
    public void execute( JobExecutionContext context ) throws JobExecutionException
    {
	System.out.println( "Hello Quartz!" );
    }

}