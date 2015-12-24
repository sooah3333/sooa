package sample4.annotation;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class HelloApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//MessageBean bean = new MessageBeanImpl("홍길동");
		/*BeanFactory factory 
				= new XmlBeanFactory(new FileSystemResource("annotation.xml"));*/
		
		AbstractApplicationContext factory =
					new FileSystemXmlApplicationContext("annotation.xml");
		
		MessageBean bean = factory.getBean("msgBean", MessageBean.class);
		bean.sayHello();
	}
}






