package sample3.applicationcontext;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext factory =
				new FileSystemXmlApplicationContext("applicationcontext.xml");
		
		factory.getBean("messageBean");
		
		factory.close();
	}
}
