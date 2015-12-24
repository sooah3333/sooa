package sample2.beanlifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XmlBeanFactory factory 
		= new XmlBeanFactory(new FileSystemResource("beanlifecycle.xml"));
		factory.addBeanPostProcessor(new CustomBeanPostProcessor());
		MessageBean bean = factory.getBean("messageBean", MessageBean.class);
		bean.sayHello();
	}

}
