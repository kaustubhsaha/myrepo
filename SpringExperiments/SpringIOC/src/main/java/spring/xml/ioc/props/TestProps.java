package spring.xml.ioc.props;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestProps {

	public static void main(String[] args) {
		ApplicationContext container = new ClassPathXmlApplicationContext("TestProps.xml");
		Foo f = container.getBean(Foo.class);
		System.out.println(f);
	}
}
class Foo {
	
	private String message;
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return message;
	}
}
