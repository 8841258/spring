package co.pooh.app.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.java.Log;

@Log
@Component
//@Aspect
public class LogAdvice {
	
	@Pointcut("execution(* co.pooh.app..*ServiceImpl.*(..) )")
	public void allPointcut() {}
	
	@Before("allPointcut()")
	public void logBefore(JoinPoint jp) {
		log.info("[before=========================================]");
		String methodName = jp.getSignature().getName();
		Object[] arg = jp.getArgs();
		
		String str = "methodName = " + methodName + " : arg = " + (arg != null && arg.length > 0 ? arg[0] : ""); 

		log.info(str);
	}
	
	@AfterReturning(pointcut = "allPointcut()", returning = "obj")
	public void logAfter(JoinPoint jp, Object obj) {
		log.info("[After=========================================]");
		String methodName = jp.getSignature().getName();
		String str = methodName + "return = " + (obj != null ? obj : "");
		log.info(str);
	}
}
