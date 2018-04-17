package com.pkrm.profilingAspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import com.pkrm.aop.LoggingAspect;

@Aspect
public class ProfilingAspect {
	private static Logger logger = Logger.getLogger(ProfilingAspect.class);

	@Around("execution(* com.pkrm.dao.EmployeeImplUsingJdbcTemplate.*(..))")
	public void profile(ProceedingJoinPoint pjp) throws Throwable {
		long startTime = System.currentTimeMillis();
		long beforeMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		logger.info("Going to call the method.");
		pjp.proceed();
		logger.info("Method execution completed.");
		long endTime = System.currentTimeMillis();
		long afterMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		long elapsedTime = (endTime - startTime);
		long totalMemory = afterMemory - beforeMemory;
		logger.info("Method execution time: " + elapsedTime + " milliseconds.");
		logger.info("Memory :" + totalMemory);

	}
}