package com.bigdata2017.mysite.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class MeasureExecutionTimeAspect {
	@Around("execution(* *..repository.*.*(..)) || execution(* *..service.*.*(..)) || execution(* *..controller.*.*(..))")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		//before advice code
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		Object result = pjp.proceed();
		
		//after advice code
		stopWatch.stop();
		Long totalTime = stopWatch.getTotalTimeMillis();
		
		String className = pjp.getTarget().getClass().getName();
		String methodName = pjp.getSignature().getName();
		String taskName = className + "." + methodName;
		System.out.println("[ExecutionTime]" + "[" + taskName + "]" + totalTime + "mills");
		
		return result;
	}
}
