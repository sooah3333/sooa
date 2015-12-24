package sample03;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*BeanFactory factory =
						new XmlBeanFactory(
								new FileSystemResource("beans.xml"));*/
		/*BeanFactory factory =
				new XmlBeanFactory(
						new ClassPathResource("beans.xml"));*/
		
		AbstractApplicationContext factory =
											new FileSystemXmlApplicationContext("/src/main/java/sample03/beans.xml");
		
		Message bean = factory.getBean("msg", Message.class);
		bean.sayHello("홍길동");
		
		Message alias = factory.getBean("k1", Message.class);
		bean.sayHello("강호동");
	}
}
