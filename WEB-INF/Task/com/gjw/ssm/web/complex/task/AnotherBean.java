package com.gjw.ssm.web.complex.task;

import org.springframework.stereotype.Component;

@Component("anotherBean")
public class AnotherBean {
    public void printAnotherMessage(){
        System.out.println("I am AnotherBean. I am called by Quartz jobBean using CronTriggerFactoryBean");
    }
}