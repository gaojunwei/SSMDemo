package com.gjw.ssm.web.complex.task;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class ComplexJob extends QuartzJobBean {  
    
    private AnotherBean anotherBean;  
  
    @Override
    protected void executeInternal(JobExecutionContext arg0)
            throws JobExecutionException {  
        System.out.println("I am FirstScheduledJob");  
        this.anotherBean.printAnotherMessage();  
  
    }  
  
    public void setAnotherBean(AnotherBean anotherBean) {  
        this.anotherBean = anotherBean;  
    }  
}