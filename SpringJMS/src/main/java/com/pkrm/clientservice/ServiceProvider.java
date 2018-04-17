package com.pkrm.clientservice;

import org.apache.log4j.Logger;

public class ServiceProvider {
	private static org.apache.log4j.Logger logger = Logger.getLogger(ServiceProvider.class);
	public String process(String message) {

		logger.info("Service Provider" + message);
	
		return "Successfully Processed " + message;

	}

}
