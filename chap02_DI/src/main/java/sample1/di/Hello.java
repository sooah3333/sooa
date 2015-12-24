package sample1.di;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XmlBeanFactory factory 
						= new XmlBeanFactory(new FileSystemResource("di.xml"));
		MessageBean bean = (MessageBean)factory.getBean("messageBean");
		//MessageBean bean = factory.getBean("messageBean", MessageBean.class);
		bean.sayHello();
	}
}
