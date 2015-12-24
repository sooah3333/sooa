package sample1.aop;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import sample1.aop.MessageBean;

public class HelloApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext factory =
				new FileSystemXmlApplicationContext("aop1.xml");
	
	MessageBean bean = factory.getBean("proxy", MessageBean.class);
	bean.sayHello("안녕하세요, ");
	}
}
