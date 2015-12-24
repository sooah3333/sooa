package sample1.aop;

public class MessageBeanImpl implements MessageBean {
	
	private String name;
	
	public void setName(String name){
		this.name = name;
	}
	
	@Override
	public void sayHello(String msg) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(msg+name+"!");
	}
}
