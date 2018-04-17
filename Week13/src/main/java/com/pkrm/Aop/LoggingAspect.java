package com.pkrm.Aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.pkrm.personPojo.JsonToJavaPojo;

@Aspect
public class LoggingAspect {

	private static final Logger logger = Logger.getLogger(LoggingAspect.class);
	private static final Logger toFile = Logger.getLogger("Logger");

	@Before("execution(* com.pkrm.Dao.PersonDaoImpl.*(. .))")
	public void beforeAdvice(JoinPoint joinPoint) {
		logger.info("Execution of Dao method started");
		toFile.info("Execution of Dao method started");
		Object[] object=joinPoint.getArgs();
		if(object[0] instanceof JsonToJavaPojo) {
			toFile.info("parameters passed are"+object[0].toString());
		}
		logger.info("parameters passed are"+object[0].toString());
	}

	@After("execution(* com.pkrm.Dao.PersonDaoImpl.*(. .))")
	public void afterAdvice(JoinPoint joinPoint) {
		logger.info("Dao method executed");
		toFile.info("Dao method executed");
	}
	

}
