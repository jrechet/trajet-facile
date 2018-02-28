package com.poe.trajetfacile.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ChronoAspect {

	private static final Logger LOG = LoggerFactory.getLogger(ChronoAspect.class);


	@Around("@annotation(Chrono)")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.currentTimeMillis();
		Object proceed = joinPoint.proceed();
		long executionTime = System.currentTimeMillis() - start;
		LOG.info(joinPoint.getSignature() + " executed in " + executionTime + "ms");
		return proceed;
	}
}
