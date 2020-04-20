package com.ws.aspect;

import lombok.extern.log4j.Log4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Log4j
@Service
@Aspect
public class TimeAspect {
	@Pointcut("bean(userServiceImpl)")
	public void doTime(){}

	@Around("doTime()")
	public Object doAround(ProceedingJoinPoint jp)
			throws Throwable{
		long start = System.currentTimeMillis();
		Object obj=jp.proceed();
		long end = System.currentTimeMillis();
		log.info("spend time: " + (end-start) + "ms");
		return obj;
	}
}
