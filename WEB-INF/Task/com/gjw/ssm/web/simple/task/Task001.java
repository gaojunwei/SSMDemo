package com.gjw.ssm.web.simple.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * 功能描述：定时任务A
 * @author gjw
 */
@Component("taskA")
public class Task001 {
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	private static Logger logger = Logger.getLogger(Task001.class);
	
	public void task001() {
		logger.info("执行定时认为task001" + dateFormat.format(new Date()));
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
