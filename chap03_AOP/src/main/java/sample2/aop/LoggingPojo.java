package sample2.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class LoggingPojo {
	
	public Object logAround(ProceedingJoinPoint pjp) throws Throwable{
		String methodName = pjp.getKind();
		StopWatch sw = new StopWatch();
		
		sw.start(methodName);
		
		System.out.println("[LOG] METHOD : " + methodName + "is calling.");
		Object rtnObject = pjp.proceed();
		
		sw.stop();
		
		System.out.println("[LOG] METHOD : " + methodName + "was called.");
		System.out.println("[LOG] 처리시간: "+sw.getTotalTimeMillis()/1000+"초");
		
		return rtnObject;
	}
}
