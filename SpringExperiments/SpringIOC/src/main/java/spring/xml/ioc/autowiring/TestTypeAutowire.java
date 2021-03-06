package spring.xml.ioc.autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestTypeAutowire {
	public static void main(String[] args) {
		ApplicationContext container = new ClassPathXmlApplicationContext("AutowireByType.xml");
		Baz baz = container.getBean(Baz.class);
		// should not be null
		System.out.println(baz.bar);
	}
}
class Baz{
	
	Bar bar;
	
	public void setBar(Bar bar) {
		this.bar = bar;
	}
}