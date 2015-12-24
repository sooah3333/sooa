package sample2.aop;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext factory
				= new FileSystemXmlApplicationContext("aop2.xml");
		
		MessageBean bean = factory.getBean("targetBean", MessageBean.class);
		bean.sayHello("Hello, ");
		
		factory.close();
	}
}








