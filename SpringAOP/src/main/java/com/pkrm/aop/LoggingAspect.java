package com.pkrm.aop;


import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

	private static final Logger logger = Logger.getLogger(LoggingAspect.class);

	@Before("execution(* com.pkrm.dao.EmployeeImplUsingJdbcTemplate.*(. .))")
	public void getAllAdvice() {
		logger.info("Dao method before called");
	}

	@After("execution(* com.pkrm.dao.EmployeeImplUsingJdbcTemplate.*(. .))")
	public void getAllAdvice1() {
		logger.info("Dao method after called");
	}

}
