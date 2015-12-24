package sample1.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class LoggingAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		// TODO Auto-generated method stub
		String methodName = arg0.getMethod().getName();
		StopWatch sw = new StopWatch();
		
		sw.start(methodName);
		
		System.out.println("[LOG] METHOD : " + methodName + "is calling.");
		Object rtnObject = arg0.proceed();
		
		sw.stop();
		
		System.out.println("[LOG] METHOD : " + methodName + "was called.");
		System.out.println("[LOG] 처리시간: "+sw.getTotalTimeMillis()/1000+"초");
		
		return rtnObject;
	}

}
