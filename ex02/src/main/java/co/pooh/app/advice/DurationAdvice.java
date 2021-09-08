package co.pooh.app.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.java.Log;

@Log
@Component
//@Aspect
public class DurationAdvice {

	//실행 전, 후 모두 호출.
	@Around("LogAdvice.allPointcut()")
	public Object logTime(ProceedingJoinPoint pjp) {
		Object result = null;
		
		long start = System.currentTimeMillis();
		
		try {
			result = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		
		log.info("경과 시간 : " + (end - start));
		
		return result;
	}
	
}
