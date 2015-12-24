package sample4.annotation;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

public class MessageBeanImpl implements MessageBean {
	private String name;
	private String greeting;
	
	@Autowired
	private Outputter outputter;
	
	public MessageBeanImpl(String name){
		this.name = name;
	}
	
	public void setGreeting(String greeting){
		this.greeting = greeting;
	}
	
	
	/*public void setOutputter(Outputter outputter){
		this.outputter = outputter;
	}*/


	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		String msg = greeting + name + "!";
		System.out.println(msg);
		
		//Outputter out = new FileOutputter(msg);
		try {
			outputter.output(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}




