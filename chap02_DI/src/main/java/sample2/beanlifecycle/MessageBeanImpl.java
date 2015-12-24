package sample2.beanlifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class MessageBeanImpl 
				implements MessageBean, BeanNameAware, BeanFactoryAware,
									InitializingBean, DisposableBean{
	private String name;
	private String greeting;
	private String beanName;
	private BeanFactory beanFactory;
	
	public MessageBeanImpl(String name){
		this.name = name;
		System.out.println("(1) Bean의 생성자 호출.");
	}
	
	public void setGreeting(String greeting){
		this.greeting = greeting;
		System.out.println("(2) 세터메서드 호출.");
	}
	
	
	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		String message = greeting + name + "!";
		System.out.println(message);
	}

	@Override
	public void setBeanName(String arg0) {
		// TODO Auto-generated method stub
		beanName = arg0;
		System.out.println("(3) Bean명 지정 : " + beanName);
	}

	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		// TODO Auto-generated method stub
		beanFactory = arg0;
		System.out.println("(4) BeanFactory 지정 : " + beanFactory.getClass());
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("(6)프로퍼티 지정 완료.");
	}
	
	public void init(){
		System.out.println("(7)초기화 메서드 실행.");
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		
	}
}





