package com.pkrm.clientservice;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Service {
	private static org.apache.log4j.Logger logger = Logger.getLogger(Service.class);
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"listenercontext.xml");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		   logger.error(e.getMessage());
		
		}
		context.close();

	}


}
